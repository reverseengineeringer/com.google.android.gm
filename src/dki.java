import android.app.Activity;
import android.app.LoaderManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;

public class dki
  extends dej<com.android.mail.providers.Account>
  implements View.OnClickListener, cjr, dee
{
  static final String e = cvl.a;
  List<String> f;
  dkl g;
  cjq h;
  private android.accounts.Account i;
  
  protected void a()
  {
    getLoaderManager().restartLoader(4, Bundle.EMPTY, h);
  }
  
  public final void a(android.accounts.Account paramAccount)
  {
    i = paramAccount;
    f = null;
  }
  
  public final void a(ccy<com.android.mail.providers.Account> paramccy)
  {
    if (paramccy == null) {
      return;
    }
    cvm.b(e, "GmailifyAccountList: %d accounts loaded", new Object[] { Integer.valueOf(paramccy.getCount()) });
    ArrayList localArrayList = new ArrayList(paramccy.getCount());
    if (paramccy.moveToFirst()) {
      do
      {
        com.android.mail.providers.Account localAccount = (com.android.mail.providers.Account)paramccy.f();
        if ((dyp.a(localAccount)) && (f != null) && (!f.contains(c)))
        {
          localArrayList.add(localAccount);
          if ((i != null) && (i.equals(localAccount.c())))
          {
            Activity localActivity = getActivity();
            if ((localActivity instanceof dkx)) {
              ((dkx)localActivity).a(localAccount);
            }
            if ((localActivity instanceof dkw)) {
              ((dkw)localActivity).c();
            }
          }
        }
      } while (paramccy.moveToNext());
    }
    paramccy = a;
    b.clear();
    b.addAll(localArrayList);
    paramccy.notifyDataSetChanged();
  }
  
  protected final ejl<frc> b()
  {
    return new dkj(this);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == dfy.aK)
    {
      buo.a().a("gmailify_setup", "add_account", String.valueOf(a.getCount()), 0L);
      ddy.a(getActivity(), this);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    h = new cjq(getActivity(), cgr.b(), this);
    a = new dkb(getActivity(), b);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(dga.F, paramViewGroup, false);
    d = ((LinearLayout)paramLayoutInflater.findViewById(dfy.w));
    paramViewGroup = paramLayoutInflater.findViewById(dfy.aK);
    if (getArguments().getBoolean("show-add-account")) {
      paramViewGroup.setOnClickListener(this);
    }
    for (;;)
    {
      c = new dkk(this);
      return paramLayoutInflater;
      paramViewGroup.setVisibility(8);
    }
  }
  
  public void onDestroy()
  {
    getLoaderManager().destroyLoader(4);
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
    getLoaderManager().initLoader(4, Bundle.EMPTY, h);
  }
}

/* Location:
 * Qualified Name:     dki
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */