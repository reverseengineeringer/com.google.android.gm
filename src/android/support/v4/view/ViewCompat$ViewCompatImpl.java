package android.support.v4.view;

import android.graphics.Paint;
import android.view.View;

abstract interface ViewCompat$ViewCompatImpl
{
  public abstract boolean canScrollHorizontally(View paramView, int paramInt);
  
  public abstract int getImportantForAccessibility(View paramView);
  
  public abstract int getOverScrollMode(View paramView);
  
  public abstract void postInvalidateOnAnimation(View paramView);
  
  public abstract void postOnAnimation(View paramView, Runnable paramRunnable);
  
  public abstract void setAccessibilityDelegate(View paramView, AccessibilityDelegateCompat paramAccessibilityDelegateCompat);
  
  public abstract void setImportantForAccessibility(View paramView, int paramInt);
  
  public abstract void setLayerType(View paramView, int paramInt, Paint paramPaint);
}

/* Location:
 * Qualified Name:     android.support.v4.view.ViewCompat.ViewCompatImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */