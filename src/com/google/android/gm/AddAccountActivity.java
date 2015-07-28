package com.google.android.gm;

import android.accounts.Account;
import android.app.Activity;
import android.os.Bundle;

public class AddAccountActivity
  extends GmailBaseActivity
{
  private boolean mAccountCreated = false;
  
  private void onAccountCreated(Account[] paramArrayOfAccount)
  {
    mAccountCreated = true;
    setResult(-1);
    finish();
  }
  
  private void onFailureToAddAccount()
  {
    setResult(0);
    finish();
  }
  
  private void waitForGmailAccount()
  {
    new AccountHelper(getContext()).asyncGetAccountsInfo(new AccountHelper.AccountResultsCallback()
    {
      public void exec(Account[] paramAnonymousArrayOfAccount)
      {
        if ((paramAnonymousArrayOfAccount == null) || (paramAnonymousArrayOfAccount.length == 0))
        {
          AccountHelper.showAddAccount(jdField_this, new AccountHelper.AddAccountCallback()
          {
            public void onResult(Account paramAnonymous2Account)
            {
              if (paramAnonymous2Account != null)
              {
                AddAccountActivity.this.onAccountCreated(new Account[] { paramAnonymous2Account });
                return;
              }
              AddAccountActivity.this.onFailureToAddAccount();
            }
          });
          return;
        }
        AddAccountActivity.this.onAccountCreated(paramAnonymousArrayOfAccount);
      }
    });
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onResume()
  {
    super.onResume();
    if (!mAccountCreated) {
      waitForGmailAccount();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.AddAccountActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */