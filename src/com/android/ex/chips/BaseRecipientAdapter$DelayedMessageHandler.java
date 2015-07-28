package com.android.ex.chips;

import android.os.Handler;
import android.os.Message;

final class BaseRecipientAdapter$DelayedMessageHandler
  extends Handler
{
  private BaseRecipientAdapter$DelayedMessageHandler(BaseRecipientAdapter paramBaseRecipientAdapter) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (BaseRecipientAdapter.access$1500(this$0) > 0) {
      BaseRecipientAdapter.access$1200(this$0, BaseRecipientAdapter.access$400(this$0, true, BaseRecipientAdapter.access$800(this$0), BaseRecipientAdapter.access$900(this$0), BaseRecipientAdapter.access$1000(this$0)));
    }
  }
  
  public void removeDelayedLoadMessage()
  {
    removeMessages(1);
  }
  
  public void sendDelayedLoadMessage()
  {
    sendMessageDelayed(obtainMessage(1, 0, 0, null), 1000L);
  }
}

/* Location:
 * Qualified Name:     com.android.ex.chips.BaseRecipientAdapter.DelayedMessageHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */