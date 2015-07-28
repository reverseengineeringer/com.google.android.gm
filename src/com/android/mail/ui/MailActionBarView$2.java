package com.android.mail.ui;

import android.widget.TextView;
import com.android.mail.providers.AccountObserver;

class MailActionBarView$2
  extends AccountObserver
{
  MailActionBarView$2(MailActionBarView paramMailActionBarView) {}
  
  public void onChanged(com.android.mail.providers.Account paramAccount)
  {
    MailActionBarView.access$002(this$0, paramAccount);
    if (MailActionBarView.access$100(this$0) != null) {
      MailActionBarView.access$100(this$0).setText(access$000this$0).name);
    }
    MailActionBarView.access$200(this$0).setAccount(MailActionBarView.access$000(this$0));
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.MailActionBarView.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */