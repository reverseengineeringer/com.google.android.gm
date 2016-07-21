import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityManager;

public final class bnh
{
  public static boolean a(AccessibilityManager paramAccessibilityManager)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      return paramAccessibilityManager.isTouchExplorationEnabled();
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     bnh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */