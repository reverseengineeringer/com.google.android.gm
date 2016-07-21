package com.android.mail.providers;

import android.content.Context;
import android.content.Intent;
import cgr;
import com.android.exchange.service.EasService;
import com.google.android.gm.welcome.WelcomeTourActivity;
import cuh;

public class GmailAccountCacheProvider
  extends cgr
{
  protected final Intent a(Context paramContext)
  {
    paramContext = new Intent(paramContext, WelcomeTourActivity.class);
    paramContext.putExtra("tour-highest-version-seen", -1);
    return paramContext;
  }
  
  protected final String a()
  {
    return "com.google.android.gm2.accountcache";
  }
  
  public boolean onCreate()
  {
    cuh.a(getContext(), EasService.class.getName());
    return super.onCreate();
  }
}

/* Location:
 * Qualified Name:     com.android.mail.providers.GmailAccountCacheProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */