import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class blw
  implements Animation.AnimationListener
{
  blw(blq paramblq) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = a;
    c.finish();
    c.overridePendingTransition(0, 0);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}

/* Location:
 * Qualified Name:     blw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */