import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.os.SystemClock;
import com.android.emailcommon.provider.Mailbox;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.http.HttpEntity;

public final class bps
  extends bqc
{
  public static final String[] a = { "count(*)" };
  private static final List<String> e;
  final Bundle b;
  btd c;
  Set<String> d;
  private final Set<String> k = new HashSet();
  private final Set<String> l = new HashSet();
  private boolean m;
  
  static
  {
    ArrayList localArrayList = new ArrayList(5);
    e = localArrayList;
    localArrayList.add(bdv.F);
    e.add("com.android.calendar");
    e.add("com.android.contacts");
  }
  
  public bps(Context paramContext, com.android.emailcommon.provider.Account paramAccount, Bundle paramBundle)
  {
    super(paramContext, paramAccount);
    b = paramBundle;
  }
  
  /* Error */
  private final int a(long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 73	buo:a	()Lbut;
    //   3: astore 10
    //   5: aload_0
    //   6: getfield 77	bps:f	Landroid/content/Context;
    //   9: lload_1
    //   10: invokestatic 82	com/android/emailcommon/provider/Mailbox:a	(Landroid/content/Context;J)Lcom/android/emailcommon/provider/Mailbox;
    //   13: astore 8
    //   15: aload 8
    //   17: ifnonnull +38 -> 55
    //   20: ldc 84
    //   22: ldc 86
    //   24: iconst_1
    //   25: anewarray 88	java/lang/Object
    //   28: dup
    //   29: iconst_0
    //   30: lload_1
    //   31: invokestatic 94	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   34: aastore
    //   35: invokestatic 99	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   38: pop
    //   39: aload 10
    //   41: ldc 101
    //   43: ldc 103
    //   45: aconst_null
    //   46: lconst_0
    //   47: invokeinterface 108 6 0
    //   52: bipush -11
    //   54: ireturn
    //   55: aload 8
    //   57: getfield 112	com/android/emailcommon/provider/Mailbox:g	J
    //   60: aload_0
    //   61: getfield 115	bps:g	Lcom/android/emailcommon/provider/Account;
    //   64: getfield 120	com/android/emailcommon/provider/Account:D	J
    //   67: lcmp
    //   68: ifeq +48 -> 116
    //   71: ldc 84
    //   73: ldc 122
    //   75: iconst_2
    //   76: anewarray 88	java/lang/Object
    //   79: dup
    //   80: iconst_0
    //   81: aload_0
    //   82: getfield 115	bps:g	Lcom/android/emailcommon/provider/Account;
    //   85: invokevirtual 126	com/android/emailcommon/provider/Account:toString	()Ljava/lang/String;
    //   88: aastore
    //   89: dup
    //   90: iconst_1
    //   91: aload_0
    //   92: getfield 67	bps:b	Landroid/os/Bundle;
    //   95: aastore
    //   96: invokestatic 128	cvm:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   99: pop
    //   100: aload 10
    //   102: ldc 101
    //   104: ldc -126
    //   106: aconst_null
    //   107: lconst_0
    //   108: invokeinterface 108 6 0
    //   113: bipush -11
    //   115: ireturn
    //   116: aload 10
    //   118: ldc -124
    //   120: bipush 100
    //   122: invokeinterface 135 3 0
    //   127: ifeq +126 -> 253
    //   130: aload_0
    //   131: getfield 77	bps:f	Landroid/content/Context;
    //   134: invokevirtual 141	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   137: getstatic 146	beb:a	Landroid/net/Uri;
    //   140: getstatic 28	bps:a	[Ljava/lang/String;
    //   143: ldc -108
    //   145: iconst_2
    //   146: anewarray 24	java/lang/String
    //   149: dup
    //   150: iconst_0
    //   151: aload_0
    //   152: getfield 115	bps:g	Lcom/android/emailcommon/provider/Account;
    //   155: getfield 120	com/android/emailcommon/provider/Account:D	J
    //   158: invokestatic 151	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   161: aastore
    //   162: dup
    //   163: iconst_1
    //   164: aload 8
    //   166: getfield 152	com/android/emailcommon/provider/Mailbox:D	J
    //   169: invokestatic 151	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   172: aastore
    //   173: aconst_null
    //   174: invokevirtual 158	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   177: astore 9
    //   179: aload 9
    //   181: ifnull +115 -> 296
    //   184: aload 9
    //   186: invokeinterface 164 1 0
    //   191: ifeq +105 -> 296
    //   194: aload 9
    //   196: iconst_0
    //   197: invokeinterface 168 2 0
    //   202: istore 4
    //   204: aload 10
    //   206: ldc 101
    //   208: ldc -86
    //   210: iload 4
    //   212: invokestatic 173	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   215: lconst_0
    //   216: invokeinterface 108 6 0
    //   221: aload 10
    //   223: ldc 101
    //   225: ldc -81
    //   227: aload 8
    //   229: getfield 179	com/android/emailcommon/provider/Mailbox:t	I
    //   232: invokestatic 173	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   235: lconst_0
    //   236: invokeinterface 108 6 0
    //   241: aload 9
    //   243: ifnull +10 -> 253
    //   246: aload 9
    //   248: invokeinterface 182 1 0
    //   253: aload 8
    //   255: getfield 185	com/android/emailcommon/provider/Mailbox:h	I
    //   258: invokestatic 187	com/android/emailcommon/provider/Mailbox:d	(I)Ljava/lang/String;
    //   261: astore 9
    //   263: aload 8
    //   265: getfield 190	com/android/emailcommon/provider/Mailbox:j	Ljava/lang/String;
    //   268: invokestatic 193	bdv:c	(Ljava/lang/String;)Z
    //   271: istore 7
    //   273: aload_0
    //   274: getfield 195	bps:d	Ljava/util/Set;
    //   277: ifnull +42 -> 319
    //   280: aload_0
    //   281: getfield 195	bps:d	Ljava/util/Set;
    //   284: aload 9
    //   286: invokeinterface 200 2 0
    //   291: ifne +28 -> 319
    //   294: iconst_0
    //   295: ireturn
    //   296: iconst_0
    //   297: istore 4
    //   299: goto -95 -> 204
    //   302: astore 8
    //   304: aload 9
    //   306: ifnull +10 -> 316
    //   309: aload 9
    //   311: invokeinterface 182 1 0
    //   316: aload 8
    //   318: athrow
    //   319: aload_0
    //   320: getfield 77	bps:f	Landroid/content/Context;
    //   323: invokevirtual 204	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   326: astore 10
    //   328: aload 9
    //   330: ldc 50
    //   332: invokestatic 210	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   335: ifeq +120 -> 455
    //   338: invokestatic 214	cuh:a	()Z
    //   341: ifeq +15 -> 356
    //   344: aload_0
    //   345: getfield 65	bps:l	Ljava/util/Set;
    //   348: ldc -40
    //   350: invokeinterface 217 2 0
    //   355: pop
    //   356: aload 10
    //   358: ldc -40
    //   360: aload_0
    //   361: getfield 77	bps:f	Landroid/content/Context;
    //   364: invokevirtual 220	android/content/Context:getPackageName	()Ljava/lang/String;
    //   367: invokevirtual 226	android/content/pm/PackageManager:checkPermission	(Ljava/lang/String;Ljava/lang/String;)I
    //   370: ifne +46 -> 416
    //   373: ldc -28
    //   375: ldc -26
    //   377: invokestatic 235	bus:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   380: aload 8
    //   382: getfield 185	com/android/emailcommon/provider/Mailbox:h	I
    //   385: iconst_3
    //   386: if_icmpne +163 -> 549
    //   389: aload_0
    //   390: getfield 115	bps:g	Lcom/android/emailcommon/provider/Account;
    //   393: getfield 237	com/android/emailcommon/provider/Account:l	Ljava/lang/String;
    //   396: invokestatic 241	bnq:d	(Ljava/lang/String;)Z
    //   399: ifne +150 -> 549
    //   402: ldc 84
    //   404: ldc -13
    //   406: iconst_0
    //   407: anewarray 88	java/lang/Object
    //   410: invokestatic 99	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   413: pop
    //   414: iconst_0
    //   415: ireturn
    //   416: ldc 84
    //   418: ldc -11
    //   420: iconst_0
    //   421: anewarray 88	java/lang/Object
    //   424: invokestatic 247	cvm:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   427: pop
    //   428: ldc -28
    //   430: ldc -7
    //   432: invokestatic 235	bus:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   435: invokestatic 214	cuh:a	()Z
    //   438: ifeq +15 -> 453
    //   441: aload_0
    //   442: getfield 63	bps:k	Ljava/util/Set;
    //   445: ldc -40
    //   447: invokeinterface 217 2 0
    //   452: pop
    //   453: iconst_0
    //   454: ireturn
    //   455: aload 9
    //   457: ldc 52
    //   459: invokestatic 210	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   462: ifeq -82 -> 380
    //   465: invokestatic 214	cuh:a	()Z
    //   468: ifeq +15 -> 483
    //   471: aload_0
    //   472: getfield 65	bps:l	Ljava/util/Set;
    //   475: ldc -5
    //   477: invokeinterface 217 2 0
    //   482: pop
    //   483: aload 10
    //   485: ldc -5
    //   487: aload_0
    //   488: getfield 77	bps:f	Landroid/content/Context;
    //   491: invokevirtual 220	android/content/Context:getPackageName	()Ljava/lang/String;
    //   494: invokevirtual 226	android/content/pm/PackageManager:checkPermission	(Ljava/lang/String;Ljava/lang/String;)I
    //   497: ifne +13 -> 510
    //   500: ldc -3
    //   502: ldc -26
    //   504: invokestatic 235	bus:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   507: goto -127 -> 380
    //   510: ldc 84
    //   512: ldc -1
    //   514: iconst_0
    //   515: anewarray 88	java/lang/Object
    //   518: invokestatic 247	cvm:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   521: pop
    //   522: ldc -3
    //   524: ldc -7
    //   526: invokestatic 235	bus:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   529: invokestatic 214	cuh:a	()Z
    //   532: ifeq +15 -> 547
    //   535: aload_0
    //   536: getfield 63	bps:k	Ljava/util/Set;
    //   539: ldc -5
    //   541: invokeinterface 217 2 0
    //   546: pop
    //   547: iconst_0
    //   548: ireturn
    //   549: aload 8
    //   551: getfield 185	com/android/emailcommon/provider/Mailbox:h	I
    //   554: iconst_4
    //   555: if_icmpeq +30 -> 585
    //   558: aload 8
    //   560: getfield 179	com/android/emailcommon/provider/Mailbox:t	I
    //   563: iflt +152 -> 715
    //   566: aload 8
    //   568: getfield 185	com/android/emailcommon/provider/Mailbox:h	I
    //   571: invokestatic 258	com/android/emailcommon/provider/Mailbox:b	(I)Z
    //   574: ifeq +141 -> 715
    //   577: iconst_1
    //   578: istore 4
    //   580: iload 4
    //   582: ifeq +460 -> 1042
    //   585: new 260	android/content/ContentValues
    //   588: dup
    //   589: iconst_2
    //   590: invokespecial 261	android/content/ContentValues:<init>	(I)V
    //   593: astore 9
    //   595: iload_3
    //   596: ifeq +125 -> 721
    //   599: iconst_1
    //   600: istore 4
    //   602: aload_0
    //   603: aload 8
    //   605: aload 9
    //   607: iload 4
    //   609: invokespecial 264	bps:a	(Lcom/android/emailcommon/provider/Mailbox;Landroid/content/ContentValues;I)V
    //   612: aload 8
    //   614: getfield 185	com/android/emailcommon/provider/Mailbox:h	I
    //   617: iconst_4
    //   618: if_icmpne +109 -> 727
    //   621: aload_0
    //   622: aload 8
    //   624: getfield 152	com/android/emailcommon/provider/Mailbox:D	J
    //   627: iload_3
    //   628: invokespecial 266	bps:b	(JZ)I
    //   631: istore 5
    //   633: aload_0
    //   634: aload 8
    //   636: aload 9
    //   638: iconst_0
    //   639: invokespecial 264	bps:a	(Lcom/android/emailcommon/provider/Mailbox;Landroid/content/ContentValues;I)V
    //   642: iconst_0
    //   643: invokestatic 268	bps:b	(I)I
    //   646: istore 6
    //   648: iload 4
    //   650: iload 6
    //   652: invokestatic 273	chh:a	(II)I
    //   655: istore 4
    //   657: aload_0
    //   658: getfield 77	bps:f	Landroid/content/Context;
    //   661: invokevirtual 141	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   664: aload 8
    //   666: getfield 152	com/android/emailcommon/provider/Mailbox:D	J
    //   669: iconst_0
    //   670: iload 4
    //   672: invokestatic 278	bes:a	(Landroid/content/ContentResolver;JII)V
    //   675: invokestatic 73	buo:a	()Lbut;
    //   678: ldc_w 280
    //   681: iload 6
    //   683: invokestatic 173	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   686: getstatic 286	java/util/Locale:US	Ljava/util/Locale;
    //   689: ldc_w 288
    //   692: iconst_1
    //   693: anewarray 88	java/lang/Object
    //   696: dup
    //   697: iconst_0
    //   698: iconst_0
    //   699: invokestatic 293	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   702: aastore
    //   703: invokestatic 297	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   706: lconst_0
    //   707: invokeinterface 108 6 0
    //   712: iload 5
    //   714: ireturn
    //   715: iconst_0
    //   716: istore 4
    //   718: goto -138 -> 580
    //   721: iconst_4
    //   722: istore 4
    //   724: goto -122 -> 602
    //   727: iload 4
    //   729: iconst_0
    //   730: invokestatic 273	chh:a	(II)I
    //   733: istore 5
    //   735: aload_0
    //   736: getfield 77	bps:f	Landroid/content/Context;
    //   739: invokevirtual 141	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   742: aload 8
    //   744: getfield 152	com/android/emailcommon/provider/Mailbox:D	J
    //   747: iconst_1
    //   748: iload 5
    //   750: invokestatic 278	bes:a	(Landroid/content/ContentResolver;JII)V
    //   753: new 299	bqt
    //   756: dup
    //   757: aload_0
    //   758: getfield 77	bps:f	Landroid/content/Context;
    //   761: aload_0
    //   762: getfield 115	bps:g	Lcom/android/emailcommon/provider/Account;
    //   765: aload 8
    //   767: aload_0
    //   768: getfield 301	bps:c	Lbtd;
    //   771: invokespecial 304	bqt:<init>	(Landroid/content/Context;Lcom/android/emailcommon/provider/Account;Lcom/android/emailcommon/provider/Mailbox;Lbtd;)V
    //   774: astore 10
    //   776: ldc 84
    //   778: ldc_w 306
    //   781: iconst_1
    //   782: anewarray 88	java/lang/Object
    //   785: dup
    //   786: iconst_0
    //   787: aload_0
    //   788: getfield 115	bps:g	Lcom/android/emailcommon/provider/Account;
    //   791: getfield 120	com/android/emailcommon/provider/Account:D	J
    //   794: invokestatic 94	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   797: aastore
    //   798: invokestatic 99	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   801: pop
    //   802: aload 10
    //   804: invokevirtual 310	bqt:p_	()I
    //   807: istore 5
    //   809: aload_0
    //   810: aload 8
    //   812: aload 9
    //   814: iconst_0
    //   815: invokespecial 264	bps:a	(Lcom/android/emailcommon/provider/Mailbox;Landroid/content/ContentValues;I)V
    //   818: iload 5
    //   820: invokestatic 268	bps:b	(I)I
    //   823: istore 6
    //   825: iload 4
    //   827: iload 6
    //   829: invokestatic 273	chh:a	(II)I
    //   832: istore 4
    //   834: aload_0
    //   835: getfield 77	bps:f	Landroid/content/Context;
    //   838: invokevirtual 141	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   841: aload 8
    //   843: getfield 152	com/android/emailcommon/provider/Mailbox:D	J
    //   846: iconst_0
    //   847: iload 4
    //   849: invokestatic 278	bes:a	(Landroid/content/ContentResolver;JII)V
    //   852: invokestatic 73	buo:a	()Lbut;
    //   855: ldc_w 280
    //   858: iload 6
    //   860: invokestatic 173	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   863: getstatic 286	java/util/Locale:US	Ljava/util/Locale;
    //   866: ldc_w 288
    //   869: iconst_1
    //   870: anewarray 88	java/lang/Object
    //   873: dup
    //   874: iconst_0
    //   875: iload 5
    //   877: invokestatic 293	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   880: aastore
    //   881: invokestatic 297	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   884: lconst_0
    //   885: invokeinterface 108 6 0
    //   890: aload 8
    //   892: getfield 185	com/android/emailcommon/provider/Mailbox:h	I
    //   895: bipush 65
    //   897: if_icmpne +136 -> 1033
    //   900: aload_0
    //   901: getfield 314	bps:i	Lbra;
    //   904: invokevirtual 318	bra:b	()Z
    //   907: ifeq +126 -> 1033
    //   910: iload 7
    //   912: ifeq +97 -> 1009
    //   915: aload_0
    //   916: getfield 314	bps:i	Lbra;
    //   919: invokevirtual 320	bra:c	()V
    //   922: iload 5
    //   924: ireturn
    //   925: astore 10
    //   927: aload_0
    //   928: aload 8
    //   930: aload 9
    //   932: iconst_0
    //   933: invokespecial 264	bps:a	(Lcom/android/emailcommon/provider/Mailbox;Landroid/content/ContentValues;I)V
    //   936: iconst_0
    //   937: invokestatic 268	bps:b	(I)I
    //   940: istore 5
    //   942: iload 4
    //   944: iload 5
    //   946: invokestatic 273	chh:a	(II)I
    //   949: istore 4
    //   951: aload_0
    //   952: getfield 77	bps:f	Landroid/content/Context;
    //   955: invokevirtual 141	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   958: aload 8
    //   960: getfield 152	com/android/emailcommon/provider/Mailbox:D	J
    //   963: iconst_0
    //   964: iload 4
    //   966: invokestatic 278	bes:a	(Landroid/content/ContentResolver;JII)V
    //   969: invokestatic 73	buo:a	()Lbut;
    //   972: ldc_w 280
    //   975: iload 5
    //   977: invokestatic 173	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   980: getstatic 286	java/util/Locale:US	Ljava/util/Locale;
    //   983: ldc_w 288
    //   986: iconst_1
    //   987: anewarray 88	java/lang/Object
    //   990: dup
    //   991: iconst_0
    //   992: iconst_0
    //   993: invokestatic 293	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   996: aastore
    //   997: invokestatic 297	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1000: lconst_0
    //   1001: invokeinterface 108 6 0
    //   1006: aload 10
    //   1008: athrow
    //   1009: iload 5
    //   1011: iflt +25 -> 1036
    //   1014: iconst_1
    //   1015: istore 4
    //   1017: iload 4
    //   1019: ifeq +14 -> 1033
    //   1022: aload_0
    //   1023: getfield 77	bps:f	Landroid/content/Context;
    //   1026: aload_0
    //   1027: getfield 115	bps:g	Lcom/android/emailcommon/provider/Account;
    //   1030: invokestatic 324	bqk:a	(Landroid/content/Context;Lcom/android/emailcommon/provider/Account;)V
    //   1033: iload 5
    //   1035: ireturn
    //   1036: iconst_0
    //   1037: istore 4
    //   1039: goto -22 -> 1017
    //   1042: ldc 84
    //   1044: ldc_w 326
    //   1047: iconst_0
    //   1048: anewarray 88	java/lang/Object
    //   1051: invokestatic 99	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1054: pop
    //   1055: iconst_0
    //   1056: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1057	0	this	bps
    //   0	1057	1	paramLong	long
    //   0	1057	3	paramBoolean	boolean
    //   202	836	4	i	int
    //   631	403	5	j	int
    //   646	213	6	n	int
    //   271	640	7	bool	boolean
    //   13	251	8	localMailbox1	Mailbox
    //   302	657	8	localMailbox2	Mailbox
    //   177	754	9	localObject1	Object
    //   3	800	10	localObject2	Object
    //   925	82	10	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   184	204	302	finally
    //   204	241	302	finally
    //   612	633	925	finally
    //   727	809	925	finally
  }
  
  private final void a(Mailbox paramMailbox, ContentValues paramContentValues, int paramInt)
  {
    paramContentValues.put("uiSyncStatus", Integer.valueOf(paramInt));
    if (paramInt == 0) {
      paramContentValues.put("syncTime", Long.valueOf(System.currentTimeMillis()));
    }
    paramMailbox.a(f, paramContentValues);
  }
  
  private final int b(long paramLong, boolean paramBoolean)
  {
    cvm.b("Exchange", "syncOutbox %d", new Object[] { Long.valueOf(g.D) });
    Cursor localCursor = f.getContentResolver().query(beb.a, beb.g, "mailboxKey=? AND nextRetryTime<?", new String[] { Long.toString(paramLong), Long.toString(System.currentTimeMillis()) }, null);
    int i;
    for (;;)
    {
      try
      {
        if (!localCursor.moveToNext()) {
          break label299;
        }
        beb localbeb = new beb();
        localbeb.a(localCursor);
        if (!bhn.a(f, D))
        {
          int j = new bqf(f, g, localbeb, true, paramBoolean).p_();
          i = j;
          if (j == -101)
          {
            cvm.d("Exchange", "WARNING: EasOutboxSync falling back from smartReply", new Object[0]);
            i = new bqf(f, g, localbeb, false, paramBoolean).p_();
          }
          buo.a().a("eas_send_result", g.l, String.valueOf(i), 0L);
          if (i < 0)
          {
            j = 1;
            if (j != 0)
            {
              if (!a(i)) {
                break;
              }
              cvm.c("Exchange", "Outbox sync failed with result %d, continuing", new Object[] { Integer.valueOf(i) });
            }
          }
          else
          {
            j = 0;
          }
        }
      }
      finally
      {
        localCursor.close();
      }
    }
    cvm.d("Exchange", "Aborting outbox sync for error %d", new Object[] { Integer.valueOf(i) });
    localCursor.close();
    return i;
    label299:
    localCursor.close();
    return 0;
  }
  
  protected final int a(bns parambns)
  {
    cvm.e("Exchange", "unexpected call to EasFullSyncOperation.handleResponse", new Object[0]);
    return 0;
  }
  
  protected final String b()
  {
    cvm.e("Exchange", "unexpected call to EasFullSyncOperation.getCommand", new Object[0]);
    return null;
  }
  
  protected final HttpEntity c()
  {
    cvm.e("Exchange", "unexpected call to EasFullSyncOperation.getRequestEntity", new Object[0]);
    return null;
  }
  
  public final boolean i()
  {
    return m;
  }
  
  public final int p_()
  {
    int n = 0;
    cvm.b("Exchange", "About to perform a full sync operation", new Object[0]);
    int i;
    if (!k())
    {
      cvm.c("Exchange", "Failed to initialize %d before sending request for operation %s", new Object[] { Long.valueOf(g.D), b() });
      i = -10;
      return i;
    }
    Object localObject2 = new android.accounts.Account(g.d, bnq.c);
    boolean bool1 = bdv.c(g.e);
    Object localObject1 = Mailbox.a(b);
    m = b.getBoolean("force", false);
    boolean bool2;
    boolean bool3;
    label185:
    label201:
    int i1;
    if (m)
    {
      d = new HashSet(e);
      bool2 = Mailbox.c(b);
      bool3 = Mailbox.b(b);
      boolean bool4 = this.i.a();
      if (((bool2) || (bool3) || (localObject1 != null)) && (!bool4)) {
        break label328;
      }
      i = 1;
      if ((i == 0) && (!bool1) && (!bool3)) {
        break label333;
      }
      i = 1;
      boolean bool5 = b.getBoolean("wiped", false);
      c = new btd(f, g.d, m, bool5, bool4);
      if (bool1) {
        this.i.c();
      }
      if (!bool4) {
        break label365;
      }
      localObject2 = new bqe(this);
      i1 = ((bqe)localObject2).p_();
      if (i1 >= 0) {
        break label338;
      }
    }
    label328:
    label333:
    label338:
    for (int j = 1;; j = 0)
    {
      if (j == 0) {
        break label343;
      }
      cvm.c("Exchange", "Fatal result %d on Options", new Object[] { Integer.valueOf(i1) });
      return i1;
      d = brw.a((android.accounts.Account)localObject2, e);
      break;
      i = 0;
      break label185;
      i = 0;
      break label201;
    }
    label343:
    localObject2 = a;
    c((String)localObject2);
    g.l = ((String)localObject2);
    label365:
    if (i != 0)
    {
      j = new bpr(f, g, false).p_();
      if (j < 0) {}
      for (i = 1; i != 0; i = 0)
      {
        cvm.c("Exchange", "Fatal result %d on folderSync", new Object[] { Integer.valueOf(j) });
        return j;
      }
    }
    if ((g.j & 0x20) != 0)
    {
      cvm.b("Exchange", "Account is on security hold %d", new Object[] { Long.valueOf(g.D) });
      return -100;
    }
    if (!bool1)
    {
      j = new bpx(f, g).j();
      if (j < 0) {}
      for (i = 1; i != 0; i = 0)
      {
        cvm.c("Exchange", "Fatal result %d on MoveItems", new Object[] { Integer.valueOf(j) });
        return j;
      }
      j = new bqs(f, g).o_();
      if (j < 0) {}
      for (i = 1; (i != 0) && (j != 1); i = 0)
      {
        cvm.c("Exchange", "Fatal result %d on upsync", new Object[] { Integer.valueOf(j) });
        return j;
      }
      if (bnq.d(g.l))
      {
        j = new bpo(f, g).o_();
        if (j < 0) {}
        for (i = 1; i != 0; i = 0)
        {
          cvm.c("Exchange", "Fatal result %d on Drafts upsync", new Object[] { Integer.valueOf(j) });
          return j;
        }
      }
    }
    k.clear();
    l.clear();
    if (localObject1 != null)
    {
      i1 = localObject1.length;
      i = 0;
      while (i < i1)
      {
        int i2 = a(localObject1[i], m);
        if (i2 < 0) {}
        for (j = 1; j != 0; j = 0)
        {
          cvm.c("Exchange", "Fatal result %d on syncMailbox", new Object[] { Integer.valueOf(i2) });
          return i2;
        }
        i += 1;
      }
    }
    if ((!bool3) && (!bool2))
    {
      localObject1 = Mailbox.b(f.getContentResolver(), g.D);
      if (localObject1 == null) {}
    }
    for (;;)
    {
      try
      {
        if (((Cursor)localObject1).moveToNext())
        {
          j = a(((Cursor)localObject1).getLong(0), false);
          if (j < 0)
          {
            i = 1;
            if (i == 0) {
              continue;
            }
            cvm.c("Exchange", "Fatal result %d on syncMailbox", new Object[] { Integer.valueOf(j) });
            return j;
          }
          i = 0;
          continue;
        }
        ((Cursor)localObject1).close();
        if (cuh.a())
        {
          localObject1 = bbz.a(f);
          if ((k.isEmpty()) && (l.size() == 2)) {
            ((bbx)localObject1).d();
          }
        }
        else
        {
          localObject1 = c;
          if ((!j) && (!h.isEmpty())) {
            break label1066;
          }
          localObject1 = buo.a();
          i = n;
          if (!((but)localObject1).a("sync", 100)) {
            break;
          }
          ((but)localObject1).a("sync_eas", c.a(), "sync_duration_ms", cui.d(g.d));
          ((but)localObject1).b("sync_eas", c.i, "sync_num_bytes", cui.d(g.d));
          return 0;
        }
      }
      finally
      {
        ((Cursor)localObject1).close();
      }
      if (!k.isEmpty())
      {
        ((bbx)localObject1).a(g.D, k);
        continue;
        label1066:
        c = SystemClock.elapsedRealtime();
        String str = String.format("syncTime: %d, bytesReceived %d, isUpload: %b, uiRefresh: %b, wiped: %b, isOptionsNeeded: %b, mailboxSyncs: %s", new Object[] { Long.valueOf(((btd)localObject1).a()), Integer.valueOf(i), Boolean.valueOf(d), Boolean.valueOf(e), Boolean.valueOf(f), Boolean.valueOf(g), h });
        cvm.b("ExchangeSyncSnapshot", "%s", new Object[] { str });
        Bundle localBundle = new Bundle(2);
        localBundle.putString("snapshot_email_address", b);
        localBundle.putString("snapshot_content", str);
        a.getContentResolver().call(bdv.H, "sync_snapshot", "", localBundle);
        j = true;
      }
    }
  }
}

/* Location:
 * Qualified Name:     bps
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */