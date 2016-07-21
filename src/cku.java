import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public final class cku
  extends View.AccessibilityDelegate
{
  private final Toolbar a;
  
  public cku(Toolbar paramToolbar)
  {
    a = paramToolbar;
  }
  
  public final boolean dispatchPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    boolean bool = false;
    if (super.dispatchPopulateAccessibilityEvent(paramView, paramAccessibilityEvent))
    {
      paramView = paramAccessibilityEvent.getText();
      paramView.clear();
      paramView.add(0, a.l);
      bool = true;
    }
    return bool;
  }
}

/* Location:
 * Qualified Name:     cku
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */