import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public class ol
{
  private static final oo a;
  private static final Object c;
  final Object b = a.a(this);
  
  static
  {
    if (Build.VERSION.SDK_INT >= 16) {
      a = new op();
    }
    for (;;)
    {
      c = a.a();
      return;
      if (Build.VERSION.SDK_INT >= 14) {
        a = new om();
      } else {
        a = new or();
      }
    }
  }
  
  public static void a(View paramView, int paramInt)
  {
    a.a(c, paramView, paramInt);
  }
  
  public static void c(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    a.d(c, paramView, paramAccessibilityEvent);
  }
  
  public ux a(View paramView)
  {
    return a.a(c, paramView);
  }
  
  public void a(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    a.b(c, paramView, paramAccessibilityEvent);
  }
  
  public void a(View paramView, uk paramuk)
  {
    a.a(c, paramView, paramuk);
  }
  
  public boolean a(View paramView, int paramInt, Bundle paramBundle)
  {
    return a.a(c, paramView, paramInt, paramBundle);
  }
  
  public boolean a(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return a.a(c, paramViewGroup, paramView, paramAccessibilityEvent);
  }
  
  public void b(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    a.c(c, paramView, paramAccessibilityEvent);
  }
  
  public boolean d(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return a.a(c, paramView, paramAccessibilityEvent);
  }
}

/* Location:
 * Qualified Name:     ol
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */