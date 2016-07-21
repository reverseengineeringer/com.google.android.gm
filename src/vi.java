import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

final class vi
  extends AccessibilityNodeProvider
{
  vi(vj paramvj) {}
  
  public final AccessibilityNodeInfo createAccessibilityNodeInfo(int paramInt)
  {
    return (AccessibilityNodeInfo)a.a(paramInt);
  }
  
  public final List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String paramString, int paramInt)
  {
    return a.a();
  }
  
  public final AccessibilityNodeInfo findFocus(int paramInt)
  {
    a.b();
    return null;
  }
  
  public final boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    return a.a(paramInt1, paramInt2, paramBundle);
  }
}

/* Location:
 * Qualified Name:     vi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */