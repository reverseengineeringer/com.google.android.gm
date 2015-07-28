package com.android.mail.browse;

import android.webkit.WebView;
import com.android.mail.ui.AbstractConversationViewFragment.AbstractConversationWebViewClient;

class SecureConversationViewFragment$1
  extends AbstractConversationViewFragment.AbstractConversationWebViewClient
{
  SecureConversationViewFragment$1(SecureConversationViewFragment paramSecureConversationViewFragment)
  {
    super(paramSecureConversationViewFragment);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    if (this$0.isUserVisible()) {
      SecureConversationViewFragment.access$000(this$0);
    }
    SecureConversationViewFragment.access$100(this$0);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.SecureConversationViewFragment.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */