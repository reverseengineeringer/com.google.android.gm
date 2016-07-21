import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.gm.happiness.HatsHolder;

public final class dml
  extends AnimatorListenerAdapter
{
  public dml(HatsHolder paramHatsHolder) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    a.postDelayed(new dmm(this), 2000L);
  }
}

/* Location:
 * Qualified Name:     dml
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */