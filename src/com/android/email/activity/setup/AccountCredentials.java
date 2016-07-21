package com.android.email.activity.setup;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import are;
import arf;
import atl;
import atn;

public class AccountCredentials
  extends Activity
  implements atn
{
  public static Intent a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = new Intent(paramContext, AccountCredentials.class);
    paramContext.putExtra("email", paramString1);
    paramContext.putExtra("protocol", paramString2);
    return paramContext;
  }
  
  public final void a(Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    setResult(-1, localIntent);
    finish();
  }
  
  public final boolean a()
  {
    return false;
  }
  
  public final void e_()
  {
    a(((atl)getFragmentManager().findFragmentByTag("credentials")).c());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(arf.a);
    String str1 = getIntent().getStringExtra("email");
    String str2 = getIntent().getStringExtra("protocol");
    setFinishOnTouchOutside(false);
    if (paramBundle == null)
    {
      paramBundle = atl.a(str1, str2, null, false, true);
      getFragmentManager().beginTransaction().add(are.c, paramBundle, "credentials").commit();
    }
    setResult(0);
  }
}

/* Location:
 * Qualified Name:     com.android.email.activity.setup.AccountCredentials
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */