import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.View;

class rk
  extends rj
{
  public final void A(View paramView)
  {
    paramView.jumpDrawablesToCurrentState();
  }
  
  public final int a(int paramInt1, int paramInt2)
  {
    return View.combineMeasuredStates(paramInt1, paramInt2);
  }
  
  public final int a(int paramInt1, int paramInt2, int paramInt3)
  {
    return View.resolveSizeAndState(paramInt1, paramInt2, paramInt3);
  }
  
  final long a()
  {
    return ValueAnimator.getFrameDelay();
  }
  
  public final void a(View paramView, float paramFloat)
  {
    paramView.setTranslationX(paramFloat);
  }
  
  public final void a(View paramView, int paramInt, Paint paramPaint)
  {
    paramView.setLayerType(paramInt, paramPaint);
  }
  
  public void a(View paramView, Paint paramPaint)
  {
    a(paramView, paramView.getLayerType(), paramPaint);
    paramView.invalidate();
  }
  
  public final void b(View paramView, float paramFloat)
  {
    paramView.setTranslationY(paramFloat);
  }
  
  public final void b(View paramView, boolean paramBoolean)
  {
    paramView.setSaveFromParentEnabled(false);
  }
  
  public final void c(View paramView, float paramFloat)
  {
    paramView.setAlpha(paramFloat);
  }
  
  public final void c(View paramView, boolean paramBoolean)
  {
    paramView.setActivated(paramBoolean);
  }
  
  public final void d(View paramView, float paramFloat)
  {
    paramView.setScaleX(paramFloat);
  }
  
  public final void e(View paramView, float paramFloat)
  {
    paramView.setScaleY(paramFloat);
  }
  
  public final float f(View paramView)
  {
    return paramView.getAlpha();
  }
  
  public void f(View paramView, int paramInt)
  {
    rw.b(paramView, paramInt);
  }
  
  public final int g(View paramView)
  {
    return paramView.getLayerType();
  }
  
  public void g(View paramView, int paramInt)
  {
    rw.a(paramView, paramInt);
  }
  
  public final int k(View paramView)
  {
    return paramView.getMeasuredWidthAndState();
  }
  
  public final int l(View paramView)
  {
    return paramView.getMeasuredState();
  }
  
  public final float p(View paramView)
  {
    return paramView.getTranslationX();
  }
  
  public final float q(View paramView)
  {
    return paramView.getTranslationY();
  }
  
  public final float r(View paramView)
  {
    return paramView.getScaleX();
  }
}

/* Location:
 * Qualified Name:     rk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */