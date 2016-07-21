import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;

final class xe
  extends Animation
{
  xe(xd paramxd, xh paramxh) {}
  
  public final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    if (b.d)
    {
      paramTransformation = a;
      xd.a(paramFloat, paramTransformation);
      f1 = (float)(Math.floor(m / 0.8F) + 1.0D);
      f2 = xd.a(paramTransformation);
      f3 = k;
      paramTransformation.a((l - f2 - k) * paramFloat + f3);
      paramTransformation.b(l);
      f2 = m;
      paramTransformation.c((f1 - m) * paramFloat + f2);
      return;
    }
    float f1 = xd.a(a);
    float f2 = a.l;
    float f4 = a.k;
    float f3 = a.m;
    xd.a(paramFloat, a);
    if (paramFloat <= 0.5F)
    {
      float f5 = paramFloat / 0.5F;
      f5 = xd.a.getInterpolation(f5);
      a.a(f4 + f5 * (0.8F - f1));
    }
    if (paramFloat > 0.5F)
    {
      f4 = (paramFloat - 0.5F) / 0.5F;
      f4 = xd.a.getInterpolation(f4);
      a.b((0.8F - f1) * f4 + f2);
    }
    a.c(0.25F * paramFloat + f3);
    f1 = b.c / 5.0F;
    b.c(216.0F * paramFloat + 1080.0F * f1);
  }
}

/* Location:
 * Qualified Name:     xe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */