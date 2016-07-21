import android.app.DownloadManager;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.android.mail.providers.Attachment;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;

public final class ctr
{
  private static final String a = cvl.a;
  
  private static int a(Uri paramUri, ContentResolver paramContentResolver)
  {
    int j = -1;
    Object localObject = null;
    Uri localUri = null;
    for (;;)
    {
      try
      {
        paramUri = paramContentResolver.openFileDescriptor(paramUri, "r");
        localUri = paramUri;
        localObject = paramUri;
        long l = paramUri.getStatSize();
        j = (int)l;
        i = j;
      }
      catch (FileNotFoundException paramUri)
      {
        localObject = localUri;
        cvm.d(a, paramUri, "Error opening file to obtain size.", new Object[0]);
        int i = j;
        if (localUri == null) {
          continue;
        }
        try
        {
          localUri.close();
          i = j;
        }
        catch (IOException paramUri)
        {
          cvm.d(a, "Error closing file opened to obtain size.", new Object[0]);
          i = j;
        }
        continue;
      }
      finally
      {
        if (localObject == null) {
          break label135;
        }
      }
      try
      {
        paramUri.close();
        i = j;
      }
      catch (IOException paramUri)
      {
        cvm.d(a, "Error closing file opened to obtain size.", new Object[0]);
        i = j;
      }
    }
    return Math.max(i, 0);
    try
    {
      ((ParcelFileDescriptor)localObject).close();
      label135:
      throw paramUri;
    }
    catch (IOException paramContentResolver)
    {
      for (;;)
      {
        cvm.d(a, "Error closing file opened to obtain size.", new Object[0]);
      }
    }
  }
  
  public static int a(String paramString)
  {
    if ((paramString.startsWith("application/msword")) || (paramString.startsWith("application/vnd.oasis.opendocument.text")) || (paramString.equals("application/rtf")) || (paramString.equals("application/vnd.openxmlformats-officedocument.wordprocessingml.document"))) {
      return 1;
    }
    if (paramString.startsWith("image/")) {
      return 2;
    }
    if (paramString.startsWith("video/")) {
      return 3;
    }
    if (paramString.startsWith("text/html")) {
      return 4;
    }
    if (paramString.startsWith("application/pdf")) {
      return 5;
    }
    if ((paramString.endsWith("powerpoint")) || (paramString.equals("application/vnd.oasis.opendocument.presentation")) || (paramString.equals("application/vnd.openxmlformats-officedocument.presentationml.presentation"))) {
      return 6;
    }
    if ((paramString.startsWith("audio/")) || (paramString.startsWith("music/"))) {
      return 7;
    }
    if (paramString.startsWith("text/plain")) {
      return 8;
    }
    if ((paramString.endsWith("excel")) || (paramString.equals("application/vnd.oasis.opendocument.spreadsheet")) || (paramString.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))) {
      return 9;
    }
    if ((paramString.endsWith("zip")) || (paramString.endsWith("/x-compress")) || (paramString.endsWith("/x-compressed"))) {
      return 10;
    }
    return 11;
  }
  
  private static Cursor a(ContentResolver paramContentResolver, Uri paramUri, String paramString)
  {
    try
    {
      paramContentResolver = paramContentResolver.query(paramUri, new String[] { paramString }, null, null, null);
      return paramContentResolver;
    }
    catch (SQLiteException paramContentResolver) {}
    return null;
  }
  
  /* Error */
  public static Attachment a(Context paramContext, Uri paramUri)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +13 -> 14
    //   4: aload_1
    //   5: invokevirtual 125	android/net/Uri:getPath	()Ljava/lang/String;
    //   8: invokestatic 131	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +13 -> 24
    //   14: new 133	ctq
    //   17: dup
    //   18: ldc -121
    //   20: invokespecial 139	ctq:<init>	(Ljava/lang/String;)V
    //   23: athrow
    //   24: aload_0
    //   25: invokevirtual 145	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   28: astore 7
    //   30: aload 7
    //   32: aload_1
    //   33: invokevirtual 149	android/content/ContentResolver:getType	(Landroid/net/Uri;)Ljava/lang/String;
    //   36: astore 4
    //   38: aload 4
    //   40: ifnonnull +480 -> 520
    //   43: ldc -105
    //   45: astore 4
    //   47: new 153	com/android/mail/providers/Attachment
    //   50: dup
    //   51: invokespecial 155	com/android/mail/providers/Attachment:<init>	()V
    //   54: astore 6
    //   56: aload 6
    //   58: aconst_null
    //   59: putfield 159	com/android/mail/providers/Attachment:e	Landroid/net/Uri;
    //   62: aload 6
    //   64: aconst_null
    //   65: invokevirtual 162	com/android/mail/providers/Attachment:b	(Ljava/lang/String;)Z
    //   68: pop
    //   69: aload 6
    //   71: iconst_0
    //   72: putfield 165	com/android/mail/providers/Attachment:d	I
    //   75: aload 6
    //   77: aload_1
    //   78: putfield 168	com/android/mail/providers/Attachment:i	Landroid/net/Uri;
    //   81: aload 6
    //   83: aload_1
    //   84: putfield 171	com/android/mail/providers/Attachment:j	Landroid/net/Uri;
    //   87: aload 7
    //   89: aload_1
    //   90: iconst_2
    //   91: anewarray 60	java/lang/String
    //   94: dup
    //   95: iconst_0
    //   96: ldc -83
    //   98: aastore
    //   99: dup
    //   100: iconst_1
    //   101: ldc -81
    //   103: aastore
    //   104: aconst_null
    //   105: aconst_null
    //   106: aconst_null
    //   107: invokevirtual 116	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   110: astore_0
    //   111: aload_0
    //   112: ifnull +61 -> 173
    //   115: aload_0
    //   116: ldc -83
    //   118: invokeinterface 180 2 0
    //   123: istore_2
    //   124: aload_0
    //   125: ldc -81
    //   127: invokeinterface 180 2 0
    //   132: istore_3
    //   133: aload_0
    //   134: invokeinterface 184 1 0
    //   139: ifeq +28 -> 167
    //   142: aload 6
    //   144: aload_0
    //   145: iload_2
    //   146: invokeinterface 188 2 0
    //   151: invokevirtual 162	com/android/mail/providers/Attachment:b	(Ljava/lang/String;)Z
    //   154: pop
    //   155: aload 6
    //   157: aload_0
    //   158: iload_3
    //   159: invokeinterface 192 2 0
    //   164: putfield 165	com/android/mail/providers/Attachment:d	I
    //   167: aload_0
    //   168: invokeinterface 193 1 0
    //   173: aload 6
    //   175: getfield 196	com/android/mail/providers/Attachment:c	Ljava/lang/String;
    //   178: ifnonnull +13 -> 191
    //   181: aload 6
    //   183: aload_1
    //   184: invokevirtual 199	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   187: invokevirtual 162	com/android/mail/providers/Attachment:b	(Ljava/lang/String;)Z
    //   190: pop
    //   191: aload 6
    //   193: getfield 165	com/android/mail/providers/Attachment:d	I
    //   196: ifne +32 -> 228
    //   199: ldc -55
    //   201: aload_1
    //   202: invokevirtual 204	android/net/Uri:getScheme	()Ljava/lang/String;
    //   205: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   208: ifeq +251 -> 459
    //   211: aload 6
    //   213: aload 7
    //   215: aload_1
    //   216: ldc 21
    //   218: invokevirtual 208	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   221: invokevirtual 213	android/content/res/AssetFileDescriptor:getLength	()J
    //   224: l2i
    //   225: putfield 165	com/android/mail/providers/Attachment:d	I
    //   228: aload 6
    //   230: aload 4
    //   232: invokevirtual 215	com/android/mail/providers/Attachment:a	(Ljava/lang/String;)V
    //   235: aload 6
    //   237: areturn
    //   238: astore 5
    //   240: aload_0
    //   241: invokeinterface 193 1 0
    //   246: aload 5
    //   248: athrow
    //   249: astore 5
    //   251: aload 7
    //   253: aload_1
    //   254: ldc -83
    //   256: invokestatic 217	ctr:a	(Landroid/content/ContentResolver;Landroid/net/Uri;Ljava/lang/String;)Landroid/database/Cursor;
    //   259: astore 5
    //   261: aload 5
    //   263: ifnull +41 -> 304
    //   266: aload 5
    //   268: astore_0
    //   269: aload 5
    //   271: invokeinterface 184 1 0
    //   276: ifeq +28 -> 304
    //   279: aload 5
    //   281: astore_0
    //   282: aload 6
    //   284: aload 5
    //   286: aload 5
    //   288: ldc -83
    //   290: invokeinterface 180 2 0
    //   295: invokeinterface 188 2 0
    //   300: invokevirtual 162	com/android/mail/providers/Attachment:b	(Ljava/lang/String;)Z
    //   303: pop
    //   304: aload 5
    //   306: ifnull +10 -> 316
    //   309: aload 5
    //   311: invokeinterface 193 1 0
    //   316: aload 5
    //   318: astore_0
    //   319: aload 7
    //   321: aload_1
    //   322: ldc -81
    //   324: invokestatic 217	ctr:a	(Landroid/content/ContentResolver;Landroid/net/Uri;Ljava/lang/String;)Landroid/database/Cursor;
    //   327: astore 5
    //   329: aload 5
    //   331: ifnull +68 -> 399
    //   334: aload 5
    //   336: astore_0
    //   337: aload 5
    //   339: invokeinterface 184 1 0
    //   344: ifeq +55 -> 399
    //   347: aload 5
    //   349: astore_0
    //   350: aload 6
    //   352: aload 5
    //   354: aload 5
    //   356: ldc -81
    //   358: invokeinterface 180 2 0
    //   363: invokeinterface 192 2 0
    //   368: putfield 165	com/android/mail/providers/Attachment:d	I
    //   371: aload 5
    //   373: ifnull -200 -> 173
    //   376: aload 5
    //   378: invokeinterface 193 1 0
    //   383: goto -210 -> 173
    //   386: astore_1
    //   387: aload_0
    //   388: ifnull +9 -> 397
    //   391: aload_0
    //   392: invokeinterface 193 1 0
    //   397: aload_1
    //   398: athrow
    //   399: aload 5
    //   401: astore_0
    //   402: aload 6
    //   404: aload_1
    //   405: aload 7
    //   407: invokestatic 219	ctr:a	(Landroid/net/Uri;Landroid/content/ContentResolver;)I
    //   410: putfield 165	com/android/mail/providers/Attachment:d	I
    //   413: goto -42 -> 371
    //   416: astore_1
    //   417: aload_0
    //   418: ifnull +9 -> 427
    //   421: aload_0
    //   422: invokeinterface 193 1 0
    //   427: aload_1
    //   428: athrow
    //   429: astore_0
    //   430: new 133	ctq
    //   433: dup
    //   434: ldc -35
    //   436: aload_0
    //   437: invokespecial 224	ctq:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   440: athrow
    //   441: astore_0
    //   442: getstatic 12	cvl:a	Ljava/lang/String;
    //   445: aload_0
    //   446: ldc -30
    //   448: iconst_0
    //   449: anewarray 4	java/lang/Object
    //   452: invokestatic 228	cvm:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   455: pop
    //   456: goto -228 -> 228
    //   459: aload 6
    //   461: aload_1
    //   462: aload 7
    //   464: invokestatic 219	ctr:a	(Landroid/net/Uri;Landroid/content/ContentResolver;)I
    //   467: putfield 165	com/android/mail/providers/Attachment:d	I
    //   470: aload_1
    //   471: invokevirtual 231	android/net/Uri:getAuthority	()Ljava/lang/String;
    //   474: astore_1
    //   475: aload_1
    //   476: astore_0
    //   477: aload_1
    //   478: ifnull +16 -> 494
    //   481: aload_1
    //   482: aload_1
    //   483: bipush 64
    //   485: invokevirtual 234	java/lang/String:lastIndexOf	(I)I
    //   488: iconst_1
    //   489: iadd
    //   490: invokevirtual 237	java/lang/String:substring	(I)Ljava/lang/String;
    //   493: astore_0
    //   494: ldc -17
    //   496: aload_0
    //   497: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   500: ifeq -272 -> 228
    //   503: aload 6
    //   505: sipush 1024
    //   508: putfield 165	com/android/mail/providers/Attachment:d	I
    //   511: goto -283 -> 228
    //   514: astore_0
    //   515: aconst_null
    //   516: astore_0
    //   517: goto -266 -> 251
    //   520: goto -473 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	523	0	paramContext	Context
    //   0	523	1	paramUri	Uri
    //   123	23	2	i	int
    //   132	27	3	j	int
    //   36	195	4	str	String
    //   238	9	5	localObject	Object
    //   249	1	5	localSQLiteException	SQLiteException
    //   259	141	5	localCursor	Cursor
    //   54	450	6	localAttachment	Attachment
    //   28	435	7	localContentResolver	ContentResolver
    // Exception table:
    //   from	to	target	type
    //   115	167	238	finally
    //   167	173	249	android/database/sqlite/SQLiteException
    //   240	249	249	android/database/sqlite/SQLiteException
    //   251	261	386	finally
    //   269	279	386	finally
    //   282	304	386	finally
    //   319	329	416	finally
    //   337	347	416	finally
    //   350	371	416	finally
    //   402	413	416	finally
    //   87	111	429	java/lang/SecurityException
    //   167	173	429	java/lang/SecurityException
    //   240	249	429	java/lang/SecurityException
    //   211	228	441	java/io/FileNotFoundException
    //   87	111	514	android/database/sqlite/SQLiteException
  }
  
  public static String a(Context paramContext, long paramLong)
  {
    if (paramLong == 0L) {
      return "";
    }
    if (paramLong < 1024L) {
      return paramContext.getString(buj.Q, new Object[] { String.valueOf(paramLong) });
    }
    if (paramLong < 1048576L)
    {
      paramLong /= 1024L;
      return paramContext.getString(buj.cK, new Object[] { String.valueOf(paramLong) });
    }
    String str = new DecimalFormat("0.#").format((float)paramLong / 1048576.0F);
    return paramContext.getString(buj.cY, new Object[] { str });
  }
  
  /* Error */
  public static String a(Context paramContext, Attachment paramAttachment, android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 277	android/content/Context:getCacheDir	()Ljava/io/File;
    //   4: astore 16
    //   6: aload 16
    //   8: invokevirtual 282	java/io/File:getTotalSpace	()J
    //   11: lstore 4
    //   13: aload_1
    //   14: getfield 165	com/android/mail/providers/Attachment:d	I
    //   17: ifle +62 -> 79
    //   20: aload 16
    //   22: invokevirtual 285	java/io/File:getUsableSpace	()J
    //   25: aload_1
    //   26: getfield 165	com/android/mail/providers/Attachment:d	I
    //   29: i2l
    //   30: lsub
    //   31: lstore 6
    //   33: lload 4
    //   35: lload 6
    //   37: invokestatic 288	ctr:a	(JJ)Z
    //   40: ifeq +39 -> 79
    //   43: getstatic 13	ctr:a	Ljava/lang/String;
    //   46: ldc_w 290
    //   49: iconst_3
    //   50: anewarray 4	java/lang/Object
    //   53: dup
    //   54: iconst_0
    //   55: lload 6
    //   57: invokestatic 295	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   60: aastore
    //   61: dup
    //   62: iconst_1
    //   63: lload 4
    //   65: invokestatic 295	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   68: aastore
    //   69: dup
    //   70: iconst_2
    //   71: aload_1
    //   72: aastore
    //   73: invokestatic 50	cvm:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   76: pop
    //   77: aconst_null
    //   78: areturn
    //   79: aconst_null
    //   80: astore 15
    //   82: aconst_null
    //   83: astore 11
    //   85: aconst_null
    //   86: astore 12
    //   88: aconst_null
    //   89: astore 14
    //   91: aconst_null
    //   92: astore 13
    //   94: aconst_null
    //   95: astore 10
    //   97: aconst_null
    //   98: astore 9
    //   100: new 297	java/text/SimpleDateFormat
    //   103: dup
    //   104: ldc_w 299
    //   107: invokespecial 300	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   110: new 302	java/util/Date
    //   113: dup
    //   114: invokespecial 303	java/util/Date:<init>	()V
    //   117: invokevirtual 306	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   120: ldc_w 308
    //   123: aload 16
    //   125: invokestatic 312	java/io/File:createTempFile	(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)Ljava/io/File;
    //   128: astore 8
    //   130: aload_2
    //   131: ifnull +209 -> 340
    //   134: aload 8
    //   136: astore 9
    //   138: aload 8
    //   140: astore 10
    //   142: aload_1
    //   143: getfield 168	com/android/mail/providers/Attachment:i	Landroid/net/Uri;
    //   146: ifnull +194 -> 340
    //   149: aload 8
    //   151: astore 9
    //   153: aload 8
    //   155: astore 10
    //   157: aload_2
    //   158: aload_1
    //   159: getfield 168	com/android/mail/providers/Attachment:i	Landroid/net/Uri;
    //   162: invokevirtual 315	android/net/Uri:toString	()Ljava/lang/String;
    //   165: invokevirtual 321	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   168: checkcast 29	android/os/ParcelFileDescriptor
    //   171: astore_2
    //   172: aload_2
    //   173: ifnull +172 -> 345
    //   176: aload 8
    //   178: astore 9
    //   180: aload 8
    //   182: astore 10
    //   184: new 323	java/io/FileInputStream
    //   187: dup
    //   188: aload_2
    //   189: invokevirtual 327	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   192: invokespecial 330	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   195: astore_0
    //   196: aload 14
    //   198: astore 11
    //   200: aload_0
    //   201: astore 10
    //   203: new 332	java/io/FileOutputStream
    //   206: dup
    //   207: aload 8
    //   209: invokespecial 335	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   212: astore_2
    //   213: invokestatic 340	android/os/SystemClock:elapsedRealtime	()J
    //   216: lstore 6
    //   218: sipush 1024
    //   221: newarray <illegal type>
    //   223: astore 9
    //   225: aload_0
    //   226: aload 9
    //   228: invokevirtual 346	java/io/InputStream:read	([B)I
    //   231: istore_3
    //   232: iload_3
    //   233: ifle +195 -> 428
    //   236: aload_2
    //   237: aload 9
    //   239: iconst_0
    //   240: iload_3
    //   241: invokevirtual 350	java/io/FileOutputStream:write	([BII)V
    //   244: invokestatic 340	android/os/SystemClock:elapsedRealtime	()J
    //   247: lload 6
    //   249: lsub
    //   250: ldc2_w 351
    //   253: lcmp
    //   254: ifle -29 -> 225
    //   257: new 19	java/io/IOException
    //   260: dup
    //   261: ldc_w 354
    //   264: invokespecial 355	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   267: athrow
    //   268: astore 10
    //   270: aload_2
    //   271: astore 9
    //   273: aload 10
    //   275: astore_2
    //   276: aload 9
    //   278: astore 11
    //   280: aload_0
    //   281: astore 10
    //   283: getstatic 13	ctr:a	Ljava/lang/String;
    //   286: aload_2
    //   287: ldc_w 357
    //   290: iconst_1
    //   291: anewarray 4	java/lang/Object
    //   294: dup
    //   295: iconst_0
    //   296: aload_1
    //   297: aastore
    //   298: invokestatic 228	cvm:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   301: pop
    //   302: aload 8
    //   304: ifnull +16 -> 320
    //   307: aload 9
    //   309: astore 11
    //   311: aload_0
    //   312: astore 10
    //   314: aload 8
    //   316: invokevirtual 360	java/io/File:delete	()Z
    //   319: pop
    //   320: aload_0
    //   321: ifnull +7 -> 328
    //   324: aload_0
    //   325: invokevirtual 361	java/io/InputStream:close	()V
    //   328: aload 9
    //   330: ifnull +8 -> 338
    //   333: aload 9
    //   335: invokevirtual 362	java/io/FileOutputStream:close	()V
    //   338: aconst_null
    //   339: areturn
    //   340: aconst_null
    //   341: astore_2
    //   342: goto -170 -> 172
    //   345: aload 8
    //   347: astore 9
    //   349: aload 8
    //   351: astore 10
    //   353: aload_1
    //   354: getfield 168	com/android/mail/providers/Attachment:i	Landroid/net/Uri;
    //   357: ifnonnull +48 -> 405
    //   360: aload 8
    //   362: astore 9
    //   364: aload 8
    //   366: astore 10
    //   368: getstatic 13	ctr:a	Ljava/lang/String;
    //   371: ldc_w 364
    //   374: iconst_1
    //   375: anewarray 4	java/lang/Object
    //   378: dup
    //   379: iconst_0
    //   380: aload_1
    //   381: aastore
    //   382: invokestatic 366	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   385: pop
    //   386: aload 8
    //   388: astore 9
    //   390: aload 8
    //   392: astore 10
    //   394: new 17	java/io/FileNotFoundException
    //   397: dup
    //   398: ldc_w 368
    //   401: invokespecial 369	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   404: athrow
    //   405: aload 8
    //   407: astore 9
    //   409: aload 8
    //   411: astore 10
    //   413: aload_0
    //   414: invokevirtual 145	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   417: aload_1
    //   418: getfield 168	com/android/mail/providers/Attachment:i	Landroid/net/Uri;
    //   421: invokevirtual 373	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   424: astore_0
    //   425: goto -229 -> 196
    //   428: aload_2
    //   429: invokevirtual 376	java/io/FileOutputStream:flush	()V
    //   432: aload 8
    //   434: invokevirtual 379	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   437: astore 9
    //   439: getstatic 13	ctr:a	Ljava/lang/String;
    //   442: ldc_w 381
    //   445: iconst_2
    //   446: anewarray 4	java/lang/Object
    //   449: dup
    //   450: iconst_0
    //   451: aload_1
    //   452: getfield 168	com/android/mail/providers/Attachment:i	Landroid/net/Uri;
    //   455: aastore
    //   456: dup
    //   457: iconst_1
    //   458: aload 9
    //   460: aastore
    //   461: invokestatic 366	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   464: pop
    //   465: aload 16
    //   467: invokevirtual 285	java/io/File:getUsableSpace	()J
    //   470: lstore 6
    //   472: lload 4
    //   474: lload 6
    //   476: invokestatic 288	ctr:a	(JJ)Z
    //   479: ifeq +46 -> 525
    //   482: aload 8
    //   484: invokevirtual 360	java/io/File:delete	()Z
    //   487: pop
    //   488: getstatic 13	ctr:a	Ljava/lang/String;
    //   491: ldc_w 290
    //   494: iconst_3
    //   495: anewarray 4	java/lang/Object
    //   498: dup
    //   499: iconst_0
    //   500: lload 6
    //   502: invokestatic 295	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   505: aastore
    //   506: dup
    //   507: iconst_1
    //   508: lload 4
    //   510: invokestatic 295	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   513: aastore
    //   514: dup
    //   515: iconst_2
    //   516: aload_1
    //   517: aastore
    //   518: invokestatic 50	cvm:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   521: pop
    //   522: aconst_null
    //   523: astore 9
    //   525: aload_0
    //   526: ifnull +7 -> 533
    //   529: aload_0
    //   530: invokevirtual 361	java/io/InputStream:close	()V
    //   533: aload_2
    //   534: invokevirtual 362	java/io/FileOutputStream:close	()V
    //   537: aload 9
    //   539: areturn
    //   540: astore_0
    //   541: getstatic 13	ctr:a	Ljava/lang/String;
    //   544: aload_0
    //   545: ldc_w 383
    //   548: iconst_0
    //   549: anewarray 4	java/lang/Object
    //   552: invokestatic 55	cvm:d	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   555: pop
    //   556: aload 9
    //   558: areturn
    //   559: astore_0
    //   560: getstatic 13	ctr:a	Ljava/lang/String;
    //   563: aload_0
    //   564: ldc_w 383
    //   567: iconst_0
    //   568: anewarray 4	java/lang/Object
    //   571: invokestatic 55	cvm:d	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   574: pop
    //   575: goto -237 -> 338
    //   578: astore_1
    //   579: aconst_null
    //   580: astore_0
    //   581: aload_0
    //   582: ifnull +7 -> 589
    //   585: aload_0
    //   586: invokevirtual 361	java/io/InputStream:close	()V
    //   589: aload 11
    //   591: ifnull +8 -> 599
    //   594: aload 11
    //   596: invokevirtual 362	java/io/FileOutputStream:close	()V
    //   599: aload_1
    //   600: athrow
    //   601: astore_0
    //   602: getstatic 13	ctr:a	Ljava/lang/String;
    //   605: aload_0
    //   606: ldc_w 383
    //   609: iconst_0
    //   610: anewarray 4	java/lang/Object
    //   613: invokestatic 55	cvm:d	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   616: pop
    //   617: goto -18 -> 599
    //   620: astore_2
    //   621: aload 15
    //   623: astore_0
    //   624: aload 12
    //   626: astore 10
    //   628: aload 9
    //   630: astore 8
    //   632: aload 10
    //   634: astore 9
    //   636: goto -360 -> 276
    //   639: astore_1
    //   640: aload 10
    //   642: astore_0
    //   643: goto -62 -> 581
    //   646: astore_1
    //   647: aload_2
    //   648: astore 11
    //   650: goto -69 -> 581
    //   653: astore_2
    //   654: aload 13
    //   656: astore 9
    //   658: goto -382 -> 276
    //   661: astore_2
    //   662: aload 12
    //   664: astore 10
    //   666: goto -34 -> 632
    //   669: astore 9
    //   671: aload_2
    //   672: astore 10
    //   674: aload 9
    //   676: astore_2
    //   677: goto -45 -> 632
    //   680: astore_2
    //   681: aconst_null
    //   682: astore_0
    //   683: aload 10
    //   685: astore 8
    //   687: aload 13
    //   689: astore 9
    //   691: goto -415 -> 276
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	694	0	paramContext	Context
    //   0	694	1	paramAttachment	Attachment
    //   0	694	2	paramBundle	android.os.Bundle
    //   231	10	3	i	int
    //   11	498	4	l1	long
    //   31	470	6	l2	long
    //   128	558	8	localObject1	Object
    //   98	559	9	localObject2	Object
    //   669	6	9	localSecurityException	SecurityException
    //   689	1	9	localObject3	Object
    //   95	107	10	localObject4	Object
    //   268	6	10	localIOException	IOException
    //   281	403	10	localObject5	Object
    //   83	566	11	localObject6	Object
    //   86	577	12	localObject7	Object
    //   92	596	13	localObject8	Object
    //   89	108	14	localObject9	Object
    //   80	542	15	localObject10	Object
    //   4	462	16	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   213	225	268	java/io/IOException
    //   225	232	268	java/io/IOException
    //   236	268	268	java/io/IOException
    //   428	472	268	java/io/IOException
    //   472	522	268	java/io/IOException
    //   529	533	540	java/io/IOException
    //   533	537	540	java/io/IOException
    //   324	328	559	java/io/IOException
    //   333	338	559	java/io/IOException
    //   100	130	578	finally
    //   142	149	578	finally
    //   157	172	578	finally
    //   184	196	578	finally
    //   353	360	578	finally
    //   368	386	578	finally
    //   394	405	578	finally
    //   413	425	578	finally
    //   585	589	601	java/io/IOException
    //   594	599	601	java/io/IOException
    //   100	130	620	java/lang/SecurityException
    //   142	149	620	java/lang/SecurityException
    //   157	172	620	java/lang/SecurityException
    //   184	196	620	java/lang/SecurityException
    //   353	360	620	java/lang/SecurityException
    //   368	386	620	java/lang/SecurityException
    //   394	405	620	java/lang/SecurityException
    //   413	425	620	java/lang/SecurityException
    //   203	213	639	finally
    //   283	302	639	finally
    //   314	320	639	finally
    //   213	225	646	finally
    //   225	232	646	finally
    //   236	268	646	finally
    //   428	472	646	finally
    //   472	522	646	finally
    //   203	213	653	java/io/IOException
    //   203	213	661	java/lang/SecurityException
    //   213	225	669	java/lang/SecurityException
    //   225	232	669	java/lang/SecurityException
    //   236	268	669	java/lang/SecurityException
    //   428	472	669	java/lang/SecurityException
    //   472	522	669	java/lang/SecurityException
    //   100	130	680	java/io/IOException
    //   142	149	680	java/io/IOException
    //   157	172	680	java/io/IOException
    //   184	196	680	java/io/IOException
    //   353	360	680	java/io/IOException
    //   368	386	680	java/io/IOException
    //   394	405	680	java/io/IOException
    //   413	425	680	java/io/IOException
  }
  
  private static boolean a(long paramLong1, long paramLong2)
  {
    return (float)paramLong2 < Math.min((float)paramLong1 * 0.25F, 1.048576E8F);
  }
  
  public static boolean a(Context paramContext, Attachment paramAttachment)
  {
    if ((paramAttachment != null) && ((l & 0x200) != 0)) {
      return false;
    }
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if (localNetworkInfo == null) {
      return false;
    }
    if (localNetworkInfo.isConnected())
    {
      if (localNetworkInfo.getType() != 0) {
        return true;
      }
      paramContext = DownloadManager.getMaxBytesOverMobile(paramContext);
      return (paramContext == null) || (paramAttachment == null) || (d <= paramContext.longValue());
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     ctr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */