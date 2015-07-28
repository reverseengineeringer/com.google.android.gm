package com.google.android.gm.provider.uiprovider;

import com.google.android.gm.provider.AttachmentStatusLoader;
import com.google.android.gm.provider.LogUtils;

class ConversationState$1
  implements Runnable
{
  ConversationState$1(ConversationState paramConversationState) {}
  
  public void run()
  {
    synchronized (ConversationState.access$000(this$0))
    {
      if (ConversationState.access$100(this$0) == null)
      {
        ConversationState.access$102(this$0, new AttachmentStatusLoader(ConversationState.access$200(this$0), ConversationState.access$300(this$0), ConversationState.access$400(this$0), ConversationState.access$500(this$0)));
        ConversationState.access$100(this$0).registerListener(0, this$0);
      }
      if (!ConversationState.access$100(this$0).isStarted())
      {
        LogUtils.d("Gmail", "starting attachment loader for conversation %d", new Object[] { Long.valueOf(ConversationState.access$400(this$0)) });
        ConversationState.access$100(this$0).startLoading();
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.uiprovider.ConversationState.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */