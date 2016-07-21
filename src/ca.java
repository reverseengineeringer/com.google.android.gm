import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class ca
  implements Animation.AnimationListener
{
  ca(bz parambz) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    if (a.c == paramAnimation) {
      a.c = null;
    }
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}

/* Location:
 * Qualified Name:     ca
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */