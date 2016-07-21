import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

final class cqz
  extends AnimatorListenerAdapter
{
  cqz(cqw paramcqw, Runnable paramRunnable) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    if (a != null) {
      a.run();
    }
  }
}

/* Location:
 * Qualified Name:     cqz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */