import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;

class rn
  extends rl
{
  public final void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.postInvalidate(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public final void a(View paramView, Runnable paramRunnable)
  {
    paramView.postOnAnimation(paramRunnable);
  }
  
  public final void a(View paramView, Runnable paramRunnable, long paramLong)
  {
    paramView.postOnAnimationDelayed(paramRunnable, paramLong);
  }
  
  public final boolean a(View paramView, int paramInt, Bundle paramBundle)
  {
    return paramView.performAccessibilityAction(paramInt, paramBundle);
  }
  
  public void c(View paramView, int paramInt)
  {
    int i = paramInt;
    if (paramInt == 4) {
      i = 2;
    }
    paramView.setImportantForAccessibility(i);
  }
  
  public final boolean c(View paramView)
  {
    return paramView.hasTransientState();
  }
  
  public final void d(View paramView)
  {
    paramView.postInvalidateOnAnimation();
  }
  
  public final int e(View paramView)
  {
    return paramView.getImportantForAccessibility();
  }
  
  public final ViewParent i(View paramView)
  {
    return paramView.getParentForAccessibility();
  }
  
  public final boolean o(View paramView)
  {
    return paramView.hasOverlappingRendering();
  }
  
  public final int s(View paramView)
  {
    return paramView.getMinimumWidth();
  }
  
  public final int t(View paramView)
  {
    return paramView.getMinimumHeight();
  }
  
  public void w(View paramView)
  {
    paramView.requestFitSystemWindows();
  }
  
  public final boolean z(View paramView)
  {
    return paramView.getFitsSystemWindows();
  }
}

/* Location:
 * Qualified Name:     rn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */