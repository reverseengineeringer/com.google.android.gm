import android.view.View;

final class cct
  implements Runnable
{
  private final View a;
  
  public cct(View paramView)
  {
    a = paramView;
  }
  
  public final void run()
  {
    if (cxd.d()) {
      if (!a.isAccessibilityFocused()) {
        a.performAccessibilityAction(64, null);
      }
    }
    while (!cxd.a()) {
      return;
    }
    a.performAccessibilityAction(64, null);
  }
}

/* Location:
 * Qualified Name:     cct
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */