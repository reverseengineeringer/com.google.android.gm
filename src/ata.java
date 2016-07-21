import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceCategory;
import com.android.email.SecurityPolicy;
import com.android.email.activity.setup.AccountSettingsFragment;

public final class ata
  implements Preference.OnPreferenceClickListener
{
  public ata(AccountSettingsFragment paramAccountSettingsFragment, PreferenceCategory paramPreferenceCategory, Preference paramPreference) {}
  
  public final boolean onPreferenceClick(Preference paramPreference)
  {
    SecurityPolicy.a(c.b, c.c, false);
    if (a != null) {
      a.removePreference(b);
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     ata
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */