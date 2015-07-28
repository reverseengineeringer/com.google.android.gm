package com.android.mail.providers;

import android.content.Context;
import android.content.Intent;
import com.google.android.gm.AddAccountActivity;

public class GmailAccountCacheProvider
  extends MailAppProvider
{
  protected String getAuthority()
  {
    return "com.google.android.gm2.accountcache";
  }
  
  protected Intent getNoAccountsIntent(Context paramContext)
  {
    return new Intent(paramContext, AddAccountActivity.class);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.providers.GmailAccountCacheProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */