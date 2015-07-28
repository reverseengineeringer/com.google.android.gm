package com.android.mail.ui;

import android.os.SystemClock;
import com.android.mail.utils.LogUtils;

class ConversationViewFragment$MailJsBridge$2
  extends AbstractConversationViewFragment.FragmentRunnable
{
  ConversationViewFragment$MailJsBridge$2(ConversationViewFragment.MailJsBridge paramMailJsBridge, String paramString)
  {
    super(this$0, paramString);
  }
  
  public void go()
  {
    try
    {
      if (ConversationViewFragment.access$800(this$1.this$0) != 0L) {
        LogUtils.i(ConversationViewFragment.access$200(), "IN CVF.onContentReady, f=%s vis=%s t=%sms", new Object[] { this$1.this$0, Boolean.valueOf(this$1.this$0.isUserVisible()), Long.valueOf(SystemClock.uptimeMillis() - ConversationViewFragment.access$800(this$1.this$0)) });
      }
      ConversationViewFragment.access$1100(this$1.this$0);
      return;
    }
    catch (Throwable localThrowable)
    {
      LogUtils.e(ConversationViewFragment.access$200(), localThrowable, "Error in MailJsBridge.onContentReady", new Object[0]);
      ConversationViewFragment.access$1100(this$1.this$0);
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.ConversationViewFragment.MailJsBridge.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */