package com.google.android.gm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import dri;

public class GoogleMailPackageReplaceReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    dri.a(dri.a, "Received intent %s", new Object[] { paramIntent });
    paramIntent.setClass(paramContext, GoogleMailSwitchService.class);
    paramContext.startService(paramIntent);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.GoogleMailPackageReplaceReceiver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */