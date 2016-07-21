package com.android.email.activity.setup;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import are;
import arf;
import atn;
import avy;

public class OAuthAuthenticationActivity
  extends Activity
  implements atn
{
  public final void a(Bundle paramBundle)
  {
    setResult(-1, new Intent().putExtras(paramBundle));
    finish();
  }
  
  public final boolean a()
  {
    return false;
  }
  
  public final void e_() {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(arf.r);
    paramBundle = getIntent();
    paramBundle = avy.a(paramBundle.getStringExtra("fallback_email_address"), paramBundle.getStringExtra("provider"));
    getFragmentManager().beginTransaction().add(are.O, paramBundle).commit();
  }
}

/* Location:
 * Qualified Name:     com.android.email.activity.setup.OAuthAuthenticationActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */