package com.android.emailcommon.utility;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.security.KeyChain;
import android.security.KeyChainAliasCallback;

public class CertificateRequestor
  extends Activity
  implements KeyChainAliasCallback
{
  public static final Uri a = Uri.parse("eas://com.android.emailcommon/certrequest");
  
  public void alias(String paramString)
  {
    if (paramString == null) {
      setResult(0);
    }
    for (;;)
    {
      finish();
      return;
      Intent localIntent = new Intent();
      localIntent.putExtra("CertificateRequestor.alias", paramString);
      setResult(-1, localIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Object localObject = getIntent();
    String str = ((Intent)localObject).getStringExtra("CertificateRequestor.host");
    int i = ((Intent)localObject).getIntExtra("CertificateRequestor.port", -1);
    localObject = ((Intent)localObject).getStringExtra("CertificateRequestor.alias");
    if (paramBundle == null) {
      KeyChain.choosePrivateKeyAlias(this, this, null, null, str, i, (String)localObject);
    }
  }
}

/* Location:
 * Qualified Name:     com.android.emailcommon.utility.CertificateRequestor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */