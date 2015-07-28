package com.google.android.gm.provider.uiprovider;

import com.android.mail.providers.MessageInfo;
import com.google.android.gm.provider.ObjectCache.Callback;

final class UIConversationCursor$3
  implements ObjectCache.Callback<MessageInfo>
{
  public MessageInfo newInstance()
  {
    return new MessageInfo();
  }
  
  public void onObjectReleased(MessageInfo paramMessageInfo)
  {
    paramMessageInfo.set(false, false, null, 0);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.uiprovider.UIConversationCursor.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */