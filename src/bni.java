import android.graphics.RectF;
import com.android.ex.photo.views.PhotoView;

public final class bni
  implements Runnable
{
  public bni(PhotoView paramPhotoView) {}
  
  public final void run()
  {
    float f3 = a.b();
    float f5;
    float f1;
    float f6;
    float f4;
    float f7;
    if (f3 > a.k)
    {
      f5 = 1.0F / (1.0F - a.k / f3);
      float f8 = 1.0F - f5;
      f1 = a.getWidth() / 2;
      f2 = a.getHeight() / 2;
      f6 = a.q.left * f8;
      f4 = a.q.top * f8;
      f7 = a.getWidth() * f5 + a.q.right * f8;
      f5 = f5 * a.getHeight() + f8 * a.q.bottom;
      if (f7 <= f6) {
        break label201;
      }
      f1 = (f7 + f6) / 2.0F;
      if (f5 <= f4) {
        break label216;
      }
    }
    label201:
    label216:
    for (float f2 = (f5 + f4) / 2.0F;; f2 = Math.min(Math.max(f5, f2), f4))
    {
      a.i.a(f3, a.k, f1, f2);
      return;
      f1 = Math.min(Math.max(f7, f1), f6);
      break;
    }
  }
}

/* Location:
 * Qualified Name:     bni
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */