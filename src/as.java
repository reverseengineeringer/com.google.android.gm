import android.view.animation.Animation;
import android.view.animation.Transformation;

abstract class as
  extends Animation
{
  private float b;
  private float c;
  
  as(ap paramap) {}
  
  protected abstract float a();
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    paramTransformation = a.b;
    paramTransformation.a(b + c * paramFloat, h);
  }
  
  public void reset()
  {
    super.reset();
    b = a.b.j;
    c = (a() - b);
  }
}

/* Location:
 * Qualified Name:     as
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */