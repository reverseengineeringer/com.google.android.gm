package com.android.mail.ui;

import com.android.mail.browse.ConversationWebView;
import com.android.mail.browse.ConversationWebView.ContentSizeChangeListener;

class ConversationViewFragment$6
  implements ConversationWebView.ContentSizeChangeListener
{
  ConversationViewFragment$6(ConversationViewFragment paramConversationViewFragment) {}
  
  public void onHeightChange(int paramInt)
  {
    ConversationViewFragment.access$400(this$0).loadUrl("javascript:measurePositions();");
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.ConversationViewFragment.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */