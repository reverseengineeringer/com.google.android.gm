package com.google.android.gm.provider;

import java.util.Set;

public abstract interface MailCore$Listener
{
  public abstract void onConversationNewlyMatchesNotificationRequest(MailCore.NotificationRequest paramNotificationRequest);
  
  public abstract void onLabelsUpdated(Set<Long> paramSet);
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailCore.Listener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */