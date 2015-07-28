package com.android.mail;

import android.net.Uri;
import com.android.mail.providers.Account;
import com.android.mail.providers.AccountObserver;
import com.android.mail.utils.LogUtils;

class AccountSpinnerAdapter$2
  extends AccountObserver
{
  AccountSpinnerAdapter$2(AccountSpinnerAdapter paramAccountSpinnerAdapter) {}
  
  public void onChanged(Account paramAccount)
  {
    if (paramAccount == null) {}
    while (uri.equals(AccountSpinnerAdapter.access$100(this$0))) {
      return;
    }
    AccountSpinnerAdapter.access$202(this$0, paramAccount);
    if (AccountSpinnerAdapter.access$300(this$0))
    {
      int i = Account.findPosition(AccountSpinnerAdapter.access$400(this$0), uri);
      LogUtils.d(AccountSpinnerAdapter.access$500(), "setCurrentAccount: mCurrentAccountPos = %d", new Object[] { Integer.valueOf(i) });
      if (i >= 0) {
        AccountSpinnerAdapter.access$000(this$0);
      }
    }
    this$0.notifyDataSetChanged();
  }
}

/* Location:
 * Qualified Name:     com.android.mail.AccountSpinnerAdapter.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */