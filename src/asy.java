import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import com.android.email.activity.setup.AccountSettingsFragment;
import com.android.mail.providers.Account;

public final class asy
  implements Preference.OnPreferenceClickListener
{
  public asy(AccountSettingsFragment paramAccountSettingsFragment) {}
  
  public final boolean onPreferenceClick(Preference paramPreference)
  {
    paramPreference = a;
    Account localAccount = a.i;
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("account", localAccount);
    ((PreferenceActivity)paramPreference.getActivity()).startPreferencePanel(asv.class.getName(), localBundle, arh.o, null, null, 0);
    return true;
  }
}

/* Location:
 * Qualified Name:     asy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */