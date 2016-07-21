import android.content.Context;
import android.view.accessibility.AccessibilityManager;

public final class dmn
{
  public static boolean a(Context paramContext)
  {
    if (cxa.a(paramContext.getResources())) {}
    for (boolean bool = false;; bool = true)
    {
      if (((AccessibilityManager)paramContext.getSystemService("accessibility")).isEnabled()) {
        return false;
      }
      return bool;
    }
  }
}

/* Location:
 * Qualified Name:     dmn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */