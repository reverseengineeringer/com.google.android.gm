import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.HashMap;
import java.util.Map;

public final class dpu
{
  private final SQLiteDatabase a;
  private final drj b;
  
  protected dpu(SQLiteDatabase paramSQLiteDatabase, drj paramdrj)
  {
    a = paramSQLiteDatabase;
    b = paramdrj;
  }
  
  public final Map<Long, drg> a(long paramLong1, long paramLong2)
  {
    HashMap localHashMap = new HashMap();
    Object localObject = a;
    String str1 = Long.toString(paramLong2);
    String str2 = Long.toString(paramLong1);
    localObject = ((SQLiteDatabase)localObject).query("conversation_labels AS cl JOIN labels AS l ON cl.labels_id = l._id", new String[] { "labels_id", "isZombie", "sortMessageId", "date" }, "queryId = ? AND conversation_id = ? AND canonicalName NOT LIKE '^^unseen-%'", new String[] { str1, str2 }, null, null, null);
    for (;;)
    {
      try
      {
        if (!((Cursor)localObject).moveToNext()) {
          break;
        }
        paramLong1 = ((Cursor)localObject).getLong(0);
        boolean bool;
        if (((Cursor)localObject).getInt(1) != 0)
        {
          bool = true;
          localHashMap.put(Long.valueOf(paramLong1), new drg(((Cursor)localObject).getLong(2), ((Cursor)localObject).getLong(3), bool));
        }
        else
        {
          bool = false;
        }
      }
      finally
      {
        ((Cursor)localObject).close();
      }
    }
    ((Cursor)localObject).close();
    return localMap;
  }
  
  /* Error */
  final void a(long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 15	dpu:a	Landroid/database/sqlite/SQLiteDatabase;
    //   4: invokevirtual 86	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   7: ifne +13 -> 20
    //   10: new 88	java/lang/IllegalStateException
    //   13: dup
    //   14: ldc 90
    //   16: invokespecial 93	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   19: athrow
    //   20: ldc 95
    //   22: ldc 97
    //   24: iconst_1
    //   25: anewarray 4	java/lang/Object
    //   28: dup
    //   29: iconst_0
    //   30: lload_1
    //   31: invokestatic 66	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   34: aastore
    //   35: invokestatic 102	dri:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   38: pop
    //   39: aload_0
    //   40: getfield 15	dpu:a	Landroid/database/sqlite/SQLiteDatabase;
    //   43: ldc 104
    //   45: iconst_1
    //   46: anewarray 32	java/lang/String
    //   49: dup
    //   50: iconst_0
    //   51: ldc 106
    //   53: aastore
    //   54: ldc 108
    //   56: iconst_1
    //   57: anewarray 32	java/lang/String
    //   60: dup
    //   61: iconst_0
    //   62: lload_1
    //   63: invokestatic 110	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   66: aastore
    //   67: ldc 106
    //   69: aconst_null
    //   70: aconst_null
    //   71: invokevirtual 48	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   74: astore 10
    //   76: new 112	java/util/HashSet
    //   79: dup
    //   80: invokespecial 113	java/util/HashSet:<init>	()V
    //   83: astore 11
    //   85: aload 10
    //   87: invokeinterface 54 1 0
    //   92: ifeq +37 -> 129
    //   95: aload 11
    //   97: aload 10
    //   99: iconst_0
    //   100: invokeinterface 58 2 0
    //   105: invokestatic 66	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   108: invokeinterface 119 2 0
    //   113: pop
    //   114: goto -29 -> 85
    //   117: astore 11
    //   119: aload 10
    //   121: invokeinterface 80 1 0
    //   126: aload 11
    //   128: athrow
    //   129: aload 10
    //   131: invokeinterface 80 1 0
    //   136: iload 4
    //   138: ifeq +15 -> 153
    //   141: aload 11
    //   143: lconst_0
    //   144: invokestatic 66	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   147: invokeinterface 119 2 0
    //   152: pop
    //   153: new 121	dpt
    //   156: dup
    //   157: invokespecial 122	dpt:<init>	()V
    //   160: astore 12
    //   162: aload 11
    //   164: invokeinterface 126 1 0
    //   169: astore 13
    //   171: aload 13
    //   173: invokeinterface 131 1 0
    //   178: ifeq +311 -> 489
    //   181: aload 13
    //   183: invokeinterface 135 1 0
    //   188: checkcast 24	java/lang/Long
    //   191: invokevirtual 139	java/lang/Long:longValue	()J
    //   194: lstore 8
    //   196: new 141	android/util/TimingLogger
    //   199: dup
    //   200: ldc 95
    //   202: ldc -113
    //   204: invokespecial 146	android/util/TimingLogger:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   207: astore 11
    //   209: lload_1
    //   210: invokestatic 28	java/lang/Long:toString	(J)Ljava/lang/String;
    //   213: astore 15
    //   215: lload 8
    //   217: invokestatic 28	java/lang/Long:toString	(J)Ljava/lang/String;
    //   220: astore 16
    //   222: aload_0
    //   223: lload_1
    //   224: lload 8
    //   226: invokevirtual 148	dpu:a	(JJ)Ljava/util/Map;
    //   229: astore 14
    //   231: aload 11
    //   233: ldc -106
    //   235: invokevirtual 153	android/util/TimingLogger:addSplit	(Ljava/lang/String;)V
    //   238: lconst_0
    //   239: lstore 6
    //   241: aload_0
    //   242: getfield 15	dpu:a	Landroid/database/sqlite/SQLiteDatabase;
    //   245: ldc -101
    //   247: iconst_2
    //   248: anewarray 32	java/lang/String
    //   251: dup
    //   252: iconst_0
    //   253: aload 15
    //   255: aastore
    //   256: dup
    //   257: iconst_1
    //   258: aload 16
    //   260: aastore
    //   261: invokevirtual 159	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   264: astore 10
    //   266: aload 10
    //   268: invokeinterface 54 1 0
    //   273: ifeq +13 -> 286
    //   276: aload 10
    //   278: iconst_0
    //   279: invokeinterface 58 2 0
    //   284: lstore 6
    //   286: aload 10
    //   288: invokeinterface 80 1 0
    //   293: aload 11
    //   295: ldc -95
    //   297: invokevirtual 153	android/util/TimingLogger:addSplit	(Ljava/lang/String;)V
    //   300: aload_0
    //   301: getfield 15	dpu:a	Landroid/database/sqlite/SQLiteDatabase;
    //   304: ldc 104
    //   306: ldc -93
    //   308: iconst_2
    //   309: anewarray 32	java/lang/String
    //   312: dup
    //   313: iconst_0
    //   314: aload 16
    //   316: aastore
    //   317: dup
    //   318: iconst_1
    //   319: aload 15
    //   321: aastore
    //   322: invokevirtual 167	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   325: pop
    //   326: aload 11
    //   328: ldc -87
    //   330: invokevirtual 153	android/util/TimingLogger:addSplit	(Ljava/lang/String;)V
    //   333: new 21	java/util/HashMap
    //   336: dup
    //   337: invokespecial 22	java/util/HashMap:<init>	()V
    //   340: astore 15
    //   342: lload 8
    //   344: lconst_0
    //   345: lcmp
    //   346: ifne +123 -> 469
    //   349: new 171	dux
    //   352: dup
    //   353: aload_0
    //   354: getfield 15	dpu:a	Landroid/database/sqlite/SQLiteDatabase;
    //   357: aload_0
    //   358: getfield 17	dpu:b	Ldrj;
    //   361: invokespecial 173	dux:<init>	(Landroid/database/sqlite/SQLiteDatabase;Ldrj;)V
    //   364: astore 10
    //   366: aload 10
    //   368: lload_1
    //   369: iload_3
    //   370: lload 8
    //   372: aload 14
    //   374: lload 6
    //   376: aload 15
    //   378: iload 5
    //   380: aload 12
    //   382: aload 11
    //   384: invokevirtual 178	dps:a	(JIJLjava/util/Map;JLjava/util/Map;ZLdpt;Landroid/util/TimingLogger;)V
    //   387: ldc 95
    //   389: ldc -76
    //   391: iconst_1
    //   392: anewarray 4	java/lang/Object
    //   395: dup
    //   396: iconst_0
    //   397: lload_1
    //   398: invokestatic 66	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   401: aastore
    //   402: invokestatic 102	dri:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   405: pop
    //   406: aload 11
    //   408: ldc -74
    //   410: invokevirtual 153	android/util/TimingLogger:addSplit	(Ljava/lang/String;)V
    //   413: aload 11
    //   415: invokevirtual 185	android/util/TimingLogger:dumpToLog	()V
    //   418: goto -247 -> 171
    //   421: astore 12
    //   423: aload 10
    //   425: invokeinterface 80 1 0
    //   430: aload 12
    //   432: athrow
    //   433: astore 10
    //   435: ldc 95
    //   437: ldc -76
    //   439: iconst_1
    //   440: anewarray 4	java/lang/Object
    //   443: dup
    //   444: iconst_0
    //   445: lload_1
    //   446: invokestatic 66	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   449: aastore
    //   450: invokestatic 102	dri:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   453: pop
    //   454: aload 11
    //   456: ldc -74
    //   458: invokevirtual 153	android/util/TimingLogger:addSplit	(Ljava/lang/String;)V
    //   461: aload 11
    //   463: invokevirtual 185	android/util/TimingLogger:dumpToLog	()V
    //   466: aload 10
    //   468: athrow
    //   469: new 187	drh
    //   472: dup
    //   473: aload_0
    //   474: getfield 15	dpu:a	Landroid/database/sqlite/SQLiteDatabase;
    //   477: aload_0
    //   478: getfield 17	dpu:b	Ldrj;
    //   481: invokespecial 188	drh:<init>	(Landroid/database/sqlite/SQLiteDatabase;Ldrj;)V
    //   484: astore 10
    //   486: goto -120 -> 366
    //   489: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	490	0	this	dpu
    //   0	490	1	paramLong	long
    //   0	490	3	paramInt	int
    //   0	490	4	paramBoolean1	boolean
    //   0	490	5	paramBoolean2	boolean
    //   239	136	6	l1	long
    //   194	177	8	l2	long
    //   74	350	10	localObject1	Object
    //   433	34	10	localObject2	Object
    //   484	1	10	localdrh	drh
    //   83	13	11	localHashSet	java.util.HashSet
    //   117	46	11	localObject3	Object
    //   207	255	11	localTimingLogger	android.util.TimingLogger
    //   160	221	12	localdpt	dpt
    //   421	10	12	localObject4	Object
    //   169	13	13	localIterator	java.util.Iterator
    //   229	144	14	localMap	Map
    //   213	164	15	localObject5	Object
    //   220	95	16	str	String
    // Exception table:
    //   from	to	target	type
    //   85	114	117	finally
    //   266	286	421	finally
    //   209	238	433	finally
    //   241	266	433	finally
    //   286	342	433	finally
    //   349	366	433	finally
    //   366	387	433	finally
    //   423	433	433	finally
    //   469	486	433	finally
  }
}

/* Location:
 * Qualified Name:     dpu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */