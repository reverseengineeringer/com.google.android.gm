import android.support.v7.app.AppCompatDelegateImplV7;
import android.support.v7.widget.ActionBarContextView;
import android.view.View;

public final class aay
  extends tx
{
  public aay(AppCompatDelegateImplV7 paramAppCompatDelegateImplV7) {}
  
  public final void a(View paramView)
  {
    a.t.setVisibility(0);
    a.t.sendAccessibilityEvent(32);
    if (a.t.getParent() != null) {
      rg.s((View)a.t.getParent());
    }
  }
  
  public final void b(View paramView)
  {
    rg.c(a.t, 1.0F);
    a.w.a(null);
    a.w = null;
  }
}

/* Location:
 * Qualified Name:     aay
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */