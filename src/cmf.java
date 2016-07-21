import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.android.mail.browse.ConversationItemView;
import com.android.mail.ui.ConversationViewFragment;
import com.android.mail.ui.MailActivity;

public final class cmf
  extends AnimatorListenerAdapter
{
  public cmf(ConversationViewFragment paramConversationViewFragment, Runnable paramRunnable, MailActivity paramMailActivity, ConversationItemView paramConversationItemView) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    a.run();
    if (b != null)
    {
      cxe.d(c);
      b.l.g(false);
    }
  }
}

/* Location:
 * Qualified Name:     cmf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */