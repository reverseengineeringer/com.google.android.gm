import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;

final class vw
  implements Runnable
{
  vw(vu paramvu) {}
  
  public final void run()
  {
    if (!a.e) {
      return;
    }
    if (a.c)
    {
      a.c = false;
      localvv = a.a;
      e = AnimationUtils.currentAnimationTimeMillis();
      i = -1L;
      f = e;
      j = 0.5F;
      g = 0;
      h = 0;
    }
    vv localvv = a.a;
    if ((i > 0L) && (AnimationUtils.currentAnimationTimeMillis() > i + k)) {}
    for (int i = 1; (i != 0) || (!a.a()); i = 0)
    {
      a.e = false;
      return;
    }
    if (a.d)
    {
      a.d = false;
      vu localvu = a;
      l1 = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l1, l1, 3, 0.0F, 0.0F, 0);
      b.onTouchEvent(localMotionEvent);
      localMotionEvent.recycle();
    }
    if (f == 0L) {
      throw new RuntimeException("Cannot compute scroll delta before calling start()");
    }
    long l1 = AnimationUtils.currentAnimationTimeMillis();
    float f = localvv.a(l1);
    f = f * 4.0F + -4.0F * f * f;
    long l2 = l1 - f;
    f = l1;
    g = ((int)((float)l2 * f * c));
    h = ((int)((float)l2 * f * d));
    i = h;
    a.a(i);
    rg.a(a.b, this);
  }
}

/* Location:
 * Qualified Name:     vw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */