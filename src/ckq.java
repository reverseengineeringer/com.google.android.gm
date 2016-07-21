import android.view.animation.Interpolator;

public final class ckq
  implements Interpolator
{
  public final float getInterpolation(float paramFloat)
  {
    return (float)Math.pow(2.0D, paramFloat) - 1.0F;
  }
}

/* Location:
 * Qualified Name:     ckq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */