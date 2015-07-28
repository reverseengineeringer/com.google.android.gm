package com.google.android.gm.provider;

import android.content.ContentQueryMap;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.text.TextUtils;
import com.google.android.gm.utils.CustomFromUtils;
import com.google.android.gm.utils.LabelColorUtils;
import com.google.android.gm.utils.OutgoingMsgPrefs;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class MailCore
  implements MailCoreLabelAccess
{
  private static final Set<String> FORCED_INCLUDED_OR_PARTIAL_LABELS = Sets.newHashSet(new String[] { "^f" });
  private static final Set<String> FORCED_SYNCED_LABELS;
  private static final Set<String> FORCED_UNSYNCED_LABELS = Sets.newHashSet(new String[] { "^all", "^b", "^s", "^k" });
  private static Set<String> NO_COUNT_LABELS;
  private static Set<String> TOTAL_COUNT_LABELS;
  private static Map<String, Integer> sDefaultSystemLabelOrder = null;
  private final Map<String, Label> mCanonicalNameToLabel = Maps.newHashMap();
  private final ConversationUtil mConversationHelper;
  private final SQLiteDatabase mDb;
  private final Map<Long, Label> mIdToLabel = Maps.newHashMap();
  Map<Long, Boolean> mLabelIdsIncludedOrPartial;
  final Gmail.LabelMap mLabelMap;
  final Listener mListener;
  private long mNextLocalLabelId = 0L;
  private long mNextServerLabelId = 0L;
  Collection<NotificationRequest> mNotificationRequests;
  private final Operations mOperations;
  long mServerVersion;
  private final Map<String, String> mUserGmailPrefs = new ConcurrentHashMap();
  
  static
  {
    TOTAL_COUNT_LABELS = Sets.newHashSet(new String[] { "^r", "^^out", "^s" });
    NO_COUNT_LABELS = Sets.newHashSet(new String[] { "^f", "^t", "^b", "^all", "^k", "^io_im" });
    FORCED_SYNCED_LABELS = Sets.newHashSet(new String[] { "^^out", "^r" });
  }
  
  public MailCore(Context paramContext, SQLiteDatabase paramSQLiteDatabase, Operations paramOperations, Listener paramListener)
  {
    mDb = paramSQLiteDatabase;
    mOperations = paramOperations;
    mNotificationRequests = null;
    mListener = paramListener;
    loadGmailPreferences();
    paramSQLiteDatabase = mDb.query("labels", new String[] { "_id", "canonicalName", "name", "numConversations", "numUnreadConversations", "color" }, null, null, null, null, null);
    mLabelMap = new Gmail.LabelMap(paramContext.getContentResolver(), paramSQLiteDatabase, false);
    mConversationHelper = new ConversationUtil(mDb, this);
  }
  
  private void addLabel(long paramLong)
  {
    if (!mDb.inTransaction()) {
      throw new IllegalStateException("Must be in transaction");
    }
    if (mNextServerLabelId == 0L) {
      throw new IllegalStateException("onLabelsChanged not yet called");
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("canonicalName", "");
    localContentValues.put("name", "");
    localContentValues.put("numConversations", Integer.valueOf(0));
    localContentValues.put("numUnreadConversations", Integer.valueOf(0));
    localContentValues.put("color", Integer.valueOf(Integer.MAX_VALUE));
    localContentValues.put("visibility", "SHOW");
    localContentValues.put("_id", Long.valueOf(paramLong));
    mDb.replace("labels", null, localContentValues);
  }
  
  private void addLabel(String paramString)
  {
    if (!mDb.inTransaction()) {
      throw new IllegalStateException("Must be in transaction");
    }
    if (mNextServerLabelId == 0L) {
      throw new IllegalStateException("onLabelsChanged not yet called");
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("canonicalName", paramString);
    localContentValues.put("name", "");
    localContentValues.put("numConversations", Integer.valueOf(0));
    localContentValues.put("numUnreadConversations", Integer.valueOf(0));
    localContentValues.put("color", Integer.valueOf(Integer.MAX_VALUE));
    localContentValues.put("visibility", "SHOW");
    adjustContentValuesForSystemLabel(paramString, localContentValues);
    long l;
    Long localLong;
    if (isCanonicalLabelNameLocal(paramString))
    {
      l = mNextLocalLabelId;
      mNextLocalLabelId = (l - 1L);
      localLong = Long.valueOf(l);
    }
    for (;;)
    {
      localContentValues.put("_id", localLong);
      if (mDb.replace("labels", null, localContentValues) != -1L) {
        break;
      }
      throw new IllegalStateException("Failed to insert row for label: " + paramString);
      if (Gmail.PRIORITY_MARKERS.contains(paramString))
      {
        localLong = (Long)Gmail.LOCAL_PRIORITY_LABELS.inverse().get(paramString);
      }
      else
      {
        l = mNextServerLabelId;
        mNextServerLabelId = (l + 1L);
        localLong = Long.valueOf(l);
      }
    }
  }
  
  private void adjustContentValuesForSystemLabel(String paramString, ContentValues paramContentValues)
  {
    boolean bool2 = false;
    boolean bool1 = paramString.startsWith("^");
    int i;
    if (bool1)
    {
      i = 1;
      paramContentValues.put("systemLabel", Integer.valueOf(i));
      initSystemLabelMap();
      if (sDefaultSystemLabelOrder.containsKey(paramString)) {
        paramContentValues.put("systemLabelOrder", (Integer)sDefaultSystemLabelOrder.get(paramString));
      }
      if (bool1) {
        if (LabelManager.getSortedUserMeaningfulSystemLabels().contains(paramString)) {
          break label263;
        }
      }
    }
    label263:
    for (bool1 = true;; bool1 = false)
    {
      paramContentValues.put("hidden", Boolean.valueOf(bool1));
      if ((paramString.equals("^io_im")) || (paramString.equals("^iim")))
      {
        bool1 = bool2;
        if (!getInfoOverloadEnabled()) {
          bool1 = true;
        }
        paramContentValues.put("hidden", Boolean.valueOf(bool1));
      }
      if (NO_COUNT_LABELS.contains(paramString)) {
        paramContentValues.put("labelCountDisplayBehavior", Integer.valueOf(2));
      }
      if (TOTAL_COUNT_LABELS.contains(paramString)) {
        paramContentValues.put("labelCountDisplayBehavior", Integer.valueOf(1));
      }
      if (FORCED_SYNCED_LABELS.contains(paramString)) {
        paramContentValues.put("labelSyncPolicy", Integer.valueOf(1));
      }
      if (FORCED_UNSYNCED_LABELS.contains(paramString)) {
        paramContentValues.put("labelSyncPolicy", Integer.valueOf(2));
      }
      if (FORCED_INCLUDED_OR_PARTIAL_LABELS.contains(paramString)) {
        paramContentValues.put("labelSyncPolicy", Integer.valueOf(3));
      }
      return;
      i = 0;
      break;
    }
  }
  
  static void changeLabelId(SQLiteDatabase paramSQLiteDatabase, long paramLong1, long paramLong2)
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = Long.toString(paramLong2);
    arrayOfString[1] = Long.toString(paramLong1);
    paramSQLiteDatabase.execSQL("UPDATE labels SET _id = ? WHERE _id = ?", arrayOfString);
    paramSQLiteDatabase.execSQL("UPDATE message_labels SET labels_id = ? WHERE labels_id = ?", arrayOfString);
    paramSQLiteDatabase.execSQL("UPDATE conversation_labels SET labels_id = ? WHERE labels_id = ?", arrayOfString);
    Operations.updateLabelId(paramSQLiteDatabase, paramLong1, paramLong2);
    paramSQLiteDatabase.execSQL("UPDATE conversations SET labelIds = REPLACE(labelIds, '," + paramLong1 + ",', '," + paramLong2 + ",')");
  }
  
  public static void correctLocalLabelIds(SQLiteDatabase paramSQLiteDatabase)
  {
    Cursor localCursor = paramSQLiteDatabase.query("labels", new String[] { "_id", "canonicalName" }, null, null, null, null, null);
    long l1 = -1L;
    try
    {
      long l2;
      while (localCursor.moveToNext())
      {
        l2 = localCursor.getLong(0);
        if (isLabelIdLocal(l2)) {
          l1 = Math.min(l1, l2);
        }
      }
      localCursor.moveToPosition(-1);
      while (localCursor.moveToNext())
      {
        l2 = localCursor.getLong(0);
        if ((isCanonicalLabelNameLocal(localCursor.getString(1))) && (!isLabelIdLocal(l2)))
        {
          l1 -= 1L;
          changeLabelId(paramSQLiteDatabase, l2, l1);
        }
      }
    }
    finally
    {
      localCursor.close();
    }
  }
  
  private void initSystemLabelMap()
  {
    if (sDefaultSystemLabelOrder == null)
    {
      sDefaultSystemLabelOrder = Maps.newHashMap();
      sDefaultSystemLabelOrder.put("^i", Integer.valueOf(1));
      sDefaultSystemLabelOrder.put("^iim", Integer.valueOf(2));
      sDefaultSystemLabelOrder.put("^t", Integer.valueOf(3));
      sDefaultSystemLabelOrder.put("^io_im", Integer.valueOf(4));
      sDefaultSystemLabelOrder.put("^b", Integer.valueOf(5));
      sDefaultSystemLabelOrder.put("^f", Integer.valueOf(6));
      sDefaultSystemLabelOrder.put("^^out", Integer.valueOf(7));
      sDefaultSystemLabelOrder.put("^r", Integer.valueOf(8));
      sDefaultSystemLabelOrder.put("^all", Integer.valueOf(9));
      sDefaultSystemLabelOrder.put("^s", Integer.valueOf(10));
      sDefaultSystemLabelOrder.put("^k", Integer.valueOf(11));
    }
  }
  
  public static boolean isCanonicalLabelNameLocal(String paramString)
  {
    return (paramString != null) && (paramString.startsWith("^^"));
  }
  
  public static boolean isLabelIdLocal(long paramLong)
  {
    return (paramLong < -1L) && (paramLong >= -1000L);
  }
  
  private void loadGmailPreferences()
  {
    Cursor localCursor = mDb.query("info_overload", new String[] { "enabled_pref" }, null, null, null, null, null);
    if (localCursor != null)
    {
      if (localCursor.moveToNext()) {
        mUserGmailPrefs.put("sx_ioe", localCursor.getString(0));
      }
      localCursor.close();
    }
    localCursor = mDb.query("server_preferences", new String[] { "value" }, "name = ?", new String[] { "bx_ioao" }, null, null, null);
    if (localCursor != null)
    {
      if (localCursor.moveToNext()) {
        mUserGmailPrefs.put("bx_ioao", localCursor.getString(0));
      }
      localCursor.close();
    }
  }
  
  private void setLabelOnConversation(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean, Operations.RecordHistory paramRecordHistory)
  {
    setLabelOnConversation(paramLong1, paramLong2, paramLong3, paramBoolean, paramRecordHistory, true);
  }
  
  private void setLabelOnConversation(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean1, Operations.RecordHistory paramRecordHistory, boolean paramBoolean2)
  {
    long l1 = mLabelMap.getLabelIdUnread();
    long l2 = mLabelMap.getLabelIdStarred();
    if (paramBoolean1)
    {
      if (l1 == paramLong3)
      {
        str1 = "UPDATE conversations SET labelIds = ? || REPLACE(labelIds, ?, ?), forceAllUnread = 1 WHERE queryId != 0 AND _id = ?";
        mDb.execSQL(str1, new String[] { "," + paramLong3, "," + paramLong3 + ",", ",", Long.toString(paramLong1) });
        if (l2 != paramLong3) {
          break label149;
        }
        if (paramBoolean2) {
          setLabelOnMessage(paramLong2, paramLong3, true, paramRecordHistory, false);
        }
      }
      label149:
      do
      {
        return;
        str1 = "UPDATE conversations SET labelIds = ? || REPLACE(labelIds, ?, ?) WHERE queryId != 0 AND _id = ?";
        break;
        str1 = Long.toString(paramLong1);
        String str2 = Long.toString(paramLong3);
        String str3 = Long.toString(paramLong2);
        mDb.execSQL("INSERT or REPLACE INTO message_labels (message_messageId, labels_id, message_conversation) SELECT messageId, ?, ? FROM messages WHERE conversation = ? AND messageId <= ?", new String[] { str2, str1, str1, str3 });
        if (paramRecordHistory == Operations.RecordHistory.TRUE) {
          mOperations.recordOperationWithLabelId(paramLong1, paramLong2, "conversationLabelAdded", paramLong3);
        }
        if (mLabelMap.getLabelIdInbox() == paramLong3)
        {
          setLabelOnConversation(paramLong1, paramLong2, mLabelMap.getLabelIdIgnored(), false, paramRecordHistory);
          return;
        }
      } while (mLabelMap.getLabelIdIgnored() != paramLong3);
      setLabelOnConversation(paramLong1, paramLong2, mLabelMap.getLabelIdInbox(), false, paramRecordHistory);
      return;
    }
    String str1 = Long.toString(paramLong1);
    mDb.delete("message_labels", "labels_id = ? AND message_labels.message_conversation = ? AND message_labels.message_messageId <= ?", new String[] { Long.toString(paramLong3), str1, Long.toString(paramLong2) });
    if (paramRecordHistory == Operations.RecordHistory.TRUE) {
      mOperations.recordOperationWithLabelId(paramLong1, paramLong2, "conversationLabelRemoved", paramLong3);
    }
    if (l1 == paramLong3) {}
    for (paramRecordHistory = "UPDATE conversations SET labelIds = REPLACE(labelIds, ?, ?), forceAllUnread = 0 WHERE queryId != 0 AND _id = ?";; paramRecordHistory = "UPDATE conversations SET labelIds = REPLACE(labelIds, ?, ?) WHERE queryId != 0 AND _id = ?")
    {
      mDb.execSQL(paramRecordHistory, new String[] { "," + paramLong3 + ",", ",", str1 });
      return;
    }
  }
  
  private void setLabelOnMessage(long paramLong1, long paramLong2, boolean paramBoolean, Operations.RecordHistory paramRecordHistory)
  {
    setLabelOnMessage(paramLong1, paramLong2, paramBoolean, paramRecordHistory, true);
  }
  
  /* Error */
  private void setLabelOnMessage(long paramLong1, long paramLong2, boolean paramBoolean1, Operations.RecordHistory paramRecordHistory, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_0
    //   1: lload_1
    //   2: invokevirtual 465	com/google/android/gm/provider/MailCore:queryConversationIdForMessageId	(J)J
    //   5: lstore 8
    //   7: aload_0
    //   8: getfield 158	com/google/android/gm/provider/MailCore:mLabelMap	Lcom/google/android/gm/provider/Gmail$LabelMap;
    //   11: invokevirtual 412	com/google/android/gm/provider/Gmail$LabelMap:getLabelIdStarred	()J
    //   14: lstore 10
    //   16: iload 5
    //   18: ifeq +148 -> 166
    //   21: new 182	android/content/ContentValues
    //   24: dup
    //   25: invokespecial 183	android/content/ContentValues:<init>	()V
    //   28: astore 12
    //   30: aload 12
    //   32: ldc_w 467
    //   35: lload_3
    //   36: invokestatic 208	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   39: invokevirtual 211	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   42: aload 12
    //   44: ldc_w 469
    //   47: lload_1
    //   48: invokestatic 208	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   51: invokevirtual 211	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   54: aload 12
    //   56: ldc_w 471
    //   59: lload 8
    //   61: invokestatic 208	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   64: invokevirtual 211	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   67: aload_0
    //   68: getfield 116	com/google/android/gm/provider/MailCore:mDb	Landroid/database/sqlite/SQLiteDatabase;
    //   71: ldc_w 446
    //   74: aconst_null
    //   75: aload 12
    //   77: invokevirtual 215	android/database/sqlite/SQLiteDatabase:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   80: pop2
    //   81: aload 6
    //   83: getstatic 430	com/google/android/gm/provider/Operations$RecordHistory:TRUE	Lcom/google/android/gm/provider/Operations$RecordHistory;
    //   86: if_acmpne +18 -> 104
    //   89: aload_0
    //   90: getfield 118	com/google/android/gm/provider/MailCore:mOperations	Lcom/google/android/gm/provider/Operations;
    //   93: lload 8
    //   95: lload_1
    //   96: ldc_w 473
    //   99: lload_3
    //   100: invokevirtual 436	com/google/android/gm/provider/Operations:recordOperationWithLabelId	(JJLjava/lang/String;J)J
    //   103: pop2
    //   104: lload 10
    //   106: lload_3
    //   107: lcmp
    //   108: ifne +57 -> 165
    //   111: iload 7
    //   113: ifeq +52 -> 165
    //   116: aload_0
    //   117: getfield 116	com/google/android/gm/provider/MailCore:mDb	Landroid/database/sqlite/SQLiteDatabase;
    //   120: ldc_w 475
    //   123: invokevirtual 479	android/database/sqlite/SQLiteDatabase:compileStatement	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;
    //   126: astore 12
    //   128: aload 12
    //   130: iconst_1
    //   131: lload 8
    //   133: invokevirtual 485	android/database/sqlite/SQLiteStatement:bindLong	(IJ)V
    //   136: aload 12
    //   138: invokevirtual 488	android/database/sqlite/SQLiteStatement:simpleQueryForLong	()J
    //   141: lstore_1
    //   142: aload 12
    //   144: invokevirtual 489	android/database/sqlite/SQLiteStatement:close	()V
    //   147: iload 5
    //   149: ifeq +93 -> 242
    //   152: aload_0
    //   153: lload 8
    //   155: lload_1
    //   156: lload_3
    //   157: iload 5
    //   159: aload 6
    //   161: iconst_0
    //   162: invokespecial 405	com/google/android/gm/provider/MailCore:setLabelOnConversation	(JJJZLcom/google/android/gm/provider/Operations$RecordHistory;Z)V
    //   165: return
    //   166: aload_0
    //   167: getfield 116	com/google/android/gm/provider/MailCore:mDb	Landroid/database/sqlite/SQLiteDatabase;
    //   170: ldc_w 446
    //   173: ldc_w 491
    //   176: iconst_2
    //   177: anewarray 56	java/lang/String
    //   180: dup
    //   181: iconst_0
    //   182: lload_3
    //   183: invokestatic 317	java/lang/Long:toString	(J)Ljava/lang/String;
    //   186: aastore
    //   187: dup
    //   188: iconst_1
    //   189: lload_1
    //   190: invokestatic 317	java/lang/Long:toString	(J)Ljava/lang/String;
    //   193: aastore
    //   194: invokevirtual 452	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   197: pop
    //   198: aload 6
    //   200: getstatic 430	com/google/android/gm/provider/Operations$RecordHistory:TRUE	Lcom/google/android/gm/provider/Operations$RecordHistory;
    //   203: if_acmpne -99 -> 104
    //   206: aload_0
    //   207: getfield 118	com/google/android/gm/provider/MailCore:mOperations	Lcom/google/android/gm/provider/Operations;
    //   210: lload 8
    //   212: lload_1
    //   213: ldc_w 493
    //   216: lload_3
    //   217: invokevirtual 436	com/google/android/gm/provider/Operations:recordOperationWithLabelId	(JJLjava/lang/String;J)J
    //   220: pop2
    //   221: goto -117 -> 104
    //   224: astore 6
    //   226: aload 12
    //   228: invokevirtual 489	android/database/sqlite/SQLiteStatement:close	()V
    //   231: return
    //   232: astore 6
    //   234: aload 12
    //   236: invokevirtual 489	android/database/sqlite/SQLiteStatement:close	()V
    //   239: aload 6
    //   241: athrow
    //   242: aload_0
    //   243: getfield 116	com/google/android/gm/provider/MailCore:mDb	Landroid/database/sqlite/SQLiteDatabase;
    //   246: ldc_w 495
    //   249: invokevirtual 479	android/database/sqlite/SQLiteDatabase:compileStatement	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;
    //   252: astore 12
    //   254: aload 12
    //   256: iconst_1
    //   257: lload_3
    //   258: invokevirtual 485	android/database/sqlite/SQLiteStatement:bindLong	(IJ)V
    //   261: aload 12
    //   263: iconst_2
    //   264: lload 8
    //   266: invokevirtual 485	android/database/sqlite/SQLiteStatement:bindLong	(IJ)V
    //   269: aload 12
    //   271: invokevirtual 488	android/database/sqlite/SQLiteStatement:simpleQueryForLong	()J
    //   274: lstore 10
    //   276: aload 12
    //   278: invokevirtual 489	android/database/sqlite/SQLiteStatement:close	()V
    //   281: lload 10
    //   283: lconst_0
    //   284: lcmp
    //   285: ifne -120 -> 165
    //   288: aload_0
    //   289: lload 8
    //   291: lload_1
    //   292: lload_3
    //   293: iload 5
    //   295: aload 6
    //   297: iconst_0
    //   298: invokespecial 405	com/google/android/gm/provider/MailCore:setLabelOnConversation	(JJJZLcom/google/android/gm/provider/Operations$RecordHistory;Z)V
    //   301: return
    //   302: astore 6
    //   304: aload 12
    //   306: invokevirtual 489	android/database/sqlite/SQLiteStatement:close	()V
    //   309: aload 6
    //   311: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	this	MailCore
    //   0	312	1	paramLong1	long
    //   0	312	3	paramLong2	long
    //   0	312	5	paramBoolean1	boolean
    //   0	312	6	paramRecordHistory	Operations.RecordHistory
    //   0	312	7	paramBoolean2	boolean
    //   5	285	8	l1	long
    //   14	268	10	l2	long
    //   28	277	12	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   128	142	224	android/database/sqlite/SQLiteDoneException
    //   128	142	232	finally
    //   254	276	302	finally
  }
  
  public void deleteLabel(Label paramLabel)
  {
    if (!mDb.inTransaction()) {
      throw new IllegalStateException("Must be in transaction");
    }
    String[] arrayOfString = new String[1];
    arrayOfString[0] = Long.toString(id);
    mDb.delete("message_labels", "labels_id = ?", arrayOfString);
    mDb.delete("labels", "_id = ?", arrayOfString);
    mDb.delete("conversation_labels", "labels_id = ?", arrayOfString);
    mOperations.deleteOperationsForLabelId(id);
  }
  
  public void expungeMessagesWithoutWritingOperations(List<Long> paramList)
  {
    String str = TextUtils.join(", ", paramList);
    String[] arrayOfString = new String[1];
    arrayOfString[0] = str;
    mDb.delete("message_labels", "message_messageId IN (?)", arrayOfString);
    mOperations.deleteOperationsForMessageIds(paramList);
    mDb.delete("messages", "messageId IN (?)", arrayOfString);
  }
  
  public Collection<Label> getAllLabels()
  {
    try
    {
      Collection localCollection = mCanonicalNameToLabel.values();
      return localCollection;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public Cursor getCursorForCustomFrom()
  {
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    localSQLiteQueryBuilder.setTables("custom_from_prefs");
    return localSQLiteQueryBuilder.query(mDb, null, null, null, null, null, CustomFromUtils.REPLY_TO + " ASC");
  }
  
  public boolean getInfoOverloadArrowsEnabled()
  {
    return !"1".equals((String)mUserGmailPrefs.get("bx_ioao"));
  }
  
  public boolean getInfoOverloadEnabled()
  {
    return "on".equals((String)mUserGmailPrefs.get("sx_ioe"));
  }
  
  public String getLabelCanonicalNameOrNull(Label paramLabel)
  {
    if (paramLabel == null) {
      return null;
    }
    return canonicalName;
  }
  
  public String getLabelCanonicalNameOrThrow(Label paramLabel)
  {
    if (paramLabel == null) {
      throw new IllegalArgumentException("null label");
    }
    return canonicalName;
  }
  
  public Gmail.LabelMap getLabelMap()
  {
    return mLabelMap;
  }
  
  public Label getLabelOrNull(long paramLong)
  {
    try
    {
      Label localLabel = (Label)mIdToLabel.get(Long.valueOf(paramLong));
      return localLabel;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public Label getLabelOrNull(String paramString)
  {
    try
    {
      paramString = (Label)mCanonicalNameToLabel.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public Label getLabelOrThrow(long paramLong)
  {
    try
    {
      Label localLabel1 = (Label)mIdToLabel.get(Long.valueOf(paramLong));
      if (localLabel1 == null) {
        throw new IllegalArgumentException("Unknown label id: " + paramLong);
      }
    }
    finally {}
    return localLabel2;
  }
  
  public Label getLabelOrThrow(String paramString)
  {
    Label localLabel;
    try
    {
      localLabel = (Label)mCanonicalNameToLabel.get(paramString);
      if (localLabel == null) {
        throw new IllegalArgumentException("Could not find label with canonical name: " + paramString);
      }
    }
    finally {}
    return localLabel;
  }
  
  public Collection<NotificationRequest> getNotificationRequests()
  {
    return mNotificationRequests;
  }
  
  public Label getOrAddLabel(long paramLong)
  {
    Label localLabel2 = getLabelOrNull(paramLong);
    Label localLabel1 = localLabel2;
    if (localLabel2 == null) {
      mDb.beginTransactionNonExclusive();
    }
    try
    {
      addLabel(paramLong);
      mDb.setTransactionSuccessful();
      onLabelsChanged();
      localLabel1 = getLabelOrNull(paramLong);
      return localLabel1;
    }
    finally
    {
      mDb.endTransaction();
    }
  }
  
  public Label getOrAddLabel(String paramString)
  {
    Label localLabel2 = getLabelOrNull(paramString);
    Label localLabel1 = localLabel2;
    if (localLabel2 == null) {
      mDb.beginTransactionNonExclusive();
    }
    try
    {
      addLabel(paramString);
      mDb.setTransactionSuccessful();
      onLabelsChanged();
      localLabel1 = getLabelOrNull(paramString);
      return localLabel1;
    }
    finally
    {
      mDb.endTransaction();
    }
  }
  
  public void onConversationChanged(long paramLong, MailSync.SyncRationale paramSyncRationale)
  {
    mConversationHelper.onConversationChanged(paramLong, paramSyncRationale);
  }
  
  void onConversationChanged(long paramLong, MailSync.SyncRationale paramSyncRationale, boolean paramBoolean1, boolean paramBoolean2)
  {
    mConversationHelper.onConversationChanged(paramLong, paramSyncRationale, paramBoolean1, paramBoolean2);
  }
  
  public void onLabelsChanged()
  {
    try
    {
      if (!mDb.inTransaction()) {
        throw new IllegalStateException("Must be in transaction");
      }
    }
    finally {}
    mIdToLabel.clear();
    mCanonicalNameToLabel.clear();
    mLabelMap.requery();
    long l3 = 0L;
    long l1 = -1L;
    Iterator localIterator = mLabelMap.getQueryMap().getRows().entrySet().iterator();
    for (;;)
    {
      long l2;
      if (localIterator.hasNext())
      {
        Object localObject2 = (Map.Entry)localIterator.next();
        long l4 = Long.parseLong((String)((Map.Entry)localObject2).getKey());
        localObject2 = ((ContentValues)((Map.Entry)localObject2).getValue()).getAsString("canonicalName");
        if (localObject2 == null)
        {
          LogUtils.e("Gmail", "Null canonical name in onLabelsChanged", new Object[0]);
          continue;
        }
        Label localLabel = new Label(l4, (String)localObject2);
        if ((isLabelIdLocal(l4) != isCanonicalLabelNameLocal((String)localObject2)) && (!((String)localObject2).equals("")) && (!Gmail.LOCAL_PRIORITY_LABELS.containsKey(Long.valueOf(l4)))) {
          throw new IllegalStateException("Not clear whether label is local: " + localLabel);
        }
        mIdToLabel.put(Long.valueOf(l4), localLabel);
        mCanonicalNameToLabel.put(canonicalName, localLabel);
        l2 = l3;
        if (l4 > l3) {
          l2 = id;
        }
        if ((isLabelIdLocal(l4)) && (l4 < l1)) {
          l1 = id;
        }
      }
      else
      {
        mNextServerLabelId = (l3 + 1L);
        mNextLocalLabelId = (l1 - 1L);
        return;
      }
      l3 = l2;
    }
  }
  
  public boolean purgeConversation(long paramLong)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = Long.toString(paramLong);
    mDb.delete("conversation_labels", "conversation_id = ? AND queryId = 0", arrayOfString);
    mDb.delete("conversations", "_id = ? AND queryId = 0", arrayOfString);
    mDb.delete("message_labels", "message_conversation = ?", arrayOfString);
    int i = mDb.delete("messages", "conversation = ? AND queryId = 0", arrayOfString);
    LogUtils.v("Gmail", "Purged %d messages in conversation %d", new Object[] { Integer.valueOf(i), Long.valueOf(paramLong) });
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("status", Integer.valueOf(-1));
    mDb.update("attachments", localContentValues, "messages_conversation = ?", arrayOfString);
    return i != 0;
  }
  
  public long queryConversationIdForMessageId(long paramLong)
  {
    try
    {
      String str = Long.toString(paramLong);
      paramLong = DatabaseUtils.longForQuery(mDb, "select conversation from messages where messageId = ?", new String[] { str });
      return paramLong;
    }
    catch (SQLException localSQLException) {}
    return 0L;
  }
  
  public void removeCustomFromPreference(String paramString1, String paramString2)
  {
    paramString2 = paramString2.replace("/customfrom/", "");
    CustomFromUtils.removeCustomFrom(UiProvider.getAccountUri(paramString1), paramString2);
    try
    {
      mDb.beginTransactionNonExclusive();
      paramString1 = "'" + paramString2 + "'";
      mDb.delete("custom_from_prefs", "_id=" + paramString1, null);
      mDb.setTransactionSuccessful();
      return;
    }
    finally
    {
      mDb.endTransaction();
    }
  }
  
  public void renameLabel(Label paramLabel, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if (!mDb.inTransaction()) {
      throw new IllegalStateException("Must be in transaction");
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("canonicalName", paramString1);
    localContentValues.put("name", paramString2);
    localContentValues.put("color", Integer.valueOf(paramInt));
    localContentValues.put("visibility", paramString3);
    adjustContentValuesForSystemLabel(paramString1, localContentValues);
    mDb.update("labels", localContentValues, "_id = ?", new String[] { Long.toString(id) });
  }
  
  public void setConfig(Label[] paramArrayOfLabel1, Label[] paramArrayOfLabel2)
  {
    mLabelIdsIncludedOrPartial = Maps.newHashMap();
    int j = paramArrayOfLabel1.length;
    int i = 0;
    while (i < j)
    {
      Label localLabel = paramArrayOfLabel1[i];
      if (localLabel != null) {
        mLabelIdsIncludedOrPartial.put(Long.valueOf(id), Boolean.valueOf(true));
      }
      i += 1;
    }
    j = paramArrayOfLabel2.length;
    i = 0;
    while (i < j)
    {
      paramArrayOfLabel1 = paramArrayOfLabel2[i];
      if (paramArrayOfLabel1 != null) {
        mLabelIdsIncludedOrPartial.put(Long.valueOf(id), Boolean.valueOf(false));
      }
      i += 1;
    }
  }
  
  public void setCustomFromPreference(String paramString, Map<String, MailStore.CustomFromPreference> paramMap, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        mDb.beginTransactionNonExclusive();
        if (paramBoolean)
        {
          mDb.delete("custom_from_prefs", null, null);
          CustomFromUtils.clearCustomFrom(paramString);
        }
        Iterator localIterator = paramMap.entrySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("name", getValuename);
        localContentValues.put("is_default", getValueisDefault);
        if (TextUtils.isEmpty(getValuereplyTo))
        {
          paramMap = (String)localEntry.getKey();
          localContentValues.put("reply_to", paramMap);
          localContentValues.put("address", getValueaddress);
          localContentValues.put("_id", (String)localEntry.getKey());
          mDb.insertWithOnConflict("custom_from_prefs", null, localContentValues, 5);
        }
        else
        {
          paramMap = getValuereplyTo;
        }
      }
      finally
      {
        mDb.endTransaction();
      }
    }
    mDb.setTransactionSuccessful();
    CustomFromUtils.instantiateCustomFrom(UiProvider.getAccountUri(paramString), getCursorForCustomFrom());
    mDb.endTransaction();
  }
  
  public void setCustomLabelColorPreference(String paramString, Map<String, MailStore.CustomLabelColorPreference> paramMap)
  {
    try
    {
      mDb.beginTransactionNonExclusive();
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        ContentValues localContentValues = new ContentValues();
        localContentValues.put(LabelColorUtils.CUSTOM_COLOR_INDEX, (String)localEntry.getKey());
        localContentValues.put(LabelColorUtils.CUSTOM_TEXT_COLOR, getValuetextColor);
        localContentValues.put(LabelColorUtils.CUSTOM_BACKGROUND_COLOR, getValuebackgroundColor);
        localContentValues.put("_id", Integer.valueOf(Integer.parseInt((String)localEntry.getKey())));
        mDb.insertWithOnConflict("custom_label_color_prefs", null, localContentValues, 5);
        LabelColorUtils.addOrUpdateCustomLabelColor(paramString, (String)localEntry.getKey(), (MailStore.CustomLabelColorPreference)localEntry.getValue());
      }
    }
    finally
    {
      mDb.endTransaction();
    }
    mDb.endTransaction();
  }
  
  public void setInfoOverloadArrowsOffPreference(String paramString)
  {
    setServerPreferences(null, ImmutableMap.of("bx_ioao", paramString));
    mUserGmailPrefs.put("bx_ioao", paramString);
  }
  
  public void setInfoOverloadEnabledPreference(String paramString)
  {
    try
    {
      mDb.beginTransactionNonExclusive();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("enabled_pref", paramString);
      mDb.delete("info_overload", null, null);
      mDb.insertWithOnConflict("info_overload", null, localContentValues, 5);
      mUserGmailPrefs.put("sx_ioe", paramString);
      mDb.setTransactionSuccessful();
      return;
    }
    finally
    {
      mDb.endTransaction();
    }
  }
  
  public void setLabelCounts(Label paramLabel, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("numConversations", Integer.valueOf(paramInt1));
    localContentValues.put("numUnreadConversations", Integer.valueOf(paramInt2));
    localContentValues.put("color", Integer.valueOf(paramInt3));
    localContentValues.put("visibility", paramString);
    mDb.beginTransactionNonExclusive();
    try
    {
      mDb.update("labels", localContentValues, "_id = ?", new String[] { Long.toString(id) });
      mDb.setTransactionSuccessful();
      onLabelsChanged();
      return;
    }
    finally
    {
      mDb.endTransaction();
    }
  }
  
  public void setLabelOnConversation(long paramLong1, long paramLong2, Label paramLabel, boolean paramBoolean, Operations.RecordHistory paramRecordHistory)
  {
    setLabelOnConversation(paramLong1, paramLong2, id, paramBoolean, paramRecordHistory);
  }
  
  public void setLabelOnMessage(long paramLong, Label paramLabel, boolean paramBoolean, Operations.RecordHistory paramRecordHistory)
  {
    setLabelOnMessage(paramLong, id, paramBoolean, paramRecordHistory);
  }
  
  public void setLabelsOnMessageWithoutWritingOperations(long paramLong, Set<Long> paramSet)
  {
    mDb.delete("message_labels", "message_messageId = ?", new String[] { Long.toString(paramLong) });
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      setLabelOnMessage(paramLong, ((Long)paramSet.next()).longValue(), true, Operations.RecordHistory.FALSE, false);
    }
  }
  
  public void setNotificationRequests(Collection<NotificationRequest> paramCollection)
  {
    mNotificationRequests = paramCollection;
  }
  
  public void setServerPreferences(String paramString, Map<String, String> paramMap)
  {
    for (;;)
    {
      Map.Entry localEntry;
      try
      {
        mDb.beginTransactionNonExclusive();
        paramMap = paramMap.entrySet().iterator();
        if (!paramMap.hasNext()) {
          break;
        }
        localEntry = (Map.Entry)paramMap.next();
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("name", (String)localEntry.getKey());
        localContentValues.put("value", (String)localEntry.getValue());
        localContentValues.put("_id", (String)localEntry.getKey());
        mDb.insertWithOnConflict("server_preferences", null, localContentValues, 5);
        if (((String)localEntry.getKey()).equals(CustomFromUtils.REPLY_FROM_DEFAULT_SETTING)) {
          continue;
        }
        if (((String)localEntry.getKey()).equals("sx_rt"))
        {
          OutgoingMsgPrefs.addOrUpdateReplyTo(paramString, (String)localEntry.getValue());
          continue;
        }
        if (!((String)localEntry.getKey()).equals("sx_dn")) {
          continue;
        }
      }
      finally
      {
        mDb.endTransaction();
      }
      OutgoingMsgPrefs.addOrUpdateDisplayName(paramString, (String)localEntry.getValue());
    }
    mDb.setTransactionSuccessful();
    mDb.endTransaction();
  }
  
  public void setServerVersion(long paramLong)
  {
    mServerVersion = paramLong;
  }
  
  int updateLabelsLastTouched(ContentValues paramContentValues)
  {
    if ((paramContentValues == null) || (paramContentValues.size() == 0))
    {
      LogUtils.e("Gmail", "Attempting to update recent labels with empty or null map: %s", new Object[] { paramContentValues });
      return 0;
    }
    String[] arrayOfString = new String[paramContentValues.size() * 3];
    int i = 0;
    int j = 1;
    StringBuilder localStringBuilder = new StringBuilder("UPDATE labels SET ");
    localStringBuilder.append("lastTouched");
    localStringBuilder.append(" = (CASE ");
    localStringBuilder.append("canonicalName");
    Object localObject = paramContentValues.keySet();
    Iterator localIterator = ((Set)localObject).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localStringBuilder.append(" WHEN ?");
      int k = i + 1;
      arrayOfString[i] = str;
      localStringBuilder.append(" THEN ?");
      i = k + 1;
      arrayOfString[k] = paramContentValues.getAsString(str);
    }
    localStringBuilder.append(" END)");
    localStringBuilder.append(" WHERE ");
    localStringBuilder.append("canonicalName");
    localStringBuilder.append(" IN (");
    paramContentValues = ((Set)localObject).iterator();
    if (paramContentValues.hasNext())
    {
      localObject = (String)paramContentValues.next();
      if (j != 0) {
        j = 0;
      }
      for (;;)
      {
        localStringBuilder.append("?");
        arrayOfString[i] = localObject;
        i += 1;
        break;
        localStringBuilder.append(", ");
      }
    }
    localStringBuilder.append(")");
    mDb.beginTransactionNonExclusive();
    try
    {
      mDb.execSQL(localStringBuilder.toString(), arrayOfString);
      mDb.setTransactionSuccessful();
      return 1;
    }
    finally
    {
      mDb.endTransaction();
    }
  }
  
  public static class Label
  {
    public String canonicalName;
    public long id;
    
    public Label(long paramLong, String paramString)
    {
      id = paramLong;
      canonicalName = paramString;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof Label)) {}
      do
      {
        return false;
        paramObject = (Label)paramObject;
      } while ((id != id) || (!canonicalName.equals(canonicalName)));
      return true;
    }
    
    public int hashCode()
    {
      return (int)id;
    }
    
    public String toString()
    {
      return id + "/" + canonicalName;
    }
  }
  
  public static abstract interface Listener
  {
    public abstract void onConversationNewlyMatchesNotificationRequest(MailCore.NotificationRequest paramNotificationRequest);
    
    public abstract void onLabelsUpdated(Set<Long> paramSet);
  }
  
  public static final class NotificationRequest
  {
    private final long mLabelId;
    private final Set<Long> mRequiredAbsentLabelIds;
    private final Set<Long> mRequiredPresentLabelIds;
    private final long mTagLabelId;
    
    public NotificationRequest(long paramLong1, long paramLong2, Set<Long> paramSet1, Set<Long> paramSet2)
    {
      mLabelId = paramLong1;
      mTagLabelId = paramLong2;
      mRequiredPresentLabelIds = paramSet1;
      mRequiredAbsentLabelIds = paramSet2;
    }
    
    public final boolean conversationMatches(Set<Long> paramSet)
    {
      if (!paramSet.containsAll(mRequiredPresentLabelIds)) {
        return false;
      }
      Iterator localIterator = mRequiredAbsentLabelIds.iterator();
      while (localIterator.hasNext()) {
        if (paramSet.contains((Long)localIterator.next())) {
          return false;
        }
      }
      return true;
    }
    
    public final long getLabelId()
    {
      return mLabelId;
    }
    
    public final long getTagLabelId()
    {
      return mTagLabelId;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailCore
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */