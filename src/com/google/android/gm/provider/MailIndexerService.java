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
import cty;
import cvb;
import dfz;
import dpr;
import dpy;
import dri;
import drp;
import ghz;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MailIndexerService
  extends IntentService
{
  private static int a = 50;
  private static String b = "gmail_full_text_search_message_index_batch_size";
  private static final String[] c = { "messageId", "conversation", "subject", "snippet", "body", "fromAddress", "toAddresses", "ccAddresses", "bccAddresses" };
  private static final String[] d = { "_id", "subject", "snippet" };
  private static final String[] e = { "docid" };
  private static final String[] f = { "tbl_name" };
  private static volatile MailIndexerService g;
  private static int j = -1;
  private String h;
  private volatile boolean i = false;
  
  public MailIndexerService()
  {
    super("MailIndexerService");
  }
  
  public static void a(SQLiteDatabase paramSQLiteDatabase)
  {
    cty.a(paramSQLiteDatabase, "conversation_fts_table");
    cty.a(paramSQLiteDatabase, "message_fts_table");
    cty.a(paramSQLiteDatabase, "message_fts_table_index");
    cty.a(paramSQLiteDatabase, "conversation_fts_table_index");
  }
  
  public static void a(String paramString)
  {
    MailIndexerService localMailIndexerService = g;
    if ((localMailIndexerService != null) && (TextUtils.equals(paramString, h)))
    {
      dri.b("Gmail", "Database access which requesting indexer delay for account: %s", new Object[] { paramString });
      i = true;
    }
  }
  
  private final boolean a()
  {
    File localFile = getFilesDir();
    long l1 = localFile.getUsableSpace();
    if (dpy.b(this)) {
      return l1 >= ghz.a(getContentResolver(), "gmail_large_data_partition_min_indexing_available_space", 1000000000L);
    }
    long l2 = localFile.getTotalSpace();
    if ((float)l1 >= (float)l2 * 0.3F) {}
    for (boolean bool = true;; bool = false)
    {
      if (!bool) {
        dri.d("Gmail", "Data space requirement not met for indexing. Total: %d, Avail: %d", new Object[] { Long.valueOf(l2), Long.valueOf(l1) });
      }
      return bool;
    }
  }
  
  private static boolean a(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    boolean bool = true;
    paramSQLiteDatabase = paramSQLiteDatabase.query(true, "sqlite_master", f, "tbl_name = ?", new String[] { paramString }, null, null, null, null);
    if (paramSQLiteDatabase != null) {
      try
      {
        int k = paramSQLiteDatabase.getCount();
        if (k > 0) {
          return bool;
        }
        bool = false;
        return false;
      }
      finally
      {
        paramSQLiteDatabase.close();
      }
    }
  }
  
  /* Error */
  private final boolean a(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    // Byte code:
    //   0: new 179	java/util/HashSet
    //   3: dup
    //   4: invokespecial 181	java/util/HashSet:<init>	()V
    //   7: astore 11
    //   9: aload_1
    //   10: new 183	java/lang/StringBuilder
    //   13: dup
    //   14: aload_3
    //   15: invokestatic 186	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   18: invokevirtual 189	java/lang/String:length	()I
    //   21: bipush 23
    //   23: iadd
    //   24: aload 4
    //   26: invokestatic 186	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   29: invokevirtual 189	java/lang/String:length	()I
    //   32: iadd
    //   33: aload 5
    //   35: invokestatic 186	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   38: invokevirtual 189	java/lang/String:length	()I
    //   41: iadd
    //   42: invokespecial 192	java/lang/StringBuilder:<init>	(I)V
    //   45: aload_3
    //   46: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: ldc -58
    //   51: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload 4
    //   56: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc -56
    //   61: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload 5
    //   66: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: ldc -54
    //   71: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: getstatic 57	com/google/android/gm/provider/MailIndexerService:e	[Ljava/lang/String;
    //   80: aload 6
    //   82: aconst_null
    //   83: aconst_null
    //   84: aconst_null
    //   85: aconst_null
    //   86: invokevirtual 209	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   89: astore 4
    //   91: aload 4
    //   93: invokeinterface 212 1 0
    //   98: ifeq +35 -> 133
    //   101: aload 11
    //   103: aload 4
    //   105: iconst_0
    //   106: invokeinterface 216 2 0
    //   111: invokestatic 148	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   114: invokeinterface 222 2 0
    //   119: pop
    //   120: goto -29 -> 91
    //   123: astore_1
    //   124: aload 4
    //   126: invokeinterface 170 1 0
    //   131: aload_1
    //   132: athrow
    //   133: aload 4
    //   135: invokeinterface 170 1 0
    //   140: aload_0
    //   141: getfield 72	com/google/android/gm/provider/MailIndexerService:i	Z
    //   144: ifeq +5 -> 149
    //   147: iconst_1
    //   148: ireturn
    //   149: aload_1
    //   150: invokevirtual 225	android/database/sqlite/SQLiteDatabase:beginTransactionNonExclusive	()V
    //   153: aload_1
    //   154: new 183	java/lang/StringBuilder
    //   157: dup
    //   158: aload_2
    //   159: invokestatic 186	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   162: invokevirtual 189	java/lang/String:length	()I
    //   165: bipush 37
    //   167: iadd
    //   168: invokespecial 192	java/lang/StringBuilder:<init>	(I)V
    //   171: ldc -29
    //   173: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload_2
    //   177: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: ldc -27
    //   182: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokevirtual 233	android/database/sqlite/SQLiteDatabase:compileStatement	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;
    //   191: astore 4
    //   193: aload 11
    //   195: invokeinterface 237 1 0
    //   200: astore 5
    //   202: aload 5
    //   204: invokeinterface 242 1 0
    //   209: ifeq +292 -> 501
    //   212: aload 5
    //   214: invokeinterface 246 1 0
    //   219: checkcast 144	java/lang/Long
    //   222: astore 6
    //   224: iconst_0
    //   225: istore 7
    //   227: aload 4
    //   229: iconst_1
    //   230: aload 6
    //   232: invokevirtual 249	java/lang/Long:longValue	()J
    //   235: invokevirtual 255	android/database/sqlite/SQLiteStatement:bindLong	(IJ)V
    //   238: aload 4
    //   240: invokevirtual 258	android/database/sqlite/SQLiteStatement:simpleQueryForLong	()J
    //   243: lstore 8
    //   245: lload 8
    //   247: lconst_0
    //   248: lcmp
    //   249: ifle +171 -> 420
    //   252: iconst_1
    //   253: istore 7
    //   255: aload 4
    //   257: invokevirtual 261	android/database/sqlite/SQLiteStatement:clearBindings	()V
    //   260: iload 7
    //   262: ifeq +45 -> 307
    //   265: aload_1
    //   266: aload_2
    //   267: ldc_w 263
    //   270: iconst_1
    //   271: anewarray 29	java/lang/String
    //   274: dup
    //   275: iconst_0
    //   276: aload 6
    //   278: invokevirtual 264	java/lang/Long:toString	()Ljava/lang/String;
    //   281: aastore
    //   282: invokevirtual 268	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   285: pop
    //   286: aload_1
    //   287: aload_3
    //   288: ldc_w 263
    //   291: iconst_1
    //   292: anewarray 29	java/lang/String
    //   295: dup
    //   296: iconst_0
    //   297: aload 6
    //   299: invokevirtual 264	java/lang/Long:toString	()Ljava/lang/String;
    //   302: aastore
    //   303: invokevirtual 268	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   306: pop
    //   307: aload_1
    //   308: getstatic 63	com/google/android/gm/provider/MailIndexerService:j	I
    //   311: i2l
    //   312: invokevirtual 272	android/database/sqlite/SQLiteDatabase:yieldIfContendedSafely	(J)Z
    //   315: ifne +10 -> 325
    //   318: aload_0
    //   319: getfield 72	com/google/android/gm/provider/MailIndexerService:i	Z
    //   322: ifeq -120 -> 202
    //   325: ldc 98
    //   327: ldc_w 274
    //   330: iconst_1
    //   331: anewarray 102	java/lang/Object
    //   334: dup
    //   335: iconst_0
    //   336: aload_2
    //   337: aastore
    //   338: invokestatic 107	dri:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   341: pop
    //   342: iconst_1
    //   343: istore 10
    //   345: ldc 98
    //   347: iconst_3
    //   348: invokestatic 277	dri:a	(Ljava/lang/String;I)Z
    //   351: ifeq +45 -> 396
    //   354: aload 11
    //   356: invokeinterface 280 1 0
    //   361: istore 7
    //   363: ldc 98
    //   365: new 183	java/lang/StringBuilder
    //   368: dup
    //   369: bipush 48
    //   371: invokespecial 192	java/lang/StringBuilder:<init>	(I)V
    //   374: ldc_w 282
    //   377: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: iload 7
    //   382: invokevirtual 285	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   385: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   388: iconst_0
    //   389: anewarray 102	java/lang/Object
    //   392: invokestatic 107	dri:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   395: pop
    //   396: aload_1
    //   397: invokevirtual 288	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   400: aload_1
    //   401: invokevirtual 291	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   404: iload 10
    //   406: ireturn
    //   407: astore_1
    //   408: new 293	android/database/sqlite/SQLiteDatabaseCorruptException
    //   411: dup
    //   412: aload_1
    //   413: invokevirtual 298	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   416: invokespecial 299	android/database/sqlite/SQLiteDatabaseCorruptException:<init>	(Ljava/lang/String;)V
    //   419: athrow
    //   420: iconst_0
    //   421: istore 7
    //   423: goto -168 -> 255
    //   426: astore 12
    //   428: aload 4
    //   430: invokevirtual 261	android/database/sqlite/SQLiteStatement:clearBindings	()V
    //   433: goto -173 -> 260
    //   436: astore_2
    //   437: aload_1
    //   438: invokevirtual 291	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   441: aload_2
    //   442: athrow
    //   443: astore_2
    //   444: aload 4
    //   446: invokevirtual 261	android/database/sqlite/SQLiteStatement:clearBindings	()V
    //   449: aload_2
    //   450: athrow
    //   451: astore 12
    //   453: ldc 98
    //   455: aload 12
    //   457: ldc_w 301
    //   460: iconst_2
    //   461: anewarray 102	java/lang/Object
    //   464: dup
    //   465: iconst_0
    //   466: aload 6
    //   468: aastore
    //   469: dup
    //   470: iconst_1
    //   471: aload_2
    //   472: aastore
    //   473: invokestatic 304	dri:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   476: pop
    //   477: goto -170 -> 307
    //   480: astore_1
    //   481: new 293	android/database/sqlite/SQLiteDatabaseCorruptException
    //   484: dup
    //   485: aload_1
    //   486: invokevirtual 298	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   489: invokespecial 299	android/database/sqlite/SQLiteDatabaseCorruptException:<init>	(Ljava/lang/String;)V
    //   492: athrow
    //   493: astore_1
    //   494: goto -86 -> 408
    //   497: astore_1
    //   498: goto -17 -> 481
    //   501: iconst_0
    //   502: istore 10
    //   504: goto -159 -> 345
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	507	0	this	MailIndexerService
    //   0	507	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	507	2	paramString1	String
    //   0	507	3	paramString2	String
    //   0	507	4	paramString3	String
    //   0	507	5	paramString4	String
    //   0	507	6	paramString5	String
    //   225	197	7	k	int
    //   243	3	8	l	long
    //   343	160	10	bool	boolean
    //   7	348	11	localHashSet	HashSet
    //   426	1	12	localSQLiteDoneException	android.database.sqlite.SQLiteDoneException
    //   451	5	12	localSQLiteException	SQLiteException
    // Exception table:
    //   from	to	target	type
    //   91	120	123	finally
    //   400	404	407	java/lang/IllegalStateException
    //   238	245	426	android/database/sqlite/SQLiteDoneException
    //   153	202	436	finally
    //   202	224	436	finally
    //   227	238	436	finally
    //   255	260	436	finally
    //   265	307	436	finally
    //   307	325	436	finally
    //   325	342	436	finally
    //   345	396	436	finally
    //   396	400	436	finally
    //   428	433	436	finally
    //   444	451	436	finally
    //   453	477	436	finally
    //   238	245	443	finally
    //   265	307	451	android/database/sqlite/SQLiteException
    //   437	441	480	java/lang/IllegalStateException
    //   400	404	493	android/database/sqlite/SQLiteException
    //   437	441	497	android/database/sqlite/SQLiteException
  }
  
  private final boolean a(drp paramdrp)
  {
    SQLiteDatabase localSQLiteDatabase = p;
    boolean bool1 = a(localSQLiteDatabase, "message_fts_table", "message_fts_table_index", "messages", "message_fts_table_index.docid = messages.messageId", "messages.messageId is null");
    boolean bool2;
    if (bool1) {
      bool2 = true;
    }
    Object localObject2;
    Object localObject1;
    int m;
    int n;
    int k;
    do
    {
      return bool2;
      if (!a()) {
        return false;
      }
      localObject2 = new HashSet();
      localObject1 = localSQLiteDatabase.query("messages", new String[] { "messageId" }, "queryId = 0 AND messageId NOT IN (SELECT docid from message_fts_table_index)", null, null, null, null);
      if (localObject1 == null) {
        return false;
      }
      if (i) {
        return true;
      }
      try
      {
        while (((Cursor)localObject1).moveToNext()) {
          ((Set)localObject2).add(Long.valueOf(((Cursor)localObject1).getLong(0)));
        }
        m = ((Set)localObject2).size();
      }
      finally
      {
        ((Cursor)localObject1).close();
      }
      dri.b("Gmail", "Number of messages to index: %d", new Object[] { Integer.valueOf(m) });
      n = ghz.a(getContentResolver(), b, a);
      localObject1 = new ArrayList();
      localObject2 = ((Set)localObject2).iterator();
      k = 0;
      bool2 = bool1;
    } while (!((Iterator)localObject2).hasNext());
    Object localObject3 = (Long)((Iterator)localObject2).next();
    k += 1;
    localObject3 = paramdrp.b(c, ((Long)localObject3).longValue());
    if (localObject3 != null) {}
    Object localObject4;
    try
    {
      if (((Cursor)localObject3).moveToFirst())
      {
        ContentValues localContentValues1 = new ContentValues(9);
        localContentValues1.put("messageId", Long.valueOf(((Cursor)localObject3).getLong(0)));
        localContentValues1.put("conversation", Long.valueOf(((Cursor)localObject3).getLong(1)));
        localContentValues1.put("subject", ((Cursor)localObject3).getString(2));
        localContentValues1.put("snippet", ((Cursor)localObject3).getString(3));
        localObject4 = ((Cursor)localObject3).getString(4);
        localContentValues1.put("fromAddress", ((Cursor)localObject3).getString(5));
        localContentValues1.put("toAddresses", ((Cursor)localObject3).getString(6));
        localContentValues1.put("ccAddresses", ((Cursor)localObject3).getString(7));
        localContentValues1.put("bccAddresses", ((Cursor)localObject3).getString(8));
        localContentValues1.put("body", cvb.a((String)localObject4));
        ((List)localObject1).add(localContentValues1);
      }
    }
    catch (dpr localdpr)
    {
      for (;;)
      {
        dri.e("Gmail", localdpr, "Unable to decompress the message body for indexing", new Object[0]);
        ((Cursor)localObject3).close();
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        dri.e("Gmail", localOutOfMemoryError, "Out of memory error when loading message body", new Object[0]);
        bool2 = ((List)localObject1).isEmpty();
        if (!bool2) {
          return bool1;
        }
        ((Cursor)localObject3).close();
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        dri.e("Gmail", localIllegalStateException, "IllegalStateExcption reading message from cursor", new Object[0]);
        ((Cursor)localObject3).close();
      }
    }
    finally
    {
      ((Cursor)localObject3).close();
    }
    if (i)
    {
      dri.b("Gmail", "Yielded for contention, while indexing messages", new Object[0]);
      return true;
    }
    if ((((List)localObject1).size() >= n) || (k == m))
    {
      dri.b("Gmail", "Indexing batch with %d messages", new Object[] { Integer.valueOf(((List)localObject1).size()) });
      localSQLiteDatabase.beginTransactionNonExclusive();
    }
    label1004:
    label1007:
    for (;;)
    {
      try
      {
        localObject3 = ((List)localObject1).iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break label1007;
        }
        ContentValues localContentValues2 = (ContentValues)((Iterator)localObject3).next();
        if (localContentValues2 != null) {}
        try
        {
          localObject4 = p;
          if (localObject4 != null)
          {
            bool2 = ((SQLiteDatabase)localObject4).isOpen();
            if (bool2) {}
          }
          else
          {
            if ((!localSQLiteDatabase.yieldIfContendedSafely(j)) && (!i)) {
              continue;
            }
            dri.b("Gmail", "Yielded for contention, while indexing messages", new Object[0]);
            bool1 = true;
            localSQLiteDatabase.setTransactionSuccessful();
            localSQLiteDatabase.endTransaction();
            ((List)localObject1).clear();
            if (!bool1) {
              break label1004;
            }
            return bool1;
          }
          if (!paramdrp.u()) {
            continue;
          }
          ContentValues localContentValues3 = new ContentValues();
          ContentValues localContentValues4 = new ContentValues();
          String str = localContentValues2.getAsString("messageId");
          if (str != null) {
            ((SQLiteDatabase)localObject4).delete("message_fts_table", "docid = ?", new String[] { str });
          }
          if (str != null)
          {
            localContentValues3.put("docid", str);
            localContentValues4.put("docid", str);
          }
          localContentValues3.put("conversation", localContentValues2.getAsString("conversation"));
          localContentValues3.put("subject", localContentValues2.getAsString("subject"));
          localContentValues3.put("snippet", localContentValues2.getAsString("snippet"));
          str = localContentValues2.getAsString("body");
          if (str != null) {
            localContentValues3.put("body", str);
          }
          localContentValues3.put("fromAddress", localContentValues2.getAsString("fromAddress"));
          localContentValues3.put("toAddresses", localContentValues2.getAsString("toAddresses"));
          localContentValues3.put("ccAddresses", localContentValues2.getAsString("ccAddresses"));
          localContentValues3.put("bccAddresses", localContentValues2.getAsString("bccAddresses"));
          ((SQLiteDatabase)localObject4).replaceOrThrow("message_fts_table", null, localContentValues3);
          ((SQLiteDatabase)localObject4).replaceOrThrow("message_fts_table_index", null, localContentValues4);
          continue;
          paramdrp = finally;
        }
        catch (SQLiteException paramdrp)
        {
          throw new SQLiteDatabaseCorruptException(paramdrp.getMessage());
        }
        continue;
      }
      finally
      {
        localSQLiteDatabase.endTransaction();
      }
      break;
    }
  }
  
  public static void b(SQLiteDatabase paramSQLiteDatabase)
  {
    a(paramSQLiteDatabase);
    c(paramSQLiteDatabase);
  }
  
  private final boolean b(drp paramdrp)
  {
    SQLiteDatabase localSQLiteDatabase = p;
    boolean bool1 = a(localSQLiteDatabase, "conversation_fts_table", "conversation_fts_table_index", "conversations", "conversation_fts_table_index.docid = conversations._id", "conversations._id is null");
    if (bool1) {
      return true;
    }
    if (!a()) {
      return false;
    }
    Object localObject2 = new ArrayList();
    Object localObject1 = localSQLiteDatabase.query("conversations", d, "queryId = 0 AND _id NOT IN (SELECT docid from conversation_fts_table_index)", null, null, null, null);
    if (localObject1 == null) {
      return false;
    }
    Object localObject3;
    try
    {
      boolean bool2 = i;
      if (bool2) {
        return true;
      }
      while (((Cursor)localObject1).moveToNext())
      {
        localObject3 = new ContentValues();
        ((ContentValues)localObject3).put("_id", Long.valueOf(((Cursor)localObject1).getLong(0)));
        ((ContentValues)localObject3).put("subject", ((Cursor)localObject1).getString(1));
        ((ContentValues)localObject3).put("snippet", ((Cursor)localObject1).getString(2));
        ((ContentValues)localObject3).put("fromAddress", "");
        ((List)localObject2).add(localObject3);
      }
    }
    finally
    {
      ((Cursor)localObject1).close();
    }
    dri.b("Gmail", "Number of conversations to index: %d", new Object[] { Integer.valueOf(((List)localObject2).size()) });
    localSQLiteDatabase.beginTransactionNonExclusive();
    try
    {
      localObject1 = ((List)localObject2).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ContentValues)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject3 = p;
          if ((localObject3 != null) && (((SQLiteDatabase)localObject3).isOpen())) {}
        }
        else
        {
          label288:
          if ((!localSQLiteDatabase.yieldIfContendedSafely(j)) && (!i)) {
            break label471;
          }
          dri.b("Gmail", "Yielded for contention while indexing conversations", new Object[0]);
          bool1 = true;
        }
      }
      for (;;)
      {
        localSQLiteDatabase.setTransactionSuccessful();
        return bool1;
        if (!paramdrp.u()) {
          break label288;
        }
        ContentValues localContentValues1 = new ContentValues();
        ContentValues localContentValues2 = new ContentValues();
        String str = ((ContentValues)localObject2).getAsString("_id");
        ((SQLiteDatabase)localObject3).delete("conversation_fts_table", "docid = ?", new String[] { str });
        localContentValues1.put("docid", str);
        localContentValues2.put("docid", str);
        localContentValues1.put("subject", ((ContentValues)localObject2).getAsString("subject"));
        localContentValues1.put("snippet", ((ContentValues)localObject2).getAsString("snippet"));
        localContentValues1.put("fromAddress", ((ContentValues)localObject2).getAsString("fromAddress"));
        ((SQLiteDatabase)localObject3).replaceOrThrow("conversation_fts_table", null, localContentValues1);
        ((SQLiteDatabase)localObject3).replaceOrThrow("conversation_fts_table_index", null, localContentValues2);
        break label288;
        label471:
        break;
      }
    }
    catch (SQLiteException paramdrp)
    {
      throw new SQLiteDatabaseCorruptException(paramdrp.getMessage());
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
  }
  
  public static void c(SQLiteDatabase paramSQLiteDatabase)
  {
    if (!a(paramSQLiteDatabase, "conversation_fts_table")) {
      paramSQLiteDatabase.execSQL("CREATE VIRTUAL TABLE conversation_fts_table USING FTS4 (subject TEXT, snippet TEXT, fromAddress TEXT, )");
    }
    if (!a(paramSQLiteDatabase, "message_fts_table")) {
      paramSQLiteDatabase.execSQL("CREATE VIRTUAL TABLE message_fts_table USING FTS4 (conversation TEXT, subject TEXT, snippet TEXT, body TEXT, fromAddress TEXT, toAddresses TEXT, ccAddresses TEXT, bccAddresses TEXT, )");
    }
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS message_fts_table_index(docid INTEGER PRIMARY KEY)");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS conversation_fts_table_index(docid INTEGER PRIMARY KEY)");
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (j == -1) {
      j = getResources().getInteger(dfz.e);
    }
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    String str = paramIntent.getAction();
    dri.b("Gmail", "MailIndexerService handling intent with action: %s", new Object[] { str });
    if ("com.google.android.gm.intent.provider.INDEX_MESSAGE_CONTENT".equals(str)) {}
    for (;;)
    {
      try
      {
        i = false;
        h = paramIntent.getStringExtra("account");
        g = this;
        Process.setThreadPriority(10);
        paramIntent = drp.b(this, h);
        if (paramIntent == null)
        {
          dri.d("Gmail", "No MailEngine for account: %s", new Object[] { h });
          g = null;
          return;
        }
        if (h)
        {
          dri.d("Gmail", "Background tasks have been disabled for testing", new Object[0]);
          paramIntent.w();
          g = null;
          return;
        }
        if (!paramIntent.u())
        {
          dri.d("Gmail", "Full text search has been disabled for this account: %s", new Object[] { h });
          paramIntent.w();
          g = null;
          return;
        }
      }
      finally
      {
        try
        {
          boolean bool2;
          boolean bool1;
          b(paramIntent);
          paramIntent.setTransactionSuccessful();
          dri.d("Gmail", "Search index tables created successfully", new Object[0]);
          paramIntent.endTransaction();
          continue;
        }
        finally
        {
          paramIntent.endTransaction();
        }
        paramIntent = finally;
        g = null;
      }
      try
      {
        c(p);
        bool2 = a(paramIntent);
        bool1 = bool2;
        if (!bool2) {
          bool1 = b(paramIntent);
        }
        if (!bool1)
        {
          dri.b("Gmail", "Successful index run, cancel next scheduled index run", new Object[0]);
          paramIntent.w();
        }
        g = null;
        return;
      }
      catch (SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException)
      {
        dri.e("Gmail", "Database appears to be corrupt.  Canceling index pass", new Object[] { localSQLiteDatabaseCorruptException });
        paramIntent.w();
        paramIntent = p;
        dri.d("Gmail", "Recreating search index tables", new Object[0]);
        paramIntent.beginTransaction();
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailIndexerService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */