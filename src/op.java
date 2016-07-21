import android.os.Bundle;
import android.view.View;
import android.view.View.AccessibilityDelegate;

final class op
  extends om
{
  public final Object a(ol paramol)
  {
    return new ow(new oq(this, paramol));
  }
  
  public final ux a(Object paramObject, View paramView)
  {
    paramObject = ((View.AccessibilityDelegate)paramObject).getAccessibilityNodeProvider(paramView);
    if (paramObject != null) {
      return new ux(paramObject);
    }
    return null;
  }
  
  public final boolean a(Object paramObject, View paramView, int paramInt, Bundle paramBundle)
  {
    return ((View.AccessibilityDelegate)paramObject).performAccessibilityAction(paramView, paramInt, paramBundle);
  }
}

/* Location:
 * Qualified Name:     op
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */