package com.google.android.gm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gm.provider.LogUtils;

public class GmailReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if ("com.android.mail.action.update_notification".equals(str))
    {
      paramIntent.setClass(paramContext, MailIntentService.class);
      paramContext.startService(paramIntent);
      return;
    }
    LogUtils.d("Gmail", "RECEIVED %s", new Object[] { str });
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.GmailReceiver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */