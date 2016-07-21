import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.android.mail.browse.ConversationViewHeader;
import com.android.mail.ui.ConversationViewFragment;

final class clw
  extends AnimatorListenerAdapter
{
  private boolean b;
  
  clw(clv paramclv) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    b = true;
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    a.a.f(0);
    a.a.x.setVisibility(4);
    cxe.d(a.a.A);
    a.a.Y.run();
    if (!b) {
      buq.b.a("open_conv_from_list", true, "open_conversation", "from_list_tablet");
    }
  }
}

/* Location:
 * Qualified Name:     clw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */