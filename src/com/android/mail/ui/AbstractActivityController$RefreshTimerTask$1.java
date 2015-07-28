package com.android.mail.ui;

import com.android.mail.utils.LogUtils;

class AbstractActivityController$RefreshTimerTask$1
  implements Runnable
{
  AbstractActivityController$RefreshTimerTask$1(AbstractActivityController.RefreshTimerTask paramRefreshTimerTask) {}
  
  public void run()
  {
    LogUtils.d(AbstractActivityController.LOG_TAG, "Delay done... calling onRefreshRequired", new Object[0]);
    this$0.mController.onRefreshRequired();
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.AbstractActivityController.RefreshTimerTask.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */