package android.support.v4.view;

import android.view.View;

public class ViewCompatJB
{
  public static int getImportantForAccessibility(View paramView)
  {
    return paramView.getImportantForAccessibility();
  }
  
  public static void postInvalidateOnAnimation(View paramView)
  {
    paramView.postInvalidateOnAnimation();
  }
  
  public static void postOnAnimation(View paramView, Runnable paramRunnable)
  {
    paramView.postOnAnimation(paramRunnable);
  }
  
  public static void setImportantForAccessibility(View paramView, int paramInt)
  {
    paramView.setImportantForAccessibility(paramInt);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.ViewCompatJB
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */