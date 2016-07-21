import android.graphics.Matrix;
import com.android.ex.photo.views.PhotoView;

public final class bnj
  implements Runnable
{
  final PhotoView a;
  float b;
  float c;
  float d;
  long e;
  boolean f;
  boolean g;
  
  public bnj(PhotoView paramPhotoView)
  {
    a = paramPhotoView;
  }
  
  public final void a()
  {
    f = false;
    g = true;
  }
  
  public final void run()
  {
    if (g) {
      return;
    }
    long l2;
    if (c != b)
    {
      l2 = System.currentTimeMillis();
      if (e == -1L) {
        break label218;
      }
    }
    label218:
    for (long l1 = l2 - e;; l1 = 0L)
    {
      float f1 = d;
      float f2 = (float)l1 * f1;
      if ((c >= b) || (c + f2 <= b))
      {
        f1 = f2;
        if (c > b)
        {
          f1 = f2;
          if (c + f2 >= b) {}
        }
      }
      else
      {
        f1 = b - c;
      }
      PhotoView localPhotoView = a;
      o += f1;
      b.postRotate(f1, localPhotoView.getWidth() / 2, localPhotoView.getHeight() / 2);
      localPhotoView.invalidate();
      c = (f1 + c);
      if (c == b) {
        a();
      }
      e = l2;
      if (g) {
        break;
      }
      a.post(this);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     bnj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */