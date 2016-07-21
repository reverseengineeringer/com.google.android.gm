import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.android.mail.ui.TwoPaneLayout;

public final class crd
  implements ValueAnimator.AnimatorUpdateListener
{
  public crd(TwoPaneLayout paramTwoPaneLayout) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (a.j)
    {
      i = (int)a.g.getX() + a.g.getWidth();
      a.invalidate(i, 0, a.k + i, a.getBottom());
      return;
    }
    int i = (int)a.g.getX();
    a.invalidate(i - a.k, 0, i, a.getBottom());
  }
}

/* Location:
 * Qualified Name:     crd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */