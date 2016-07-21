package com.android.email.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class EmailBroadcastReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Intent localIntent = new Intent(paramContext, EmailBroadcastProcessorService.class);
    localIntent.setAction("com.android.mail.action.BROADCAST");
    localIntent.putExtra("android.intent.extra.INTENT", paramIntent);
    paramContext.startService(localIntent);
  }
}

/* Location:
 * Qualified Name:     com.android.email.service.EmailBroadcastReceiver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */