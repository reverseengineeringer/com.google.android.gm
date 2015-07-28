package com.android.mail.ui;

import android.app.LoaderManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.webkit.WebView;
import com.android.mail.providers.Address;
import com.android.mail.utils.LogUtils;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class ConversationViewFragment$ConversationWebViewClient
  extends AbstractConversationViewFragment.AbstractConversationWebViewClient
{
  private ConversationViewFragment$ConversationWebViewClient(ConversationViewFragment paramConversationViewFragment)
  {
    super(paramConversationViewFragment);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    ControllableActivity localControllableActivity = (ControllableActivity)this$0.getActivity();
    if ((!this$0.isAdded()) || (!ConversationViewFragment.access$700(this$0)))
    {
      LogUtils.i(ConversationViewFragment.access$200(), "ignoring CVF.onPageFinished, url=%s fragment=%s", new Object[] { paramString, this$0 });
      return;
    }
    LogUtils.i(ConversationViewFragment.access$200(), "IN CVF.onPageFinished, url=%s fragment=%s wv=%s t=%sms", new Object[] { paramString, this$0, paramWebView, Long.valueOf(SystemClock.uptimeMillis() - ConversationViewFragment.access$800(this$0)) });
    ConversationViewFragment.access$900(this$0);
    if (!ConversationViewFragment.access$1000(this$0)) {
      ConversationViewFragment.access$1100(this$0);
    }
    paramWebView = Sets.newHashSet();
    paramString = this$0.mAddressCache.values().iterator();
    while (paramString.hasNext()) {
      paramWebView.add(((Address)paramString.next()).getAddress());
    }
    paramString = this$0.getContactInfoSource();
    this$0.getContactInfoSource().setSenders(paramWebView);
    this$0.getLoaderManager().restartLoader(1, Bundle.EMPTY, paramString);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    return (ConversationViewFragment.access$700(this$0)) && (super.shouldOverrideUrlLoading(paramWebView, paramString));
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.ConversationViewFragment.ConversationWebViewClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */