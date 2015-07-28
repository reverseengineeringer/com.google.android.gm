package com.google.android.gm;

import android.accounts.Account;
import android.app.Activity;

class AddAccountActivity$1
  implements AccountHelper.AccountResultsCallback
{
  AddAccountActivity$1(AddAccountActivity paramAddAccountActivity, Activity paramActivity) {}
  
  public void exec(Account[] paramArrayOfAccount)
  {
    if ((paramArrayOfAccount == null) || (paramArrayOfAccount.length == 0))
    {
      AccountHelper.showAddAccount(val$activity, new AccountHelper.AddAccountCallback()
      {
        public void onResult(Account paramAnonymousAccount)
        {
          if (paramAnonymousAccount != null)
          {
            AddAccountActivity.access$000(this$0, new Account[] { paramAnonymousAccount });
            return;
          }
          AddAccountActivity.access$100(this$0);
        }
      });
      return;
    }
    AddAccountActivity.access$000(this$0, paramArrayOfAccount);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.AddAccountActivity.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */