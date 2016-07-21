import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

final class ctg
  extends AnimatorListenerAdapter
{
  ctg(cte paramcte) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    a.e = false;
    a.f = System.currentTimeMillis();
  }
}

/* Location:
 * Qualified Name:     ctg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */