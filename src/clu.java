import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import com.android.mail.browse.ConversationContainer;
import com.android.mail.ui.ConversationViewFragment;

final class clu
  extends AnimatorListenerAdapter
{
  private boolean b;
  
  clu(clt paramclt) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    b = true;
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    a.a.A.setLayerType(0, null);
    if (!b)
    {
      a.a.w.setVisibility(4);
      a.a.Y.run();
      buq.b.a("open_conv_from_list", true, "open_conversation", "from_list_phone");
    }
  }
}

/* Location:
 * Qualified Name:     clu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */