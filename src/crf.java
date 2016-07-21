import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.android.mail.ui.TwoPaneLayout;

public final class crf
  extends AnimatorListenerAdapter
{
  public crf(TwoPaneLayout paramTwoPaneLayout) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    a.h.setLayerType(0, null);
  }
}

/* Location:
 * Qualified Name:     crf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */