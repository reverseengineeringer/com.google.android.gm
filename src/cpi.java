import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.app.Fragment;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import com.android.mail.browse.ConversationPager;
import com.android.mail.providers.Conversation;

final class cpi
  extends cog
{
  cpi(cph paramcph, String paramString, Fragment paramFragment, cjf paramcjf, cqp paramcqp, View paramView, cje paramcje)
  {
    super(paramString, paramFragment);
  }
  
  public final void a()
  {
    long l = a.d.b;
    if (!b.a(l)) {}
    Object localObject2;
    cpj localcpj;
    for (boolean bool = true;; bool = false)
    {
      localObject2 = new vs();
      localcpj = new cpj(this, l, bool);
      cxe.c(c);
      if (c.getAlpha() == 1.0F)
      {
        c.setAlpha(0.0F);
        c.setScaleX(0.95F);
        c.setScaleY(0.95F);
      }
      localObject1 = ObjectAnimator.ofFloat(c, "alpha", new float[] { 1.0F });
      ((ObjectAnimator)localObject1).setInterpolator(new LinearInterpolator());
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(c, "scaleX", new float[] { 1.0F });
      localObjectAnimator1.setInterpolator((TimeInterpolator)localObject2);
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(c, "scaleY", new float[] { 1.0F });
      localObjectAnimator2.setInterpolator((TimeInterpolator)localObject2);
      localObject2 = new AnimatorSet();
      ((AnimatorSet)localObject2).playTogether(new Animator[] { localObject1, localObjectAnimator1, localObjectAnimator2 });
      ((AnimatorSet)localObject2).setDuration(210L);
      ((AnimatorSet)localObject2).setStartDelay(70L);
      ((AnimatorSet)localObject2).addListener(new cpk(this));
      if (!bool) {
        break;
      }
      a.a(d, (AnimatorSet)localObject2, localcpj);
      return;
    }
    Object localObject1 = e.a.G;
    a.animate().translationY(a.getHeight()).setDuration(200L).setInterpolator(new vq()).setListener(new bxm((bxl)localObject1, localcpj));
    b.m = true;
    a.a((AnimatorSet)localObject2);
  }
}

/* Location:
 * Qualified Name:     cpi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */