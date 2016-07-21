import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public abstract class vu
  implements View.OnTouchListener
{
  private static final int r = ;
  final vv a = new vv();
  final View b;
  boolean c;
  boolean d;
  boolean e;
  private final Interpolator f = new AccelerateInterpolator();
  private Runnable g;
  private float[] h = { 0.0F, 0.0F };
  private float[] i = { Float.MAX_VALUE, Float.MAX_VALUE };
  private int j;
  private int k;
  private float[] l = { 0.0F, 0.0F };
  private float[] m = { 0.0F, 0.0F };
  private float[] n = { Float.MAX_VALUE, Float.MAX_VALUE };
  private boolean o;
  private boolean p;
  private boolean q;
  
  public vu(View paramView)
  {
    b = paramView;
    paramView = Resources.getSystem().getDisplayMetrics();
    int i1 = (int)(1575.0F * density + 0.5F);
    int i2 = (int)(density * 315.0F + 0.5F);
    float f1 = i1;
    n[0] = (f1 / 1000.0F);
    n[1] = (f1 / 1000.0F);
    f1 = i2;
    m[0] = (f1 / 1000.0F);
    m[1] = (f1 / 1000.0F);
    j = 1;
    i[0] = Float.MAX_VALUE;
    i[1] = Float.MAX_VALUE;
    h[0] = 0.2F;
    h[1] = 0.2F;
    l[0] = 0.001F;
    l[1] = 0.001F;
    k = r;
    a.a = 500;
    a.b = 500;
  }
  
  private final float a(float paramFloat1, float paramFloat2)
  {
    if (paramFloat2 == 0.0F) {}
    do
    {
      do
      {
        do
        {
          return 0.0F;
          switch (j)
          {
          default: 
            return 0.0F;
          }
        } while (paramFloat1 >= paramFloat2);
        if (paramFloat1 >= 0.0F) {
          return 1.0F - paramFloat1 / paramFloat2;
        }
      } while ((!e) || (j != 1));
      return 1.0F;
    } while (paramFloat1 >= 0.0F);
    return paramFloat1 / -paramFloat2;
  }
  
  static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 > paramFloat3) {
      return paramFloat3;
    }
    if (paramFloat1 < paramFloat2) {
      return paramFloat2;
    }
    return paramFloat1;
  }
  
  private final float a(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = a(h[paramInt] * paramFloat2, 0.0F, i[paramInt]);
    float f2 = a(paramFloat1, f1);
    paramFloat1 = a(paramFloat2 - paramFloat1, f1) - f2;
    if (paramFloat1 < 0.0F) {
      paramFloat1 = -f.getInterpolation(-paramFloat1);
    }
    for (paramFloat1 = a(paramFloat1, -1.0F, 1.0F);; paramFloat1 = 0.0F)
    {
      if (paramFloat1 != 0.0F) {
        break label102;
      }
      return 0.0F;
      if (paramFloat1 > 0.0F)
      {
        paramFloat1 = f.getInterpolation(paramFloat1);
        break;
      }
    }
    label102:
    f2 = l[paramInt];
    paramFloat2 = m[paramInt];
    f1 = n[paramInt];
    paramFloat3 = f2 * paramFloat3;
    if (paramFloat1 > 0.0F) {
      return a(paramFloat1 * paramFloat3, paramFloat2, f1);
    }
    return -a(-paramFloat1 * paramFloat3, paramFloat2, f1);
  }
  
  private final void b()
  {
    if (c)
    {
      e = false;
      return;
    }
    vv localvv = a;
    long l1 = AnimationUtils.currentAnimationTimeMillis();
    int i1 = (int)(l1 - e);
    int i2 = b;
    if (i1 > i2) {
      i1 = i2;
    }
    for (;;)
    {
      k = i1;
      j = localvv.a(l1);
      i = l1;
      return;
      if (i1 < 0) {
        i1 = 0;
      }
    }
  }
  
  public final vu a(boolean paramBoolean)
  {
    if ((p) && (!paramBoolean)) {
      b();
    }
    p = paramBoolean;
    return this;
  }
  
  public abstract void a(int paramInt);
  
  final boolean a()
  {
    vv localvv = a;
    int i1 = (int)(d / Math.abs(d));
    int i2 = (int)(c / Math.abs(c));
    if ((i1 == 0) || (!b(i1)))
    {
      if (i2 != 0) {}
      return false;
    }
    return true;
  }
  
  public abstract boolean b(int paramInt);
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!p) {}
    for (;;)
    {
      return false;
      switch (qk.a(paramMotionEvent))
      {
      }
      while ((q) && (e))
      {
        return true;
        d = true;
        o = false;
        float f1 = a(0, paramMotionEvent.getX(), paramView.getWidth(), b.getWidth());
        float f2 = a(1, paramMotionEvent.getY(), paramView.getHeight(), b.getHeight());
        paramView = a;
        c = f1;
        d = f2;
        if ((!e) && (a()))
        {
          if (g == null) {
            g = new vw(this);
          }
          e = true;
          c = true;
          if ((!o) && (k > 0)) {
            rg.a(b, g, k);
          }
          for (;;)
          {
            o = true;
            break;
            g.run();
          }
          b();
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     vu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */