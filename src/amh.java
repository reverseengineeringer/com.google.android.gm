import android.support.v7.widget.SwitchCompat;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

public final class amh
  implements Animation.AnimationListener
{
  public amh(SwitchCompat paramSwitchCompat, boolean paramBoolean) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    if (b.a == paramAnimation)
    {
      paramAnimation = b;
      if (!a) {
        break label39;
      }
    }
    label39:
    for (float f = 1.0F;; f = 0.0F)
    {
      paramAnimation.a(f);
      b.a = null;
      return;
    }
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}

/* Location:
 * Qualified Name:     amh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */