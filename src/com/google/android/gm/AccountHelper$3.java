package com.google.android.gm;

import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.os.Bundle;
import com.google.android.gm.provider.LogUtils;
import java.io.IOException;

final class AccountHelper$3
  implements AccountManagerCallback<Bundle>
{
  AccountHelper$3(AccountHelper.CredentialsCallback paramCredentialsCallback) {}
  
  public void run(AccountManagerFuture<Bundle> paramAccountManagerFuture)
  {
    boolean bool = false;
    try
    {
      paramAccountManagerFuture = (Bundle)paramAccountManagerFuture.getResult();
      bool = true;
    }
    catch (OperationCanceledException paramAccountManagerFuture)
    {
      for (;;)
      {
        LogUtils.v("Gmail", "promptForCredentials(): User Canceled", new Object[0]);
      }
    }
    catch (IOException paramAccountManagerFuture)
    {
      for (;;)
      {
        LogUtils.v("Gmail", "promptForCredentials(): IO Error", new Object[0]);
      }
    }
    catch (AuthenticatorException paramAccountManagerFuture)
    {
      for (;;)
      {
        LogUtils.v("Gmail", "promptForCredentials(): Not Authenticated", new Object[0]);
      }
    }
    val$callback.onCredentialsResult(bool);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.AccountHelper.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */