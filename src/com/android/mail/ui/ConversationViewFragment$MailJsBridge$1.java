package com.android.mail.ui;

import com.android.mail.browse.ConversationContainer;
import com.android.mail.browse.ConversationWebView;
import com.android.mail.utils.LogUtils;

class ConversationViewFragment$MailJsBridge$1
  extends AbstractConversationViewFragment.FragmentRunnable
{
  ConversationViewFragment$MailJsBridge$1(ConversationViewFragment.MailJsBridge paramMailJsBridge, String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    super(this$0, paramString);
  }
  
  public void go()
  {
    try
    {
      if (!ConversationViewFragment.access$700(this$1.this$0))
      {
        LogUtils.d(ConversationViewFragment.access$200(), "ignoring webContentGeometryChange because views are gone, %s", new Object[] { this$1.this$0 });
        return;
      }
      ConversationViewFragment.access$1300(this$1.this$0).onGeometryChange(ConversationViewFragment.access$1200(val$overlayTopStrs, val$overlayBottomStrs));
      if (ConversationViewFragment.access$1400(this$1.this$0) != 0)
      {
        int i = (int)(ConversationViewFragment.access$400(this$1.this$0).getScale() / ConversationViewFragment.access$400(this$1.this$0).getInitialScale());
        if (i > 1) {
          ConversationViewFragment.access$400(this$1.this$0).scrollBy(0, ConversationViewFragment.access$1400(this$1.this$0) * (i - 1));
        }
        ConversationViewFragment.access$1402(this$1.this$0, 0);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      LogUtils.e(ConversationViewFragment.access$200(), localThrowable, "Error in MailJsBridge.onWebContentGeometryChange", new Object[0]);
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.ConversationViewFragment.MailJsBridge.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */