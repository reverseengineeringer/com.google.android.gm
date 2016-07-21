import android.accounts.Account;
import android.content.ContentResolver;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;

final class dog
  implements Preference.OnPreferenceClickListener
{
  dog(dnz paramdnz) {}
  
  public final boolean onPreferenceClick(Preference paramPreference)
  {
    paramPreference = a;
    if (ContentResolver.getMasterSyncAutomatically()) {
      paramPreference.a();
    }
    for (;;)
    {
      return true;
      cqs.a(new Account(a, "com.google"), "gmail-ls").show(paramPreference.getFragmentManager(), "auto sync");
    }
  }
}

/* Location:
 * Qualified Name:     dog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */