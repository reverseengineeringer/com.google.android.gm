import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityEvent;

public final class ub
{
  public static final uf a = new ue();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      a = new ud();
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      a = new uc();
      return;
    }
  }
  
  public static vk a(AccessibilityEvent paramAccessibilityEvent)
  {
    return new vk(paramAccessibilityEvent);
  }
}

/* Location:
 * Qualified Name:     ub
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */