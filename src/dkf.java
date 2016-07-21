import android.app.Activity;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.android.mail.providers.Account;
import com.google.android.gm.ui.CheckableAddressListItem;

final class dkf
  extends dkb
  implements View.OnClickListener
{
  private final int g;
  private final int h;
  private Account i = null;
  private dkg j;
  
  public dkf(Activity paramActivity, eiz parameiz, Account paramAccount)
  {
    super(paramActivity, parameiz);
    parameiz = paramActivity.getResources();
    i = paramAccount;
    h = parameiz.getColor(dfv.y);
    paramActivity = paramActivity.obtainStyledAttributes(new int[] { 16843534 });
    g = paramActivity.getResourceId(0, 0);
    paramActivity.recycle();
  }
  
  final void a(Account paramAccount)
  {
    i = paramAccount;
    if (j != null) {
      j.a(paramAccount);
    }
    notifyDataSetChanged();
  }
  
  final void a(dkg paramdkg)
  {
    j = paramdkg;
    if (j != null) {
      j.a(i);
    }
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = super.getView(paramInt, paramView, paramViewGroup);
    paramViewGroup = (CheckableAddressListItem)paramView;
    Account localAccount = (Account)getItem(paramInt);
    paramViewGroup.setOnClickListener(this);
    paramViewGroup.setTag(localAccount);
    if ((i != null) && (localAccount.h().equals(i.h()))) {}
    for (boolean bool = true;; bool = false)
    {
      paramViewGroup.setChecked(bool);
      if (!bool) {
        break;
      }
      paramView.setBackgroundColor(h);
      return paramView;
    }
    paramView.setBackgroundResource(g);
    return paramView;
  }
  
  public final void onClick(View paramView)
  {
    a((Account)paramView.getTag());
  }
}

/* Location:
 * Qualified Name:     dkf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */