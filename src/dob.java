import android.content.Intent;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import com.google.android.gm.preference.LabelSynchronizationActivity;

final class dob
  implements Preference.OnPreferenceClickListener
{
  dob(dnz paramdnz) {}
  
  public final boolean onPreferenceClick(Preference paramPreference)
  {
    paramPreference = a;
    Intent localIntent = new Intent(paramPreference.getActivity(), LabelSynchronizationActivity.class);
    localIntent.putExtra("account", a);
    localIntent.putExtra("folder", b);
    localIntent.putExtra("included-labels", c.e());
    localIntent.putExtra("partial-labels", c.f());
    localIntent.putExtra("num-of-sync-days", c.g());
    paramPreference.startActivityForResult(localIntent, 1);
    return true;
  }
}

/* Location:
 * Qualified Name:     dob
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */