package com.android.email.activity.setup;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import arh;
import asj;
import asl;
import bgz;
import com.android.email.SecurityPolicy;
import com.android.emailcommon.provider.Account;
import com.android.emailcommon.provider.HostAuth;

public class AccountSecurity
  extends Activity
{
  public Account a;
  public boolean b;
  public Handler c;
  public boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private asl h;
  private Bundle i;
  
  public static Intent a(Context paramContext, long paramLong, boolean paramBoolean)
  {
    paramContext = new Intent(paramContext, AccountSecurity.class);
    paramContext.putExtra("ACCOUNT_ID", paramLong);
    paramContext.putExtra("SHOW_DIALOG", paramBoolean);
    return paramContext;
  }
  
  private final void a()
  {
    if (!b) {
      getLoaderManager().initLoader(0, i, h);
    }
  }
  
  public static void a(Account paramAccount, SecurityPolicy paramSecurityPolicy)
  {
    if (paramAccount == null) {
      return;
    }
    new asj(paramSecurityPolicy, paramAccount).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }
  
  public static Intent b(Context paramContext, long paramLong, boolean paramBoolean)
  {
    ForwardingIntent localForwardingIntent = new ForwardingIntent(paramContext, AccountSecurity.class);
    localForwardingIntent.putExtra("ACCOUNT_ID", paramLong);
    if (paramBoolean) {}
    for (paramContext = "EXPIRED";; paramContext = "EXPIRING")
    {
      localForwardingIntent.putExtra(paramContext, true);
      return localForwardingIntent;
    }
  }
  
  public final void a(Account paramAccount)
  {
    SecurityPolicy localSecurityPolicy = SecurityPolicy.a(this);
    if (!localSecurityPolicy.e())
    {
      if (e)
      {
        a(paramAccount, localSecurityPolicy);
        finish();
        return;
      }
      e = true;
      HostAuth localHostAuth = t;
      if (localHostAuth == null)
      {
        a(paramAccount, localSecurityPolicy);
        finish();
        return;
      }
      paramAccount = new Intent("android.app.action.ADD_DEVICE_ADMIN");
      paramAccount.putExtra("android.app.extra.DEVICE_ADMIN", b);
      paramAccount.putExtra("android.app.extra.ADD_EXPLANATION", getString(arh.n, new Object[] { c }));
      startActivityForResult(paramAccount, 1);
      return;
    }
    if (localSecurityPolicy.a(null))
    {
      Account.g(this);
      localSecurityPolicy.a(paramAccount);
      localSecurityPolicy.d();
      finish();
      return;
    }
    localSecurityPolicy.c();
    int j = localSecurityPolicy.b(null);
    if ((j & 0x4) != 0)
    {
      if (f)
      {
        a(paramAccount, localSecurityPolicy);
        finish();
        return;
      }
      f = true;
      startActivityForResult(new Intent("android.app.action.SET_NEW_PASSWORD"), 2);
      return;
    }
    if ((j & 0x8) != 0)
    {
      if (g)
      {
        a(paramAccount, localSecurityPolicy);
        finish();
        return;
      }
      g = true;
      startActivityForResult(new Intent("android.app.action.START_ENCRYPTION"), 3);
      return;
    }
    Account.g(this);
    localSecurityPolicy.a(paramAccount);
    localSecurityPolicy.d();
    finish();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    a(a);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    c = new Handler();
    Object localObject = getIntent();
    Bundle localBundle;
    if (((Intent)localObject).getExtras() == null)
    {
      localBundle = new Bundle();
      if (((Intent)localObject).getData() == null) {
        break label240;
      }
    }
    label240:
    for (long l = bgz.a(((Intent)localObject).getData(), "ACCOUNT_ID");; l = -1L)
    {
      localBundle.putLong("ACCOUNT_ID", l);
      localObject = ((Intent)localObject).getData().getQueryParameter("SHOW_DIALOG");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
      for (boolean bool = Boolean.getBoolean((String)localObject);; bool = false)
      {
        localBundle.putBoolean("SHOW_DIALOG", bool);
        SecurityPolicy.a(this).d();
        if (l == -1L) {
          finish();
        }
        do
        {
          return;
          l = ((Intent)localObject).getLongExtra("ACCOUNT_ID", -1L);
          localBundle = ((Intent)localObject).getExtras();
          break;
          if (paramBundle != null)
          {
            b = paramBundle.getBoolean("initialized", false);
            e = paramBundle.getBoolean("triedAddAdministrator", false);
            f = paramBundle.getBoolean("triedSetpassword", false);
            g = paramBundle.getBoolean("triedSetEncryption", false);
            a = ((Account)paramBundle.getParcelable("account"));
          }
        } while (b);
        i = localBundle;
        h = new asl(this);
        a();
        return;
      }
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    d = false;
  }
  
  protected void onResume()
  {
    super.onResume();
    d = true;
    a();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("initialized", b);
    paramBundle.putBoolean("triedAddAdministrator", e);
    paramBundle.putBoolean("triedSetpassword", f);
    paramBundle.putBoolean("triedSetEncryption", g);
    paramBundle.putParcelable("account", a);
  }
}

/* Location:
 * Qualified Name:     com.android.email.activity.setup.AccountSecurity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */