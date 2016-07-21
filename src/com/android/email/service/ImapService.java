package com.android.email.service;

import android.app.Service;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.os.SystemClock;
import android.text.TextUtils;
import aqt;
import arh;
import awr;
import baa;
import bal;
import bay;
import baz;
import bbk;
import bco;
import bcx;
import bcy;
import bda;
import bdb;
import bdc;
import bdf;
import bdg;
import bdi;
import bdk;
import bdn;
import beb;
import bgt;
import cfg;
import com.android.emailcommon.provider.Account;
import com.android.emailcommon.provider.Mailbox;
import cvm;
import cwz;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ImapService
  extends Service
{
  public static String a;
  private static final bda[] b = { bda.b };
  private static final bda[] c = { bda.d };
  private static final bda[] d = { bda.c };
  private static final bda[] e = { bda.g };
  private static long f = -1L;
  private static String g = null;
  private static Mailbox h = null;
  private bal i = new bal();
  
  private static int a(Context paramContext, long paramLong1, long paramLong2)
  {
    bgt.b(paramContext, paramLong1, paramLong2);
    paramContext = paramContext.getContentResolver();
    int j = paramContext.delete(ContentUris.withAppendedId(beb.a, paramLong2), null, null);
    paramContext.delete(ContentUris.withAppendedId(beb.e, paramLong2), null, null);
    return j;
  }
  
  private static int a(Context paramContext, Account paramAccount, long paramLong, List<bdg> paramList1, Map<String, baz> paramMap, List<bdg> paramList2, Map<String, bdg> paramMap1)
  {
    int j = 0;
    Iterator localIterator = paramList1.iterator();
    while (localIterator.hasNext())
    {
      bdg localbdg = (bdg)localIterator.next();
      if (localbdg.b(bda.a))
      {
        paramMap1.remove(f);
        paramList2.remove(localbdg);
        cvm.a("ImapService", "Removing deleted but not expunged message %s", new Object[] { f });
      }
    }
    paramMap = paramMap.values().iterator();
    while (paramMap.hasNext())
    {
      paramList2 = (baz)paramMap.next();
      if ((paramList1.isEmpty()) || (h >= paramLong))
      {
        if (!paramMap1.containsKey(f))
        {
          cvm.a("ImapService", "Local message %s not found in remote store, deleting", new Object[] { f });
          j = a(paramContext, D, b) + j;
        }
      }
      else {
        cvm.a("ImapService", "Message %s outside of sync window, not considering for deletion", new Object[] { f });
      }
    }
    return j;
  }
  
  /* Error */
  public static int a(Context paramContext, Account paramAccount, Mailbox paramMailbox, boolean paramBoolean1, boolean paramBoolean2, bbk parambbk)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_1
    //   4: invokestatic 174	bcf:a	(Lcom/android/emailcommon/provider/Account;)I
    //   7: invokestatic 180	android/net/TrafficStats:setThreadStatsTag	(I)V
    //   10: aload_0
    //   11: invokestatic 185	bbz:a	(Landroid/content/Context;)Lbbx;
    //   14: astore 23
    //   16: aconst_null
    //   17: astore 17
    //   19: aload_1
    //   20: aload_0
    //   21: invokestatic 190	awr:a	(Lcom/android/emailcommon/provider/Account;Landroid/content/Context;)Lawr;
    //   24: astore 18
    //   26: aload_1
    //   27: invokestatic 174	bcf:a	(Lcom/android/emailcommon/provider/Account;)I
    //   30: invokestatic 180	android/net/TrafficStats:setThreadStatsTag	(I)V
    //   33: iconst_1
    //   34: anewarray 192	java/lang/String
    //   37: astore 17
    //   39: aload 17
    //   41: iconst_0
    //   42: aload_1
    //   43: getfield 158	com/android/emailcommon/provider/Account:D	J
    //   46: invokestatic 198	java/lang/Long:toString	(J)Ljava/lang/String;
    //   49: aastore
    //   50: aload_0
    //   51: invokevirtual 68	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   54: getstatic 87	beb:e	Landroid/net/Uri;
    //   57: getstatic 201	beb:g	[Ljava/lang/String;
    //   60: ldc -53
    //   62: aload 17
    //   64: ldc -51
    //   66: invokevirtual 209	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   69: astore 19
    //   71: ldc2_w 40
    //   74: lstore 11
    //   76: lload 11
    //   78: lstore 15
    //   80: aload 19
    //   82: invokeinterface 214 1 0
    //   87: ifeq +799 -> 886
    //   90: lload 11
    //   92: lstore 15
    //   94: aload_0
    //   95: aload 19
    //   97: ldc 70
    //   99: invokestatic 219	bdv:a	(Landroid/content/Context;Landroid/database/Cursor;Ljava/lang/Class;)Lbdv;
    //   102: checkcast 70	beb
    //   105: astore 20
    //   107: lload 11
    //   109: lstore 13
    //   111: aload 20
    //   113: ifnull +2373 -> 2486
    //   116: lload 11
    //   118: lstore 15
    //   120: aload 20
    //   122: getfield 220	beb:D	J
    //   125: lstore 13
    //   127: lload 13
    //   129: lstore 15
    //   131: aload_0
    //   132: aload 20
    //   134: invokestatic 223	com/android/email/service/ImapService:a	(Landroid/content/Context;Lbeb;)Lcom/android/emailcommon/provider/Mailbox;
    //   137: astore 21
    //   139: lload 13
    //   141: lstore 11
    //   143: aload 21
    //   145: ifnull -69 -> 76
    //   148: lload 13
    //   150: lstore 15
    //   152: aload 18
    //   154: aload 21
    //   156: getfield 227	com/android/emailcommon/provider/Mailbox:d	Ljava/lang/String;
    //   159: invokevirtual 230	awr:a	(Ljava/lang/String;)Lbdb;
    //   162: astore 21
    //   164: lload 13
    //   166: lstore 15
    //   168: aload 21
    //   170: invokevirtual 234	bdb:d	()Z
    //   173: ifeq +39 -> 212
    //   176: lload 13
    //   178: lstore 15
    //   180: aload 21
    //   182: getstatic 239	bdf:a	I
    //   185: invokevirtual 241	bdb:a	(I)V
    //   188: lload 13
    //   190: lstore 15
    //   192: aload 21
    //   194: invokevirtual 244	bdb:a	()I
    //   197: getstatic 239	bdf:a	I
    //   200: if_icmpeq +48 -> 248
    //   203: lload 13
    //   205: lstore 15
    //   207: aload 21
    //   209: invokevirtual 246	bdb:b	()V
    //   212: lload 13
    //   214: lstore 15
    //   216: getstatic 87	beb:e	Landroid/net/Uri;
    //   219: aload 20
    //   221: getfield 220	beb:D	J
    //   224: invokestatic 79	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   227: astore 20
    //   229: lload 13
    //   231: lstore 15
    //   233: aload_0
    //   234: invokevirtual 68	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   237: aload 20
    //   239: aconst_null
    //   240: aconst_null
    //   241: invokevirtual 85	android/content/ContentResolver:delete	(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    //   244: pop
    //   245: goto +2241 -> 2486
    //   248: lload 13
    //   250: lstore 15
    //   252: aload 21
    //   254: aload 20
    //   256: getfield 249	beb:x	Ljava/lang/String;
    //   259: invokevirtual 252	bdb:a	(Ljava/lang/String;)Lbdg;
    //   262: astore 22
    //   264: aload 22
    //   266: ifnonnull +575 -> 841
    //   269: lload 13
    //   271: lstore 15
    //   273: aload 21
    //   275: invokevirtual 246	bdb:b	()V
    //   278: goto -66 -> 212
    //   281: astore 20
    //   283: ldc 124
    //   285: aload 20
    //   287: ldc -2
    //   289: iconst_1
    //   290: anewarray 128	java/lang/Object
    //   293: dup
    //   294: iconst_0
    //   295: lload 15
    //   297: invokestatic 258	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   300: aastore
    //   301: invokestatic 261	cvm:b	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   304: pop
    //   305: aload 19
    //   307: invokeinterface 264 1 0
    //   312: aload_0
    //   313: invokevirtual 68	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   316: astore 25
    //   318: aload 25
    //   320: getstatic 265	com/android/emailcommon/provider/Mailbox:a	Landroid/net/Uri;
    //   323: getstatic 268	com/android/emailcommon/provider/Mailbox:B	[Ljava/lang/String;
    //   326: ldc_w 270
    //   329: aload 17
    //   331: aconst_null
    //   332: invokevirtual 209	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   335: astore 24
    //   337: ldc2_w 40
    //   340: lstore 11
    //   342: aload 18
    //   344: astore 17
    //   346: aload 24
    //   348: invokeinterface 214 1 0
    //   353: ifeq +874 -> 1227
    //   356: aload 24
    //   358: iconst_0
    //   359: invokeinterface 274 2 0
    //   364: lstore 15
    //   366: lload 15
    //   368: invokestatic 198	java/lang/Long:toString	(J)Ljava/lang/String;
    //   371: astore 19
    //   373: aload 25
    //   375: getstatic 73	beb:a	Landroid/net/Uri;
    //   378: getstatic 275	beb:B	[Ljava/lang/String;
    //   381: ldc_w 277
    //   384: iconst_1
    //   385: anewarray 192	java/lang/String
    //   388: dup
    //   389: iconst_0
    //   390: aload 19
    //   392: aastore
    //   393: aconst_null
    //   394: invokevirtual 209	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   397: astore 26
    //   399: aconst_null
    //   400: astore 19
    //   402: aload 17
    //   404: astore 21
    //   406: lload 11
    //   408: lstore 13
    //   410: aload 26
    //   412: invokeinterface 214 1 0
    //   417: ifeq +774 -> 1191
    //   420: aload 17
    //   422: astore 20
    //   424: aload 17
    //   426: ifnonnull +18 -> 444
    //   429: aload 17
    //   431: astore 21
    //   433: lload 11
    //   435: lstore 13
    //   437: aload_1
    //   438: aload_0
    //   439: invokestatic 190	awr:a	(Lcom/android/emailcommon/provider/Account;Landroid/content/Context;)Lawr;
    //   442: astore 20
    //   444: aload 19
    //   446: astore 22
    //   448: aload 19
    //   450: ifnonnull +32 -> 482
    //   453: aload 20
    //   455: astore 21
    //   457: lload 11
    //   459: lstore 13
    //   461: aload_0
    //   462: lload 15
    //   464: invokestatic 280	com/android/emailcommon/provider/Mailbox:a	(Landroid/content/Context;J)Lcom/android/emailcommon/provider/Mailbox;
    //   467: astore 22
    //   469: aload 20
    //   471: astore 17
    //   473: aload 22
    //   475: astore 19
    //   477: aload 22
    //   479: ifnull -77 -> 402
    //   482: aload 20
    //   484: astore 21
    //   486: lload 11
    //   488: lstore 13
    //   490: aload 26
    //   492: iconst_0
    //   493: invokeinterface 274 2 0
    //   498: lstore 11
    //   500: aload 20
    //   502: astore 21
    //   504: lload 11
    //   506: lstore 13
    //   508: aload_0
    //   509: lload 11
    //   511: invokestatic 283	beb:a	(Landroid/content/Context;J)Lbeb;
    //   514: astore 17
    //   516: aload 17
    //   518: ifnonnull +378 -> 896
    //   521: aload 20
    //   523: astore 21
    //   525: lload 11
    //   527: lstore 13
    //   529: ldc 124
    //   531: ldc_w 285
    //   534: iconst_1
    //   535: anewarray 128	java/lang/Object
    //   538: dup
    //   539: iconst_0
    //   540: lload 11
    //   542: invokestatic 258	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   545: aastore
    //   546: invokestatic 287	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   549: pop
    //   550: aload 20
    //   552: astore 17
    //   554: aload 22
    //   556: astore 19
    //   558: goto -156 -> 402
    //   561: astore 17
    //   563: aload 26
    //   565: ifnull +14 -> 579
    //   568: lload 13
    //   570: lstore 15
    //   572: aload 26
    //   574: invokeinterface 264 1 0
    //   579: aload 21
    //   581: ifnull +12 -> 593
    //   584: lload 13
    //   586: lstore 15
    //   588: aload 21
    //   590: invokevirtual 289	awr:e	()V
    //   593: lload 13
    //   595: lstore 15
    //   597: aload 17
    //   599: athrow
    //   600: astore 17
    //   602: ldc 124
    //   604: aload 17
    //   606: ldc_w 291
    //   609: iconst_1
    //   610: anewarray 128	java/lang/Object
    //   613: dup
    //   614: iconst_0
    //   615: lload 15
    //   617: invokestatic 258	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   620: aastore
    //   621: invokestatic 261	cvm:b	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   624: pop
    //   625: aload 24
    //   627: ifnull +10 -> 637
    //   630: aload 24
    //   632: invokeinterface 264 1 0
    //   637: aload_0
    //   638: invokevirtual 68	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   641: astore 17
    //   643: aload_0
    //   644: aload_1
    //   645: getfield 158	com/android/emailcommon/provider/Account:D	J
    //   648: iconst_0
    //   649: invokestatic 296	beg:a	(Landroid/content/Context;JZ)Ljava/util/List;
    //   652: astore 19
    //   654: aload 19
    //   656: ifnull +1018 -> 1674
    //   659: aload 19
    //   661: invokeinterface 94 1 0
    //   666: astore 19
    //   668: aload 19
    //   670: invokeinterface 100 1 0
    //   675: ifeq +999 -> 1674
    //   678: aload 19
    //   680: invokeinterface 104 1 0
    //   685: checkcast 293	beg
    //   688: astore 20
    //   690: aload 20
    //   692: invokevirtual 298	beg:c	()I
    //   695: iconst_m1
    //   696: if_icmpeq +561 -> 1257
    //   699: iconst_1
    //   700: istore 6
    //   702: aload 20
    //   704: invokevirtual 300	beg:b	()I
    //   707: iconst_m1
    //   708: if_icmpeq +555 -> 1263
    //   711: iconst_1
    //   712: istore 7
    //   714: aload 20
    //   716: invokevirtual 301	beg:a	()I
    //   719: iconst_m1
    //   720: if_icmpeq +549 -> 1269
    //   723: iconst_1
    //   724: istore 8
    //   726: aload 20
    //   728: invokevirtual 303	beg:d	()I
    //   731: iconst_m1
    //   732: if_icmpeq +543 -> 1275
    //   735: iconst_1
    //   736: istore 9
    //   738: iload 6
    //   740: ifne +541 -> 1281
    //   743: iload 7
    //   745: ifne +536 -> 1281
    //   748: iload 8
    //   750: ifne +531 -> 1281
    //   753: iload 9
    //   755: ifne +526 -> 1281
    //   758: aload 17
    //   760: iconst_1
    //   761: newarray <illegal type>
    //   763: dup
    //   764: iconst_0
    //   765: aload 20
    //   767: getfield 307	bec:d	J
    //   770: lastore
    //   771: iconst_1
    //   772: invokestatic 310	beg:a	(Landroid/content/ContentResolver;[JI)V
    //   775: goto -107 -> 668
    //   778: astore_2
    //   779: aload 18
    //   781: astore_0
    //   782: ldc 124
    //   784: aload_2
    //   785: ldc_w 312
    //   788: iconst_0
    //   789: anewarray 128	java/lang/Object
    //   792: invokestatic 314	cvm:c	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   795: pop
    //   796: aload_2
    //   797: instanceof 316
    //   800: ifeq +1645 -> 2445
    //   803: aload 23
    //   805: aload_1
    //   806: getfield 158	com/android/emailcommon/provider/Account:D	J
    //   809: iconst_1
    //   810: invokeinterface 321 4 0
    //   815: aload_2
    //   816: athrow
    //   817: astore_1
    //   818: aload_0
    //   819: astore 18
    //   821: aload_1
    //   822: astore_0
    //   823: aload 18
    //   825: ifnull +8 -> 833
    //   828: aload 18
    //   830: invokevirtual 289	awr:e	()V
    //   833: aload_0
    //   834: athrow
    //   835: astore_0
    //   836: ldc 2
    //   838: monitorexit
    //   839: aload_0
    //   840: athrow
    //   841: lload 13
    //   843: lstore 15
    //   845: aload 22
    //   847: getstatic 108	bda:a	Lbda;
    //   850: iconst_1
    //   851: invokevirtual 324	bdg:a	(Lbda;Z)V
    //   854: lload 13
    //   856: lstore 15
    //   858: aload 21
    //   860: invokevirtual 327	bdb:g	()[Lbdg;
    //   863: pop
    //   864: lload 13
    //   866: lstore 15
    //   868: aload 21
    //   870: invokevirtual 246	bdb:b	()V
    //   873: goto -661 -> 212
    //   876: astore_0
    //   877: aload 19
    //   879: invokeinterface 264 1 0
    //   884: aload_0
    //   885: athrow
    //   886: aload 19
    //   888: invokeinterface 264 1 0
    //   893: goto -581 -> 312
    //   896: aload 20
    //   898: astore 21
    //   900: lload 11
    //   902: lstore 13
    //   904: aload 22
    //   906: getfield 329	com/android/emailcommon/provider/Mailbox:h	I
    //   909: iconst_3
    //   910: if_icmpne +43 -> 953
    //   913: aload 20
    //   915: astore 21
    //   917: lload 11
    //   919: lstore 13
    //   921: ldc 124
    //   923: ldc_w 331
    //   926: iconst_1
    //   927: anewarray 128	java/lang/Object
    //   930: dup
    //   931: iconst_0
    //   932: lload 11
    //   934: invokestatic 258	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   937: aastore
    //   938: invokestatic 287	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   941: pop
    //   942: aload 20
    //   944: astore 17
    //   946: aload 22
    //   948: astore 19
    //   950: goto -548 -> 402
    //   953: aload 20
    //   955: astore 21
    //   957: lload 11
    //   959: lstore 13
    //   961: aload 22
    //   963: getfield 329	com/android/emailcommon/provider/Mailbox:h	I
    //   966: iconst_4
    //   967: if_icmpne +43 -> 1010
    //   970: aload 20
    //   972: astore 21
    //   974: lload 11
    //   976: lstore 13
    //   978: ldc 124
    //   980: ldc_w 333
    //   983: iconst_1
    //   984: anewarray 128	java/lang/Object
    //   987: dup
    //   988: iconst_0
    //   989: lload 11
    //   991: invokestatic 258	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   994: aastore
    //   995: invokestatic 287	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   998: pop
    //   999: aload 20
    //   1001: astore 17
    //   1003: aload 22
    //   1005: astore 19
    //   1007: goto -605 -> 402
    //   1010: aload 20
    //   1012: astore 21
    //   1014: lload 11
    //   1016: lstore 13
    //   1018: aload 22
    //   1020: getfield 329	com/android/emailcommon/provider/Mailbox:h	I
    //   1023: bipush 6
    //   1025: if_icmpne +43 -> 1068
    //   1028: aload 20
    //   1030: astore 21
    //   1032: lload 11
    //   1034: lstore 13
    //   1036: ldc 124
    //   1038: ldc_w 335
    //   1041: iconst_1
    //   1042: anewarray 128	java/lang/Object
    //   1045: dup
    //   1046: iconst_0
    //   1047: lload 11
    //   1049: invokestatic 258	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1052: aastore
    //   1053: invokestatic 287	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1056: pop
    //   1057: aload 20
    //   1059: astore 17
    //   1061: aload 22
    //   1063: astore 19
    //   1065: goto -663 -> 402
    //   1068: aload 20
    //   1070: astore 21
    //   1072: lload 11
    //   1074: lstore 13
    //   1076: aload 17
    //   1078: getfield 338	beb:U	J
    //   1081: aload 22
    //   1083: getfield 339	com/android/emailcommon/provider/Mailbox:D	J
    //   1086: lcmp
    //   1087: ifeq +43 -> 1130
    //   1090: aload 20
    //   1092: astore 21
    //   1094: lload 11
    //   1096: lstore 13
    //   1098: ldc 124
    //   1100: ldc_w 341
    //   1103: iconst_1
    //   1104: anewarray 128	java/lang/Object
    //   1107: dup
    //   1108: iconst_0
    //   1109: lload 11
    //   1111: invokestatic 258	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1114: aastore
    //   1115: invokestatic 287	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1118: pop
    //   1119: aload 20
    //   1121: astore 17
    //   1123: aload 22
    //   1125: astore 19
    //   1127: goto -725 -> 402
    //   1130: aload 20
    //   1132: astore 21
    //   1134: lload 11
    //   1136: lstore 13
    //   1138: ldc 124
    //   1140: ldc_w 343
    //   1143: iconst_1
    //   1144: anewarray 128	java/lang/Object
    //   1147: dup
    //   1148: iconst_0
    //   1149: lload 11
    //   1151: invokestatic 258	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1154: aastore
    //   1155: invokestatic 133	cvm:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1158: pop
    //   1159: aload 20
    //   1161: astore 21
    //   1163: lload 11
    //   1165: lstore 13
    //   1167: aload_0
    //   1168: aload 20
    //   1170: aload 22
    //   1172: aload 17
    //   1174: iload 4
    //   1176: invokestatic 346	com/android/email/service/ImapService:a	(Landroid/content/Context;Lawr;Lcom/android/emailcommon/provider/Mailbox;Lbeb;Z)Z
    //   1179: pop
    //   1180: aload 20
    //   1182: astore 17
    //   1184: aload 22
    //   1186: astore 19
    //   1188: goto -786 -> 402
    //   1191: aload 26
    //   1193: ifnull +14 -> 1207
    //   1196: lload 11
    //   1198: lstore 15
    //   1200: aload 26
    //   1202: invokeinterface 264 1 0
    //   1207: aload 17
    //   1209: ifnull +15 -> 1224
    //   1212: lload 11
    //   1214: lstore 15
    //   1216: aload 17
    //   1218: invokevirtual 289	awr:e	()V
    //   1221: goto -875 -> 346
    //   1224: goto -878 -> 346
    //   1227: aload 24
    //   1229: ifnull -592 -> 637
    //   1232: aload 24
    //   1234: invokeinterface 264 1 0
    //   1239: goto -602 -> 637
    //   1242: astore_0
    //   1243: aload 24
    //   1245: ifnull +10 -> 1255
    //   1248: aload 24
    //   1250: invokeinterface 264 1 0
    //   1255: aload_0
    //   1256: athrow
    //   1257: iconst_0
    //   1258: istore 6
    //   1260: goto -558 -> 702
    //   1263: iconst_0
    //   1264: istore 7
    //   1266: goto -552 -> 714
    //   1269: iconst_0
    //   1270: istore 8
    //   1272: goto -546 -> 726
    //   1275: iconst_0
    //   1276: istore 9
    //   1278: goto -540 -> 738
    //   1281: aload_0
    //   1282: aload_0
    //   1283: invokevirtual 68	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   1286: aload 20
    //   1288: getfield 307	bec:d	J
    //   1291: invokestatic 351	bed:a	(Landroid/content/ContentResolver;J)J
    //   1294: invokestatic 280	com/android/emailcommon/provider/Mailbox:a	(Landroid/content/Context;J)Lcom/android/emailcommon/provider/Mailbox;
    //   1297: astore 21
    //   1299: aload 21
    //   1301: ifnull +25 -> 1326
    //   1304: aload 21
    //   1306: getfield 329	com/android/emailcommon/provider/Mailbox:h	I
    //   1309: iconst_3
    //   1310: if_icmpeq +16 -> 1326
    //   1313: aload 21
    //   1315: getfield 329	com/android/emailcommon/provider/Mailbox:h	I
    //   1318: istore 6
    //   1320: iload 6
    //   1322: iconst_4
    //   1323: if_icmpne +23 -> 1346
    //   1326: aload 17
    //   1328: iconst_1
    //   1329: newarray <illegal type>
    //   1331: dup
    //   1332: iconst_0
    //   1333: aload 20
    //   1335: getfield 307	bec:d	J
    //   1338: lastore
    //   1339: iconst_1
    //   1340: invokestatic 310	beg:a	(Landroid/content/ContentResolver;[JI)V
    //   1343: goto -675 -> 668
    //   1346: aload 18
    //   1348: aload 21
    //   1350: getfield 227	com/android/emailcommon/provider/Mailbox:d	Ljava/lang/String;
    //   1353: invokevirtual 230	awr:a	(Ljava/lang/String;)Lbdb;
    //   1356: astore 21
    //   1358: aload 21
    //   1360: invokevirtual 234	bdb:d	()Z
    //   1363: ifeq -37 -> 1326
    //   1366: aload 21
    //   1368: getstatic 239	bdf:a	I
    //   1371: invokevirtual 241	bdb:a	(I)V
    //   1374: aload 21
    //   1376: invokevirtual 244	bdb:a	()I
    //   1379: getstatic 239	bdf:a	I
    //   1382: if_icmpne -56 -> 1326
    //   1385: aload 21
    //   1387: aload 20
    //   1389: getfield 353	bec:e	Ljava/lang/String;
    //   1392: invokevirtual 252	bdb:a	(Ljava/lang/String;)Lbdg;
    //   1395: astore 24
    //   1397: aload 24
    //   1399: ifnull -73 -> 1326
    //   1402: aload 20
    //   1404: invokevirtual 301	beg:a	()I
    //   1407: istore 6
    //   1409: aload 20
    //   1411: invokevirtual 300	beg:b	()I
    //   1414: istore 7
    //   1416: aload 20
    //   1418: invokevirtual 298	beg:c	()I
    //   1421: istore 8
    //   1423: aload 20
    //   1425: invokevirtual 303	beg:d	()I
    //   1428: istore 9
    //   1430: ldc 124
    //   1432: ldc_w 355
    //   1435: iconst_5
    //   1436: anewarray 128	java/lang/Object
    //   1439: dup
    //   1440: iconst_0
    //   1441: aload 20
    //   1443: getfield 307	bec:d	J
    //   1446: invokestatic 258	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1449: aastore
    //   1450: dup
    //   1451: iconst_1
    //   1452: iload 6
    //   1454: invokestatic 360	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1457: aastore
    //   1458: dup
    //   1459: iconst_2
    //   1460: iload 7
    //   1462: invokestatic 360	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1465: aastore
    //   1466: dup
    //   1467: iconst_3
    //   1468: iload 8
    //   1470: invokestatic 360	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1473: aastore
    //   1474: dup
    //   1475: iconst_4
    //   1476: iload 9
    //   1478: invokestatic 360	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1481: aastore
    //   1482: invokestatic 133	cvm:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1485: pop
    //   1486: iconst_1
    //   1487: anewarray 106	bdg
    //   1490: astore 22
    //   1492: aload 22
    //   1494: iconst_0
    //   1495: aload 24
    //   1497: aastore
    //   1498: iload 6
    //   1500: iconst_m1
    //   1501: if_icmpeq +27 -> 1528
    //   1504: getstatic 27	com/android/email/service/ImapService:b	[Lbda;
    //   1507: astore 24
    //   1509: iload 6
    //   1511: ifeq +986 -> 2497
    //   1514: iconst_1
    //   1515: istore 10
    //   1517: aload 21
    //   1519: aload 22
    //   1521: aload 24
    //   1523: iload 10
    //   1525: invokevirtual 363	bdb:a	([Lbdg;[Lbda;Z)V
    //   1528: iload 7
    //   1530: iconst_m1
    //   1531: if_icmpeq +27 -> 1558
    //   1534: getstatic 31	com/android/email/service/ImapService:c	[Lbda;
    //   1537: astore 24
    //   1539: iload 7
    //   1541: ifeq +962 -> 2503
    //   1544: iconst_1
    //   1545: istore 10
    //   1547: aload 21
    //   1549: aload 22
    //   1551: aload 24
    //   1553: iload 10
    //   1555: invokevirtual 363	bdb:a	([Lbdg;[Lbda;Z)V
    //   1558: iload 8
    //   1560: iconst_m1
    //   1561: if_icmpeq +27 -> 1588
    //   1564: getstatic 35	com/android/email/service/ImapService:d	[Lbda;
    //   1567: astore 24
    //   1569: iload 8
    //   1571: ifeq +938 -> 2509
    //   1574: iconst_1
    //   1575: istore 10
    //   1577: aload 21
    //   1579: aload 22
    //   1581: aload 24
    //   1583: iload 10
    //   1585: invokevirtual 363	bdb:a	([Lbdg;[Lbda;Z)V
    //   1588: iload 9
    //   1590: iconst_m1
    //   1591: if_icmpeq +27 -> 1618
    //   1594: getstatic 39	com/android/email/service/ImapService:e	[Lbda;
    //   1597: astore 24
    //   1599: iload 9
    //   1601: ifeq +914 -> 2515
    //   1604: iconst_1
    //   1605: istore 10
    //   1607: aload 21
    //   1609: aload 22
    //   1611: aload 24
    //   1613: iload 10
    //   1615: invokevirtual 363	bdb:a	([Lbdg;[Lbda;Z)V
    //   1618: aload 21
    //   1620: invokevirtual 246	bdb:b	()V
    //   1623: goto -297 -> 1326
    //   1626: astore 21
    //   1628: ldc 124
    //   1630: aload 21
    //   1632: ldc_w 365
    //   1635: iconst_1
    //   1636: anewarray 128	java/lang/Object
    //   1639: dup
    //   1640: iconst_0
    //   1641: aload 20
    //   1643: getfield 307	bec:d	J
    //   1646: invokestatic 258	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1649: aastore
    //   1650: invokestatic 367	cvm:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1653: pop
    //   1654: aload 17
    //   1656: iconst_1
    //   1657: newarray <illegal type>
    //   1659: dup
    //   1660: iconst_0
    //   1661: aload 20
    //   1663: getfield 307	bec:d	J
    //   1666: lastore
    //   1667: iconst_1
    //   1668: invokestatic 369	beg:b	(Landroid/content/ContentResolver;[JI)V
    //   1671: goto -1003 -> 668
    //   1674: aload_0
    //   1675: invokevirtual 68	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   1678: astore 17
    //   1680: aload_0
    //   1681: aload_1
    //   1682: getfield 158	com/android/emailcommon/provider/Account:D	J
    //   1685: bipush 6
    //   1687: invokestatic 372	com/android/emailcommon/provider/Mailbox:a	(Landroid/content/Context;JI)J
    //   1690: lstore 11
    //   1692: aload_0
    //   1693: aload_1
    //   1694: getfield 158	com/android/emailcommon/provider/Account:D	J
    //   1697: invokestatic 375	bed:a	(Landroid/content/Context;J)Ljava/util/List;
    //   1700: astore 19
    //   1702: aload 19
    //   1704: ifnull +605 -> 2309
    //   1707: aload 19
    //   1709: invokeinterface 94 1 0
    //   1714: astore 19
    //   1716: aload 19
    //   1718: invokeinterface 100 1 0
    //   1723: ifeq +586 -> 2309
    //   1726: aload 19
    //   1728: invokeinterface 104 1 0
    //   1733: checkcast 348	bed
    //   1736: astore 20
    //   1738: aload 20
    //   1740: getfield 378	bed:j	J
    //   1743: lstore 13
    //   1745: lload 13
    //   1747: lload 11
    //   1749: lcmp
    //   1750: ifne +91 -> 1841
    //   1753: iconst_1
    //   1754: istore 6
    //   1756: iload 6
    //   1758: ifeq +318 -> 2076
    //   1761: aload_0
    //   1762: aload 20
    //   1764: getfield 380	bed:i	J
    //   1767: invokestatic 280	com/android/emailcommon/provider/Mailbox:a	(Landroid/content/Context;J)Lcom/android/emailcommon/provider/Mailbox;
    //   1770: astore 21
    //   1772: aload 21
    //   1774: ifnull +47 -> 1821
    //   1777: aload 18
    //   1779: aload 21
    //   1781: getfield 227	com/android/emailcommon/provider/Mailbox:d	Ljava/lang/String;
    //   1784: invokevirtual 230	awr:a	(Ljava/lang/String;)Lbdb;
    //   1787: astore 21
    //   1789: aload 21
    //   1791: invokevirtual 234	bdb:d	()Z
    //   1794: ifeq +27 -> 1821
    //   1797: aload 21
    //   1799: getstatic 239	bdf:a	I
    //   1802: invokevirtual 241	bdb:a	(I)V
    //   1805: aload 21
    //   1807: invokevirtual 244	bdb:a	()I
    //   1810: getstatic 239	bdf:a	I
    //   1813: if_icmpeq +34 -> 1847
    //   1816: aload 21
    //   1818: invokevirtual 246	bdb:b	()V
    //   1821: aload 17
    //   1823: iconst_1
    //   1824: newarray <illegal type>
    //   1826: dup
    //   1827: iconst_0
    //   1828: aload 20
    //   1830: getfield 307	bec:d	J
    //   1833: lastore
    //   1834: iconst_1
    //   1835: invokestatic 381	bed:a	(Landroid/content/ContentResolver;[JI)V
    //   1838: goto -122 -> 1716
    //   1841: iconst_0
    //   1842: istore 6
    //   1844: goto -88 -> 1756
    //   1847: aload 21
    //   1849: aload 20
    //   1851: getfield 353	bec:e	Ljava/lang/String;
    //   1854: invokevirtual 252	bdb:a	(Ljava/lang/String;)Lbdg;
    //   1857: astore 22
    //   1859: aload 22
    //   1861: ifnonnull +86 -> 1947
    //   1864: aload 21
    //   1866: invokevirtual 246	bdb:b	()V
    //   1869: goto -48 -> 1821
    //   1872: astore 21
    //   1874: ldc 124
    //   1876: aload 21
    //   1878: ldc_w 383
    //   1881: iconst_1
    //   1882: anewarray 128	java/lang/Object
    //   1885: dup
    //   1886: iconst_0
    //   1887: aload 20
    //   1889: getfield 307	bec:d	J
    //   1892: invokestatic 258	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1895: aastore
    //   1896: invokestatic 367	cvm:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1899: pop
    //   1900: aload 21
    //   1902: instanceof 316
    //   1905: ifne +22 -> 1927
    //   1908: aload 21
    //   1910: getfield 385	bdi:d	I
    //   1913: iconst_1
    //   1914: if_icmpeq +13 -> 1927
    //   1917: aload 21
    //   1919: getfield 385	bdi:d	I
    //   1922: bipush 19
    //   1924: if_icmpne +319 -> 2243
    //   1927: aload 17
    //   1929: iconst_1
    //   1930: newarray <illegal type>
    //   1932: dup
    //   1933: iconst_0
    //   1934: aload 20
    //   1936: getfield 307	bec:d	J
    //   1939: lastore
    //   1940: iconst_1
    //   1941: invokestatic 386	bed:b	(Landroid/content/ContentResolver;[JI)V
    //   1944: goto -228 -> 1716
    //   1947: aload 18
    //   1949: aload 20
    //   1951: getfield 389	bed:l	Ljava/lang/String;
    //   1954: invokevirtual 230	awr:a	(Ljava/lang/String;)Lbdb;
    //   1957: astore 24
    //   1959: aload 24
    //   1961: invokevirtual 234	bdb:d	()Z
    //   1964: ifne +14 -> 1978
    //   1967: getstatic 393	bdc:b	I
    //   1970: istore 6
    //   1972: aload 24
    //   1974: invokevirtual 395	bdb:e	()Z
    //   1977: pop
    //   1978: aload 24
    //   1980: invokevirtual 234	bdb:d	()Z
    //   1983: ifeq +70 -> 2053
    //   1986: aload 24
    //   1988: getstatic 239	bdf:a	I
    //   1991: invokevirtual 241	bdb:a	(I)V
    //   1994: aload 24
    //   1996: invokevirtual 244	bdb:a	()I
    //   1999: getstatic 239	bdf:a	I
    //   2002: if_icmpeq +16 -> 2018
    //   2005: aload 21
    //   2007: invokevirtual 246	bdb:b	()V
    //   2010: aload 24
    //   2012: invokevirtual 246	bdb:b	()V
    //   2015: goto -194 -> 1821
    //   2018: new 397	bax
    //   2021: dup
    //   2022: aload_0
    //   2023: aload 20
    //   2025: invokespecial 400	bax:<init>	(Landroid/content/Context;Lbed;)V
    //   2028: astore 25
    //   2030: aload 21
    //   2032: iconst_1
    //   2033: anewarray 106	bdg
    //   2036: dup
    //   2037: iconst_0
    //   2038: aload 22
    //   2040: aastore
    //   2041: aload 24
    //   2043: aload 25
    //   2045: invokevirtual 403	bdb:a	([Lbdg;Lbdb;Lbde;)V
    //   2048: aload 24
    //   2050: invokevirtual 246	bdb:b	()V
    //   2053: aload 22
    //   2055: getstatic 108	bda:a	Lbda;
    //   2058: iconst_1
    //   2059: invokevirtual 324	bdg:a	(Lbda;Z)V
    //   2062: aload 21
    //   2064: invokevirtual 327	bdb:g	()[Lbdg;
    //   2067: pop
    //   2068: aload 21
    //   2070: invokevirtual 246	bdb:b	()V
    //   2073: goto -252 -> 1821
    //   2076: aload_0
    //   2077: aload_0
    //   2078: invokevirtual 68	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   2081: aload 20
    //   2083: getfield 307	bec:d	J
    //   2086: invokestatic 351	bed:a	(Landroid/content/ContentResolver;J)J
    //   2089: invokestatic 280	com/android/emailcommon/provider/Mailbox:a	(Landroid/content/Context;J)Lcom/android/emailcommon/provider/Mailbox;
    //   2092: astore 21
    //   2094: aload 21
    //   2096: ifnull -275 -> 1821
    //   2099: aload 21
    //   2101: getfield 329	com/android/emailcommon/provider/Mailbox:h	I
    //   2104: iconst_3
    //   2105: if_icmpeq -284 -> 1821
    //   2108: aload 21
    //   2110: getfield 329	com/android/emailcommon/provider/Mailbox:h	I
    //   2113: iconst_4
    //   2114: if_icmpeq -293 -> 1821
    //   2117: aload 18
    //   2119: aload 21
    //   2121: getfield 227	com/android/emailcommon/provider/Mailbox:d	Ljava/lang/String;
    //   2124: invokevirtual 230	awr:a	(Ljava/lang/String;)Lbdb;
    //   2127: astore 21
    //   2129: aload 21
    //   2131: invokevirtual 234	bdb:d	()Z
    //   2134: ifeq -313 -> 1821
    //   2137: aload 21
    //   2139: getstatic 239	bdf:a	I
    //   2142: invokevirtual 241	bdb:a	(I)V
    //   2145: aload 21
    //   2147: invokevirtual 244	bdb:a	()I
    //   2150: getstatic 239	bdf:a	I
    //   2153: if_icmpne -332 -> 1821
    //   2156: aload 21
    //   2158: aload 20
    //   2160: getfield 353	bec:e	Ljava/lang/String;
    //   2163: invokevirtual 252	bdb:a	(Ljava/lang/String;)Lbdg;
    //   2166: astore 22
    //   2168: aload 22
    //   2170: ifnull -349 -> 1821
    //   2173: aload 22
    //   2175: aload 20
    //   2177: getfield 353	bec:e	Ljava/lang/String;
    //   2180: invokevirtual 406	bdg:c	(Ljava/lang/String;)V
    //   2183: aload 18
    //   2185: aload 20
    //   2187: getfield 389	bed:l	Ljava/lang/String;
    //   2190: invokevirtual 230	awr:a	(Ljava/lang/String;)Lbdb;
    //   2193: astore 24
    //   2195: new 408	baw
    //   2198: dup
    //   2199: aload_0
    //   2200: aload 20
    //   2202: invokespecial 409	baw:<init>	(Landroid/content/Context;Lbed;)V
    //   2205: astore 25
    //   2207: aload 21
    //   2209: iconst_1
    //   2210: anewarray 106	bdg
    //   2213: dup
    //   2214: iconst_0
    //   2215: aload 22
    //   2217: aastore
    //   2218: aload 24
    //   2220: aload 25
    //   2222: invokevirtual 403	bdb:a	([Lbdg;Lbdb;Lbde;)V
    //   2225: aload 22
    //   2227: getstatic 108	bda:a	Lbda;
    //   2230: iconst_1
    //   2231: invokevirtual 324	bdg:a	(Lbda;Z)V
    //   2234: aload 21
    //   2236: invokevirtual 327	bdb:g	()[Lbdg;
    //   2239: pop
    //   2240: goto -419 -> 1821
    //   2243: aload 17
    //   2245: iconst_1
    //   2246: newarray <illegal type>
    //   2248: dup
    //   2249: iconst_0
    //   2250: aload 20
    //   2252: getfield 307	bec:d	J
    //   2255: lastore
    //   2256: iconst_1
    //   2257: invokestatic 411	bed:c	(Landroid/content/ContentResolver;[JI)V
    //   2260: new 413	android/content/ContentValues
    //   2263: dup
    //   2264: iconst_1
    //   2265: invokespecial 415	android/content/ContentValues:<init>	(I)V
    //   2268: astore 21
    //   2270: aload 21
    //   2272: ldc -51
    //   2274: aload 20
    //   2276: getfield 380	bed:i	J
    //   2279: invokestatic 258	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2282: invokevirtual 419	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2285: aload 17
    //   2287: getstatic 73	beb:a	Landroid/net/Uri;
    //   2290: aload 20
    //   2292: getfield 307	bec:d	J
    //   2295: invokestatic 79	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   2298: aload 21
    //   2300: aconst_null
    //   2301: aconst_null
    //   2302: invokevirtual 423	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   2305: pop
    //   2306: goto -590 -> 1716
    //   2309: invokestatic 429	android/os/SystemClock:elapsedRealtime	()J
    //   2312: aload_2
    //   2313: getfield 432	com/android/emailcommon/provider/Mailbox:v	J
    //   2316: lsub
    //   2317: lstore 11
    //   2319: ldc 124
    //   2321: ldc_w 434
    //   2324: iconst_1
    //   2325: anewarray 128	java/lang/Object
    //   2328: dup
    //   2329: iconst_0
    //   2330: lload 11
    //   2332: invokestatic 258	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2335: aastore
    //   2336: invokestatic 287	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   2339: pop
    //   2340: lload 11
    //   2342: ldc2_w 435
    //   2345: lcmp
    //   2346: ifge +175 -> 2521
    //   2349: lload 11
    //   2351: lconst_0
    //   2352: lcmp
    //   2353: iflt +168 -> 2521
    //   2356: iload 4
    //   2358: ifeq +81 -> 2439
    //   2361: goto +160 -> 2521
    //   2364: invokestatic 441	java/lang/System:currentTimeMillis	()J
    //   2367: lstore 11
    //   2369: aload_2
    //   2370: getfield 432	com/android/emailcommon/provider/Mailbox:v	J
    //   2373: lconst_0
    //   2374: lcmp
    //   2375: ifne +22 -> 2397
    //   2378: iload 4
    //   2380: ifeq +17 -> 2397
    //   2383: aload_0
    //   2384: aload_1
    //   2385: lload 11
    //   2387: aload 18
    //   2389: aload_2
    //   2390: iload_3
    //   2391: iconst_0
    //   2392: aload 5
    //   2394: invokestatic 444	com/android/email/service/ImapService:a	(Landroid/content/Context;Lcom/android/emailcommon/provider/Account;JLawr;Lcom/android/emailcommon/provider/Mailbox;ZZLbbk;)V
    //   2397: aload_0
    //   2398: aload_1
    //   2399: lload 11
    //   2401: aload 18
    //   2403: aload_2
    //   2404: iload_3
    //   2405: iload 4
    //   2407: aload 5
    //   2409: invokestatic 444	com/android/email/service/ImapService:a	(Landroid/content/Context;Lcom/android/emailcommon/provider/Account;JLawr;Lcom/android/emailcommon/provider/Mailbox;ZZLbbk;)V
    //   2412: aload 23
    //   2414: aload_1
    //   2415: getfield 158	com/android/emailcommon/provider/Account:D	J
    //   2418: iconst_1
    //   2419: invokeinterface 446 4 0
    //   2424: aload 18
    //   2426: ifnull +8 -> 2434
    //   2429: aload 18
    //   2431: invokevirtual 289	awr:e	()V
    //   2434: ldc 2
    //   2436: monitorexit
    //   2437: iconst_0
    //   2438: ireturn
    //   2439: iconst_0
    //   2440: istore 4
    //   2442: goto -78 -> 2364
    //   2445: aload_2
    //   2446: instanceof 448
    //   2449: ifeq -1634 -> 815
    //   2452: aload 23
    //   2454: aload_1
    //   2455: invokeinterface 451 2 0
    //   2460: goto -1645 -> 815
    //   2463: astore_0
    //   2464: aconst_null
    //   2465: astore 18
    //   2467: goto -1644 -> 823
    //   2470: astore_2
    //   2471: aload 17
    //   2473: astore_0
    //   2474: goto -1692 -> 782
    //   2477: astore 17
    //   2479: lload 11
    //   2481: lstore 15
    //   2483: goto -1881 -> 602
    //   2486: lload 13
    //   2488: lstore 11
    //   2490: goto -2414 -> 76
    //   2493: astore_0
    //   2494: goto -1671 -> 823
    //   2497: iconst_0
    //   2498: istore 10
    //   2500: goto -983 -> 1517
    //   2503: iconst_0
    //   2504: istore 10
    //   2506: goto -959 -> 1547
    //   2509: iconst_0
    //   2510: istore 10
    //   2512: goto -935 -> 1577
    //   2515: iconst_0
    //   2516: istore 10
    //   2518: goto -911 -> 1607
    //   2521: iconst_1
    //   2522: istore 4
    //   2524: goto -160 -> 2364
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2527	0	paramContext	Context
    //   0	2527	1	paramAccount	Account
    //   0	2527	2	paramMailbox	Mailbox
    //   0	2527	3	paramBoolean1	boolean
    //   0	2527	4	paramBoolean2	boolean
    //   0	2527	5	parambbk	bbk
    //   700	1271	6	j	int
    //   712	828	7	k	int
    //   724	846	8	m	int
    //   736	864	9	n	int
    //   1515	1002	10	bool	boolean
    //   74	2415	11	l1	long
    //   109	2378	13	l2	long
    //   78	2404	15	l3	long
    //   17	536	17	localObject1	Object
    //   561	37	17	localObject2	Object
    //   600	5	17	localbdi1	bdi
    //   641	1831	17	localObject3	Object
    //   2477	1	17	localbdi2	bdi
    //   24	2442	18	localObject4	Object
    //   69	1658	19	localObject5	Object
    //   105	150	20	localObject6	Object
    //   281	5	20	localbdi3	bdi
    //   422	1869	20	localObject7	Object
    //   137	1482	21	localObject8	Object
    //   1626	5	21	localbdi4	bdi
    //   1770	95	21	localObject9	Object
    //   1872	197	21	localbdi5	bdi
    //   2092	207	21	localObject10	Object
    //   262	1964	22	localObject11	Object
    //   14	2439	23	localbbx	bbx
    //   335	1884	24	localObject12	Object
    //   316	1905	25	localObject13	Object
    //   397	804	26	localCursor	Cursor
    // Exception table:
    //   from	to	target	type
    //   80	90	281	bdi
    //   94	107	281	bdi
    //   120	127	281	bdi
    //   131	139	281	bdi
    //   152	164	281	bdi
    //   168	176	281	bdi
    //   180	188	281	bdi
    //   192	203	281	bdi
    //   207	212	281	bdi
    //   216	229	281	bdi
    //   233	245	281	bdi
    //   252	264	281	bdi
    //   273	278	281	bdi
    //   845	854	281	bdi
    //   858	864	281	bdi
    //   868	873	281	bdi
    //   410	420	561	finally
    //   437	444	561	finally
    //   461	469	561	finally
    //   490	500	561	finally
    //   508	516	561	finally
    //   529	550	561	finally
    //   904	913	561	finally
    //   921	942	561	finally
    //   961	970	561	finally
    //   978	999	561	finally
    //   1018	1028	561	finally
    //   1036	1057	561	finally
    //   1076	1090	561	finally
    //   1098	1119	561	finally
    //   1138	1159	561	finally
    //   1167	1180	561	finally
    //   572	579	600	bdi
    //   588	593	600	bdi
    //   597	600	600	bdi
    //   1200	1207	600	bdi
    //   1216	1221	600	bdi
    //   26	71	778	bdi
    //   305	312	778	bdi
    //   312	337	778	bdi
    //   630	637	778	bdi
    //   637	654	778	bdi
    //   659	668	778	bdi
    //   668	699	778	bdi
    //   702	711	778	bdi
    //   714	723	778	bdi
    //   726	735	778	bdi
    //   758	775	778	bdi
    //   877	886	778	bdi
    //   886	893	778	bdi
    //   1232	1239	778	bdi
    //   1248	1255	778	bdi
    //   1255	1257	778	bdi
    //   1326	1343	778	bdi
    //   1628	1671	778	bdi
    //   1674	1702	778	bdi
    //   1707	1716	778	bdi
    //   1716	1745	778	bdi
    //   1821	1838	778	bdi
    //   1874	1927	778	bdi
    //   1927	1944	778	bdi
    //   2243	2306	778	bdi
    //   2309	2340	778	bdi
    //   2364	2378	778	bdi
    //   2383	2397	778	bdi
    //   2397	2424	778	bdi
    //   782	815	817	finally
    //   815	817	817	finally
    //   2445	2460	817	finally
    //   3	16	835	finally
    //   828	833	835	finally
    //   833	835	835	finally
    //   2429	2434	835	finally
    //   80	90	876	finally
    //   94	107	876	finally
    //   120	127	876	finally
    //   131	139	876	finally
    //   152	164	876	finally
    //   168	176	876	finally
    //   180	188	876	finally
    //   192	203	876	finally
    //   207	212	876	finally
    //   216	229	876	finally
    //   233	245	876	finally
    //   252	264	876	finally
    //   273	278	876	finally
    //   283	305	876	finally
    //   845	854	876	finally
    //   858	864	876	finally
    //   868	873	876	finally
    //   346	399	1242	finally
    //   572	579	1242	finally
    //   588	593	1242	finally
    //   597	600	1242	finally
    //   602	625	1242	finally
    //   1200	1207	1242	finally
    //   1216	1221	1242	finally
    //   1281	1299	1626	bdi
    //   1304	1320	1626	bdi
    //   1346	1397	1626	bdi
    //   1402	1492	1626	bdi
    //   1504	1509	1626	bdi
    //   1517	1528	1626	bdi
    //   1534	1539	1626	bdi
    //   1547	1558	1626	bdi
    //   1564	1569	1626	bdi
    //   1577	1588	1626	bdi
    //   1594	1599	1626	bdi
    //   1607	1618	1626	bdi
    //   1618	1623	1626	bdi
    //   1761	1772	1872	bdi
    //   1777	1821	1872	bdi
    //   1847	1859	1872	bdi
    //   1864	1869	1872	bdi
    //   1947	1978	1872	bdi
    //   1978	2015	1872	bdi
    //   2018	2053	1872	bdi
    //   2053	2073	1872	bdi
    //   2076	2094	1872	bdi
    //   2099	2168	1872	bdi
    //   2173	2240	1872	bdi
    //   19	26	2463	finally
    //   19	26	2470	bdi
    //   346	399	2477	bdi
    //   26	71	2493	finally
    //   305	312	2493	finally
    //   312	337	2493	finally
    //   630	637	2493	finally
    //   637	654	2493	finally
    //   659	668	2493	finally
    //   668	699	2493	finally
    //   702	711	2493	finally
    //   714	723	2493	finally
    //   726	735	2493	finally
    //   758	775	2493	finally
    //   877	886	2493	finally
    //   886	893	2493	finally
    //   1232	1239	2493	finally
    //   1248	1255	2493	finally
    //   1255	1257	2493	finally
    //   1281	1299	2493	finally
    //   1304	1320	2493	finally
    //   1326	1343	2493	finally
    //   1346	1397	2493	finally
    //   1402	1492	2493	finally
    //   1504	1509	2493	finally
    //   1517	1528	2493	finally
    //   1534	1539	2493	finally
    //   1547	1558	2493	finally
    //   1564	1569	2493	finally
    //   1577	1588	2493	finally
    //   1594	1599	2493	finally
    //   1607	1618	2493	finally
    //   1618	1623	2493	finally
    //   1628	1671	2493	finally
    //   1674	1702	2493	finally
    //   1707	1716	2493	finally
    //   1716	1745	2493	finally
    //   1761	1772	2493	finally
    //   1777	1821	2493	finally
    //   1821	1838	2493	finally
    //   1847	1859	2493	finally
    //   1864	1869	2493	finally
    //   1874	1927	2493	finally
    //   1927	1944	2493	finally
    //   1947	1978	2493	finally
    //   1978	2015	2493	finally
    //   2018	2053	2493	finally
    //   2053	2073	2493	finally
    //   2076	2094	2493	finally
    //   2099	2168	2493	finally
    //   2173	2240	2493	finally
    //   2243	2306	2493	finally
    //   2309	2340	2493	finally
    //   2364	2378	2493	finally
    //   2383	2397	2493	finally
    //   2397	2424	2493	finally
  }
  
  private static Mailbox a(Context paramContext, beb parambeb)
  {
    if (!TextUtils.isEmpty(ag))
    {
      long l = V;
      parambeb = ag;
      if ((l == f) && (parambeb.equals(g))) {
        return h;
      }
      paramContext = paramContext.getContentResolver().query(Mailbox.a, Mailbox.z, "serverId=? and accountKey=?", new String[] { parambeb, Long.toString(l) }, null);
      try
      {
        if (paramContext.moveToNext())
        {
          Mailbox localMailbox = new Mailbox();
          localMailbox.a(paramContext);
          f = l;
          g = parambeb;
          h = localMailbox;
          return localMailbox;
        }
        return null;
      }
      finally
      {
        paramContext.close();
      }
    }
    return Mailbox.a(paramContext, U);
  }
  
  private static Map<String, baz> a(ContentResolver paramContentResolver, Account paramAccount, Mailbox paramMailbox)
  {
    HashMap localHashMap = new HashMap();
    paramContentResolver = paramContentResolver.query(beb.a, baz.a, "accountKey=? AND mailboxKey=?", new String[] { String.valueOf(D), String.valueOf(D) }, null);
    for (;;)
    {
      if (paramContentResolver != null) {}
      try
      {
        if (paramContentResolver.moveToNext())
        {
          paramAccount = new baz(paramContentResolver);
          if (TextUtils.isEmpty(f)) {
            continue;
          }
          localHashMap.put(f, paramAccount);
        }
      }
      finally
      {
        if (paramContentResolver != null) {
          paramContentResolver.close();
        }
      }
    }
    return localHashMap;
  }
  
  private static void a(ContentResolver paramContentResolver, List<bdg> paramList, Map<String, baz> paramMap)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject1 = (bdg)paramList.next();
      Object localObject2 = (baz)paramMap.get(f);
      if (localObject2 != null)
      {
        boolean bool1 = c;
        boolean bool2 = ((bdg)localObject1).b(bda.b);
        int j;
        label74:
        int k;
        label101:
        int i1;
        label120:
        int m;
        label140:
        label152:
        int n;
        if (bool2 != bool1)
        {
          j = 1;
          bool1 = d;
          boolean bool3 = ((bdg)localObject1).b(bda.d);
          if (bool1 == bool3) {
            break label314;
          }
          k = 1;
          i1 = g;
          if ((0x40000 & i1) == 0) {
            break label320;
          }
          bool1 = true;
          boolean bool4 = ((bdg)localObject1).b(bda.c);
          if (bool1 == bool4) {
            break label326;
          }
          m = 1;
          if ((0x80000 & i1) == 0) {
            break label332;
          }
          bool1 = true;
          boolean bool5 = ((bdg)localObject1).b(bda.g);
          if (bool1 == bool5) {
            break label338;
          }
          n = 1;
          label172:
          if ((j == 0) && (k == 0) && (m == 0) && (n == 0)) {
            break label342;
          }
          cvm.a("ImapService", "Updating local tags for message %s", new Object[] { f });
          localObject1 = ContentUris.withAppendedId(beb.a, b);
          localObject2 = new ContentValues();
          ((ContentValues)localObject2).put("flagRead", Boolean.valueOf(bool2));
          ((ContentValues)localObject2).put("flagFavorite", Boolean.valueOf(bool3));
          if (!bool4) {
            break label344;
          }
          j = 0x40000 | i1;
          label272:
          if (!bool5) {
            break label354;
          }
          j |= 0x80000;
        }
        for (;;)
        {
          ((ContentValues)localObject2).put("flags", Integer.valueOf(j));
          paramContentResolver.update((Uri)localObject1, (ContentValues)localObject2, null, null);
          break;
          j = 0;
          break label74;
          label314:
          k = 0;
          break label101;
          label320:
          bool1 = false;
          break label120;
          label326:
          m = 0;
          break label140;
          label332:
          bool1 = false;
          break label152;
          label338:
          n = 0;
          break label172;
          label342:
          break;
          label344:
          j = 0xFFFBFFFF & i1;
          break label272;
          label354:
          j &= 0xFFF7FFFF;
        }
      }
    }
  }
  
  private static void a(Context paramContext, Account paramAccount, long paramLong, awr paramawr, Mailbox paramMailbox, boolean paramBoolean1, boolean paramBoolean2, bbk parambbk)
  {
    cwz localcwz;
    bdb localbdb;
    for (;;)
    {
      try
      {
        localcwz = new cwz("ImapService#synchronizeMailboxGeneric");
        cvm.b("ImapService", "synchronizeMailboxGeneric acct %d mailbox %d now %d loadMore %bfullSync %b", new Object[] { Long.valueOf(D), Long.valueOf(D), Long.valueOf(paramLong), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
        if ((h == 3) || (h == 4))
        {
          cvm.b("ImapService", "Aborting due to unsyncable mailbox", new Object[0]);
          return;
        }
        if (paramawr == null)
        {
          cvm.b("ImapService", "Aborting due to null remoteStore", new Object[0]);
          continue;
        }
        localbdb = paramawr.a(d);
      }
      finally {}
      if (((h != 6) && (h != 5)) || (localbdb.d())) {
        break label237;
      }
      j = bdc.b;
      if (localbdb.e()) {
        break;
      }
      cvm.d("ImapService", "could not create remote folder type %d", new Object[] { Integer.valueOf(h) });
    }
    cvm.a("ImapService", "Created remote folder of type %d", new Object[] { Integer.valueOf(h) });
    label237:
    localbdb.a(bdf.a);
    localcwz.a("openedFolder", null);
    int j = localbdb.f();
    cvm.a("ImapService", "Remote message count: %d", new Object[] { Integer.valueOf(j) });
    paramMailbox.a(paramContext, j);
    localcwz.a("msgCount", null);
    Map localMap = a(paramContext.getContentResolver(), paramAccount, paramMailbox);
    cvm.b("ImapService", "Found %d local messages", new Object[] { Integer.valueOf(localMap.size()) });
    int k;
    if (paramBoolean1)
    {
      k = Math.max(1, j - localMap.size() - 10 + 1);
      cvm.b("ImapService", "Loading more messages, retrieving UIDs %d:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(j) });
      paramawr = Arrays.asList(localbdb.a(k, j));
    }
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    Object localObject2;
    HashMap localHashMap;
    Object localObject1;
    Object localObject3;
    for (;;)
    {
      localcwz.a("gotMsgIds", null);
      localArrayList1 = new ArrayList(localMap.size());
      localArrayList2 = new ArrayList(paramawr.size());
      localObject2 = new ArrayList();
      localHashMap = new HashMap();
      a(paramawr, localMap, localArrayList1, localArrayList2, (ArrayList)localObject2, localHashMap);
      cvm.b("ImapService", "reconciled local messages synced %d unsynced %d upgrade %d", new Object[] { Integer.valueOf(localArrayList1.size()), Integer.valueOf(localArrayList2.size()), Integer.valueOf(((ArrayList)localObject2).size()) });
      localcwz.a("foundUnsynced", null);
      if ((!localArrayList1.isEmpty()) || (!paramBoolean2) || (paramawr.isEmpty())) {
        break label1342;
      }
      cvm.d("ImapService", "No overlap between local and remote messages, deleting all local", new Object[0]);
      localObject1 = localMap.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject1).next();
        a(paramContext, D, getValueb);
      }
      if (f == 6)
      {
        cvm.b("ImapService", "Sync window set to SYNC_WINDOW_ALL by debugging option", new Object[0]);
        paramawr = Arrays.asList(localbdb.a(1, j));
      }
      else if (paramBoolean2)
      {
        k = j + 1 - Math.min(300, j);
        if (j == 0)
        {
          cvm.b("ImapService", "zero remote messages, skipping sync", new Object[0]);
          paramawr = new ArrayList();
        }
        else
        {
          cvm.b("ImapService", "Full sync, retrieving UIDs %d:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(j) });
          paramawr = Arrays.asList(localbdb.a(k, j));
        }
      }
      else
      {
        paramLong -= 86400000L;
        cvm.b("ImapService", "Quick sync, window end %d", new Object[] { Long.valueOf(paramLong) });
        paramawr = Arrays.asList(localbdb.a(paramLong));
      }
    }
    localMap.clear();
    label1342:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      localObject1 = new bdk();
      long l;
      if ((localArrayList2.size() > 0) || (((ArrayList)localObject2).size() > 0))
      {
        paramLong = D;
        l = D;
        localObject3 = new bcx();
        ((bcx)localObject3).add(bcy.a);
        ((bcx)localObject3).add(bcy.b);
        bay localbay = new bay(paramContext, paramLong, l, new HashMap(localMap));
        if (localArrayList2.size() > 0) {
          localbdb.a((bdg[])localArrayList2.toArray(new bdg[localArrayList2.size()]), (bcx)localObject3, localbay);
        }
        if (((List)localObject2).size() > 0) {
          localbdb.a((bdg[])((List)localObject2).toArray(new bdg[((List)localObject2).size()]), (bcx)localObject3, localbay);
        }
        ((bdk)localObject1).a(e);
        localcwz.a("downloadedUnsyncedFlags", null);
      }
      a(localbdb, localArrayList1);
      localcwz.a("downloadedSyncedFlags", null);
      a(paramContext.getContentResolver(), paramawr, localMap);
      localcwz.a("updatedFlags", null);
      paramLong = Long.MAX_VALUE;
      localObject2 = paramawr.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (bdg)((Iterator)localObject2).next();
        if (((bdg)localObject3).g() != null)
        {
          l = ((bdg)localObject3).g().getTime();
          if ((l > 0L) && (l < paramLong)) {
            paramLong = l;
          }
        }
      }
      if (paramBoolean2) {
        localcwz.a("processedRemoteDeletes", String.valueOf(a(paramContext, paramAccount, paramLong, paramawr, localMap, localArrayList2, localHashMap)));
      }
      a(paramContext, paramAccount, localbdb, localArrayList2, paramMailbox);
      localcwz.a("loadedMsgs", null);
      if (paramBoolean2)
      {
        paramLong = SystemClock.elapsedRealtime();
        if (paramLong != v)
        {
          paramawr = new ContentValues(1);
          paramawr.put("lastFullSyncTime", Long.valueOf(paramLong));
          paramMailbox.a(paramContext, paramawr);
          v = paramLong;
        }
        cvm.a("ImapService", "Updated full sync time to %d", new Object[] { Long.valueOf(paramLong) });
      }
      localcwz.a("addedSyncInfo", null);
      ((bdk)localObject1).a(localbdb.h());
      parambbk.a(D, paramBoolean2, paramBoolean1, j, localArrayList1.size(), localArrayList2.size(), (bdk)localObject1, localcwz.toString());
      localbdb.b();
      localcwz.a("closedFolder", null);
      localcwz.a();
      e.add(localcwz);
      if (h != 0) {
        break;
      }
      cfg.b(paramContext, d).c(j);
      break;
    }
  }
  
  private static void a(Context paramContext, Account paramAccount, bdb parambdb, List<bdg> paramList, Mailbox paramMailbox)
  {
    bcx localbcx = new bcx();
    localbcx.add(bcy.c);
    parambdb.a((bdg[])paramList.toArray(new bdg[paramList.size()]), localbcx, null);
    bdg[] arrayOfbdg = new bdg[1];
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bdg localbdg = (bdg)paramList.next();
      Object localObject = new ArrayList();
      bco.a(localbdg, (ArrayList)localObject, new ArrayList());
      arrayOfbdg[0] = localbdg;
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        bdn localbdn = (bdn)((Iterator)localObject).next();
        localbcx.clear();
        localbcx.add(localbdn);
        parambdb.a(arrayOfbdg, localbcx, null);
      }
      baa.a(paramContext, localbdg, paramAccount, paramMailbox, 1);
    }
  }
  
  private static void a(bdb parambdb, List<bdg> paramList)
  {
    bcx localbcx = new bcx();
    localbcx.add(bcy.a);
    if (paramList.size() > 500)
    {
      int j = 0;
      while (j < paramList.size())
      {
        int m = j + 500;
        int k = m;
        if (m >= paramList.size()) {
          k = paramList.size();
        }
        cvm.a("ImapService", "Fetching message flags for count %d to %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
        List localList = paramList.subList(j, k);
        parambdb.a((bdg[])localList.toArray(new bdg[localList.size()]), localbcx, null);
        j += 500;
      }
    }
    cvm.a("ImapService", "Fetching message flags for %d messages", new Object[] { Integer.valueOf(paramList.size()) });
    parambdb.a((bdg[])paramList.toArray(new bdg[paramList.size()]), localbcx, null);
  }
  
  private static void a(List<bdg> paramList, Map<String, baz> paramMap, ArrayList<bdg> paramArrayList1, ArrayList<bdg> paramArrayList2, ArrayList<bdg> paramArrayList3, Map<String, bdg> paramMap1)
  {
    int j = paramList.size() - 1;
    if (j >= 0)
    {
      bdg localbdg = (bdg)paramList.get(j);
      paramMap1.put(f, localbdg);
      baz localbaz = (baz)paramMap.get(f);
      if ((localbaz == null) || (e == 0) || (beb.a(e)))
      {
        cvm.a("ImapService", "Found unsynced message %s", new Object[] { f });
        paramArrayList2.add(localbdg);
      }
      for (;;)
      {
        j -= 1;
        break;
        if (e == 6)
        {
          cvm.a("ImapService", "Found message %s to upgrade threading header", new Object[] { f });
          paramArrayList3.add(localbdg);
        }
        cvm.a("ImapService", "Found synced message %s", new Object[] { f });
        localbdg.a(new Date(h));
        paramArrayList1.add(localbdg);
      }
    }
  }
  
  private static boolean a(Context paramContext, awr paramawr, Mailbox paramMailbox, beb parambeb, boolean paramBoolean)
  {
    int j = 0;
    boolean bool = true;
    paramMailbox = paramawr.a(d);
    int k;
    if (!paramMailbox.d())
    {
      k = bdc.b;
      if (!paramMailbox.e())
      {
        paramBoolean = false;
        return paramBoolean;
      }
    }
    paramMailbox.a(bdf.a);
    if (paramMailbox.a() != bdf.a) {
      return false;
    }
    if ((x != null) && (x.length() > 0)) {}
    int n;
    for (paramawr = paramMailbox.a(x);; paramawr = null)
    {
      int m;
      if (paramawr == null)
      {
        paramawr = aqt.a(paramContext, parambeb);
        paramMailbox.a(paramContext, paramawr, paramBoolean);
        x = f;
        k = 0;
        m = 1;
        j = 1;
      }
      for (;;)
      {
        n = j;
        if (m != 0)
        {
          n = j;
          if (x == null) {}
        }
        try
        {
          paramawr = paramMailbox.a(x);
          n = j;
          if (paramawr != null)
          {
            localbcx = new bcx();
            localbcx.add(bcy.b);
            paramMailbox.a(new bdg[] { paramawr }, localbcx, null);
            n = j;
            if (g != null)
            {
              y = g.getTime();
              n = 1;
            }
          }
        }
        catch (bdi paramawr)
        {
          for (;;)
          {
            bcx localbcx;
            Object localObject;
            Date localDate;
            n = j;
          }
        }
        if (k == 0)
        {
          paramBoolean = bool;
          if (n == 0) {
            break;
          }
        }
        paramawr = ContentUris.withAppendedId(beb.a, D);
        paramContext = paramContext.getContentResolver();
        if (k == 0) {
          break label400;
        }
        paramContext.delete(paramawr, null, null);
        return true;
        localbcx = new bcx();
        localbcx.add(bcy.b);
        paramMailbox.a(new bdg[] { paramawr }, localbcx, null);
        localObject = new Date(y);
        localDate = g;
        if ((localDate != null) && (localDate.compareTo((Date)localObject) > 0))
        {
          k = 1;
          m = 0;
        }
        else
        {
          localObject = aqt.a(paramContext, parambeb);
          localbcx.clear();
          new bcx().add(bcy.e);
          paramMailbox.a(paramContext, (bdg)localObject, paramBoolean);
          x = f;
          paramawr.a(bda.a, true);
          k = 0;
          m = 1;
          j = 1;
        }
      }
      label400:
      paramBoolean = bool;
      if (n == 0) {
        break;
      }
      paramMailbox = new ContentValues();
      paramMailbox.put("syncServerId", x);
      paramMailbox.put("syncServerTimeStamp", Long.valueOf(y));
      paramContext.update(paramawr, paramMailbox, null, null);
      return true;
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    i.a = this;
    return i;
  }
  
  public void onCreate()
  {
    super.onCreate();
    a = getString(arh.bM);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return 1;
  }
}

/* Location:
 * Qualified Name:     com.android.email.service.ImapService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */