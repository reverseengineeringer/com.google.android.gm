import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;

class uq
  extends uo
{
  public final void a(Object paramObject, View paramView, int paramInt)
  {
    ((AccessibilityNodeInfo)paramObject).setSource(paramView, paramInt);
  }
  
  public final void b(Object paramObject, View paramView, int paramInt)
  {
    ((AccessibilityNodeInfo)paramObject).addChild(paramView, paramInt);
  }
  
  public final void h(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityNodeInfo)paramObject).setVisibleToUser(paramBoolean);
  }
  
  public final void i(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityNodeInfo)paramObject).setAccessibilityFocused(paramBoolean);
  }
  
  public final boolean r(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).isVisibleToUser();
  }
  
  public final boolean s(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).isAccessibilityFocused();
  }
}

/* Location:
 * Qualified Name:     uq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */