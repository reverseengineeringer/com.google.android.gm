public final class bap
{
  public static final String a = cvm.a;
  public static baq b = new bar();
  private static final String[] c = { "_id" };
  private static final String[] d = { "_id" };
  private static final String[] e = { "_id" };
  
  /* Error */
  public static void a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: getstatic 19	bap:a	Ljava/lang/String;
    //   3: ldc 40
    //   5: iconst_0
    //   6: anewarray 4	java/lang/Object
    //   9: invokestatic 43	cvm:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   12: pop
    //   13: aload_0
    //   14: invokevirtual 49	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   17: astore 8
    //   19: aload_0
    //   20: getstatic 55	arh:cm	I
    //   23: invokevirtual 59	android/content/Context:getString	(I)Ljava/lang/String;
    //   26: astore 10
    //   28: aload 8
    //   30: getstatic 64	com/android/emailcommon/provider/Account:a	Landroid/net/Uri;
    //   33: getstatic 25	bap:c	[Ljava/lang/String;
    //   36: aconst_null
    //   37: aconst_null
    //   38: aconst_null
    //   39: invokevirtual 70	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   42: astore 8
    //   44: aload 8
    //   46: ldc 23
    //   48: invokeinterface 76 2 0
    //   53: istore_1
    //   54: aload 8
    //   56: invokeinterface 80 1 0
    //   61: ifeq +400 -> 461
    //   64: aload 8
    //   66: iload_1
    //   67: invokeinterface 84 2 0
    //   72: lstore 4
    //   74: aload_0
    //   75: lload 4
    //   77: invokestatic 87	com/android/emailcommon/provider/Account:a	(Landroid/content/Context;J)Lcom/android/emailcommon/provider/Account;
    //   80: aload_0
    //   81: invokevirtual 90	com/android/emailcommon/provider/Account:d	(Landroid/content/Context;)Lcom/android/emailcommon/provider/HostAuth;
    //   84: getfield 94	com/android/emailcommon/provider/HostAuth:b	Ljava/lang/String;
    //   87: aload 10
    //   89: invokestatic 100	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   92: ifeq -38 -> 54
    //   95: getstatic 19	bap:a	Ljava/lang/String;
    //   98: ldc 102
    //   100: iconst_1
    //   101: anewarray 4	java/lang/Object
    //   104: dup
    //   105: iconst_0
    //   106: lload 4
    //   108: invokestatic 108	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   111: aastore
    //   112: invokestatic 110	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   115: pop
    //   116: aload_0
    //   117: invokevirtual 49	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   120: getstatic 113	com/android/emailcommon/provider/Mailbox:a	Landroid/net/Uri;
    //   123: getstatic 27	bap:d	[Ljava/lang/String;
    //   126: ldc 115
    //   128: iconst_1
    //   129: anewarray 21	java/lang/String
    //   132: dup
    //   133: iconst_0
    //   134: lload 4
    //   136: invokestatic 118	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   139: aastore
    //   140: aconst_null
    //   141: invokevirtual 70	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   144: astore 9
    //   146: aload 9
    //   148: ldc 23
    //   150: invokeinterface 76 2 0
    //   155: istore_2
    //   156: aload 9
    //   158: invokeinterface 80 1 0
    //   163: ifeq +283 -> 446
    //   166: aload 9
    //   168: iload_2
    //   169: invokeinterface 84 2 0
    //   174: lstore 6
    //   176: getstatic 19	bap:a	Ljava/lang/String;
    //   179: ldc 120
    //   181: iconst_1
    //   182: anewarray 4	java/lang/Object
    //   185: dup
    //   186: iconst_0
    //   187: lload 6
    //   189: invokestatic 108	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   192: aastore
    //   193: invokestatic 110	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   196: pop
    //   197: aload_0
    //   198: invokevirtual 49	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   201: getstatic 123	beb:a	Landroid/net/Uri;
    //   204: getstatic 29	bap:e	[Ljava/lang/String;
    //   207: ldc 125
    //   209: iconst_2
    //   210: anewarray 21	java/lang/String
    //   213: dup
    //   214: iconst_0
    //   215: lload 4
    //   217: invokestatic 118	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   220: aastore
    //   221: dup
    //   222: iconst_1
    //   223: lload 6
    //   225: invokestatic 118	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   228: aastore
    //   229: ldc 127
    //   231: invokevirtual 70	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   234: astore 11
    //   236: aload 11
    //   238: ldc 23
    //   240: invokeinterface 76 2 0
    //   245: istore_3
    //   246: aload 11
    //   248: invokeinterface 131 1 0
    //   253: sipush 300
    //   256: if_icmpge +74 -> 330
    //   259: getstatic 19	bap:a	Ljava/lang/String;
    //   262: ldc -123
    //   264: iconst_1
    //   265: anewarray 4	java/lang/Object
    //   268: dup
    //   269: iconst_0
    //   270: aload 11
    //   272: invokeinterface 131 1 0
    //   277: invokestatic 138	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   280: aastore
    //   281: invokestatic 110	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   284: pop
    //   285: aload 11
    //   287: ifnull -131 -> 156
    //   290: aload 11
    //   292: invokeinterface 141 1 0
    //   297: goto -141 -> 156
    //   300: astore_0
    //   301: aload 9
    //   303: ifnull +10 -> 313
    //   306: aload 9
    //   308: invokeinterface 141 1 0
    //   313: aload_0
    //   314: athrow
    //   315: astore_0
    //   316: aload 8
    //   318: ifnull +10 -> 328
    //   321: aload 8
    //   323: invokeinterface 141 1 0
    //   328: aload_0
    //   329: athrow
    //   330: aload 11
    //   332: sipush 299
    //   335: invokeinterface 145 2 0
    //   340: pop
    //   341: aload 11
    //   343: invokeinterface 80 1 0
    //   348: ifeq -63 -> 285
    //   351: aload 11
    //   353: iload_3
    //   354: invokeinterface 84 2 0
    //   359: lstore 6
    //   361: getstatic 19	bap:a	Ljava/lang/String;
    //   364: ldc -109
    //   366: iconst_1
    //   367: anewarray 4	java/lang/Object
    //   370: dup
    //   371: iconst_0
    //   372: lload 6
    //   374: invokestatic 108	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   377: aastore
    //   378: invokestatic 110	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   381: pop
    //   382: aload_0
    //   383: lload 4
    //   385: lload 6
    //   387: invokestatic 152	bgt:b	(Landroid/content/Context;JJ)V
    //   390: aload_0
    //   391: invokevirtual 49	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   394: astore 12
    //   396: aload 12
    //   398: getstatic 123	beb:a	Landroid/net/Uri;
    //   401: lload 6
    //   403: invokestatic 158	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   406: aconst_null
    //   407: aconst_null
    //   408: invokevirtual 162	android/content/ContentResolver:delete	(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    //   411: pop
    //   412: aload 12
    //   414: getstatic 164	beb:e	Landroid/net/Uri;
    //   417: lload 6
    //   419: invokestatic 158	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   422: aconst_null
    //   423: aconst_null
    //   424: invokevirtual 162	android/content/ContentResolver:delete	(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    //   427: pop
    //   428: goto -87 -> 341
    //   431: astore_0
    //   432: aload 11
    //   434: ifnull +10 -> 444
    //   437: aload 11
    //   439: invokeinterface 141 1 0
    //   444: aload_0
    //   445: athrow
    //   446: aload 9
    //   448: ifnull -394 -> 54
    //   451: aload 9
    //   453: invokeinterface 141 1 0
    //   458: goto -404 -> 54
    //   461: aload 8
    //   463: ifnull +10 -> 473
    //   466: aload 8
    //   468: invokeinterface 141 1 0
    //   473: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	474	0	paramContext	android.content.Context
    //   53	14	1	i	int
    //   155	14	2	j	int
    //   245	109	3	k	int
    //   72	312	4	l1	long
    //   174	244	6	l2	long
    //   17	450	8	localObject	Object
    //   144	308	9	localCursor1	android.database.Cursor
    //   26	62	10	str	String
    //   234	204	11	localCursor2	android.database.Cursor
    //   394	19	12	localContentResolver	android.content.ContentResolver
    // Exception table:
    //   from	to	target	type
    //   146	156	300	finally
    //   156	236	300	finally
    //   290	297	300	finally
    //   437	444	300	finally
    //   444	446	300	finally
    //   44	54	315	finally
    //   54	146	315	finally
    //   306	313	315	finally
    //   313	315	315	finally
    //   451	458	315	finally
    //   236	285	431	finally
    //   330	341	431	finally
    //   341	428	431	finally
  }
}

/* Location:
 * Qualified Name:     bap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */