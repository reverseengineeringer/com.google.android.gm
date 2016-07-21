import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

class ta
  extends te
{
  public final boolean a(ViewParent paramViewParent, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return paramViewParent.requestSendAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
}

/* Location:
 * Qualified Name:     ta
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */