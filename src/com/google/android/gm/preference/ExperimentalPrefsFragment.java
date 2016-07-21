package com.google.android.gm.preference;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceManager;
import android.view.Menu;
import cfm;
import cfr;
import cse;
import dgh;
import dmv;

public class ExperimentalPrefsFragment
  extends cse
  implements Preference.OnPreferenceChangeListener
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getPreferenceManager().setSharedPreferencesName(agetActivityc);
    addPreferencesFromResource(dgh.a);
    setHasOptionsMenu(true);
    paramBundle = (CheckBoxPreference)findPreference("notification-requires-us");
    paramBundle.setChecked(dmv.a().a(getActivity(), null, "notification-requires-us", false));
    paramBundle.setOnPreferenceChangeListener(this);
  }
  
  public boolean onPreferenceChange(Preference paramPreference, Object paramObject)
  {
    if ("notification-requires-us".equals(paramPreference.getKey()))
    {
      dmv.a().a(getActivity(), null, "notification-requires-us", (Boolean)paramObject);
      return true;
    }
    return false;
  }
  
  public void onPrepareOptionsMenu(Menu paramMenu)
  {
    paramMenu.clear();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.preference.ExperimentalPrefsFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */