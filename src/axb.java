import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

final class axb
{
  private static final String h = cvl.a;
  private static final Map<String, String> o = new hen().b("IDLE", "idle").b("NOTIFY", "notify").b("CREATE-SPECIAL-USE", "create_special_use").b("SPECIAL-USE", "special_use").b("CONDSTORE", "condstore").b("QRESYNC", "qresync").b("SORT", "sort").b("THREAD=ORDEREDSUBJECT", "thread_orderedsubject").b("THREAD=REFERENCES", "thread_references").b("URLAUTH", "url_auth").b("UTF8=ACCEPT", "utf8_accept").b("UTF8=ONLY", "utf8_only").b("WITHIN", "within").b("CATENATE", "catenate").b();
  ayd a;
  public axv b;
  int c;
  int d;
  int e;
  long f;
  final ayc g = new ayc();
  private int i;
  private axd j;
  private String k;
  private String l;
  private String m = null;
  private final AtomicInteger n = new AtomicInteger(0);
  
  axb(axd paramaxd)
  {
    a(paramaxd);
  }
  
  /* Error */
  private final void a(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: bipush 24
    //   5: istore_3
    //   6: aload_0
    //   7: getfield 133	axb:a	Layd;
    //   10: ifnull +14 -> 24
    //   13: aload_0
    //   14: getfield 133	axb:a	Layd;
    //   17: invokevirtual 138	ayd:e	()Z
    //   20: ifeq +4 -> 24
    //   23: return
    //   24: aload_0
    //   25: getfield 133	axb:a	Layd;
    //   28: ifnonnull +17 -> 45
    //   31: aload_0
    //   32: aload_0
    //   33: getfield 140	axb:j	Laxd;
    //   36: getfield 144	axd:d	Layd;
    //   39: invokevirtual 147	ayd:a	()Layd;
    //   42: putfield 133	axb:a	Layd;
    //   45: aload_0
    //   46: getfield 133	axb:a	Layd;
    //   49: invokevirtual 149	ayd:c	()V
    //   52: aload_0
    //   53: invokespecial 151	axb:i	()V
    //   56: aload_0
    //   57: invokevirtual 154	axb:d	()Laxu;
    //   60: pop
    //   61: aload_0
    //   62: invokespecial 156	axb:j	()Laxu;
    //   65: astore 6
    //   67: aload 6
    //   69: ldc -98
    //   71: invokevirtual 163	axu:a	(Ljava/lang/String;)Z
    //   74: istore 4
    //   76: aload_0
    //   77: getfield 133	axb:a	Layd;
    //   80: invokevirtual 165	ayd:b	()Z
    //   83: ifeq +784 -> 867
    //   86: iload 4
    //   88: ifeq +442 -> 530
    //   91: aload_0
    //   92: ldc -98
    //   94: iconst_0
    //   95: invokevirtual 168	axb:b	(Ljava/lang/String;Z)Ljava/util/List;
    //   98: pop
    //   99: aload_0
    //   100: getfield 133	axb:a	Layd;
    //   103: invokevirtual 170	ayd:d	()V
    //   106: aload_0
    //   107: invokespecial 151	axb:i	()V
    //   110: aload_0
    //   111: invokespecial 156	axb:j	()Laxu;
    //   114: astore 5
    //   116: goto +751 -> 867
    //   119: aload_0
    //   120: aload 5
    //   122: invokespecial 173	axb:a	(Laxu;)V
    //   125: aload 5
    //   127: new 175	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   134: invokevirtual 181	axr:a	(Ljava/lang/StringBuilder;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload_0
    //   139: iconst_1
    //   140: invokespecial 184	axb:b	(I)Z
    //   143: ifeq +124 -> 267
    //   146: aload_0
    //   147: getfield 133	axb:a	Layd;
    //   150: getfield 187	ayd:a	Lcom/android/emailcommon/provider/HostAuth;
    //   153: getfield 191	com/android/emailcommon/provider/HostAuth:c	Ljava/lang/String;
    //   156: invokevirtual 197	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   159: ldc -57
    //   161: invokevirtual 202	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   164: ifne +103 -> 267
    //   167: aload_0
    //   168: getfield 140	axb:j	Laxd;
    //   171: getfield 205	axd:b	Landroid/content/Context;
    //   174: aload_0
    //   175: getfield 140	axb:j	Laxd;
    //   178: getfield 207	axd:e	Ljava/lang/String;
    //   181: invokestatic 210	axd:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   184: astore 5
    //   186: aload 5
    //   188: ifnull +58 -> 246
    //   191: ldc -44
    //   193: invokestatic 216	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   196: astore 6
    //   198: aload_0
    //   199: new 175	java/lang/StringBuilder
    //   202: dup
    //   203: aload 6
    //   205: invokestatic 216	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   208: invokevirtual 220	java/lang/String:length	()I
    //   211: iconst_1
    //   212: iadd
    //   213: aload 5
    //   215: invokestatic 216	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   218: invokevirtual 220	java/lang/String:length	()I
    //   221: iadd
    //   222: invokespecial 221	java/lang/StringBuilder:<init>	(I)V
    //   225: aload 6
    //   227: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: aload 5
    //   232: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: ldc -29
    //   237: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: putfield 111	axb:m	Ljava/lang/String;
    //   246: aload_0
    //   247: getfield 111	axb:m	Ljava/lang/String;
    //   250: astore 5
    //   252: aload 5
    //   254: ifnull +13 -> 267
    //   257: aload_0
    //   258: aload_0
    //   259: getfield 111	axb:m	Ljava/lang/String;
    //   262: iconst_0
    //   263: invokevirtual 168	axb:b	(Ljava/lang/String;Z)Ljava/util/List;
    //   266: pop
    //   267: aload_0
    //   268: getfield 140	axb:j	Laxd;
    //   271: getfield 233	axd:j	Z
    //   274: istore 4
    //   276: iload 4
    //   278: ifeq +469 -> 747
    //   281: getstatic 236	bbw:a	Ljava/lang/String;
    //   284: ldc -18
    //   286: iconst_1
    //   287: anewarray 4	java/lang/Object
    //   290: dup
    //   291: iconst_0
    //   292: iload_1
    //   293: invokestatic 243	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   296: aastore
    //   297: invokestatic 248	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   300: pop
    //   301: aload_0
    //   302: invokespecial 250	axb:k	()Laxu;
    //   305: astore 5
    //   307: aload 5
    //   309: iconst_0
    //   310: ldc -4
    //   312: iconst_0
    //   313: invokevirtual 255	axr:a	(ILjava/lang/String;Z)Z
    //   316: ifeq +321 -> 637
    //   319: aload 5
    //   321: iconst_1
    //   322: ldc_w 257
    //   325: iconst_1
    //   326: invokevirtual 258	axu:a	(ILjava/lang/String;Z)Z
    //   329: ifne +308 -> 637
    //   332: iconst_1
    //   333: istore_2
    //   334: iload_2
    //   335: ifne +72 -> 407
    //   338: getstatic 236	bbw:a	Ljava/lang/String;
    //   341: ldc_w 260
    //   344: iconst_0
    //   345: anewarray 4	java/lang/Object
    //   348: invokestatic 248	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   351: pop
    //   352: aload_0
    //   353: invokevirtual 261	axb:c	()V
    //   356: invokestatic 266	aws:a	()Laws;
    //   359: aload_0
    //   360: getfield 140	axb:j	Laxd;
    //   363: getfield 205	axd:b	Landroid/content/Context;
    //   366: aload_0
    //   367: getfield 140	axb:j	Laxd;
    //   370: getfield 271	awr:c	Lcom/android/emailcommon/provider/Account;
    //   373: invokevirtual 274	aws:b	(Landroid/content/Context;Lcom/android/emailcommon/provider/Account;)Ljava/lang/String;
    //   376: pop
    //   377: aload_0
    //   378: getfield 133	axb:a	Layd;
    //   381: ifnull +15 -> 396
    //   384: aload_0
    //   385: getfield 133	axb:a	Layd;
    //   388: invokevirtual 276	ayd:f	()V
    //   391: aload_0
    //   392: aconst_null
    //   393: putfield 133	axb:a	Layd;
    //   396: iload_1
    //   397: ifle +245 -> 642
    //   400: aload_0
    //   401: iload_1
    //   402: iconst_1
    //   403: isub
    //   404: invokespecial 278	axb:a	(I)V
    //   407: aload_0
    //   408: invokespecial 156	axb:j	()Laxu;
    //   411: astore 5
    //   413: aload 5
    //   415: ifnull +9 -> 424
    //   418: aload_0
    //   419: aload 5
    //   421: invokespecial 173	axb:a	(Laxu;)V
    //   424: aload_0
    //   425: aload_0
    //   426: iconst_2
    //   427: invokespecial 184	axb:b	(I)Z
    //   430: invokespecial 281	axb:a	(Z)V
    //   433: aload_0
    //   434: invokespecial 283	axb:l	()V
    //   437: aload_0
    //   438: getfield 140	axb:j	Laxd;
    //   441: astore 6
    //   443: aload 6
    //   445: getfield 284	axd:h	Ljava/lang/String;
    //   448: invokestatic 290	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   451: ifne +74 -> 525
    //   454: aload 6
    //   456: getfield 292	axd:i	Ljava/lang/String;
    //   459: invokestatic 290	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   462: ifne +63 -> 525
    //   465: aload 6
    //   467: getfield 284	axd:h	Ljava/lang/String;
    //   470: aload 6
    //   472: getfield 292	axd:i	Ljava/lang/String;
    //   475: invokevirtual 202	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   478: ifne +47 -> 525
    //   481: aload 6
    //   483: getfield 284	axd:h	Ljava/lang/String;
    //   486: invokestatic 216	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   489: astore 5
    //   491: aload 6
    //   493: getfield 292	axd:i	Ljava/lang/String;
    //   496: invokestatic 216	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   499: astore 7
    //   501: aload 7
    //   503: invokevirtual 220	java/lang/String:length	()I
    //   506: ifeq +335 -> 841
    //   509: aload 5
    //   511: aload 7
    //   513: invokevirtual 296	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   516: astore 5
    //   518: aload 6
    //   520: aload 5
    //   522: putfield 284	axd:h	Ljava/lang/String;
    //   525: aload_0
    //   526: invokevirtual 261	axb:c	()V
    //   529: return
    //   530: getstatic 236	bbw:a	Ljava/lang/String;
    //   533: ldc_w 298
    //   536: iconst_0
    //   537: anewarray 4	java/lang/Object
    //   540: invokestatic 300	cvm:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   543: pop
    //   544: new 302	bdi
    //   547: dup
    //   548: iconst_2
    //   549: invokespecial 303	bdi:<init>	(I)V
    //   552: athrow
    //   553: astore 5
    //   555: getstatic 37	axb:h	Ljava/lang/String;
    //   558: aload 5
    //   560: ldc_w 305
    //   563: iconst_0
    //   564: anewarray 4	java/lang/Object
    //   567: invokestatic 308	cvm:c	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   570: pop
    //   571: new 310	bcw
    //   574: dup
    //   575: aload 5
    //   577: invokevirtual 313	javax/net/ssl/SSLException:getMessage	()Ljava/lang/String;
    //   580: aload 5
    //   582: invokespecial 316	bcw:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   585: athrow
    //   586: astore 5
    //   588: aload_0
    //   589: invokevirtual 261	axb:c	()V
    //   592: aload 5
    //   594: athrow
    //   595: astore 5
    //   597: getstatic 236	bbw:a	Ljava/lang/String;
    //   600: aload 5
    //   602: ldc_w 318
    //   605: iconst_0
    //   606: anewarray 4	java/lang/Object
    //   609: invokestatic 320	cvm:b	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   612: pop
    //   613: goto -346 -> 267
    //   616: astore 5
    //   618: getstatic 37	axb:h	Ljava/lang/String;
    //   621: aload 5
    //   623: ldc_w 305
    //   626: iconst_0
    //   627: anewarray 4	java/lang/Object
    //   630: invokestatic 308	cvm:c	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   633: pop
    //   634: aload 5
    //   636: athrow
    //   637: iconst_0
    //   638: istore_2
    //   639: goto -305 -> 334
    //   642: getstatic 236	bbw:a	Ljava/lang/String;
    //   645: ldc_w 322
    //   648: iconst_0
    //   649: anewarray 4	java/lang/Object
    //   652: invokestatic 248	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   655: pop
    //   656: new 324	bcs
    //   659: dup
    //   660: ldc_w 326
    //   663: invokespecial 329	bcs:<init>	(Ljava/lang/String;)V
    //   666: athrow
    //   667: astore 5
    //   669: getstatic 236	bbw:a	Ljava/lang/String;
    //   672: aload 5
    //   674: ldc_w 331
    //   677: iconst_0
    //   678: anewarray 4	java/lang/Object
    //   681: invokestatic 308	cvm:c	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   684: pop
    //   685: aload 5
    //   687: getfield 332	axe:a	Ljava/lang/String;
    //   690: astore 6
    //   692: aload 5
    //   694: getfield 333	axe:c	Ljava/lang/String;
    //   697: astore 7
    //   699: aload 5
    //   701: getfield 335	axe:b	Ljava/lang/String;
    //   704: astore 8
    //   706: ldc_w 337
    //   709: aload 7
    //   711: invokevirtual 341	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   714: ifeq +56 -> 770
    //   717: ldc_w 343
    //   720: aload 6
    //   722: invokevirtual 341	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   725: ifeq +45 -> 770
    //   728: iload 4
    //   730: ifeq +30 -> 760
    //   733: new 324	bcs
    //   736: dup
    //   737: bipush 24
    //   739: aload 8
    //   741: aload 5
    //   743: invokespecial 346	bcs:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   746: athrow
    //   747: aload_0
    //   748: aload_0
    //   749: invokespecial 348	axb:h	()Ljava/lang/String;
    //   752: iconst_1
    //   753: invokevirtual 168	axb:b	(Ljava/lang/String;Z)Ljava/util/List;
    //   756: pop
    //   757: goto -350 -> 407
    //   760: new 350	bdo
    //   763: dup
    //   764: aload 8
    //   766: invokespecial 351	bdo:<init>	(Ljava/lang/String;)V
    //   769: athrow
    //   770: ldc_w 353
    //   773: aload 7
    //   775: invokevirtual 341	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   778: ifne +97 -> 875
    //   781: ldc_w 355
    //   784: aload 7
    //   786: invokevirtual 341	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   789: ifne +86 -> 875
    //   792: ldc_w 343
    //   795: aload 6
    //   797: invokevirtual 341	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   800: ifeq +27 -> 827
    //   803: aload 7
    //   805: invokestatic 290	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   808: ifeq +19 -> 827
    //   811: goto +64 -> 875
    //   814: new 324	bcs
    //   817: dup
    //   818: iload_1
    //   819: aload 8
    //   821: aload 5
    //   823: invokespecial 346	bcs:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   826: athrow
    //   827: new 302	bdi
    //   830: dup
    //   831: bipush 26
    //   833: aload 8
    //   835: aload 5
    //   837: invokespecial 356	bdi:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   840: athrow
    //   841: new 193	java/lang/String
    //   844: dup
    //   845: aload 5
    //   847: invokespecial 357	java/lang/String:<init>	(Ljava/lang/String;)V
    //   850: astore 5
    //   852: goto -334 -> 518
    //   855: astore 5
    //   857: goto -590 -> 267
    //   860: aload 6
    //   862: astore 5
    //   864: goto -745 -> 119
    //   867: aload 5
    //   869: ifnull -9 -> 860
    //   872: goto -753 -> 119
    //   875: iload 4
    //   877: ifeq +8 -> 885
    //   880: iload_3
    //   881: istore_1
    //   882: goto -68 -> 814
    //   885: iconst_5
    //   886: istore_1
    //   887: goto -73 -> 814
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	890	0	this	axb
    //   0	890	1	paramInt	int
    //   333	306	2	i1	int
    //   5	876	3	i2	int
    //   74	802	4	bool	boolean
    //   1	520	5	localObject1	Object
    //   553	28	5	localSSLException	javax.net.ssl.SSLException
    //   586	7	5	localObject2	Object
    //   595	6	5	localaxe1	axe
    //   616	19	5	localIOException1	IOException
    //   667	179	5	localaxe2	axe
    //   850	1	5	str1	String
    //   855	1	5	localIOException2	IOException
    //   862	6	5	localObject3	Object
    //   65	796	6	localObject4	Object
    //   499	305	7	str2	String
    //   704	130	8	str3	String
    // Exception table:
    //   from	to	target	type
    //   24	45	553	javax/net/ssl/SSLException
    //   45	76	553	javax/net/ssl/SSLException
    //   76	86	553	javax/net/ssl/SSLException
    //   91	116	553	javax/net/ssl/SSLException
    //   119	186	553	javax/net/ssl/SSLException
    //   191	246	553	javax/net/ssl/SSLException
    //   246	252	553	javax/net/ssl/SSLException
    //   257	267	553	javax/net/ssl/SSLException
    //   267	276	553	javax/net/ssl/SSLException
    //   281	332	553	javax/net/ssl/SSLException
    //   338	396	553	javax/net/ssl/SSLException
    //   400	407	553	javax/net/ssl/SSLException
    //   407	413	553	javax/net/ssl/SSLException
    //   418	424	553	javax/net/ssl/SSLException
    //   424	518	553	javax/net/ssl/SSLException
    //   518	525	553	javax/net/ssl/SSLException
    //   530	553	553	javax/net/ssl/SSLException
    //   597	613	553	javax/net/ssl/SSLException
    //   642	667	553	javax/net/ssl/SSLException
    //   669	728	553	javax/net/ssl/SSLException
    //   733	747	553	javax/net/ssl/SSLException
    //   747	757	553	javax/net/ssl/SSLException
    //   760	770	553	javax/net/ssl/SSLException
    //   770	811	553	javax/net/ssl/SSLException
    //   814	827	553	javax/net/ssl/SSLException
    //   827	841	553	javax/net/ssl/SSLException
    //   841	852	553	javax/net/ssl/SSLException
    //   24	45	586	finally
    //   45	76	586	finally
    //   76	86	586	finally
    //   91	116	586	finally
    //   119	186	586	finally
    //   191	246	586	finally
    //   246	252	586	finally
    //   257	267	586	finally
    //   267	276	586	finally
    //   281	332	586	finally
    //   338	396	586	finally
    //   400	407	586	finally
    //   407	413	586	finally
    //   418	424	586	finally
    //   424	518	586	finally
    //   518	525	586	finally
    //   530	553	586	finally
    //   555	586	586	finally
    //   597	613	586	finally
    //   618	637	586	finally
    //   642	667	586	finally
    //   669	728	586	finally
    //   733	747	586	finally
    //   747	757	586	finally
    //   760	770	586	finally
    //   770	811	586	finally
    //   814	827	586	finally
    //   827	841	586	finally
    //   841	852	586	finally
    //   257	267	595	axe
    //   24	45	616	java/io/IOException
    //   45	76	616	java/io/IOException
    //   76	86	616	java/io/IOException
    //   91	116	616	java/io/IOException
    //   119	186	616	java/io/IOException
    //   191	246	616	java/io/IOException
    //   246	252	616	java/io/IOException
    //   267	276	616	java/io/IOException
    //   281	332	616	java/io/IOException
    //   338	396	616	java/io/IOException
    //   400	407	616	java/io/IOException
    //   407	413	616	java/io/IOException
    //   418	424	616	java/io/IOException
    //   424	518	616	java/io/IOException
    //   518	525	616	java/io/IOException
    //   530	553	616	java/io/IOException
    //   597	613	616	java/io/IOException
    //   642	667	616	java/io/IOException
    //   669	728	616	java/io/IOException
    //   733	747	616	java/io/IOException
    //   747	757	616	java/io/IOException
    //   760	770	616	java/io/IOException
    //   770	811	616	java/io/IOException
    //   814	827	616	java/io/IOException
    //   827	841	616	java/io/IOException
    //   841	852	616	java/io/IOException
    //   281	332	667	axe
    //   338	396	667	axe
    //   400	407	667	axe
    //   642	667	667	axe
    //   747	757	667	axe
    //   257	267	855	java/io/IOException
  }
  
  private final void a(axu paramaxu)
  {
    but localbut = buo.a();
    if (localbut.a("imap_capabilities", 200))
    {
      Object localObject1 = o.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localObject3 = Boolean.toString(paramaxu.a((String)localObject2));
        localbut.a("imap_capabilities", (String)o.get(localObject2), (String)localObject3, 0L);
        cvm.a(cvm.a, "Server supports capability %s: %s", new Object[] { localObject2, localObject3 });
      }
      Object localObject2 = new StringBuilder();
      Object localObject3 = axm.a;
      int i2 = localObject3.length;
      int i1 = 0;
      if (i1 < i2)
      {
        Object localObject4 = localObject3[i1];
        localObject1 = String.valueOf("AUTH=");
        String str = String.valueOf(localObject4);
        if (str.length() != 0) {}
        for (localObject1 = ((String)localObject1).concat(str);; localObject1 = new String((String)localObject1))
        {
          localObject1 = Boolean.toString(paramaxu.a((String)localObject1));
          ((StringBuilder)localObject2).append(String.format(Locale.US, "%s=%s ", new Object[] { localObject4, localObject1 }));
          i1 += 1;
          break;
        }
      }
      localObject1 = ((StringBuilder)localObject2).toString();
      cvm.a(cvm.a, "Server supports auth types: %s", new Object[] { localObject1 });
      localbut.a(12, (String)localObject1);
      localbut.a("imap_capabilities", "auth", null, 0L);
    }
    if (paramaxu.a("ID")) {
      i |= 0x1;
    }
    if (paramaxu.a("NAMESPACE")) {
      i |= 0x2;
    }
    if (paramaxu.a("UIDPLUS")) {
      i |= 0x8;
    }
    if (paramaxu.a("STARTTLS")) {
      i |= 0x4;
    }
  }
  
  private final void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    e += 1;
    c += paramString1.length();
    long l1 = SystemClock.elapsedRealtime();
    a.a(paramString1, paramString2);
    long l2 = f;
    f = (SystemClock.elapsedRealtime() - l1 + l2);
    paramString2 = g;
    if (paramBoolean) {
      paramString1 = "[IMAP command redacted]";
    }
    paramString2.a(paramString1);
  }
  
  private final void a(boolean paramBoolean)
  {
    Object localObject1;
    if ((paramBoolean) && (!j.f()))
    {
      localObject1 = Collections.emptyList();
      try
      {
        localObject2 = b("NAMESPACE", false);
        localObject1 = localObject2;
      }
      catch (axe localaxe)
      {
        for (;;)
        {
          Object localObject2;
          cvm.b(bbw.a, localaxe, "Exception getting namespace", new Object[0]);
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          cvm.b(bbw.a, localIOException, "Exception getting namespace", new Object[0]);
          continue;
          localObject1 = axd.c((String)localObject1, null);
        }
      }
      localObject2 = ((List)localObject1).iterator();
      for (;;)
      {
        if (!((Iterator)localObject2).hasNext()) {
          return;
        }
        localObject1 = (axu)((Iterator)localObject2).next();
        if (((axu)localObject1).a(0, "NAMESPACE"))
        {
          axr localaxr = ((axu)localObject1).b(1).b(0);
          localObject1 = localaxr.c(0).e();
          if (localObject1 != null)
          {
            axd localaxd = j;
            if (!((String)localObject1).isEmpty()) {
              break;
            }
            h = ((String)localObject1);
            j.i = localaxr.c(1).e();
          }
        }
      }
    }
  }
  
  private final boolean b(int paramInt)
  {
    return (i & paramInt) != 0;
  }
  
  private final String c(String paramString, boolean paramBoolean)
  {
    if (a == null) {
      throw new IOException("Null transport");
    }
    String str1 = Integer.toString(n.incrementAndGet());
    String str2 = String.valueOf(str1).length() + 1 + String.valueOf(paramString).length() + str1 + " " + paramString;
    if (paramBoolean) {}
    for (paramString = "[IMAP command redacted]";; paramString = null)
    {
      a(str2, paramString, paramBoolean);
      return str1;
    }
  }
  
  private final String h()
  {
    String str1;
    String str2;
    if (j.j)
    {
      str1 = aws.a().a(j.b, j.c);
      if (TextUtils.isEmpty(str1))
      {
        cvm.d(h, "OAuth tokens have been cleared. Re-authentication required", new Object[0]);
        throw new bcs(24, "OAuth tokens have been cleared. Re-authentication required");
      }
      if ((k == null) || (!TextUtils.equals(l, str1)))
      {
        l = str1;
        str1 = String.valueOf(j.e);
        str2 = l;
        str2 = String.valueOf(str1).length() + 20 + String.valueOf(str2).length() + "user=" + str1 + "\001auth=Bearer " + str2 + "\001\001";
        str1 = String.valueOf("AUTHENTICATE XOAUTH2 ");
        str2 = String.valueOf(Base64.encodeToString(str2.getBytes(), 2));
        if (str2.length() == 0) {
          break label201;
        }
        str1 = str1.concat(str2);
      }
    }
    label201:
    String str3;
    for (k = str1;; k = (String.valueOf(str1).length() + 1 + String.valueOf(str2).length() + String.valueOf(str3).length() + str1 + str2 + " " + str3))
    {
      do
      {
        return k;
        str1 = new String(str1);
        break;
      } while ((k != null) || (j.e == null) || (j.f == null));
      str1 = String.valueOf("LOGIN ");
      str2 = String.valueOf(j.e);
      str3 = j.f.replaceAll("\\\\", "\\\\\\\\").replaceAll("\"", "\\\\\"");
      str3 = String.valueOf(String.valueOf(str3).length() + 2 + "\"" + str3 + "\"");
    }
  }
  
  private final void i()
  {
    c();
    b = new axv(a.c, g);
  }
  
  private final axu j()
  {
    c("CAPABILITY", false);
    Iterator localIterator = e().iterator();
    axu localaxu;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localaxu = (axu)localIterator.next();
    } while (!localaxu.a(0, "CAPABILITY", false));
    for (;;)
    {
      if (localaxu == null) {
        throw new bdi(26, "Invalid CAPABILITY response received");
      }
      return localaxu;
      localaxu = null;
    }
  }
  
  private final axu k()
  {
    c(h(), true);
    axu localaxu2;
    do
    {
      localaxu2 = d();
    } while ((!localaxu2.f()) && (!e));
    axu localaxu1 = localaxu2;
    if (e)
    {
      c("", true);
      localaxu1 = d();
    }
    if ("UNAVAILABLE".equals(localaxu1.h().e())) {
      throw new bdi(19, localaxu1.i().e());
    }
    return localaxu1;
  }
  
  private final void l()
  {
    if (j.f()) {
      localObject1 = Collections.emptyList();
    }
    try
    {
      localObject2 = b("LIST \"\" \"\"", false);
      localObject1 = localObject2;
    }
    catch (axe localaxe)
    {
      for (;;)
      {
        Object localObject2;
        cvm.b(bbw.a, localaxe, "ImapException", new Object[0]);
      }
      return;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    Object localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (axu)((Iterator)localObject1).next();
      if (((axu)localObject2).a(0, "LIST")) {
        j.i = ((axu)localObject2).c(2).e();
      }
    }
  }
  
  final String a(String paramString, boolean paramBoolean)
  {
    String str2 = bbw.a;
    if (paramBoolean) {}
    for (String str1 = "[IMAP command redacted]";; str1 = paramString)
    {
      cvm.b(str2, "sendCommand %s", new Object[] { str1 });
      a();
      return c(paramString, paramBoolean);
    }
  }
  
  final String a(List<String> paramList, boolean paramBoolean)
  {
    a();
    String str2 = Integer.toString(n.incrementAndGet());
    int i2 = paramList.size();
    int i1 = 0;
    if (i1 < i2)
    {
      String str1 = (String)paramList.get(i1);
      if (i1 == 0) {
        str1 = String.valueOf(str2).length() + 1 + String.valueOf(str1).length() + str2 + " " + str1;
      }
      while (de)
      {
        a(str1, null, false);
        i1 += 1;
        break;
      }
      throw new bdi(26, "Expected continuation request");
    }
    return str2;
  }
  
  final void a()
  {
    if ((j != null) && (j.j))
    {
      a(2);
      return;
    }
    a(1);
  }
  
  final void a(axd paramaxd)
  {
    j = paramaxd;
    k = null;
  }
  
  final List<axu> b(String paramString, boolean paramBoolean)
  {
    a(paramString, paramBoolean);
    return e();
  }
  
  final void b()
  {
    if (a != null)
    {
      a.f();
      a = null;
    }
    c();
    b = null;
    j = null;
  }
  
  final void c()
  {
    if (b != null)
    {
      axv localaxv = b;
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext()) {
        ((axu)localIterator.next()).c();
      }
      a.clear();
    }
  }
  
  final axu d()
  {
    long l1 = SystemClock.elapsedRealtime();
    axu localaxu = b.a();
    long l2 = f;
    f = (SystemClock.elapsedRealtime() - l1 + l2);
    d += f;
    return localaxu;
  }
  
  final List<axu> e()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    do
    {
      localObject2 = d();
      localArrayList.add(localObject2);
    } while (!((axu)localObject2).f());
    if (!((axr)localObject2).a(0, "OK", false))
    {
      String str1 = ((axu)localObject2).toString();
      Object localObject1;
      label62:
      String str2;
      String str3;
      int i1;
      if (!((axu)localObject2).g())
      {
        localObject1 = axy.d;
        localObject1 = ((axy)localObject1).e();
        str2 = ((axu)localObject2).i().e();
        str3 = ((axu)localObject2).h().e();
        localObject2 = ((axu)localObject2).j().e();
        c();
        buo.a().a("imap_error", str3, (String)localObject2, 0L);
        i1 = -1;
        switch (str3.hashCode())
        {
        }
      }
      for (;;)
      {
        switch (i1)
        {
        default: 
          throw new axe(str1, (String)localObject1, str2, str3);
          localObject1 = ((axu)localObject2).c(0);
          break label62;
          if (str3.equals("UNAVAILABLE"))
          {
            i1 = 0;
            continue;
            if (str3.equals("NONEXISTENT")) {
              i1 = 1;
            }
          }
          break;
        }
      }
      throw new bdi(19, str2);
      if (!((String)localObject2).startsWith("Unknown Mailbox: [Gmail]")) {
        throw new bdi(22, str2);
      }
    }
    return localArrayList;
  }
  
  final void f()
  {
    g.b();
  }
  
  public final void g()
  {
    c = 0;
    d = 0;
    e = 0;
    f = 0L;
  }
}

/* Location:
 * Qualified Name:     axb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */