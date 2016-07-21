import android.accounts.Account;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;
import android.util.EventLog;

public final class dtz
  extends bgp
{
  private volatile drp a;
  
  public dtz(Context paramContext)
  {
    super(paramContext, (byte)0);
  }
  
  protected final void a(long paramLong1, long paramLong2, SyncResult paramSyncResult)
  {
    int i = 0;
    if (a != null)
    {
      dtn localdtn = a.m;
      StringBuffer localStringBuffer = new StringBuffer();
      while (i < dtn.m.length)
      {
        if (n[i] > 0L) {
          localStringBuffer.append(dtn.m[i]).append(n[i]);
        }
        i += 1;
      }
      localStringBuffer.append(paramSyncResult.toDebugString());
      EventLog.writeEvent(203001, new Object[] { "Gmail", Long.valueOf(paramLong1), Long.valueOf(paramLong2), localStringBuffer.toString() });
    }
    if ((!paramSyncResult.hasError()) && (a != null))
    {
      paramSyncResult = a.a;
      if (paramSyncResult != null)
      {
        q = paramLong1;
        r = paramLong2;
      }
    }
  }
  
  /* Error */
  public final void a(Account paramAccount, Bundle arg2, ContentProviderClient paramContentProviderClient, SyncResult paramSyncResult)
  {
    // Byte code:
    //   0: ldc 53
    //   2: ldc 101
    //   4: iconst_1
    //   5: anewarray 51	java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: aload_1
    //   11: getfield 107	android/accounts/Account:name	Ljava/lang/String;
    //   14: invokestatic 112	dri:a	(Ljava/lang/String;)Ljava/lang/String;
    //   17: aastore
    //   18: invokestatic 116	dri:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   21: pop
    //   22: aload_0
    //   23: getstatic 121	com/google/android/gm/provider/MailProvider:a	Lcom/google/android/gm/provider/MailProvider;
    //   26: invokevirtual 125	com/google/android/gm/provider/MailProvider:getContext	()Landroid/content/Context;
    //   29: aload_1
    //   30: getfield 107	android/accounts/Account:name	Ljava/lang/String;
    //   33: invokestatic 129	drp:b	(Landroid/content/Context;Ljava/lang/String;)Ldrp;
    //   36: putfield 15	dtz:a	Ldrp;
    //   39: invokestatic 135	android/os/SystemClock:elapsedRealtime	()J
    //   42: lstore 23
    //   44: aload_0
    //   45: getfield 15	dtz:a	Ldrp;
    //   48: astore_3
    //   49: aload_3
    //   50: getfield 139	drp:g	Ljava/lang/Object;
    //   53: astore 28
    //   55: aload 28
    //   57: monitorenter
    //   58: aload_3
    //   59: getfield 143	drp:h	Z
    //   62: ifeq +68 -> 130
    //   65: getstatic 145	drp:b	Ljava/lang/String;
    //   68: ldc -109
    //   70: iconst_0
    //   71: anewarray 51	java/lang/Object
    //   74: invokestatic 150	dri:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   77: pop
    //   78: aload 28
    //   80: monitorexit
    //   81: invokestatic 135	android/os/SystemClock:elapsedRealtime	()J
    //   84: lstore 25
    //   86: aload_0
    //   87: getfield 15	dtz:a	Ldrp;
    //   90: getfield 75	drp:a	Ldqu;
    //   93: astore_2
    //   94: aload_2
    //   95: ifnull +12 -> 107
    //   98: aload_2
    //   99: lload 25
    //   101: lload 23
    //   103: lsub
    //   104: putfield 153	cgu:p	J
    //   107: ldc 53
    //   109: ldc -101
    //   111: iconst_1
    //   112: anewarray 51	java/lang/Object
    //   115: dup
    //   116: iconst_0
    //   117: aload_1
    //   118: getfield 107	android/accounts/Account:name	Ljava/lang/String;
    //   121: invokestatic 112	dri:a	(Ljava/lang/String;)Ljava/lang/String;
    //   124: aastore
    //   125: invokestatic 116	dri:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   128: pop
    //   129: return
    //   130: aload_3
    //   131: invokestatic 161	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   134: putfield 165	drp:i	Ljava/lang/Thread;
    //   137: aload 28
    //   139: monitorexit
    //   140: new 167	android/util/TimingLogger
    //   143: dup
    //   144: getstatic 145	drp:b	Ljava/lang/String;
    //   147: invokestatic 172	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   150: ldc -82
    //   152: invokevirtual 177	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   155: ldc -77
    //   157: invokespecial 182	android/util/TimingLogger:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: astore 28
    //   162: aload 28
    //   164: ldc -72
    //   166: invokevirtual 188	android/util/TimingLogger:addSplit	(Ljava/lang/String;)V
    //   169: new 190	dsu
    //   172: dup
    //   173: invokespecial 191	dsu:<init>	()V
    //   176: astore 29
    //   178: iconst_0
    //   179: istore 13
    //   181: iconst_0
    //   182: istore 15
    //   184: iconst_0
    //   185: istore 16
    //   187: iconst_0
    //   188: istore 17
    //   190: iconst_0
    //   191: istore 18
    //   193: iconst_0
    //   194: istore 19
    //   196: iconst_0
    //   197: istore 20
    //   199: iconst_0
    //   200: istore 21
    //   202: iconst_0
    //   203: istore 14
    //   205: aload_3
    //   206: getfield 21	drp:m	Ldtn;
    //   209: invokevirtual 193	dtn:a	()V
    //   212: aload_3
    //   213: getfield 196	drp:p	Landroid/database/sqlite/SQLiteDatabase;
    //   216: ifnull +314 -> 530
    //   219: aload_3
    //   220: iconst_0
    //   221: putfield 199	drp:F	Z
    //   224: iload 15
    //   226: istore 7
    //   228: iload 16
    //   230: istore 8
    //   232: iload 17
    //   234: istore 9
    //   236: iload 18
    //   238: istore 10
    //   240: iload 19
    //   242: istore 11
    //   244: iload 20
    //   246: istore 12
    //   248: iload 21
    //   250: istore 6
    //   252: aload_3
    //   253: iconst_1
    //   254: iconst_1
    //   255: invokevirtual 202	drp:a	(IZ)V
    //   258: iload 15
    //   260: istore 7
    //   262: iload 16
    //   264: istore 8
    //   266: iload 17
    //   268: istore 9
    //   270: iload 18
    //   272: istore 10
    //   274: iload 19
    //   276: istore 11
    //   278: iload 20
    //   280: istore 12
    //   282: iload 21
    //   284: istore 6
    //   286: aload_3
    //   287: iconst_1
    //   288: putfield 205	drp:B	Z
    //   291: iload 15
    //   293: istore 7
    //   295: iload 16
    //   297: istore 8
    //   299: iload 17
    //   301: istore 9
    //   303: iload 18
    //   305: istore 10
    //   307: iload 19
    //   309: istore 11
    //   311: iload 20
    //   313: istore 12
    //   315: iload 21
    //   317: istore 6
    //   319: aload_3
    //   320: getfield 209	drp:l	Landroid/accounts/Account;
    //   323: ldc -45
    //   325: invokestatic 217	android/content/ContentResolver:getIsSyncable	(Landroid/accounts/Account;Ljava/lang/String;)I
    //   328: istore 22
    //   330: iload 22
    //   332: istore 5
    //   334: iload 22
    //   336: ifge +80 -> 416
    //   339: iload 15
    //   341: istore 7
    //   343: iload 16
    //   345: istore 8
    //   347: iload 17
    //   349: istore 9
    //   351: iload 18
    //   353: istore 10
    //   355: iload 19
    //   357: istore 11
    //   359: iload 20
    //   361: istore 12
    //   363: iload 21
    //   365: istore 6
    //   367: aload_3
    //   368: invokevirtual 220	drp:C	()Z
    //   371: ifeq +256 -> 627
    //   374: iconst_1
    //   375: istore 5
    //   377: iload 15
    //   379: istore 7
    //   381: iload 16
    //   383: istore 8
    //   385: iload 17
    //   387: istore 9
    //   389: iload 18
    //   391: istore 10
    //   393: iload 19
    //   395: istore 11
    //   397: iload 20
    //   399: istore 12
    //   401: iload 21
    //   403: istore 6
    //   405: aload_3
    //   406: getfield 209	drp:l	Landroid/accounts/Account;
    //   409: ldc -45
    //   411: iload 5
    //   413: invokestatic 224	android/content/ContentResolver:setIsSyncable	(Landroid/accounts/Account;Ljava/lang/String;I)V
    //   416: iload 15
    //   418: istore 7
    //   420: iload 16
    //   422: istore 8
    //   424: iload 17
    //   426: istore 9
    //   428: iload 18
    //   430: istore 10
    //   432: iload 19
    //   434: istore 11
    //   436: iload 20
    //   438: istore 12
    //   440: iload 21
    //   442: istore 6
    //   444: aload_2
    //   445: ldc -30
    //   447: iconst_0
    //   448: invokevirtual 232	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   451: istore 27
    //   453: iload 27
    //   455: ifeq +178 -> 633
    //   458: aload 29
    //   460: invokevirtual 234	dsu:c	()Z
    //   463: ifeq +8 -> 471
    //   466: aload_3
    //   467: iconst_0
    //   468: invokevirtual 237	drp:a	(Z)V
    //   471: aload_3
    //   472: invokevirtual 239	drp:h	()V
    //   475: aload_3
    //   476: iconst_1
    //   477: putfield 242	drp:af	Z
    //   480: aload_3
    //   481: iconst_0
    //   482: putfield 205	drp:B	Z
    //   485: aload 29
    //   487: invokevirtual 234	dsu:c	()Z
    //   490: ifeq +22 -> 512
    //   493: aload_3
    //   494: iconst_0
    //   495: invokevirtual 244	drp:b	(Z)V
    //   498: aload_3
    //   499: getfield 248	drp:k	Landroid/content/Context;
    //   502: aload_3
    //   503: getfield 209	drp:l	Landroid/accounts/Account;
    //   506: getfield 107	android/accounts/Account:name	Ljava/lang/String;
    //   509: invokestatic 253	com/google/android/gm/provider/GmailProvider:c	(Landroid/content/Context;Ljava/lang/String;)V
    //   512: aload 28
    //   514: ldc -1
    //   516: invokevirtual 188	android/util/TimingLogger:addSplit	(Ljava/lang/String;)V
    //   519: aload 28
    //   521: invokevirtual 258	android/util/TimingLogger:dumpToLog	()V
    //   524: aload_3
    //   525: iconst_1
    //   526: iconst_0
    //   527: invokevirtual 202	drp:a	(IZ)V
    //   530: aload_3
    //   531: getfield 139	drp:g	Ljava/lang/Object;
    //   534: astore_2
    //   535: aload_2
    //   536: monitorenter
    //   537: aload_3
    //   538: aconst_null
    //   539: putfield 165	drp:i	Ljava/lang/Thread;
    //   542: aload_2
    //   543: monitorexit
    //   544: goto -463 -> 81
    //   547: astore_3
    //   548: aload_2
    //   549: monitorexit
    //   550: aload_3
    //   551: athrow
    //   552: astore_2
    //   553: ldc 53
    //   555: aload_2
    //   556: ldc_w 260
    //   559: iconst_0
    //   560: anewarray 51	java/lang/Object
    //   563: invokestatic 264	dri:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   566: pop
    //   567: aload 4
    //   569: iconst_1
    //   570: putfield 267	android/content/SyncResult:databaseError	Z
    //   573: ldc 53
    //   575: ldc -101
    //   577: iconst_1
    //   578: anewarray 51	java/lang/Object
    //   581: dup
    //   582: iconst_0
    //   583: aload_1
    //   584: getfield 107	android/accounts/Account:name	Ljava/lang/String;
    //   587: invokestatic 112	dri:a	(Ljava/lang/String;)Ljava/lang/String;
    //   590: aastore
    //   591: invokestatic 116	dri:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   594: pop
    //   595: return
    //   596: astore_2
    //   597: aload 28
    //   599: monitorexit
    //   600: aload_2
    //   601: athrow
    //   602: astore_2
    //   603: ldc 53
    //   605: ldc -101
    //   607: iconst_1
    //   608: anewarray 51	java/lang/Object
    //   611: dup
    //   612: iconst_0
    //   613: aload_1
    //   614: getfield 107	android/accounts/Account:name	Ljava/lang/String;
    //   617: invokestatic 112	dri:a	(Ljava/lang/String;)Ljava/lang/String;
    //   620: aastore
    //   621: invokestatic 116	dri:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   624: pop
    //   625: aload_2
    //   626: athrow
    //   627: iconst_0
    //   628: istore 5
    //   630: goto -253 -> 377
    //   633: iload 5
    //   635: ifgt +97 -> 732
    //   638: aload 29
    //   640: invokevirtual 234	dsu:c	()Z
    //   643: ifeq +8 -> 651
    //   646: aload_3
    //   647: iconst_0
    //   648: invokevirtual 237	drp:a	(Z)V
    //   651: aload_3
    //   652: invokevirtual 239	drp:h	()V
    //   655: aload_3
    //   656: iconst_1
    //   657: putfield 242	drp:af	Z
    //   660: aload_3
    //   661: iconst_0
    //   662: putfield 205	drp:B	Z
    //   665: aload 29
    //   667: invokevirtual 234	dsu:c	()Z
    //   670: ifeq +22 -> 692
    //   673: aload_3
    //   674: iconst_0
    //   675: invokevirtual 244	drp:b	(Z)V
    //   678: aload_3
    //   679: getfield 248	drp:k	Landroid/content/Context;
    //   682: aload_3
    //   683: getfield 209	drp:l	Landroid/accounts/Account;
    //   686: getfield 107	android/accounts/Account:name	Ljava/lang/String;
    //   689: invokestatic 253	com/google/android/gm/provider/GmailProvider:c	(Landroid/content/Context;Ljava/lang/String;)V
    //   692: aload 28
    //   694: ldc -1
    //   696: invokevirtual 188	android/util/TimingLogger:addSplit	(Ljava/lang/String;)V
    //   699: aload 28
    //   701: invokevirtual 258	android/util/TimingLogger:dumpToLog	()V
    //   704: aload_3
    //   705: iconst_1
    //   706: iconst_0
    //   707: invokevirtual 202	drp:a	(IZ)V
    //   710: goto -180 -> 530
    //   713: astore 28
    //   715: aload_3
    //   716: getfield 139	drp:g	Ljava/lang/Object;
    //   719: astore_2
    //   720: aload_2
    //   721: monitorenter
    //   722: aload_3
    //   723: aconst_null
    //   724: putfield 165	drp:i	Ljava/lang/Thread;
    //   727: aload_2
    //   728: monitorexit
    //   729: aload 28
    //   731: athrow
    //   732: iload 15
    //   734: istore 7
    //   736: iload 16
    //   738: istore 8
    //   740: iload 17
    //   742: istore 9
    //   744: iload 18
    //   746: istore 10
    //   748: iload 19
    //   750: istore 11
    //   752: iload 20
    //   754: istore 12
    //   756: iload 21
    //   758: istore 6
    //   760: new 269	dtd
    //   763: dup
    //   764: invokespecial 270	dtd:<init>	()V
    //   767: astore 30
    //   769: iload 15
    //   771: istore 7
    //   773: iload 16
    //   775: istore 8
    //   777: iload 17
    //   779: istore 9
    //   781: iload 18
    //   783: istore 10
    //   785: iload 19
    //   787: istore 11
    //   789: iload 20
    //   791: istore 12
    //   793: iload 21
    //   795: istore 6
    //   797: aload_2
    //   798: ldc_w 272
    //   801: iconst_0
    //   802: invokevirtual 232	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   805: ifeq +181 -> 986
    //   808: iload 15
    //   810: istore 7
    //   812: iload 16
    //   814: istore 8
    //   816: iload 17
    //   818: istore 9
    //   820: iload 18
    //   822: istore 10
    //   824: iload 19
    //   826: istore 11
    //   828: iload 20
    //   830: istore 12
    //   832: iload 21
    //   834: istore 6
    //   836: aload 30
    //   838: iconst_0
    //   839: putfield 274	dtd:a	Z
    //   842: iload 15
    //   844: istore 7
    //   846: iload 16
    //   848: istore 8
    //   850: iload 17
    //   852: istore 9
    //   854: iload 18
    //   856: istore 10
    //   858: iload 19
    //   860: istore 11
    //   862: iload 20
    //   864: istore 12
    //   866: iload 21
    //   868: istore 6
    //   870: aload 30
    //   872: aload_2
    //   873: ldc_w 276
    //   876: invokevirtual 280	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   879: putfield 283	dtd:f	J
    //   882: iload 15
    //   884: istore 7
    //   886: iload 16
    //   888: istore 8
    //   890: iload 17
    //   892: istore 9
    //   894: iload 18
    //   896: istore 10
    //   898: iload 19
    //   900: istore 11
    //   902: iload 20
    //   904: istore 12
    //   906: iload 21
    //   908: istore 6
    //   910: aload 30
    //   912: aload_2
    //   913: ldc_w 285
    //   916: invokevirtual 280	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   919: putfield 287	dtd:e	J
    //   922: iload 15
    //   924: istore 7
    //   926: iload 16
    //   928: istore 8
    //   930: iload 17
    //   932: istore 9
    //   934: iload 18
    //   936: istore 10
    //   938: iload 19
    //   940: istore 11
    //   942: iload 20
    //   944: istore 12
    //   946: iload 21
    //   948: istore 6
    //   950: getstatic 145	drp:b	Ljava/lang/String;
    //   953: ldc_w 289
    //   956: iconst_2
    //   957: anewarray 51	java/lang/Object
    //   960: dup
    //   961: iconst_0
    //   962: aload 30
    //   964: getfield 283	dtd:f	J
    //   967: invokestatic 59	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   970: aastore
    //   971: dup
    //   972: iconst_1
    //   973: aload 30
    //   975: getfield 287	dtd:e	J
    //   978: invokestatic 59	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   981: aastore
    //   982: invokestatic 291	dri:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   985: pop
    //   986: iload 15
    //   988: istore 7
    //   990: iload 16
    //   992: istore 8
    //   994: iload 17
    //   996: istore 9
    //   998: iload 18
    //   1000: istore 10
    //   1002: iload 19
    //   1004: istore 11
    //   1006: iload 20
    //   1008: istore 12
    //   1010: iload 21
    //   1012: istore 6
    //   1014: aload_2
    //   1015: ldc_w 293
    //   1018: invokevirtual 297	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   1021: ifeq +37 -> 1058
    //   1024: iload 15
    //   1026: istore 7
    //   1028: iload 16
    //   1030: istore 8
    //   1032: iload 17
    //   1034: istore 9
    //   1036: iload 18
    //   1038: istore 10
    //   1040: iload 19
    //   1042: istore 11
    //   1044: iload 20
    //   1046: istore 12
    //   1048: iload 21
    //   1050: istore 6
    //   1052: aload 30
    //   1054: iconst_1
    //   1055: putfield 299	dtd:c	Z
    //   1058: iload 15
    //   1060: istore 7
    //   1062: iload 16
    //   1064: istore 8
    //   1066: iload 17
    //   1068: istore 9
    //   1070: iload 18
    //   1072: istore 10
    //   1074: iload 19
    //   1076: istore 11
    //   1078: iload 20
    //   1080: istore 12
    //   1082: iload 21
    //   1084: istore 6
    //   1086: aload_2
    //   1087: ldc_w 301
    //   1090: invokevirtual 297	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   1093: ifeq +125 -> 1218
    //   1096: iload 15
    //   1098: istore 7
    //   1100: iload 16
    //   1102: istore 8
    //   1104: iload 17
    //   1106: istore 9
    //   1108: iload 18
    //   1110: istore 10
    //   1112: iload 19
    //   1114: istore 11
    //   1116: iload 20
    //   1118: istore 12
    //   1120: iload 21
    //   1122: istore 6
    //   1124: aload_2
    //   1125: ldc_w 301
    //   1128: invokevirtual 304	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1131: astore 31
    //   1133: iload 15
    //   1135: istore 7
    //   1137: iload 16
    //   1139: istore 8
    //   1141: iload 17
    //   1143: istore 9
    //   1145: iload 18
    //   1147: istore 10
    //   1149: iload 19
    //   1151: istore 11
    //   1153: iload 20
    //   1155: istore 12
    //   1157: iload 21
    //   1159: istore 6
    //   1161: aload_3
    //   1162: getfield 308	drp:X	Ldqc;
    //   1165: aload 31
    //   1167: invokevirtual 312	dqc:b	(Ljava/lang/String;)Z
    //   1170: ifeq +48 -> 1218
    //   1173: iload 15
    //   1175: istore 7
    //   1177: iload 16
    //   1179: istore 8
    //   1181: iload 17
    //   1183: istore 9
    //   1185: iload 18
    //   1187: istore 10
    //   1189: iload 19
    //   1191: istore 11
    //   1193: iload 20
    //   1195: istore 12
    //   1197: iload 21
    //   1199: istore 6
    //   1201: aload 30
    //   1203: aload_3
    //   1204: getfield 308	drp:X	Ldqc;
    //   1207: aload 31
    //   1209: invokevirtual 314	dqc:a	(Ljava/lang/String;)J
    //   1212: invokestatic 59	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1215: putfield 317	dtd:d	Ljava/lang/Long;
    //   1218: iload 15
    //   1220: istore 7
    //   1222: iload 16
    //   1224: istore 8
    //   1226: iload 17
    //   1228: istore 9
    //   1230: iload 18
    //   1232: istore 10
    //   1234: iload 19
    //   1236: istore 11
    //   1238: iload 20
    //   1240: istore 12
    //   1242: iload 21
    //   1244: istore 6
    //   1246: aload_2
    //   1247: ldc_w 319
    //   1250: invokevirtual 297	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   1253: istore 27
    //   1255: iload 15
    //   1257: istore 7
    //   1259: iload 16
    //   1261: istore 8
    //   1263: iload 17
    //   1265: istore 9
    //   1267: iload 18
    //   1269: istore 10
    //   1271: iload 19
    //   1273: istore 11
    //   1275: iload 20
    //   1277: istore 12
    //   1279: iload 21
    //   1281: istore 6
    //   1283: aload_3
    //   1284: getfield 322	drp:G	Ljava/lang/Object;
    //   1287: astore_2
    //   1288: iload 15
    //   1290: istore 7
    //   1292: iload 16
    //   1294: istore 8
    //   1296: iload 17
    //   1298: istore 9
    //   1300: iload 18
    //   1302: istore 10
    //   1304: iload 19
    //   1306: istore 11
    //   1308: iload 20
    //   1310: istore 12
    //   1312: iload 21
    //   1314: istore 6
    //   1316: aload_2
    //   1317: monitorenter
    //   1318: iload 14
    //   1320: istore 5
    //   1322: iload 13
    //   1324: istore 6
    //   1326: aload_3
    //   1327: aload 29
    //   1329: aload 30
    //   1331: aload 4
    //   1333: iload 27
    //   1335: invokevirtual 325	drp:a	(Ldsu;Ldtd;Landroid/content/SyncResult;Z)Z
    //   1338: ifeq +6 -> 1344
    //   1341: iconst_1
    //   1342: istore 5
    //   1344: iload 5
    //   1346: istore 6
    //   1348: aload_3
    //   1349: getfield 21	drp:m	Ldtn;
    //   1352: getfield 328	dtn:e	Ljava/util/Set;
    //   1355: invokeinterface 334 1 0
    //   1360: ifle +39 -> 1399
    //   1363: iload 5
    //   1365: istore 6
    //   1367: aload_3
    //   1368: getfield 338	drp:v	Ldth;
    //   1371: aload_3
    //   1372: getfield 21	drp:m	Ldtn;
    //   1375: getfield 328	dtn:e	Ljava/util/Set;
    //   1378: invokeinterface 343 2 0
    //   1383: iload 5
    //   1385: istore 6
    //   1387: aload_3
    //   1388: getfield 21	drp:m	Ldtn;
    //   1391: getfield 328	dtn:e	Ljava/util/Set;
    //   1394: invokeinterface 346 1 0
    //   1399: iload 5
    //   1401: istore 6
    //   1403: aload_2
    //   1404: monitorexit
    //   1405: iload 5
    //   1407: istore 7
    //   1409: iload 5
    //   1411: istore 8
    //   1413: iload 5
    //   1415: istore 9
    //   1417: iload 5
    //   1419: istore 10
    //   1421: iload 5
    //   1423: istore 11
    //   1425: iload 5
    //   1427: istore 12
    //   1429: iload 5
    //   1431: istore 6
    //   1433: aload_3
    //   1434: iconst_0
    //   1435: iconst_0
    //   1436: invokevirtual 349	drp:a	(II)V
    //   1439: aload 29
    //   1441: invokevirtual 234	dsu:c	()Z
    //   1444: ifeq +8 -> 1452
    //   1447: aload_3
    //   1448: iconst_0
    //   1449: invokevirtual 237	drp:a	(Z)V
    //   1452: aload_3
    //   1453: invokevirtual 239	drp:h	()V
    //   1456: aload_3
    //   1457: iconst_1
    //   1458: putfield 242	drp:af	Z
    //   1461: aload_3
    //   1462: iconst_0
    //   1463: putfield 205	drp:B	Z
    //   1466: aload 29
    //   1468: invokevirtual 234	dsu:c	()Z
    //   1471: ifne +8 -> 1479
    //   1474: iload 5
    //   1476: ifeq +22 -> 1498
    //   1479: aload_3
    //   1480: iconst_0
    //   1481: invokevirtual 244	drp:b	(Z)V
    //   1484: aload_3
    //   1485: getfield 248	drp:k	Landroid/content/Context;
    //   1488: aload_3
    //   1489: getfield 209	drp:l	Landroid/accounts/Account;
    //   1492: getfield 107	android/accounts/Account:name	Ljava/lang/String;
    //   1495: invokestatic 253	com/google/android/gm/provider/GmailProvider:c	(Landroid/content/Context;Ljava/lang/String;)V
    //   1498: aload 28
    //   1500: ldc -1
    //   1502: invokevirtual 188	android/util/TimingLogger:addSplit	(Ljava/lang/String;)V
    //   1505: aload 28
    //   1507: invokevirtual 258	android/util/TimingLogger:dumpToLog	()V
    //   1510: aload_3
    //   1511: iconst_1
    //   1512: iconst_0
    //   1513: invokevirtual 202	drp:a	(IZ)V
    //   1516: goto -986 -> 530
    //   1519: astore 30
    //   1521: aload_2
    //   1522: monitorexit
    //   1523: iload 6
    //   1525: istore 7
    //   1527: iload 6
    //   1529: istore 8
    //   1531: iload 6
    //   1533: istore 9
    //   1535: iload 6
    //   1537: istore 10
    //   1539: iload 6
    //   1541: istore 11
    //   1543: iload 6
    //   1545: istore 12
    //   1547: aload 30
    //   1549: athrow
    //   1550: astore_2
    //   1551: iload 7
    //   1553: istore 6
    //   1555: getstatic 145	drp:b	Ljava/lang/String;
    //   1558: aload_2
    //   1559: ldc_w 351
    //   1562: iconst_0
    //   1563: anewarray 51	java/lang/Object
    //   1566: invokestatic 353	dri:b	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1569: pop
    //   1570: iload 7
    //   1572: istore 6
    //   1574: aload 4
    //   1576: getfield 357	android/content/SyncResult:stats	Landroid/content/SyncStats;
    //   1579: astore_2
    //   1580: iload 7
    //   1582: istore 6
    //   1584: aload_2
    //   1585: aload_2
    //   1586: getfield 362	android/content/SyncStats:numAuthExceptions	J
    //   1589: lconst_1
    //   1590: ladd
    //   1591: putfield 362	android/content/SyncStats:numAuthExceptions	J
    //   1594: iload 7
    //   1596: istore 6
    //   1598: aload_3
    //   1599: iconst_2
    //   1600: iconst_0
    //   1601: invokevirtual 349	drp:a	(II)V
    //   1604: aload 29
    //   1606: invokevirtual 234	dsu:c	()Z
    //   1609: ifeq +8 -> 1617
    //   1612: aload_3
    //   1613: iconst_0
    //   1614: invokevirtual 237	drp:a	(Z)V
    //   1617: aload_3
    //   1618: invokevirtual 239	drp:h	()V
    //   1621: aload_3
    //   1622: iconst_1
    //   1623: putfield 242	drp:af	Z
    //   1626: aload_3
    //   1627: iconst_0
    //   1628: putfield 205	drp:B	Z
    //   1631: aload 29
    //   1633: invokevirtual 234	dsu:c	()Z
    //   1636: ifne +8 -> 1644
    //   1639: iload 7
    //   1641: ifeq +22 -> 1663
    //   1644: aload_3
    //   1645: iconst_0
    //   1646: invokevirtual 244	drp:b	(Z)V
    //   1649: aload_3
    //   1650: getfield 248	drp:k	Landroid/content/Context;
    //   1653: aload_3
    //   1654: getfield 209	drp:l	Landroid/accounts/Account;
    //   1657: getfield 107	android/accounts/Account:name	Ljava/lang/String;
    //   1660: invokestatic 253	com/google/android/gm/provider/GmailProvider:c	(Landroid/content/Context;Ljava/lang/String;)V
    //   1663: aload 28
    //   1665: ldc -1
    //   1667: invokevirtual 188	android/util/TimingLogger:addSplit	(Ljava/lang/String;)V
    //   1670: aload 28
    //   1672: invokevirtual 258	android/util/TimingLogger:dumpToLog	()V
    //   1675: aload_3
    //   1676: iconst_1
    //   1677: iconst_0
    //   1678: invokevirtual 202	drp:a	(IZ)V
    //   1681: goto -1151 -> 530
    //   1684: astore_2
    //   1685: iload 8
    //   1687: istore 6
    //   1689: getstatic 145	drp:b	Ljava/lang/String;
    //   1692: aload_2
    //   1693: ldc_w 351
    //   1696: iconst_0
    //   1697: anewarray 51	java/lang/Object
    //   1700: invokestatic 264	dri:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1703: pop
    //   1704: iload 8
    //   1706: istore 6
    //   1708: aload 4
    //   1710: getfield 357	android/content/SyncResult:stats	Landroid/content/SyncStats;
    //   1713: astore_2
    //   1714: iload 8
    //   1716: istore 6
    //   1718: aload_2
    //   1719: aload_2
    //   1720: getfield 365	android/content/SyncStats:numParseExceptions	J
    //   1723: lconst_1
    //   1724: ladd
    //   1725: putfield 365	android/content/SyncStats:numParseExceptions	J
    //   1728: iload 8
    //   1730: istore 6
    //   1732: aload_3
    //   1733: bipush 7
    //   1735: iconst_1
    //   1736: invokevirtual 349	drp:a	(II)V
    //   1739: aload 29
    //   1741: invokevirtual 234	dsu:c	()Z
    //   1744: ifeq +8 -> 1752
    //   1747: aload_3
    //   1748: iconst_0
    //   1749: invokevirtual 237	drp:a	(Z)V
    //   1752: aload_3
    //   1753: invokevirtual 239	drp:h	()V
    //   1756: aload_3
    //   1757: iconst_1
    //   1758: putfield 242	drp:af	Z
    //   1761: aload_3
    //   1762: iconst_0
    //   1763: putfield 205	drp:B	Z
    //   1766: aload 29
    //   1768: invokevirtual 234	dsu:c	()Z
    //   1771: ifne +8 -> 1779
    //   1774: iload 8
    //   1776: ifeq +22 -> 1798
    //   1779: aload_3
    //   1780: iconst_0
    //   1781: invokevirtual 244	drp:b	(Z)V
    //   1784: aload_3
    //   1785: getfield 248	drp:k	Landroid/content/Context;
    //   1788: aload_3
    //   1789: getfield 209	drp:l	Landroid/accounts/Account;
    //   1792: getfield 107	android/accounts/Account:name	Ljava/lang/String;
    //   1795: invokestatic 253	com/google/android/gm/provider/GmailProvider:c	(Landroid/content/Context;Ljava/lang/String;)V
    //   1798: aload 28
    //   1800: ldc -1
    //   1802: invokevirtual 188	android/util/TimingLogger:addSplit	(Ljava/lang/String;)V
    //   1805: aload 28
    //   1807: invokevirtual 258	android/util/TimingLogger:dumpToLog	()V
    //   1810: aload_3
    //   1811: iconst_1
    //   1812: iconst_0
    //   1813: invokevirtual 202	drp:a	(IZ)V
    //   1816: goto -1286 -> 530
    //   1819: astore_2
    //   1820: iload 9
    //   1822: istore 6
    //   1824: getstatic 145	drp:b	Ljava/lang/String;
    //   1827: aload_2
    //   1828: ldc_w 351
    //   1831: iconst_0
    //   1832: anewarray 51	java/lang/Object
    //   1835: invokestatic 367	dri:c	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1838: pop
    //   1839: iload 9
    //   1841: istore 6
    //   1843: aload_3
    //   1844: bipush 8
    //   1846: iconst_0
    //   1847: invokevirtual 349	drp:a	(II)V
    //   1850: aload 29
    //   1852: invokevirtual 234	dsu:c	()Z
    //   1855: ifeq +8 -> 1863
    //   1858: aload_3
    //   1859: iconst_0
    //   1860: invokevirtual 237	drp:a	(Z)V
    //   1863: aload_3
    //   1864: invokevirtual 239	drp:h	()V
    //   1867: aload_3
    //   1868: iconst_1
    //   1869: putfield 242	drp:af	Z
    //   1872: aload_3
    //   1873: iconst_0
    //   1874: putfield 205	drp:B	Z
    //   1877: aload 29
    //   1879: invokevirtual 234	dsu:c	()Z
    //   1882: ifne +8 -> 1890
    //   1885: iload 9
    //   1887: ifeq +22 -> 1909
    //   1890: aload_3
    //   1891: iconst_0
    //   1892: invokevirtual 244	drp:b	(Z)V
    //   1895: aload_3
    //   1896: getfield 248	drp:k	Landroid/content/Context;
    //   1899: aload_3
    //   1900: getfield 209	drp:l	Landroid/accounts/Account;
    //   1903: getfield 107	android/accounts/Account:name	Ljava/lang/String;
    //   1906: invokestatic 253	com/google/android/gm/provider/GmailProvider:c	(Landroid/content/Context;Ljava/lang/String;)V
    //   1909: aload 28
    //   1911: ldc -1
    //   1913: invokevirtual 188	android/util/TimingLogger:addSplit	(Ljava/lang/String;)V
    //   1916: aload 28
    //   1918: invokevirtual 258	android/util/TimingLogger:dumpToLog	()V
    //   1921: aload_3
    //   1922: iconst_1
    //   1923: iconst_0
    //   1924: invokevirtual 202	drp:a	(IZ)V
    //   1927: goto -1397 -> 530
    //   1930: astore_2
    //   1931: iload 10
    //   1933: istore 6
    //   1935: aload_3
    //   1936: bipush 16
    //   1938: iconst_0
    //   1939: invokevirtual 349	drp:a	(II)V
    //   1942: aload 29
    //   1944: invokevirtual 234	dsu:c	()Z
    //   1947: ifeq +8 -> 1955
    //   1950: aload_3
    //   1951: iconst_0
    //   1952: invokevirtual 237	drp:a	(Z)V
    //   1955: aload_3
    //   1956: invokevirtual 239	drp:h	()V
    //   1959: aload_3
    //   1960: iconst_1
    //   1961: putfield 242	drp:af	Z
    //   1964: aload_3
    //   1965: iconst_0
    //   1966: putfield 205	drp:B	Z
    //   1969: aload 29
    //   1971: invokevirtual 234	dsu:c	()Z
    //   1974: ifne +8 -> 1982
    //   1977: iload 10
    //   1979: ifeq +22 -> 2001
    //   1982: aload_3
    //   1983: iconst_0
    //   1984: invokevirtual 244	drp:b	(Z)V
    //   1987: aload_3
    //   1988: getfield 248	drp:k	Landroid/content/Context;
    //   1991: aload_3
    //   1992: getfield 209	drp:l	Landroid/accounts/Account;
    //   1995: getfield 107	android/accounts/Account:name	Ljava/lang/String;
    //   1998: invokestatic 253	com/google/android/gm/provider/GmailProvider:c	(Landroid/content/Context;Ljava/lang/String;)V
    //   2001: aload 28
    //   2003: ldc -1
    //   2005: invokevirtual 188	android/util/TimingLogger:addSplit	(Ljava/lang/String;)V
    //   2008: aload 28
    //   2010: invokevirtual 258	android/util/TimingLogger:dumpToLog	()V
    //   2013: aload_3
    //   2014: iconst_1
    //   2015: iconst_0
    //   2016: invokevirtual 202	drp:a	(IZ)V
    //   2019: goto -1489 -> 530
    //   2022: astore_2
    //   2023: iload 11
    //   2025: istore 6
    //   2027: getstatic 145	drp:b	Ljava/lang/String;
    //   2030: aload_2
    //   2031: ldc_w 351
    //   2034: iconst_0
    //   2035: anewarray 51	java/lang/Object
    //   2038: invokestatic 264	dri:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   2041: pop
    //   2042: iload 11
    //   2044: istore 6
    //   2046: aload 4
    //   2048: getfield 357	android/content/SyncResult:stats	Landroid/content/SyncStats;
    //   2051: astore_2
    //   2052: iload 11
    //   2054: istore 6
    //   2056: aload_2
    //   2057: aload_2
    //   2058: getfield 370	android/content/SyncStats:numIoExceptions	J
    //   2061: lconst_1
    //   2062: ladd
    //   2063: putfield 370	android/content/SyncStats:numIoExceptions	J
    //   2066: iload 11
    //   2068: istore 6
    //   2070: aload_3
    //   2071: iconst_1
    //   2072: iconst_0
    //   2073: invokevirtual 349	drp:a	(II)V
    //   2076: aload 29
    //   2078: invokevirtual 234	dsu:c	()Z
    //   2081: ifeq +8 -> 2089
    //   2084: aload_3
    //   2085: iconst_0
    //   2086: invokevirtual 237	drp:a	(Z)V
    //   2089: aload_3
    //   2090: invokevirtual 239	drp:h	()V
    //   2093: aload_3
    //   2094: iconst_1
    //   2095: putfield 242	drp:af	Z
    //   2098: aload_3
    //   2099: iconst_0
    //   2100: putfield 205	drp:B	Z
    //   2103: aload 29
    //   2105: invokevirtual 234	dsu:c	()Z
    //   2108: ifne +8 -> 2116
    //   2111: iload 11
    //   2113: ifeq +22 -> 2135
    //   2116: aload_3
    //   2117: iconst_0
    //   2118: invokevirtual 244	drp:b	(Z)V
    //   2121: aload_3
    //   2122: getfield 248	drp:k	Landroid/content/Context;
    //   2125: aload_3
    //   2126: getfield 209	drp:l	Landroid/accounts/Account;
    //   2129: getfield 107	android/accounts/Account:name	Ljava/lang/String;
    //   2132: invokestatic 253	com/google/android/gm/provider/GmailProvider:c	(Landroid/content/Context;Ljava/lang/String;)V
    //   2135: aload 28
    //   2137: ldc -1
    //   2139: invokevirtual 188	android/util/TimingLogger:addSplit	(Ljava/lang/String;)V
    //   2142: aload 28
    //   2144: invokevirtual 258	android/util/TimingLogger:dumpToLog	()V
    //   2147: aload_3
    //   2148: iconst_1
    //   2149: iconst_0
    //   2150: invokevirtual 202	drp:a	(IZ)V
    //   2153: goto -1623 -> 530
    //   2156: astore_2
    //   2157: iload 12
    //   2159: istore 6
    //   2161: getstatic 145	drp:b	Ljava/lang/String;
    //   2164: aload_2
    //   2165: ldc_w 351
    //   2168: iconst_0
    //   2169: anewarray 51	java/lang/Object
    //   2172: invokestatic 264	dri:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   2175: pop
    //   2176: iload 12
    //   2178: istore 6
    //   2180: aload_3
    //   2181: iconst_3
    //   2182: iconst_0
    //   2183: invokevirtual 349	drp:a	(II)V
    //   2186: iload 12
    //   2188: istore 6
    //   2190: aload 4
    //   2192: getfield 357	android/content/SyncResult:stats	Landroid/content/SyncStats;
    //   2195: astore_2
    //   2196: iload 12
    //   2198: istore 6
    //   2200: aload_2
    //   2201: aload_2
    //   2202: getfield 365	android/content/SyncStats:numParseExceptions	J
    //   2205: lconst_1
    //   2206: ladd
    //   2207: putfield 365	android/content/SyncStats:numParseExceptions	J
    //   2210: aload 29
    //   2212: invokevirtual 234	dsu:c	()Z
    //   2215: ifeq +8 -> 2223
    //   2218: aload_3
    //   2219: iconst_0
    //   2220: invokevirtual 237	drp:a	(Z)V
    //   2223: aload_3
    //   2224: invokevirtual 239	drp:h	()V
    //   2227: aload_3
    //   2228: iconst_1
    //   2229: putfield 242	drp:af	Z
    //   2232: aload_3
    //   2233: iconst_0
    //   2234: putfield 205	drp:B	Z
    //   2237: aload 29
    //   2239: invokevirtual 234	dsu:c	()Z
    //   2242: ifne +8 -> 2250
    //   2245: iload 12
    //   2247: ifeq +22 -> 2269
    //   2250: aload_3
    //   2251: iconst_0
    //   2252: invokevirtual 244	drp:b	(Z)V
    //   2255: aload_3
    //   2256: getfield 248	drp:k	Landroid/content/Context;
    //   2259: aload_3
    //   2260: getfield 209	drp:l	Landroid/accounts/Account;
    //   2263: getfield 107	android/accounts/Account:name	Ljava/lang/String;
    //   2266: invokestatic 253	com/google/android/gm/provider/GmailProvider:c	(Landroid/content/Context;Ljava/lang/String;)V
    //   2269: aload 28
    //   2271: ldc -1
    //   2273: invokevirtual 188	android/util/TimingLogger:addSplit	(Ljava/lang/String;)V
    //   2276: aload 28
    //   2278: invokevirtual 258	android/util/TimingLogger:dumpToLog	()V
    //   2281: aload_3
    //   2282: iconst_1
    //   2283: iconst_0
    //   2284: invokevirtual 202	drp:a	(IZ)V
    //   2287: goto -1757 -> 530
    //   2290: astore_2
    //   2291: aload 29
    //   2293: invokevirtual 234	dsu:c	()Z
    //   2296: ifeq +8 -> 2304
    //   2299: aload_3
    //   2300: iconst_0
    //   2301: invokevirtual 237	drp:a	(Z)V
    //   2304: aload_3
    //   2305: invokevirtual 239	drp:h	()V
    //   2308: aload_3
    //   2309: iconst_1
    //   2310: putfield 242	drp:af	Z
    //   2313: aload_3
    //   2314: iconst_0
    //   2315: putfield 205	drp:B	Z
    //   2318: aload 29
    //   2320: invokevirtual 234	dsu:c	()Z
    //   2323: ifne +8 -> 2331
    //   2326: iload 6
    //   2328: ifeq +22 -> 2350
    //   2331: aload_3
    //   2332: iconst_0
    //   2333: invokevirtual 244	drp:b	(Z)V
    //   2336: aload_3
    //   2337: getfield 248	drp:k	Landroid/content/Context;
    //   2340: aload_3
    //   2341: getfield 209	drp:l	Landroid/accounts/Account;
    //   2344: getfield 107	android/accounts/Account:name	Ljava/lang/String;
    //   2347: invokestatic 253	com/google/android/gm/provider/GmailProvider:c	(Landroid/content/Context;Ljava/lang/String;)V
    //   2350: aload 28
    //   2352: ldc -1
    //   2354: invokevirtual 188	android/util/TimingLogger:addSplit	(Ljava/lang/String;)V
    //   2357: aload 28
    //   2359: invokevirtual 258	android/util/TimingLogger:dumpToLog	()V
    //   2362: aload_3
    //   2363: iconst_1
    //   2364: iconst_0
    //   2365: invokevirtual 202	drp:a	(IZ)V
    //   2368: aload_2
    //   2369: athrow
    //   2370: astore_3
    //   2371: aload_2
    //   2372: monitorexit
    //   2373: aload_3
    //   2374: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2375	0	this	dtz
    //   0	2375	1	paramAccount	Account
    //   0	2375	3	paramContentProviderClient	ContentProviderClient
    //   0	2375	4	paramSyncResult	SyncResult
    //   332	1143	5	i	int
    //   250	2077	6	j	int
    //   226	1414	7	k	int
    //   230	1545	8	m	int
    //   234	1652	9	n	int
    //   238	1740	10	i1	int
    //   242	1870	11	i2	int
    //   246	2000	12	i3	int
    //   179	1144	13	i4	int
    //   203	1116	14	i5	int
    //   182	1107	15	i6	int
    //   185	1108	16	i7	int
    //   188	1109	17	i8	int
    //   191	1110	18	i9	int
    //   194	1111	19	i10	int
    //   197	1112	20	i11	int
    //   200	1113	21	i12	int
    //   328	7	22	i13	int
    //   42	60	23	l1	long
    //   84	16	25	l2	long
    //   451	883	27	bool	boolean
    //   53	647	28	localObject1	Object
    //   713	1645	28	localObject2	Object
    //   176	2143	29	localdsu	dsu
    //   767	563	30	localdtd	dtd
    //   1519	29	30	localObject3	Object
    //   1131	77	31	str	String
    // Exception table:
    //   from	to	target	type
    //   537	544	547	finally
    //   548	550	547	finally
    //   39	58	552	android/database/SQLException
    //   81	94	552	android/database/SQLException
    //   98	107	552	android/database/SQLException
    //   530	537	552	android/database/SQLException
    //   550	552	552	android/database/SQLException
    //   600	602	552	android/database/SQLException
    //   715	722	552	android/database/SQLException
    //   729	732	552	android/database/SQLException
    //   2373	2375	552	android/database/SQLException
    //   58	81	596	finally
    //   130	140	596	finally
    //   597	600	596	finally
    //   39	58	602	finally
    //   81	94	602	finally
    //   98	107	602	finally
    //   530	537	602	finally
    //   550	552	602	finally
    //   553	573	602	finally
    //   600	602	602	finally
    //   715	722	602	finally
    //   729	732	602	finally
    //   2373	2375	602	finally
    //   140	178	713	finally
    //   205	224	713	finally
    //   458	471	713	finally
    //   471	512	713	finally
    //   512	530	713	finally
    //   638	651	713	finally
    //   651	692	713	finally
    //   692	710	713	finally
    //   1439	1452	713	finally
    //   1452	1474	713	finally
    //   1479	1498	713	finally
    //   1498	1516	713	finally
    //   1604	1617	713	finally
    //   1617	1639	713	finally
    //   1644	1663	713	finally
    //   1663	1681	713	finally
    //   1739	1752	713	finally
    //   1752	1774	713	finally
    //   1779	1798	713	finally
    //   1798	1816	713	finally
    //   1850	1863	713	finally
    //   1863	1885	713	finally
    //   1890	1909	713	finally
    //   1909	1927	713	finally
    //   1942	1955	713	finally
    //   1955	1977	713	finally
    //   1982	2001	713	finally
    //   2001	2019	713	finally
    //   2076	2089	713	finally
    //   2089	2111	713	finally
    //   2116	2135	713	finally
    //   2135	2153	713	finally
    //   2210	2223	713	finally
    //   2223	2245	713	finally
    //   2250	2269	713	finally
    //   2269	2287	713	finally
    //   2291	2304	713	finally
    //   2304	2326	713	finally
    //   2331	2350	713	finally
    //   2350	2370	713	finally
    //   1326	1341	1519	finally
    //   1348	1363	1519	finally
    //   1367	1383	1519	finally
    //   1387	1399	1519	finally
    //   1403	1405	1519	finally
    //   1521	1523	1519	finally
    //   252	258	1550	dsj
    //   286	291	1550	dsj
    //   319	330	1550	dsj
    //   367	374	1550	dsj
    //   405	416	1550	dsj
    //   444	453	1550	dsj
    //   760	769	1550	dsj
    //   797	808	1550	dsj
    //   836	842	1550	dsj
    //   870	882	1550	dsj
    //   910	922	1550	dsj
    //   950	986	1550	dsj
    //   1014	1024	1550	dsj
    //   1052	1058	1550	dsj
    //   1086	1096	1550	dsj
    //   1124	1133	1550	dsj
    //   1161	1173	1550	dsj
    //   1201	1218	1550	dsj
    //   1246	1255	1550	dsj
    //   1283	1288	1550	dsj
    //   1316	1318	1550	dsj
    //   1433	1439	1550	dsj
    //   1547	1550	1550	dsj
    //   252	258	1684	dty
    //   286	291	1684	dty
    //   319	330	1684	dty
    //   367	374	1684	dty
    //   405	416	1684	dty
    //   444	453	1684	dty
    //   760	769	1684	dty
    //   797	808	1684	dty
    //   836	842	1684	dty
    //   870	882	1684	dty
    //   910	922	1684	dty
    //   950	986	1684	dty
    //   1014	1024	1684	dty
    //   1052	1058	1684	dty
    //   1086	1096	1684	dty
    //   1124	1133	1684	dty
    //   1161	1173	1684	dty
    //   1201	1218	1684	dty
    //   1246	1255	1684	dty
    //   1283	1288	1684	dty
    //   1316	1318	1684	dty
    //   1433	1439	1684	dty
    //   1547	1550	1684	dty
    //   252	258	1819	android/accounts/OperationCanceledException
    //   286	291	1819	android/accounts/OperationCanceledException
    //   319	330	1819	android/accounts/OperationCanceledException
    //   367	374	1819	android/accounts/OperationCanceledException
    //   405	416	1819	android/accounts/OperationCanceledException
    //   444	453	1819	android/accounts/OperationCanceledException
    //   760	769	1819	android/accounts/OperationCanceledException
    //   797	808	1819	android/accounts/OperationCanceledException
    //   836	842	1819	android/accounts/OperationCanceledException
    //   870	882	1819	android/accounts/OperationCanceledException
    //   910	922	1819	android/accounts/OperationCanceledException
    //   950	986	1819	android/accounts/OperationCanceledException
    //   1014	1024	1819	android/accounts/OperationCanceledException
    //   1052	1058	1819	android/accounts/OperationCanceledException
    //   1086	1096	1819	android/accounts/OperationCanceledException
    //   1124	1133	1819	android/accounts/OperationCanceledException
    //   1161	1173	1819	android/accounts/OperationCanceledException
    //   1201	1218	1819	android/accounts/OperationCanceledException
    //   1246	1255	1819	android/accounts/OperationCanceledException
    //   1283	1288	1819	android/accounts/OperationCanceledException
    //   1316	1318	1819	android/accounts/OperationCanceledException
    //   1433	1439	1819	android/accounts/OperationCanceledException
    //   1547	1550	1819	android/accounts/OperationCanceledException
    //   252	258	1930	dtf
    //   286	291	1930	dtf
    //   319	330	1930	dtf
    //   367	374	1930	dtf
    //   405	416	1930	dtf
    //   444	453	1930	dtf
    //   760	769	1930	dtf
    //   797	808	1930	dtf
    //   836	842	1930	dtf
    //   870	882	1930	dtf
    //   910	922	1930	dtf
    //   950	986	1930	dtf
    //   1014	1024	1930	dtf
    //   1052	1058	1930	dtf
    //   1086	1096	1930	dtf
    //   1124	1133	1930	dtf
    //   1161	1173	1930	dtf
    //   1201	1218	1930	dtf
    //   1246	1255	1930	dtf
    //   1283	1288	1930	dtf
    //   1316	1318	1930	dtf
    //   1433	1439	1930	dtf
    //   1547	1550	1930	dtf
    //   252	258	2022	java/io/IOException
    //   286	291	2022	java/io/IOException
    //   319	330	2022	java/io/IOException
    //   367	374	2022	java/io/IOException
    //   405	416	2022	java/io/IOException
    //   444	453	2022	java/io/IOException
    //   760	769	2022	java/io/IOException
    //   797	808	2022	java/io/IOException
    //   836	842	2022	java/io/IOException
    //   870	882	2022	java/io/IOException
    //   910	922	2022	java/io/IOException
    //   950	986	2022	java/io/IOException
    //   1014	1024	2022	java/io/IOException
    //   1052	1058	2022	java/io/IOException
    //   1086	1096	2022	java/io/IOException
    //   1124	1133	2022	java/io/IOException
    //   1161	1173	2022	java/io/IOException
    //   1201	1218	2022	java/io/IOException
    //   1246	1255	2022	java/io/IOException
    //   1283	1288	2022	java/io/IOException
    //   1316	1318	2022	java/io/IOException
    //   1433	1439	2022	java/io/IOException
    //   1547	1550	2022	java/io/IOException
    //   252	258	2156	dsl
    //   286	291	2156	dsl
    //   319	330	2156	dsl
    //   367	374	2156	dsl
    //   405	416	2156	dsl
    //   444	453	2156	dsl
    //   760	769	2156	dsl
    //   797	808	2156	dsl
    //   836	842	2156	dsl
    //   870	882	2156	dsl
    //   910	922	2156	dsl
    //   950	986	2156	dsl
    //   1014	1024	2156	dsl
    //   1052	1058	2156	dsl
    //   1086	1096	2156	dsl
    //   1124	1133	2156	dsl
    //   1161	1173	2156	dsl
    //   1201	1218	2156	dsl
    //   1246	1255	2156	dsl
    //   1283	1288	2156	dsl
    //   1316	1318	2156	dsl
    //   1433	1439	2156	dsl
    //   1547	1550	2156	dsl
    //   252	258	2290	finally
    //   286	291	2290	finally
    //   319	330	2290	finally
    //   367	374	2290	finally
    //   405	416	2290	finally
    //   444	453	2290	finally
    //   760	769	2290	finally
    //   797	808	2290	finally
    //   836	842	2290	finally
    //   870	882	2290	finally
    //   910	922	2290	finally
    //   950	986	2290	finally
    //   1014	1024	2290	finally
    //   1052	1058	2290	finally
    //   1086	1096	2290	finally
    //   1124	1133	2290	finally
    //   1161	1173	2290	finally
    //   1201	1218	2290	finally
    //   1246	1255	2290	finally
    //   1283	1288	2290	finally
    //   1316	1318	2290	finally
    //   1433	1439	2290	finally
    //   1547	1550	2290	finally
    //   1555	1570	2290	finally
    //   1574	1580	2290	finally
    //   1584	1594	2290	finally
    //   1598	1604	2290	finally
    //   1689	1704	2290	finally
    //   1708	1714	2290	finally
    //   1718	1728	2290	finally
    //   1732	1739	2290	finally
    //   1824	1839	2290	finally
    //   1843	1850	2290	finally
    //   1935	1942	2290	finally
    //   2027	2042	2290	finally
    //   2046	2052	2290	finally
    //   2056	2066	2290	finally
    //   2070	2076	2290	finally
    //   2161	2176	2290	finally
    //   2180	2186	2290	finally
    //   2190	2196	2290	finally
    //   2200	2210	2290	finally
    //   722	729	2370	finally
    //   2371	2373	2370	finally
  }
  
  public final void onPerformSync(Account paramAccount, Bundle paramBundle, String paramString, ContentProviderClient paramContentProviderClient, SyncResult paramSyncResult)
  {
    if ((paramBundle != null) && (paramBundle.getBoolean("initialize", false)))
    {
      dri.c("Gmail", "SyncAdapterImpl.onPerformSync: Received initialize sync extra", new Object[0]);
      ContentResolver.setIsSyncable(paramAccount, paramString, 1);
      ContentResolver.setSyncAutomatically(paramAccount, paramString, true);
      return;
    }
    super.onPerformSync(paramAccount, paramBundle, paramString, paramContentProviderClient, paramSyncResult);
  }
  
  public final void onSyncCanceled(Thread paramThread)
  {
    dri.d("Gmail", "MailSyncAdapterService#onSyncCanceled %s", new Object[] { paramThread });
    if (a != null)
    {
      dri.d("Gmail", "MailEngine != null account: %s", new Object[] { dri.a(a.l.name) });
      a.D();
    }
    super.onSyncCanceled(paramThread);
  }
}

/* Location:
 * Qualified Name:     dtz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */