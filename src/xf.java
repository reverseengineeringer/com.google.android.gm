import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class xf
  implements Animation.AnimationListener
{
  xf(xd paramxd, xh paramxh) {}
  
  public final void onAnimationEnd(Animation paramAnimation) {}
  
  public final void onAnimationRepeat(Animation paramAnimation)
  {
    a.b();
    xh localxh = a;
    localxh.a(localxh.a());
    a.a(a.e);
    if (b.d)
    {
      b.d = false;
      paramAnimation.setDuration(1332L);
      a.a(false);
      return;
    }
    b.c = ((b.c + 1.0F) % 5.0F);
  }
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    b.c = 0.0F;
  }
}

/* Location:
 * Qualified Name:     xf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */