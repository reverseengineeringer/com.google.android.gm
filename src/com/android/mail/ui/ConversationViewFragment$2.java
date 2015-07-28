package com.android.mail.ui;

import com.android.mail.browse.ConversationWebView;

class ConversationViewFragment$2
  extends AbstractConversationViewFragment.FragmentRunnable
{
  ConversationViewFragment$2(ConversationViewFragment paramConversationViewFragment, String paramString)
  {
    super(paramConversationViewFragment, paramString);
  }
  
  public void go()
  {
    if (this$0.isUserVisible()) {
      this$0.onConversationSeen();
    }
    ConversationViewFragment.access$400(this$0).onRenderComplete();
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.ConversationViewFragment.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */