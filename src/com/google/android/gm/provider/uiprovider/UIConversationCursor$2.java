package com.google.android.gm.provider.uiprovider;

import com.android.mail.providers.ConversationInfo;
import com.google.android.gm.provider.ObjectCache.Callback;

final class UIConversationCursor$2
  implements ObjectCache.Callback<ConversationInfo>
{
  public ConversationInfo newInstance()
  {
    return new ConversationInfo();
  }
  
  public void onObjectReleased(ConversationInfo paramConversationInfo)
  {
    paramConversationInfo.set(0, 0, null, null, null);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.uiprovider.UIConversationCursor.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */