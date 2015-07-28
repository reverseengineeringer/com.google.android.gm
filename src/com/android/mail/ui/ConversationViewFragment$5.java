package com.android.mail.ui;

import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import com.android.mail.utils.LogUtils;

class ConversationViewFragment$5
  extends WebChromeClient
{
  ConversationViewFragment$5(ConversationViewFragment paramConversationViewFragment) {}
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    LogUtils.d(ConversationViewFragment.access$200(), "JS: %s (%s:%d)", new Object[] { paramConsoleMessage.message(), paramConsoleMessage.sourceId(), Integer.valueOf(paramConsoleMessage.lineNumber()) });
    return true;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.ConversationViewFragment.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */