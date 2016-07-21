import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.google.android.apps.work.common.richedittext.RichTextToolbar;

public final class dcz
  implements Animator.AnimatorListener
{
  public dcz(RichTextToolbar paramRichTextToolbar, int paramInt) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    b.setVisibility(a);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    if (a != 0) {
      b.setVisibility(a);
    }
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    if (a == 0) {
      b.setVisibility(a);
    }
  }
}

/* Location:
 * Qualified Name:     dcz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */