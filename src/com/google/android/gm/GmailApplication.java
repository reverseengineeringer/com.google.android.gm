package com.google.android.gm;

import android.app.Application;
import android.preference.PreferenceManager;

public class GmailApplication
  extends Application
{
  public void onCreate()
  {
    PreferenceManager.setDefaultValues(this, "Gmail", 0, 2131165185, false);
    PreferenceManager.setDefaultValues(this, "Gmail", 0, 2131165187, false);
    PreferenceManager.setDefaultValues(this, "Gmail", 0, 2131165184, false);
  }
  
  public void onTerminate() {}
}

/* Location:
 * Qualified Name:     com.google.android.gm.GmailApplication
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */