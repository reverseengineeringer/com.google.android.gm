import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

public final class st
  extends ol
{
  public st(ViewPager paramViewPager) {}
  
  private final boolean a()
  {
    return (a.b != null) && (a.b.a() > 1);
  }
  
  public final void a(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.a(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(ViewPager.class.getName());
    paramView = ub.a(paramAccessibilityEvent);
    paramView.a(a());
    if ((paramAccessibilityEvent.getEventType() == 4096) && (a.b != null))
    {
      paramView.a(a.b.a());
      paramView.b(a.c);
      paramView.c(a.c);
    }
  }
  
  public final void a(View paramView, uk paramuk)
  {
    super.a(paramView, paramuk);
    paramuk.b(ViewPager.class.getName());
    paramuk.h(a());
    if (a.canScrollHorizontally(1)) {
      paramuk.a(4096);
    }
    if (a.canScrollHorizontally(-1)) {
      paramuk.a(8192);
    }
  }
  
  public final boolean a(View paramView, int paramInt, Bundle paramBundle)
  {
    if (super.a(paramView, paramInt, paramBundle)) {
      return true;
    }
    switch (paramInt)
    {
    default: 
      return false;
    case 4096: 
      if (a.canScrollHorizontally(1))
      {
        a.b(a.c + 1);
        return true;
      }
      return false;
    }
    if (a.canScrollHorizontally(-1))
    {
      a.b(a.c - 1);
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     st
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */