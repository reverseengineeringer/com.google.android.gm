package android.support.v4.view;

import android.view.View;
import android.view.View.AccessibilityDelegate;

class ViewCompatICS
{
  public static boolean canScrollHorizontally(View paramView, int paramInt)
  {
    return paramView.canScrollHorizontally(paramInt);
  }
  
  public static void setAccessibilityDelegate(View paramView, Object paramObject)
  {
    paramView.setAccessibilityDelegate((View.AccessibilityDelegate)paramObject);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.ViewCompatICS
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */