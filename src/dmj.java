import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.google.android.gm.happiness.HatsHolder;

public final class dmj
  extends AnimatorListenerAdapter
{
  public dmj(HatsHolder paramHatsHolder, View paramView) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    a.setAlpha(1.0F);
    a.setVisibility(8);
    paramAnimator = b.getLayoutParams();
    height = -2;
    b.setLayoutParams(paramAnimator);
  }
}

/* Location:
 * Qualified Name:     dmj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */