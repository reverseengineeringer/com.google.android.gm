package com.android.mail.ui;

import com.android.mail.providers.Account;
import com.android.mail.providers.AccountObserver;

class AnimatedAdapter$2
  extends AccountObserver
{
  AnimatedAdapter$2(AnimatedAdapter paramAnimatedAdapter) {}
  
  public void onChanged(Account paramAccount)
  {
    AnimatedAdapter.access$000(this$0, paramAccount);
    this$0.notifyDataSetChanged();
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.AnimatedAdapter.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */