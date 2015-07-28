package com.google.android.gm.provider;

import java.util.Map;
import java.util.Set;

class MailEngine$8
  implements MailCore.Listener
{
  MailEngine$8(MailEngine paramMailEngine) {}
  
  public void onConversationNewlyMatchesNotificationRequest(MailCore.NotificationRequest paramNotificationRequest)
  {
    long l = paramNotificationRequest.getTagLabelId();
    if (MailEngine.access$000(this$0).getNumUnreadConversations(l) != 0) {
      MailEngine.access$1300(this$0).put(Long.valueOf(paramNotificationRequest.getLabelId()), Boolean.valueOf(true));
    }
  }
  
  public void onLabelsUpdated(Set<Long> paramSet)
  {
    MailEngine.access$1400(this$0, paramSet);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailEngine.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */