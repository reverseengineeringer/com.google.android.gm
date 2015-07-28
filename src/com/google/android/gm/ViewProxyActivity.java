package com.google.android.gm;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.android.mail.utils.LogTag;
import com.google.android.gm.provider.LogUtils;
import com.google.android.gsf.Gservices;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ViewProxyActivity
  extends Activity
{
  public void addUriAccountIntentExtras(Uri paramUri, com.android.mail.providers.Account paramAccount, Intent paramIntent)
  {
    paramUri = paramUri.getHost();
    Object localObject = Pattern.compile(Gservices.getString(getContentResolver(), "gmail_account_extras_uri_host_pattern", ".*\\.google(\\.co(m?))?(\\.\\w{2})?"));
    if ((paramUri != null) && (((Pattern)localObject).matcher(paramUri).matches())) {}
    try
    {
      paramUri = MessageDigest.getInstance("MD5");
      localObject = Long.toString(new Random().nextLong());
      paramUri.update(((String)localObject + name + "com.google").getBytes());
      paramIntent.putExtra("salt", (String)localObject);
      paramIntent.putExtra("digest", paramUri.digest());
      return;
    }
    catch (NoSuchAlgorithmException paramUri)
    {
      LogUtils.e(LogTag.getLogTag(), paramUri, "Unable to load MD5 digest instance", new Object[0]);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = (Uri)getIntent().getParcelableExtra("original_uri");
    com.android.mail.providers.Account localAccount = (com.android.mail.providers.Account)getIntent().getParcelableExtra("account");
    Intent localIntent = new Intent("android.intent.action.VIEW", paramBundle);
    localIntent.setFlags(524288);
    localIntent.putExtra("com.android.browser.application_id", getPackageName());
    addUriAccountIntentExtras(paramBundle, localAccount, localIntent);
    try
    {
      startActivity(localIntent);
      finish();
      return;
    }
    catch (ActivityNotFoundException paramBundle)
    {
      for (;;) {}
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.ViewProxyActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */