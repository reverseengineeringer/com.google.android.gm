package com.google.android.gm.setup;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import bam;
import ban;
import buo;
import but;
import com.android.email.activity.setup.AccountSetupFinal;
import com.android.email.activity.setup.SetupDataFragment;
import com.android.emailcommon.EmailProviderConfiguration;
import com.android.emailcommon.provider.Account;
import com.android.emailcommon.provider.HostAuth;
import com.google.android.gms.identity.accounts.api.AccountData;
import cvm;
import ddy;
import dee;
import dge;
import dmo;
import dwv;
import flw;

public class AccountSetupFinalGmail
  extends AccountSetupFinal
{
  dmo g;
  private final dee h = new dwv(this);
  
  public final String a(Intent paramIntent)
  {
    paramIntent = flw.b(this, paramIntent);
    if (paramIntent != null) {
      return b;
    }
    return null;
  }
  
  protected final EmailProviderConfiguration b(String paramString)
  {
    return super.b(paramString);
  }
  
  public final boolean m()
  {
    return true;
  }
  
  public final boolean n()
  {
    ddy.a(this, h);
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    g = new dmo(this);
  }
  
  protected final void t()
  {
    super.t();
    Object localObject = a.b;
    ban localban = bam.e(this, db);
    if (localban == null) {
      buo.a().a("exchange_tracker", "logging_failed", "missing_service_info", 0L);
    }
    while (!TextUtils.equals(getString(dge.a), c)) {
      return;
    }
    localObject = d;
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      cvm.b(b, "AccountSetupFinalGmail: Logging error, empty email", new Object[0]);
      buo.a().a("exchange_tracker", "logging_failed", "empty_email", 0L);
      return;
    }
    g.a((String)localObject, e);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.setup.AccountSetupFinalGmail
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */