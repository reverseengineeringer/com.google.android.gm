import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.provider.CalendarContract.Events;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.android.mail.providers.Event;
import java.util.regex.Pattern;

public final class ayv
  extends CursorWrapper
{
  private static final String a = cvl.a;
  private static final Pattern v = Pattern.compile("<(?i)img\\s+");
  private final SparseArray<String> b;
  private final SparseArray<String> c;
  private final SparseIntArray d;
  private final SparseIntArray e;
  private final SparseArray<String> f;
  private final SparseArray<String> g;
  private final SparseIntArray h;
  private final SparseIntArray i;
  private final SparseArray<String> j;
  private final SparseIntArray k;
  private final SparseArray<Event> l;
  private final int m;
  private final int n;
  private final int o;
  private final int p;
  private final int q;
  private final int r;
  private final int s;
  private final int t;
  private final int u;
  
  /* Error */
  public ayv(Context paramContext, Cursor paramCursor)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_2
    //   2: invokespecial 60	android/database/CursorWrapper:<init>	(Landroid/database/Cursor;)V
    //   5: aload_0
    //   6: aload_2
    //   7: ldc 62
    //   9: invokeinterface 68 2 0
    //   14: putfield 70	ayv:n	I
    //   17: aload_0
    //   18: aload_2
    //   19: ldc 72
    //   21: invokeinterface 68 2 0
    //   26: putfield 74	ayv:m	I
    //   29: aload_0
    //   30: aload_2
    //   31: ldc 76
    //   33: invokeinterface 68 2 0
    //   38: putfield 78	ayv:o	I
    //   41: aload_0
    //   42: aload_2
    //   43: ldc 80
    //   45: invokeinterface 68 2 0
    //   50: putfield 82	ayv:p	I
    //   53: aload_0
    //   54: aload_2
    //   55: ldc 84
    //   57: invokeinterface 68 2 0
    //   62: putfield 86	ayv:q	I
    //   65: aload_0
    //   66: aload_2
    //   67: ldc 88
    //   69: invokeinterface 68 2 0
    //   74: putfield 90	ayv:r	I
    //   77: aload_0
    //   78: aload_2
    //   79: ldc 92
    //   81: invokeinterface 68 2 0
    //   86: putfield 94	ayv:s	I
    //   89: aload_0
    //   90: aload_2
    //   91: ldc 96
    //   93: invokeinterface 68 2 0
    //   98: putfield 98	ayv:t	I
    //   101: aload_0
    //   102: aload_2
    //   103: ldc 100
    //   105: invokeinterface 68 2 0
    //   110: putfield 102	ayv:u	I
    //   113: aload_2
    //   114: invokeinterface 106 1 0
    //   119: istore_3
    //   120: aload_0
    //   121: new 108	android/util/SparseArray
    //   124: dup
    //   125: iload_3
    //   126: invokespecial 111	android/util/SparseArray:<init>	(I)V
    //   129: putfield 113	ayv:c	Landroid/util/SparseArray;
    //   132: aload_0
    //   133: new 108	android/util/SparseArray
    //   136: dup
    //   137: iload_3
    //   138: invokespecial 111	android/util/SparseArray:<init>	(I)V
    //   141: putfield 115	ayv:b	Landroid/util/SparseArray;
    //   144: aload_0
    //   145: new 117	android/util/SparseIntArray
    //   148: dup
    //   149: iload_3
    //   150: invokespecial 118	android/util/SparseIntArray:<init>	(I)V
    //   153: putfield 120	ayv:d	Landroid/util/SparseIntArray;
    //   156: aload_0
    //   157: new 117	android/util/SparseIntArray
    //   160: dup
    //   161: iload_3
    //   162: invokespecial 118	android/util/SparseIntArray:<init>	(I)V
    //   165: putfield 122	ayv:e	Landroid/util/SparseIntArray;
    //   168: aload_0
    //   169: new 108	android/util/SparseArray
    //   172: dup
    //   173: iload_3
    //   174: invokespecial 111	android/util/SparseArray:<init>	(I)V
    //   177: putfield 124	ayv:f	Landroid/util/SparseArray;
    //   180: aload_0
    //   181: new 108	android/util/SparseArray
    //   184: dup
    //   185: iload_3
    //   186: invokespecial 111	android/util/SparseArray:<init>	(I)V
    //   189: putfield 126	ayv:g	Landroid/util/SparseArray;
    //   192: aload_0
    //   193: new 117	android/util/SparseIntArray
    //   196: dup
    //   197: iload_3
    //   198: invokespecial 118	android/util/SparseIntArray:<init>	(I)V
    //   201: putfield 128	ayv:h	Landroid/util/SparseIntArray;
    //   204: aload_0
    //   205: new 117	android/util/SparseIntArray
    //   208: dup
    //   209: iload_3
    //   210: invokespecial 118	android/util/SparseIntArray:<init>	(I)V
    //   213: putfield 130	ayv:i	Landroid/util/SparseIntArray;
    //   216: aload_0
    //   217: new 108	android/util/SparseArray
    //   220: dup
    //   221: iload_3
    //   222: invokespecial 111	android/util/SparseArray:<init>	(I)V
    //   225: putfield 132	ayv:j	Landroid/util/SparseArray;
    //   228: aload_0
    //   229: new 117	android/util/SparseIntArray
    //   232: dup
    //   233: iload_3
    //   234: invokespecial 118	android/util/SparseIntArray:<init>	(I)V
    //   237: putfield 134	ayv:k	Landroid/util/SparseIntArray;
    //   240: aload_0
    //   241: new 108	android/util/SparseArray
    //   244: dup
    //   245: iload_3
    //   246: invokespecial 111	android/util/SparseArray:<init>	(I)V
    //   249: putfield 136	ayv:l	Landroid/util/SparseArray;
    //   252: aload_1
    //   253: invokevirtual 142	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   256: astore 14
    //   258: aload_2
    //   259: invokeinterface 146 1 0
    //   264: ifeq +880 -> 1144
    //   267: aload_2
    //   268: invokeinterface 149 1 0
    //   273: istore 6
    //   275: aload_2
    //   276: aload_2
    //   277: ldc -105
    //   279: invokeinterface 68 2 0
    //   284: invokeinterface 155 2 0
    //   289: lstore 8
    //   291: aload_1
    //   292: lload 8
    //   294: invokestatic 160	beb:a	(Landroid/content/Context;J)Lbeb;
    //   297: astore 15
    //   299: aload 15
    //   301: ifnull +515 -> 816
    //   304: aload_1
    //   305: lload 8
    //   307: invokestatic 165	bds:a	(Landroid/content/Context;J)Lbds;
    //   310: astore 13
    //   312: aload 13
    //   314: ifnull +38 -> 352
    //   317: aload 13
    //   319: getfield 167	bds:d	Ljava/lang/String;
    //   322: ifnull +30 -> 352
    //   325: getstatic 50	ayv:v	Ljava/util/regex/Pattern;
    //   328: aload 13
    //   330: getfield 167	bds:d	Ljava/lang/String;
    //   333: invokevirtual 171	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   336: invokevirtual 176	java/util/regex/Matcher:find	()Z
    //   339: ifeq +13 -> 352
    //   342: aload_0
    //   343: getfield 120	ayv:d	Landroid/util/SparseIntArray;
    //   346: iload 6
    //   348: iconst_1
    //   349: invokevirtual 180	android/util/SparseIntArray:put	(II)V
    //   352: aload 15
    //   354: getfield 183	beb:X	Ljava/lang/String;
    //   357: invokestatic 188	com/android/emailcommon/mail/Address:h	(Ljava/lang/String;)[Lcom/android/emailcommon/mail/Address;
    //   360: astore 13
    //   362: iconst_0
    //   363: istore 5
    //   365: aload_1
    //   366: invokestatic 193	cfm:a	(Landroid/content/Context;)Lcfm;
    //   369: astore 16
    //   371: aload 13
    //   373: arraylength
    //   374: istore 7
    //   376: iconst_0
    //   377: istore_3
    //   378: iload 5
    //   380: istore 4
    //   382: iload_3
    //   383: iload 7
    //   385: if_icmpge +21 -> 406
    //   388: aload 16
    //   390: aload 13
    //   392: iload_3
    //   393: aaload
    //   394: getfield 194	com/android/emailcommon/mail/Address:a	Ljava/lang/String;
    //   397: invokevirtual 197	cfm:c	(Ljava/lang/String;)Z
    //   400: ifeq +541 -> 941
    //   403: iconst_1
    //   404: istore 4
    //   406: aload_0
    //   407: getfield 122	ayv:e	Landroid/util/SparseIntArray;
    //   410: iload 6
    //   412: iload 4
    //   414: invokevirtual 180	android/util/SparseIntArray:put	(II)V
    //   417: getstatic 203	bdv:H	Landroid/net/Uri;
    //   420: invokevirtual 209	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   423: ldc -45
    //   425: invokevirtual 217	android/net/Uri$Builder:appendPath	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   428: lload 8
    //   430: invokestatic 223	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   433: invokevirtual 217	android/net/Uri$Builder:appendPath	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   436: invokevirtual 227	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   439: astore 13
    //   441: aload_1
    //   442: invokevirtual 142	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   445: aload 13
    //   447: getstatic 232	chh:o	[Ljava/lang/String;
    //   450: aconst_null
    //   451: aconst_null
    //   452: aconst_null
    //   453: invokevirtual 238	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   456: invokestatic 243	com/android/mail/providers/Attachment:a	(Landroid/database/Cursor;)Ljava/util/List;
    //   459: astore 13
    //   461: aload 13
    //   463: ifnull +27 -> 490
    //   466: aload 13
    //   468: invokeinterface 248 1 0
    //   473: ifle +17 -> 490
    //   476: aload_0
    //   477: getfield 124	ayv:f	Landroid/util/SparseArray;
    //   480: iload 6
    //   482: aload 13
    //   484: invokestatic 251	com/android/mail/providers/Attachment:a	(Ljava/util/Collection;)Ljava/lang/String;
    //   487: invokevirtual 254	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   490: aload 15
    //   492: getfield 257	beb:z	I
    //   495: ifeq +49 -> 544
    //   498: aload_0
    //   499: getfield 128	ayv:h	Landroid/util/SparseIntArray;
    //   502: astore 13
    //   504: aload 15
    //   506: getfield 257	beb:z	I
    //   509: ldc_w 258
    //   512: iand
    //   513: ifeq +435 -> 948
    //   516: iconst_1
    //   517: istore_3
    //   518: aload 13
    //   520: iload 6
    //   522: iload_3
    //   523: invokevirtual 180	android/util/SparseIntArray:put	(II)V
    //   526: aload_0
    //   527: getfield 130	ayv:i	Landroid/util/SparseIntArray;
    //   530: iload 6
    //   532: aload 15
    //   534: getfield 257	beb:z	I
    //   537: ldc_w 259
    //   540: iand
    //   541: invokevirtual 180	android/util/SparseIntArray:put	(II)V
    //   544: aload 15
    //   546: getfield 260	beb:u	I
    //   549: iconst_4
    //   550: iand
    //   551: ifeq +402 -> 953
    //   554: iconst_1
    //   555: istore_3
    //   556: iload_3
    //   557: ifeq +190 -> 747
    //   560: new 262	bdl
    //   563: dup
    //   564: aload 15
    //   566: getfield 265	beb:ac	Ljava/lang/String;
    //   569: invokespecial 268	bdl:<init>	(Ljava/lang/String;)V
    //   572: astore 16
    //   574: aload_1
    //   575: aload 16
    //   577: invokestatic 271	ayv:a	(Landroid/content/Context;Lbdl;)J
    //   580: lstore 10
    //   582: lload 10
    //   584: ldc2_w 272
    //   587: lcmp
    //   588: ifeq +370 -> 958
    //   591: getstatic 278	android/provider/CalendarContract$Events:CONTENT_URI	Landroid/net/Uri;
    //   594: lload 10
    //   596: invokestatic 284	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   599: invokevirtual 288	android/net/Uri:toString	()Ljava/lang/String;
    //   602: astore 13
    //   604: new 290	cgh
    //   607: dup
    //   608: invokespecial 292	cgh:<init>	()V
    //   611: astore 17
    //   613: aload 17
    //   615: aload 16
    //   617: ldc_w 294
    //   620: invokevirtual 297	bdl:a	(Ljava/lang/String;)Ljava/lang/String;
    //   623: putfield 298	cgh:a	Ljava/lang/String;
    //   626: aload 16
    //   628: ldc_w 300
    //   631: invokevirtual 297	bdl:a	(Ljava/lang/String;)Ljava/lang/String;
    //   634: ifnull +335 -> 969
    //   637: iconst_1
    //   638: istore 12
    //   640: aload 17
    //   642: iload 12
    //   644: putfield 303	cgh:d	Z
    //   647: aload 17
    //   649: aload 16
    //   651: ldc_w 305
    //   654: invokevirtual 297	bdl:a	(Ljava/lang/String;)Ljava/lang/String;
    //   657: putfield 307	cgh:e	Ljava/lang/String;
    //   660: aload 17
    //   662: aload 16
    //   664: ldc_w 309
    //   667: invokevirtual 297	bdl:a	(Ljava/lang/String;)Ljava/lang/String;
    //   670: putfield 311	cgh:f	Ljava/lang/String;
    //   673: aload 17
    //   675: aload 16
    //   677: ldc_w 313
    //   680: invokevirtual 297	bdl:a	(Ljava/lang/String;)Ljava/lang/String;
    //   683: putfield 315	cgh:h	Ljava/lang/String;
    //   686: aload 17
    //   688: aload 16
    //   690: ldc_w 317
    //   693: invokevirtual 297	bdl:a	(Ljava/lang/String;)Ljava/lang/String;
    //   696: invokestatic 322	bhn:b	(Ljava/lang/String;)J
    //   699: putfield 325	cgh:b	J
    //   702: aload 17
    //   704: aload 16
    //   706: ldc_w 327
    //   709: invokevirtual 297	bdl:a	(Ljava/lang/String;)Ljava/lang/String;
    //   712: invokestatic 322	bhn:b	(Ljava/lang/String;)J
    //   715: putfield 329	cgh:c	J
    //   718: aload_0
    //   719: getfield 136	ayv:l	Landroid/util/SparseArray;
    //   722: iload 6
    //   724: new 331	com/android/mail/providers/Event
    //   727: dup
    //   728: aload 17
    //   730: invokespecial 334	com/android/mail/providers/Event:<init>	(Lcgh;)V
    //   733: invokevirtual 254	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   736: aload_0
    //   737: getfield 132	ayv:j	Landroid/util/SparseArray;
    //   740: iload 6
    //   742: aload 13
    //   744: invokevirtual 254	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   747: ldc -45
    //   749: lload 8
    //   751: invokestatic 339	com/android/email/provider/EmailProvider:a	(Ljava/lang/String;J)Landroid/net/Uri;
    //   754: invokevirtual 209	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   757: astore 16
    //   759: aload 15
    //   761: getfield 340	beb:r	I
    //   764: iconst_1
    //   765: if_icmpne +322 -> 1087
    //   768: ldc_w 342
    //   771: astore 13
    //   773: aload 16
    //   775: ldc_w 344
    //   778: aload 13
    //   780: invokevirtual 348	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   783: invokevirtual 227	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   786: astore 13
    //   788: aload_0
    //   789: getfield 126	ayv:g	Landroid/util/SparseArray;
    //   792: iload 6
    //   794: aload 13
    //   796: invokevirtual 288	android/net/Uri:toString	()Ljava/lang/String;
    //   799: invokevirtual 254	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   802: aload_0
    //   803: getfield 134	ayv:k	Landroid/util/SparseIntArray;
    //   806: iload 6
    //   808: aload 15
    //   810: getfield 350	beb:v	I
    //   813: invokevirtual 180	android/util/SparseIntArray:put	(II)V
    //   816: aload_0
    //   817: getfield 70	ayv:n	I
    //   820: iconst_m1
    //   821: if_icmpeq +45 -> 866
    //   824: aload 14
    //   826: lload 8
    //   828: invokestatic 353	bds:b	(J)Landroid/net/Uri;
    //   831: invokevirtual 357	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   834: astore 13
    //   836: aload 13
    //   838: invokestatic 362	idc:c	(Ljava/io/InputStream;)Ljava/lang/String;
    //   841: astore 15
    //   843: aload 13
    //   845: invokevirtual 367	java/io/InputStream:close	()V
    //   848: aload 15
    //   850: invokestatic 370	cux:a	(Ljava/lang/String;)Ljava/lang/String;
    //   853: astore 13
    //   855: aload_0
    //   856: getfield 113	ayv:c	Landroid/util/SparseArray;
    //   859: iload 6
    //   861: aload 13
    //   863: invokevirtual 254	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   866: aload_0
    //   867: getfield 74	ayv:m	I
    //   870: iconst_m1
    //   871: if_icmpeq -613 -> 258
    //   874: aload 14
    //   876: lload 8
    //   878: invokestatic 372	bds:a	(J)Landroid/net/Uri;
    //   881: invokevirtual 357	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   884: astore 13
    //   886: aload 13
    //   888: invokestatic 362	idc:c	(Ljava/io/InputStream;)Ljava/lang/String;
    //   891: astore 15
    //   893: aload 13
    //   895: invokevirtual 367	java/io/InputStream:close	()V
    //   898: aload_0
    //   899: getfield 115	ayv:b	Landroid/util/SparseArray;
    //   902: iload 6
    //   904: aload 15
    //   906: invokevirtual 254	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   909: goto -651 -> 258
    //   912: astore 13
    //   914: getstatic 375	cvm:a	Ljava/lang/String;
    //   917: aload 13
    //   919: ldc_w 377
    //   922: iconst_1
    //   923: anewarray 379	java/lang/Object
    //   926: dup
    //   927: iconst_0
    //   928: lload 8
    //   930: invokestatic 384	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   933: aastore
    //   934: invokestatic 387	cvm:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   937: pop
    //   938: goto -680 -> 258
    //   941: iload_3
    //   942: iconst_1
    //   943: iadd
    //   944: istore_3
    //   945: goto -567 -> 378
    //   948: iconst_0
    //   949: istore_3
    //   950: goto -432 -> 518
    //   953: iconst_0
    //   954: istore_3
    //   955: goto -399 -> 556
    //   958: getstatic 390	android/net/Uri:EMPTY	Landroid/net/Uri;
    //   961: invokevirtual 288	android/net/Uri:toString	()Ljava/lang/String;
    //   964: astore 13
    //   966: goto -362 -> 604
    //   969: iconst_0
    //   970: istore 12
    //   972: goto -332 -> 640
    //   975: astore 18
    //   977: getstatic 40	ayv:a	Ljava/lang/String;
    //   980: aload 18
    //   982: ldc_w 392
    //   985: iconst_0
    //   986: anewarray 379	java/lang/Object
    //   989: invokestatic 394	cvm:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   992: pop
    //   993: getstatic 40	ayv:a	Ljava/lang/String;
    //   996: iconst_3
    //   997: invokestatic 397	cvm:a	(Ljava/lang/String;I)Z
    //   1000: ifeq -298 -> 702
    //   1003: getstatic 40	ayv:a	Ljava/lang/String;
    //   1006: ldc_w 399
    //   1009: iconst_1
    //   1010: anewarray 379	java/lang/Object
    //   1013: dup
    //   1014: iconst_0
    //   1015: aload 16
    //   1017: ldc_w 317
    //   1020: invokevirtual 297	bdl:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1023: aastore
    //   1024: invokestatic 402	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1027: pop
    //   1028: goto -326 -> 702
    //   1031: astore 18
    //   1033: getstatic 40	ayv:a	Ljava/lang/String;
    //   1036: aload 18
    //   1038: ldc_w 404
    //   1041: iconst_0
    //   1042: anewarray 379	java/lang/Object
    //   1045: invokestatic 394	cvm:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1048: pop
    //   1049: getstatic 40	ayv:a	Ljava/lang/String;
    //   1052: iconst_3
    //   1053: invokestatic 397	cvm:a	(Ljava/lang/String;I)Z
    //   1056: ifeq -338 -> 718
    //   1059: getstatic 40	ayv:a	Ljava/lang/String;
    //   1062: ldc_w 406
    //   1065: iconst_1
    //   1066: anewarray 379	java/lang/Object
    //   1069: dup
    //   1070: iconst_0
    //   1071: aload 16
    //   1073: ldc_w 327
    //   1076: invokevirtual 297	bdl:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1079: aastore
    //   1080: invokestatic 402	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1083: pop
    //   1084: goto -366 -> 718
    //   1087: ldc_w 408
    //   1090: astore 13
    //   1092: goto -319 -> 773
    //   1095: astore 15
    //   1097: aload 13
    //   1099: invokevirtual 367	java/io/InputStream:close	()V
    //   1102: aload 15
    //   1104: athrow
    //   1105: astore 13
    //   1107: getstatic 375	cvm:a	Ljava/lang/String;
    //   1110: aload 13
    //   1112: ldc_w 410
    //   1115: iconst_1
    //   1116: anewarray 379	java/lang/Object
    //   1119: dup
    //   1120: iconst_0
    //   1121: lload 8
    //   1123: invokestatic 384	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1126: aastore
    //   1127: invokestatic 387	cvm:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1130: pop
    //   1131: goto -265 -> 866
    //   1134: astore 15
    //   1136: aload 13
    //   1138: invokevirtual 367	java/io/InputStream:close	()V
    //   1141: aload 15
    //   1143: athrow
    //   1144: aload_2
    //   1145: iconst_m1
    //   1146: invokeinterface 414 2 0
    //   1151: pop
    //   1152: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1153	0	this	ayv
    //   0	1153	1	paramContext	Context
    //   0	1153	2	paramCursor	Cursor
    //   119	836	3	i1	int
    //   380	33	4	i2	int
    //   363	16	5	i3	int
    //   273	630	6	i4	int
    //   374	12	7	i5	int
    //   289	833	8	l1	long
    //   580	15	10	l2	long
    //   638	333	12	bool	boolean
    //   310	584	13	localObject1	Object
    //   912	6	13	localIOException1	java.io.IOException
    //   964	134	13	str	String
    //   1105	32	13	localIOException2	java.io.IOException
    //   256	619	14	localContentResolver	ContentResolver
    //   297	608	15	localObject2	Object
    //   1095	8	15	localObject3	Object
    //   1134	8	15	localObject4	Object
    //   369	703	16	localObject5	Object
    //   611	118	17	localcgh	cgh
    //   975	6	18	localParseException1	java.text.ParseException
    //   1031	6	18	localParseException2	java.text.ParseException
    // Exception table:
    //   from	to	target	type
    //   866	886	912	java/io/IOException
    //   893	909	912	java/io/IOException
    //   1136	1144	912	java/io/IOException
    //   686	702	975	java/text/ParseException
    //   702	718	1031	java/text/ParseException
    //   836	843	1095	finally
    //   816	836	1105	java/io/IOException
    //   843	866	1105	java/io/IOException
    //   1097	1105	1105	java/io/IOException
    //   886	893	1134	finally
  }
  
  private static long a(Context paramContext, bdl parambdl)
  {
    if (cwm.a(paramContext, "android.permission.READ_CALENDAR"))
    {
      parambdl = parambdl.a("UID");
      if (parambdl != null)
      {
        paramContext = paramContext.getContentResolver().query(CalendarContract.Events.CONTENT_URI, new String[] { "_id" }, "sync_data2=?", new String[] { parambdl }, null);
        if (paramContext == null) {}
      }
    }
    for (;;)
    {
      try
      {
        if (paramContext.getCount() == 1)
        {
          paramContext.moveToFirst();
          long l1 = paramContext.getLong(0);
          return l1;
        }
        paramContext.close();
        bus.a("calendar_event_viewer", "enabled");
        return -1L;
      }
      finally
      {
        paramContext.close();
      }
      bus.a("calendar_event_viewer", "disabled");
    }
  }
  
  public final int getInt(int paramInt)
  {
    Object localObject;
    if (paramInt == o)
    {
      localObject = Integer.valueOf(d.get(getPosition()));
      if (localObject != null) {
        return ((Integer)localObject).intValue();
      }
      return 0;
    }
    if (paramInt == p)
    {
      localObject = Integer.valueOf(e.get(getPosition()));
      if (localObject != null) {
        return ((Integer)localObject).intValue();
      }
      return 0;
    }
    if (paramInt == s)
    {
      localObject = Integer.valueOf(h.get(getPosition()));
      if (localObject != null) {
        return ((Integer)localObject).intValue();
      }
      return 0;
    }
    if (paramInt == t)
    {
      localObject = Integer.valueOf(i.get(getPosition()));
      if (localObject != null) {
        return ((Integer)localObject).intValue();
      }
      return 0;
    }
    if (paramInt == 63)
    {
      paramInt = k.get(getPosition());
      if ((paramInt & 0x1) != 0) {
        return 1;
      }
      if ((paramInt & 0x2) != 0) {
        return 2;
      }
      if ((paramInt & 0x4) != 0) {
        return 3;
      }
      return 0;
    }
    if (paramInt == 45)
    {
      localObject = (Event)l.get(getPosition());
      if (localObject != null)
      {
        if (d) {
          return 1;
        }
        return 0;
      }
    }
    return super.getInt(paramInt);
  }
  
  public final long getLong(int paramInt)
  {
    switch (paramInt)
    {
    }
    Event localEvent;
    do
    {
      do
      {
        return super.getLong(paramInt);
        localEvent = (Event)l.get(getPosition());
      } while (localEvent == null);
      return b;
      localEvent = (Event)l.get(getPosition());
    } while (localEvent == null);
    return c;
  }
  
  public final String getString(int paramInt)
  {
    if (paramInt == n) {
      return (String)c.get(getPosition());
    }
    if (paramInt == m) {
      return (String)b.get(getPosition());
    }
    if (paramInt == q) {
      return (String)f.get(getPosition());
    }
    if (paramInt == r) {
      return (String)g.get(getPosition());
    }
    if (paramInt == u) {
      return (String)j.get(getPosition());
    }
    Event localEvent;
    if (paramInt == 42)
    {
      localEvent = (Event)l.get(getPosition());
      if (localEvent != null) {
        return a;
      }
    }
    else if (paramInt == 46)
    {
      localEvent = (Event)l.get(getPosition());
      if (localEvent != null) {
        return e;
      }
    }
    else if (paramInt == 47)
    {
      localEvent = (Event)l.get(getPosition());
      if (localEvent != null) {
        return f;
      }
    }
    else if (paramInt == 49)
    {
      localEvent = (Event)l.get(getPosition());
      if (localEvent != null) {
        return h;
      }
    }
    return super.getString(paramInt);
  }
  
  public final int getType(int paramInt)
  {
    if ((paramInt == n) || (paramInt == m) || (paramInt == q) || (paramInt == r) || (paramInt == u)) {
      return 3;
    }
    return super.getType(paramInt);
  }
}

/* Location:
 * Qualified Name:     ayv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */