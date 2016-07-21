import android.view.View;
import android.view.animation.Interpolator;
import java.util.WeakHashMap;

class th
  implements tp
{
  WeakHashMap<View, Runnable> a = null;
  
  private final void d(tg paramtg, View paramView)
  {
    Runnable localRunnable = null;
    if (a != null) {
      localRunnable = (Runnable)a.get(paramView);
    }
    Object localObject = localRunnable;
    if (localRunnable == null)
    {
      localObject = new ti(this, paramtg, paramView);
      if (a == null) {
        a = new WeakHashMap();
      }
      a.put(paramView, localObject);
    }
    paramView.removeCallbacks((Runnable)localObject);
    paramView.post((Runnable)localObject);
  }
  
  public long a(View paramView)
  {
    return 0L;
  }
  
  public void a(View paramView, long paramLong) {}
  
  public void a(View paramView, Interpolator paramInterpolator) {}
  
  public void a(View paramView, ty paramty) {}
  
  public void a(tg paramtg, View paramView)
  {
    d(paramtg, paramView);
  }
  
  public void a(tg paramtg, View paramView, float paramFloat)
  {
    d(paramtg, paramView);
  }
  
  public void a(tg paramtg, View paramView, tw paramtw)
  {
    paramView.setTag(2113929216, paramtw);
  }
  
  public void b(View paramView, long paramLong) {}
  
  public void b(tg paramtg, View paramView)
  {
    if (a != null)
    {
      Runnable localRunnable = (Runnable)a.get(paramView);
      if (localRunnable != null) {
        paramView.removeCallbacks(localRunnable);
      }
    }
    c(paramtg, paramView);
  }
  
  public void b(tg paramtg, View paramView, float paramFloat)
  {
    d(paramtg, paramView);
  }
  
  final void c(tg paramtg, View paramView)
  {
    Object localObject = paramView.getTag(2113929216);
    if ((localObject instanceof tw)) {}
    for (localObject = (tw)localObject;; localObject = null)
    {
      Runnable localRunnable1 = b;
      Runnable localRunnable2 = c;
      b = null;
      c = null;
      if (localRunnable1 != null) {
        localRunnable1.run();
      }
      if (localObject != null)
      {
        ((tw)localObject).a(paramView);
        ((tw)localObject).b(paramView);
      }
      if (localRunnable2 != null) {
        localRunnable2.run();
      }
      if (a != null) {
        a.remove(paramView);
      }
      return;
    }
  }
  
  public void c(tg paramtg, View paramView, float paramFloat)
  {
    d(paramtg, paramView);
  }
}

/* Location:
 * Qualified Name:     th
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */