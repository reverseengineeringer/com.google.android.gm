package com.google.android.gm.browse;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import buo;
import but;
import com.google.android.gms.identity.accounts.api.AccountData;
import cvl;
import din;
import dri;
import flw;
import ghz;

public class TrampolineActivity
  extends Activity
{
  public static final String a = cvl.a;
  private din b = new din(this);
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Object localObject = getIntent();
    paramBundle = ((Intent)localObject).getAction();
    if ("com.google.android.gm.intent.VIEW_PLID".equals(paramBundle))
    {
      String str1 = ((Intent)localObject).getStringExtra("plid");
      paramBundle = str1;
      if (TextUtils.isEmpty(str1))
      {
        dri.c(a, "Intent does not contain a plid.", new Object[0]);
        String str2 = ((Intent)localObject).getStringExtra("permalink");
        paramBundle = str1;
        if (str2 != null)
        {
          paramBundle = ghz.a(getContentResolver(), "gmail_permalink_plid_param", "plid");
          paramBundle = Uri.parse(str2).getQueryParameter(paramBundle);
        }
      }
      if (TextUtils.isEmpty(paramBundle))
      {
        buo.a().a("plid_intent", "failure", "no_plid", 0L);
        dri.e(a, "Intent does not contain a plid nor permalink.", new Object[0]);
        finish();
        return;
      }
      if (!flw.a(this, (Intent)localObject))
      {
        buo.a().a("plid_intent", "failure", "no_account_data", 0L);
        dri.e(a, "Intent does not contain account data.", new Object[0]);
        finish();
        return;
      }
      str1 = bb;
      localObject = new Bundle(2);
      ((Bundle)localObject).putString("plid", paramBundle);
      ((Bundle)localObject).putString("account-name", str1);
      getLoaderManager().initLoader(0, (Bundle)localObject, b);
      return;
    }
    dri.c(a, "Unrecognized intent: %s", new Object[] { paramBundle });
    finish();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.browse.TrampolineActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */