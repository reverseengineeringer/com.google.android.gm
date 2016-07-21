package com.google.android.gm.preference;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import com.android.email.activity.setup.AccountSettingsFragment;
import cvl;
import cvm;
import dge;
import dkm;
import dkn;

public class AccountSettingsFragmentGmail
  extends AccountSettingsFragment
{
  private static final String k = cvl.a;
  
  protected final boolean a(String paramString)
  {
    if ("account_g6y".equals(paramString))
    {
      dkn.a(getActivity(), i);
      return true;
    }
    return super.a(paramString);
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    int i = 0;
    super.onActivityCreated(paramBundle);
    int j;
    if (dkn.a())
    {
      j = new dkm(getActivity(), d).e();
      if (j == 1)
      {
        paramBundle = getPreferenceScreen();
        PreferenceScreen localPreferenceScreen = getPreferenceManager().createPreferenceScreen(getActivity());
        Preference localPreference = paramBundle.findPreference("data_usage");
        if (localPreference != null) {
          i = localPreference.getOrder() - 1;
        }
        localPreferenceScreen.setOrder(i);
        localPreferenceScreen.setTitle(dge.eQ);
        localPreferenceScreen.setSummary(dge.eP);
        localPreferenceScreen.setKey("account_g6y");
        paramBundle.addPreference(localPreferenceScreen);
      }
    }
    else
    {
      return;
    }
    cvm.b(k, "g6y: Not adding pref screen. Availability state: %d", new Object[] { Integer.valueOf(j) });
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.preference.AccountSettingsFragmentGmail
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */