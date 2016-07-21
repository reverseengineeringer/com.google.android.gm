import android.content.Context;
import android.content.SyncResult;

final class bbj
  extends bgp
{
  public bbj(bbi parambbi, Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void a(long paramLong1, long paramLong2, SyncResult paramSyncResult) {}
  
  /* Error */
  public final void a(android.accounts.Account paramAccount, android.os.Bundle paramBundle, android.content.ContentProviderClient paramContentProviderClient, SyncResult paramSyncResult)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 10	bbj:a	Lbbi;
    //   4: astore 14
    //   6: aload_0
    //   7: invokevirtual 22	bbj:getContext	()Landroid/content/Context;
    //   10: astore 15
    //   12: new 24	bbk
    //   15: dup
    //   16: aload 15
    //   18: aload_1
    //   19: getfield 30	android/accounts/Account:name	Ljava/lang/String;
    //   22: invokespecial 33	bbk:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   25: astore 13
    //   27: aload 13
    //   29: getstatic 38	bbi:a	Ljava/lang/Long;
    //   32: invokevirtual 44	java/lang/Long:longValue	()J
    //   35: putfield 50	cgu:s	J
    //   38: aload 13
    //   40: getfield 53	cgu:n	J
    //   43: invokestatic 57	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   46: putstatic 38	bbi:a	Ljava/lang/Long;
    //   49: aconst_null
    //   50: astore 12
    //   52: aload_3
    //   53: getstatic 62	com/android/emailcommon/provider/Account:a	Landroid/net/Uri;
    //   56: getstatic 66	com/android/emailcommon/provider/Account:y	[Ljava/lang/String;
    //   59: ldc 68
    //   61: iconst_1
    //   62: anewarray 70	java/lang/String
    //   65: dup
    //   66: iconst_0
    //   67: aload_1
    //   68: getfield 30	android/accounts/Account:name	Ljava/lang/String;
    //   71: aastore
    //   72: aconst_null
    //   73: invokevirtual 76	android/content/ContentProviderClient:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   76: astore_3
    //   77: aload_3
    //   78: ifnull +19 -> 97
    //   81: aload_3
    //   82: astore 12
    //   84: aload_3
    //   85: invokeinterface 82 1 0
    //   90: istore 7
    //   92: iload 7
    //   94: ifne +168 -> 262
    //   97: aload_3
    //   98: ifnull +9 -> 107
    //   101: aload_3
    //   102: invokeinterface 86 1 0
    //   107: aload 4
    //   109: ifnull +13 -> 122
    //   112: aload 13
    //   114: aload 4
    //   116: invokevirtual 92	android/content/SyncResult:toString	()Ljava/lang/String;
    //   119: putfield 95	bbk:j	Ljava/lang/String;
    //   122: aload 13
    //   124: invokevirtual 98	bbk:d	()V
    //   127: aload 14
    //   129: aload 13
    //   131: invokevirtual 101	bbi:a	(Lbbk;)V
    //   134: aload 13
    //   136: getfield 105	bbk:c	Z
    //   139: ifeq +84 -> 223
    //   142: ldc 107
    //   144: astore_2
    //   145: aload_1
    //   146: getfield 30	android/accounts/Account:name	Ljava/lang/String;
    //   149: invokestatic 112	cui:d	(Ljava/lang/String;)Ljava/lang/String;
    //   152: astore_3
    //   153: invokestatic 117	buo:a	()Lbut;
    //   156: astore 4
    //   158: aload 13
    //   160: getfield 121	bbk:k	Ljava/lang/Exception;
    //   163: ifnonnull +72 -> 235
    //   166: aload 13
    //   168: getfield 105	bbk:c	Z
    //   171: ifeq +58 -> 229
    //   174: ldc 123
    //   176: astore_1
    //   177: aload 4
    //   179: aload_1
    //   180: bipush 100
    //   182: invokeinterface 128 3 0
    //   187: ifeq +35 -> 222
    //   190: aload 4
    //   192: aload_2
    //   193: aload 13
    //   195: getfield 131	cgu:p	J
    //   198: ldc -123
    //   200: aload_3
    //   201: invokeinterface 136 6 0
    //   206: aload 4
    //   208: aload_2
    //   209: aload 13
    //   211: getfield 139	cgu:r	J
    //   214: ldc -115
    //   216: aload_3
    //   217: invokeinterface 144 6 0
    //   222: return
    //   223: ldc -110
    //   225: astore_2
    //   226: goto -81 -> 145
    //   229: ldc -108
    //   231: astore_1
    //   232: goto -55 -> 177
    //   235: aload 4
    //   237: aload_2
    //   238: invokestatic 151	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   241: ldc -103
    //   243: invokevirtual 156	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   246: aload_3
    //   247: aload 13
    //   249: getfield 121	bbk:k	Ljava/lang/Exception;
    //   252: invokevirtual 157	java/lang/Exception:toString	()Ljava/lang/String;
    //   255: lconst_0
    //   256: invokeinterface 160 6 0
    //   261: return
    //   262: aload_3
    //   263: astore 12
    //   265: new 59	com/android/emailcommon/provider/Account
    //   268: dup
    //   269: invokespecial 162	com/android/emailcommon/provider/Account:<init>	()V
    //   272: astore 16
    //   274: aload_3
    //   275: astore 12
    //   277: aload 16
    //   279: aload_3
    //   280: invokevirtual 165	com/android/emailcommon/provider/Account:a	(Landroid/database/Cursor;)V
    //   283: aload_3
    //   284: astore 12
    //   286: aload 15
    //   288: aload 16
    //   290: getfield 168	com/android/emailcommon/provider/Account:D	J
    //   293: iconst_4
    //   294: invokestatic 173	com/android/emailcommon/provider/Mailbox:a	(Landroid/content/Context;JI)J
    //   297: lstore 8
    //   299: aload_3
    //   300: astore 12
    //   302: aload_2
    //   303: ldc -81
    //   305: invokevirtual 181	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   308: ifeq +320 -> 628
    //   311: aload_3
    //   312: astore 12
    //   314: aload 13
    //   316: iconst_1
    //   317: putfield 183	bbk:a	Z
    //   320: aload_3
    //   321: astore 12
    //   323: ldc -71
    //   325: ldc -69
    //   327: iconst_1
    //   328: anewarray 189	java/lang/Object
    //   331: dup
    //   332: iconst_0
    //   333: aload 16
    //   335: getfield 168	com/android/emailcommon/provider/Account:D	J
    //   338: invokestatic 57	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   341: aastore
    //   342: invokestatic 194	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   345: pop
    //   346: aload_3
    //   347: astore 12
    //   349: new 196	java/util/LinkedHashSet
    //   352: dup
    //   353: invokespecial 197	java/util/LinkedHashSet:<init>	()V
    //   356: astore_2
    //   357: aload_3
    //   358: astore 12
    //   360: aload_2
    //   361: aload 15
    //   363: invokevirtual 203	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   366: aload 16
    //   368: getfield 168	com/android/emailcommon/provider/Account:D	J
    //   371: invokestatic 208	bed:b	(Landroid/content/ContentResolver;J)Ljava/util/Set;
    //   374: invokeinterface 214 2 0
    //   379: pop
    //   380: aload_3
    //   381: astore 12
    //   383: aload_2
    //   384: aload 15
    //   386: invokevirtual 203	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   389: aload 16
    //   391: getfield 168	com/android/emailcommon/provider/Account:D	J
    //   394: invokestatic 218	beg:a	(Landroid/content/ContentResolver;J)Ljava/util/Set;
    //   397: invokeinterface 214 2 0
    //   402: pop
    //   403: lload 8
    //   405: ldc2_w 219
    //   408: lcmp
    //   409: ifeq +18 -> 427
    //   412: aload_3
    //   413: astore 12
    //   415: aload_2
    //   416: lload 8
    //   418: invokestatic 57	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   421: invokeinterface 224 2 0
    //   426: pop
    //   427: aload_3
    //   428: astore 12
    //   430: aload_2
    //   431: invokeinterface 228 1 0
    //   436: astore_2
    //   437: aload_3
    //   438: astore 12
    //   440: aload_2
    //   441: invokeinterface 233 1 0
    //   446: ifeq +690 -> 1136
    //   449: aload_3
    //   450: astore 12
    //   452: aload 15
    //   454: aload_2
    //   455: invokeinterface 237 1 0
    //   460: checkcast 40	java/lang/Long
    //   463: invokevirtual 44	java/lang/Long:longValue	()J
    //   466: iconst_0
    //   467: iconst_0
    //   468: aload 13
    //   470: invokestatic 240	bbi:a	(Landroid/content/Context;JZILbbk;)V
    //   473: goto -36 -> 437
    //   476: astore 12
    //   478: aload_3
    //   479: astore_2
    //   480: aload 12
    //   482: astore_3
    //   483: ldc -71
    //   485: aload_3
    //   486: ldc -14
    //   488: iconst_0
    //   489: anewarray 189	java/lang/Object
    //   492: invokestatic 246	cvm:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   495: pop
    //   496: aload 13
    //   498: aload_3
    //   499: putfield 121	bbk:k	Ljava/lang/Exception;
    //   502: aload_2
    //   503: ifnull +9 -> 512
    //   506: aload_2
    //   507: invokeinterface 86 1 0
    //   512: aload 4
    //   514: ifnull +13 -> 527
    //   517: aload 13
    //   519: aload 4
    //   521: invokevirtual 92	android/content/SyncResult:toString	()Ljava/lang/String;
    //   524: putfield 95	bbk:j	Ljava/lang/String;
    //   527: aload 13
    //   529: invokevirtual 98	bbk:d	()V
    //   532: aload 14
    //   534: aload 13
    //   536: invokevirtual 101	bbi:a	(Lbbk;)V
    //   539: aload 13
    //   541: getfield 105	bbk:c	Z
    //   544: ifeq +757 -> 1301
    //   547: ldc 107
    //   549: astore_2
    //   550: aload_1
    //   551: getfield 30	android/accounts/Account:name	Ljava/lang/String;
    //   554: invokestatic 112	cui:d	(Ljava/lang/String;)Ljava/lang/String;
    //   557: astore_3
    //   558: invokestatic 117	buo:a	()Lbut;
    //   561: astore 4
    //   563: aload 13
    //   565: getfield 121	bbk:k	Ljava/lang/Exception;
    //   568: ifnonnull +745 -> 1313
    //   571: aload 13
    //   573: getfield 105	bbk:c	Z
    //   576: ifeq +731 -> 1307
    //   579: ldc 123
    //   581: astore_1
    //   582: aload 4
    //   584: aload_1
    //   585: bipush 100
    //   587: invokeinterface 128 3 0
    //   592: ifeq -370 -> 222
    //   595: aload 4
    //   597: aload_2
    //   598: aload 13
    //   600: getfield 131	cgu:p	J
    //   603: ldc -123
    //   605: aload_3
    //   606: invokeinterface 136 6 0
    //   611: aload 4
    //   613: aload_2
    //   614: aload 13
    //   616: getfield 139	cgu:r	J
    //   619: ldc -115
    //   621: aload_3
    //   622: invokeinterface 144 6 0
    //   627: return
    //   628: aload_3
    //   629: astore 12
    //   631: ldc -71
    //   633: ldc -8
    //   635: iconst_1
    //   636: anewarray 189	java/lang/Object
    //   639: dup
    //   640: iconst_0
    //   641: aload 16
    //   643: getfield 168	com/android/emailcommon/provider/Account:D	J
    //   646: invokestatic 57	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   649: aastore
    //   650: invokestatic 194	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   653: pop
    //   654: aload_3
    //   655: astore 12
    //   657: ldc -71
    //   659: ldc -6
    //   661: iconst_1
    //   662: anewarray 189	java/lang/Object
    //   665: dup
    //   666: iconst_0
    //   667: aload_2
    //   668: invokevirtual 251	android/os/Bundle:toString	()Ljava/lang/String;
    //   671: aastore
    //   672: invokestatic 194	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   675: pop
    //   676: aload_3
    //   677: astore 12
    //   679: aload 15
    //   681: aload 16
    //   683: getfield 168	com/android/emailcommon/provider/Account:D	J
    //   686: invokestatic 256	bam:a	(Landroid/content/Context;J)Lber;
    //   689: aload 16
    //   691: getfield 168	com/android/emailcommon/provider/Account:D	J
    //   694: invokeinterface 261 3 0
    //   699: aload_3
    //   700: astore 12
    //   702: aload_2
    //   703: invokestatic 264	com/android/emailcommon/provider/Mailbox:a	(Landroid/os/Bundle;)[J
    //   706: astore 17
    //   708: aload_3
    //   709: astore 12
    //   711: new 196	java/util/LinkedHashSet
    //   714: dup
    //   715: invokespecial 197	java/util/LinkedHashSet:<init>	()V
    //   718: astore 18
    //   720: aload_3
    //   721: astore 12
    //   723: aload 15
    //   725: aload 16
    //   727: getfield 168	com/android/emailcommon/provider/Account:D	J
    //   730: iconst_0
    //   731: invokestatic 173	com/android/emailcommon/provider/Mailbox:a	(Landroid/content/Context;JI)J
    //   734: lstore 10
    //   736: aload 17
    //   738: ifnull +56 -> 794
    //   741: aload_3
    //   742: astore 12
    //   744: aload 17
    //   746: arraylength
    //   747: ifle +47 -> 794
    //   750: aload_3
    //   751: astore 12
    //   753: aload 17
    //   755: arraylength
    //   756: istore 6
    //   758: iconst_0
    //   759: istore 5
    //   761: iload 5
    //   763: iload 6
    //   765: if_icmpge +75 -> 840
    //   768: aload_3
    //   769: astore 12
    //   771: aload 18
    //   773: aload 17
    //   775: iload 5
    //   777: laload
    //   778: invokestatic 57	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   781: invokevirtual 265	java/util/LinkedHashSet:add	(Ljava/lang/Object;)Z
    //   784: pop
    //   785: iload 5
    //   787: iconst_1
    //   788: iadd
    //   789: istore 5
    //   791: goto -30 -> 761
    //   794: lload 10
    //   796: ldc2_w 219
    //   799: lcmp
    //   800: ifeq +17 -> 817
    //   803: aload_3
    //   804: astore 12
    //   806: aload 18
    //   808: lload 10
    //   810: invokestatic 57	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   813: invokevirtual 265	java/util/LinkedHashSet:add	(Ljava/lang/Object;)Z
    //   816: pop
    //   817: lload 8
    //   819: ldc2_w 219
    //   822: lcmp
    //   823: ifeq +17 -> 840
    //   826: aload_3
    //   827: astore 12
    //   829: aload 18
    //   831: lload 8
    //   833: invokestatic 57	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   836: invokevirtual 265	java/util/LinkedHashSet:add	(Ljava/lang/Object;)Z
    //   839: pop
    //   840: aload_3
    //   841: astore 12
    //   843: aload 15
    //   845: aload 16
    //   847: invokestatic 268	bbi:a	(Landroid/content/Context;Lcom/android/emailcommon/provider/Account;)Z
    //   850: ifeq +67 -> 917
    //   853: lload 10
    //   855: ldc2_w 219
    //   858: lcmp
    //   859: ifeq +58 -> 917
    //   862: aload_3
    //   863: astore 12
    //   865: aload 18
    //   867: lload 10
    //   869: invokestatic 57	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   872: invokevirtual 271	java/util/LinkedHashSet:contains	(Ljava/lang/Object;)Z
    //   875: ifeq +42 -> 917
    //   878: aload_3
    //   879: astore 12
    //   881: aload 15
    //   883: aload 16
    //   885: getfield 168	com/android/emailcommon/provider/Account:D	J
    //   888: iconst_5
    //   889: invokestatic 173	com/android/emailcommon/provider/Mailbox:a	(Landroid/content/Context;JI)J
    //   892: lstore 8
    //   894: lload 8
    //   896: ldc2_w 219
    //   899: lcmp
    //   900: ifeq +17 -> 917
    //   903: aload_3
    //   904: astore 12
    //   906: aload 18
    //   908: lload 8
    //   910: invokestatic 57	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   913: invokevirtual 265	java/util/LinkedHashSet:add	(Ljava/lang/Object;)Z
    //   916: pop
    //   917: aload_3
    //   918: astore 12
    //   920: aload_2
    //   921: ldc_w 273
    //   924: iconst_0
    //   925: invokevirtual 276	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   928: istore 7
    //   930: aload_3
    //   931: astore 12
    //   933: aload 13
    //   935: iload 7
    //   937: putfield 278	bbk:b	Z
    //   940: aload_3
    //   941: astore 12
    //   943: aload_2
    //   944: ldc_w 280
    //   947: iconst_0
    //   948: invokevirtual 284	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   951: istore 5
    //   953: aload_3
    //   954: astore 12
    //   956: aload 18
    //   958: invokevirtual 285	java/util/LinkedHashSet:iterator	()Ljava/util/Iterator;
    //   961: astore_2
    //   962: aload_3
    //   963: astore 12
    //   965: aload_2
    //   966: invokeinterface 233 1 0
    //   971: ifeq +165 -> 1136
    //   974: aload_3
    //   975: astore 12
    //   977: aload 15
    //   979: aload_2
    //   980: invokeinterface 237 1 0
    //   985: checkcast 40	java/lang/Long
    //   988: invokevirtual 44	java/lang/Long:longValue	()J
    //   991: iload 7
    //   993: iload 5
    //   995: aload 13
    //   997: invokestatic 240	bbi:a	(Landroid/content/Context;JZILbbk;)V
    //   1000: goto -38 -> 962
    //   1003: astore_2
    //   1004: aload 12
    //   1006: ifnull +10 -> 1016
    //   1009: aload 12
    //   1011: invokeinterface 86 1 0
    //   1016: aload 4
    //   1018: ifnull +13 -> 1031
    //   1021: aload 13
    //   1023: aload 4
    //   1025: invokevirtual 92	android/content/SyncResult:toString	()Ljava/lang/String;
    //   1028: putfield 95	bbk:j	Ljava/lang/String;
    //   1031: aload 13
    //   1033: invokevirtual 98	bbk:d	()V
    //   1036: aload 14
    //   1038: aload 13
    //   1040: invokevirtual 101	bbi:a	(Lbbk;)V
    //   1043: aload 13
    //   1045: getfield 105	bbk:c	Z
    //   1048: ifeq +292 -> 1340
    //   1051: ldc 107
    //   1053: astore_3
    //   1054: aload_1
    //   1055: getfield 30	android/accounts/Account:name	Ljava/lang/String;
    //   1058: invokestatic 112	cui:d	(Ljava/lang/String;)Ljava/lang/String;
    //   1061: astore 4
    //   1063: invokestatic 117	buo:a	()Lbut;
    //   1066: astore 12
    //   1068: aload 13
    //   1070: getfield 121	bbk:k	Ljava/lang/Exception;
    //   1073: ifnonnull +279 -> 1352
    //   1076: aload 13
    //   1078: getfield 105	bbk:c	Z
    //   1081: ifeq +265 -> 1346
    //   1084: ldc 123
    //   1086: astore_1
    //   1087: aload 12
    //   1089: aload_1
    //   1090: bipush 100
    //   1092: invokeinterface 128 3 0
    //   1097: ifeq +37 -> 1134
    //   1100: aload 12
    //   1102: aload_3
    //   1103: aload 13
    //   1105: getfield 131	cgu:p	J
    //   1108: ldc -123
    //   1110: aload 4
    //   1112: invokeinterface 136 6 0
    //   1117: aload 12
    //   1119: aload_3
    //   1120: aload 13
    //   1122: getfield 139	cgu:r	J
    //   1125: ldc -115
    //   1127: aload 4
    //   1129: invokeinterface 144 6 0
    //   1134: aload_2
    //   1135: athrow
    //   1136: aload_3
    //   1137: ifnull +9 -> 1146
    //   1140: aload_3
    //   1141: invokeinterface 86 1 0
    //   1146: aload 4
    //   1148: ifnull +13 -> 1161
    //   1151: aload 13
    //   1153: aload 4
    //   1155: invokevirtual 92	android/content/SyncResult:toString	()Ljava/lang/String;
    //   1158: putfield 95	bbk:j	Ljava/lang/String;
    //   1161: aload 13
    //   1163: invokevirtual 98	bbk:d	()V
    //   1166: aload 14
    //   1168: aload 13
    //   1170: invokevirtual 101	bbi:a	(Lbbk;)V
    //   1173: aload 13
    //   1175: getfield 105	bbk:c	Z
    //   1178: ifeq +84 -> 1262
    //   1181: ldc 107
    //   1183: astore_2
    //   1184: aload_1
    //   1185: getfield 30	android/accounts/Account:name	Ljava/lang/String;
    //   1188: invokestatic 112	cui:d	(Ljava/lang/String;)Ljava/lang/String;
    //   1191: astore_3
    //   1192: invokestatic 117	buo:a	()Lbut;
    //   1195: astore 4
    //   1197: aload 13
    //   1199: getfield 121	bbk:k	Ljava/lang/Exception;
    //   1202: ifnonnull +72 -> 1274
    //   1205: aload 13
    //   1207: getfield 105	bbk:c	Z
    //   1210: ifeq +58 -> 1268
    //   1213: ldc 123
    //   1215: astore_1
    //   1216: aload 4
    //   1218: aload_1
    //   1219: bipush 100
    //   1221: invokeinterface 128 3 0
    //   1226: ifeq -1004 -> 222
    //   1229: aload 4
    //   1231: aload_2
    //   1232: aload 13
    //   1234: getfield 131	cgu:p	J
    //   1237: ldc -123
    //   1239: aload_3
    //   1240: invokeinterface 136 6 0
    //   1245: aload 4
    //   1247: aload_2
    //   1248: aload 13
    //   1250: getfield 139	cgu:r	J
    //   1253: ldc -115
    //   1255: aload_3
    //   1256: invokeinterface 144 6 0
    //   1261: return
    //   1262: ldc -110
    //   1264: astore_2
    //   1265: goto -81 -> 1184
    //   1268: ldc -108
    //   1270: astore_1
    //   1271: goto -55 -> 1216
    //   1274: aload 4
    //   1276: aload_2
    //   1277: invokestatic 151	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1280: ldc -103
    //   1282: invokevirtual 156	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1285: aload_3
    //   1286: aload 13
    //   1288: getfield 121	bbk:k	Ljava/lang/Exception;
    //   1291: invokevirtual 157	java/lang/Exception:toString	()Ljava/lang/String;
    //   1294: lconst_0
    //   1295: invokeinterface 160 6 0
    //   1300: return
    //   1301: ldc -110
    //   1303: astore_2
    //   1304: goto -754 -> 550
    //   1307: ldc -108
    //   1309: astore_1
    //   1310: goto -728 -> 582
    //   1313: aload 4
    //   1315: aload_2
    //   1316: invokestatic 151	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1319: ldc -103
    //   1321: invokevirtual 156	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1324: aload_3
    //   1325: aload 13
    //   1327: getfield 121	bbk:k	Ljava/lang/Exception;
    //   1330: invokevirtual 157	java/lang/Exception:toString	()Ljava/lang/String;
    //   1333: lconst_0
    //   1334: invokeinterface 160 6 0
    //   1339: return
    //   1340: ldc -110
    //   1342: astore_3
    //   1343: goto -289 -> 1054
    //   1346: ldc -108
    //   1348: astore_1
    //   1349: goto -262 -> 1087
    //   1352: aload 12
    //   1354: aload_3
    //   1355: invokestatic 151	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1358: ldc -103
    //   1360: invokevirtual 156	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1363: aload 4
    //   1365: aload 13
    //   1367: getfield 121	bbk:k	Ljava/lang/Exception;
    //   1370: invokevirtual 157	java/lang/Exception:toString	()Ljava/lang/String;
    //   1373: lconst_0
    //   1374: invokeinterface 160 6 0
    //   1379: goto -245 -> 1134
    //   1382: astore_3
    //   1383: aload_2
    //   1384: astore 12
    //   1386: aload_3
    //   1387: astore_2
    //   1388: goto -384 -> 1004
    //   1391: astore_3
    //   1392: aconst_null
    //   1393: astore_2
    //   1394: goto -911 -> 483
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1397	0	this	bbj
    //   0	1397	1	paramAccount	android.accounts.Account
    //   0	1397	2	paramBundle	android.os.Bundle
    //   0	1397	3	paramContentProviderClient	android.content.ContentProviderClient
    //   0	1397	4	paramSyncResult	SyncResult
    //   759	235	5	i	int
    //   756	10	6	j	int
    //   90	902	7	bool	boolean
    //   297	612	8	l1	long
    //   734	134	10	l2	long
    //   50	401	12	localContentProviderClient	android.content.ContentProviderClient
    //   476	5	12	localException	Exception
    //   629	756	12	localObject	Object
    //   25	1341	13	localbbk	bbk
    //   4	1163	14	localbbi	bbi
    //   10	968	15	localContext	Context
    //   272	612	16	localAccount	com.android.emailcommon.provider.Account
    //   706	68	17	arrayOfLong	long[]
    //   718	239	18	localLinkedHashSet	java.util.LinkedHashSet
    // Exception table:
    //   from	to	target	type
    //   84	92	476	java/lang/Exception
    //   265	274	476	java/lang/Exception
    //   277	283	476	java/lang/Exception
    //   286	299	476	java/lang/Exception
    //   302	311	476	java/lang/Exception
    //   314	320	476	java/lang/Exception
    //   323	346	476	java/lang/Exception
    //   349	357	476	java/lang/Exception
    //   360	380	476	java/lang/Exception
    //   383	403	476	java/lang/Exception
    //   415	427	476	java/lang/Exception
    //   430	437	476	java/lang/Exception
    //   440	449	476	java/lang/Exception
    //   452	473	476	java/lang/Exception
    //   631	654	476	java/lang/Exception
    //   657	676	476	java/lang/Exception
    //   679	699	476	java/lang/Exception
    //   702	708	476	java/lang/Exception
    //   711	720	476	java/lang/Exception
    //   723	736	476	java/lang/Exception
    //   744	750	476	java/lang/Exception
    //   753	758	476	java/lang/Exception
    //   771	785	476	java/lang/Exception
    //   806	817	476	java/lang/Exception
    //   829	840	476	java/lang/Exception
    //   843	853	476	java/lang/Exception
    //   865	878	476	java/lang/Exception
    //   881	894	476	java/lang/Exception
    //   906	917	476	java/lang/Exception
    //   920	930	476	java/lang/Exception
    //   933	940	476	java/lang/Exception
    //   943	953	476	java/lang/Exception
    //   956	962	476	java/lang/Exception
    //   965	974	476	java/lang/Exception
    //   977	1000	476	java/lang/Exception
    //   52	77	1003	finally
    //   84	92	1003	finally
    //   265	274	1003	finally
    //   277	283	1003	finally
    //   286	299	1003	finally
    //   302	311	1003	finally
    //   314	320	1003	finally
    //   323	346	1003	finally
    //   349	357	1003	finally
    //   360	380	1003	finally
    //   383	403	1003	finally
    //   415	427	1003	finally
    //   430	437	1003	finally
    //   440	449	1003	finally
    //   452	473	1003	finally
    //   631	654	1003	finally
    //   657	676	1003	finally
    //   679	699	1003	finally
    //   702	708	1003	finally
    //   711	720	1003	finally
    //   723	736	1003	finally
    //   744	750	1003	finally
    //   753	758	1003	finally
    //   771	785	1003	finally
    //   806	817	1003	finally
    //   829	840	1003	finally
    //   843	853	1003	finally
    //   865	878	1003	finally
    //   881	894	1003	finally
    //   906	917	1003	finally
    //   920	930	1003	finally
    //   933	940	1003	finally
    //   943	953	1003	finally
    //   956	962	1003	finally
    //   965	974	1003	finally
    //   977	1000	1003	finally
    //   483	502	1382	finally
    //   52	77	1391	java/lang/Exception
  }
}

/* Location:
 * Qualified Name:     bbj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */