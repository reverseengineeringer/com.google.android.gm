import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

final class cqy
  implements ValueAnimator.AnimatorUpdateListener
{
  cqy(cqw paramcqw, float paramFloat, cnk paramcnk, boolean paramBoolean) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    d.a(f);
    if (f == a) {
      b.a(c);
    }
  }
}

/* Location:
 * Qualified Name:     cqy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */