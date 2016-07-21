import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

public final class cuv
  extends AnimatorListenerAdapter
{
  private final View a;
  
  public cuv(View paramView)
  {
    a = paramView;
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    a.setLayerType(0, null);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    a.setLayerType(2, null);
  }
}

/* Location:
 * Qualified Name:     cuv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */