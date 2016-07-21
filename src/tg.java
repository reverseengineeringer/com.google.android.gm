import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

public final class tg
{
  public static final tp e = new th();
  public WeakReference<View> a;
  Runnable b = null;
  Runnable c = null;
  int d = -1;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 21)
    {
      e = new to();
      return;
    }
    if (i >= 19)
    {
      e = new tn();
      return;
    }
    if (i >= 18)
    {
      e = new tl();
      return;
    }
    if (i >= 16)
    {
      e = new tm();
      return;
    }
    if (i >= 14)
    {
      e = new tj();
      return;
    }
  }
  
  tg(View paramView)
  {
    a = new WeakReference(paramView);
  }
  
  public final tg a(float paramFloat)
  {
    View localView = (View)a.get();
    if (localView != null) {
      e.a(this, localView, paramFloat);
    }
    return this;
  }
  
  public final tg a(long paramLong)
  {
    View localView = (View)a.get();
    if (localView != null) {
      e.a(localView, paramLong);
    }
    return this;
  }
  
  public final tg a(Interpolator paramInterpolator)
  {
    View localView = (View)a.get();
    if (localView != null) {
      e.a(localView, paramInterpolator);
    }
    return this;
  }
  
  public final tg a(tw paramtw)
  {
    View localView = (View)a.get();
    if (localView != null) {
      e.a(this, localView, paramtw);
    }
    return this;
  }
  
  public final tg a(ty paramty)
  {
    View localView = (View)a.get();
    if (localView != null) {
      e.a(localView, paramty);
    }
    return this;
  }
  
  public final void a()
  {
    View localView = (View)a.get();
    if (localView != null) {
      e.a(this, localView);
    }
  }
  
  public final tg b(float paramFloat)
  {
    View localView = (View)a.get();
    if (localView != null) {
      e.b(this, localView, paramFloat);
    }
    return this;
  }
  
  public final tg b(long paramLong)
  {
    View localView = (View)a.get();
    if (localView != null) {
      e.b(localView, paramLong);
    }
    return this;
  }
  
  public final void b()
  {
    View localView = (View)a.get();
    if (localView != null) {
      e.b(this, localView);
    }
  }
  
  public final tg c(float paramFloat)
  {
    View localView = (View)a.get();
    if (localView != null) {
      e.c(this, localView, paramFloat);
    }
    return this;
  }
}

/* Location:
 * Qualified Name:     tg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */