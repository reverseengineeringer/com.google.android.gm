package com.google.android.gm;

import android.accounts.Account;

class AddAccountActivity$1$1
  implements AccountHelper.AddAccountCallback
{
  AddAccountActivity$1$1(AddAccountActivity.1 param1) {}
  
  public void onResult(Account paramAccount)
  {
    if (paramAccount != null)
    {
      AddAccountActivity.access$000(this$1.this$0, new Account[] { paramAccount });
      return;
    }
    AddAccountActivity.access$100(this$1.this$0);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.AddAccountActivity.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */