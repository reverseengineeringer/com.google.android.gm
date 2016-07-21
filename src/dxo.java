import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;
import com.google.android.gm.ui.GmailDrawerFragment;
import com.google.android.gms.people.accountswitcherview.SelectedAccountNavigationView;

public final class dxo
  implements View.OnApplyWindowInsetsListener
{
  public dxo(GmailDrawerFragment paramGmailDrawerFragment) {}
  
  public final WindowInsets onApplyWindowInsets(View paramView, WindowInsets paramWindowInsets)
  {
    int i = paramWindowInsets.getSystemWindowInsetTop();
    a.K.a = i;
    a.I.a(i);
    return paramWindowInsets;
  }
}

/* Location:
 * Qualified Name:     dxo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */