import android.animation.ValueAnimator;
import android.view.animation.Interpolator;

final class cu
  extends cq
{
  final ValueAnimator a = new ValueAnimator();
  
  public final void a()
  {
    a.start();
  }
  
  public final void a(float paramFloat1, float paramFloat2)
  {
    a.setFloatValues(new float[] { paramFloat1, paramFloat2 });
  }
  
  public final void a(int paramInt)
  {
    a.setDuration(paramInt);
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    a.setIntValues(new int[] { paramInt1, paramInt2 });
  }
  
  public final void a(Interpolator paramInterpolator)
  {
    a.setInterpolator(paramInterpolator);
  }
  
  public final void a(cr paramcr)
  {
    a.addUpdateListener(new cv(this, paramcr));
  }
  
  public final boolean b()
  {
    return a.isRunning();
  }
  
  public final int c()
  {
    return ((Integer)a.getAnimatedValue()).intValue();
  }
  
  public final float d()
  {
    return ((Float)a.getAnimatedValue()).floatValue();
  }
  
  public final void e()
  {
    a.cancel();
  }
}

/* Location:
 * Qualified Name:     cu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */