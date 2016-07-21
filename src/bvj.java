import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

final class bvj
  implements ValueAnimator.AnimatorUpdateListener
{
  bvj(bvi parambvi) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = a.h;
    a.h = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f != a.h) {
      a.invalidateSelf();
    }
  }
}

/* Location:
 * Qualified Name:     bvj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */