package com.google.android.gm;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class ReauthenticateActivity
  extends GmailBaseActivity
  implements AccountHelper.CredentialsCallback
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    AccountHelper.promptForCredentials(this, getIntent().getData().getQueryParameter("account"), this);
  }
  
  public void onCredentialsResult(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = -1;; i = 0)
    {
      setResult(i);
      finish();
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.ReauthenticateActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */