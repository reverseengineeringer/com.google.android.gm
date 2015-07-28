package com.google.android.gm;

import android.app.IntentService;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;

public class GoogleMailSwitchService
  extends IntentService
{
  private static final ComponentName GMAIL_WIDGET_PROVIDER_COMPONENT_NAME = new ComponentName("com.google.android.gm", "com.google.android.gm.widget.GmailWidgetProvider");
  private static final ComponentName GOOGLE_MAIL_WIDGET_PROVIDER_COMPONENT_NAME = new ComponentName("com.google.android.gm", "com.google.android.gm.widget.GoogleMailWidgetProvider");
  
  public GoogleMailSwitchService()
  {
    super("GoogleMailSwitchService");
  }
  
  private void validateGmailWidgets()
  {
    validateWidgetProvider();
    Utils.enableLabelShortcutActivity(this);
  }
  
  private void validateWidgetProvider()
  {
    PackageManager localPackageManager = getPackageManager();
    boolean bool = Utils.haveGoogleMailActivitiesBeenEnabled(this);
    ComponentName localComponentName1;
    if (bool)
    {
      localComponentName1 = GOOGLE_MAIL_WIDGET_PROVIDER_COMPONENT_NAME;
      if (!bool) {
        break label51;
      }
    }
    label51:
    for (ComponentName localComponentName2 = GMAIL_WIDGET_PROVIDER_COMPONENT_NAME;; localComponentName2 = GOOGLE_MAIL_WIDGET_PROVIDER_COMPONENT_NAME)
    {
      localPackageManager.setComponentEnabledSetting(localComponentName2, 2, 1);
      localPackageManager.setComponentEnabledSetting(localComponentName1, 1, 1);
      return;
      localComponentName1 = GMAIL_WIDGET_PROVIDER_COMPONENT_NAME;
      break;
    }
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    paramIntent = paramIntent.getAction();
    if ("android.intent.action.BOOT_COMPLETED".equals(paramIntent)) {
      validateGmailWidgets();
    }
    while (!"android.intent.action.MY_PACKAGE_REPLACED".equals(paramIntent)) {
      return;
    }
    GoogleMailDeviceStartupReceiver.enableReceiver(this);
    validateGmailWidgets();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.GoogleMailSwitchService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */