import android.view.animation.Animation;
import android.view.animation.Transformation;

final class yo
  extends Animation
{
  yo(yg paramyg) {}
  
  public final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f1 = a.g;
    float f2 = -a.g;
    a.a(f1 + f2 * paramFloat);
    paramTransformation = a;
    paramTransformation.a(f + (int)((h - f) * paramFloat) - e.getTop(), false);
  }
}

/* Location:
 * Qualified Name:     yo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */