package com.google.android.gm.autoactivation;

import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.security.KeyChain;
import android.text.TextUtils;
import com.android.emailcommon.utility.CertificateRequestor;

public class AutoActivationCertificateRequestor
  extends CertificateRequestor
{
  private ResultReceiver b;
  
  public void alias(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      if (b != null) {
        b.send(0, null);
      }
    }
    for (;;)
    {
      finish();
      return;
      Bundle localBundle = new Bundle();
      localBundle.putString("CertificateRequestor.alias", paramString);
      if (b != null) {
        b.send(-1, localBundle);
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    b = ((ResultReceiver)getIntent().getParcelableExtra("CertificateRequestor.resultReceiver"));
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    KeyChain.choosePrivateKeyAlias(this, this, null, null, paramIntent.getStringExtra("CertificateRequestor.host"), paramIntent.getIntExtra("CertificateRequestor.port", -1), paramIntent.getStringExtra("CertificateRequestor.alias"));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.autoactivation.AutoActivationCertificateRequestor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */