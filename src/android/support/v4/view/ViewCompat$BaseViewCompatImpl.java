package android.support.v4.view;

import android.graphics.Paint;
import android.view.View;

class ViewCompat$BaseViewCompatImpl
  implements ViewCompat.ViewCompatImpl
{
  public boolean canScrollHorizontally(View paramView, int paramInt)
  {
    return false;
  }
  
  long getFrameTime()
  {
    return 10L;
  }
  
  public int getImportantForAccessibility(View paramView)
  {
    return 0;
  }
  
  public int getOverScrollMode(View paramView)
  {
    return 2;
  }
  
  public void postInvalidateOnAnimation(View paramView)
  {
    paramView.postInvalidateDelayed(getFrameTime());
  }
  
  public void postOnAnimation(View paramView, Runnable paramRunnable)
  {
    paramView.postDelayed(paramRunnable, getFrameTime());
  }
  
  public void setAccessibilityDelegate(View paramView, AccessibilityDelegateCompat paramAccessibilityDelegateCompat) {}
  
  public void setImportantForAccessibility(View paramView, int paramInt) {}
  
  public void setLayerType(View paramView, int paramInt, Paint paramPaint) {}
}

/* Location:
 * Qualified Name:     android.support.v4.view.ViewCompat.BaseViewCompatImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */