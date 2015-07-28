package com.google.android.gm.preference;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.view.Menu;

public class ExperimentalPrefsFragment
  extends PreferenceFragment
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getPreferenceManager().setSharedPreferencesName("Gmail");
    addPreferencesFromResource(2131165185);
    setHasOptionsMenu(true);
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