import android.content.Context;
import android.net.Uri;
import com.android.mail.browse.ConversationMessage;

public final class byb
  extends cot<ConversationMessage>
{
  private static final String a = cvl.a;
  private final Uri b;
  
  public byb(Context paramContext, Uri paramUri)
  {
    super(paramContext);
    b = paramUri;
  }
  
  /* Error */
  private final ConversationMessage a()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 35	byb:getContext	()Landroid/content/Context;
    //   4: astore_3
    //   5: aload_3
    //   6: invokevirtual 41	android/content/Context:getCacheDir	()Ljava/io/File;
    //   9: putstatic 46	bce:a	Ljava/io/File;
    //   12: aload_3
    //   13: invokevirtual 50	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   16: astore 4
    //   18: aload 4
    //   20: aload_0
    //   21: getfield 24	byb:b	Landroid/net/Uri;
    //   24: invokevirtual 56	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   27: astore 5
    //   29: new 58	com/android/mail/browse/ConversationMessage
    //   32: dup
    //   33: aload_3
    //   34: new 60	bcl
    //   37: dup
    //   38: aload 5
    //   40: invokespecial 63	bcl:<init>	(Ljava/io/InputStream;)V
    //   43: aload_0
    //   44: getfield 24	byb:b	Landroid/net/Uri;
    //   47: invokespecial 66	com/android/mail/browse/ConversationMessage:<init>	(Landroid/content/Context;Lbcl;Landroid/net/Uri;)V
    //   50: astore_3
    //   51: aload 5
    //   53: invokevirtual 71	java/io/InputStream:close	()V
    //   56: invokestatic 73	bce:a	()Ljava/io/File;
    //   59: invokevirtual 79	java/io/File:listFiles	()[Ljava/io/File;
    //   62: astore 5
    //   64: aload 5
    //   66: arraylength
    //   67: istore_2
    //   68: iconst_0
    //   69: istore_1
    //   70: iload_1
    //   71: iload_2
    //   72: if_icmpge +478 -> 550
    //   75: aload 5
    //   77: iload_1
    //   78: aaload
    //   79: astore 4
    //   81: aload 4
    //   83: invokevirtual 83	java/io/File:getName	()Ljava/lang/String;
    //   86: ldc 85
    //   88: invokevirtual 91	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   91: ifeq +55 -> 146
    //   94: aload 4
    //   96: invokevirtual 95	java/io/File:delete	()Z
    //   99: ifne +47 -> 146
    //   102: getstatic 16	byb:a	Ljava/lang/String;
    //   105: astore 6
    //   107: aload 4
    //   109: invokevirtual 83	java/io/File:getName	()Ljava/lang/String;
    //   112: invokestatic 99	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   115: astore 4
    //   117: aload 4
    //   119: invokevirtual 103	java/lang/String:length	()I
    //   122: ifeq +61 -> 183
    //   125: ldc 105
    //   127: aload 4
    //   129: invokevirtual 109	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   132: astore 4
    //   134: aload 6
    //   136: aload 4
    //   138: iconst_0
    //   139: anewarray 111	java/lang/Object
    //   142: invokestatic 116	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   145: pop
    //   146: iload_1
    //   147: iconst_1
    //   148: iadd
    //   149: istore_1
    //   150: goto -80 -> 70
    //   153: astore_3
    //   154: getstatic 16	byb:a	Ljava/lang/String;
    //   157: aload_3
    //   158: ldc 118
    //   160: iconst_1
    //   161: anewarray 111	java/lang/Object
    //   164: dup
    //   165: iconst_0
    //   166: aload_0
    //   167: getfield 24	byb:b	Landroid/net/Uri;
    //   170: aastore
    //   171: invokestatic 122	cvm:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   174: pop
    //   175: aconst_null
    //   176: areturn
    //   177: astore_3
    //   178: aconst_null
    //   179: astore_3
    //   180: goto -124 -> 56
    //   183: new 87	java/lang/String
    //   186: dup
    //   187: ldc 105
    //   189: invokespecial 125	java/lang/String:<init>	(Ljava/lang/String;)V
    //   192: astore 4
    //   194: goto -60 -> 134
    //   197: astore_3
    //   198: getstatic 16	byb:a	Ljava/lang/String;
    //   201: aload_3
    //   202: ldc 127
    //   204: iconst_0
    //   205: anewarray 111	java/lang/Object
    //   208: invokestatic 122	cvm:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   211: pop
    //   212: aload 5
    //   214: invokevirtual 71	java/io/InputStream:close	()V
    //   217: invokestatic 73	bce:a	()Ljava/io/File;
    //   220: invokevirtual 79	java/io/File:listFiles	()[Ljava/io/File;
    //   223: astore 4
    //   225: aload 4
    //   227: arraylength
    //   228: istore_2
    //   229: iconst_0
    //   230: istore_1
    //   231: iload_1
    //   232: iload_2
    //   233: if_icmpge -58 -> 175
    //   236: aload 4
    //   238: iload_1
    //   239: aaload
    //   240: astore_3
    //   241: aload_3
    //   242: invokevirtual 83	java/io/File:getName	()Ljava/lang/String;
    //   245: ldc 85
    //   247: invokevirtual 91	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   250: ifeq +48 -> 298
    //   253: aload_3
    //   254: invokevirtual 95	java/io/File:delete	()Z
    //   257: ifne +41 -> 298
    //   260: getstatic 16	byb:a	Ljava/lang/String;
    //   263: astore 5
    //   265: aload_3
    //   266: invokevirtual 83	java/io/File:getName	()Ljava/lang/String;
    //   269: invokestatic 99	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   272: astore_3
    //   273: aload_3
    //   274: invokevirtual 103	java/lang/String:length	()I
    //   277: ifeq +28 -> 305
    //   280: ldc 105
    //   282: aload_3
    //   283: invokevirtual 109	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   286: astore_3
    //   287: aload 5
    //   289: aload_3
    //   290: iconst_0
    //   291: anewarray 111	java/lang/Object
    //   294: invokestatic 116	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   297: pop
    //   298: iload_1
    //   299: iconst_1
    //   300: iadd
    //   301: istore_1
    //   302: goto -71 -> 231
    //   305: new 87	java/lang/String
    //   308: dup
    //   309: ldc 105
    //   311: invokespecial 125	java/lang/String:<init>	(Ljava/lang/String;)V
    //   314: astore_3
    //   315: goto -28 -> 287
    //   318: astore_3
    //   319: getstatic 16	byb:a	Ljava/lang/String;
    //   322: aload_3
    //   323: ldc -127
    //   325: iconst_0
    //   326: anewarray 111	java/lang/Object
    //   329: invokestatic 122	cvm:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   332: pop
    //   333: aload 5
    //   335: invokevirtual 71	java/io/InputStream:close	()V
    //   338: invokestatic 73	bce:a	()Ljava/io/File;
    //   341: invokevirtual 79	java/io/File:listFiles	()[Ljava/io/File;
    //   344: astore 4
    //   346: aload 4
    //   348: arraylength
    //   349: istore_2
    //   350: iconst_0
    //   351: istore_1
    //   352: iload_1
    //   353: iload_2
    //   354: if_icmpge -179 -> 175
    //   357: aload 4
    //   359: iload_1
    //   360: aaload
    //   361: astore_3
    //   362: aload_3
    //   363: invokevirtual 83	java/io/File:getName	()Ljava/lang/String;
    //   366: ldc 85
    //   368: invokevirtual 91	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   371: ifeq +48 -> 419
    //   374: aload_3
    //   375: invokevirtual 95	java/io/File:delete	()Z
    //   378: ifne +41 -> 419
    //   381: getstatic 16	byb:a	Ljava/lang/String;
    //   384: astore 5
    //   386: aload_3
    //   387: invokevirtual 83	java/io/File:getName	()Ljava/lang/String;
    //   390: invokestatic 99	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   393: astore_3
    //   394: aload_3
    //   395: invokevirtual 103	java/lang/String:length	()I
    //   398: ifeq +28 -> 426
    //   401: ldc 105
    //   403: aload_3
    //   404: invokevirtual 109	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   407: astore_3
    //   408: aload 5
    //   410: aload_3
    //   411: iconst_0
    //   412: anewarray 111	java/lang/Object
    //   415: invokestatic 116	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   418: pop
    //   419: iload_1
    //   420: iconst_1
    //   421: iadd
    //   422: istore_1
    //   423: goto -71 -> 352
    //   426: new 87	java/lang/String
    //   429: dup
    //   430: ldc 105
    //   432: invokespecial 125	java/lang/String:<init>	(Ljava/lang/String;)V
    //   435: astore_3
    //   436: goto -28 -> 408
    //   439: astore 4
    //   441: aload 5
    //   443: invokevirtual 71	java/io/InputStream:close	()V
    //   446: invokestatic 73	bce:a	()Ljava/io/File;
    //   449: invokevirtual 79	java/io/File:listFiles	()[Ljava/io/File;
    //   452: astore 5
    //   454: aload 5
    //   456: arraylength
    //   457: istore_2
    //   458: iconst_0
    //   459: istore_1
    //   460: iload_1
    //   461: iload_2
    //   462: if_icmpge +85 -> 547
    //   465: aload 5
    //   467: iload_1
    //   468: aaload
    //   469: astore_3
    //   470: aload_3
    //   471: invokevirtual 83	java/io/File:getName	()Ljava/lang/String;
    //   474: ldc 85
    //   476: invokevirtual 91	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   479: ifeq +48 -> 527
    //   482: aload_3
    //   483: invokevirtual 95	java/io/File:delete	()Z
    //   486: ifne +41 -> 527
    //   489: getstatic 16	byb:a	Ljava/lang/String;
    //   492: astore 6
    //   494: aload_3
    //   495: invokevirtual 83	java/io/File:getName	()Ljava/lang/String;
    //   498: invokestatic 99	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   501: astore_3
    //   502: aload_3
    //   503: invokevirtual 103	java/lang/String:length	()I
    //   506: ifeq +28 -> 534
    //   509: ldc 105
    //   511: aload_3
    //   512: invokevirtual 109	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   515: astore_3
    //   516: aload 6
    //   518: aload_3
    //   519: iconst_0
    //   520: anewarray 111	java/lang/Object
    //   523: invokestatic 116	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   526: pop
    //   527: iload_1
    //   528: iconst_1
    //   529: iadd
    //   530: istore_1
    //   531: goto -71 -> 460
    //   534: new 87	java/lang/String
    //   537: dup
    //   538: ldc 105
    //   540: invokespecial 125	java/lang/String:<init>	(Ljava/lang/String;)V
    //   543: astore_3
    //   544: goto -28 -> 516
    //   547: aload 4
    //   549: athrow
    //   550: aload_3
    //   551: areturn
    //   552: astore_3
    //   553: goto -336 -> 217
    //   556: astore_3
    //   557: goto -219 -> 338
    //   560: astore_3
    //   561: goto -115 -> 446
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	564	0	this	byb
    //   69	462	1	i	int
    //   67	396	2	j	int
    //   4	47	3	localObject1	Object
    //   153	5	3	localFileNotFoundException	java.io.FileNotFoundException
    //   177	1	3	localIOException1	java.io.IOException
    //   179	1	3	localObject2	Object
    //   197	5	3	localIOException2	java.io.IOException
    //   240	75	3	str1	String
    //   318	5	3	localbdi	bdi
    //   361	190	3	str2	String
    //   552	1	3	localIOException3	java.io.IOException
    //   556	1	3	localIOException4	java.io.IOException
    //   560	1	3	localIOException5	java.io.IOException
    //   16	342	4	localObject3	Object
    //   439	109	4	localObject4	Object
    //   27	439	5	localObject5	Object
    //   105	412	6	str3	String
    // Exception table:
    //   from	to	target	type
    //   18	29	153	java/io/FileNotFoundException
    //   51	56	177	java/io/IOException
    //   29	51	197	java/io/IOException
    //   29	51	318	bdi
    //   29	51	439	finally
    //   198	212	439	finally
    //   319	333	439	finally
    //   212	217	552	java/io/IOException
    //   333	338	556	java/io/IOException
    //   441	446	560	java/io/IOException
  }
}

/* Location:
 * Qualified Name:     byb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */