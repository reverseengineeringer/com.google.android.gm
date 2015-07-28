package com.google.android.gm.provider;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import com.android.mail.utils.DelayedTaskHandler;

class MailEngine$DatasetChangedNotifier
  extends DelayedTaskHandler
{
  private final Context mContext;
  private final Intent mIntent;
  
  public MailEngine$DatasetChangedNotifier(MailEngine paramMailEngine, Context paramContext, int paramInt)
  {
    super(MailEngine.access$4900(), paramInt);
    mContext = paramContext;
    mIntent = new Intent("com.android.mail.ACTION_NOTIFY_DATASET_CHANGED");
    mIntent.putExtra("accountUri", UiProvider.getAccountUri(access$800name));
    mIntent.setType("application/gmail-ls");
  }
  
  protected void performTask()
  {
    mContext.sendBroadcast(mIntent);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailEngine.DatasetChangedNotifier
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */