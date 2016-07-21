import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityManager;

public final class ug
{
  private static final uj a = new ui();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      a = new uh();
      return;
    }
  }
  
  public static boolean a(AccessibilityManager paramAccessibilityManager)
  {
    return a.a(paramAccessibilityManager);
  }
}

/* Location:
 * Qualified Name:     ug
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */