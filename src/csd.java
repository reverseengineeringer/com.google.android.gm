import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceScreen;
import android.text.format.DateUtils;
import android.text.format.Time;
import com.android.mail.providers.Account;

public abstract class csd
  extends cse
  implements Preference.OnPreferenceChangeListener
{
  public Account i;
  public Preference j;
  
  private final String a(long paramLong)
  {
    return DateUtils.formatDateTime(getActivity(), paramLong, 524288);
  }
  
  private final String b(long paramLong)
  {
    return DateUtils.formatDateTime(getActivity(), paramLong, 524292);
  }
  
  private static boolean c(long paramLong)
  {
    Time localTime = new Time();
    localTime.set(paramLong);
    int k = year;
    localTime.set(System.currentTimeMillis());
    return k == year;
  }
  
  public abstract int a();
  
  public final String a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    Resources localResources = getResources();
    if (!paramBoolean) {
      return localResources.getString(buj.fy);
    }
    if (paramLong2 <= 0L)
    {
      str1 = a(paramLong1);
      return localResources.getString(buj.fz, new Object[] { str1 });
    }
    String str2;
    if ((!c(paramLong1)) || (!c(paramLong2))) {
      str2 = b(paramLong1);
    }
    for (String str1 = b(paramLong2);; str1 = a(paramLong2))
    {
      return localResources.getString(buj.fA, new Object[] { str2, str1 });
      str2 = a(paramLong1);
    }
  }
  
  public void a(Intent paramIntent)
  {
    paramIntent.putExtra("account", i);
  }
  
  public final void a(Account paramAccount)
  {
    if (!paramAccount.equals(i))
    {
      i = paramAccount;
      c();
    }
  }
  
  public abstract Class<? extends csg> b();
  
  public abstract void c();
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    addPreferencesFromResource(a());
    j = findPreference("vacation-responder");
  }
  
  public boolean onPreferenceTreeClick(PreferenceScreen paramPreferenceScreen, Preference paramPreference)
  {
    int k = 0;
    String str = paramPreference.getKey();
    if (str == null) {
      return false;
    }
    switch (str.hashCode())
    {
    default: 
      label40:
      k = -1;
    }
    for (;;)
    {
      switch (k)
      {
      default: 
        return super.onPreferenceTreeClick(paramPreferenceScreen, paramPreference);
        if (!str.equals("vacation-responder")) {
          break label40;
        }
      }
    }
    if ((i != null) && (i.a(4194304L)))
    {
      paramPreferenceScreen = new Intent(getActivity(), b());
      a(paramPreferenceScreen);
      startActivity(paramPreferenceScreen);
      return true;
    }
    throw new IllegalStateException("Trying to access vacation responder for an invalid account");
  }
  
  public void onResume()
  {
    super.onResume();
    c();
  }
}

/* Location:
 * Qualified Name:     csd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */