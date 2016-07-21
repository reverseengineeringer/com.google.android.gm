package com.google.android.gm;

import btu;
import com.android.mail.providers.Account;
import com.android.mail.utils.NotificationActionUtils.NotificationAction;
import cxf;
import dev;
import dmr;
import gnr;
import hli;

public class GmailNotificationActionIntentService
  extends btu
{
  protected final void a(String paramString, NotificationActionUtils.NotificationAction paramNotificationAction)
  {
    super.a(paramString, paramNotificationAction);
    dev localdev = (dev)getApplication();
    dmr localdmr = f;
    Account localAccount = b;
    if (cxf.a(localdev, localAccount))
    {
      paramNotificationAction = null;
      if (!"com.android.mail.action.notification.ARCHIVE".equals(paramString)) {
        break label75;
      }
      paramNotificationAction = new gnr(hli.b);
    }
    for (;;)
    {
      if (paramNotificationAction != null) {
        localdmr.a(paramNotificationAction, 4, c);
      }
      return;
      label75:
      if ("com.android.mail.action.notification.DELETE".equals(paramString)) {
        paramNotificationAction = new gnr(hli.f);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.GmailNotificationActionIntentService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */