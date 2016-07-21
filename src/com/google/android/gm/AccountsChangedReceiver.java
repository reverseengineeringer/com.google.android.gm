package com.google.android.gm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AccountsChangedReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("android.accounts.LOGIN_ACCOUNTS_CHANGED".equals(paramIntent.getAction()))
    {
      paramIntent.setClass(paramContext, GmailIntentService.class);
      paramContext.startService(paramIntent);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.AccountsChangedReceiver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */