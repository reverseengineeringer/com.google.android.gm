package com.android.mail.ui;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.android.mail.providers.Account;
import com.android.mail.utils.LogUtils;
import com.android.mail.utils.Utils;
import java.util.Iterator;
import java.util.List;

public class AbstractConversationViewFragment$AbstractConversationWebViewClient
  extends WebViewClient
{
  protected AbstractConversationViewFragment$AbstractConversationWebViewClient(AbstractConversationViewFragment paramAbstractConversationViewFragment) {}
  
  private Intent generateProxyIntent(Uri paramUri)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW", this$0.mAccount.viewIntentProxyUri);
    localIntent.putExtra("original_uri", paramUri);
    localIntent.putExtra("account", this$0.mAccount);
    Object localObject2 = this$0.getContext();
    paramUri = null;
    try
    {
      localObject1 = ((Context)localObject2).getPackageManager();
      paramUri = (Uri)localObject1;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      for (;;)
      {
        Object localObject1;
        LogUtils.e(AbstractConversationViewFragment.access$600(), localUnsupportedOperationException, "Error getting package manager", new Object[0]);
      }
    }
    if (paramUri != null)
    {
      localObject1 = paramUri.queryIntentActivities(localIntent, 65536);
      paramUri = ((Context)localObject2).getPackageName();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = nextactivityInfo;
        if (paramUri.equals(packageName)) {
          localIntent.setClassName(packageName, name);
        }
      }
    }
    return localIntent;
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    Activity localActivity = this$0.getActivity();
    if (localActivity == null) {
      return false;
    }
    paramWebView = Uri.parse(paramString);
    if (!Utils.isEmpty(this$0.mAccount.viewIntentProxyUri)) {
      paramWebView = generateProxyIntent(paramWebView);
    }
    for (;;)
    {
      try
      {
        paramWebView.setFlags(524288);
        localActivity.startActivity(paramWebView);
        return true;
      }
      catch (ActivityNotFoundException paramWebView) {}
      paramWebView = new Intent("android.intent.action.VIEW", paramWebView);
      paramWebView.putExtra("com.android.browser.application_id", localActivity.getPackageName());
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.AbstractConversationViewFragment.AbstractConversationWebViewClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */