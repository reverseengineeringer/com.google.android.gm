package com.google.android.gm;

import android.app.IntentService;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import dfh;

public class GoogleMailSwitchService
  extends IntentService
{
  private static final ComponentName a = new ComponentName("com.google.android.gm", "com.google.android.gm.widget.GmailWidgetProvider");
  private static final ComponentName b = new ComponentName("com.google.android.gm", "com.google.android.gm.widget.GoogleMailWidgetProvider");
  
  public GoogleMailSwitchService()
  {
    super("GoogleMailSwitchService");
  }
  
  private final void a()
  {
    PackageManager localPackageManager = getPackageManager();
    boolean bool = dfh.h(this);
    ComponentName localComponentName1;
    if (bool)
    {
      localComponentName1 = b;
      if (!bool) {
        break label55;
      }
    }
    label55:
    for (ComponentName localComponentName2 = a;; localComponentName2 = b)
    {
      localPackageManager.setComponentEnabledSetting(localComponentName2, 2, 1);
      localPackageManager.setComponentEnabledSetting(localComponentName1, 1, 1);
      dfh.e(this);
      return;
      localComponentName1 = a;
      break;
    }
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    paramIntent = paramIntent.getAction();
    if ("android.intent.action.BOOT_COMPLETED".equals(paramIntent)) {
      a();
    }
    while (!"android.intent.action.MY_PACKAGE_REPLACED".equals(paramIntent)) {
      return;
    }
    GoogleMailDeviceStartupReceiver.a(this);
    a();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.GoogleMailSwitchService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */