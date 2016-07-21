import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.AsyncTask;
import android.os.ParcelFileDescriptor;
import java.io.IOException;
import java.io.InputStream;

public class ang
  extends AsyncTask<Void, Void, ann>
{
  private static final String i = ang.class.getSimpleName();
  private final anl a;
  private final ani b;
  private final anm c;
  private final anh d;
  private final anf e;
  private final BitmapFactory.Options f = new BitmapFactory.Options();
  private ann g = null;
  private byte[] h = null;
  
  public ang(anl paramanl, ani paramani, anf paramanf)
  {
    a = paramanl;
    b = paramani;
    c = null;
    h = null;
    d = null;
    e = paramanf;
  }
  
  private final Bitmap a(ParcelFileDescriptor paramParcelFileDescriptor, InputStream paramInputStream)
  {
    if (paramParcelFileDescriptor != null) {
      return BitmapFactory.decodeFileDescriptor(paramParcelFileDescriptor.getFileDescriptor(), null, f);
    }
    if (h != null) {
      return BitmapFactory.decodeByteArray(h, 0, h.length, f);
    }
    return BitmapFactory.decodeStream(paramInputStream, null, f);
  }
  
  private final InputStream a(InputStream paramInputStream)
  {
    ans.a("create stream");
    if (paramInputStream == null) {
      paramInputStream = a.a();
    }
    for (;;)
    {
      ans.a();
      return paramInputStream;
      if (paramInputStream.markSupported())
      {
        paramInputStream.reset();
        continue;
      }
      try
      {
        paramInputStream.close();
        paramInputStream = a.a();
      }
      catch (IOException paramInputStream)
      {
        for (;;) {}
      }
    }
  }
  
  /* Error */
  public final ann a()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 117	ang:isCancelled	()Z
    //   4: ifeq +9 -> 13
    //   7: aconst_null
    //   8: astore 17
    //   10: aload 17
    //   12: areturn
    //   13: aconst_null
    //   14: astore 22
    //   16: aconst_null
    //   17: astore 18
    //   19: aconst_null
    //   20: astore 16
    //   22: aconst_null
    //   23: astore 20
    //   25: aconst_null
    //   26: astore 19
    //   28: aload 16
    //   30: astore 17
    //   32: aload_0
    //   33: getfield 53	ang:c	Lanm;
    //   36: ifnull +216 -> 252
    //   39: aload 16
    //   41: astore 17
    //   43: ldc 119
    //   45: invokestatic 88	ans:a	(Ljava/lang/String;)V
    //   48: aload 16
    //   50: astore 17
    //   52: aload_0
    //   53: getfield 53	ang:c	Lanm;
    //   56: invokeinterface 124 1 0
    //   61: astore 16
    //   63: invokestatic 95	ans:a	()V
    //   66: aload 16
    //   68: astore 20
    //   70: aload 19
    //   72: astore 18
    //   74: aload 20
    //   76: ifnonnull +334 -> 410
    //   79: aload 18
    //   81: astore 17
    //   83: aload 18
    //   85: astore 16
    //   87: aload_0
    //   88: getfield 47	ang:h	[B
    //   91: ifnonnull +319 -> 410
    //   94: iconst_1
    //   95: istore 9
    //   97: aload 18
    //   99: astore 17
    //   101: aload 18
    //   103: astore 16
    //   105: getstatic 130	android/os/Build$VERSION:SDK_INT	I
    //   108: bipush 16
    //   110: if_icmplt +306 -> 416
    //   113: iconst_1
    //   114: istore 10
    //   116: iload 10
    //   118: ifeq +51 -> 169
    //   121: aload 18
    //   123: astore 17
    //   125: aload 18
    //   127: astore 16
    //   129: ldc -124
    //   131: invokestatic 88	ans:a	(Ljava/lang/String;)V
    //   134: aload 18
    //   136: astore 17
    //   138: aload 18
    //   140: astore 16
    //   142: aload_0
    //   143: aload_0
    //   144: getfield 57	ang:e	Lanf;
    //   147: invokeinterface 137 1 0
    //   152: checkcast 139	ann
    //   155: putfield 45	ang:g	Lann;
    //   158: aload 18
    //   160: astore 17
    //   162: aload 18
    //   164: astore 16
    //   166: invokestatic 95	ans:a	()V
    //   169: aload 18
    //   171: astore 17
    //   173: aload 18
    //   175: astore 16
    //   177: aload_0
    //   178: invokevirtual 117	ang:isCancelled	()Z
    //   181: istore 15
    //   183: iload 15
    //   185: ifeq +237 -> 422
    //   188: aload 20
    //   190: ifnull +8 -> 198
    //   193: aload 20
    //   195: invokevirtual 140	android/os/ParcelFileDescriptor:close	()V
    //   198: aload 18
    //   200: ifnull +8 -> 208
    //   203: aload 18
    //   205: invokevirtual 107	java/io/InputStream:close	()V
    //   208: aload_0
    //   209: invokevirtual 117	ang:isCancelled	()Z
    //   212: ifne +18 -> 230
    //   215: aload_0
    //   216: getfield 57	ang:e	Lanf;
    //   219: aload_0
    //   220: getfield 49	ang:a	Lanl;
    //   223: aconst_null
    //   224: invokeinterface 143 3 0
    //   229: pop
    //   230: aload_0
    //   231: getfield 45	ang:g	Lann;
    //   234: ifnull +16 -> 250
    //   237: aload_0
    //   238: getfield 57	ang:e	Lanf;
    //   241: aload_0
    //   242: getfield 45	ang:g	Lann;
    //   245: invokeinterface 146 2 0
    //   250: aconst_null
    //   251: areturn
    //   252: aload 16
    //   254: astore 17
    //   256: aload 20
    //   258: astore 18
    //   260: aload_0
    //   261: getfield 47	ang:h	[B
    //   264: ifnonnull +3732 -> 3996
    //   267: aload 16
    //   269: astore 17
    //   271: aload_0
    //   272: aconst_null
    //   273: invokespecial 148	ang:a	(Ljava/io/InputStream;)Ljava/io/InputStream;
    //   276: astore 16
    //   278: aload 16
    //   280: ifnonnull +57 -> 337
    //   283: aload 16
    //   285: ifnull +8 -> 293
    //   288: aload 16
    //   290: invokevirtual 107	java/io/InputStream:close	()V
    //   293: aload_0
    //   294: invokevirtual 117	ang:isCancelled	()Z
    //   297: ifne +18 -> 315
    //   300: aload_0
    //   301: getfield 57	ang:e	Lanf;
    //   304: aload_0
    //   305: getfield 49	ang:a	Lanl;
    //   308: aconst_null
    //   309: invokeinterface 143 3 0
    //   314: pop
    //   315: aload_0
    //   316: getfield 45	ang:g	Lann;
    //   319: ifnull +16 -> 335
    //   322: aload_0
    //   323: getfield 57	ang:e	Lanf;
    //   326: aload_0
    //   327: getfield 45	ang:g	Lann;
    //   330: invokeinterface 146 2 0
    //   335: aconst_null
    //   336: areturn
    //   337: aload 16
    //   339: astore 17
    //   341: aload_0
    //   342: invokevirtual 117	ang:isCancelled	()Z
    //   345: istore 15
    //   347: aload 16
    //   349: astore 18
    //   351: iload 15
    //   353: ifeq +3643 -> 3996
    //   356: aload 16
    //   358: ifnull +8 -> 366
    //   361: aload 16
    //   363: invokevirtual 107	java/io/InputStream:close	()V
    //   366: aload_0
    //   367: invokevirtual 117	ang:isCancelled	()Z
    //   370: ifne +18 -> 388
    //   373: aload_0
    //   374: getfield 57	ang:e	Lanf;
    //   377: aload_0
    //   378: getfield 49	ang:a	Lanl;
    //   381: aconst_null
    //   382: invokeinterface 143 3 0
    //   387: pop
    //   388: aload_0
    //   389: getfield 45	ang:g	Lann;
    //   392: ifnull +16 -> 408
    //   395: aload_0
    //   396: getfield 57	ang:e	Lanf;
    //   399: aload_0
    //   400: getfield 45	ang:g	Lann;
    //   403: invokeinterface 146 2 0
    //   408: aconst_null
    //   409: areturn
    //   410: iconst_0
    //   411: istore 9
    //   413: goto -316 -> 97
    //   416: iconst_0
    //   417: istore 10
    //   419: goto -303 -> 116
    //   422: aload 18
    //   424: astore 17
    //   426: aload 18
    //   428: astore 16
    //   430: ldc -106
    //   432: invokestatic 88	ans:a	(Ljava/lang/String;)V
    //   435: aload 20
    //   437: ifnull +17 -> 454
    //   440: aload 18
    //   442: astore 17
    //   444: aload 18
    //   446: astore 16
    //   448: aload 20
    //   450: invokevirtual 154	android/os/ParcelFileDescriptor:getStatSize	()J
    //   453: pop2
    //   454: aload 18
    //   456: astore 17
    //   458: aload 18
    //   460: astore 16
    //   462: invokestatic 95	ans:a	()V
    //   465: aload 18
    //   467: astore 17
    //   469: aload 18
    //   471: astore 16
    //   473: ldc -100
    //   475: invokestatic 88	ans:a	(Ljava/lang/String;)V
    //   478: aload 18
    //   480: astore 17
    //   482: aload 18
    //   484: astore 16
    //   486: invokestatic 95	ans:a	()V
    //   489: aload 18
    //   491: astore 17
    //   493: aload 18
    //   495: astore 16
    //   497: aload_0
    //   498: invokevirtual 117	ang:isCancelled	()Z
    //   501: istore 15
    //   503: iload 15
    //   505: ifeq +67 -> 572
    //   508: aload 20
    //   510: ifnull +8 -> 518
    //   513: aload 20
    //   515: invokevirtual 140	android/os/ParcelFileDescriptor:close	()V
    //   518: aload 18
    //   520: ifnull +8 -> 528
    //   523: aload 18
    //   525: invokevirtual 107	java/io/InputStream:close	()V
    //   528: aload_0
    //   529: invokevirtual 117	ang:isCancelled	()Z
    //   532: ifne +18 -> 550
    //   535: aload_0
    //   536: getfield 57	ang:e	Lanf;
    //   539: aload_0
    //   540: getfield 49	ang:a	Lanl;
    //   543: aconst_null
    //   544: invokeinterface 143 3 0
    //   549: pop
    //   550: aload_0
    //   551: getfield 45	ang:g	Lann;
    //   554: ifnull +16 -> 570
    //   557: aload_0
    //   558: getfield 57	ang:e	Lanf;
    //   561: aload_0
    //   562: getfield 45	ang:g	Lann;
    //   565: invokeinterface 146 2 0
    //   570: aconst_null
    //   571: areturn
    //   572: aload 18
    //   574: astore 19
    //   576: iload 9
    //   578: ifeq +175 -> 753
    //   581: aload 18
    //   583: astore 17
    //   585: aload 18
    //   587: astore 16
    //   589: aload_0
    //   590: aload 18
    //   592: invokespecial 148	ang:a	(Ljava/io/InputStream;)Ljava/io/InputStream;
    //   595: astore 18
    //   597: aload 18
    //   599: ifnonnull +67 -> 666
    //   602: aload 20
    //   604: ifnull +8 -> 612
    //   607: aload 20
    //   609: invokevirtual 140	android/os/ParcelFileDescriptor:close	()V
    //   612: aload 18
    //   614: ifnull +8 -> 622
    //   617: aload 18
    //   619: invokevirtual 107	java/io/InputStream:close	()V
    //   622: aload_0
    //   623: invokevirtual 117	ang:isCancelled	()Z
    //   626: ifne +18 -> 644
    //   629: aload_0
    //   630: getfield 57	ang:e	Lanf;
    //   633: aload_0
    //   634: getfield 49	ang:a	Lanl;
    //   637: aconst_null
    //   638: invokeinterface 143 3 0
    //   643: pop
    //   644: aload_0
    //   645: getfield 45	ang:g	Lann;
    //   648: ifnull +16 -> 664
    //   651: aload_0
    //   652: getfield 57	ang:e	Lanf;
    //   655: aload_0
    //   656: getfield 45	ang:g	Lann;
    //   659: invokeinterface 146 2 0
    //   664: aconst_null
    //   665: areturn
    //   666: aload 18
    //   668: astore 17
    //   670: aload 18
    //   672: astore 16
    //   674: aload_0
    //   675: invokevirtual 117	ang:isCancelled	()Z
    //   678: istore 15
    //   680: aload 18
    //   682: astore 19
    //   684: iload 15
    //   686: ifeq +67 -> 753
    //   689: aload 20
    //   691: ifnull +8 -> 699
    //   694: aload 20
    //   696: invokevirtual 140	android/os/ParcelFileDescriptor:close	()V
    //   699: aload 18
    //   701: ifnull +8 -> 709
    //   704: aload 18
    //   706: invokevirtual 107	java/io/InputStream:close	()V
    //   709: aload_0
    //   710: invokevirtual 117	ang:isCancelled	()Z
    //   713: ifne +18 -> 731
    //   716: aload_0
    //   717: getfield 57	ang:e	Lanf;
    //   720: aload_0
    //   721: getfield 49	ang:a	Lanl;
    //   724: aconst_null
    //   725: invokeinterface 143 3 0
    //   730: pop
    //   731: aload_0
    //   732: getfield 45	ang:g	Lann;
    //   735: ifnull +16 -> 751
    //   738: aload_0
    //   739: getfield 57	ang:e	Lanf;
    //   742: aload_0
    //   743: getfield 45	ang:g	Lann;
    //   746: invokeinterface 146 2 0
    //   751: aconst_null
    //   752: areturn
    //   753: aload 19
    //   755: astore 17
    //   757: aload 19
    //   759: astore 16
    //   761: ldc -98
    //   763: invokestatic 88	ans:a	(Ljava/lang/String;)V
    //   766: aload 19
    //   768: astore 17
    //   770: aload 19
    //   772: astore 16
    //   774: aload_0
    //   775: getfield 43	ang:f	Landroid/graphics/BitmapFactory$Options;
    //   778: iconst_1
    //   779: putfield 162	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   782: aload 20
    //   784: ifnull +119 -> 903
    //   787: aload 19
    //   789: astore 17
    //   791: aload 19
    //   793: astore 16
    //   795: aload 20
    //   797: invokevirtual 64	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   800: aconst_null
    //   801: aload_0
    //   802: getfield 43	ang:f	Landroid/graphics/BitmapFactory$Options;
    //   805: invokestatic 70	android/graphics/BitmapFactory:decodeFileDescriptor	(Ljava/io/FileDescriptor;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   808: pop
    //   809: aload 19
    //   811: astore 17
    //   813: aload 19
    //   815: astore 16
    //   817: invokestatic 95	ans:a	()V
    //   820: aload 19
    //   822: astore 17
    //   824: aload 19
    //   826: astore 16
    //   828: aload_0
    //   829: invokevirtual 117	ang:isCancelled	()Z
    //   832: istore 15
    //   834: iload 15
    //   836: ifeq +293 -> 1129
    //   839: aload 20
    //   841: ifnull +8 -> 849
    //   844: aload 20
    //   846: invokevirtual 140	android/os/ParcelFileDescriptor:close	()V
    //   849: aload 19
    //   851: ifnull +8 -> 859
    //   854: aload 19
    //   856: invokevirtual 107	java/io/InputStream:close	()V
    //   859: aload_0
    //   860: invokevirtual 117	ang:isCancelled	()Z
    //   863: ifne +18 -> 881
    //   866: aload_0
    //   867: getfield 57	ang:e	Lanf;
    //   870: aload_0
    //   871: getfield 49	ang:a	Lanl;
    //   874: aconst_null
    //   875: invokeinterface 143 3 0
    //   880: pop
    //   881: aload_0
    //   882: getfield 45	ang:g	Lann;
    //   885: ifnull +16 -> 901
    //   888: aload_0
    //   889: getfield 57	ang:e	Lanf;
    //   892: aload_0
    //   893: getfield 45	ang:g	Lann;
    //   896: invokeinterface 146 2 0
    //   901: aconst_null
    //   902: areturn
    //   903: aload 19
    //   905: astore 17
    //   907: aload 19
    //   909: astore 16
    //   911: aload_0
    //   912: getfield 47	ang:h	[B
    //   915: ifnull +122 -> 1037
    //   918: aload 19
    //   920: astore 17
    //   922: aload 19
    //   924: astore 16
    //   926: aload_0
    //   927: getfield 47	ang:h	[B
    //   930: iconst_0
    //   931: aload_0
    //   932: getfield 47	ang:h	[B
    //   935: arraylength
    //   936: aload_0
    //   937: getfield 43	ang:f	Landroid/graphics/BitmapFactory$Options;
    //   940: invokestatic 74	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   943: pop
    //   944: goto -135 -> 809
    //   947: astore 16
    //   949: aconst_null
    //   950: astore 19
    //   952: aload 17
    //   954: astore 18
    //   956: aload 16
    //   958: astore 17
    //   960: aload 19
    //   962: astore 16
    //   964: aload 16
    //   966: astore 22
    //   968: aload 18
    //   970: astore 21
    //   972: aload 20
    //   974: astore 19
    //   976: aload 17
    //   978: invokevirtual 165	java/lang/Exception:printStackTrace	()V
    //   981: aload 20
    //   983: ifnull +8 -> 991
    //   986: aload 20
    //   988: invokevirtual 140	android/os/ParcelFileDescriptor:close	()V
    //   991: aload 18
    //   993: ifnull +8 -> 1001
    //   996: aload 18
    //   998: invokevirtual 107	java/io/InputStream:close	()V
    //   1001: aload_0
    //   1002: invokevirtual 117	ang:isCancelled	()Z
    //   1005: ifne +19 -> 1024
    //   1008: aload_0
    //   1009: getfield 57	ang:e	Lanf;
    //   1012: aload_0
    //   1013: getfield 49	ang:a	Lanl;
    //   1016: aload 16
    //   1018: invokeinterface 143 3 0
    //   1023: pop
    //   1024: aload 16
    //   1026: ifnull +2573 -> 3599
    //   1029: aload 16
    //   1031: invokevirtual 166	ann:a	()V
    //   1034: aload 16
    //   1036: areturn
    //   1037: aload 19
    //   1039: astore 17
    //   1041: aload 19
    //   1043: astore 16
    //   1045: aload 19
    //   1047: aconst_null
    //   1048: aload_0
    //   1049: getfield 43	ang:f	Landroid/graphics/BitmapFactory$Options;
    //   1052: invokestatic 78	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1055: pop
    //   1056: goto -247 -> 809
    //   1059: astore 19
    //   1061: aload 22
    //   1063: astore 18
    //   1065: aload 16
    //   1067: astore 17
    //   1069: aload 19
    //   1071: astore 16
    //   1073: aload 20
    //   1075: ifnull +8 -> 1083
    //   1078: aload 20
    //   1080: invokevirtual 140	android/os/ParcelFileDescriptor:close	()V
    //   1083: aload 17
    //   1085: ifnull +8 -> 1093
    //   1088: aload 17
    //   1090: invokevirtual 107	java/io/InputStream:close	()V
    //   1093: aload_0
    //   1094: invokevirtual 117	ang:isCancelled	()Z
    //   1097: ifne +19 -> 1116
    //   1100: aload_0
    //   1101: getfield 57	ang:e	Lanf;
    //   1104: aload_0
    //   1105: getfield 49	ang:a	Lanl;
    //   1108: aload 18
    //   1110: invokeinterface 143 3 0
    //   1115: pop
    //   1116: aload 18
    //   1118: ifnull +2508 -> 3626
    //   1121: aload 18
    //   1123: invokevirtual 166	ann:a	()V
    //   1126: aload 16
    //   1128: athrow
    //   1129: aload 19
    //   1131: astore 17
    //   1133: aload 19
    //   1135: astore 16
    //   1137: aload_0
    //   1138: getfield 43	ang:f	Landroid/graphics/BitmapFactory$Options;
    //   1141: getfield 169	android/graphics/BitmapFactory$Options:outWidth	I
    //   1144: istore 11
    //   1146: aload 19
    //   1148: astore 17
    //   1150: aload 19
    //   1152: astore 16
    //   1154: aload_0
    //   1155: getfield 43	ang:f	Landroid/graphics/BitmapFactory$Options;
    //   1158: getfield 172	android/graphics/BitmapFactory$Options:outHeight	I
    //   1161: istore 12
    //   1163: aload 19
    //   1165: astore 17
    //   1167: aload 19
    //   1169: astore 16
    //   1171: iload 11
    //   1173: i2f
    //   1174: aload_0
    //   1175: getfield 51	ang:b	Lani;
    //   1178: getfield 176	ani:a	I
    //   1181: i2f
    //   1182: fdiv
    //   1183: iload 12
    //   1185: i2f
    //   1186: aload_0
    //   1187: getfield 51	ang:b	Lani;
    //   1190: getfield 178	ani:b	I
    //   1193: i2f
    //   1194: fdiv
    //   1195: invokestatic 184	java/lang/Math:min	(FF)F
    //   1198: fstore_3
    //   1199: aload 19
    //   1201: astore 17
    //   1203: aload 19
    //   1205: astore 16
    //   1207: aload_0
    //   1208: getfield 51	ang:b	Lani;
    //   1211: getfield 186	ani:e	I
    //   1214: tableswitch	default:+2788->4002, 1:+276->1490, 2:+283->1497
    //   1236: aload 19
    //   1238: astore 17
    //   1240: aload 19
    //   1242: astore 16
    //   1244: ldc2_w 187
    //   1247: ldc2_w 189
    //   1250: fload_3
    //   1251: f2d
    //   1252: invokestatic 194	java/lang/Math:log	(D)D
    //   1255: ldc2_w 187
    //   1258: invokestatic 194	java/lang/Math:log	(D)D
    //   1261: ddiv
    //   1262: dadd
    //   1263: d2i
    //   1264: i2d
    //   1265: invokestatic 198	java/lang/Math:pow	(DD)D
    //   1268: d2i
    //   1269: istore 8
    //   1271: aload 19
    //   1273: astore 17
    //   1275: aload 19
    //   1277: astore 16
    //   1279: aload_0
    //   1280: getfield 43	ang:f	Landroid/graphics/BitmapFactory$Options;
    //   1283: iconst_1
    //   1284: iload 8
    //   1286: invokestatic 202	java/lang/Math:max	(II)I
    //   1289: putfield 205	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1292: aload 19
    //   1294: astore 17
    //   1296: aload 19
    //   1298: astore 16
    //   1300: aload_0
    //   1301: getfield 43	ang:f	Landroid/graphics/BitmapFactory$Options;
    //   1304: iconst_0
    //   1305: putfield 162	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   1308: aload 19
    //   1310: astore 17
    //   1312: aload 19
    //   1314: astore 16
    //   1316: aload_0
    //   1317: getfield 43	ang:f	Landroid/graphics/BitmapFactory$Options;
    //   1320: iconst_1
    //   1321: putfield 208	android/graphics/BitmapFactory$Options:inMutable	Z
    //   1324: iload 10
    //   1326: ifeq +382 -> 1708
    //   1329: aload 19
    //   1331: astore 17
    //   1333: aload 19
    //   1335: astore 16
    //   1337: aload_0
    //   1338: getfield 45	ang:g	Lann;
    //   1341: ifnonnull +345 -> 1686
    //   1344: aload 19
    //   1346: astore 17
    //   1348: aload 19
    //   1350: astore 16
    //   1352: ldc -46
    //   1354: invokestatic 88	ans:a	(Ljava/lang/String;)V
    //   1357: aload 19
    //   1359: astore 17
    //   1361: aload 19
    //   1363: astore 16
    //   1365: aload_0
    //   1366: new 139	ann
    //   1369: dup
    //   1370: aload_0
    //   1371: getfield 51	ang:b	Lani;
    //   1374: getfield 176	ani:a	I
    //   1377: aload_0
    //   1378: getfield 51	ang:b	Lani;
    //   1381: getfield 178	ani:b	I
    //   1384: getstatic 216	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   1387: invokestatic 222	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   1390: invokespecial 225	ann:<init>	(Landroid/graphics/Bitmap;)V
    //   1393: putfield 45	ang:g	Lann;
    //   1396: aload 19
    //   1398: astore 17
    //   1400: aload 19
    //   1402: astore 16
    //   1404: invokestatic 95	ans:a	()V
    //   1407: aload 19
    //   1409: astore 17
    //   1411: aload 19
    //   1413: astore 16
    //   1415: aload_0
    //   1416: invokevirtual 117	ang:isCancelled	()Z
    //   1419: istore 15
    //   1421: iload 15
    //   1423: ifeq +263 -> 1686
    //   1426: aload 20
    //   1428: ifnull +8 -> 1436
    //   1431: aload 20
    //   1433: invokevirtual 140	android/os/ParcelFileDescriptor:close	()V
    //   1436: aload 19
    //   1438: ifnull +8 -> 1446
    //   1441: aload 19
    //   1443: invokevirtual 107	java/io/InputStream:close	()V
    //   1446: aload_0
    //   1447: invokevirtual 117	ang:isCancelled	()Z
    //   1450: ifne +18 -> 1468
    //   1453: aload_0
    //   1454: getfield 57	ang:e	Lanf;
    //   1457: aload_0
    //   1458: getfield 49	ang:a	Lanl;
    //   1461: aconst_null
    //   1462: invokeinterface 143 3 0
    //   1467: pop
    //   1468: aload_0
    //   1469: getfield 45	ang:g	Lann;
    //   1472: ifnull +16 -> 1488
    //   1475: aload_0
    //   1476: getfield 57	ang:e	Lanf;
    //   1479: aload_0
    //   1480: getfield 45	ang:g	Lann;
    //   1483: invokeinterface 146 2 0
    //   1488: aconst_null
    //   1489: areturn
    //   1490: fload_3
    //   1491: f2i
    //   1492: istore 8
    //   1494: goto -223 -> 1271
    //   1497: fload_3
    //   1498: f2d
    //   1499: dstore_1
    //   1500: aload 19
    //   1502: astore 17
    //   1504: aload 19
    //   1506: astore 16
    //   1508: dload_1
    //   1509: invokestatic 228	java/lang/Math:ceil	(D)D
    //   1512: d2i
    //   1513: istore 8
    //   1515: goto -244 -> 1271
    //   1518: astore 18
    //   1520: aload 19
    //   1522: astore 17
    //   1524: aload 19
    //   1526: astore 16
    //   1528: getstatic 33	ang:i	Ljava/lang/String;
    //   1531: astore 21
    //   1533: aload 19
    //   1535: astore 17
    //   1537: aload 19
    //   1539: astore 16
    //   1541: aload 18
    //   1543: invokevirtual 231	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   1546: invokestatic 237	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1549: astore 18
    //   1551: aload 19
    //   1553: astore 17
    //   1555: aload 19
    //   1557: astore 16
    //   1559: aload 18
    //   1561: invokevirtual 241	java/lang/String:length	()I
    //   1564: ifeq +100 -> 1664
    //   1567: aload 19
    //   1569: astore 17
    //   1571: aload 19
    //   1573: astore 16
    //   1575: ldc -13
    //   1577: aload 18
    //   1579: invokevirtual 247	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1582: astore 18
    //   1584: aload 19
    //   1586: astore 17
    //   1588: aload 19
    //   1590: astore 16
    //   1592: aload 21
    //   1594: aload 18
    //   1596: invokestatic 252	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   1599: pop
    //   1600: aload 20
    //   1602: ifnull +8 -> 1610
    //   1605: aload 20
    //   1607: invokevirtual 140	android/os/ParcelFileDescriptor:close	()V
    //   1610: aload 19
    //   1612: ifnull +8 -> 1620
    //   1615: aload 19
    //   1617: invokevirtual 107	java/io/InputStream:close	()V
    //   1620: aload_0
    //   1621: invokevirtual 117	ang:isCancelled	()Z
    //   1624: ifne +18 -> 1642
    //   1627: aload_0
    //   1628: getfield 57	ang:e	Lanf;
    //   1631: aload_0
    //   1632: getfield 49	ang:a	Lanl;
    //   1635: aconst_null
    //   1636: invokeinterface 143 3 0
    //   1641: pop
    //   1642: aload_0
    //   1643: getfield 45	ang:g	Lann;
    //   1646: ifnull +16 -> 1662
    //   1649: aload_0
    //   1650: getfield 57	ang:e	Lanf;
    //   1653: aload_0
    //   1654: getfield 45	ang:g	Lann;
    //   1657: invokeinterface 146 2 0
    //   1662: aconst_null
    //   1663: areturn
    //   1664: aload 19
    //   1666: astore 17
    //   1668: aload 19
    //   1670: astore 16
    //   1672: new 233	java/lang/String
    //   1675: dup
    //   1676: ldc -13
    //   1678: invokespecial 254	java/lang/String:<init>	(Ljava/lang/String;)V
    //   1681: astore 18
    //   1683: goto -99 -> 1584
    //   1686: aload 19
    //   1688: astore 17
    //   1690: aload 19
    //   1692: astore 16
    //   1694: aload_0
    //   1695: getfield 43	ang:f	Landroid/graphics/BitmapFactory$Options;
    //   1698: aload_0
    //   1699: getfield 45	ang:g	Lann;
    //   1702: getfield 257	ann:a	Landroid/graphics/Bitmap;
    //   1705: putfield 260	android/graphics/BitmapFactory$Options:inBitmap	Landroid/graphics/Bitmap;
    //   1708: aload 19
    //   1710: astore 17
    //   1712: aload 19
    //   1714: astore 16
    //   1716: aload_0
    //   1717: invokevirtual 117	ang:isCancelled	()Z
    //   1720: istore 15
    //   1722: iload 15
    //   1724: ifeq +67 -> 1791
    //   1727: aload 20
    //   1729: ifnull +8 -> 1737
    //   1732: aload 20
    //   1734: invokevirtual 140	android/os/ParcelFileDescriptor:close	()V
    //   1737: aload 19
    //   1739: ifnull +8 -> 1747
    //   1742: aload 19
    //   1744: invokevirtual 107	java/io/InputStream:close	()V
    //   1747: aload_0
    //   1748: invokevirtual 117	ang:isCancelled	()Z
    //   1751: ifne +18 -> 1769
    //   1754: aload_0
    //   1755: getfield 57	ang:e	Lanf;
    //   1758: aload_0
    //   1759: getfield 49	ang:a	Lanl;
    //   1762: aconst_null
    //   1763: invokeinterface 143 3 0
    //   1768: pop
    //   1769: aload_0
    //   1770: getfield 45	ang:g	Lann;
    //   1773: ifnull +16 -> 1789
    //   1776: aload_0
    //   1777: getfield 57	ang:e	Lanf;
    //   1780: aload_0
    //   1781: getfield 45	ang:g	Lann;
    //   1784: invokeinterface 146 2 0
    //   1789: aconst_null
    //   1790: areturn
    //   1791: aload 19
    //   1793: astore 18
    //   1795: iload 9
    //   1797: ifeq +175 -> 1972
    //   1800: aload 19
    //   1802: astore 17
    //   1804: aload 19
    //   1806: astore 16
    //   1808: aload_0
    //   1809: aload 19
    //   1811: invokespecial 148	ang:a	(Ljava/io/InputStream;)Ljava/io/InputStream;
    //   1814: astore 19
    //   1816: aload 19
    //   1818: ifnonnull +67 -> 1885
    //   1821: aload 20
    //   1823: ifnull +8 -> 1831
    //   1826: aload 20
    //   1828: invokevirtual 140	android/os/ParcelFileDescriptor:close	()V
    //   1831: aload 19
    //   1833: ifnull +8 -> 1841
    //   1836: aload 19
    //   1838: invokevirtual 107	java/io/InputStream:close	()V
    //   1841: aload_0
    //   1842: invokevirtual 117	ang:isCancelled	()Z
    //   1845: ifne +18 -> 1863
    //   1848: aload_0
    //   1849: getfield 57	ang:e	Lanf;
    //   1852: aload_0
    //   1853: getfield 49	ang:a	Lanl;
    //   1856: aconst_null
    //   1857: invokeinterface 143 3 0
    //   1862: pop
    //   1863: aload_0
    //   1864: getfield 45	ang:g	Lann;
    //   1867: ifnull +16 -> 1883
    //   1870: aload_0
    //   1871: getfield 57	ang:e	Lanf;
    //   1874: aload_0
    //   1875: getfield 45	ang:g	Lann;
    //   1878: invokeinterface 146 2 0
    //   1883: aconst_null
    //   1884: areturn
    //   1885: aload 19
    //   1887: astore 17
    //   1889: aload 19
    //   1891: astore 16
    //   1893: aload_0
    //   1894: invokevirtual 117	ang:isCancelled	()Z
    //   1897: istore 15
    //   1899: aload 19
    //   1901: astore 18
    //   1903: iload 15
    //   1905: ifeq +67 -> 1972
    //   1908: aload 20
    //   1910: ifnull +8 -> 1918
    //   1913: aload 20
    //   1915: invokevirtual 140	android/os/ParcelFileDescriptor:close	()V
    //   1918: aload 19
    //   1920: ifnull +8 -> 1928
    //   1923: aload 19
    //   1925: invokevirtual 107	java/io/InputStream:close	()V
    //   1928: aload_0
    //   1929: invokevirtual 117	ang:isCancelled	()Z
    //   1932: ifne +18 -> 1950
    //   1935: aload_0
    //   1936: getfield 57	ang:e	Lanf;
    //   1939: aload_0
    //   1940: getfield 49	ang:a	Lanl;
    //   1943: aconst_null
    //   1944: invokeinterface 143 3 0
    //   1949: pop
    //   1950: aload_0
    //   1951: getfield 45	ang:g	Lann;
    //   1954: ifnull +16 -> 1970
    //   1957: aload_0
    //   1958: getfield 57	ang:e	Lanf;
    //   1961: aload_0
    //   1962: getfield 45	ang:g	Lann;
    //   1965: invokeinterface 146 2 0
    //   1970: aconst_null
    //   1971: areturn
    //   1972: aload 18
    //   1974: astore 17
    //   1976: aload 18
    //   1978: astore 16
    //   1980: new 262	android/graphics/Rect
    //   1983: dup
    //   1984: invokespecial 263	android/graphics/Rect:<init>	()V
    //   1987: astore 23
    //   1989: aload 18
    //   1991: astore 21
    //   1993: aload_0
    //   1994: getfield 43	ang:f	Landroid/graphics/BitmapFactory$Options;
    //   1997: getfield 205	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   2000: istore 8
    //   2002: aload 18
    //   2004: astore 21
    //   2006: new 265	java/lang/StringBuilder
    //   2009: dup
    //   2010: bipush 24
    //   2012: invokespecial 268	java/lang/StringBuilder:<init>	(I)V
    //   2015: ldc_w 270
    //   2018: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2021: iload 8
    //   2023: invokevirtual 277	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2026: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2029: invokestatic 88	ans:a	(Ljava/lang/String;)V
    //   2032: aload 20
    //   2034: ifnull +131 -> 2165
    //   2037: aload 18
    //   2039: astore 21
    //   2041: aload 20
    //   2043: invokevirtual 64	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   2046: iconst_1
    //   2047: invokestatic 286	android/graphics/BitmapRegionDecoder:newInstance	(Ljava/io/FileDescriptor;Z)Landroid/graphics/BitmapRegionDecoder;
    //   2050: astore 16
    //   2052: aload 18
    //   2054: astore 21
    //   2056: aload_0
    //   2057: invokevirtual 117	ang:isCancelled	()Z
    //   2060: ifeq +154 -> 2214
    //   2063: aconst_null
    //   2064: astore 19
    //   2066: aload 18
    //   2068: astore 21
    //   2070: aload 16
    //   2072: invokevirtual 289	android/graphics/BitmapRegionDecoder:recycle	()V
    //   2075: aload 18
    //   2077: astore 17
    //   2079: aload 18
    //   2081: astore 16
    //   2083: invokestatic 95	ans:a	()V
    //   2086: aload 19
    //   2088: astore 16
    //   2090: aload_0
    //   2091: invokevirtual 117	ang:isCancelled	()Z
    //   2094: istore 15
    //   2096: iload 15
    //   2098: ifeq +885 -> 2983
    //   2101: aload 20
    //   2103: ifnull +8 -> 2111
    //   2106: aload 20
    //   2108: invokevirtual 140	android/os/ParcelFileDescriptor:close	()V
    //   2111: aload 18
    //   2113: ifnull +8 -> 2121
    //   2116: aload 18
    //   2118: invokevirtual 107	java/io/InputStream:close	()V
    //   2121: aload_0
    //   2122: invokevirtual 117	ang:isCancelled	()Z
    //   2125: ifne +18 -> 2143
    //   2128: aload_0
    //   2129: getfield 57	ang:e	Lanf;
    //   2132: aload_0
    //   2133: getfield 49	ang:a	Lanl;
    //   2136: aconst_null
    //   2137: invokeinterface 143 3 0
    //   2142: pop
    //   2143: aload_0
    //   2144: getfield 45	ang:g	Lann;
    //   2147: ifnull +16 -> 2163
    //   2150: aload_0
    //   2151: getfield 57	ang:e	Lanf;
    //   2154: aload_0
    //   2155: getfield 45	ang:g	Lann;
    //   2158: invokeinterface 146 2 0
    //   2163: aconst_null
    //   2164: areturn
    //   2165: aload 18
    //   2167: astore 21
    //   2169: aload_0
    //   2170: getfield 47	ang:h	[B
    //   2173: ifnull +26 -> 2199
    //   2176: aload 18
    //   2178: astore 21
    //   2180: aload_0
    //   2181: getfield 47	ang:h	[B
    //   2184: iconst_0
    //   2185: aload_0
    //   2186: getfield 47	ang:h	[B
    //   2189: arraylength
    //   2190: iconst_1
    //   2191: invokestatic 292	android/graphics/BitmapRegionDecoder:newInstance	([BIIZ)Landroid/graphics/BitmapRegionDecoder;
    //   2194: astore 16
    //   2196: goto -144 -> 2052
    //   2199: aload 18
    //   2201: astore 21
    //   2203: aload 18
    //   2205: iconst_1
    //   2206: invokestatic 295	android/graphics/BitmapRegionDecoder:newInstance	(Ljava/io/InputStream;Z)Landroid/graphics/BitmapRegionDecoder;
    //   2209: astore 16
    //   2211: goto -159 -> 2052
    //   2214: aload 18
    //   2216: astore 21
    //   2218: aload_0
    //   2219: getfield 51	ang:b	Lani;
    //   2222: getfield 176	ani:a	I
    //   2225: istore 14
    //   2227: aload 18
    //   2229: astore 21
    //   2231: aload_0
    //   2232: getfield 51	ang:b	Lani;
    //   2235: getfield 178	ani:b	I
    //   2238: istore 13
    //   2240: aload 18
    //   2242: astore 21
    //   2244: aload_0
    //   2245: getfield 51	ang:b	Lani;
    //   2248: getfield 178	ani:b	I
    //   2251: istore 10
    //   2253: aload 18
    //   2255: astore 21
    //   2257: aload_0
    //   2258: getfield 43	ang:f	Landroid/graphics/BitmapFactory$Options;
    //   2261: getfield 205	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   2264: istore 8
    //   2266: aload 18
    //   2268: astore 21
    //   2270: aload_0
    //   2271: getfield 51	ang:b	Lani;
    //   2274: getfield 298	ani:c	F
    //   2277: fstore 5
    //   2279: aload 18
    //   2281: astore 21
    //   2283: aload_0
    //   2284: getfield 51	ang:b	Lani;
    //   2287: getfield 300	ani:d	F
    //   2290: fstore 6
    //   2292: iload 8
    //   2294: ifgt +1699 -> 3993
    //   2297: iconst_1
    //   2298: istore 8
    //   2300: aload 18
    //   2302: astore 21
    //   2304: iload 11
    //   2306: i2f
    //   2307: iload 14
    //   2309: i2f
    //   2310: fdiv
    //   2311: fstore 4
    //   2313: aload 18
    //   2315: astore 21
    //   2317: iload 12
    //   2319: i2f
    //   2320: iload 13
    //   2322: i2f
    //   2323: fdiv
    //   2324: fstore 7
    //   2326: fload 4
    //   2328: fstore_3
    //   2329: fload 7
    //   2331: fload 4
    //   2333: fcmpg
    //   2334: ifge +12 -> 2346
    //   2337: aload 18
    //   2339: astore 21
    //   2341: fload 7
    //   2343: fconst_1
    //   2344: fdiv
    //   2345: fstore_3
    //   2346: aload 18
    //   2348: astore 21
    //   2350: iload 8
    //   2352: i2f
    //   2353: fload_3
    //   2354: invokestatic 184	java/lang/Math:min	(FF)F
    //   2357: fstore_3
    //   2358: aload 18
    //   2360: astore 21
    //   2362: iload 14
    //   2364: i2f
    //   2365: fload_3
    //   2366: fmul
    //   2367: invokestatic 304	java/lang/Math:round	(F)I
    //   2370: istore 8
    //   2372: aload 18
    //   2374: astore 21
    //   2376: iload 13
    //   2378: i2f
    //   2379: fload_3
    //   2380: fmul
    //   2381: invokestatic 304	java/lang/Math:round	(F)I
    //   2384: istore 13
    //   2386: aload 18
    //   2388: astore 21
    //   2390: fload_3
    //   2391: iload 10
    //   2393: i2f
    //   2394: fmul
    //   2395: invokestatic 304	java/lang/Math:round	(F)I
    //   2398: iload 12
    //   2400: invokestatic 306	java/lang/Math:min	(II)I
    //   2403: iconst_2
    //   2404: idiv
    //   2405: istore 10
    //   2407: aload 18
    //   2409: astore 21
    //   2411: aload 23
    //   2413: iload 11
    //   2415: iload 8
    //   2417: isub
    //   2418: i2f
    //   2419: fload 5
    //   2421: fmul
    //   2422: f2i
    //   2423: putfield 309	android/graphics/Rect:left	I
    //   2426: aload 18
    //   2428: astore 21
    //   2430: aload 23
    //   2432: iload 8
    //   2434: aload 23
    //   2436: getfield 309	android/graphics/Rect:left	I
    //   2439: iadd
    //   2440: putfield 312	android/graphics/Rect:right	I
    //   2443: aload 18
    //   2445: astore 21
    //   2447: aload 23
    //   2449: iload 10
    //   2451: iload 12
    //   2453: iload 10
    //   2455: isub
    //   2456: iload 12
    //   2458: i2f
    //   2459: fload 6
    //   2461: fmul
    //   2462: invokestatic 304	java/lang/Math:round	(F)I
    //   2465: invokestatic 306	java/lang/Math:min	(II)I
    //   2468: invokestatic 202	java/lang/Math:max	(II)I
    //   2471: iload 13
    //   2473: iconst_2
    //   2474: idiv
    //   2475: isub
    //   2476: putfield 315	android/graphics/Rect:top	I
    //   2479: aload 18
    //   2481: astore 21
    //   2483: aload 23
    //   2485: aload 23
    //   2487: getfield 315	android/graphics/Rect:top	I
    //   2490: iload 13
    //   2492: iadd
    //   2493: putfield 318	android/graphics/Rect:bottom	I
    //   2496: aload 18
    //   2498: astore 21
    //   2500: new 262	android/graphics/Rect
    //   2503: dup
    //   2504: iconst_0
    //   2505: iconst_0
    //   2506: iload 11
    //   2508: iload 12
    //   2510: invokespecial 321	android/graphics/Rect:<init>	(IIII)V
    //   2513: astore 17
    //   2515: aload 18
    //   2517: astore 21
    //   2519: new 323	android/graphics/Matrix
    //   2522: dup
    //   2523: invokespecial 324	android/graphics/Matrix:<init>	()V
    //   2526: astore 19
    //   2528: aload 18
    //   2530: astore 21
    //   2532: aload 19
    //   2534: fconst_0
    //   2535: invokevirtual 328	android/graphics/Matrix:setRotate	(F)V
    //   2538: aload 18
    //   2540: astore 21
    //   2542: new 330	android/graphics/RectF
    //   2545: dup
    //   2546: aload 17
    //   2548: invokespecial 333	android/graphics/RectF:<init>	(Landroid/graphics/Rect;)V
    //   2551: astore 24
    //   2553: aload 18
    //   2555: astore 21
    //   2557: new 330	android/graphics/RectF
    //   2560: dup
    //   2561: aload 23
    //   2563: invokespecial 333	android/graphics/RectF:<init>	(Landroid/graphics/Rect;)V
    //   2566: astore 25
    //   2568: aload 18
    //   2570: astore 21
    //   2572: aload 19
    //   2574: aload 24
    //   2576: invokevirtual 337	android/graphics/Matrix:mapRect	(Landroid/graphics/RectF;)Z
    //   2579: pop
    //   2580: aload 18
    //   2582: astore 21
    //   2584: aload 19
    //   2586: aload 25
    //   2588: invokevirtual 337	android/graphics/Matrix:mapRect	(Landroid/graphics/RectF;)Z
    //   2591: pop
    //   2592: aload 18
    //   2594: astore 21
    //   2596: aload 19
    //   2598: invokevirtual 338	android/graphics/Matrix:reset	()V
    //   2601: aload 18
    //   2603: astore 21
    //   2605: aload 19
    //   2607: aload 24
    //   2609: getfield 340	android/graphics/RectF:left	F
    //   2612: fneg
    //   2613: aload 24
    //   2615: getfield 342	android/graphics/RectF:top	F
    //   2618: fneg
    //   2619: invokevirtual 346	android/graphics/Matrix:setTranslate	(FF)V
    //   2622: aload 18
    //   2624: astore 21
    //   2626: aload 19
    //   2628: aload 24
    //   2630: invokevirtual 337	android/graphics/Matrix:mapRect	(Landroid/graphics/RectF;)Z
    //   2633: pop
    //   2634: aload 18
    //   2636: astore 21
    //   2638: aload 19
    //   2640: aload 25
    //   2642: invokevirtual 337	android/graphics/Matrix:mapRect	(Landroid/graphics/RectF;)Z
    //   2645: pop
    //   2646: aload 18
    //   2648: astore 21
    //   2650: aload 17
    //   2652: aload 24
    //   2654: getfield 340	android/graphics/RectF:left	F
    //   2657: f2i
    //   2658: aload 24
    //   2660: getfield 342	android/graphics/RectF:top	F
    //   2663: f2i
    //   2664: aload 24
    //   2666: getfield 348	android/graphics/RectF:right	F
    //   2669: f2i
    //   2670: aload 24
    //   2672: getfield 350	android/graphics/RectF:bottom	F
    //   2675: f2i
    //   2676: invokevirtual 353	android/graphics/Rect:set	(IIII)V
    //   2679: aload 18
    //   2681: astore 21
    //   2683: aload 23
    //   2685: aload 25
    //   2687: getfield 340	android/graphics/RectF:left	F
    //   2690: f2i
    //   2691: aload 25
    //   2693: getfield 342	android/graphics/RectF:top	F
    //   2696: f2i
    //   2697: aload 25
    //   2699: getfield 348	android/graphics/RectF:right	F
    //   2702: f2i
    //   2703: aload 25
    //   2705: getfield 350	android/graphics/RectF:bottom	F
    //   2708: f2i
    //   2709: invokevirtual 353	android/graphics/Rect:set	(IIII)V
    //   2712: aload 18
    //   2714: astore 21
    //   2716: aload 16
    //   2718: aload 23
    //   2720: aload_0
    //   2721: getfield 43	ang:f	Landroid/graphics/BitmapFactory$Options;
    //   2724: invokevirtual 357	android/graphics/BitmapRegionDecoder:decodeRegion	(Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   2727: astore 19
    //   2729: goto -663 -> 2066
    //   2732: astore 16
    //   2734: aload 18
    //   2736: astore 19
    //   2738: iload 9
    //   2740: ifeq +189 -> 2929
    //   2743: aload 18
    //   2745: astore 21
    //   2747: aload_0
    //   2748: aload 18
    //   2750: invokespecial 148	ang:a	(Ljava/io/InputStream;)Ljava/io/InputStream;
    //   2753: astore 18
    //   2755: aload 18
    //   2757: ifnonnull +78 -> 2835
    //   2760: aload 18
    //   2762: astore 17
    //   2764: aload 18
    //   2766: astore 16
    //   2768: invokestatic 95	ans:a	()V
    //   2771: aload 20
    //   2773: ifnull +8 -> 2781
    //   2776: aload 20
    //   2778: invokevirtual 140	android/os/ParcelFileDescriptor:close	()V
    //   2781: aload 18
    //   2783: ifnull +8 -> 2791
    //   2786: aload 18
    //   2788: invokevirtual 107	java/io/InputStream:close	()V
    //   2791: aload_0
    //   2792: invokevirtual 117	ang:isCancelled	()Z
    //   2795: ifne +18 -> 2813
    //   2798: aload_0
    //   2799: getfield 57	ang:e	Lanf;
    //   2802: aload_0
    //   2803: getfield 49	ang:a	Lanl;
    //   2806: aconst_null
    //   2807: invokeinterface 143 3 0
    //   2812: pop
    //   2813: aload_0
    //   2814: getfield 45	ang:g	Lann;
    //   2817: ifnull +16 -> 2833
    //   2820: aload_0
    //   2821: getfield 57	ang:e	Lanf;
    //   2824: aload_0
    //   2825: getfield 45	ang:g	Lann;
    //   2828: invokeinterface 146 2 0
    //   2833: aconst_null
    //   2834: areturn
    //   2835: aload 18
    //   2837: astore 21
    //   2839: aload_0
    //   2840: invokevirtual 117	ang:isCancelled	()Z
    //   2843: istore 15
    //   2845: aload 18
    //   2847: astore 19
    //   2849: iload 15
    //   2851: ifeq +78 -> 2929
    //   2854: aload 18
    //   2856: astore 17
    //   2858: aload 18
    //   2860: astore 16
    //   2862: invokestatic 95	ans:a	()V
    //   2865: aload 20
    //   2867: ifnull +8 -> 2875
    //   2870: aload 20
    //   2872: invokevirtual 140	android/os/ParcelFileDescriptor:close	()V
    //   2875: aload 18
    //   2877: ifnull +8 -> 2885
    //   2880: aload 18
    //   2882: invokevirtual 107	java/io/InputStream:close	()V
    //   2885: aload_0
    //   2886: invokevirtual 117	ang:isCancelled	()Z
    //   2889: ifne +18 -> 2907
    //   2892: aload_0
    //   2893: getfield 57	ang:e	Lanf;
    //   2896: aload_0
    //   2897: getfield 49	ang:a	Lanl;
    //   2900: aconst_null
    //   2901: invokeinterface 143 3 0
    //   2906: pop
    //   2907: aload_0
    //   2908: getfield 45	ang:g	Lann;
    //   2911: ifnull +16 -> 2927
    //   2914: aload_0
    //   2915: getfield 57	ang:e	Lanf;
    //   2918: aload_0
    //   2919: getfield 45	ang:g	Lann;
    //   2922: invokeinterface 146 2 0
    //   2927: aconst_null
    //   2928: areturn
    //   2929: aload 19
    //   2931: astore 21
    //   2933: aload 16
    //   2935: invokevirtual 358	java/io/IOException:printStackTrace	()V
    //   2938: aload 19
    //   2940: astore 17
    //   2942: aload 19
    //   2944: astore 16
    //   2946: invokestatic 95	ans:a	()V
    //   2949: aload 19
    //   2951: astore 18
    //   2953: aconst_null
    //   2954: astore 16
    //   2956: goto -866 -> 2090
    //   2959: astore 18
    //   2961: aload 21
    //   2963: astore 17
    //   2965: aload 21
    //   2967: astore 16
    //   2969: invokestatic 95	ans:a	()V
    //   2972: aload 21
    //   2974: astore 17
    //   2976: aload 21
    //   2978: astore 16
    //   2980: aload 18
    //   2982: athrow
    //   2983: aload 16
    //   2985: ifnonnull +309 -> 3294
    //   2988: aload_0
    //   2989: invokevirtual 117	ang:isCancelled	()Z
    //   2992: istore 15
    //   2994: iload 15
    //   2996: ifne +298 -> 3294
    //   2999: aload_0
    //   3000: getfield 43	ang:f	Landroid/graphics/BitmapFactory$Options;
    //   3003: getfield 205	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   3006: istore 8
    //   3008: new 265	java/lang/StringBuilder
    //   3011: dup
    //   3012: bipush 17
    //   3014: invokespecial 268	java/lang/StringBuilder:<init>	(I)V
    //   3017: ldc_w 360
    //   3020: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3023: iload 8
    //   3025: invokevirtual 277	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3028: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3031: invokestatic 88	ans:a	(Ljava/lang/String;)V
    //   3034: aload_0
    //   3035: getfield 45	ang:g	Lann;
    //   3038: ifnull +29 -> 3067
    //   3041: aload_0
    //   3042: getfield 57	ang:e	Lanf;
    //   3045: aload_0
    //   3046: getfield 45	ang:g	Lann;
    //   3049: invokeinterface 146 2 0
    //   3054: aload_0
    //   3055: aconst_null
    //   3056: putfield 45	ang:g	Lann;
    //   3059: aload_0
    //   3060: getfield 43	ang:f	Landroid/graphics/BitmapFactory$Options;
    //   3063: aconst_null
    //   3064: putfield 260	android/graphics/BitmapFactory$Options:inBitmap	Landroid/graphics/Bitmap;
    //   3067: aload_0
    //   3068: aload 20
    //   3070: aload 18
    //   3072: invokespecial 362	ang:a	(Landroid/os/ParcelFileDescriptor;Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   3075: astore 17
    //   3077: aload 17
    //   3079: astore 16
    //   3081: invokestatic 95	ans:a	()V
    //   3084: aload_0
    //   3085: invokevirtual 117	ang:isCancelled	()Z
    //   3088: istore 15
    //   3090: aload 16
    //   3092: astore 17
    //   3094: iload 15
    //   3096: ifeq +202 -> 3298
    //   3099: aload 20
    //   3101: ifnull +8 -> 3109
    //   3104: aload 20
    //   3106: invokevirtual 140	android/os/ParcelFileDescriptor:close	()V
    //   3109: aload 18
    //   3111: ifnull +8 -> 3119
    //   3114: aload 18
    //   3116: invokevirtual 107	java/io/InputStream:close	()V
    //   3119: aload_0
    //   3120: invokevirtual 117	ang:isCancelled	()Z
    //   3123: ifne +18 -> 3141
    //   3126: aload_0
    //   3127: getfield 57	ang:e	Lanf;
    //   3130: aload_0
    //   3131: getfield 49	ang:a	Lanl;
    //   3134: aconst_null
    //   3135: invokeinterface 143 3 0
    //   3140: pop
    //   3141: aload_0
    //   3142: getfield 45	ang:g	Lann;
    //   3145: ifnull +16 -> 3161
    //   3148: aload_0
    //   3149: getfield 57	ang:e	Lanf;
    //   3152: aload_0
    //   3153: getfield 45	ang:g	Lann;
    //   3156: invokeinterface 146 2 0
    //   3161: aconst_null
    //   3162: areturn
    //   3163: astore 19
    //   3165: getstatic 33	ang:i	Ljava/lang/String;
    //   3168: astore 17
    //   3170: aload 19
    //   3172: invokevirtual 363	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   3175: invokestatic 237	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   3178: astore 19
    //   3180: aload_0
    //   3181: getfield 43	ang:f	Landroid/graphics/BitmapFactory$Options;
    //   3184: getfield 205	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   3187: istore 8
    //   3189: aload 17
    //   3191: new 265	java/lang/StringBuilder
    //   3194: dup
    //   3195: aload 19
    //   3197: invokestatic 237	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   3200: invokevirtual 241	java/lang/String:length	()I
    //   3203: bipush 39
    //   3205: iadd
    //   3206: invokespecial 268	java/lang/StringBuilder:<init>	(I)V
    //   3209: ldc_w 365
    //   3212: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3215: aload 19
    //   3217: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3220: ldc_w 367
    //   3223: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3226: iload 8
    //   3228: invokevirtual 277	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3231: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3234: invokestatic 252	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   3237: pop
    //   3238: aload_0
    //   3239: getfield 43	ang:f	Landroid/graphics/BitmapFactory$Options;
    //   3242: getfield 205	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   3245: iconst_1
    //   3246: if_icmple +744 -> 3990
    //   3249: aload_0
    //   3250: getfield 43	ang:f	Landroid/graphics/BitmapFactory$Options;
    //   3253: iconst_1
    //   3254: putfield 205	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   3257: aload_0
    //   3258: aload 20
    //   3260: aload 18
    //   3262: invokespecial 362	ang:a	(Landroid/os/ParcelFileDescriptor;Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   3265: astore 16
    //   3267: invokestatic 95	ans:a	()V
    //   3270: goto -186 -> 3084
    //   3273: astore 16
    //   3275: invokestatic 95	ans:a	()V
    //   3278: aload 16
    //   3280: athrow
    //   3281: astore 16
    //   3283: aload 18
    //   3285: astore 17
    //   3287: aload 22
    //   3289: astore 18
    //   3291: goto -2218 -> 1073
    //   3294: aload 16
    //   3296: astore 17
    //   3298: aload 17
    //   3300: ifnonnull +67 -> 3367
    //   3303: aload 20
    //   3305: ifnull +8 -> 3313
    //   3308: aload 20
    //   3310: invokevirtual 140	android/os/ParcelFileDescriptor:close	()V
    //   3313: aload 18
    //   3315: ifnull +8 -> 3323
    //   3318: aload 18
    //   3320: invokevirtual 107	java/io/InputStream:close	()V
    //   3323: aload_0
    //   3324: invokevirtual 117	ang:isCancelled	()Z
    //   3327: ifne +18 -> 3345
    //   3330: aload_0
    //   3331: getfield 57	ang:e	Lanf;
    //   3334: aload_0
    //   3335: getfield 49	ang:a	Lanl;
    //   3338: aconst_null
    //   3339: invokeinterface 143 3 0
    //   3344: pop
    //   3345: aload_0
    //   3346: getfield 45	ang:g	Lann;
    //   3349: ifnull +16 -> 3365
    //   3352: aload_0
    //   3353: getfield 57	ang:e	Lanf;
    //   3356: aload_0
    //   3357: getfield 45	ang:g	Lann;
    //   3360: invokeinterface 146 2 0
    //   3365: aconst_null
    //   3366: areturn
    //   3367: aload_0
    //   3368: getfield 45	ang:g	Lann;
    //   3371: ifnull +166 -> 3537
    //   3374: aload_0
    //   3375: getfield 45	ang:g	Lann;
    //   3378: astore 16
    //   3380: aload 23
    //   3382: invokevirtual 370	android/graphics/Rect:isEmpty	()Z
    //   3385: ifne +125 -> 3510
    //   3388: aload 16
    //   3390: aload 23
    //   3392: getfield 312	android/graphics/Rect:right	I
    //   3395: aload 23
    //   3397: getfield 309	android/graphics/Rect:left	I
    //   3400: isub
    //   3401: aload_0
    //   3402: getfield 43	ang:f	Landroid/graphics/BitmapFactory$Options;
    //   3405: getfield 205	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   3408: idiv
    //   3409: putfield 371	ann:b	I
    //   3412: aload 16
    //   3414: aload 23
    //   3416: getfield 318	android/graphics/Rect:bottom	I
    //   3419: aload 23
    //   3421: getfield 315	android/graphics/Rect:top	I
    //   3424: isub
    //   3425: aload_0
    //   3426: getfield 43	ang:f	Landroid/graphics/BitmapFactory$Options;
    //   3429: getfield 205	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   3432: idiv
    //   3433: putfield 373	ann:c	I
    //   3436: aload 16
    //   3438: astore 22
    //   3440: aload 18
    //   3442: astore 21
    //   3444: aload 20
    //   3446: astore 19
    //   3448: aload 16
    //   3450: iconst_0
    //   3451: putfield 375	ann:d	I
    //   3454: aload 20
    //   3456: ifnull +8 -> 3464
    //   3459: aload 20
    //   3461: invokevirtual 140	android/os/ParcelFileDescriptor:close	()V
    //   3464: aload 18
    //   3466: ifnull +8 -> 3474
    //   3469: aload 18
    //   3471: invokevirtual 107	java/io/InputStream:close	()V
    //   3474: aload_0
    //   3475: invokevirtual 117	ang:isCancelled	()Z
    //   3478: ifne +19 -> 3497
    //   3481: aload_0
    //   3482: getfield 57	ang:e	Lanf;
    //   3485: aload_0
    //   3486: getfield 49	ang:a	Lanl;
    //   3489: aload 16
    //   3491: invokeinterface 143 3 0
    //   3496: pop
    //   3497: aload 16
    //   3499: ifnull +73 -> 3572
    //   3502: aload 16
    //   3504: invokevirtual 166	ann:a	()V
    //   3507: aload 16
    //   3509: areturn
    //   3510: aload 16
    //   3512: aload_0
    //   3513: getfield 43	ang:f	Landroid/graphics/BitmapFactory$Options;
    //   3516: getfield 169	android/graphics/BitmapFactory$Options:outWidth	I
    //   3519: putfield 371	ann:b	I
    //   3522: aload 16
    //   3524: aload_0
    //   3525: getfield 43	ang:f	Landroid/graphics/BitmapFactory$Options;
    //   3528: getfield 172	android/graphics/BitmapFactory$Options:outHeight	I
    //   3531: putfield 373	ann:c	I
    //   3534: goto -98 -> 3436
    //   3537: new 139	ann
    //   3540: dup
    //   3541: aload 17
    //   3543: iconst_0
    //   3544: invokespecial 378	ann:<init>	(Landroid/graphics/Bitmap;Z)V
    //   3547: astore 16
    //   3549: aload 16
    //   3551: aload 17
    //   3553: invokevirtual 381	android/graphics/Bitmap:getWidth	()I
    //   3556: putfield 371	ann:b	I
    //   3559: aload 16
    //   3561: aload 17
    //   3563: invokevirtual 384	android/graphics/Bitmap:getHeight	()I
    //   3566: putfield 373	ann:c	I
    //   3569: goto -133 -> 3436
    //   3572: aload 16
    //   3574: astore 17
    //   3576: aload_0
    //   3577: getfield 45	ang:g	Lann;
    //   3580: ifnull -3570 -> 10
    //   3583: aload_0
    //   3584: getfield 57	ang:e	Lanf;
    //   3587: aload_0
    //   3588: getfield 45	ang:g	Lann;
    //   3591: invokeinterface 146 2 0
    //   3596: aload 16
    //   3598: areturn
    //   3599: aload 16
    //   3601: astore 17
    //   3603: aload_0
    //   3604: getfield 45	ang:g	Lann;
    //   3607: ifnull -3597 -> 10
    //   3610: aload_0
    //   3611: getfield 57	ang:e	Lanf;
    //   3614: aload_0
    //   3615: getfield 45	ang:g	Lann;
    //   3618: invokeinterface 146 2 0
    //   3623: aload 16
    //   3625: areturn
    //   3626: aload_0
    //   3627: getfield 45	ang:g	Lann;
    //   3630: ifnull -2504 -> 1126
    //   3633: aload_0
    //   3634: getfield 57	ang:e	Lanf;
    //   3637: aload_0
    //   3638: getfield 45	ang:g	Lann;
    //   3641: invokeinterface 146 2 0
    //   3646: goto -2520 -> 1126
    //   3649: astore 16
    //   3651: goto -3358 -> 293
    //   3654: astore 16
    //   3656: goto -3290 -> 366
    //   3659: astore 16
    //   3661: goto -3463 -> 198
    //   3664: astore 16
    //   3666: goto -3458 -> 208
    //   3669: astore 16
    //   3671: goto -3153 -> 518
    //   3674: astore 16
    //   3676: goto -3148 -> 528
    //   3679: astore 16
    //   3681: goto -3069 -> 612
    //   3684: astore 16
    //   3686: goto -3064 -> 622
    //   3689: astore 16
    //   3691: goto -2992 -> 699
    //   3694: astore 16
    //   3696: goto -2987 -> 709
    //   3699: astore 16
    //   3701: goto -2852 -> 849
    //   3704: astore 16
    //   3706: goto -2847 -> 859
    //   3709: astore 16
    //   3711: goto -2101 -> 1610
    //   3714: astore 16
    //   3716: goto -2096 -> 1620
    //   3719: astore 16
    //   3721: goto -2285 -> 1436
    //   3724: astore 16
    //   3726: goto -2280 -> 1446
    //   3729: astore 16
    //   3731: goto -1994 -> 1737
    //   3734: astore 16
    //   3736: goto -1989 -> 1747
    //   3739: astore 16
    //   3741: goto -1910 -> 1831
    //   3744: astore 16
    //   3746: goto -1905 -> 1841
    //   3749: astore 16
    //   3751: goto -1833 -> 1918
    //   3754: astore 16
    //   3756: goto -1828 -> 1928
    //   3759: astore 16
    //   3761: goto -980 -> 2781
    //   3764: astore 16
    //   3766: goto -975 -> 2791
    //   3769: astore 16
    //   3771: goto -896 -> 2875
    //   3774: astore 16
    //   3776: goto -891 -> 2885
    //   3779: astore 16
    //   3781: goto -1670 -> 2111
    //   3784: astore 16
    //   3786: goto -1665 -> 2121
    //   3789: astore 16
    //   3791: goto -682 -> 3109
    //   3794: astore 16
    //   3796: goto -677 -> 3119
    //   3799: astore 16
    //   3801: goto -488 -> 3313
    //   3804: astore 16
    //   3806: goto -483 -> 3323
    //   3809: astore 17
    //   3811: goto -347 -> 3464
    //   3814: astore 17
    //   3816: goto -342 -> 3474
    //   3819: astore 17
    //   3821: goto -2830 -> 991
    //   3824: astore 17
    //   3826: goto -2825 -> 1001
    //   3829: astore 19
    //   3831: goto -2748 -> 1083
    //   3834: astore 17
    //   3836: goto -2743 -> 1093
    //   3839: astore 16
    //   3841: aconst_null
    //   3842: astore 20
    //   3844: aload 22
    //   3846: astore 18
    //   3848: goto -2775 -> 1073
    //   3851: astore 17
    //   3853: aload 16
    //   3855: astore 20
    //   3857: aload 17
    //   3859: astore 16
    //   3861: aload 18
    //   3863: astore 17
    //   3865: aload 22
    //   3867: astore 18
    //   3869: goto -2796 -> 1073
    //   3872: astore 21
    //   3874: aload 16
    //   3876: astore 19
    //   3878: aload 18
    //   3880: astore 17
    //   3882: aload 21
    //   3884: astore 16
    //   3886: aload 19
    //   3888: astore 18
    //   3890: goto -2817 -> 1073
    //   3893: astore 21
    //   3895: aload 16
    //   3897: astore 19
    //   3899: aload 18
    //   3901: astore 17
    //   3903: aload 21
    //   3905: astore 16
    //   3907: aload 19
    //   3909: astore 18
    //   3911: goto -2838 -> 1073
    //   3914: astore 16
    //   3916: aload 22
    //   3918: astore 18
    //   3920: aload 21
    //   3922: astore 17
    //   3924: aload 19
    //   3926: astore 20
    //   3928: goto -2855 -> 1073
    //   3931: astore 17
    //   3933: aconst_null
    //   3934: astore 20
    //   3936: aconst_null
    //   3937: astore 18
    //   3939: aconst_null
    //   3940: astore 16
    //   3942: goto -2978 -> 964
    //   3945: astore 17
    //   3947: aload 16
    //   3949: astore 20
    //   3951: aconst_null
    //   3952: astore 18
    //   3954: aconst_null
    //   3955: astore 16
    //   3957: goto -2993 -> 964
    //   3960: astore 17
    //   3962: aconst_null
    //   3963: astore 20
    //   3965: aload 16
    //   3967: astore 18
    //   3969: aconst_null
    //   3970: astore 16
    //   3972: goto -3008 -> 964
    //   3975: astore 17
    //   3977: goto -3013 -> 964
    //   3980: astore 17
    //   3982: goto -3018 -> 964
    //   3985: astore 17
    //   3987: goto -3023 -> 964
    //   3990: goto -723 -> 3267
    //   3993: goto -1693 -> 2300
    //   3996: aconst_null
    //   3997: astore 20
    //   3999: goto -3925 -> 74
    //   4002: goto -2766 -> 1236
    //   4005: astore 17
    //   4007: aconst_null
    //   4008: astore 16
    //   4010: goto -3046 -> 964
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4013	0	this	ang
    //   1499	10	1	d1	double
    //   1198	1193	3	f1	float
    //   2311	21	4	f2	float
    //   2277	143	5	f3	float
    //   2290	170	6	f4	float
    //   2324	18	7	f5	float
    //   1269	1958	8	j	int
    //   95	2644	9	k	int
    //   114	2342	10	m	int
    //   1144	1363	11	n	int
    //   1161	1348	12	i1	int
    //   2238	255	13	i2	int
    //   2225	138	14	i3	int
    //   181	2914	15	bool	boolean
    //   20	905	16	localObject1	Object
    //   947	10	16	localException1	Exception
    //   962	1755	16	localObject2	Object
    //   2732	1	16	localIOException1	IOException
    //   2766	500	16	localObject3	Object
    //   3273	6	16	localObject4	Object
    //   3281	14	16	localObject5	Object
    //   3378	246	16	localann	ann
    //   3649	1	16	localIOException2	IOException
    //   3654	1	16	localIOException3	IOException
    //   3659	1	16	localIOException4	IOException
    //   3664	1	16	localIOException5	IOException
    //   3669	1	16	localIOException6	IOException
    //   3674	1	16	localIOException7	IOException
    //   3679	1	16	localIOException8	IOException
    //   3684	1	16	localIOException9	IOException
    //   3689	1	16	localIOException10	IOException
    //   3694	1	16	localIOException11	IOException
    //   3699	1	16	localIOException12	IOException
    //   3704	1	16	localIOException13	IOException
    //   3709	1	16	localIOException14	IOException
    //   3714	1	16	localIOException15	IOException
    //   3719	1	16	localIOException16	IOException
    //   3724	1	16	localIOException17	IOException
    //   3729	1	16	localIOException18	IOException
    //   3734	1	16	localIOException19	IOException
    //   3739	1	16	localIOException20	IOException
    //   3744	1	16	localIOException21	IOException
    //   3749	1	16	localIOException22	IOException
    //   3754	1	16	localIOException23	IOException
    //   3759	1	16	localIOException24	IOException
    //   3764	1	16	localIOException25	IOException
    //   3769	1	16	localIOException26	IOException
    //   3774	1	16	localIOException27	IOException
    //   3779	1	16	localIOException28	IOException
    //   3784	1	16	localIOException29	IOException
    //   3789	1	16	localIOException30	IOException
    //   3794	1	16	localIOException31	IOException
    //   3799	1	16	localIOException32	IOException
    //   3804	1	16	localIOException33	IOException
    //   3839	15	16	localObject6	Object
    //   3859	47	16	localObject7	Object
    //   3914	1	16	localObject8	Object
    //   3940	69	16	localObject9	Object
    //   8	3594	17	localObject10	Object
    //   3809	1	17	localIOException34	IOException
    //   3814	1	17	localIOException35	IOException
    //   3819	1	17	localIOException36	IOException
    //   3824	1	17	localIOException37	IOException
    //   3834	1	17	localIOException38	IOException
    //   3851	7	17	localObject11	Object
    //   3863	60	17	localObject12	Object
    //   3931	1	17	localException2	Exception
    //   3945	1	17	localException3	Exception
    //   3960	1	17	localException4	Exception
    //   3975	1	17	localException5	Exception
    //   3980	1	17	localException6	Exception
    //   3985	1	17	localException7	Exception
    //   4005	1	17	localException8	Exception
    //   17	1105	18	localObject13	Object
    //   1518	24	18	localOutOfMemoryError	OutOfMemoryError
    //   1549	1403	18	localObject14	Object
    //   2959	325	18	localInputStream1	InputStream
    //   3289	679	18	localObject15	Object
    //   26	1020	19	localObject16	Object
    //   1059	751	19	localInputStream2	InputStream
    //   1814	1136	19	localObject17	Object
    //   3163	8	19	localIllegalArgumentException	IllegalArgumentException
    //   3178	269	19	localObject18	Object
    //   3829	1	19	localIOException39	IOException
    //   3876	49	19	localObject19	Object
    //   23	3975	20	localObject20	Object
    //   970	2473	21	localObject21	Object
    //   3872	11	21	localObject22	Object
    //   3893	28	21	localObject23	Object
    //   14	3903	22	localObject24	Object
    //   1987	1433	23	localRect	android.graphics.Rect
    //   2551	120	24	localRectF1	android.graphics.RectF
    //   2566	138	25	localRectF2	android.graphics.RectF
    // Exception table:
    //   from	to	target	type
    //   87	94	947	java/lang/Exception
    //   105	113	947	java/lang/Exception
    //   129	134	947	java/lang/Exception
    //   142	158	947	java/lang/Exception
    //   166	169	947	java/lang/Exception
    //   177	183	947	java/lang/Exception
    //   430	435	947	java/lang/Exception
    //   448	454	947	java/lang/Exception
    //   462	465	947	java/lang/Exception
    //   473	478	947	java/lang/Exception
    //   486	489	947	java/lang/Exception
    //   497	503	947	java/lang/Exception
    //   589	597	947	java/lang/Exception
    //   674	680	947	java/lang/Exception
    //   761	766	947	java/lang/Exception
    //   774	782	947	java/lang/Exception
    //   795	809	947	java/lang/Exception
    //   817	820	947	java/lang/Exception
    //   828	834	947	java/lang/Exception
    //   911	918	947	java/lang/Exception
    //   926	944	947	java/lang/Exception
    //   1045	1056	947	java/lang/Exception
    //   1137	1146	947	java/lang/Exception
    //   1154	1163	947	java/lang/Exception
    //   1171	1199	947	java/lang/Exception
    //   1207	1236	947	java/lang/Exception
    //   1244	1271	947	java/lang/Exception
    //   1279	1292	947	java/lang/Exception
    //   1300	1308	947	java/lang/Exception
    //   1316	1324	947	java/lang/Exception
    //   1337	1344	947	java/lang/Exception
    //   1352	1357	947	java/lang/Exception
    //   1365	1396	947	java/lang/Exception
    //   1404	1407	947	java/lang/Exception
    //   1415	1421	947	java/lang/Exception
    //   1508	1515	947	java/lang/Exception
    //   1528	1533	947	java/lang/Exception
    //   1541	1551	947	java/lang/Exception
    //   1559	1567	947	java/lang/Exception
    //   1575	1584	947	java/lang/Exception
    //   1592	1600	947	java/lang/Exception
    //   1672	1683	947	java/lang/Exception
    //   1694	1708	947	java/lang/Exception
    //   1716	1722	947	java/lang/Exception
    //   1808	1816	947	java/lang/Exception
    //   1893	1899	947	java/lang/Exception
    //   1980	1989	947	java/lang/Exception
    //   2083	2086	947	java/lang/Exception
    //   2768	2771	947	java/lang/Exception
    //   2862	2865	947	java/lang/Exception
    //   2946	2949	947	java/lang/Exception
    //   2969	2972	947	java/lang/Exception
    //   2980	2983	947	java/lang/Exception
    //   87	94	1059	finally
    //   105	113	1059	finally
    //   129	134	1059	finally
    //   142	158	1059	finally
    //   166	169	1059	finally
    //   177	183	1059	finally
    //   430	435	1059	finally
    //   448	454	1059	finally
    //   462	465	1059	finally
    //   473	478	1059	finally
    //   486	489	1059	finally
    //   497	503	1059	finally
    //   589	597	1059	finally
    //   674	680	1059	finally
    //   761	766	1059	finally
    //   774	782	1059	finally
    //   795	809	1059	finally
    //   817	820	1059	finally
    //   828	834	1059	finally
    //   911	918	1059	finally
    //   926	944	1059	finally
    //   1045	1056	1059	finally
    //   1137	1146	1059	finally
    //   1154	1163	1059	finally
    //   1171	1199	1059	finally
    //   1207	1236	1059	finally
    //   1244	1271	1059	finally
    //   1279	1292	1059	finally
    //   1300	1308	1059	finally
    //   1316	1324	1059	finally
    //   1337	1344	1059	finally
    //   1352	1357	1059	finally
    //   1365	1396	1059	finally
    //   1404	1407	1059	finally
    //   1415	1421	1059	finally
    //   1508	1515	1059	finally
    //   1528	1533	1059	finally
    //   1541	1551	1059	finally
    //   1559	1567	1059	finally
    //   1575	1584	1059	finally
    //   1592	1600	1059	finally
    //   1672	1683	1059	finally
    //   1694	1708	1059	finally
    //   1716	1722	1059	finally
    //   1808	1816	1059	finally
    //   1893	1899	1059	finally
    //   1980	1989	1059	finally
    //   2083	2086	1059	finally
    //   2768	2771	1059	finally
    //   2862	2865	1059	finally
    //   2946	2949	1059	finally
    //   2969	2972	1059	finally
    //   2980	2983	1059	finally
    //   1365	1396	1518	java/lang/OutOfMemoryError
    //   1993	2002	2732	java/io/IOException
    //   2006	2032	2732	java/io/IOException
    //   2041	2052	2732	java/io/IOException
    //   2056	2063	2732	java/io/IOException
    //   2070	2075	2732	java/io/IOException
    //   2169	2176	2732	java/io/IOException
    //   2180	2196	2732	java/io/IOException
    //   2203	2211	2732	java/io/IOException
    //   2218	2227	2732	java/io/IOException
    //   2231	2240	2732	java/io/IOException
    //   2244	2253	2732	java/io/IOException
    //   2257	2266	2732	java/io/IOException
    //   2270	2279	2732	java/io/IOException
    //   2283	2292	2732	java/io/IOException
    //   2304	2313	2732	java/io/IOException
    //   2317	2326	2732	java/io/IOException
    //   2341	2346	2732	java/io/IOException
    //   2350	2358	2732	java/io/IOException
    //   2362	2372	2732	java/io/IOException
    //   2376	2386	2732	java/io/IOException
    //   2390	2407	2732	java/io/IOException
    //   2411	2426	2732	java/io/IOException
    //   2430	2443	2732	java/io/IOException
    //   2447	2479	2732	java/io/IOException
    //   2483	2496	2732	java/io/IOException
    //   2500	2515	2732	java/io/IOException
    //   2519	2528	2732	java/io/IOException
    //   2532	2538	2732	java/io/IOException
    //   2542	2553	2732	java/io/IOException
    //   2557	2568	2732	java/io/IOException
    //   2572	2580	2732	java/io/IOException
    //   2584	2592	2732	java/io/IOException
    //   2596	2601	2732	java/io/IOException
    //   2605	2622	2732	java/io/IOException
    //   2626	2634	2732	java/io/IOException
    //   2638	2646	2732	java/io/IOException
    //   2650	2679	2732	java/io/IOException
    //   2683	2712	2732	java/io/IOException
    //   2716	2729	2732	java/io/IOException
    //   1993	2002	2959	finally
    //   2006	2032	2959	finally
    //   2041	2052	2959	finally
    //   2056	2063	2959	finally
    //   2070	2075	2959	finally
    //   2169	2176	2959	finally
    //   2180	2196	2959	finally
    //   2203	2211	2959	finally
    //   2218	2227	2959	finally
    //   2231	2240	2959	finally
    //   2244	2253	2959	finally
    //   2257	2266	2959	finally
    //   2270	2279	2959	finally
    //   2283	2292	2959	finally
    //   2304	2313	2959	finally
    //   2317	2326	2959	finally
    //   2341	2346	2959	finally
    //   2350	2358	2959	finally
    //   2362	2372	2959	finally
    //   2376	2386	2959	finally
    //   2390	2407	2959	finally
    //   2411	2426	2959	finally
    //   2430	2443	2959	finally
    //   2447	2479	2959	finally
    //   2483	2496	2959	finally
    //   2500	2515	2959	finally
    //   2519	2528	2959	finally
    //   2532	2538	2959	finally
    //   2542	2553	2959	finally
    //   2557	2568	2959	finally
    //   2572	2580	2959	finally
    //   2584	2592	2959	finally
    //   2596	2601	2959	finally
    //   2605	2622	2959	finally
    //   2626	2634	2959	finally
    //   2638	2646	2959	finally
    //   2650	2679	2959	finally
    //   2683	2712	2959	finally
    //   2716	2729	2959	finally
    //   2747	2755	2959	finally
    //   2839	2845	2959	finally
    //   2933	2938	2959	finally
    //   2999	3067	3163	java/lang/IllegalArgumentException
    //   3067	3077	3163	java/lang/IllegalArgumentException
    //   2999	3067	3273	finally
    //   3067	3077	3273	finally
    //   3165	3267	3273	finally
    //   2090	2096	3281	finally
    //   2988	2994	3281	finally
    //   3081	3084	3281	finally
    //   3084	3090	3281	finally
    //   3267	3270	3281	finally
    //   3275	3281	3281	finally
    //   3367	3380	3281	finally
    //   3537	3549	3281	finally
    //   288	293	3649	java/io/IOException
    //   361	366	3654	java/io/IOException
    //   193	198	3659	java/io/IOException
    //   203	208	3664	java/io/IOException
    //   513	518	3669	java/io/IOException
    //   523	528	3674	java/io/IOException
    //   607	612	3679	java/io/IOException
    //   617	622	3684	java/io/IOException
    //   694	699	3689	java/io/IOException
    //   704	709	3694	java/io/IOException
    //   844	849	3699	java/io/IOException
    //   854	859	3704	java/io/IOException
    //   1605	1610	3709	java/io/IOException
    //   1615	1620	3714	java/io/IOException
    //   1431	1436	3719	java/io/IOException
    //   1441	1446	3724	java/io/IOException
    //   1732	1737	3729	java/io/IOException
    //   1742	1747	3734	java/io/IOException
    //   1826	1831	3739	java/io/IOException
    //   1836	1841	3744	java/io/IOException
    //   1913	1918	3749	java/io/IOException
    //   1923	1928	3754	java/io/IOException
    //   2776	2781	3759	java/io/IOException
    //   2786	2791	3764	java/io/IOException
    //   2870	2875	3769	java/io/IOException
    //   2880	2885	3774	java/io/IOException
    //   2106	2111	3779	java/io/IOException
    //   2116	2121	3784	java/io/IOException
    //   3104	3109	3789	java/io/IOException
    //   3114	3119	3794	java/io/IOException
    //   3308	3313	3799	java/io/IOException
    //   3318	3323	3804	java/io/IOException
    //   3459	3464	3809	java/io/IOException
    //   3469	3474	3814	java/io/IOException
    //   986	991	3819	java/io/IOException
    //   996	1001	3824	java/io/IOException
    //   1078	1083	3829	java/io/IOException
    //   1088	1093	3834	java/io/IOException
    //   32	39	3839	finally
    //   43	48	3839	finally
    //   52	63	3839	finally
    //   260	267	3839	finally
    //   271	278	3839	finally
    //   341	347	3839	finally
    //   63	66	3851	finally
    //   3380	3436	3872	finally
    //   3510	3534	3872	finally
    //   3549	3569	3893	finally
    //   976	981	3914	finally
    //   3448	3454	3914	finally
    //   32	39	3931	java/lang/Exception
    //   43	48	3931	java/lang/Exception
    //   52	63	3931	java/lang/Exception
    //   260	267	3931	java/lang/Exception
    //   271	278	3931	java/lang/Exception
    //   63	66	3945	java/lang/Exception
    //   341	347	3960	java/lang/Exception
    //   3380	3436	3975	java/lang/Exception
    //   3510	3534	3975	java/lang/Exception
    //   3549	3569	3980	java/lang/Exception
    //   3448	3454	3985	java/lang/Exception
    //   2090	2096	4005	java/lang/Exception
    //   2988	2994	4005	java/lang/Exception
    //   3081	3084	4005	java/lang/Exception
    //   3084	3090	4005	java/lang/Exception
    //   3267	3270	4005	java/lang/Exception
    //   3275	3281	4005	java/lang/Exception
    //   3367	3380	4005	java/lang/Exception
    //   3537	3549	4005	java/lang/Exception
  }
}

/* Location:
 * Qualified Name:     ang
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */