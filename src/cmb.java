import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.android.mail.ui.ConversationViewFragment;

public final class cmb
  extends AnimatorListenerAdapter
{
  public cmb(ConversationViewFragment paramConversationViewFragment, Runnable paramRunnable) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    b.b.q().l();
    if (a != null) {
      a.run();
    }
  }
}

/* Location:
 * Qualified Name:     cmb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */