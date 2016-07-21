import android.view.View;

class rq
  extends rp
{
  public final boolean G(View paramView)
  {
    return paramView.isLaidOut();
  }
  
  public final boolean I(View paramView)
  {
    return paramView.isAttachedToWindow();
  }
  
  public final void c(View paramView, int paramInt)
  {
    paramView.setImportantForAccessibility(paramInt);
  }
  
  public final void e(View paramView, int paramInt)
  {
    paramView.setAccessibilityLiveRegion(1);
  }
}

/* Location:
 * Qualified Name:     rq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */