package com.google.android.gm.welcome;

import android.app.Activity;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import buo;
import but;
import cvl;
import cxa;
import dfy;
import dga;
import eaf;
import eag;
import eah;
import ghz;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChangeAddressActivity
  extends Activity
{
  public static final String a = cvl.a;
  public String b;
  public WebView c;
  public String d;
  public String e;
  public Set<String> f = new HashSet();
  public String g;
  public Matcher h;
  public View i;
  private WebViewClient j = new eaf(this);
  private LoaderManager.LoaderCallbacks<String> k = new eag(this);
  
  public static String a(Uri paramUri)
  {
    return new Uri.Builder().scheme(paramUri.getScheme()).authority(paramUri.getHost()).path(paramUri.getPath()).toString();
  }
  
  public final void a()
  {
    if (TextUtils.isEmpty(g)) {}
    for (int m = 0;; m = -1)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("account-address", b);
      localIntent.putExtra("changed-address", g);
      setResult(m, localIntent);
      super.finish();
      return;
    }
  }
  
  public void onBackPressed()
  {
    a();
    super.onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(dga.p);
    i = findViewById(dfy.ab);
    b = getIntent().getStringExtra("account-address");
    c = ((WebView)findViewById(dfy.cv));
    paramBundle = getContentResolver();
    d = ghz.a(paramBundle, "gmail_account_change_email", "https://security.google.com/settings/security/username");
    e = ghz.a(paramBundle, "gmail_account_change_email_finished", "https://www.google.com/settings/personalinfo");
    h = Pattern.compile(ghz.a(paramBundle, "gmail_account_central_setcookie_regexp", "https://(accounts|security)\\.google\\.[a-zA-Z0-9 -퟿豈-﷏ﷰ-￯]{2,63}/.*")).matcher("");
    f.add(ghz.a(paramBundle, "gmail_account_central_login", "https://accounts.google.com/ServiceLogin"));
    f.add(ghz.a(paramBundle, "gmail_account_central_checkcookie", "https://accounts.google.com/CheckCookie"));
    paramBundle = Uri.parse(d);
    f.add(a(paramBundle));
    paramBundle = c.getSettings();
    paramBundle.setSaveFormData(false);
    paramBundle.setJavaScriptEnabled(true);
    paramBundle.setSupportZoom(true);
    paramBundle.setBlockNetworkImage(false);
    cxa.a(c, this);
    c.setScrollBarStyle(0);
    c.setWebViewClient(j);
    c.addJavascriptInterface(new eah(this), "AndroidGmail");
    getLoaderManager().initLoader(1, Bundle.EMPTY, k);
    buo.a().a(this);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  protected void onStop()
  {
    buo.a().b(this);
    super.onStop();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.welcome.ChangeAddressActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */