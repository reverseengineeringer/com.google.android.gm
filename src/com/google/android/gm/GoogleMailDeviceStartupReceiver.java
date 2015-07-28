package com.google.android.gm;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.google.android.gm.provider.LogUtils;

public class GoogleMailDeviceStartupReceiver
  extends BroadcastReceiver
{
  private static final ComponentName sComponentName = new ComponentName("com.google.android.gm", "com.google.android.gm.GoogleMailDeviceStartupReceiver");
  
  public static void enableReceiver(Context paramContext)
  {
    paramContext.getPackageManager().setComponentEnabledSetting(sComponentName, 1, 1);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    LogUtils.v("Gmail", "Received intent %s", new Object[] { paramIntent });
    paramIntent.setClass(paramContext, GoogleMailSwitchService.class);
    paramContext.startService(paramIntent);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.GoogleMailDeviceStartupReceiver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */