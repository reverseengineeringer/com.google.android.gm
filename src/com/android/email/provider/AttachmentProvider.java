package com.android.email.provider;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Binder;
import bbw;
import com.android.emailcommon.provider.Attachment;
import cvm;
import cvp;
import java.io.File;
import java.io.InputStream;
import java.util.List;

public class AttachmentProvider
  extends ContentProvider
{
  private static final String[] a = { "mimeType", "fileName" };
  private static final String[] b = { "fileName", "size", "contentUri" };
  
  private static Bitmap a(InputStream paramInputStream)
  {
    String str;
    try
    {
      paramInputStream = BitmapFactory.decodeStream(paramInputStream);
      return paramInputStream;
    }
    catch (OutOfMemoryError paramInputStream)
    {
      str = bbw.a;
      paramInputStream = String.valueOf(paramInputStream.getMessage());
      if (paramInputStream.length() != 0) {}
      for (paramInputStream = "createImageThumbnail failed with ".concat(paramInputStream);; paramInputStream = new String("createImageThumbnail failed with "))
      {
        cvm.b(str, paramInputStream, new Object[0]);
        return null;
      }
    }
    catch (Exception paramInputStream)
    {
      str = bbw.a;
      paramInputStream = String.valueOf(paramInputStream.getMessage());
      if (paramInputStream.length() == 0) {}
    }
    for (paramInputStream = "createImageThumbnail failed with ".concat(paramInputStream);; paramInputStream = new String("createImageThumbnail failed with "))
    {
      cvm.b(str, paramInputStream, new Object[0]);
      return null;
    }
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  /* Error */
  public String getType(Uri paramUri)
  {
    // Byte code:
    //   0: invokestatic 81	android/os/Binder:clearCallingIdentity	()J
    //   3: lstore_2
    //   4: aload_1
    //   5: invokevirtual 87	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   8: astore_1
    //   9: aload_1
    //   10: iconst_1
    //   11: invokeinterface 93 2 0
    //   16: checkcast 11	java/lang/String
    //   19: astore 4
    //   21: ldc 95
    //   23: aload_1
    //   24: iconst_2
    //   25: invokeinterface 93 2 0
    //   30: checkcast 11	java/lang/String
    //   33: invokevirtual 99	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   36: ifeq +10 -> 46
    //   39: lload_2
    //   40: invokestatic 103	android/os/Binder:restoreCallingIdentity	(J)V
    //   43: ldc 105
    //   45: areturn
    //   46: getstatic 110	com/android/emailcommon/provider/Attachment:a	Landroid/net/Uri;
    //   49: aload 4
    //   51: invokestatic 116	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   54: invokestatic 122	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   57: astore_1
    //   58: aload_0
    //   59: invokevirtual 126	com/android/email/provider/AttachmentProvider:getContext	()Landroid/content/Context;
    //   62: invokevirtual 132	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   65: aload_1
    //   66: getstatic 17	com/android/email/provider/AttachmentProvider:a	[Ljava/lang/String;
    //   69: aconst_null
    //   70: aconst_null
    //   71: aconst_null
    //   72: invokevirtual 138	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   75: astore_1
    //   76: aload_1
    //   77: invokeinterface 144 1 0
    //   82: ifeq +39 -> 121
    //   85: aload_1
    //   86: iconst_0
    //   87: invokeinterface 148 2 0
    //   92: astore 4
    //   94: aload_1
    //   95: iconst_1
    //   96: invokeinterface 148 2 0
    //   101: aload 4
    //   103: invokestatic 153	bgt:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   106: astore 4
    //   108: aload_1
    //   109: invokeinterface 156 1 0
    //   114: lload_2
    //   115: invokestatic 103	android/os/Binder:restoreCallingIdentity	(J)V
    //   118: aload 4
    //   120: areturn
    //   121: aload_1
    //   122: invokeinterface 156 1 0
    //   127: lload_2
    //   128: invokestatic 103	android/os/Binder:restoreCallingIdentity	(J)V
    //   131: aconst_null
    //   132: areturn
    //   133: astore 4
    //   135: aload_1
    //   136: invokeinterface 156 1 0
    //   141: aload 4
    //   143: athrow
    //   144: astore_1
    //   145: lload_2
    //   146: invokestatic 103	android/os/Binder:restoreCallingIdentity	(J)V
    //   149: aload_1
    //   150: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	AttachmentProvider
    //   0	151	1	paramUri	Uri
    //   3	143	2	l	long
    //   19	100	4	str	String
    //   133	9	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   76	108	133	finally
    //   4	39	144	finally
    //   46	76	144	finally
    //   108	114	144	finally
    //   121	127	144	finally
    //   135	144	144	finally
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    return null;
  }
  
  public boolean onCreate()
  {
    Object localObject1 = getContext().getCacheDir();
    if (localObject1 != null)
    {
      localObject1 = ((File)localObject1).listFiles();
      if (localObject1 != null)
      {
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          String str = ((File)localObject2).getName();
          if ((str.endsWith(".tmp")) || (str.startsWith("thmb_"))) {
            ((File)localObject2).delete();
          }
          i += 1;
        }
      }
    }
    return true;
  }
  
  /* Error */
  public android.os.ParcelFileDescriptor openFile(Uri paramUri, String paramString)
  {
    // Byte code:
    //   0: aload_2
    //   1: ldc -65
    //   3: invokevirtual 99	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6: ifeq +94 -> 100
    //   9: aload_0
    //   10: invokevirtual 126	com/android/email/provider/AttachmentProvider:getContext	()Landroid/content/Context;
    //   13: astore_2
    //   14: aload_2
    //   15: getstatic 196	bdv:O	Ljava/lang/String;
    //   18: invokevirtual 200	android/content/Context:checkCallingOrSelfPermission	(Ljava/lang/String;)I
    //   21: ifeq +11 -> 32
    //   24: new 202	java/io/FileNotFoundException
    //   27: dup
    //   28: invokespecial 203	java/io/FileNotFoundException:<init>	()V
    //   31: athrow
    //   32: aload_1
    //   33: invokevirtual 87	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   36: astore 7
    //   38: aload 7
    //   40: iconst_0
    //   41: invokeinterface 93 2 0
    //   46: checkcast 11	java/lang/String
    //   49: astore_1
    //   50: aload 7
    //   52: iconst_1
    //   53: invokeinterface 93 2 0
    //   58: checkcast 11	java/lang/String
    //   61: astore 7
    //   63: aload_2
    //   64: aload_1
    //   65: invokestatic 116	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   68: invokestatic 206	bgt:a	(Landroid/content/Context;J)Ljava/io/File;
    //   71: astore_1
    //   72: aload_1
    //   73: invokevirtual 209	java/io/File:exists	()Z
    //   76: ifne +8 -> 84
    //   79: aload_1
    //   80: invokevirtual 212	java/io/File:mkdirs	()Z
    //   83: pop
    //   84: new 165	java/io/File
    //   87: dup
    //   88: aload_1
    //   89: aload 7
    //   91: invokespecial 215	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   94: ldc -40
    //   96: invokestatic 222	android/os/ParcelFileDescriptor:open	(Ljava/io/File;I)Landroid/os/ParcelFileDescriptor;
    //   99: areturn
    //   100: invokestatic 81	android/os/Binder:clearCallingIdentity	()J
    //   103: lstore 5
    //   105: aload_1
    //   106: invokevirtual 87	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   109: astore_2
    //   110: aload_2
    //   111: iconst_0
    //   112: invokeinterface 93 2 0
    //   117: checkcast 11	java/lang/String
    //   120: astore_1
    //   121: aload_2
    //   122: iconst_1
    //   123: invokeinterface 93 2 0
    //   128: checkcast 11	java/lang/String
    //   131: astore 7
    //   133: ldc 95
    //   135: aload_2
    //   136: iconst_2
    //   137: invokeinterface 93 2 0
    //   142: checkcast 11	java/lang/String
    //   145: invokevirtual 99	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   148: ifeq +435 -> 583
    //   151: aload_2
    //   152: iconst_3
    //   153: invokeinterface 93 2 0
    //   158: checkcast 11	java/lang/String
    //   161: invokestatic 227	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   164: istore_3
    //   165: aload_2
    //   166: iconst_4
    //   167: invokeinterface 93 2 0
    //   172: checkcast 11	java/lang/String
    //   175: invokestatic 227	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   178: istore 4
    //   180: new 229	java/lang/StringBuilder
    //   183: dup
    //   184: aload_1
    //   185: invokestatic 50	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   188: invokevirtual 54	java/lang/String:length	()I
    //   191: bipush 6
    //   193: iadd
    //   194: aload 7
    //   196: invokestatic 50	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   199: invokevirtual 54	java/lang/String:length	()I
    //   202: iadd
    //   203: invokespecial 232	java/lang/StringBuilder:<init>	(I)V
    //   206: ldc -76
    //   208: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: aload_1
    //   212: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: ldc -18
    //   217: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: aload 7
    //   222: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: astore_2
    //   229: new 165	java/io/File
    //   232: dup
    //   233: aload_0
    //   234: invokevirtual 126	com/android/email/provider/AttachmentProvider:getContext	()Landroid/content/Context;
    //   237: invokevirtual 163	android/content/Context:getCacheDir	()Ljava/io/File;
    //   240: aload_2
    //   241: invokespecial 215	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   244: astore_2
    //   245: aload_2
    //   246: invokevirtual 209	java/io/File:exists	()Z
    //   249: ifne +201 -> 450
    //   252: aload_1
    //   253: invokestatic 116	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   256: aload 7
    //   258: invokestatic 116	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   261: invokestatic 244	bgt:a	(JJ)Landroid/net/Uri;
    //   264: astore_1
    //   265: aload_0
    //   266: aload_1
    //   267: iconst_1
    //   268: anewarray 11	java/lang/String
    //   271: dup
    //   272: iconst_0
    //   273: ldc -10
    //   275: aastore
    //   276: aconst_null
    //   277: aconst_null
    //   278: aconst_null
    //   279: invokevirtual 247	com/android/email/provider/AttachmentProvider:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   282: astore 7
    //   284: aload 7
    //   286: ifnull +32 -> 318
    //   289: aload 7
    //   291: invokeinterface 144 1 0
    //   296: ifeq +76 -> 372
    //   299: aload 7
    //   301: iconst_0
    //   302: invokeinterface 148 2 0
    //   307: invokestatic 251	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   310: astore_1
    //   311: aload 7
    //   313: invokeinterface 156 1 0
    //   318: aload_0
    //   319: invokevirtual 126	com/android/email/provider/AttachmentProvider:getContext	()Landroid/content/Context;
    //   322: invokevirtual 132	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   325: aload_1
    //   326: invokevirtual 253	android/content/ContentResolver:getType	(Landroid/net/Uri;)Ljava/lang/String;
    //   329: astore 8
    //   331: aload_0
    //   332: invokevirtual 126	com/android/email/provider/AttachmentProvider:getContext	()Landroid/content/Context;
    //   335: invokevirtual 132	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   338: aload_1
    //   339: invokevirtual 257	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   342: astore 7
    //   344: aload 8
    //   346: ldc_w 259
    //   349: invokestatic 264	bco:b	(Ljava/lang/String;Ljava/lang/String;)Z
    //   352: ifeq +52 -> 404
    //   355: aload 7
    //   357: invokestatic 266	com/android/email/provider/AttachmentProvider:a	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   360: astore_1
    //   361: aload_1
    //   362: ifnonnull +47 -> 409
    //   365: lload 5
    //   367: invokestatic 103	android/os/Binder:restoreCallingIdentity	(J)V
    //   370: aconst_null
    //   371: areturn
    //   372: aload 7
    //   374: invokeinterface 156 1 0
    //   379: lload 5
    //   381: invokestatic 103	android/os/Binder:restoreCallingIdentity	(J)V
    //   384: aconst_null
    //   385: areturn
    //   386: astore_1
    //   387: aload 7
    //   389: invokeinterface 156 1 0
    //   394: aload_1
    //   395: athrow
    //   396: astore_1
    //   397: lload 5
    //   399: invokestatic 103	android/os/Binder:restoreCallingIdentity	(J)V
    //   402: aload_1
    //   403: athrow
    //   404: aconst_null
    //   405: astore_1
    //   406: goto -45 -> 361
    //   409: aload_1
    //   410: iload_3
    //   411: iload 4
    //   413: iconst_1
    //   414: invokestatic 272	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   417: astore_1
    //   418: new 274	java/io/FileOutputStream
    //   421: dup
    //   422: aload_2
    //   423: invokespecial 277	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   426: astore 8
    //   428: aload_1
    //   429: getstatic 283	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   432: bipush 100
    //   434: aload 8
    //   436: invokevirtual 287	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   439: pop
    //   440: aload 8
    //   442: invokevirtual 288	java/io/FileOutputStream:close	()V
    //   445: aload 7
    //   447: invokevirtual 291	java/io/InputStream:close	()V
    //   450: aload_2
    //   451: ldc_w 292
    //   454: invokestatic 222	android/os/ParcelFileDescriptor:open	(Ljava/io/File;I)Landroid/os/ParcelFileDescriptor;
    //   457: astore_1
    //   458: lload 5
    //   460: invokestatic 103	android/os/Binder:restoreCallingIdentity	(J)V
    //   463: aload_1
    //   464: areturn
    //   465: astore_1
    //   466: getstatic 42	bbw:a	Ljava/lang/String;
    //   469: astore_2
    //   470: aload_1
    //   471: invokevirtual 293	java/io/IOException:getMessage	()Ljava/lang/String;
    //   474: invokestatic 50	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   477: astore_1
    //   478: aload_1
    //   479: invokevirtual 54	java/lang/String:length	()I
    //   482: ifeq +28 -> 510
    //   485: ldc_w 295
    //   488: aload_1
    //   489: invokevirtual 60	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   492: astore_1
    //   493: aload_2
    //   494: aload_1
    //   495: iconst_0
    //   496: anewarray 62	java/lang/Object
    //   499: invokestatic 67	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   502: pop
    //   503: lload 5
    //   505: invokestatic 103	android/os/Binder:restoreCallingIdentity	(J)V
    //   508: aconst_null
    //   509: areturn
    //   510: new 11	java/lang/String
    //   513: dup
    //   514: ldc_w 295
    //   517: invokespecial 70	java/lang/String:<init>	(Ljava/lang/String;)V
    //   520: astore_1
    //   521: goto -28 -> 493
    //   524: astore_1
    //   525: getstatic 42	bbw:a	Ljava/lang/String;
    //   528: astore_2
    //   529: aload_1
    //   530: invokevirtual 46	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   533: invokestatic 50	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   536: astore_1
    //   537: aload_1
    //   538: invokevirtual 54	java/lang/String:length	()I
    //   541: ifeq +28 -> 569
    //   544: ldc_w 295
    //   547: aload_1
    //   548: invokevirtual 60	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   551: astore_1
    //   552: aload_2
    //   553: aload_1
    //   554: iconst_0
    //   555: anewarray 62	java/lang/Object
    //   558: invokestatic 67	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   561: pop
    //   562: lload 5
    //   564: invokestatic 103	android/os/Binder:restoreCallingIdentity	(J)V
    //   567: aconst_null
    //   568: areturn
    //   569: new 11	java/lang/String
    //   572: dup
    //   573: ldc_w 295
    //   576: invokespecial 70	java/lang/String:<init>	(Ljava/lang/String;)V
    //   579: astore_1
    //   580: goto -28 -> 552
    //   583: new 165	java/io/File
    //   586: dup
    //   587: aload_0
    //   588: invokevirtual 126	com/android/email/provider/AttachmentProvider:getContext	()Landroid/content/Context;
    //   591: aload_1
    //   592: invokestatic 50	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   595: ldc_w 297
    //   598: invokevirtual 60	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   601: invokevirtual 301	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   604: aload 7
    //   606: invokespecial 215	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   609: ldc_w 292
    //   612: invokestatic 222	android/os/ParcelFileDescriptor:open	(Ljava/io/File;I)Landroid/os/ParcelFileDescriptor;
    //   615: astore_1
    //   616: lload 5
    //   618: invokestatic 103	android/os/Binder:restoreCallingIdentity	(J)V
    //   621: aload_1
    //   622: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	623	0	this	AttachmentProvider
    //   0	623	1	paramUri	Uri
    //   0	623	2	paramString	String
    //   164	247	3	i	int
    //   178	234	4	j	int
    //   103	514	5	l	long
    //   36	569	7	localObject1	Object
    //   329	112	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   289	311	386	finally
    //   105	284	396	finally
    //   311	318	396	finally
    //   318	331	396	finally
    //   331	361	396	finally
    //   372	379	396	finally
    //   387	396	396	finally
    //   409	450	396	finally
    //   450	458	396	finally
    //   466	493	396	finally
    //   493	503	396	finally
    //   510	521	396	finally
    //   525	552	396	finally
    //   552	562	396	finally
    //   569	580	396	finally
    //   583	616	396	finally
    //   331	361	465	java/io/IOException
    //   409	450	465	java/io/IOException
    //   331	361	524	java/lang/OutOfMemoryError
    //   409	450	524	java/lang/OutOfMemoryError
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    long l = Binder.clearCallingIdentity();
    paramString1 = paramArrayOfString1;
    if (paramArrayOfString1 == null) {}
    for (;;)
    {
      int j;
      Object[] arrayOfObject;
      int i;
      Object localObject;
      try
      {
        paramString1 = new String[4];
        paramString1[0] = "_id";
        paramString1[1] = "_data";
        paramString1[2] = "_display_name";
        paramString1[3] = "_size";
        paramArrayOfString1 = paramUri.getPathSegments();
        paramArrayOfString1.get(0);
        paramUri = (String)paramArrayOfString1.get(1);
        paramArrayOfString1.get(2);
        paramArrayOfString1 = ContentUris.withAppendedId(Attachment.a, Long.parseLong(paramUri));
        paramString2 = getContext().getContentResolver().query(paramArrayOfString1, b, null, null, null);
        try
        {
          if (paramString2.moveToFirst())
          {
            paramArrayOfString1 = paramString2.getString(0);
            j = paramString2.getInt(1);
            paramArrayOfString2 = paramString2.getString(2);
            paramString2.close();
            paramString2 = new cvp(paramString1);
            arrayOfObject = new Object[paramString1.length];
            i = 0;
            int k = paramString1.length;
            if (i >= k) {
              break label300;
            }
            localObject = paramString1[i];
            if ("_id".equals(localObject))
            {
              arrayOfObject[i] = paramUri;
              break label315;
            }
          }
          else
          {
            paramString2.close();
            return null;
          }
        }
        finally
        {
          paramString2.close();
        }
        if (!"_data".equals(localObject)) {
          break label256;
        }
      }
      finally
      {
        Binder.restoreCallingIdentity(l);
      }
      arrayOfObject[i] = paramArrayOfString2;
      break label315;
      label256:
      if ("_display_name".equals(localObject))
      {
        arrayOfObject[i] = paramArrayOfString1;
      }
      else if ("_size".equals(localObject))
      {
        arrayOfObject[i] = Integer.valueOf(j);
        break label315;
        label300:
        paramString2.addRow(arrayOfObject);
        Binder.restoreCallingIdentity(l);
        return paramString2;
      }
      label315:
      i += 1;
    }
  }
  
  public void shutdown() {}
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}

/* Location:
 * Qualified Name:     com.android.email.provider.AttachmentProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */