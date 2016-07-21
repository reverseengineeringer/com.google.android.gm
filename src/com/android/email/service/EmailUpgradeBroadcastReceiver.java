package com.android.email.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class EmailUpgradeBroadcastReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    EmailBroadcastProcessorService.a(paramContext);
  }
}

/* Location:
 * Qualified Name:     com.android.email.service.EmailUpgradeBroadcastReceiver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */