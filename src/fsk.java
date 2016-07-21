import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.ParcelFileDescriptor;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

final class fsk
  extends AsyncTask<Void, Void, Bitmap>
{
  final fsj a;
  final ParcelFileDescriptor b;
  final int c;
  final int d;
  final int e;
  
  fsk(fsi paramfsi, fsj paramfsj, ParcelFileDescriptor paramParcelFileDescriptor, int paramInt1, int paramInt2, int paramInt3)
  {
    a = paramfsj;
    b = paramParcelFileDescriptor;
    c = paramInt1;
    d = paramInt2;
    e = paramInt3;
  }
  
  private final Bitmap a()
  {
    try
    {
      Bitmap localBitmap;
      if (f.h)
      {
        localBitmap = frs.a(b);
        if (localBitmap == null) {
          localBitmap = null;
        }
      }
      for (;;)
      {
        if (localBitmap != null) {
          f.d.put(a.g, localBitmap);
        }
        if (b != null) {}
        try
        {
          b.close();
          return localBitmap;
        }
        catch (IOException localIOException1)
        {
          localIOException1.getMessage();
          return localBitmap;
        }
        localBitmap = fto.a(localBitmap);
        continue;
        localBitmap = fsi.a(b, c, d, e, (int)(c * f.i / f.j));
        if (localBitmap == null) {
          localBitmap = null;
        } else {
          localBitmap = fsi.a(localBitmap, c, f.i / f.j);
        }
      }
      try
      {
        b.close();
        throw ((Throwable)localObject);
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          localIOException2.getMessage();
        }
      }
    }
    finally
    {
      if (b == null) {}
    }
  }
}

/* Location:
 * Qualified Name:     fsk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */