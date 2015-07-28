package com.google.android.gm.provider;

import java.util.Observable;
import java.util.Observer;

class MailEngine$1
  implements Observer
{
  private boolean mLabelMapInitialized = false;
  private boolean mPreviousLabelSynced = false;
  
  MailEngine$1(MailEngine paramMailEngine) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((mLabelMapInitialized != MailEngine.access$000(this$0).labelsSynchronizationStateInitialized()) || (mPreviousLabelSynced != MailEngine.access$000(this$0).labelsSynced())) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        mPreviousLabelSynced = MailEngine.access$000(this$0).labelsSynced();
        mLabelMapInitialized = MailEngine.access$000(this$0).labelsSynchronizationStateInitialized();
        MailEngine.access$100(this$0);
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailEngine.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */