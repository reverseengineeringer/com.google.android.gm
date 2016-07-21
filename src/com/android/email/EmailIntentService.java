package com.android.email;

import android.content.Intent;
import bbx;
import bbz;
import bts;
import cvl;
import cvm;

public class EmailIntentService
  extends bts
{
  private static final String a = cvl.a;
  
  public EmailIntentService()
  {
    super("EmailIntentService");
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    super.onHandleIntent(paramIntent);
    if ("com.android.mail.action.update_notification".equals(paramIntent.getAction()))
    {
      bbx localbbx = bbz.a(this);
      if (localbbx != null) {
        localbbx.a(this, paramIntent);
      }
    }
    cvm.a(a, "Handling intent %s", new Object[] { paramIntent });
  }
}

/* Location:
 * Qualified Name:     com.android.email.EmailIntentService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */