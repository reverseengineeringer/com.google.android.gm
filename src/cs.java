import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;

final class cs
  extends cq
{
  static final Handler a = new Handler(Looper.getMainLooper());
  long b;
  boolean c;
  int d = 200;
  Interpolator e;
  cr f;
  float g;
  final Runnable h = new ct(this);
  private final int[] i = new int[2];
  private final float[] j = new float[2];
  
  public final void a()
  {
    if (c) {
      return;
    }
    if (e == null) {
      e = new AccelerateDecelerateInterpolator();
    }
    b = SystemClock.uptimeMillis();
    c = true;
    a.postDelayed(h, 10L);
  }
  
  public final void a(float paramFloat1, float paramFloat2)
  {
    j[0] = paramFloat1;
    j[1] = paramFloat2;
  }
  
  public final void a(int paramInt)
  {
    d = paramInt;
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    i[0] = paramInt1;
    i[1] = paramInt2;
  }
  
  public final void a(Interpolator paramInterpolator)
  {
    e = paramInterpolator;
  }
  
  public final void a(cr paramcr)
  {
    f = paramcr;
  }
  
  public final boolean b()
  {
    return c;
  }
  
  public final int c()
  {
    return p.a(i[0], i[1], g);
  }
  
  public final float d()
  {
    return p.a(j[0], j[1], g);
  }
  
  public final void e()
  {
    c = false;
    a.removeCallbacks(h);
  }
}

/* Location:
 * Qualified Name:     cs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */