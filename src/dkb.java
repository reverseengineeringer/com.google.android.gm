import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.mail.providers.Account;
import java.util.ArrayList;

class dkb
  extends deo<Account>
{
  public dkb(Activity paramActivity, eiz parameiz)
  {
    super(paramActivity, parameiz, new ArrayList());
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = c.inflate(dga.q, paramViewGroup, false);
    }
    a(localView, new dkc(this, (Account)getItem(paramInt)));
    return localView;
  }
}

/* Location:
 * Qualified Name:     dkb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */