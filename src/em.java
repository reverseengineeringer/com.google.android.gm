import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;

final class em
  implements ek
{
  private TimeInterpolator a;
  
  public final void a(View paramView)
  {
    if (a == null) {
      a = new ValueAnimator().getInterpolator();
    }
    paramView.animate().setInterpolator(a);
  }
}

/* Location:
 * Qualified Name:     em
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */