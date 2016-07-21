import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import java.util.List;

public final class dcc
{
  public static void a(Context paramContext, View paramView, CharSequence paramCharSequence)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      if (paramView == null) {
        throw new IllegalArgumentException("Must provide a view for accessibility announcement since API level 16");
      }
      paramView.announceForAccessibility(paramCharSequence);
    }
    do
    {
      return;
      paramView = (AccessibilityManager)paramContext.getSystemService("accessibility");
    } while ((paramView == null) || (!paramView.isEnabled()));
    AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain();
    localAccessibilityEvent.setEventType(16384);
    localAccessibilityEvent.setPackageName(paramContext.getPackageName());
    localAccessibilityEvent.setClassName(paramContext.getClass().getName());
    localAccessibilityEvent.getText().add(paramCharSequence);
    paramView.sendAccessibilityEvent(localAccessibilityEvent);
  }
}

/* Location:
 * Qualified Name:     dcc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */