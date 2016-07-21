import android.content.ContentResolver;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build.VERSION;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Pattern;

public final class bna
{
  static final Pattern a = Pattern.compile("^(?:.*;)?base64,.*");
  public static final int b = bnd.a;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      b = bnd.c;
      return;
    }
    if (blq.a >= 32L)
    {
      b = bnd.c;
      return;
    }
    if (blq.a >= 24L)
    {
      b = bnd.b;
      return;
    }
  }
  
  /* Error */
  private static android.graphics.Bitmap a(bne parambne, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokeinterface 53 1 0
    //   6: astore_3
    //   7: aload_3
    //   8: astore 4
    //   10: aload_3
    //   11: invokestatic 58	bmz:a	(Ljava/io/InputStream;)I
    //   14: istore_2
    //   15: aload_3
    //   16: ifnull +10 -> 26
    //   19: aload_3
    //   20: astore 4
    //   22: aload_3
    //   23: invokevirtual 63	java/io/InputStream:close	()V
    //   26: aload_3
    //   27: astore 4
    //   29: aload_0
    //   30: invokeinterface 53 1 0
    //   35: astore_0
    //   36: aload_0
    //   37: astore_3
    //   38: aload_0
    //   39: aconst_null
    //   40: aload_1
    //   41: invokestatic 69	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   44: astore 4
    //   46: aload_0
    //   47: ifnull +68 -> 115
    //   50: aload 4
    //   52: ifnonnull +63 -> 115
    //   55: aload_0
    //   56: astore_3
    //   57: aload_1
    //   58: getfield 75	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   61: ifne +54 -> 115
    //   64: aload_0
    //   65: astore_3
    //   66: ldc 77
    //   68: ldc 79
    //   70: invokestatic 85	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   73: pop
    //   74: aload_0
    //   75: astore_3
    //   76: new 87	java/lang/UnsupportedOperationException
    //   79: dup
    //   80: ldc 89
    //   82: invokespecial 93	java/lang/UnsupportedOperationException:<init>	(Ljava/lang/String;)V
    //   85: athrow
    //   86: astore_1
    //   87: aload_0
    //   88: astore_3
    //   89: aload_1
    //   90: astore_0
    //   91: aload_3
    //   92: astore 4
    //   94: ldc 77
    //   96: ldc 95
    //   98: aload_0
    //   99: invokestatic 99	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   102: pop
    //   103: aload_3
    //   104: ifnull +7 -> 111
    //   107: aload_3
    //   108: invokevirtual 63	java/io/InputStream:close	()V
    //   111: aconst_null
    //   112: astore_1
    //   113: aload_1
    //   114: areturn
    //   115: aload 4
    //   117: ifnull +65 -> 182
    //   120: iload_2
    //   121: ifeq +61 -> 182
    //   124: aload_0
    //   125: astore_3
    //   126: new 101	android/graphics/Matrix
    //   129: dup
    //   130: invokespecial 103	android/graphics/Matrix:<init>	()V
    //   133: astore_1
    //   134: aload_0
    //   135: astore_3
    //   136: aload_1
    //   137: iload_2
    //   138: i2f
    //   139: invokevirtual 107	android/graphics/Matrix:postRotate	(F)Z
    //   142: pop
    //   143: aload_0
    //   144: astore_3
    //   145: aload 4
    //   147: iconst_0
    //   148: iconst_0
    //   149: aload 4
    //   151: invokevirtual 113	android/graphics/Bitmap:getWidth	()I
    //   154: aload 4
    //   156: invokevirtual 116	android/graphics/Bitmap:getHeight	()I
    //   159: aload_1
    //   160: iconst_1
    //   161: invokestatic 120	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   164: astore_1
    //   165: aload_1
    //   166: astore_3
    //   167: aload_3
    //   168: astore_1
    //   169: aload_0
    //   170: ifnull -57 -> 113
    //   173: aload_0
    //   174: invokevirtual 63	java/io/InputStream:close	()V
    //   177: aload_3
    //   178: areturn
    //   179: astore_0
    //   180: aload_3
    //   181: areturn
    //   182: aload 4
    //   184: astore_1
    //   185: aload_0
    //   186: ifnull -73 -> 113
    //   189: aload_0
    //   190: invokevirtual 63	java/io/InputStream:close	()V
    //   193: aload 4
    //   195: areturn
    //   196: astore_0
    //   197: aload 4
    //   199: areturn
    //   200: astore_1
    //   201: aconst_null
    //   202: astore_0
    //   203: aload_0
    //   204: astore_3
    //   205: ldc 77
    //   207: ldc 122
    //   209: aload_1
    //   210: invokestatic 99	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   213: pop
    //   214: aload_0
    //   215: ifnull +7 -> 222
    //   218: aload_0
    //   219: invokevirtual 63	java/io/InputStream:close	()V
    //   222: aconst_null
    //   223: areturn
    //   224: astore_0
    //   225: aconst_null
    //   226: astore_3
    //   227: aload_3
    //   228: ifnull +7 -> 235
    //   231: aload_3
    //   232: invokevirtual 63	java/io/InputStream:close	()V
    //   235: aload_0
    //   236: athrow
    //   237: astore_0
    //   238: goto -127 -> 111
    //   241: astore_0
    //   242: goto -20 -> 222
    //   245: astore_1
    //   246: goto -11 -> 235
    //   249: astore_0
    //   250: aload 4
    //   252: astore_3
    //   253: goto -26 -> 227
    //   256: astore_0
    //   257: goto -30 -> 227
    //   260: astore_1
    //   261: aload_3
    //   262: astore_0
    //   263: goto -60 -> 203
    //   266: astore_1
    //   267: goto -64 -> 203
    //   270: astore_0
    //   271: aconst_null
    //   272: astore_3
    //   273: goto -182 -> 91
    //   276: astore_0
    //   277: goto -186 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	parambne	bne
    //   0	280	1	paramOptions	BitmapFactory.Options
    //   14	124	2	i	int
    //   6	267	3	localObject1	Object
    //   8	243	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   38	46	86	java/lang/OutOfMemoryError
    //   57	64	86	java/lang/OutOfMemoryError
    //   66	74	86	java/lang/OutOfMemoryError
    //   76	86	86	java/lang/OutOfMemoryError
    //   126	134	86	java/lang/OutOfMemoryError
    //   136	143	86	java/lang/OutOfMemoryError
    //   145	165	86	java/lang/OutOfMemoryError
    //   173	177	179	java/io/IOException
    //   189	193	196	java/io/IOException
    //   0	7	200	java/io/IOException
    //   0	7	224	finally
    //   107	111	237	java/io/IOException
    //   218	222	241	java/io/IOException
    //   231	235	245	java/io/IOException
    //   10	15	249	finally
    //   22	26	249	finally
    //   29	36	249	finally
    //   94	103	249	finally
    //   38	46	256	finally
    //   57	64	256	finally
    //   66	74	256	finally
    //   76	86	256	finally
    //   126	134	256	finally
    //   136	143	256	finally
    //   145	165	256	finally
    //   205	214	256	finally
    //   10	15	260	java/io/IOException
    //   22	26	260	java/io/IOException
    //   29	36	260	java/io/IOException
    //   38	46	266	java/io/IOException
    //   57	64	266	java/io/IOException
    //   66	74	266	java/io/IOException
    //   76	86	266	java/io/IOException
    //   126	134	266	java/io/IOException
    //   136	143	266	java/io/IOException
    //   145	165	266	java/io/IOException
    //   0	7	270	java/lang/OutOfMemoryError
    //   10	15	276	java/lang/OutOfMemoryError
    //   22	26	276	java/lang/OutOfMemoryError
    //   29	36	276	java/lang/OutOfMemoryError
  }
  
  public static bmv a(ContentResolver paramContentResolver, Uri paramUri, int paramInt)
  {
    localbmv = new bmv();
    if ("data".equals(paramUri.getScheme())) {}
    for (paramContentResolver = new bnc(paramContentResolver, paramUri);; paramContentResolver = new bnb(paramContentResolver, paramUri)) {
      try
      {
        paramUri = new BitmapFactory.Options();
        inJustDecodeBounds = true;
        a(paramContentResolver, paramUri);
        paramUri = new Point(outWidth, outHeight);
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        inSampleSize = Math.max(x / paramInt, y / paramInt);
        b = a(paramContentResolver, localOptions);
        c = 0;
        return localbmv;
      }
      catch (IOException paramContentResolver)
      {
        c = 1;
        return localbmv;
      }
      catch (SecurityException paramContentResolver)
      {
        for (;;)
        {
          c = 1;
        }
      }
      catch (IllegalArgumentException paramContentResolver)
      {
        for (;;) {}
      }
      catch (FileNotFoundException paramContentResolver)
      {
        for (;;) {}
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    return (paramString != null) && (paramString.startsWith("image/"));
  }
}

/* Location:
 * Qualified Name:     bna
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */