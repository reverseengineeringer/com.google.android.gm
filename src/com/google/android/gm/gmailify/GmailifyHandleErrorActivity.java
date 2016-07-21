package com.google.android.gm.gmailify;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gm.utils.WebViewUrl;
import cvl;
import cvm;
import dkd;
import dky;

public class GmailifyHandleErrorActivity
  extends dkd
{
  private static final String c = cvl.a;
  
  final String a()
  {
    return "gmailify_fix_error";
  }
  
  public final void c() {}
  
  public void onCreate(Bundle paramBundle)
  {
    Object localObject = (WebViewUrl)getIntent().getParcelableExtra("errorUrl");
    if ((TextUtils.isEmpty(a)) || (!b))
    {
      paramBundle = c;
      str1 = String.valueOf(localObject);
      boolean bool = b;
      cvm.f(paramBundle, new IllegalStateException(String.valueOf(str1).length() + 24 + "url=" + str1 + " authenticated=" + bool), GmailifyHandleErrorActivity.class.getName(), new Object[0]);
      finish();
      return;
    }
    super.onCreate(paramBundle);
    paramBundle = a;
    String str1 = getIntent().getStringExtra("gmail");
    String str2 = getIntent().getStringExtra("email");
    localObject = c;
    dky localdky = new dky();
    Bundle localBundle = new Bundle(4);
    localBundle.putString("url", paramBundle);
    localBundle.putString("gmailAddress", str1);
    localBundle.putString("thirdPartyEmail", str2);
    localBundle.putString("domainWhitelist", (String)localObject);
    localdky.setArguments(localBundle);
    a(localdky);
    a("start", getIntent().getStringExtra("analytics"), 0L);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.gmailify.GmailifyHandleErrorActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */