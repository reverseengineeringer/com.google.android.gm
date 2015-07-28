package com.android.mail.ui;

import android.content.res.Resources;
import android.text.TextUtils;
import com.android.mail.providers.Address;

class ConversationViewFragment$NewMessagesInfo
{
  int count;
  int countFromSelf;
  String senderAddress;
  
  private ConversationViewFragment$NewMessagesInfo(ConversationViewFragment paramConversationViewFragment) {}
  
  public String getNotificationText()
  {
    Resources localResources = this$0.getResources();
    if (count > 1) {
      return localResources.getString(2131493043, new Object[] { Integer.valueOf(count) });
    }
    Object localObject = ConversationViewFragment.access$1800(this$0, senderAddress);
    if (TextUtils.isEmpty(((Address)localObject).getName())) {}
    for (localObject = ((Address)localObject).getAddress();; localObject = ((Address)localObject).getName()) {
      return localResources.getString(2131493042, new Object[] { localObject });
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.ConversationViewFragment.NewMessagesInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */