import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import java.util.WeakHashMap;

class tj
  extends th
{
  WeakHashMap<View, Integer> b = null;
  
  public final long a(View paramView)
  {
    return paramView.animate().getDuration();
  }
  
  public final void a(View paramView, long paramLong)
  {
    paramView.animate().setDuration(paramLong);
  }
  
  public final void a(View paramView, Interpolator paramInterpolator)
  {
    paramView.animate().setInterpolator(paramInterpolator);
  }
  
  public final void a(tg paramtg, View paramView)
  {
    paramView.animate().cancel();
  }
  
  public final void a(tg paramtg, View paramView, float paramFloat)
  {
    paramView.animate().alpha(paramFloat);
  }
  
  public void a(tg paramtg, View paramView, tw paramtw)
  {
    paramView.setTag(2113929216, paramtw);
    paramtg = new tk(paramtg);
    paramView.animate().setListener(new tr(paramtg, paramView));
  }
  
  public final void b(View paramView, long paramLong)
  {
    paramView.animate().setStartDelay(paramLong);
  }
  
  public final void b(tg paramtg, View paramView)
  {
    paramView.animate().start();
  }
  
  public final void b(tg paramtg, View paramView, float paramFloat)
  {
    paramView.animate().translationX(paramFloat);
  }
  
  public final void c(tg paramtg, View paramView, float paramFloat)
  {
    paramView.animate().translationY(paramFloat);
  }
}

/* Location:
 * Qualified Name:     tj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */