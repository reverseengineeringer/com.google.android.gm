package android.support.v4.view;

import android.view.View;

class ViewCompat$JBViewCompatImpl
  extends ViewCompat.ICSViewCompatImpl
{
  public int getImportantForAccessibility(View paramView)
  {
    return ViewCompatJB.getImportantForAccessibility(paramView);
  }
  
  public void postInvalidateOnAnimation(View paramView)
  {
    ViewCompatJB.postInvalidateOnAnimation(paramView);
  }
  
  public void postOnAnimation(View paramView, Runnable paramRunnable)
  {
    ViewCompatJB.postOnAnimation(paramView, paramRunnable);
  }
  
  public void setImportantForAccessibility(View paramView, int paramInt)
  {
    ViewCompatJB.setImportantForAccessibility(paramView, paramInt);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.ViewCompat.JBViewCompatImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */