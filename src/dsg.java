final class dsg
  implements Runnable
{
  dsg(drp paramdrp) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: getfield 12	dsg:a	Ldrp;
    //   6: getfield 23	drp:w	Ldpa;
    //   9: astore 9
    //   11: aload 9
    //   13: ifnull +599 -> 612
    //   16: aload 9
    //   18: invokevirtual 28	dpa:a	()Z
    //   21: ifeq +17 -> 38
    //   24: getstatic 31	dpa:a	Ljava/lang/String;
    //   27: ldc 33
    //   29: iconst_0
    //   30: anewarray 4	java/lang/Object
    //   33: invokestatic 39	dri:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   36: pop
    //   37: return
    //   38: aload 9
    //   40: getfield 42	dpa:c	Landroid/database/sqlite/SQLiteDatabase;
    //   43: ldc 44
    //   45: getstatic 49	dpd:a	[Ljava/lang/String;
    //   48: ldc 51
    //   50: iconst_1
    //   51: anewarray 53	java/lang/String
    //   54: dup
    //   55: iconst_0
    //   56: ldc 55
    //   58: aastore
    //   59: aconst_null
    //   60: aconst_null
    //   61: aconst_null
    //   62: invokevirtual 61	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   65: astore 8
    //   67: aload 8
    //   69: invokeinterface 67 1 0
    //   74: ifle +552 -> 626
    //   77: new 69	java/util/HashSet
    //   80: dup
    //   81: invokespecial 70	java/util/HashSet:<init>	()V
    //   84: astore 10
    //   86: aload 8
    //   88: invokeinterface 73 1 0
    //   93: ifeq +38 -> 131
    //   96: aload 10
    //   98: aload 8
    //   100: bipush 7
    //   102: invokeinterface 77 2 0
    //   107: invokestatic 83	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   110: invokeinterface 89 2 0
    //   115: pop
    //   116: goto -30 -> 86
    //   119: astore 9
    //   121: aload 8
    //   123: invokeinterface 92 1 0
    //   128: aload 9
    //   130: athrow
    //   131: new 94	android/app/DownloadManager$Query
    //   134: dup
    //   135: invokespecial 95	android/app/DownloadManager$Query:<init>	()V
    //   138: iconst_2
    //   139: invokevirtual 99	android/app/DownloadManager$Query:setFilterByStatus	(I)Landroid/app/DownloadManager$Query;
    //   142: astore 11
    //   144: aload 9
    //   146: getfield 103	dpa:e	Landroid/app/DownloadManager;
    //   149: aload 11
    //   151: invokevirtual 108	android/app/DownloadManager:query	(Landroid/app/DownloadManager$Query;)Landroid/database/Cursor;
    //   154: astore 11
    //   156: aload 11
    //   158: ifnonnull +24 -> 182
    //   161: getstatic 31	dpa:a	Ljava/lang/String;
    //   164: ldc 110
    //   166: iconst_0
    //   167: anewarray 4	java/lang/Object
    //   170: invokestatic 112	dri:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   173: pop
    //   174: aload 8
    //   176: invokeinterface 92 1 0
    //   181: return
    //   182: aload 11
    //   184: ldc 114
    //   186: invokeinterface 118 2 0
    //   191: istore_1
    //   192: aload 11
    //   194: invokeinterface 73 1 0
    //   199: ifeq +64 -> 263
    //   202: aload 11
    //   204: iload_1
    //   205: invokeinterface 77 2 0
    //   210: lstore 5
    //   212: aload 10
    //   214: lload 5
    //   216: invokestatic 83	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   219: invokeinterface 121 2 0
    //   224: ifeq -32 -> 192
    //   227: getstatic 31	dpa:a	Ljava/lang/String;
    //   230: ldc 123
    //   232: iconst_1
    //   233: anewarray 4	java/lang/Object
    //   236: dup
    //   237: iconst_0
    //   238: lload 5
    //   240: invokestatic 83	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   243: aastore
    //   244: invokestatic 126	dri:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   247: pop
    //   248: aload 11
    //   250: invokeinterface 92 1 0
    //   255: aload 8
    //   257: invokeinterface 92 1 0
    //   262: return
    //   263: aload 11
    //   265: invokeinterface 92 1 0
    //   270: new 94	android/app/DownloadManager$Query
    //   273: dup
    //   274: invokespecial 95	android/app/DownloadManager$Query:<init>	()V
    //   277: iconst_4
    //   278: invokevirtual 99	android/app/DownloadManager$Query:setFilterByStatus	(I)Landroid/app/DownloadManager$Query;
    //   281: astore 10
    //   283: aload 9
    //   285: getfield 103	dpa:e	Landroid/app/DownloadManager;
    //   288: aload 10
    //   290: invokevirtual 108	android/app/DownloadManager:query	(Landroid/app/DownloadManager$Query;)Landroid/database/Cursor;
    //   293: astore 10
    //   295: aload 10
    //   297: ifnull +329 -> 626
    //   300: aload 10
    //   302: invokeinterface 67 1 0
    //   307: istore_1
    //   308: iload_1
    //   309: ifle +334 -> 643
    //   312: iconst_1
    //   313: istore_1
    //   314: aload 10
    //   316: invokeinterface 92 1 0
    //   321: aload 8
    //   323: invokeinterface 92 1 0
    //   328: aload 9
    //   330: getfield 42	dpa:c	Landroid/database/sqlite/SQLiteDatabase;
    //   333: ldc 44
    //   335: getstatic 49	dpd:a	[Ljava/lang/String;
    //   338: ldc -128
    //   340: aconst_null
    //   341: aconst_null
    //   342: aconst_null
    //   343: ldc -126
    //   345: invokevirtual 61	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   348: astore 8
    //   350: aload 8
    //   352: invokeinterface 73 1 0
    //   357: ifeq +239 -> 596
    //   360: aload 8
    //   362: iconst_0
    //   363: invokeinterface 77 2 0
    //   368: lstore 5
    //   370: aload 8
    //   372: bipush 6
    //   374: invokeinterface 134 2 0
    //   379: invokestatic 138	chi:a	(Ljava/lang/String;)I
    //   382: ifeq +147 -> 529
    //   385: iconst_1
    //   386: istore 7
    //   388: goto +243 -> 631
    //   391: aload 9
    //   393: getfield 141	dpa:b	Landroid/content/Context;
    //   396: invokevirtual 147	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   399: aconst_null
    //   400: new 149	android/content/IntentFilter
    //   403: dup
    //   404: ldc -105
    //   406: invokespecial 154	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   409: invokevirtual 158	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   412: astore 10
    //   414: aload 10
    //   416: ifnull +124 -> 540
    //   419: aload 10
    //   421: ldc -96
    //   423: iconst_m1
    //   424: invokevirtual 166	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   427: istore_3
    //   428: aload 10
    //   430: ldc -88
    //   432: iconst_m1
    //   433: invokevirtual 166	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   436: istore 4
    //   438: aload 10
    //   440: ldc -86
    //   442: iconst_m1
    //   443: invokevirtual 166	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   446: iconst_2
    //   447: if_icmpne +88 -> 535
    //   450: iconst_1
    //   451: istore_1
    //   452: iload_1
    //   453: ifne +87 -> 540
    //   456: iload_3
    //   457: i2f
    //   458: iload 4
    //   460: i2f
    //   461: fdiv
    //   462: f2d
    //   463: ldc2_w 171
    //   466: dcmpg
    //   467: ifge +73 -> 540
    //   470: iload_2
    //   471: istore_1
    //   472: iload_1
    //   473: ifeq +72 -> 545
    //   476: getstatic 31	dpa:a	Ljava/lang/String;
    //   479: ldc -82
    //   481: iconst_1
    //   482: anewarray 4	java/lang/Object
    //   485: dup
    //   486: iconst_0
    //   487: lload 5
    //   489: invokestatic 83	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   492: aastore
    //   493: invokestatic 126	dri:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   496: pop
    //   497: aload 8
    //   499: invokeinterface 92 1 0
    //   504: return
    //   505: astore 9
    //   507: aload 11
    //   509: invokeinterface 92 1 0
    //   514: aload 9
    //   516: athrow
    //   517: astore 9
    //   519: aload 10
    //   521: invokeinterface 92 1 0
    //   526: aload 9
    //   528: athrow
    //   529: iconst_0
    //   530: istore 7
    //   532: goto +99 -> 631
    //   535: iconst_0
    //   536: istore_1
    //   537: goto -85 -> 452
    //   540: iconst_0
    //   541: istore_1
    //   542: goto -70 -> 472
    //   545: aload 9
    //   547: lload 5
    //   549: ldc2_w 175
    //   552: iload 7
    //   554: invokevirtual 179	dpa:a	(JJZ)V
    //   557: goto -60 -> 497
    //   560: astore 9
    //   562: aload 8
    //   564: invokeinterface 92 1 0
    //   569: aload 9
    //   571: athrow
    //   572: getstatic 31	dpa:a	Ljava/lang/String;
    //   575: ldc -75
    //   577: iconst_1
    //   578: anewarray 4	java/lang/Object
    //   581: dup
    //   582: iconst_0
    //   583: lload 5
    //   585: invokestatic 83	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   588: aastore
    //   589: invokestatic 126	dri:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   592: pop
    //   593: goto -96 -> 497
    //   596: getstatic 31	dpa:a	Ljava/lang/String;
    //   599: ldc -73
    //   601: iconst_0
    //   602: anewarray 4	java/lang/Object
    //   605: invokestatic 126	dri:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   608: pop
    //   609: goto -112 -> 497
    //   612: getstatic 185	drp:b	Ljava/lang/String;
    //   615: ldc -69
    //   617: iconst_0
    //   618: anewarray 4	java/lang/Object
    //   621: invokestatic 112	dri:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   624: pop
    //   625: return
    //   626: iconst_0
    //   627: istore_1
    //   628: goto -307 -> 321
    //   631: iload 7
    //   633: ifeq -242 -> 391
    //   636: iload_1
    //   637: ifne -65 -> 572
    //   640: goto -249 -> 391
    //   643: iconst_0
    //   644: istore_1
    //   645: goto -331 -> 314
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	648	0	this	dsg
    //   191	454	1	i	int
    //   1	470	2	j	int
    //   427	30	3	k	int
    //   436	23	4	m	int
    //   210	374	5	l	long
    //   386	246	7	bool	boolean
    //   65	498	8	localCursor	android.database.Cursor
    //   9	30	9	localdpa	dpa
    //   119	273	9	localObject1	Object
    //   505	10	9	localObject2	Object
    //   517	29	9	localObject3	Object
    //   560	10	9	localObject4	Object
    //   84	436	10	localObject5	Object
    //   142	366	11	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   67	86	119	finally
    //   86	116	119	finally
    //   131	156	119	finally
    //   161	174	119	finally
    //   248	255	119	finally
    //   263	295	119	finally
    //   314	321	119	finally
    //   507	517	119	finally
    //   519	529	119	finally
    //   182	192	505	finally
    //   192	248	505	finally
    //   300	308	517	finally
    //   350	385	560	finally
    //   391	414	560	finally
    //   419	450	560	finally
    //   456	470	560	finally
    //   476	497	560	finally
    //   545	557	560	finally
    //   572	593	560	finally
    //   596	609	560	finally
  }
}

/* Location:
 * Qualified Name:     dsg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */