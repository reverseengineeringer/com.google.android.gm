import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import com.android.mail.ui.ConversationViewFrame;
import com.android.mail.ui.TwoPaneLayout;

public final class crg
  extends AnimatorListenerAdapter
  implements Runnable
{
  public crg(TwoPaneLayout paramTwoPaneLayout) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    if (!a.c) {
      ((ConversationViewFrame)a.h).setForeground(null);
    }
    a.d();
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    if (!a.c) {
      ((ConversationViewFrame)a.h).setForeground(a.getResources().getDrawable(bub.as));
    }
    if (!cxd.c())
    {
      paramAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      paramAnimator.setDuration(250L).addUpdateListener(a.l);
      paramAnimator.start();
    }
  }
  
  public final void run()
  {
    a.d();
  }
}

/* Location:
 * Qualified Name:     crg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */