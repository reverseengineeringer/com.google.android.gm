import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.android.mail.browse.ConversationPager;

public final class bxm
  extends AnimatorListenerAdapter
{
  public bxm(bxl parambxl, Runnable paramRunnable) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    if (b.b != null) {
      b.b.m = false;
    }
    b.a(true);
    a.run();
    b.a.setTranslationY(0.0F);
  }
}

/* Location:
 * Qualified Name:     bxm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */