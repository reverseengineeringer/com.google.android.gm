package com.google.android.gm.provider;

import android.app.IntentService;
import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteException;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gm.Utils;
import com.google.android.gsf.Gservices;
import com.google.common.collect.Lists;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class MailIndexerService
  extends IntentService
{
  private static int DEFAULT_MESSAGE_BATCH_SIZE = 50;
  private static final String[] FTS_DOCID_PROJECTION = { "docid" };
  private static String GMAIL_FULL_TEXT_SEARCH_MESSAGE_INDEX__BATCH_SIZE = "gmail_full_text_search_message_index_batch_size";
  private static final String[] INDEXABLE_CONVERSATION_CONTENT_PROJECTION;
  private static final String[] INDEXABLE_MESSAGE_CONTENT_PROJECTION = { "messageId", "conversation", "subject", "snippet", "body", "fromAddress", "toAddresses", "ccAddresses", "bccAddresses" };
  private static volatile MailIndexerService sIndexerInstance;
  private static int sTransactionYieldTimeoutMs = -1;
  private String mAccount;
  private volatile boolean mIndexerExternallyYielded = false;
  
  static
  {
    INDEXABLE_CONVERSATION_CONTENT_PROJECTION = new String[] { "_id", "subject", "snippet", "fromAddress" };
  }
  
  public MailIndexerService()
  {
    super("MailIndexerService");
  }
  
  private void addConversationToFtsIndex(MailEngine paramMailEngine, ContentValues paramContentValues)
  {
    SQLiteDatabase localSQLiteDatabase = mDb;
    if ((localSQLiteDatabase == null) || (!localSQLiteDatabase.isOpen())) {}
    while (!paramMailEngine.isFullTextSearchEnabled()) {
      return;
    }
    paramMailEngine = new ContentValues();
    ContentValues localContentValues = new ContentValues();
    String str = paramContentValues.getAsString("_id");
    localSQLiteDatabase.delete("conversation_fts_table", "docid = ?", new String[] { str });
    paramMailEngine.put("docid", str);
    localContentValues.put("docid", str);
    paramMailEngine.put("subject", paramContentValues.getAsString("subject"));
    paramMailEngine.put("snippet", paramContentValues.getAsString("snippet"));
    paramMailEngine.put("fromAddress", paramContentValues.getAsString("fromAddress"));
    localSQLiteDatabase.replaceOrThrow("conversation_fts_table", null, paramMailEngine);
    localSQLiteDatabase.replaceOrThrow("conversation_fts_table_index", null, localContentValues);
  }
  
  private void addMessageToFtsIndex(MailEngine paramMailEngine, ContentValues paramContentValues)
  {
    SQLiteDatabase localSQLiteDatabase = mDb;
    if ((localSQLiteDatabase == null) || (!localSQLiteDatabase.isOpen())) {}
    while (!paramMailEngine.isFullTextSearchEnabled()) {
      return;
    }
    paramMailEngine = new ContentValues();
    ContentValues localContentValues = new ContentValues();
    String str = paramContentValues.getAsString("messageId");
    deleteMessageFromFtsIndex(localSQLiteDatabase, str);
    if (str != null)
    {
      paramMailEngine.put("docid", str);
      localContentValues.put("docid", str);
    }
    paramMailEngine.put("conversation", paramContentValues.getAsString("conversation"));
    paramMailEngine.put("subject", paramContentValues.getAsString("subject"));
    paramMailEngine.put("snippet", paramContentValues.getAsString("snippet"));
    str = paramContentValues.getAsString("body");
    if (str != null) {
      paramMailEngine.put("body", str);
    }
    paramMailEngine.put("fromAddress", paramContentValues.getAsString("fromAddress"));
    paramMailEngine.put("toAddresses", paramContentValues.getAsString("toAddresses"));
    paramMailEngine.put("ccAddresses", paramContentValues.getAsString("ccAddresses"));
    paramMailEngine.put("bccAddresses", paramContentValues.getAsString("bccAddresses"));
    localSQLiteDatabase.replaceOrThrow("message_fts_table", null, paramMailEngine);
    localSQLiteDatabase.replaceOrThrow("message_fts_table_index", null, localContentValues);
  }
  
  static void createSearchIndexTables(SQLiteDatabase paramSQLiteDatabase)
  {
    deleteSearchIndexTables(paramSQLiteDatabase);
    paramSQLiteDatabase.execSQL("CREATE VIRTUAL TABLE conversation_fts_table USING FTS4 (subject TEXT, snippet TEXT, fromAddress TEXT, )");
    paramSQLiteDatabase.execSQL("CREATE VIRTUAL TABLE message_fts_table USING FTS4 (conversation TEXT, subject TEXT, snippet TEXT, body TEXT, fromAddress TEXT, toAddresses TEXT, ccAddresses TEXT, bccAddresses TEXT, )");
    paramSQLiteDatabase.execSQL("CREATE TABLE message_fts_table_index(docid INTEGER PRIMARY KEY)");
    paramSQLiteDatabase.execSQL("CREATE TABLE conversation_fts_table_index(docid INTEGER PRIMARY KEY)");
  }
  
  private boolean deleteConversationFtsEntries(SQLiteDatabase paramSQLiteDatabase)
  {
    return deleteEntriesFromFtsTable(paramSQLiteDatabase, "conversation_fts_table", "conversation_fts_table_index", "conversations", "conversation_fts_table_index.docid = conversations._id", "conversations._id is null");
  }
  
  /* Error */
  private boolean deleteEntriesFromFtsTable(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 9
    //   3: invokestatic 159	com/google/common/collect/Sets:newHashSet	()Ljava/util/HashSet;
    //   6: astore 12
    //   8: aload_1
    //   9: new 161	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   16: aload_3
    //   17: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: ldc -88
    //   22: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload 4
    //   27: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc -86
    //   32: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload 5
    //   37: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc -84
    //   42: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: getstatic 56	com/google/android/gm/provider/MailIndexerService:FTS_DOCID_PROJECTION	[Ljava/lang/String;
    //   51: aload 6
    //   53: aconst_null
    //   54: aconst_null
    //   55: aconst_null
    //   56: aconst_null
    //   57: invokevirtual 180	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   60: astore 4
    //   62: aload 4
    //   64: invokeinterface 185 1 0
    //   69: ifeq +35 -> 104
    //   72: aload 12
    //   74: aload 4
    //   76: iconst_0
    //   77: invokeinterface 189 2 0
    //   82: invokestatic 195	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   85: invokeinterface 201 2 0
    //   90: pop
    //   91: goto -29 -> 62
    //   94: astore_1
    //   95: aload 4
    //   97: invokeinterface 204 1 0
    //   102: aload_1
    //   103: athrow
    //   104: aload 4
    //   106: invokeinterface 204 1 0
    //   111: aload_0
    //   112: getfield 67	com/google/android/gm/provider/MailIndexerService:mIndexerExternallyYielded	Z
    //   115: ifeq +5 -> 120
    //   118: iconst_1
    //   119: ireturn
    //   120: aload_1
    //   121: invokevirtual 207	android/database/sqlite/SQLiteDatabase:beginTransactionNonExclusive	()V
    //   124: aload_1
    //   125: new 161	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   132: ldc -47
    //   134: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_2
    //   138: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: ldc -45
    //   143: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokevirtual 215	android/database/sqlite/SQLiteDatabase:compileStatement	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;
    //   152: astore 4
    //   154: aload 12
    //   156: invokeinterface 219 1 0
    //   161: astore 5
    //   163: iload 9
    //   165: istore 8
    //   167: aload 5
    //   169: invokeinterface 224 1 0
    //   174: ifeq +133 -> 307
    //   177: aload 5
    //   179: invokeinterface 228 1 0
    //   184: checkcast 191	java/lang/Long
    //   187: astore 6
    //   189: iconst_0
    //   190: istore 7
    //   192: aload 4
    //   194: iconst_1
    //   195: aload 6
    //   197: invokevirtual 232	java/lang/Long:longValue	()J
    //   200: invokevirtual 238	android/database/sqlite/SQLiteStatement:bindLong	(IJ)V
    //   203: aload 4
    //   205: invokevirtual 241	android/database/sqlite/SQLiteStatement:simpleQueryForLong	()J
    //   208: lstore 10
    //   210: lload 10
    //   212: lconst_0
    //   213: lcmp
    //   214: ifle +149 -> 363
    //   217: iconst_1
    //   218: istore 7
    //   220: aload 4
    //   222: invokevirtual 244	android/database/sqlite/SQLiteStatement:clearBindings	()V
    //   225: iload 7
    //   227: ifeq +43 -> 270
    //   230: aload_1
    //   231: aload_2
    //   232: ldc 96
    //   234: iconst_1
    //   235: anewarray 28	java/lang/String
    //   238: dup
    //   239: iconst_0
    //   240: aload 6
    //   242: invokevirtual 245	java/lang/Long:toString	()Ljava/lang/String;
    //   245: aastore
    //   246: invokevirtual 100	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   249: pop
    //   250: aload_1
    //   251: aload_3
    //   252: ldc 96
    //   254: iconst_1
    //   255: anewarray 28	java/lang/String
    //   258: dup
    //   259: iconst_0
    //   260: aload 6
    //   262: invokevirtual 245	java/lang/Long:toString	()Ljava/lang/String;
    //   265: aastore
    //   266: invokevirtual 100	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   269: pop
    //   270: aload_1
    //   271: getstatic 58	com/google/android/gm/provider/MailIndexerService:sTransactionYieldTimeoutMs	I
    //   274: i2l
    //   275: invokevirtual 249	android/database/sqlite/SQLiteDatabase:yieldIfContendedSafely	(J)Z
    //   278: ifne +10 -> 288
    //   281: aload_0
    //   282: getfield 67	com/google/android/gm/provider/MailIndexerService:mIndexerExternallyYielded	Z
    //   285: ifeq -122 -> 163
    //   288: ldc -5
    //   290: ldc -3
    //   292: iconst_1
    //   293: anewarray 255	java/lang/Object
    //   296: dup
    //   297: iconst_0
    //   298: aload_2
    //   299: aastore
    //   300: invokestatic 261	com/google/android/gm/provider/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   303: pop
    //   304: iconst_1
    //   305: istore 8
    //   307: ldc -5
    //   309: iconst_3
    //   310: invokestatic 265	com/google/android/gm/provider/LogUtils:isLoggable	(Ljava/lang/String;I)Z
    //   313: ifeq +39 -> 352
    //   316: ldc -5
    //   318: new 161	java/lang/StringBuilder
    //   321: dup
    //   322: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   325: ldc_w 267
    //   328: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: aload 12
    //   333: invokeinterface 271 1 0
    //   338: invokevirtual 274	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   341: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: iconst_0
    //   345: anewarray 255	java/lang/Object
    //   348: invokestatic 261	com/google/android/gm/provider/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   351: pop
    //   352: aload_1
    //   353: invokevirtual 277	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   356: aload_1
    //   357: invokevirtual 280	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   360: iload 8
    //   362: ireturn
    //   363: iconst_0
    //   364: istore 7
    //   366: goto -146 -> 220
    //   369: astore 13
    //   371: aload 4
    //   373: invokevirtual 244	android/database/sqlite/SQLiteStatement:clearBindings	()V
    //   376: goto -151 -> 225
    //   379: astore_2
    //   380: aload_1
    //   381: invokevirtual 280	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   384: aload_2
    //   385: athrow
    //   386: astore_2
    //   387: aload 4
    //   389: invokevirtual 244	android/database/sqlite/SQLiteStatement:clearBindings	()V
    //   392: aload_2
    //   393: athrow
    //   394: astore 13
    //   396: ldc -5
    //   398: aload 13
    //   400: ldc_w 282
    //   403: iconst_2
    //   404: anewarray 255	java/lang/Object
    //   407: dup
    //   408: iconst_0
    //   409: aload 6
    //   411: aastore
    //   412: dup
    //   413: iconst_1
    //   414: aload_2
    //   415: aastore
    //   416: invokestatic 286	com/google/android/gm/provider/LogUtils:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   419: pop
    //   420: goto -150 -> 270
    //   423: astore_1
    //   424: new 288	android/database/sqlite/SQLiteDatabaseCorruptException
    //   427: dup
    //   428: aload_1
    //   429: invokevirtual 291	java/lang/IllegalStateException:getMessage	()Ljava/lang/String;
    //   432: invokespecial 292	android/database/sqlite/SQLiteDatabaseCorruptException:<init>	(Ljava/lang/String;)V
    //   435: athrow
    //   436: astore_1
    //   437: new 288	android/database/sqlite/SQLiteDatabaseCorruptException
    //   440: dup
    //   441: aload_1
    //   442: invokevirtual 293	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   445: invokespecial 292	android/database/sqlite/SQLiteDatabaseCorruptException:<init>	(Ljava/lang/String;)V
    //   448: athrow
    //   449: astore_1
    //   450: new 288	android/database/sqlite/SQLiteDatabaseCorruptException
    //   453: dup
    //   454: aload_1
    //   455: invokevirtual 291	java/lang/IllegalStateException:getMessage	()Ljava/lang/String;
    //   458: invokespecial 292	android/database/sqlite/SQLiteDatabaseCorruptException:<init>	(Ljava/lang/String;)V
    //   461: athrow
    //   462: astore_1
    //   463: new 288	android/database/sqlite/SQLiteDatabaseCorruptException
    //   466: dup
    //   467: aload_1
    //   468: invokevirtual 293	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   471: invokespecial 292	android/database/sqlite/SQLiteDatabaseCorruptException:<init>	(Ljava/lang/String;)V
    //   474: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	475	0	this	MailIndexerService
    //   0	475	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	475	2	paramString1	String
    //   0	475	3	paramString2	String
    //   0	475	4	paramString3	String
    //   0	475	5	paramString4	String
    //   0	475	6	paramString5	String
    //   190	175	7	i	int
    //   165	196	8	bool1	boolean
    //   1	163	9	bool2	boolean
    //   208	3	10	l	long
    //   6	326	12	localHashSet	java.util.HashSet
    //   369	1	13	localSQLiteDoneException	android.database.sqlite.SQLiteDoneException
    //   394	5	13	localSQLiteException	SQLiteException
    // Exception table:
    //   from	to	target	type
    //   62	91	94	finally
    //   203	210	369	android/database/sqlite/SQLiteDoneException
    //   124	163	379	finally
    //   167	189	379	finally
    //   192	203	379	finally
    //   220	225	379	finally
    //   230	270	379	finally
    //   270	288	379	finally
    //   288	304	379	finally
    //   307	352	379	finally
    //   352	356	379	finally
    //   371	376	379	finally
    //   387	394	379	finally
    //   396	420	379	finally
    //   203	210	386	finally
    //   230	270	394	android/database/sqlite/SQLiteException
    //   356	360	423	java/lang/IllegalStateException
    //   356	360	436	android/database/sqlite/SQLiteException
    //   380	384	449	java/lang/IllegalStateException
    //   380	384	462	android/database/sqlite/SQLiteException
  }
  
  private void deleteMessageFromFtsIndex(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    if (paramString != null) {
      paramSQLiteDatabase.delete("message_fts_table", "docid = ?", new String[] { paramString });
    }
  }
  
  static void deleteSearchIndexTables(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS conversation_fts_table");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS message_fts_table");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS message_fts_table_index");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS conversation_fts_table_index");
  }
  
  private boolean deleteStaleMessageFtsEntries(SQLiteDatabase paramSQLiteDatabase)
  {
    return deleteEntriesFromFtsTable(paramSQLiteDatabase, "message_fts_table", "message_fts_table_index", "messages", "message_fts_table_index.docid = messages.messageId", "messages.messageId is null");
  }
  
  static String getIndexableMessageBodyText(String paramString)
  {
    return Utils.getMessageBodyWithoutElidedText(paramString);
  }
  
  private boolean indexConversationContent(MailEngine paramMailEngine)
  {
    SQLiteDatabase localSQLiteDatabase = mDb;
    boolean bool2 = deleteConversationFtsEntries(localSQLiteDatabase);
    if (bool2) {
      return true;
    }
    if (!spaceAvailableToIndexNewContent()) {
      return false;
    }
    Object localObject2 = Lists.newArrayList();
    Object localObject1 = localSQLiteDatabase.query("conversations", INDEXABLE_CONVERSATION_CONTENT_PROJECTION, "queryId = 0 AND _id NOT IN (SELECT docid from conversation_fts_table_index)", null, null, null, null);
    if (localObject1 == null) {
      return false;
    }
    boolean bool1;
    try
    {
      bool1 = mIndexerExternallyYielded;
      if (bool1) {
        return true;
      }
      while (((Cursor)localObject1).moveToNext())
      {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("_id", Long.valueOf(((Cursor)localObject1).getLong(0)));
        localContentValues.put("subject", ((Cursor)localObject1).getString(1));
        localContentValues.put("snippet", ((Cursor)localObject1).getString(2));
        localContentValues.put("fromAddress", ((Cursor)localObject1).getString(3));
        ((List)localObject2).add(localContentValues);
      }
    }
    finally
    {
      ((Cursor)localObject1).close();
    }
    LogUtils.d("Gmail", "Number of conversations to index: %d", new Object[] { Integer.valueOf(((List)localObject2).size()) });
    localSQLiteDatabase.beginTransactionNonExclusive();
    try
    {
      localObject1 = ((List)localObject2).iterator();
      do
      {
        bool1 = bool2;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (ContentValues)((Iterator)localObject1).next();
        if (localObject2 != null) {
          addConversationToFtsIndex(paramMailEngine, (ContentValues)localObject2);
        }
      } while ((!localSQLiteDatabase.yieldIfContendedSafely(sTransactionYieldTimeoutMs)) && (!mIndexerExternallyYielded));
      LogUtils.d("Gmail", "Yielded for contention while indexing conversations", new Object[0]);
      bool1 = true;
      localSQLiteDatabase.setTransactionSuccessful();
      return bool1;
    }
    catch (SQLiteException paramMailEngine)
    {
      throw new SQLiteDatabaseCorruptException(paramMailEngine.getMessage());
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
  }
  
  /* Error */
  private boolean indexMessageContent(MailEngine paramMailEngine)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 75	com/google/android/gm/provider/MailEngine:mDb	Landroid/database/sqlite/SQLiteDatabase;
    //   4: astore 7
    //   6: aload_0
    //   7: aload 7
    //   9: invokespecial 357	com/google/android/gm/provider/MailIndexerService:deleteStaleMessageFtsEntries	(Landroid/database/sqlite/SQLiteDatabase;)Z
    //   12: istore 5
    //   14: iload 5
    //   16: ifeq +5 -> 21
    //   19: iconst_1
    //   20: ireturn
    //   21: aload_0
    //   22: invokespecial 321	com/google/android/gm/provider/MailIndexerService:spaceAvailableToIndexNewContent	()Z
    //   25: ifne +5 -> 30
    //   28: iconst_0
    //   29: ireturn
    //   30: invokestatic 159	com/google/common/collect/Sets:newHashSet	()Ljava/util/HashSet;
    //   33: astore 9
    //   35: aload 7
    //   37: ldc_w 304
    //   40: iconst_1
    //   41: anewarray 28	java/lang/String
    //   44: dup
    //   45: iconst_0
    //   46: ldc 30
    //   48: aastore
    //   49: ldc_w 359
    //   52: aconst_null
    //   53: aconst_null
    //   54: aconst_null
    //   55: aconst_null
    //   56: invokevirtual 180	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   59: astore 8
    //   61: aload 8
    //   63: ifnonnull +5 -> 68
    //   66: iconst_0
    //   67: ireturn
    //   68: aload_0
    //   69: getfield 67	com/google/android/gm/provider/MailIndexerService:mIndexerExternallyYielded	Z
    //   72: ifeq +5 -> 77
    //   75: iconst_1
    //   76: ireturn
    //   77: aload 8
    //   79: invokeinterface 185 1 0
    //   84: ifeq +35 -> 119
    //   87: aload 9
    //   89: aload 8
    //   91: iconst_0
    //   92: invokeinterface 189 2 0
    //   97: invokestatic 195	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   100: invokeinterface 201 2 0
    //   105: pop
    //   106: goto -29 -> 77
    //   109: astore_1
    //   110: aload 8
    //   112: invokeinterface 204 1 0
    //   117: aload_1
    //   118: athrow
    //   119: aload 8
    //   121: invokeinterface 204 1 0
    //   126: aload 9
    //   128: invokeinterface 271 1 0
    //   133: istore_3
    //   134: ldc -5
    //   136: ldc_w 361
    //   139: iconst_1
    //   140: anewarray 255	java/lang/Object
    //   143: dup
    //   144: iconst_0
    //   145: iload_3
    //   146: invokestatic 347	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   149: aastore
    //   150: invokestatic 261	com/google/android/gm/provider/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   153: pop
    //   154: aload_0
    //   155: invokevirtual 365	com/google/android/gm/provider/MailIndexerService:getContentResolver	()Landroid/content/ContentResolver;
    //   158: getstatic 26	com/google/android/gm/provider/MailIndexerService:GMAIL_FULL_TEXT_SEARCH_MESSAGE_INDEX__BATCH_SIZE	Ljava/lang/String;
    //   161: getstatic 22	com/google/android/gm/provider/MailIndexerService:DEFAULT_MESSAGE_BATCH_SIZE	I
    //   164: invokestatic 371	com/google/android/gsf/Gservices:getInt	(Landroid/content/ContentResolver;Ljava/lang/String;I)I
    //   167: istore 4
    //   169: invokestatic 327	com/google/common/collect/Lists:newArrayList	()Ljava/util/ArrayList;
    //   172: astore 8
    //   174: iconst_0
    //   175: istore_2
    //   176: aload 9
    //   178: invokeinterface 219 1 0
    //   183: astore 9
    //   185: iload 5
    //   187: istore 6
    //   189: aload 9
    //   191: invokeinterface 224 1 0
    //   196: ifeq +253 -> 449
    //   199: aload 9
    //   201: invokeinterface 228 1 0
    //   206: checkcast 191	java/lang/Long
    //   209: astore 10
    //   211: iload_2
    //   212: iconst_1
    //   213: iadd
    //   214: istore_2
    //   215: aload_1
    //   216: getstatic 48	com/google/android/gm/provider/MailIndexerService:INDEXABLE_MESSAGE_CONTENT_PROJECTION	[Ljava/lang/String;
    //   219: aload 10
    //   221: invokevirtual 232	java/lang/Long:longValue	()J
    //   224: invokevirtual 375	com/google/android/gm/provider/MailEngine:getMessageCursorForMessageId	([Ljava/lang/String;J)Landroid/database/Cursor;
    //   227: astore 10
    //   229: aload 10
    //   231: ifnull +195 -> 426
    //   234: aload 10
    //   236: invokeinterface 378 1 0
    //   241: ifeq +178 -> 419
    //   244: new 86	android/content/ContentValues
    //   247: dup
    //   248: invokespecial 88	android/content/ContentValues:<init>	()V
    //   251: astore 11
    //   253: aload 11
    //   255: invokevirtual 381	android/content/ContentValues:clear	()V
    //   258: aload 11
    //   260: ldc 30
    //   262: aload 10
    //   264: iconst_0
    //   265: invokeinterface 189 2 0
    //   270: invokestatic 195	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   273: invokevirtual 332	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   276: aload 11
    //   278: ldc 32
    //   280: aload 10
    //   282: iconst_1
    //   283: invokeinterface 189 2 0
    //   288: invokestatic 195	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   291: invokevirtual 332	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   294: aload 11
    //   296: ldc 34
    //   298: aload 10
    //   300: iconst_2
    //   301: invokeinterface 336 2 0
    //   306: invokevirtual 104	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   309: aload 11
    //   311: ldc 36
    //   313: aload 10
    //   315: iconst_3
    //   316: invokeinterface 336 2 0
    //   321: invokevirtual 104	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   324: aload 10
    //   326: iconst_4
    //   327: invokeinterface 336 2 0
    //   332: astore 12
    //   334: aload 11
    //   336: ldc 40
    //   338: aload 10
    //   340: iconst_5
    //   341: invokeinterface 336 2 0
    //   346: invokevirtual 104	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   349: aload 11
    //   351: ldc 42
    //   353: aload 10
    //   355: bipush 6
    //   357: invokeinterface 336 2 0
    //   362: invokevirtual 104	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   365: aload 11
    //   367: ldc 44
    //   369: aload 10
    //   371: bipush 7
    //   373: invokeinterface 336 2 0
    //   378: invokevirtual 104	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   381: aload 11
    //   383: ldc 46
    //   385: aload 10
    //   387: bipush 8
    //   389: invokeinterface 336 2 0
    //   394: invokevirtual 104	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   397: aload 11
    //   399: ldc 38
    //   401: aload 12
    //   403: invokestatic 383	com/google/android/gm/provider/MailIndexerService:getIndexableMessageBodyText	(Ljava/lang/String;)Ljava/lang/String;
    //   406: invokevirtual 104	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   409: aload 8
    //   411: aload 11
    //   413: invokeinterface 339 2 0
    //   418: pop
    //   419: aload 10
    //   421: invokeinterface 204 1 0
    //   426: aload_0
    //   427: getfield 67	com/google/android/gm/provider/MailIndexerService:mIndexerExternallyYielded	Z
    //   430: ifeq +59 -> 489
    //   433: ldc -5
    //   435: ldc_w 385
    //   438: iconst_0
    //   439: anewarray 255	java/lang/Object
    //   442: invokestatic 261	com/google/android/gm/provider/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   445: pop
    //   446: iconst_1
    //   447: istore 6
    //   449: iload 6
    //   451: ireturn
    //   452: astore 11
    //   454: ldc -5
    //   456: aload 11
    //   458: ldc_w 387
    //   461: iconst_0
    //   462: anewarray 255	java/lang/Object
    //   465: invokestatic 286	com/google/android/gm/provider/LogUtils:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   468: pop
    //   469: aload 10
    //   471: invokeinterface 204 1 0
    //   476: goto -50 -> 426
    //   479: astore_1
    //   480: aload 10
    //   482: invokeinterface 204 1 0
    //   487: aload_1
    //   488: athrow
    //   489: aload 8
    //   491: invokeinterface 342 1 0
    //   496: iload 4
    //   498: if_icmpge +12 -> 510
    //   501: iload 5
    //   503: istore 6
    //   505: iload_2
    //   506: iload_3
    //   507: if_icmpne +133 -> 640
    //   510: ldc -5
    //   512: ldc_w 389
    //   515: iconst_1
    //   516: anewarray 255	java/lang/Object
    //   519: dup
    //   520: iconst_0
    //   521: aload 8
    //   523: invokeinterface 342 1 0
    //   528: invokestatic 347	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   531: aastore
    //   532: invokestatic 261	com/google/android/gm/provider/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   535: pop
    //   536: aload 7
    //   538: invokevirtual 207	android/database/sqlite/SQLiteDatabase:beginTransactionNonExclusive	()V
    //   541: aload 8
    //   543: invokeinterface 348 1 0
    //   548: astore 10
    //   550: iload 5
    //   552: istore 6
    //   554: aload 10
    //   556: invokeinterface 224 1 0
    //   561: ifeq +62 -> 623
    //   564: aload 10
    //   566: invokeinterface 228 1 0
    //   571: checkcast 86	android/content/ContentValues
    //   574: astore 11
    //   576: aload 11
    //   578: ifnull +10 -> 588
    //   581: aload_0
    //   582: aload_1
    //   583: aload 11
    //   585: invokespecial 391	com/google/android/gm/provider/MailIndexerService:addMessageToFtsIndex	(Lcom/google/android/gm/provider/MailEngine;Landroid/content/ContentValues;)V
    //   588: aload 7
    //   590: getstatic 58	com/google/android/gm/provider/MailIndexerService:sTransactionYieldTimeoutMs	I
    //   593: i2l
    //   594: invokevirtual 249	android/database/sqlite/SQLiteDatabase:yieldIfContendedSafely	(J)Z
    //   597: ifne +10 -> 607
    //   600: aload_0
    //   601: getfield 67	com/google/android/gm/provider/MailIndexerService:mIndexerExternallyYielded	Z
    //   604: ifeq -54 -> 550
    //   607: ldc -5
    //   609: ldc_w 385
    //   612: iconst_0
    //   613: anewarray 255	java/lang/Object
    //   616: invokestatic 261	com/google/android/gm/provider/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   619: pop
    //   620: iconst_1
    //   621: istore 6
    //   623: aload 7
    //   625: invokevirtual 277	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   628: aload 7
    //   630: invokevirtual 280	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   633: aload 8
    //   635: invokeinterface 392 1 0
    //   640: iload 6
    //   642: istore 5
    //   644: iload 6
    //   646: ifeq -461 -> 185
    //   649: goto -200 -> 449
    //   652: astore_1
    //   653: new 288	android/database/sqlite/SQLiteDatabaseCorruptException
    //   656: dup
    //   657: aload_1
    //   658: invokevirtual 293	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   661: invokespecial 292	android/database/sqlite/SQLiteDatabaseCorruptException:<init>	(Ljava/lang/String;)V
    //   664: athrow
    //   665: astore_1
    //   666: aload 7
    //   668: invokevirtual 280	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   671: aload_1
    //   672: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	673	0	this	MailIndexerService
    //   0	673	1	paramMailEngine	MailEngine
    //   175	333	2	i	int
    //   133	375	3	j	int
    //   167	332	4	k	int
    //   12	631	5	bool1	boolean
    //   187	458	6	bool2	boolean
    //   4	663	7	localSQLiteDatabase	SQLiteDatabase
    //   59	575	8	localObject1	Object
    //   33	167	9	localObject2	Object
    //   209	356	10	localObject3	Object
    //   251	161	11	localContentValues1	ContentValues
    //   452	5	11	localCorruptedMessageException	CompressedMessageCursor.CorruptedMessageException
    //   574	10	11	localContentValues2	ContentValues
    //   332	70	12	str	String
    // Exception table:
    //   from	to	target	type
    //   77	106	109	finally
    //   234	419	452	com/google/android/gm/provider/CompressedMessageCursor$CorruptedMessageException
    //   234	419	479	finally
    //   454	469	479	finally
    //   581	588	652	android/database/sqlite/SQLiteException
    //   541	550	665	finally
    //   554	576	665	finally
    //   581	588	665	finally
    //   588	607	665	finally
    //   607	620	665	finally
    //   623	628	665	finally
    //   653	665	665	finally
  }
  
  static void onContentProviderAccess(String paramString)
  {
    MailIndexerService localMailIndexerService = sIndexerInstance;
    if ((localMailIndexerService != null) && (TextUtils.equals(paramString, mAccount)))
    {
      LogUtils.d("Gmail", "Database access which requesting indexer delay for account: %s", new Object[] { paramString });
      mIndexerExternallyYielded = true;
    }
  }
  
  private void resetFtsTables(MailEngine paramMailEngine)
  {
    paramMailEngine = mDb;
    LogUtils.w("Gmail", "Recreating search index tables", new Object[0]);
    paramMailEngine.beginTransaction();
    try
    {
      createSearchIndexTables(paramMailEngine);
      paramMailEngine.setTransactionSuccessful();
      LogUtils.w("Gmail", "Search index tables created successfully", new Object[0]);
      return;
    }
    finally
    {
      paramMailEngine.endTransaction();
    }
  }
  
  private boolean spaceAvailableToIndexNewContent()
  {
    File localFile = getFilesDir();
    long l1 = localFile.getUsableSpace();
    boolean bool2;
    if (Gmail.deviceHasLargeDataPartition(this))
    {
      if (l1 >= Gservices.getLong(getContentResolver(), "gmail_large_data_partition_min_indexing_available_space", 1000000000L))
      {
        bool2 = true;
        return bool2;
      }
      return false;
    }
    long l2 = localFile.getTotalSpace();
    if ((float)l1 >= (float)l2 * 0.3F) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (bool1) {
        break;
      }
      LogUtils.w("Gmail", "Data space requirement not met for indexing. Total: %d, Avail: %d", new Object[] { Long.valueOf(l2), Long.valueOf(l1) });
      return bool1;
    }
  }
  
  static void yieldForTesting()
  {
    MailIndexerService localMailIndexerService = sIndexerInstance;
    if (localMailIndexerService != null) {
      mIndexerExternallyYielded = true;
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (sTransactionYieldTimeoutMs == -1) {
      sTransactionYieldTimeoutMs = getResources().getInteger(2131361852);
    }
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    String str = paramIntent.getAction();
    LogUtils.d("Gmail", "MailIndexerService handling intent with action: %s", new Object[] { str });
    if ("com.google.android.gm.intent.provider.INDEX_MESSAGE_CONTENT".equals(str)) {}
    try
    {
      mIndexerExternallyYielded = false;
      mAccount = paramIntent.getStringExtra("account");
      sIndexerInstance = this;
      Process.setThreadPriority(10);
      paramIntent = MailEngine.getOrMakeMailEngineSync(this, mAccount);
      if (paramIntent == null)
      {
        LogUtils.w("Gmail", "No MailEngine for account: %s", new Object[] { mAccount });
        return;
      }
      if (paramIntent.backgroundTasksDisabledForTesting())
      {
        LogUtils.w("Gmail", "Background tasks have been disabled for testing", new Object[0]);
        paramIntent.cancelScheduledIndexRun();
        return;
      }
      if (!paramIntent.isFullTextSearchEnabled())
      {
        LogUtils.w("Gmail", "Full text search has been disabled for this account: %s", new Object[] { mAccount });
        paramIntent.cancelScheduledIndexRun();
        return;
      }
      try
      {
        boolean bool2 = indexMessageContent(paramIntent);
        boolean bool1 = bool2;
        if (!bool2) {
          bool1 = indexConversationContent(paramIntent);
        }
        if (!bool1)
        {
          LogUtils.w("Gmail", "Successful index run, cancel next scheduled index run", new Object[0]);
          paramIntent.cancelScheduledIndexRun();
        }
      }
      catch (SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException)
      {
        for (;;)
        {
          LogUtils.e("Gmail", "Database appears to be corrupt.  Canceling index pass", new Object[] { localSQLiteDatabaseCorruptException });
          paramIntent.cancelScheduledIndexRun();
          resetFtsTables(paramIntent);
        }
      }
      return;
    }
    finally
    {
      sIndexerInstance = null;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailIndexerService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */