import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class yh
  implements Animation.AnimationListener
{
  yh(yg paramyg) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    if (a.b)
    {
      a.i.setAlpha(255);
      a.i.start();
      if ((a.k) && (a.a != null)) {
        a.a.a();
      }
      a.c = a.e.getTop();
      return;
    }
    a.a();
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}

/* Location:
 * Qualified Name:     yh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */