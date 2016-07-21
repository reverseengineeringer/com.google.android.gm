package com.google.android.gm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import dri;

public class GmailReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    dri.b("GmailReceiver", "RECEIVED %s", new Object[] { str });
    if ("com.android.mail.action.update_notification".equals(str))
    {
      paramIntent.setClass(paramContext, GmailIntentService.class);
      paramContext.startService(paramIntent);
      return;
    }
    dri.b("GmailReceiver", "UNHANDLED %s", new Object[] { str });
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.GmailReceiver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */