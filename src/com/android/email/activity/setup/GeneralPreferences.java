package com.android.email.activity.setup;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceGroup;
import android.preference.PreferenceScreen;
import com.android.mail.ui.settings.GeneralPrefsFragment;

public class GeneralPreferences
  extends GeneralPrefsFragment
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getPreferenceScreen();
    Object localObject = findPreference("removal-action");
    if (localObject != null) {
      paramBundle.removePreference((Preference)localObject);
    }
    paramBundle = findPreference("confirm-archive");
    localObject = (PreferenceGroup)findPreference("removal-actions-group");
    if (paramBundle != null) {
      ((PreferenceGroup)localObject).removePreference(paramBundle);
    }
  }
}

/* Location:
 * Qualified Name:     com.android.email.activity.setup.GeneralPreferences
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */