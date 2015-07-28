package com.android.mail.ui;

import com.android.mail.providers.Account;
import com.android.mail.providers.AccountObserver;

class ConversationListFragment$1
  extends AccountObserver
{
  ConversationListFragment$1(ConversationListFragment paramConversationListFragment) {}
  
  public void onChanged(Account paramAccount)
  {
    ConversationListFragment.access$002(this$0, paramAccount);
    ConversationListFragment.access$100(this$0);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.ConversationListFragment.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */