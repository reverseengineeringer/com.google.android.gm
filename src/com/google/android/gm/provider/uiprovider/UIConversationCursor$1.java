package com.google.android.gm.provider.uiprovider;

import com.google.android.gm.provider.ObjectCache.Callback;
import com.google.android.gm.provider.SenderInstructions;

final class UIConversationCursor$1
  implements ObjectCache.Callback<SenderInstructions>
{
  public SenderInstructions newInstance()
  {
    return new SenderInstructions();
  }
  
  public void onObjectReleased(SenderInstructions paramSenderInstructions)
  {
    paramSenderInstructions.reset();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.uiprovider.UIConversationCursor.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */