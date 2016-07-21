import android.view.animation.Animation;
import android.view.animation.Transformation;

final class yk
  extends Animation
{
  yk(yg paramyg, int paramInt1, int paramInt2) {}
  
  public final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    c.i.setAlpha((int)(a + (b - a) * paramFloat));
  }
}

/* Location:
 * Qualified Name:     yk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */