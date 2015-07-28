package com.google.android.gm.preference;

import android.app.Activity;
import android.content.res.Resources;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;
import android.view.Menu;
import android.view.MenuInflater;

public class GmailPreferenceFragment
  extends PreferenceFragment
  implements Preference.OnPreferenceChangeListener
{
  protected String getRingtoneSummary(Uri paramUri, Activity paramActivity)
  {
    paramUri = RingtoneManager.getRingtone(getActivity(), paramUri);
    if (paramUri != null) {
      return paramUri.getTitle(paramActivity);
    }
    return paramActivity.getResources().getString(2131493273);
  }
  
  protected void initializeCheckBox(String paramString, boolean paramBoolean)
  {
    paramString = (CheckBoxPreference)findPreference(paramString);
    if (paramString != null) {
      paramString.setChecked(paramBoolean);
    }
  }
  
  protected void initializeCheckBoxAndSummary(String paramString, boolean paramBoolean, CharSequence paramCharSequence)
  {
    paramString = (CheckBoxPreference)getPreferenceScreen().findPreference(paramString);
    paramString.setChecked(paramBoolean);
    paramString.setSummary(paramCharSequence);
  }
  
  protected void initializeEditText(String paramString1, String paramString2)
  {
    paramString1 = (EditTextPreference)findPreference(paramString1);
    if (paramString1 != null) {
      paramString1.setText(paramString2);
    }
  }
  
  protected void initializePreferenceScreen(String paramString1, String paramString2)
  {
    paramString1 = (PreferenceScreen)findPreference(paramString1);
    if (paramString1 != null) {
      paramString1.setTitle(paramString2);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setHasOptionsMenu(true);
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenu.clear();
    paramMenuInflater.inflate(2131886092, paramMenu);
  }
  
  public boolean onPreferenceChange(Preference paramPreference, Object paramObject)
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.preference.GmailPreferenceFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */