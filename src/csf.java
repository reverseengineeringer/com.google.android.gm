import android.preference.Preference;
import android.text.TextUtils;

public final class csf
{
  public static void a(Preference paramPreference, String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramPreference.setSummary(paramString);
      return;
    }
    paramPreference.setSummary(paramInt);
  }
}

/* Location:
 * Qualified Name:     csf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */