import android.accounts.Account;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.res.Resources;
import android.os.Bundle;

public final class cqs
  extends DialogFragment
{
  public static String a;
  public cqv b;
  
  public static cqs a(Account paramAccount, String paramString)
  {
    cqs localcqs = new cqs();
    Bundle localBundle = new Bundle(3);
    localBundle.putParcelable("account", paramAccount);
    localBundle.putString("syncAuthority", paramString);
    localcqs.setArguments(localBundle);
    return localcqs;
  }
  
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = (Account)getArguments().getParcelable("account");
    String str = getArguments().getString("syncAuthority");
    Object localObject = getResources();
    boolean bool = cxa.a((Resources)localObject);
    int j = buj.fk;
    if (bool) {}
    for (int i = buj.fd;; i = buj.dB)
    {
      localObject = ((Resources)localObject).getString(j, new Object[] { ((Resources)localObject).getString(i) });
      return new AlertDialog.Builder(getActivity()).setMessage((CharSequence)localObject).setTitle(buj.fm).setPositiveButton(buj.fl, new cqu(this, str, paramBundle)).setNegativeButton(buj.R, new cqt(this)).create();
    }
  }
}

/* Location:
 * Qualified Name:     cqs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */