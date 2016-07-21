import android.support.v4.app.Fragment;
import android.view.View;
import android.view.animation.Animation;

final class fu
  extends fv
{
  fu(fr paramfr, View paramView, Animation paramAnimation, Fragment paramFragment)
  {
    super(paramView, paramAnimation);
  }
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    super.onAnimationEnd(paramAnimation);
    if (a.l != null)
    {
      a.l = null;
      b.a(a, a.m, 0, 0, false);
    }
  }
}

/* Location:
 * Qualified Name:     fu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */