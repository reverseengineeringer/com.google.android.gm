import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;

final class ms
{
  final Context a;
  BitmapFactory.Options b = null;
  final Object c = new Object();
  int d = 2;
  int e = 2;
  int f = 1;
  
  ms(Context paramContext)
  {
    a = paramContext;
  }
  
  private final Bitmap a(Uri paramUri, BitmapFactory.Options paramOptions)
  {
    localUri = null;
    if ((paramUri == null) || (a == null)) {
      throw new IllegalArgumentException("bad argument to loadBitmap");
    }
    try
    {
      paramUri = a.getContentResolver().openInputStream(paramUri);
      localUri = paramUri;
      paramOptions = BitmapFactory.decodeStream(paramUri, null, paramOptions);
      if (paramUri != null) {}
      try
      {
        paramUri.close();
        return paramOptions;
      }
      catch (IOException paramUri)
      {
        Log.w("PrintHelperKitkat", "close fail ", paramUri);
        return paramOptions;
      }
      try
      {
        localUri.close();
        throw paramUri;
      }
      catch (IOException paramOptions)
      {
        for (;;)
        {
          Log.w("PrintHelperKitkat", "close fail ", paramOptions);
        }
      }
    }
    finally
    {
      if (localUri == null) {}
    }
  }
  
  final Bitmap a(Uri arg1, int paramInt)
  {
    paramInt = 1;
    if ((??? == null) || (a == null)) {
      throw new IllegalArgumentException("bad argument to getScaledBitmap");
    }
    ??? = new BitmapFactory.Options();
    inJustDecodeBounds = true;
    a(???, (BitmapFactory.Options)???);
    int j = outWidth;
    int k = outHeight;
    if ((j <= 0) || (k <= 0)) {}
    do
    {
      return null;
      int i = Math.max(j, k);
      while (i > 3500)
      {
        i >>>= 1;
        paramInt <<= 1;
      }
    } while ((paramInt <= 0) || (Math.min(j, k) / paramInt <= 0));
    BitmapFactory.Options localOptions;
    synchronized (c)
    {
      b = new BitmapFactory.Options();
      b.inMutable = true;
      b.inSampleSize = paramInt;
      localOptions = b;
    }
    try
    {
      ??? = a(???, localOptions);
      synchronized (c)
      {
        b = null;
        return (Bitmap)???;
      }
      ??? = finally;
      throw ???;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     ms
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */