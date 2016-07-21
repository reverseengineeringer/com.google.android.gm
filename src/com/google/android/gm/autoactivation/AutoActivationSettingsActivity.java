package com.google.android.gm.autoactivation;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import are;
import arf;
import ass;
import ath;
import atv;
import awp;
import awq;
import bbn;
import com.android.email.activity.setup.SetupDataFragment;
import com.android.emailcommon.provider.Account;
import com.android.emailcommon.provider.HostAuth;
import cvl;
import cvm;

public class AutoActivationSettingsActivity
  extends ath
  implements ass, awp
{
  private static final String b = cvl.a;
  private SetupDataFragment c;
  private atv d;
  private String e;
  private ResultReceiver f;
  
  public static Intent a(Context paramContext, SetupDataFragment paramSetupDataFragment, String paramString, ResultReceiver paramResultReceiver)
  {
    paramContext = new Intent(paramContext, AutoActivationSettingsActivity.class);
    paramContext.putExtra("setupData", paramSetupDataFragment);
    paramContext.putExtra("errorMessage", paramString);
    paramContext.putExtra("resultReceiver", paramResultReceiver);
    return paramContext;
  }
  
  public final void a(int paramInt)
  {
    if (f != null) {
      f.send(-1, bbn.a(c));
    }
    finish();
  }
  
  public final void a(String paramString1, String paramString2) {}
  
  public final boolean a()
  {
    return false;
  }
  
  public final void e_()
  {
    finish();
  }
  
  public final void k() {}
  
  public final SetupDataFragment l()
  {
    return c;
  }
  
  public void onBackPressed()
  {
    if (f != null) {
      f.send(0, null);
    }
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(arf.c);
    Intent localIntent = getIntent();
    if (localIntent == null)
    {
      cvm.d(b, "AutoActivationSettingsActivity.onCreate, intent is null", new Object[0]);
      finish();
    }
    if (paramBundle != null) {
      c = ((SetupDataFragment)paramBundle.getParcelable("setupData"));
    }
    if (c == null) {
      c = ((SetupDataFragment)localIntent.getParcelableExtra("setupData"));
    }
    e = localIntent.getStringExtra("errorMessage");
    f = ((ResultReceiver)localIntent.getParcelableExtra("resultReceiver"));
    d = atv.b(3, false);
    getFragmentManager().beginTransaction().replace(are.p, d).commit();
  }
  
  protected void onResume()
  {
    super.onResume();
    Object localObject = c.b;
    if (localObject != null)
    {
      localObject = ((Account)localObject).d(this);
      atv localatv = d;
      int i = e;
      awq.a(t, Integer.valueOf(i & 0xB));
    }
    if (!TextUtils.isEmpty(e)) {
      d.a(e);
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    d.f();
    paramBundle.putParcelable("setupData", c);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.autoactivation.AutoActivationSettingsActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */