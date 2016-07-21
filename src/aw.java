import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

final class aw
  extends AnimatorListenerAdapter
{
  private boolean d;
  
  aw(av paramav, boolean paramBoolean, ba paramba) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    c.c = false;
    d = true;
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    c.c = false;
    if (!d) {
      c.m.a(8, a);
    }
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    c.c = true;
    d = false;
    c.m.a(0, a);
  }
}

/* Location:
 * Qualified Name:     aw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */