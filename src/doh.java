import android.content.Intent;
import android.net.Uri;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.provider.Settings.System;
import android.text.TextUtils;

final class doh
  implements Preference.OnPreferenceClickListener
{
  doh(dnz paramdnz) {}
  
  public final boolean onPreferenceClick(Preference paramPreference)
  {
    paramPreference = a;
    Intent localIntent = new Intent("android.intent.action.RINGTONE_PICKER");
    String str = d.b();
    if (!TextUtils.isEmpty(str)) {
      localIntent.putExtra("android.intent.extra.ringtone.EXISTING_URI", Uri.parse(str));
    }
    localIntent.putExtra("android.intent.extra.ringtone.SHOW_DEFAULT", true);
    localIntent.putExtra("android.intent.extra.ringtone.DEFAULT_URI", Settings.System.DEFAULT_NOTIFICATION_URI);
    localIntent.putExtra("android.intent.extra.ringtone.SHOW_SILENT", true);
    localIntent.putExtra("android.intent.extra.ringtone.TYPE", 2);
    paramPreference.startActivityForResult(localIntent, 0);
    return true;
  }
}

/* Location:
 * Qualified Name:     doh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */