import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import com.android.mail.browse.ConversationItemView;
import com.android.mail.ui.ConversationViewFragment;

public final class cmd
  extends AnimatorListenerAdapter
{
  private boolean e;
  
  public cmd(ConversationViewFragment paramConversationViewFragment, cpf paramcpf, ConversationItemView paramConversationItemView, Runnable paramRunnable) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    e = true;
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    if ((d.isAdded()) && (!e))
    {
      a.au();
      d.w.setBackgroundResource(0);
      b.setVisibility(4);
      d.C.a(d.b(), d.n());
      if (c != null) {
        c.run();
      }
    }
  }
}

/* Location:
 * Qualified Name:     cmd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */