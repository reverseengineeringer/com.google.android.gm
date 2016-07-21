import android.view.animation.Animation;
import android.view.animation.Transformation;

final class ym
  extends Animation
{
  ym(yg paramyg) {}
  
  public final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    if (!a.l) {}
    for (int i = (int)(a.j - Math.abs(a.h));; i = (int)a.j)
    {
      int j = a.f;
      i = (int)((i - a.f) * paramFloat);
      int k = a.e.getTop();
      a.a(i + j - k, false);
      a.i.a(1.0F - paramFloat);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     ym
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */