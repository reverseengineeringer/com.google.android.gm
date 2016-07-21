import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gm.happiness.HatsHolder;

public final class dmi
  implements ValueAnimator.AnimatorUpdateListener
{
  public dmi(HatsHolder paramHatsHolder) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    ViewGroup.LayoutParams localLayoutParams = a.getLayoutParams();
    height = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    a.setLayoutParams(localLayoutParams);
  }
}

/* Location:
 * Qualified Name:     dmi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */