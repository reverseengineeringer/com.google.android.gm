import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public final class coh
{
  private final coi a;
  private final ViewConfiguration b;
  private boolean c;
  private VelocityTracker d;
  private float e;
  private float f;
  private float g;
  
  public coh(Context paramContext, coi paramcoi)
  {
    a = paramcoi;
    b = ViewConfiguration.get(paramContext);
  }
  
  private final void a(boolean paramBoolean, float paramFloat)
  {
    c = paramBoolean;
    if (c)
    {
      g = paramFloat;
      a.a();
      return;
    }
    d.computeCurrentVelocity(1000);
    float f1 = d.getXVelocity();
    if (Math.abs(f1) > b.getScaledMinimumFlingVelocity()) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      d.clear();
      a.a(paramFloat - g, f1, paramBoolean);
      return;
    }
  }
  
  public final boolean a(MotionEvent paramMotionEvent, int paramInt, Float paramFloat)
  {
    int i = 0;
    if (d == null) {
      d = VelocityTracker.obtain();
    }
    d.addMovement(paramMotionEvent);
    float f1;
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        for (;;)
        {
          return c;
          e = paramMotionEvent.getX();
          f = paramMotionEvent.getY();
          continue;
          if (!c) {
            break;
          }
          a.a(paramMotionEvent.getX() - g);
        }
        f1 = paramMotionEvent.getX();
      } while (((paramInt == 0) && (f1 <= e)) || ((paramInt == 1) && (f1 >= e)));
      if (paramFloat != null) {
        if (paramInt == 0)
        {
          paramInt = i;
          if (f1 > paramFloat.floatValue()) {
            paramInt = 1;
          }
        }
      }
      break;
    }
    for (;;)
    {
      float f2 = Math.abs(f1 - e);
      float f3 = Math.abs(paramMotionEvent.getY() - f);
      if ((f2 < b.getScaledTouchSlop()) || (f2 < f3) || (paramInt == 0)) {
        break;
      }
      a(true, f1);
      break;
      paramInt = i;
      if (f1 < paramFloat.floatValue())
      {
        paramInt = 1;
        continue;
        if (!c) {
          break;
        }
        a(false, paramMotionEvent.getX());
        break;
        paramInt = 1;
      }
    }
  }
}

/* Location:
 * Qualified Name:     coh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */