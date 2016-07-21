import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.animation.LinearInterpolator;
import com.android.mail.browse.ConversationContainer;
import com.android.mail.ui.ConversationViewFragment;

public final class clv
  implements Runnable
{
  public clv(ConversationViewFragment paramConversationViewFragment) {}
  
  public final void run()
  {
    cxe.c(a.A);
    a.f(4);
    a.A.setAlpha(0.0F);
    a.A.setTranslationY(a.z);
    a.A.setVisibility(0);
    if (a.u) {}
    for (int i = 75;; i = 0)
    {
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(a.A, "alpha", new float[] { 0.0F, 1.0F });
      localObjectAnimator1.setInterpolator(new LinearInterpolator());
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(a.A, "translationY", new float[] { 0.0F });
      localObjectAnimator2.setInterpolator(new vs());
      localObjectAnimator2.setDuration(300L);
      a.y = new AnimatorSet();
      a.y.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
      a.y.setStartDelay(i);
      a.y.addListener(new clw(this));
      a.y.start();
      return;
    }
  }
}

/* Location:
 * Qualified Name:     clv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */