package com.android.mail.providers.protos.boot;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.android.mail.providers.MailAppProvider;

public class AccountReceiver
  extends BroadcastReceiver
{
  private static final Uri GMAIL_ACCOUNTS_URI = Uri.parse("content://com.android.gmail.ui/accounts");
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    MailAppProvider.addAccountsForUriAsync(GMAIL_ACCOUNTS_URI);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.providers.protos.boot.AccountReceiver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */