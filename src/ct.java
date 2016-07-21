import android.os.Handler;
import android.os.SystemClock;
import android.view.animation.Interpolator;

final class ct
  implements Runnable
{
  ct(cs paramcs) {}
  
  public final void run()
  {
    cs localcs = a;
    if (c)
    {
      float f2 = (float)(SystemClock.uptimeMillis() - b) / d;
      float f1 = f2;
      if (e != null) {
        f1 = e.getInterpolation(f2);
      }
      g = f1;
      if (f != null) {
        f.a();
      }
      if (SystemClock.uptimeMillis() >= b + d) {
        c = false;
      }
    }
    if (c) {
      cs.a.postDelayed(h, 10L);
    }
  }
}

/* Location:
 * Qualified Name:     ct
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */