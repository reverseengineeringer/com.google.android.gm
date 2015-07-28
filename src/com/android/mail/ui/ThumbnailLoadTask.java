package com.android.mail.ui;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.AsyncTask;
import com.android.mail.providers.Attachment;
import com.android.mail.utils.LogTag;
import com.android.mail.utils.LogUtils;
import java.io.IOException;

public class ThumbnailLoadTask
  extends AsyncTask<Uri, Void, Bitmap>
{
  private static final String LOG_TAG = ;
  private final int mHeight;
  private final AttachmentBitmapHolder mHolder;
  private final int mWidth;
  
  public ThumbnailLoadTask(AttachmentBitmapHolder paramAttachmentBitmapHolder, int paramInt1, int paramInt2)
  {
    mHolder = paramAttachmentBitmapHolder;
    mWidth = paramInt1;
    mHeight = paramInt2;
  }
  
  /* Error */
  private int getOrientation(Uri paramUri)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 9
    //   12: aconst_null
    //   13: astore 4
    //   15: aconst_null
    //   16: astore 7
    //   18: aload 8
    //   20: astore 6
    //   22: aload_0
    //   23: getfield 29	com/android/mail/ui/ThumbnailLoadTask:mHolder	Lcom/android/mail/ui/AttachmentBitmapHolder;
    //   26: invokeinterface 45 1 0
    //   31: aload_1
    //   32: invokevirtual 51	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   35: astore 5
    //   37: aload 5
    //   39: astore 7
    //   41: aload 5
    //   43: astore 4
    //   45: aload 8
    //   47: astore 6
    //   49: new 53	java/io/ByteArrayOutputStream
    //   52: dup
    //   53: invokespecial 54	java/io/ByteArrayOutputStream:<init>	()V
    //   56: astore 8
    //   58: aload 5
    //   60: astore 4
    //   62: aload 5
    //   64: astore 6
    //   66: sipush 4096
    //   69: newarray <illegal type>
    //   71: astore 7
    //   73: aload 5
    //   75: astore 4
    //   77: aload 5
    //   79: astore 6
    //   81: aload 5
    //   83: aload 7
    //   85: invokevirtual 60	java/io/InputStream:read	([B)I
    //   88: istore_2
    //   89: iload_2
    //   90: iflt +39 -> 129
    //   93: aload 5
    //   95: astore 4
    //   97: aload 5
    //   99: astore 6
    //   101: aload 8
    //   103: aload 7
    //   105: iconst_0
    //   106: iload_2
    //   107: invokevirtual 64	java/io/ByteArrayOutputStream:write	([BII)V
    //   110: aload 5
    //   112: astore 4
    //   114: aload 5
    //   116: astore 6
    //   118: aload 5
    //   120: aload 7
    //   122: invokevirtual 60	java/io/InputStream:read	([B)I
    //   125: istore_2
    //   126: goto -37 -> 89
    //   129: aload 5
    //   131: astore 4
    //   133: aload 5
    //   135: astore 6
    //   137: aload 5
    //   139: invokevirtual 67	java/io/InputStream:close	()V
    //   142: aconst_null
    //   143: astore 7
    //   145: aconst_null
    //   146: astore 5
    //   148: aload 5
    //   150: astore 4
    //   152: aload 7
    //   154: astore 6
    //   156: aload_0
    //   157: invokevirtual 71	com/android/mail/ui/ThumbnailLoadTask:isCancelled	()Z
    //   160: istore_3
    //   161: iload_3
    //   162: ifeq +56 -> 218
    //   165: iconst_0
    //   166: ifeq +5 -> 171
    //   169: aconst_null
    //   170: athrow
    //   171: aload 8
    //   173: ifnull -169 -> 4
    //   176: aload 8
    //   178: invokevirtual 72	java/io/ByteArrayOutputStream:close	()V
    //   181: iconst_0
    //   182: ireturn
    //   183: astore_1
    //   184: getstatic 22	com/android/mail/ui/ThumbnailLoadTask:LOG_TAG	Ljava/lang/String;
    //   187: aload_1
    //   188: ldc 74
    //   190: iconst_0
    //   191: anewarray 76	java/lang/Object
    //   194: invokestatic 82	com/android/mail/utils/LogUtils:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   197: pop
    //   198: iconst_0
    //   199: ireturn
    //   200: astore_1
    //   201: getstatic 22	com/android/mail/ui/ThumbnailLoadTask:LOG_TAG	Ljava/lang/String;
    //   204: aload_1
    //   205: ldc 84
    //   207: iconst_0
    //   208: anewarray 76	java/lang/Object
    //   211: invokestatic 82	com/android/mail/utils/LogUtils:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   214: pop
    //   215: goto -44 -> 171
    //   218: aload 5
    //   220: astore 4
    //   222: aload 7
    //   224: astore 6
    //   226: aload 8
    //   228: invokevirtual 88	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   231: invokestatic 92	com/android/ex/photo/util/Exif:getOrientation	([B)I
    //   234: istore_2
    //   235: iconst_0
    //   236: ifeq +5 -> 241
    //   239: aconst_null
    //   240: athrow
    //   241: aload 8
    //   243: ifnull +8 -> 251
    //   246: aload 8
    //   248: invokevirtual 72	java/io/ByteArrayOutputStream:close	()V
    //   251: iload_2
    //   252: ireturn
    //   253: astore_1
    //   254: getstatic 22	com/android/mail/ui/ThumbnailLoadTask:LOG_TAG	Ljava/lang/String;
    //   257: aload_1
    //   258: ldc 84
    //   260: iconst_0
    //   261: anewarray 76	java/lang/Object
    //   264: invokestatic 82	com/android/mail/utils/LogUtils:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   267: pop
    //   268: goto -27 -> 241
    //   271: astore_1
    //   272: getstatic 22	com/android/mail/ui/ThumbnailLoadTask:LOG_TAG	Ljava/lang/String;
    //   275: aload_1
    //   276: ldc 74
    //   278: iconst_0
    //   279: anewarray 76	java/lang/Object
    //   282: invokestatic 82	com/android/mail/utils/LogUtils:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   285: pop
    //   286: goto -35 -> 251
    //   289: astore 8
    //   291: aload 9
    //   293: astore 5
    //   295: aload 7
    //   297: astore 4
    //   299: aload 5
    //   301: astore 6
    //   303: getstatic 22	com/android/mail/ui/ThumbnailLoadTask:LOG_TAG	Ljava/lang/String;
    //   306: aload 8
    //   308: ldc 94
    //   310: iconst_1
    //   311: anewarray 76	java/lang/Object
    //   314: dup
    //   315: iconst_0
    //   316: aload_1
    //   317: aastore
    //   318: invokestatic 82	com/android/mail/utils/LogUtils:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   321: pop
    //   322: aload 7
    //   324: ifnull +8 -> 332
    //   327: aload 7
    //   329: invokevirtual 67	java/io/InputStream:close	()V
    //   332: aload 5
    //   334: ifnull -330 -> 4
    //   337: aload 5
    //   339: invokevirtual 72	java/io/ByteArrayOutputStream:close	()V
    //   342: iconst_0
    //   343: ireturn
    //   344: astore_1
    //   345: getstatic 22	com/android/mail/ui/ThumbnailLoadTask:LOG_TAG	Ljava/lang/String;
    //   348: aload_1
    //   349: ldc 74
    //   351: iconst_0
    //   352: anewarray 76	java/lang/Object
    //   355: invokestatic 82	com/android/mail/utils/LogUtils:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   358: pop
    //   359: iconst_0
    //   360: ireturn
    //   361: astore_1
    //   362: getstatic 22	com/android/mail/ui/ThumbnailLoadTask:LOG_TAG	Ljava/lang/String;
    //   365: aload_1
    //   366: ldc 84
    //   368: iconst_0
    //   369: anewarray 76	java/lang/Object
    //   372: invokestatic 82	com/android/mail/utils/LogUtils:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   375: pop
    //   376: goto -44 -> 332
    //   379: astore_1
    //   380: aload 4
    //   382: ifnull +8 -> 390
    //   385: aload 4
    //   387: invokevirtual 67	java/io/InputStream:close	()V
    //   390: aload 6
    //   392: ifnull +8 -> 400
    //   395: aload 6
    //   397: invokevirtual 72	java/io/ByteArrayOutputStream:close	()V
    //   400: aload_1
    //   401: athrow
    //   402: astore 4
    //   404: getstatic 22	com/android/mail/ui/ThumbnailLoadTask:LOG_TAG	Ljava/lang/String;
    //   407: aload 4
    //   409: ldc 84
    //   411: iconst_0
    //   412: anewarray 76	java/lang/Object
    //   415: invokestatic 82	com/android/mail/utils/LogUtils:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   418: pop
    //   419: goto -29 -> 390
    //   422: astore 4
    //   424: getstatic 22	com/android/mail/ui/ThumbnailLoadTask:LOG_TAG	Ljava/lang/String;
    //   427: aload 4
    //   429: ldc 74
    //   431: iconst_0
    //   432: anewarray 76	java/lang/Object
    //   435: invokestatic 82	com/android/mail/utils/LogUtils:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   438: pop
    //   439: goto -39 -> 400
    //   442: astore_1
    //   443: aload 8
    //   445: astore 6
    //   447: goto -67 -> 380
    //   450: astore 4
    //   452: aload 8
    //   454: astore 5
    //   456: aload 6
    //   458: astore 7
    //   460: aload 4
    //   462: astore 8
    //   464: goto -169 -> 295
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	467	0	this	ThumbnailLoadTask
    //   0	467	1	paramUri	Uri
    //   88	164	2	i	int
    //   160	2	3	bool	boolean
    //   13	373	4	localObject1	Object
    //   402	6	4	localIOException1	IOException
    //   422	6	4	localIOException2	IOException
    //   450	11	4	localThrowable1	Throwable
    //   35	420	5	localObject2	Object
    //   20	437	6	localObject3	Object
    //   16	443	7	localObject4	Object
    //   7	240	8	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   289	164	8	localThrowable2	Throwable
    //   462	1	8	localObject5	Object
    //   10	282	9	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   176	181	183	java/io/IOException
    //   169	171	200	java/io/IOException
    //   239	241	253	java/io/IOException
    //   246	251	271	java/io/IOException
    //   22	37	289	java/lang/Throwable
    //   49	58	289	java/lang/Throwable
    //   337	342	344	java/io/IOException
    //   327	332	361	java/io/IOException
    //   22	37	379	finally
    //   49	58	379	finally
    //   303	322	379	finally
    //   385	390	402	java/io/IOException
    //   395	400	422	java/io/IOException
    //   66	73	442	finally
    //   81	89	442	finally
    //   101	110	442	finally
    //   118	126	442	finally
    //   137	142	442	finally
    //   156	161	442	finally
    //   226	235	442	finally
    //   66	73	450	java/lang/Throwable
    //   81	89	450	java/lang/Throwable
    //   101	110	450	java/lang/Throwable
    //   118	126	450	java/lang/Throwable
    //   137	142	450	java/lang/Throwable
    //   156	161	450	java/lang/Throwable
    //   226	235	450	java/lang/Throwable
  }
  
  private Bitmap loadBitmap(Uri paramUri)
  {
    if (paramUri == null)
    {
      LogUtils.e(LOG_TAG, "Attempting to load bitmap for null uri", new Object[0]);
      paramUri = null;
    }
    for (;;)
    {
      return paramUri;
      int i = getOrientation(paramUri);
      localObject2 = null;
      Object localObject1 = null;
      try
      {
        AssetFileDescriptor localAssetFileDescriptor = mHolder.getResolver().openAssetFileDescriptor(paramUri, "r");
        localObject1 = localAssetFileDescriptor;
        localObject2 = localAssetFileDescriptor;
        boolean bool = isCancelled();
        if ((bool) || (localAssetFileDescriptor == null))
        {
          paramUri = null;
          if (localAssetFileDescriptor == null) {
            continue;
          }
          try
          {
            localAssetFileDescriptor.close();
            return null;
          }
          catch (IOException paramUri)
          {
            LogUtils.e(LOG_TAG, paramUri, "", new Object[0]);
            return null;
          }
        }
        localObject1 = localAssetFileDescriptor;
        localObject2 = localAssetFileDescriptor;
        Object localObject3 = new BitmapFactory.Options();
        localObject1 = localAssetFileDescriptor;
        localObject2 = localAssetFileDescriptor;
        inJustDecodeBounds = true;
        localObject1 = localAssetFileDescriptor;
        localObject2 = localAssetFileDescriptor;
        inDensity = 160;
        localObject1 = localAssetFileDescriptor;
        localObject2 = localAssetFileDescriptor;
        BitmapFactory.decodeFileDescriptor(localAssetFileDescriptor.getFileDescriptor(), null, (BitmapFactory.Options)localObject3);
        localObject1 = localAssetFileDescriptor;
        localObject2 = localAssetFileDescriptor;
        if (!isCancelled())
        {
          localObject1 = localAssetFileDescriptor;
          localObject2 = localAssetFileDescriptor;
          if (outWidth != -1)
          {
            localObject1 = localAssetFileDescriptor;
            localObject2 = localAssetFileDescriptor;
            int j = outHeight;
            if (j != -1) {
              break label254;
            }
          }
        }
        paramUri = null;
        if (localAssetFileDescriptor == null) {
          continue;
        }
        try
        {
          localAssetFileDescriptor.close();
          return null;
        }
        catch (IOException paramUri)
        {
          LogUtils.e(LOG_TAG, paramUri, "", new Object[0]);
          return null;
        }
        label254:
        localObject1 = localAssetFileDescriptor;
        localObject2 = localAssetFileDescriptor;
        inJustDecodeBounds = false;
        localObject1 = localAssetFileDescriptor;
        localObject2 = localAssetFileDescriptor;
        inSampleSize = Math.min(Math.max(outWidth / mWidth, 1), Math.max(outHeight / mHeight, 1));
        localObject1 = localAssetFileDescriptor;
        localObject2 = localAssetFileDescriptor;
        LogUtils.d(LOG_TAG, "in background, src w/h=%d/%d dst w/h=%d/%d, divider=%d", new Object[] { Integer.valueOf(outWidth), Integer.valueOf(outHeight), Integer.valueOf(mWidth), Integer.valueOf(mHeight), Integer.valueOf(inSampleSize) });
        localObject1 = localAssetFileDescriptor;
        localObject2 = localAssetFileDescriptor;
        localObject3 = BitmapFactory.decodeFileDescriptor(localAssetFileDescriptor.getFileDescriptor(), null, (BitmapFactory.Options)localObject3);
        if ((localObject3 != null) && (i != 0))
        {
          localObject1 = localAssetFileDescriptor;
          localObject2 = localAssetFileDescriptor;
          Matrix localMatrix = new Matrix();
          localObject1 = localAssetFileDescriptor;
          localObject2 = localAssetFileDescriptor;
          localMatrix.postRotate(i);
          localObject1 = localAssetFileDescriptor;
          localObject2 = localAssetFileDescriptor;
          localObject3 = Bitmap.createBitmap((Bitmap)localObject3, 0, 0, ((Bitmap)localObject3).getWidth(), ((Bitmap)localObject3).getHeight(), localMatrix, true);
          localObject1 = localObject3;
          paramUri = (Uri)localObject1;
          if (localAssetFileDescriptor == null) {
            continue;
          }
          try
          {
            localAssetFileDescriptor.close();
            return (Bitmap)localObject1;
          }
          catch (IOException paramUri)
          {
            LogUtils.e(LOG_TAG, paramUri, "", new Object[0]);
            return (Bitmap)localObject1;
          }
        }
        paramUri = (Uri)localObject3;
        if (localAssetFileDescriptor == null) {
          continue;
        }
        try
        {
          localAssetFileDescriptor.close();
          return (Bitmap)localObject3;
        }
        catch (IOException paramUri)
        {
          LogUtils.e(LOG_TAG, paramUri, "", new Object[0]);
          return (Bitmap)localObject3;
        }
        try
        {
          ((AssetFileDescriptor)localObject2).close();
          throw paramUri;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            LogUtils.e(LOG_TAG, localIOException, "", new Object[0]);
          }
        }
      }
      catch (Throwable localThrowable)
      {
        localObject2 = localObject1;
        LogUtils.e(LOG_TAG, localThrowable, "Unable to decode thumbnail %s", new Object[] { paramUri });
        if (localObject1 != null) {}
        try
        {
          ((AssetFileDescriptor)localObject1).close();
          return null;
        }
        catch (IOException paramUri)
        {
          for (;;)
          {
            LogUtils.e(LOG_TAG, paramUri, "", new Object[0]);
          }
        }
      }
      finally
      {
        if (localObject2 == null) {}
      }
    }
  }
  
  public static void setupThumbnailPreview(ThumbnailLoadTask paramThumbnailLoadTask, AttachmentBitmapHolder paramAttachmentBitmapHolder, Attachment paramAttachment1, Attachment paramAttachment2)
  {
    Object localObject = null;
    int i = paramAttachmentBitmapHolder.getThumbnailWidth();
    int j = paramAttachmentBitmapHolder.getThumbnailHeight();
    if ((paramAttachment1 == null) || (i == 0) || (j == 0) || (!paramAttachment1.isImage())) {
      paramAttachmentBitmapHolder.setThumbnailToDefault();
    }
    Uri localUri1;
    Uri localUri2;
    label152:
    label160:
    do
    {
      return;
      localUri1 = thumbnailUri;
      localUri2 = contentUri;
      if (paramAttachment2 == null)
      {
        paramAttachment1 = null;
        if (paramAttachment2 != null) {
          break label152;
        }
      }
      for (paramAttachment2 = (Attachment)localObject;; paramAttachment2 = uri)
      {
        if (((localUri1 == null) && (localUri2 == null)) || ((!paramAttachmentBitmapHolder.bitmapSetToDefault()) && (paramAttachment2 != null) && (paramAttachment1.equals(paramAttachment2)))) {
          break label160;
        }
        if (paramThumbnailLoadTask != null) {
          paramThumbnailLoadTask.cancel(true);
        }
        new ThumbnailLoadTask(paramAttachmentBitmapHolder, i, j).execute(new Uri[] { localUri1, localUri2 });
        return;
        paramAttachment1 = uri;
        break;
      }
    } while ((localUri1 != null) || (localUri2 != null));
    paramAttachmentBitmapHolder.setThumbnailToDefault();
  }
  
  protected Bitmap doInBackground(Uri... paramVarArgs)
  {
    Bitmap localBitmap2 = loadBitmap(paramVarArgs[0]);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = loadBitmap(paramVarArgs[1]);
    }
    return localBitmap1;
  }
  
  protected void onPostExecute(Bitmap paramBitmap)
  {
    if (paramBitmap == null)
    {
      LogUtils.d(LOG_TAG, "back in UI thread, decode failed", new Object[0]);
      mHolder.setThumbnailToDefault();
      return;
    }
    LogUtils.d(LOG_TAG, "back in UI thread, decode success, w/h=%d/%d", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) });
    mHolder.setThumbnail(paramBitmap);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.ThumbnailLoadTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */