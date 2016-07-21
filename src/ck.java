import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.TextView;
import java.util.List;

public final class ck
  extends ol
{
  public ck(TextInputLayout paramTextInputLayout) {}
  
  public final void a(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.a(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(TextInputLayout.class.getSimpleName());
  }
  
  public final void a(View paramView, uk paramuk)
  {
    super.a(paramView, paramuk);
    paramuk.b(TextInputLayout.class.getSimpleName());
    paramView = a.f.o;
    if (!TextUtils.isEmpty(paramView)) {
      uk.a.e(b, paramView);
    }
    if (a.a != null)
    {
      paramView = a.a;
      uk.a.d(b, paramView);
    }
    if (a.d != null) {}
    for (paramView = a.d.getText();; paramView = null)
    {
      if (!TextUtils.isEmpty(paramView))
      {
        uk.a.j(b, true);
        uk.a.a(b, paramView);
      }
      return;
    }
  }
  
  public final void b(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.b(paramView, paramAccessibilityEvent);
    paramView = a.f.o;
    if (!TextUtils.isEmpty(paramView)) {
      paramAccessibilityEvent.getText().add(paramView);
    }
  }
}

/* Location:
 * Qualified Name:     ck
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */