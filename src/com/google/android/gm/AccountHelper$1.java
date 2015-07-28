package com.google.android.gm;

import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import com.google.android.gm.provider.LogUtils;
import java.io.IOException;

class AccountHelper$1
  implements AccountManagerCallback<Account[]>
{
  AccountHelper$1(AccountHelper paramAccountHelper, AccountHelper.AccountResultsCallback paramAccountResultsCallback) {}
  
  public void run(AccountManagerFuture<Account[]> paramAccountManagerFuture)
  {
    Object localObject = null;
    try
    {
      paramAccountManagerFuture = (Account[])paramAccountManagerFuture.getResult();
      val$callback.exec(paramAccountManagerFuture);
      return;
    }
    catch (OperationCanceledException paramAccountManagerFuture)
    {
      for (;;)
      {
        LogUtils.w("Gmail", paramAccountManagerFuture, "Unexpected exception trying to get accounts.", new Object[0]);
        paramAccountManagerFuture = (AccountManagerFuture<Account[]>)localObject;
      }
    }
    catch (IOException paramAccountManagerFuture)
    {
      for (;;)
      {
        LogUtils.w("Gmail", paramAccountManagerFuture, "Unexpected exception trying to get accounts.", new Object[0]);
        paramAccountManagerFuture = (AccountManagerFuture<Account[]>)localObject;
      }
    }
    catch (AuthenticatorException paramAccountManagerFuture)
    {
      for (;;)
      {
        LogUtils.w("Gmail", paramAccountManagerFuture, "Unexpected exception trying to get accounts.", new Object[0]);
        paramAccountManagerFuture = (AccountManagerFuture<Account[]>)localObject;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.AccountHelper.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */