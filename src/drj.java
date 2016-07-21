import android.accounts.Account;
import android.content.ContentQueryMap;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.text.TextUtils;
import com.google.android.gm.provider.GmailProvider;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class drj
  implements dro
{
  public static final String a = cvl.a;
  private static final Map<String, Integer> p = new hen().b("^i", Integer.valueOf(1)).b("^sq_ig_i_personal", Integer.valueOf(2)).b("^sq_ig_i_social", Integer.valueOf(3)).b("^sq_ig_i_promo", Integer.valueOf(4)).b("^sq_ig_i_notification", Integer.valueOf(5)).b("^sq_ig_i_group", Integer.valueOf(6)).b("^iim", Integer.valueOf(7)).b("^t", Integer.valueOf(8)).b("^io_im", Integer.valueOf(9)).b("^b", Integer.valueOf(10)).b("^f", Integer.valueOf(11)).b("^^out", Integer.valueOf(12)).b("^r", Integer.valueOf(13)).b("^all", Integer.valueOf(14)).b("^s", Integer.valueOf(15)).b("^k", Integer.valueOf(16)).b();
  private static Set<String> u = hio.a(new String[] { "^r", "^^out", "^s" });
  private static Set<String> v = hio.a(new String[] { "^f", "^t", "^b", "^all", "^k", "^io_im" });
  private static final Set<String> w = hio.a(new String[] { "^^out", "^r" });
  private static final Set<String> x = hio.a(new String[] { "^f" });
  private static final Set<String> y = hio.a(new String[] { "^all", "^b", "^s", "^k" });
  final SQLiteDatabase b;
  public final duf c;
  long d;
  Collection<drm> e;
  final Map<Long, Boolean> f = new HashMap();
  public final Map<String, String> g = new ConcurrentHashMap();
  final drl h;
  final dqc i;
  public final Account j;
  final dpu k;
  String l;
  private final Map<String, byte[]> m = new ConcurrentHashMap();
  private final Context n;
  private boolean o = false;
  private final Map<Long, drk> q = new HashMap();
  private final Map<String, drk> r = new HashMap();
  private long s = 0L;
  private long t = 0L;
  private boolean z = false;
  
  public drj(Context paramContext, Account paramAccount, SQLiteDatabase paramSQLiteDatabase, duf paramduf, drl paramdrl)
  {
    n = paramContext;
    j = paramAccount;
    b = paramSQLiteDatabase;
    c = paramduf;
    e = null;
    h = paramdrl;
    m();
    i = new dqc(b.query("labels", new String[] { "_id", "canonicalName", "name", "numConversations", "numUnreadConversations", "numUnseenConversations", "color", "hidden" }, null, null, null, null, null));
    k = new dpu(b, this);
    n();
  }
  
  public static String a(drk paramdrk)
  {
    if (paramdrk == null) {
      throw new IllegalArgumentException("null label");
    }
    return b;
  }
  
  private final void a(long paramLong1, long paramLong2, long paramLong3)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("labels_id", Long.valueOf(paramLong1));
    localContentValues.put("message_messageId", Long.valueOf(paramLong2));
    localContentValues.put("message_conversation", Long.valueOf(paramLong3));
    b.replace("message_labels", null, localContentValues);
  }
  
  private final void a(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean, int paramInt)
  {
    a(paramLong1, paramLong2, paramLong3, paramBoolean, paramInt, true);
  }
  
  private final void a(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    long l1 = i.g();
    long l2 = i.j();
    if (paramBoolean1)
    {
      if (l1 == paramLong3)
      {
        str1 = "UPDATE conversations SET labelIds = ? || REPLACE(labelIds, ?, ?), forceAllUnread = 1 WHERE queryId != 0 AND _id = ?";
        b.execSQL(str1, new String[] { 21 + "," + paramLong3, 22 + "," + paramLong3 + ",", ",", Long.toString(paramLong1) });
        if (l2 != paramLong3) {
          break label153;
        }
        if (paramBoolean2) {
          a(paramLong2, paramLong3, true, paramInt, false);
        }
      }
      label153:
      do
      {
        return;
        str1 = "UPDATE conversations SET labelIds = ? || REPLACE(labelIds, ?, ?) WHERE queryId != 0 AND _id = ?";
        break;
        str1 = Long.toString(paramLong1);
        str2 = Long.toString(paramLong3);
        String str3 = Long.toString(paramLong2);
        b.execSQL("INSERT or REPLACE INTO message_labels (message_messageId, labels_id, message_conversation) SELECT messageId, ?, ? FROM messages WHERE conversation = ? AND messageId <= ?", new String[] { str2, str1, str1, str3 });
        if (paramInt == 1) {
          c.a(paramLong1, paramLong2, "conversationLabelAdded", paramLong3);
        }
        if (i.e() == paramLong3)
        {
          a(paramLong1, paramLong2, i.k(), false, paramInt);
          return;
        }
      } while (i.k() != paramLong3);
      a(paramLong1, paramLong2, i.e(), false, paramInt);
      return;
    }
    String str2 = Long.toString(paramLong1);
    b.delete("message_labels", "labels_id = ? AND message_labels.message_conversation = ? AND message_labels.message_messageId <= ?", new String[] { Long.toString(paramLong3), str2, Long.toString(paramLong2) });
    if (paramInt == 1) {
      c.a(paramLong1, paramLong2, "conversationLabelRemoved", paramLong3);
    }
    if (l1 == paramLong3) {}
    for (String str1 = "UPDATE conversations SET labelIds = REPLACE(labelIds, ?, ?), forceAllUnread = 0 WHERE queryId != 0 AND _id = ?";; str1 = "UPDATE conversations SET labelIds = REPLACE(labelIds, ?, ?) WHERE queryId != 0 AND _id = ?")
    {
      b.execSQL(str1, new String[] { 22 + "," + paramLong3 + ",", ",", str2 });
      return;
    }
  }
  
  /* Error */
  private final void a(long paramLong1, long paramLong2, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_0
    //   1: lload_1
    //   2: invokespecial 319	drj:e	(J)J
    //   5: lstore 8
    //   7: aload_0
    //   8: getfield 200	drj:i	Ldqc;
    //   11: invokevirtual 255	dqc:j	()J
    //   14: lstore 10
    //   16: iload 5
    //   18: ifeq +94 -> 112
    //   21: aload_0
    //   22: lload_3
    //   23: lload_1
    //   24: lload 8
    //   26: invokespecial 321	drj:a	(JJJ)V
    //   29: iload 6
    //   31: iconst_1
    //   32: if_icmpne +18 -> 50
    //   35: aload_0
    //   36: getfield 163	drj:c	Lduf;
    //   39: lload 8
    //   41: lload_1
    //   42: ldc_w 323
    //   45: lload_3
    //   46: invokevirtual 296	duf:a	(JJLjava/lang/String;J)J
    //   49: pop2
    //   50: lload 10
    //   52: lload_3
    //   53: lcmp
    //   54: ifne +57 -> 111
    //   57: iload 7
    //   59: ifeq +52 -> 111
    //   62: aload_0
    //   63: getfield 161	drj:b	Landroid/database/sqlite/SQLiteDatabase;
    //   66: ldc_w 325
    //   69: invokevirtual 329	android/database/sqlite/SQLiteDatabase:compileStatement	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;
    //   72: astore 12
    //   74: aload 12
    //   76: iconst_1
    //   77: lload 8
    //   79: invokevirtual 335	android/database/sqlite/SQLiteStatement:bindLong	(IJ)V
    //   82: aload 12
    //   84: invokevirtual 338	android/database/sqlite/SQLiteStatement:simpleQueryForLong	()J
    //   87: lstore_1
    //   88: aload 12
    //   90: invokevirtual 341	android/database/sqlite/SQLiteStatement:close	()V
    //   93: iload 5
    //   95: ifeq +90 -> 185
    //   98: aload_0
    //   99: lload 8
    //   101: lload_1
    //   102: lload_3
    //   103: iload 5
    //   105: iload 6
    //   107: iconst_0
    //   108: invokespecial 250	drj:a	(JJJZIZ)V
    //   111: return
    //   112: aload_0
    //   113: getfield 161	drj:b	Landroid/database/sqlite/SQLiteDatabase;
    //   116: ldc -14
    //   118: ldc_w 343
    //   121: iconst_2
    //   122: anewarray 113	java/lang/String
    //   125: dup
    //   126: iconst_0
    //   127: lload_3
    //   128: invokestatic 278	java/lang/Long:toString	(J)Ljava/lang/String;
    //   131: aastore
    //   132: dup
    //   133: iconst_1
    //   134: lload_1
    //   135: invokestatic 278	java/lang/Long:toString	(J)Ljava/lang/String;
    //   138: aastore
    //   139: invokevirtual 308	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   142: pop
    //   143: iload 6
    //   145: iconst_1
    //   146: if_icmpne -96 -> 50
    //   149: aload_0
    //   150: getfield 163	drj:c	Lduf;
    //   153: lload 8
    //   155: lload_1
    //   156: ldc_w 345
    //   159: lload_3
    //   160: invokevirtual 296	duf:a	(JJLjava/lang/String;J)J
    //   163: pop2
    //   164: goto -114 -> 50
    //   167: astore 13
    //   169: aload 12
    //   171: invokevirtual 341	android/database/sqlite/SQLiteStatement:close	()V
    //   174: return
    //   175: astore 13
    //   177: aload 12
    //   179: invokevirtual 341	android/database/sqlite/SQLiteStatement:close	()V
    //   182: aload 13
    //   184: athrow
    //   185: aload_0
    //   186: getfield 161	drj:b	Landroid/database/sqlite/SQLiteDatabase;
    //   189: ldc_w 347
    //   192: invokevirtual 329	android/database/sqlite/SQLiteDatabase:compileStatement	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;
    //   195: astore 12
    //   197: aload 12
    //   199: iconst_1
    //   200: lload_3
    //   201: invokevirtual 335	android/database/sqlite/SQLiteStatement:bindLong	(IJ)V
    //   204: aload 12
    //   206: iconst_2
    //   207: lload 8
    //   209: invokevirtual 335	android/database/sqlite/SQLiteStatement:bindLong	(IJ)V
    //   212: aload 12
    //   214: invokevirtual 338	android/database/sqlite/SQLiteStatement:simpleQueryForLong	()J
    //   217: lstore 10
    //   219: aload 12
    //   221: invokevirtual 341	android/database/sqlite/SQLiteStatement:close	()V
    //   224: lload 10
    //   226: lconst_0
    //   227: lcmp
    //   228: ifne -117 -> 111
    //   231: aload_0
    //   232: lload 8
    //   234: lload_1
    //   235: lload_3
    //   236: iload 5
    //   238: iload 6
    //   240: iconst_0
    //   241: invokespecial 250	drj:a	(JJJZIZ)V
    //   244: return
    //   245: astore 13
    //   247: aload 12
    //   249: invokevirtual 341	android/database/sqlite/SQLiteStatement:close	()V
    //   252: aload 13
    //   254: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	255	0	this	drj
    //   0	255	1	paramLong1	long
    //   0	255	3	paramLong2	long
    //   0	255	5	paramBoolean1	boolean
    //   0	255	6	paramInt	int
    //   0	255	7	paramBoolean2	boolean
    //   5	228	8	l1	long
    //   14	211	10	l2	long
    //   72	176	12	localSQLiteStatement	android.database.sqlite.SQLiteStatement
    //   167	1	13	localSQLiteDoneException	android.database.sqlite.SQLiteDoneException
    //   175	8	13	localObject1	Object
    //   245	8	13	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   74	88	167	android/database/sqlite/SQLiteDoneException
    //   74	88	175	finally
    //   197	219	245	finally
  }
  
  public static void a(SQLiteDatabase paramSQLiteDatabase)
  {
    Cursor localCursor = paramSQLiteDatabase.query("labels", new String[] { "_id", "canonicalName" }, null, null, null, null, null);
    long l1 = -1L;
    try
    {
      long l2;
      while (localCursor.moveToNext())
      {
        l2 = localCursor.getLong(0);
        if (d(l2)) {
          l1 = Math.min(l1, l2);
        }
      }
      localCursor.moveToPosition(-1);
      while (localCursor.moveToNext())
      {
        l2 = localCursor.getLong(0);
        if ((h(localCursor.getString(1))) && (!d(l2)))
        {
          l1 -= 1L;
          String[] arrayOfString = new String[2];
          arrayOfString[0] = Long.toString(l1);
          arrayOfString[1] = Long.toString(l2);
          paramSQLiteDatabase.execSQL("UPDATE labels SET _id = ? WHERE _id = ?", arrayOfString);
          paramSQLiteDatabase.execSQL("UPDATE message_labels SET labels_id = ? WHERE labels_id = ?", arrayOfString);
          paramSQLiteDatabase.execSQL("UPDATE conversation_labels SET labels_id = ? WHERE labels_id = ?", arrayOfString);
          duf.a(paramSQLiteDatabase, l2, l1);
          paramSQLiteDatabase.execSQL(105 + "UPDATE conversations SET labelIds = REPLACE(labelIds, '," + l2 + ",', '," + l1 + ",')");
        }
      }
    }
    finally
    {
      localCursor.close();
    }
  }
  
  private final void a(gwt paramgwt)
  {
    a(hdu.a("sx_piac", hlt.a(paramgwt)));
  }
  
  private final void a(String paramString, ContentValues paramContentValues)
  {
    boolean bool2 = false;
    Object localObject = dmv.a();
    int i1;
    int i2;
    label34:
    boolean bool3;
    label113:
    boolean bool1;
    label144:
    boolean bool4;
    if ((dpy.f(paramString)) || (paramString.startsWith("^")))
    {
      i1 = 1;
      if (i1 == 0) {
        break label361;
      }
      i2 = 1;
      paramContentValues.put("systemLabel", Integer.valueOf(i2));
      String str = ((dmv)localObject).a(n, j.name, false);
      bool3 = str.equals("priority");
      if (p.containsKey(paramString))
      {
        if (!paramString.equals(dmv.e(n, str, j.name))) {
          break label367;
        }
        i2 = 1;
        paramContentValues.put("systemLabelOrder", Integer.valueOf(i2));
      }
      if (i1 != 0)
      {
        if (p.containsKey(paramString)) {
          break label389;
        }
        bool1 = true;
        bool4 = ((dmv)localObject).c(n, j.name);
        if (!dpy.g(paramString)) {
          break label401;
        }
        if ((!bool4) || (bool3)) {
          break label461;
        }
        localObject = g().values().iterator();
        while (((Iterator)localObject).hasNext()) {
          if (paramString.equals(nexta)) {
            bool1 = bool2;
          }
        }
      }
    }
    for (;;)
    {
      paramContentValues.put("hidden", Boolean.valueOf(bool1));
      if (v.contains(paramString)) {
        paramContentValues.put("labelCountDisplayBehavior", Integer.valueOf(2));
      }
      if (u.contains(paramString)) {
        paramContentValues.put("labelCountDisplayBehavior", Integer.valueOf(1));
      }
      if (w.contains(paramString)) {
        paramContentValues.put("labelSyncPolicy", Integer.valueOf(1));
      }
      if (y.contains(paramString)) {
        paramContentValues.put("labelSyncPolicy", Integer.valueOf(2));
      }
      if (x.contains(paramString)) {
        paramContentValues.put("labelSyncPolicy", Integer.valueOf(3));
      }
      return;
      i1 = 0;
      break;
      label361:
      i2 = 0;
      break label34;
      label367:
      i2 = ((Integer)p.get(paramString)).intValue() + 1;
      break label113;
      label389:
      bool1 = false;
      break label144;
      bool1 = true;
      continue;
      label401:
      if (("^i".equals(paramString)) || ("^iim".equals(paramString)))
      {
        bool1 = bool2;
        if (bool4)
        {
          bool1 = bool2;
          if (!bool3) {
            bool1 = true;
          }
        }
      }
      else if ("^b".equals(paramString))
      {
        bool1 = true;
      }
      else
      {
        continue;
        label461:
        bool1 = true;
      }
    }
  }
  
  public static String b(drk paramdrk)
  {
    if (paramdrk == null) {
      return null;
    }
    return b;
  }
  
  private void b(Map<String, String> paramMap)
  {
    a(paramMap, false);
  }
  
  public static boolean d(long paramLong)
  {
    return (paramLong < -1L) && (paramLong >= -1000L);
  }
  
  private final long e(long paramLong)
  {
    try
    {
      String str = Long.toString(paramLong);
      paramLong = DatabaseUtils.longForQuery(b, "select conversation from messages where messageId = ?", new String[] { str });
      return paramLong;
    }
    catch (SQLException localSQLException) {}
    return 0L;
  }
  
  public static boolean h(String paramString)
  {
    return (paramString != null) && (paramString.startsWith("^^"));
  }
  
  private final void m()
  {
    Cursor localCursor = b.query("server_preferences", new String[] { "name", "value", "blobValue" }, null, null, null, null, null);
    if (localCursor != null)
    {
      while (localCursor.moveToNext())
      {
        String str1 = localCursor.getString(0);
        String str2 = localCursor.getString(1);
        byte[] arrayOfByte = localCursor.getBlob(2);
        if (str2 != null) {
          g.put(str1, str2);
        } else {
          m.put(str1, arrayOfByte);
        }
      }
      localCursor.close();
    }
  }
  
  private final void n()
  {
    if (o) {
      return;
    }
    b.beginTransactionNonExclusive();
    for (;;)
    {
      Object localObject2;
      String str;
      try
      {
        Iterator localIterator = p.entrySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (Map.Entry)localIterator.next();
        str = (String)((Map.Entry)localObject2).getKey();
        localObject2 = (Integer)((Map.Entry)localObject2).getValue();
        if (!b.inTransaction()) {
          throw new IllegalStateException("Must be in transaction");
        }
      }
      finally
      {
        b.endTransaction();
      }
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("systemLabelOrder", (Integer)localObject2);
      a(str, localContentValues);
      b.update("labels", localContentValues, "canonicalName = ?", new String[] { str });
    }
    o = true;
    l();
    b.setTransactionSuccessful();
    b.endTransaction();
  }
  
  final int a(ContentValues paramContentValues)
  {
    if ((paramContentValues == null) || (paramContentValues.size() == 0))
    {
      dri.e(a, "Attempting to update recent labels with empty or null map: %s", new Object[] { paramContentValues });
      return 0;
    }
    String[] arrayOfString = new String[paramContentValues.size() * 3];
    StringBuilder localStringBuilder = new StringBuilder("UPDATE labels SET ");
    localStringBuilder.append("lastTouched");
    localStringBuilder.append(" = (CASE ");
    localStringBuilder.append("canonicalName");
    Object localObject = paramContentValues.keySet();
    Iterator localIterator = ((Set)localObject).iterator();
    int i1 = 0;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localStringBuilder.append(" WHEN ?");
      i2 = i1 + 1;
      arrayOfString[i1] = str;
      localStringBuilder.append(" THEN ?");
      i1 = i2 + 1;
      arrayOfString[i2] = paramContentValues.getAsString(str);
    }
    localStringBuilder.append(" END)");
    localStringBuilder.append(" WHERE ");
    localStringBuilder.append("canonicalName");
    localStringBuilder.append(" IN (");
    paramContentValues = ((Set)localObject).iterator();
    int i2 = 1;
    if (paramContentValues.hasNext())
    {
      localObject = (String)paramContentValues.next();
      if (i2 != 0) {
        i2 = 0;
      }
      for (;;)
      {
        localStringBuilder.append("?");
        arrayOfString[i1] = localObject;
        i1 += 1;
        break;
        localStringBuilder.append(", ");
      }
    }
    localStringBuilder.append(")");
    b.beginTransactionNonExclusive();
    try
    {
      b.execSQL(localStringBuilder.toString(), arrayOfString);
      b.setTransactionSuccessful();
      return 1;
    }
    finally
    {
      b.endTransaction();
    }
  }
  
  public final long a(long paramLong1, long paramLong2)
  {
    long l1 = e(paramLong1);
    b.beginTransactionNonExclusive();
    try
    {
      a(paramLong2, paramLong1, l1);
      b.setTransactionSuccessful();
      return l1;
    }
    finally
    {
      b.endTransaction();
    }
  }
  
  public final drk a(long paramLong)
  {
    try
    {
      drk localdrk = (drk)q.get(Long.valueOf(paramLong));
      return localdrk;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final drk a(String paramString)
  {
    try
    {
      paramString = (drk)r.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final String a(String paramString1, String paramString2)
  {
    paramString1 = f(paramString1);
    if (paramString1 == null) {
      return paramString2;
    }
    return paramString1;
  }
  
  public final Set<Long> a()
  {
    localObject5 = null;
    Object localObject1 = a("^^sending");
    if (localObject1 == null)
    {
      dri.d(a, "expungeAllSendingLabels retrieved null sending label", new Object[0]);
      localObject5 = null;
    }
    label99:
    label125:
    do
    {
      return (Set<Long>)localObject5;
      String str = Long.toString(a);
      b.beginTransactionNonExclusive();
      try
      {
        localCursor = b.query("message_labels", new String[] { "message_conversation" }, "labels_id = ?", new String[] { str }, null, null, null);
      }
      finally
      {
        b.endTransaction();
        if (localObject5 != null) {
          ((Cursor)localObject5).close();
        }
      }
      try
      {
        if (!localCursor.moveToFirst()) {
          break label201;
        }
        localObject1 = new HashSet();
        ((Set)localObject1).add(Long.valueOf(localCursor.getLong(0)));
        if (localCursor.moveToNext()) {
          break label99;
        }
      }
      finally
      {
        localObject5 = localCursor;
        break;
        Object localObject4 = null;
        break label125;
      }
      b.delete("message_labels", "labels_id=?", new String[] { str });
      b.setTransactionSuccessful();
      b.endTransaction();
      localObject5 = localObject1;
    } while (localCursor == null);
    localCursor.close();
    return (Set<Long>)localObject1;
  }
  
  public final void a(long paramLong1, long paramLong2, drk paramdrk, boolean paramBoolean, int paramInt)
  {
    a(paramLong1, paramLong2, a, paramBoolean, paramInt);
  }
  
  public final void a(long paramLong, drk paramdrk, boolean paramBoolean, int paramInt)
  {
    a(paramLong, a, paramBoolean, paramInt, true);
  }
  
  public final void a(long paramLong, Set<Long> paramSet)
  {
    b.delete("message_labels", "message_messageId = ?", new String[] { Long.toString(paramLong) });
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      a(paramLong, ((Long)paramSet.next()).longValue(), true, 0, false);
    }
  }
  
  public final void a(drk paramdrk, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("numConversations", Integer.valueOf(paramInt1));
    localContentValues.put("numUnreadConversations", Integer.valueOf(paramInt2));
    localContentValues.put("numUnseenConversations", Integer.valueOf(paramInt3));
    localContentValues.put("color", Integer.valueOf(paramInt4));
    localContentValues.put("visibility", paramString);
    b.beginTransactionNonExclusive();
    try
    {
      b.update("labels", localContentValues, "_id = ?", new String[] { Long.toString(a) });
      b.setTransactionSuccessful();
      l();
      return;
    }
    finally
    {
      b.endTransaction();
    }
  }
  
  public final void a(drk paramdrk, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if (!b.inTransaction()) {
      throw new IllegalStateException("Must be in transaction");
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("canonicalName", paramString1);
    localContentValues.put("name", paramString2);
    localContentValues.put("color", Integer.valueOf(paramInt));
    localContentValues.put("visibility", paramString3);
    a(paramString1, localContentValues);
    b.update("labels", localContentValues, "_id = ?", new String[] { Long.toString(a) });
  }
  
  public final void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject = new ContentValues(3);
    ((ContentValues)localObject).put("_id", paramString1);
    ((ContentValues)localObject).put("name", paramString1);
    ((ContentValues)localObject).put("value", paramString2);
    b.insertWithOnConflict("server_preferences", null, (ContentValues)localObject, 5);
    localObject = j.name;
    if (dyr.e.equals(paramString1)) {
      dyr.a(GmailProvider.b((String)localObject), paramString2);
    }
    for (;;)
    {
      g.put(paramString1, paramString2);
      if (paramBoolean) {
        c.a(paramString1, paramString2);
      }
      return;
      if ("sx_rt".equals(paramString1))
      {
        dyy.a((String)localObject, paramString2);
      }
      else if ("sx_dn".equals(paramString1))
      {
        dyy.b((String)localObject, paramString2);
      }
      else if ("bx_pie".equals(paramString1))
      {
        dmv.a().a(n, (String)localObject, Boolean.parseBoolean(paramString2), g().keySet(), h);
        localObject = n;
        Intent localIntent = new Intent("com.android.mail.ACTION_VALIDATE_ALL_WIDGETS");
        localIntent.setType("application/gmail-ls");
        ((Context)localObject).sendBroadcast(localIntent);
      }
    }
  }
  
  public final void a(List<Long> paramList)
  {
    String str1 = TextUtils.join(", ", paramList);
    b.delete("message_labels", String.valueOf(str1).length() + 23 + "message_messageId IN (" + str1 + ")", null);
    duf localduf = c;
    String str2 = TextUtils.join(", ", paramList);
    c.delete("operations", String.valueOf(str2).length() + 23 + "message_messageId IN (" + str2 + ")", null);
    int i1 = b.delete("messages", String.valueOf(str1).length() + 15 + "messageId IN (" + str1 + ")", null);
    if (i1 != paramList.size()) {
      dri.d(a, "Deleted messages count (%d) does not match delete request count (%d)", new Object[] { Integer.valueOf(i1), Integer.valueOf(paramList.size()) });
    }
  }
  
  public final void a(Map<String, byte[]> paramMap)
  {
    Object localObject1 = g().keySet();
    Object localObject2;
    Object localObject3;
    Object localObject4;
    try
    {
      b.beginTransactionNonExclusive();
      localObject2 = paramMap.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        localObject4 = new ContentValues();
        ((ContentValues)localObject4).put("name", (String)((Map.Entry)localObject3).getKey());
        ((ContentValues)localObject4).putNull("value");
        ((ContentValues)localObject4).put("blobValue", (byte[])((Map.Entry)localObject3).getValue());
        ((ContentValues)localObject4).put("_id", (String)((Map.Entry)localObject3).getKey());
        b.insertWithOnConflict("server_preferences", null, (ContentValues)localObject4, 5);
        m.put((String)((Map.Entry)localObject3).getKey(), (byte[])((Map.Entry)localObject3).getValue());
      }
    }
    finally
    {
      b.endTransaction();
    }
    b.endTransaction();
    HashSet localHashSet;
    if (paramMap.containsKey("sx_piac"))
    {
      e();
      h.a();
      paramMap = g().keySet();
      localHashSet = new HashSet(paramMap);
      localHashSet.removeAll((Collection)localObject1);
      localObject2 = dpy.a(n, j.name);
      localObject3 = new HashSet();
      ((Set)localObject3).addAll(((dqg)localObject2).d());
      localObject4 = new HashSet();
      ((Set)localObject4).addAll(((dqg)localObject2).c());
      if (!((Set)localObject4).contains("^sq_ig_i_personal")) {
        break label389;
      }
      ((Set)localObject4).addAll(localHashSet);
    }
    for (;;)
    {
      localObject1 = new HashSet((Collection)localObject1);
      ((Set)localObject1).removeAll(paramMap);
      ((Set)localObject3).removeAll((Collection)localObject1);
      ((Set)localObject4).removeAll((Collection)localObject1);
      ((dqg)localObject2).b((Collection)localObject3);
      ((dqg)localObject2).a((Collection)localObject4);
      dpy.a(j.name, (dqg)localObject2, n.getContentResolver());
      return;
      label389:
      if (((Set)localObject3).contains("^sq_ig_i_personal")) {
        ((Set)localObject3).addAll(localHashSet);
      }
    }
  }
  
  public final void a(Map<String, String> paramMap, boolean paramBoolean)
  {
    try
    {
      b.beginTransactionNonExclusive();
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        a((String)localEntry.getKey(), (String)localEntry.getValue(), paramBoolean);
        if (paramBoolean) {
          c.a((String)localEntry.getKey(), (String)localEntry.getValue());
        }
      }
      g.putAll(paramMap);
    }
    finally
    {
      b.endTransaction();
    }
    b.setTransactionSuccessful();
    b.endTransaction();
  }
  
  public final void a(Set<String> paramSet, boolean paramBoolean)
  {
    gwt localgwt = f();
    if (localgwt != null)
    {
      HashSet localHashSet = hio.a(b.length);
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = b;
      int i2 = localObject1.length;
      int i1 = 0;
      while (i1 < i2)
      {
        localObject2 = localObject1[i1];
        if (paramSet.contains(b))
        {
          localArrayList.add(localObject2);
          localHashSet.add(b);
        }
        i1 += 1;
      }
      Object localObject2 = paramSet.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (String)((Iterator)localObject2).next();
        if (!localHashSet.contains(localObject1))
        {
          gzq localgzq = new gzq();
          b = ((String)localObject1);
          localObject1 = String.valueOf(localObject1);
          if (((String)localObject1).length() != 0) {}
          for (localObject1 = "label:".concat((String)localObject1); localObject1 == null; localObject1 = new String("label:")) {
            throw new NullPointerException();
          }
          c = ((String)localObject1);
          a |= 0x1;
          d = dyx.a();
          a |= 0x2;
          localArrayList.add(localgzq);
        }
      }
      b = ((gzq[])localArrayList.toArray(gzq.b()));
      c = paramBoolean;
      a |= 0x1;
      try
      {
        a(localgwt);
        if (paramSet.size() > 1)
        {
          paramBoolean = true;
          b(hdu.a("bx_pie", Boolean.toString(paramBoolean)));
          return;
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          dri.e(a, "Error writing tab config protobuf. Requires server sync", new Object[0]);
          continue;
          paramBoolean = false;
        }
      }
    }
    dri.d(a, "User changed section config, but we have no existing protobuf", new Object[0]);
  }
  
  public final boolean a(String paramString, boolean paramBoolean)
  {
    paramString = f(paramString);
    if (paramString == null) {
      return paramBoolean;
    }
    if (paramString.equals("0")) {
      return false;
    }
    return (paramString.equals("1")) || (Boolean.parseBoolean(paramString));
  }
  
  public final int b(String paramString1, String paramString2)
  {
    paramString1 = dpy.k(paramString1);
    paramString1 = drd.a(n, j.name, paramString1);
    if (paramString1 == null) {}
    long l1;
    long l2;
    do
    {
      do
      {
        return 0;
        l1 = paramString1.a();
        paramString1 = drd.a(n, j.name, paramString2);
      } while (paramString1 == null);
      l2 = paramString1.a();
      paramString1 = dpy.k(paramString2);
      paramString1 = drd.a(n, j.name, paramString1);
    } while (paramString1 == null);
    long l3 = paramString1.a();
    b.beginTransactionNonExclusive();
    try
    {
      paramString1 = new ContentValues(1);
      paramString1.put("labels_id", Long.toString(l3));
      paramString2 = new String[2];
      paramString2[0] = Long.toString(l1);
      paramString2[1] = Long.toString(l2);
      int i1 = b.updateWithOnConflict("conversation_labels", paramString1, "labels_id = ? AND conversation_id IN (SELECT conversation_id FROM conversation_labels WHERE labels_id = ?)", paramString2, 5);
      b.updateWithOnConflict("message_labels", paramString1, "labels_id = ? AND message_conversation IN (SELECT conversation_id FROM conversation_labels WHERE labels_id = ?)", paramString2, 5);
      paramString1 = new ContentValues(3);
      paramString1.put("numConversations", Integer.valueOf(i1));
      paramString1.put("numUnreadConversations", Integer.valueOf(i1));
      paramString1.put("numUnseenConversations", Integer.valueOf(i1));
      paramString2 = Long.toString(l3);
      b.update("labels", paramString1, "_id = ?", new String[] { paramString2 });
      b.setTransactionSuccessful();
      l();
      return i1;
    }
    finally
    {
      b.endTransaction();
    }
  }
  
  public final drk b(long paramLong)
  {
    drk localdrk2 = a(paramLong);
    drk localdrk1 = localdrk2;
    Object localObject2;
    if (localdrk2 == null)
    {
      b.beginTransactionNonExclusive();
      try
      {
        if (!b.inTransaction()) {
          throw new IllegalStateException("Must be in transaction");
        }
      }
      finally
      {
        b.endTransaction();
      }
      if (s == 0L) {
        throw new IllegalStateException("onLabelsChanged not yet called");
      }
      localObject2 = new ContentValues();
      ((ContentValues)localObject2).put("canonicalName", "");
      ((ContentValues)localObject2).put("name", "");
      ((ContentValues)localObject2).put("numConversations", Integer.valueOf(0));
      ((ContentValues)localObject2).put("numUnreadConversations", Integer.valueOf(0));
      ((ContentValues)localObject2).put("numUnseenConversations", Integer.valueOf(0));
      ((ContentValues)localObject2).put("color", Integer.valueOf(Integer.MAX_VALUE));
      ((ContentValues)localObject2).put("visibility", "SHOW");
      ((ContentValues)localObject2).put("_id", Long.valueOf(paramLong));
      b.replace("labels", null, (ContentValues)localObject2);
      b.setTransactionSuccessful();
      l();
      localObject2 = a(paramLong);
      b.endTransaction();
    }
    return (drk)localObject2;
  }
  
  public final drk b(String paramString)
  {
    drk localdrk;
    for (;;)
    {
      try
      {
        localdrk = (drk)r.get(paramString);
        if (localdrk != null) {
          break;
        }
        paramString = String.valueOf(paramString);
        if (paramString.length() != 0)
        {
          paramString = "Could not find label with canonical name: ".concat(paramString);
          throw new IllegalArgumentException(paramString);
        }
      }
      finally {}
      paramString = new String("Could not find label with canonical name: ");
    }
    return localdrk;
  }
  
  public final Collection<drk> b()
  {
    try
    {
      Collection localCollection = r.values();
      return localCollection;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final Cursor c()
  {
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    localSQLiteQueryBuilder.setTables("custom_from_prefs");
    return localSQLiteQueryBuilder.query(b, null, null, null, null, null, String.valueOf(dyr.c).concat(" ASC"));
  }
  
  public final drk c(long paramLong)
  {
    try
    {
      drk localdrk1 = (drk)q.get(Long.valueOf(paramLong));
      if (localdrk1 == null) {
        throw new IllegalArgumentException(38 + "Unknown label id: " + paramLong);
      }
    }
    finally {}
    return localdrk2;
  }
  
  public final drk c(String paramString)
  {
    Object localObject2 = a(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      b.beginTransactionNonExclusive();
      try
      {
        if (!b.inTransaction()) {
          throw new IllegalStateException("Must be in transaction");
        }
      }
      finally
      {
        b.endTransaction();
      }
      if (s == 0L) {
        throw new IllegalStateException("onLabelsChanged not yet called");
      }
      localObject2 = new ContentValues();
      ((ContentValues)localObject2).put("canonicalName", paramString);
      ((ContentValues)localObject2).put("name", "");
      ((ContentValues)localObject2).put("numConversations", Integer.valueOf(0));
      ((ContentValues)localObject2).put("numUnreadConversations", Integer.valueOf(0));
      ((ContentValues)localObject2).put("numUnseenConversations", Integer.valueOf(0));
      ((ContentValues)localObject2).put("color", Integer.valueOf(Integer.MAX_VALUE));
      ((ContentValues)localObject2).put("visibility", "SHOW");
      a(paramString, (ContentValues)localObject2);
      long l1;
      if (h(paramString))
      {
        l1 = t;
        t = (l1 - 1L);
        localObject1 = Long.valueOf(l1);
        ((ContentValues)localObject2).put("_id", (Long)localObject1);
        if (b.replace("labels", null, (ContentValues)localObject2) != -1L) {
          break label316;
        }
        paramString = String.valueOf(paramString);
        if (paramString.length() == 0) {
          break label302;
        }
      }
      label302:
      for (paramString = "Failed to insert row for label: ".concat(paramString);; paramString = new String("Failed to insert row for label: "))
      {
        throw new IllegalStateException(paramString);
        if (dpy.j.contains(paramString))
        {
          localObject1 = (Long)dpy.i.a().get(paramString);
          break;
        }
        l1 = s;
        s = (1L + l1);
        localObject1 = Long.valueOf(l1);
        break;
      }
      label316:
      b.setTransactionSuccessful();
      l();
      localObject1 = a(paramString);
      b.endTransaction();
    }
    return (drk)localObject1;
  }
  
  public final void c(drk paramdrk)
  {
    if (!b.inTransaction()) {
      throw new IllegalStateException("Must be in transaction");
    }
    Object localObject = new String[1];
    localObject[0] = Long.toString(a);
    b.delete("message_labels", "labels_id = ?", (String[])localObject);
    b.delete("labels", "_id = ?", (String[])localObject);
    b.delete("conversation_labels", "labels_id = ?", (String[])localObject);
    localObject = c;
    paramdrk = Long.toString(a);
    localObject = c;
    String str = duf.e;
    ((SQLiteDatabase)localObject).delete("operations", String.valueOf(str).length() + 27 + "action IN (" + str + ") AND value1 = ?", new String[] { paramdrk });
  }
  
  public final int d(String paramString)
  {
    String str = f(paramString);
    if (str == null) {
      return -1;
    }
    try
    {
      int i1 = Integer.parseInt(str);
      return i1;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      dri.e(a, localNumberFormatException, "Value %s for key %s cannot be parsed as an int", new Object[] { str, paramString });
    }
    return -1;
  }
  
  /* Error */
  public final String d()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 155	drj:z	Z
    //   4: ifne +82 -> 86
    //   7: new 918	android/database/sqlite/SQLiteQueryBuilder
    //   10: dup
    //   11: invokespecial 919	android/database/sqlite/SQLiteQueryBuilder:<init>	()V
    //   14: astore_1
    //   15: aload_1
    //   16: ldc_w 964
    //   19: invokevirtual 924	android/database/sqlite/SQLiteQueryBuilder:setTables	(Ljava/lang/String;)V
    //   22: aload_1
    //   23: aload_0
    //   24: getfield 161	drj:b	Landroid/database/sqlite/SQLiteDatabase;
    //   27: getstatic 967	dpy:p	[Ljava/lang/String;
    //   30: aconst_null
    //   31: aconst_null
    //   32: aconst_null
    //   33: aconst_null
    //   34: aconst_null
    //   35: invokevirtual 930	android/database/sqlite/SQLiteQueryBuilder:query	(Landroid/database/sqlite/SQLiteDatabase;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   38: astore_1
    //   39: aload_1
    //   40: ifnull +31 -> 71
    //   43: aload_1
    //   44: invokeinterface 645 1 0
    //   49: ifeq +22 -> 71
    //   52: aload_0
    //   53: aload_1
    //   54: aload_1
    //   55: ldc_w 969
    //   58: invokeinterface 972 2 0
    //   63: invokeinterface 377 2 0
    //   68: putfield 974	drj:l	Ljava/lang/String;
    //   71: aload_1
    //   72: ifnull +9 -> 81
    //   75: aload_1
    //   76: invokeinterface 398 1 0
    //   81: aload_0
    //   82: iconst_1
    //   83: putfield 155	drj:z	Z
    //   86: aload_0
    //   87: getfield 974	drj:l	Ljava/lang/String;
    //   90: areturn
    //   91: astore_2
    //   92: aconst_null
    //   93: astore_1
    //   94: invokestatic 979	buo:a	()Lbut;
    //   97: ldc_w 981
    //   100: ldc_w 983
    //   103: aload_2
    //   104: invokevirtual 986	android/database/SQLException:getMessage	()Ljava/lang/String;
    //   107: lconst_0
    //   108: invokeinterface 991 6 0
    //   113: getstatic 60	drj:a	Ljava/lang/String;
    //   116: aload_2
    //   117: ldc_w 993
    //   120: iconst_0
    //   121: anewarray 4	java/lang/Object
    //   124: invokestatic 962	dri:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   127: pop
    //   128: aload_2
    //   129: athrow
    //   130: astore_3
    //   131: aload_1
    //   132: astore_2
    //   133: aload_3
    //   134: astore_1
    //   135: aload_2
    //   136: ifnull +9 -> 145
    //   139: aload_2
    //   140: invokeinterface 398 1 0
    //   145: aload_1
    //   146: athrow
    //   147: astore_1
    //   148: aconst_null
    //   149: astore_2
    //   150: goto -15 -> 135
    //   153: astore_3
    //   154: aload_1
    //   155: astore_2
    //   156: aload_3
    //   157: astore_1
    //   158: goto -23 -> 135
    //   161: astore_2
    //   162: goto -68 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	drj
    //   14	132	1	localObject1	Object
    //   147	8	1	localObject2	Object
    //   157	1	1	localObject3	Object
    //   91	38	2	localSQLException1	SQLException
    //   132	24	2	localObject4	Object
    //   161	1	2	localSQLException2	SQLException
    //   130	4	3	localObject5	Object
    //   153	4	3	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   22	39	91	android/database/SQLException
    //   94	130	130	finally
    //   22	39	147	finally
    //   43	71	153	finally
    //   43	71	161	android/database/SQLException
  }
  
  public final long e(String paramString)
  {
    String str = f(paramString);
    if (str == null) {
      return 0L;
    }
    try
    {
      long l1 = Long.parseLong(str);
      return l1;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      dri.e(a, localNumberFormatException, "Value %s for key %s cannot be parsed as a long", new Object[] { str, paramString });
    }
    return 0L;
  }
  
  public final void e()
  {
    b.beginTransactionNonExclusive();
    try
    {
      Iterator localIterator = dpy.a.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ContentValues localContentValues2 = new ContentValues();
        a(str, localContentValues2);
        b.update("labels", localContentValues2, "canonicalName = ?", new String[] { str });
      }
      localContentValues1 = new ContentValues();
    }
    finally
    {
      b.endTransaction();
    }
    a("^i", localContentValues1);
    b.update("labels", localContentValues1, "canonicalName = ?", new String[] { "^i" });
    ContentValues localContentValues1 = new ContentValues();
    a("^iim", localContentValues1);
    b.update("labels", localContentValues1, "canonicalName = ?", new String[] { "^iim" });
    l();
    b.setTransactionSuccessful();
    b.endTransaction();
  }
  
  public final gwt f()
  {
    Object localObject = (byte[])m.get("sx_piac");
    if (localObject == null)
    {
      dri.d(a, "Could not find personal inbox android config protobuf", new Object[0]);
      return null;
    }
    try
    {
      localObject = (gwt)hlt.a(new gwt(), (byte[])localObject, localObject.length);
      return (gwt)localObject;
    }
    catch (IOException localIOException)
    {
      dri.e(a, "Unable to parse personal inbox android config protobuf", new Object[] { localIOException });
    }
    return null;
  }
  
  public final String f(String paramString)
  {
    String str = (String)g.get(paramString);
    dri.a(a, "userpref %s is %s for %s", new Object[] { paramString, str, j.name });
    return str;
  }
  
  public final Map<String, drn> g()
  {
    Object localObject1 = f();
    if (localObject1 == null) {
      return hid.b;
    }
    hen localhen = new hen();
    localObject1 = b;
    int i2 = localObject1.length;
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject2 = localObject1[i1];
      String str = b;
      localhen.b(str, new drn(str, c, d));
      i1 += 1;
    }
    return localhen.b();
  }
  
  public final void g(String paramString)
  {
    if (paramString.equals(dnm.a(n, j.name).g()))
    {
      a("sx_agda", paramString, true);
      GmailProvider.b(n, j.name);
      return;
    }
    dri.d(a, "Can't set %s address as g6y_display_address", new Object[] { paramString });
  }
  
  public final boolean h()
  {
    boolean bool = a("temp_adie", false);
    dri.b(a, "reading always-show-images CF, val=%s acct=%s", new Object[] { Boolean.valueOf(bool), j.name });
    return bool;
  }
  
  public final boolean i()
  {
    if (!h()) {
      return false;
    }
    boolean bool = a("bx_eid", true);
    dri.b(a, "MailCore.getAlwaysShowImages(), val=%s acct=%s", new Object[] { Boolean.valueOf(bool), j.name });
    return bool;
  }
  
  public final String j()
  {
    String str1 = f("sx_agda");
    if (TextUtils.isEmpty(str1)) {
      return null;
    }
    String str2 = dnm.a(n, j.name).g();
    if (TextUtils.equals(str1, str2)) {
      return str1;
    }
    dri.d(a, "g6y_display_address=%s doesn't match g6y_address=%s", new Object[] { dri.a(str1), dri.a(str2) });
    return null;
  }
  
  public final void k()
  {
    a("sx_agda", "", true);
    GmailProvider.b(n, j.name);
  }
  
  public final void l()
  {
    try
    {
      if (!b.inTransaction()) {
        throw new IllegalStateException("Must be in transaction");
      }
    }
    finally {}
    q.clear();
    r.clear();
    i.a.requery();
    long l3 = 0L;
    long l1 = -1L;
    Object localObject2 = i.a.getRows().entrySet().iterator();
    for (;;)
    {
      long l2;
      if (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (Map.Entry)((Iterator)localObject2).next();
        long l4 = Long.parseLong((String)((Map.Entry)localObject3).getKey());
        localObject3 = ((ContentValues)((Map.Entry)localObject3).getValue()).getAsString("canonicalName");
        if (localObject3 == null)
        {
          dri.e(a, "Null canonical name in onLabelsChanged", new Object[0]);
          continue;
        }
        drk localdrk = new drk(l4, (String)localObject3);
        if ((d(l4) != h((String)localObject3)) && (!((String)localObject3).equals("")) && (!dpy.i.containsKey(Long.valueOf(l4))))
        {
          localObject2 = String.valueOf(localdrk);
          throw new IllegalStateException(String.valueOf(localObject2).length() + 34 + "Not clear whether label is local: " + (String)localObject2);
        }
        q.put(Long.valueOf(l4), localdrk);
        r.put(b, localdrk);
        l2 = l3;
        if (l4 > l3) {
          l2 = a;
        }
        if ((d(l4)) && (l4 < l1)) {
          l1 = a;
        }
      }
      else
      {
        s = (l3 + 1L);
        t = (l1 - 1L);
        return;
      }
      l3 = l2;
    }
  }
}

/* Location:
 * Qualified Name:     drj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */