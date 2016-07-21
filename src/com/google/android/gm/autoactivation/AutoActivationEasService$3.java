package com.google.android.gm.autoactivation;

import android.os.Bundle;
import android.os.ResultReceiver;
import cvm;

class AutoActivationEasService$3
  extends ResultReceiver
{
  AutoActivationEasService$3(AutoActivationEasService paramAutoActivationEasService)
  {
    super(null);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    if (paramInt == -1)
    {
      paramBundle = paramBundle.getString("CertificateRequestor.alias");
      if (paramBundle != null)
      {
        cvm.d(AutoActivationEasService.a, "AutoActivationEasService: Certificate chosen, re-launch activation", new Object[0]);
        Bundle localBundle = new Bundle(a.d);
        localBundle.putString("exchange_login_certificate_alias", paramBundle);
        AutoActivationEasService.a(a.getApplicationContext(), localBundle, 3);
      }
    }
    else
    {
      return;
    }
    cvm.d(AutoActivationEasService.a, "AutoActivationEasService: User denied choosing certificate", new Object[0]);
    a.a();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.autoactivation.AutoActivationEasService.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */