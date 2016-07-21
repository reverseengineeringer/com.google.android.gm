import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.android.mail.providers.Account;
import java.util.ArrayList;
import java.util.List;

final class cnw
  extends BaseAdapter
{
  private final List<Account> b = new ArrayList();
  
  cnw(cnk paramcnk) {}
  
  public final void a(Account[] paramArrayOfAccount, Account paramAccount)
  {
    b.clear();
    if (paramAccount == null)
    {
      notifyDataSetChanged();
      return;
    }
    b.add(paramAccount);
    int j = paramArrayOfAccount.length;
    int i = 0;
    while (i < j)
    {
      Account localAccount = paramArrayOfAccount[i];
      if (!c.equals(c)) {
        b.add(localAccount);
      }
      i += 1;
    }
    notifyDataSetChanged();
  }
  
  public final int getCount()
  {
    return b.size();
  }
  
  public final Object getItem(int paramInt)
  {
    if (paramInt >= b.size()) {
      return null;
    }
    return b.get(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return getItem(paramInt).hashCode();
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null) {}
    for (paramView = (ImageView)paramView;; paramView = (ImageView)LayoutInflater.from(a.getActivity()).inflate(bue.X, paramViewGroup, false))
    {
      cnx localcnx = new cnx(this, paramView);
      b = new buv(d.a.getResources(), d.a.v, d.a.w);
      b.a(d.a.A, d.a.A);
      c.setImageDrawable(b);
      a = ((Account)b.get(paramInt));
      b.a(a.b, a.c);
      String str = a.a;
      paramViewGroup = str;
      if (TextUtils.isEmpty(str)) {
        paramViewGroup = a.c;
      }
      c.setContentDescription(paramViewGroup);
      paramView.setTag(localcnx);
      return paramView;
    }
  }
}

/* Location:
 * Qualified Name:     cnw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */