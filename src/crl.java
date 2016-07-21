import android.app.Fragment;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.android.mail.providers.Account;

public final class crl
  extends Fragment
  implements LoaderManager.LoaderCallbacks<Cursor>, View.OnClickListener
{
  Account a;
  private LayoutInflater b;
  private boolean c;
  
  private final View a(ViewGroup paramViewGroup)
  {
    if ((a != null) && ((a.u & 0x10) == 16))
    {
      paramViewGroup = b.inflate(bue.ar, paramViewGroup, false);
      paramViewGroup.findViewById(buc.cy).setOnClickListener(this);
      paramViewGroup.findViewById(buc.ad).setOnClickListener(this);
      return paramViewGroup;
    }
    if (c) {
      return b.inflate(bue.T, paramViewGroup, false);
    }
    return b.inflate(bue.aq, paramViewGroup, false);
  }
  
  public static crl a(Account paramAccount, boolean paramBoolean)
  {
    crl localcrl = new crl();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("account", paramAccount);
    localBundle.putBoolean("expectingMessages", paramBoolean);
    localcrl.setArguments(localBundle);
    return localcrl;
  }
  
  public final void a(Account paramAccount)
  {
    a = paramAccount;
    paramAccount = (ViewGroup)getView();
    if (paramAccount != null)
    {
      paramAccount.removeAllViews();
      paramAccount.addView(a(paramAccount));
    }
  }
  
  public final void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == buc.ad)
    {
      paramView = new Intent("android.settings.SYNC_SETTINGS");
      paramView.addFlags(268435456);
      startActivity(paramView);
    }
    while ((i != buc.cy) || (a == null) || (a.A == null)) {
      return;
    }
    getLoaderManager().initLoader(0, null, this);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    a = ((Account)paramBundle.getParcelable("account"));
    c = paramBundle.getBoolean("expectingMessages", false);
  }
  
  public final Loader<Cursor> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    return new CursorLoader(getActivity(), a.A, null, null, null, null);
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    b = paramLayoutInflater;
    paramLayoutInflater = (ViewGroup)b.inflate(bue.ap, paramViewGroup, false);
    paramLayoutInflater.addView(a(paramLayoutInflater));
    glh.a.a("Application ready", "Application ready wait");
    return paramLayoutInflater;
  }
  
  public final void onLoaderReset(Loader<Cursor> paramLoader) {}
}

/* Location:
 * Qualified Name:     crl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */