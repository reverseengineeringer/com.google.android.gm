import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.lang.reflect.Field;
import java.util.WeakHashMap;

class rm
  extends rk
{
  static Field b;
  static boolean c = false;
  
  public final void a(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    paramView.onInitializeAccessibilityEvent(paramAccessibilityEvent);
  }
  
  public final void a(View paramView, ol paramol)
  {
    if (paramol == null) {}
    for (paramol = null;; paramol = b)
    {
      paramView.setAccessibilityDelegate((View.AccessibilityDelegate)paramol);
      return;
    }
  }
  
  public final void a(View paramView, uk paramuk)
  {
    paramView.onInitializeAccessibilityNodeInfo((AccessibilityNodeInfo)b);
  }
  
  public final void a(View paramView, boolean paramBoolean)
  {
    paramView.setFitsSystemWindows(true);
  }
  
  public final boolean a(View paramView, int paramInt)
  {
    return paramView.canScrollHorizontally(paramInt);
  }
  
  public final boolean b(View paramView)
  {
    if (c) {}
    for (;;)
    {
      return false;
      if (b == null) {}
      try
      {
        Field localField = View.class.getDeclaredField("mAccessibilityDelegate");
        b = localField;
        localField.setAccessible(true);
      }
      catch (Throwable paramView)
      {
        try
        {
          paramView = b.get(paramView);
          if (paramView == null) {
            continue;
          }
          return true;
        }
        catch (Throwable paramView)
        {
          c = true;
        }
        paramView = paramView;
        c = true;
        return false;
      }
    }
    return false;
  }
  
  public final boolean b(View paramView, int paramInt)
  {
    return paramView.canScrollVertically(paramInt);
  }
  
  public final tg u(View paramView)
  {
    if (a == null) {
      a = new WeakHashMap();
    }
    tg localtg2 = (tg)a.get(paramView);
    tg localtg1 = localtg2;
    if (localtg2 == null)
    {
      localtg1 = new tg(paramView);
      a.put(paramView, localtg1);
    }
    return localtg1;
  }
}

/* Location:
 * Qualified Name:     rm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */