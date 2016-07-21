import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import com.android.mail.browse.ConversationContainer;
import com.android.mail.ui.ConversationViewFragment;

public final class clt
  implements Runnable
{
  public clt(ConversationViewFragment paramConversationViewFragment) {}
  
  public final void run()
  {
    cxe.c(a.A);
    a.A.setAlpha(0.0F);
    a.A.setVisibility(0);
    a.A.animate().alpha(1.0F).setDuration(93L).setInterpolator(new LinearInterpolator()).setListener(new clu(this));
  }
}

/* Location:
 * Qualified Name:     clt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */