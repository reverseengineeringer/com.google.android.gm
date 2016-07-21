package com.android.exchange;

import android.accounts.AccountManager;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import bdv;
import bnu;
import cvm;

public class ExchangeBroadcastReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = 0;
    paramContext = AccountManager.get(paramContext).getAccountsByType(paramContext.getString(bnu.a));
    cvm.c("Exchange", "Accounts changed - requesting FolderSync for unsynced accounts", new Object[0]);
    int j = paramContext.length;
    while (i < j)
    {
      paramIntent = paramContext[i];
      if ((!ContentResolver.getSyncAutomatically(paramIntent, bdv.F)) && (!ContentResolver.getSyncAutomatically(paramIntent, "com.android.calendar")) && (!ContentResolver.getSyncAutomatically(paramIntent, "com.android.contacts")))
      {
        Bundle localBundle = new Bundle(3);
        localBundle.putBoolean("ignore_settings", true);
        localBundle.putBoolean("expedited", true);
        localBundle.putBoolean("__account_only__", true);
        ContentResolver.requestSync(paramIntent, bdv.F, localBundle);
      }
      i += 1;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.exchange.ExchangeBroadcastReceiver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */