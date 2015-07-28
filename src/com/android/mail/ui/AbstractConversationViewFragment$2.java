package com.android.mail.ui;

import com.android.mail.providers.Account;
import com.android.mail.providers.AccountObserver;

class AbstractConversationViewFragment$2
  extends AccountObserver
{
  AbstractConversationViewFragment$2(AbstractConversationViewFragment paramAbstractConversationViewFragment) {}
  
  public void onChanged(Account paramAccount)
  {
    Account localAccount = this$0.mAccount;
    this$0.mAccount = paramAccount;
    this$0.onAccountChanged(paramAccount, localAccount);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.AbstractConversationViewFragment.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */