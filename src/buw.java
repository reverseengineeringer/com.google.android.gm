import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.res.Resources;

public final class buw
  extends bvi
  implements ValueAnimator.AnimatorUpdateListener
{
  public final bva a = (bva)b;
  private final bux j = (bux)c;
  private final ValueAnimator k;
  private final ValueAnimator l;
  
  public buw(Resources paramResources, int paramInt)
  {
    super(new bva(paramResources), new bux(paramResources), paramInt);
    long l1 = e + d / 2;
    long l2 = d / 2 + f;
    k = ValueAnimator.ofFloat(new float[] { 0.2F, 1.0F }).setDuration(l2);
    k.setStartDelay(l1);
    k.addUpdateListener(this);
    l = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(l2);
    l.setStartDelay(l1);
    l.addUpdateListener(this);
  }
  
  public final void a()
  {
    super.a();
    if ((!k.isStarted()) && (!i))
    {
      k.start();
      l.start();
      return;
    }
    k.reverse();
    l.reverse();
  }
  
  public final void a(boolean paramBoolean)
  {
    float f2 = 1.0F;
    super.a(paramBoolean);
    if (k == null) {
      return;
    }
    k.cancel();
    l.cancel();
    bux localbux = j;
    if (paramBoolean) {}
    for (float f1 = 0.2F;; f1 = 1.0F)
    {
      localbux.a(f1);
      localbux = j;
      f1 = f2;
      if (paramBoolean) {
        f1 = 0.0F;
      }
      localbux.b(f1);
      return;
    }
  }
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (paramValueAnimator == k) {
      j.a(f);
    }
    while (paramValueAnimator != l) {
      return;
    }
    j.b(f);
  }
}

/* Location:
 * Qualified Name:     buw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */