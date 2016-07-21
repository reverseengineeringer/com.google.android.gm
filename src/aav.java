import android.support.v7.app.AppCompatDelegateImplV7;
import android.support.v7.app.AppCompatDelegateImplV7.PanelFeatureState;
import android.view.View;
import android.view.Window;
import android.widget.PopupWindow;

public final class aav
  implements ahu
{
  public aav(AppCompatDelegateImplV7 paramAppCompatDelegateImplV7) {}
  
  public final void a()
  {
    Object localObject = a;
    if (r != null) {
      r.j();
    }
    if (u != null)
    {
      d.getDecorView().removeCallbacks(v);
      if (!u.isShowing()) {}
    }
    try
    {
      u.dismiss();
      u = null;
      ((AppCompatDelegateImplV7)localObject).m();
      localObject = ((AppCompatDelegateImplV7)localObject).g(0);
      if ((localObject != null) && (j != null)) {
        j.close();
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;) {}
    }
  }
}

/* Location:
 * Qualified Name:     aav
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */