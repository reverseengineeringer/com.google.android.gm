import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gm.browse.FullMessageActivity;

final class dif
  extends WebViewClient
{
  dif(die paramdie) {}
  
  public final void onPageFinished(WebView paramWebView, String paramString)
  {
    if (!a.isAdded())
    {
      dri.b(die.a, "ignoring FMF.onPageFinished, url=%s fragment=%s", new Object[] { paramString, a });
      return;
    }
    a.e.a(null);
  }
  
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    dri.b(die.a, "should override Url loading? %s", new Object[] { paramString });
    FullMessageActivity localFullMessageActivity = (FullMessageActivity)a.getActivity();
    if (localFullMessageActivity == null) {}
    do
    {
      return false;
      paramWebView = Uri.parse(paramString);
      if (paramWebView == null) {
        return true;
      }
      if (cxa.b(localFullMessageActivity, paramWebView, n)) {
        return true;
      }
      paramString = paramWebView.getHost();
    } while ((dyp.a(localFullMessageActivity.getContentResolver(), paramString)) && ((paramString.startsWith("accounts.google.")) || (paramString.startsWith("mail.google."))));
    if (a.c != null) {
      paramWebView = cjl.a(localFullMessageActivity, Uri.parse("content://com.android.gmail.ui/proxy"), paramWebView, a.c);
    }
    for (;;)
    {
      try
      {
        paramWebView.setFlags(589824);
        localFullMessageActivity.startActivity(paramWebView);
        bool = true;
      }
      catch (ActivityNotFoundException paramWebView)
      {
        boolean bool = false;
        continue;
      }
      return bool;
      paramWebView = new Intent("android.intent.action.VIEW", paramWebView);
      paramWebView.putExtra("com.android.browser.application_id", localFullMessageActivity.getPackageName());
      paramWebView.putExtra("create_new_tab", true);
    }
  }
}

/* Location:
 * Qualified Name:     dif
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */