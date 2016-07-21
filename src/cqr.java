import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import com.android.mail.providers.Attachment;
import java.io.IOException;
import java.io.InputStream;

public final class cqr
  extends AsyncTask<Uri, Void, Bitmap>
{
  private static final String a = cvl.a;
  private final cki b;
  private final int c;
  private final int d;
  
  private cqr(cki paramcki, int paramInt1, int paramInt2)
  {
    b = paramcki;
    c = paramInt1;
    d = paramInt2;
  }
  
  /* Error */
  private final Bitmap a(Uri paramUri)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +20 -> 21
    //   4: getstatic 19	cqr:a	Ljava/lang/String;
    //   7: ldc 37
    //   9: iconst_0
    //   10: anewarray 39	java/lang/Object
    //   13: invokestatic 45	cvm:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   16: pop
    //   17: aconst_null
    //   18: astore_1
    //   19: aload_1
    //   20: areturn
    //   21: aload_0
    //   22: aload_1
    //   23: invokespecial 48	cqr:b	(Landroid/net/Uri;)I
    //   26: istore_2
    //   27: aload_0
    //   28: getfield 26	cqr:b	Lcki;
    //   31: invokeinterface 54 1 0
    //   36: aload_1
    //   37: ldc 56
    //   39: invokevirtual 62	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   42: astore 5
    //   44: aload_0
    //   45: invokevirtual 66	cqr:isCancelled	()Z
    //   48: istore 4
    //   50: iload 4
    //   52: ifne +8 -> 60
    //   55: aload 5
    //   57: ifnonnull +33 -> 90
    //   60: aload 5
    //   62: ifnull +8 -> 70
    //   65: aload 5
    //   67: invokevirtual 71	android/content/res/AssetFileDescriptor:close	()V
    //   70: aconst_null
    //   71: areturn
    //   72: astore_1
    //   73: getstatic 19	cqr:a	Ljava/lang/String;
    //   76: aload_1
    //   77: ldc 73
    //   79: iconst_0
    //   80: anewarray 39	java/lang/Object
    //   83: invokestatic 76	cvm:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   86: pop
    //   87: goto -17 -> 70
    //   90: new 78	android/graphics/BitmapFactory$Options
    //   93: dup
    //   94: invokespecial 79	android/graphics/BitmapFactory$Options:<init>	()V
    //   97: astore 6
    //   99: aload 6
    //   101: iconst_1
    //   102: putfield 83	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   105: aload 6
    //   107: bipush 120
    //   109: putfield 86	android/graphics/BitmapFactory$Options:inDensity	I
    //   112: aload 5
    //   114: invokevirtual 90	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   117: aconst_null
    //   118: aload 6
    //   120: invokestatic 96	android/graphics/BitmapFactory:decodeFileDescriptor	(Ljava/io/FileDescriptor;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   123: pop
    //   124: aload_0
    //   125: invokevirtual 66	cqr:isCancelled	()Z
    //   128: ifne +23 -> 151
    //   131: aload 6
    //   133: getfield 99	android/graphics/BitmapFactory$Options:outWidth	I
    //   136: iconst_m1
    //   137: if_icmpeq +14 -> 151
    //   140: aload 6
    //   142: getfield 102	android/graphics/BitmapFactory$Options:outHeight	I
    //   145: istore_3
    //   146: iload_3
    //   147: iconst_m1
    //   148: if_icmpne +33 -> 181
    //   151: aload 5
    //   153: ifnull +8 -> 161
    //   156: aload 5
    //   158: invokevirtual 71	android/content/res/AssetFileDescriptor:close	()V
    //   161: aconst_null
    //   162: areturn
    //   163: astore_1
    //   164: getstatic 19	cqr:a	Ljava/lang/String;
    //   167: aload_1
    //   168: ldc 73
    //   170: iconst_0
    //   171: anewarray 39	java/lang/Object
    //   174: invokestatic 76	cvm:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   177: pop
    //   178: goto -17 -> 161
    //   181: aload 6
    //   183: iconst_0
    //   184: putfield 83	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   187: aload 6
    //   189: aload 6
    //   191: getfield 99	android/graphics/BitmapFactory$Options:outWidth	I
    //   194: aload_0
    //   195: getfield 28	cqr:c	I
    //   198: idiv
    //   199: iconst_1
    //   200: invokestatic 108	java/lang/Math:max	(II)I
    //   203: aload 6
    //   205: getfield 102	android/graphics/BitmapFactory$Options:outHeight	I
    //   208: aload_0
    //   209: getfield 30	cqr:d	I
    //   212: idiv
    //   213: iconst_1
    //   214: invokestatic 108	java/lang/Math:max	(II)I
    //   217: invokestatic 111	java/lang/Math:min	(II)I
    //   220: putfield 114	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   223: getstatic 19	cqr:a	Ljava/lang/String;
    //   226: ldc 116
    //   228: iconst_5
    //   229: anewarray 39	java/lang/Object
    //   232: dup
    //   233: iconst_0
    //   234: aload 6
    //   236: getfield 99	android/graphics/BitmapFactory$Options:outWidth	I
    //   239: invokestatic 122	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   242: aastore
    //   243: dup
    //   244: iconst_1
    //   245: aload 6
    //   247: getfield 102	android/graphics/BitmapFactory$Options:outHeight	I
    //   250: invokestatic 122	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   253: aastore
    //   254: dup
    //   255: iconst_2
    //   256: aload_0
    //   257: getfield 28	cqr:c	I
    //   260: invokestatic 122	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   263: aastore
    //   264: dup
    //   265: iconst_3
    //   266: aload_0
    //   267: getfield 30	cqr:d	I
    //   270: invokestatic 122	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   273: aastore
    //   274: dup
    //   275: iconst_4
    //   276: aload 6
    //   278: getfield 114	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   281: invokestatic 122	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   284: aastore
    //   285: invokestatic 124	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   288: pop
    //   289: aload 5
    //   291: invokevirtual 90	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   294: aconst_null
    //   295: aload 6
    //   297: invokestatic 96	android/graphics/BitmapFactory:decodeFileDescriptor	(Ljava/io/FileDescriptor;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   300: astore 6
    //   302: aload 6
    //   304: ifnull +80 -> 384
    //   307: iload_2
    //   308: ifeq +76 -> 384
    //   311: new 126	android/graphics/Matrix
    //   314: dup
    //   315: invokespecial 127	android/graphics/Matrix:<init>	()V
    //   318: astore 7
    //   320: aload 7
    //   322: iload_2
    //   323: i2f
    //   324: invokevirtual 131	android/graphics/Matrix:postRotate	(F)Z
    //   327: pop
    //   328: aload 6
    //   330: iconst_0
    //   331: iconst_0
    //   332: aload 6
    //   334: invokevirtual 137	android/graphics/Bitmap:getWidth	()I
    //   337: aload 6
    //   339: invokevirtual 140	android/graphics/Bitmap:getHeight	()I
    //   342: aload 7
    //   344: iconst_1
    //   345: invokestatic 144	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   348: astore 6
    //   350: aload 6
    //   352: astore_1
    //   353: aload 5
    //   355: ifnull -336 -> 19
    //   358: aload 5
    //   360: invokevirtual 71	android/content/res/AssetFileDescriptor:close	()V
    //   363: aload 6
    //   365: areturn
    //   366: astore_1
    //   367: getstatic 19	cqr:a	Ljava/lang/String;
    //   370: aload_1
    //   371: ldc 73
    //   373: iconst_0
    //   374: anewarray 39	java/lang/Object
    //   377: invokestatic 76	cvm:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   380: pop
    //   381: aload 6
    //   383: areturn
    //   384: aload 6
    //   386: astore_1
    //   387: aload 5
    //   389: ifnull -370 -> 19
    //   392: aload 5
    //   394: invokevirtual 71	android/content/res/AssetFileDescriptor:close	()V
    //   397: aload 6
    //   399: areturn
    //   400: astore_1
    //   401: getstatic 19	cqr:a	Ljava/lang/String;
    //   404: aload_1
    //   405: ldc 73
    //   407: iconst_0
    //   408: anewarray 39	java/lang/Object
    //   411: invokestatic 76	cvm:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   414: pop
    //   415: aload 6
    //   417: areturn
    //   418: astore 6
    //   420: aconst_null
    //   421: astore 5
    //   423: getstatic 19	cqr:a	Ljava/lang/String;
    //   426: ldc -110
    //   428: iconst_3
    //   429: anewarray 39	java/lang/Object
    //   432: dup
    //   433: iconst_0
    //   434: aload_1
    //   435: aastore
    //   436: dup
    //   437: iconst_1
    //   438: aload 6
    //   440: invokevirtual 150	java/lang/Object:getClass	()Ljava/lang/Class;
    //   443: aastore
    //   444: dup
    //   445: iconst_2
    //   446: aload 6
    //   448: invokevirtual 154	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   451: aastore
    //   452: invokestatic 156	cvm:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   455: pop
    //   456: aload 5
    //   458: ifnull +8 -> 466
    //   461: aload 5
    //   463: invokevirtual 71	android/content/res/AssetFileDescriptor:close	()V
    //   466: aconst_null
    //   467: areturn
    //   468: astore_1
    //   469: getstatic 19	cqr:a	Ljava/lang/String;
    //   472: aload_1
    //   473: ldc 73
    //   475: iconst_0
    //   476: anewarray 39	java/lang/Object
    //   479: invokestatic 76	cvm:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   482: pop
    //   483: goto -17 -> 466
    //   486: astore_1
    //   487: aconst_null
    //   488: astore 5
    //   490: aload 5
    //   492: ifnull +8 -> 500
    //   495: aload 5
    //   497: invokevirtual 71	android/content/res/AssetFileDescriptor:close	()V
    //   500: aload_1
    //   501: athrow
    //   502: astore 5
    //   504: getstatic 19	cqr:a	Ljava/lang/String;
    //   507: aload 5
    //   509: ldc 73
    //   511: iconst_0
    //   512: anewarray 39	java/lang/Object
    //   515: invokestatic 76	cvm:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   518: pop
    //   519: goto -19 -> 500
    //   522: astore_1
    //   523: goto -33 -> 490
    //   526: astore_1
    //   527: goto -37 -> 490
    //   530: astore 6
    //   532: goto -109 -> 423
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	535	0	this	cqr
    //   0	535	1	paramUri	Uri
    //   26	297	2	i	int
    //   145	4	3	j	int
    //   48	3	4	bool	boolean
    //   42	454	5	localAssetFileDescriptor	android.content.res.AssetFileDescriptor
    //   502	6	5	localIOException	IOException
    //   97	319	6	localObject	Object
    //   418	29	6	localThrowable1	Throwable
    //   530	1	6	localThrowable2	Throwable
    //   318	25	7	localMatrix	android.graphics.Matrix
    // Exception table:
    //   from	to	target	type
    //   65	70	72	java/io/IOException
    //   156	161	163	java/io/IOException
    //   358	363	366	java/io/IOException
    //   392	397	400	java/io/IOException
    //   27	44	418	java/lang/Throwable
    //   461	466	468	java/io/IOException
    //   27	44	486	finally
    //   495	500	502	java/io/IOException
    //   44	50	522	finally
    //   90	146	522	finally
    //   181	302	522	finally
    //   311	350	522	finally
    //   423	456	526	finally
    //   44	50	530	java/lang/Throwable
    //   90	146	530	java/lang/Throwable
    //   181	302	530	java/lang/Throwable
    //   311	350	530	java/lang/Throwable
  }
  
  public static void a(ckk paramckk, cki paramcki, Attachment paramAttachment1, Attachment paramAttachment2)
  {
    if (paramckk != null)
    {
      paramckk = paramckk.a(paramAttachment1);
      if (paramckk != null) {
        paramcki.a(paramckk);
      }
    }
    Uri localUri1;
    Uri localUri2;
    do
    {
      return;
      int i = paramcki.e();
      int j = paramcki.f();
      if ((paramAttachment1 == null) || (i == 0) || (j == 0) || (!paramAttachment1.j()))
      {
        paramcki.g();
        return;
      }
      localUri1 = j;
      localUri2 = i;
      paramAttachment1 = paramAttachment1.k();
      if (paramAttachment2 == null) {}
      for (paramckk = null; ((localUri1 != null) || (localUri2 != null)) && ((paramcki.i()) || (paramckk == null) || (!paramAttachment1.equals(paramckk))); paramckk = paramAttachment2.k())
      {
        new cqr(paramcki, i, j).execute(new Uri[] { localUri1, localUri2 });
        return;
      }
    } while ((localUri1 != null) || (localUri2 != null));
    paramcki.g();
  }
  
  private final int b(Uri paramUri)
  {
    if (paramUri == null) {}
    Object localObject2;
    for (;;)
    {
      return 0;
      localObject2 = null;
      Object localObject1 = null;
      try
      {
        InputStream localInputStream = b.h().openInputStream(paramUri);
        localObject1 = localInputStream;
        localObject2 = localInputStream;
        int i = bmz.a(localInputStream);
        if (localInputStream != null) {}
        try
        {
          localInputStream.close();
          return i;
        }
        catch (IOException paramUri)
        {
          for (;;)
          {
            cvm.e(a, paramUri, "error attemtping to close input stream", new Object[0]);
          }
        }
      }
      catch (Throwable localThrowable)
      {
        localObject2 = localObject1;
        cvm.c(a, "Unable to get orientation of thumbnail %s: %s %s", new Object[] { paramUri, localThrowable.getClass(), localThrowable.getMessage() });
        if (localObject1 != null) {
          try
          {
            ((InputStream)localObject1).close();
            return 0;
          }
          catch (IOException paramUri)
          {
            cvm.e(a, paramUri, "error attemtping to close input stream", new Object[0]);
            return 0;
          }
        }
      }
      finally
      {
        if (localObject2 == null) {}
      }
    }
    try
    {
      ((InputStream)localObject2).close();
      throw paramUri;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        cvm.e(a, localIOException, "error attemtping to close input stream", new Object[0]);
      }
    }
  }
}

/* Location:
 * Qualified Name:     cqr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */