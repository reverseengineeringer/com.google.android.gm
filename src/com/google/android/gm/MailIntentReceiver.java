package com.google.android.gm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gm.provider.LogUtils;

public class MailIntentReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    LogUtils.v("Gmail", "Received intent %s", new Object[] { paramIntent });
    paramIntent.setClass(paramContext, MailIntentService.class);
    paramContext.startService(paramIntent);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.MailIntentReceiver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */