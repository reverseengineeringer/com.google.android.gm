import android.app.Activity;
import android.content.Intent;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import com.android.email.activity.setup.AccountServerSettingsActivity;
import com.android.email.activity.setup.AccountSettingsFragment;
import com.android.emailcommon.provider.Account;

public final class atb
  implements Preference.OnPreferenceClickListener
{
  public atb(AccountSettingsFragment paramAccountSettingsFragment) {}
  
  public final boolean onPreferenceClick(Preference paramPreference)
  {
    paramPreference = a;
    Object localObject = a.c;
    localObject = AccountServerSettingsActivity.a(paramPreference.getActivity(), (Account)localObject, "incoming", true);
    paramPreference.getActivity().startActivity((Intent)localObject);
    return true;
  }
}

/* Location:
 * Qualified Name:     atb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */