import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ScrollView;

public final class xi
  extends ol
{
  public final void a(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.a(paramView, paramAccessibilityEvent);
    paramView = (NestedScrollView)paramView;
    paramAccessibilityEvent.setClassName(ScrollView.class.getName());
    paramAccessibilityEvent = ub.a(paramAccessibilityEvent);
    if (paramView.a() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramAccessibilityEvent.a(bool);
      int i = paramView.getScrollX();
      vk.a.c(b, i);
      i = paramView.getScrollY();
      vk.a.d(b, i);
      i = paramView.getScrollX();
      vk.a.f(b, i);
      i = paramView.a();
      vk.a.g(b, i);
      return;
    }
  }
  
  public final void a(View paramView, uk paramuk)
  {
    super.a(paramView, paramuk);
    paramView = (NestedScrollView)paramView;
    paramuk.b(ScrollView.class.getName());
    if (paramView.isEnabled())
    {
      int i = paramView.a();
      if (i > 0)
      {
        paramuk.h(true);
        if (paramView.getScrollY() > 0) {
          paramuk.a(8192);
        }
        if (paramView.getScrollY() < i) {
          paramuk.a(4096);
        }
      }
    }
  }
  
  public final boolean a(View paramView, int paramInt, Bundle paramBundle)
  {
    if (super.a(paramView, paramInt, paramBundle)) {
      return true;
    }
    paramView = (NestedScrollView)paramView;
    if (!paramView.isEnabled()) {
      return false;
    }
    switch (paramInt)
    {
    default: 
      return false;
    case 4096: 
      paramInt = Math.min(paramView.getHeight() - paramView.getPaddingBottom() - paramView.getPaddingTop() + paramView.getScrollY(), paramView.a());
      if (paramInt != paramView.getScrollY())
      {
        paramView.a(paramInt);
        return true;
      }
      return false;
    }
    paramInt = paramView.getHeight();
    int i = paramView.getPaddingBottom();
    int j = paramView.getPaddingTop();
    paramInt = Math.max(paramView.getScrollY() - (paramInt - i - j), 0);
    if (paramInt != paramView.getScrollY())
    {
      paramView.a(paramInt);
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     xi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */