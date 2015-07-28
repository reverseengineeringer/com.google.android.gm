package com.android.mail.ui;

import android.os.Handler;
import com.android.mail.utils.LogUtils;
import java.util.TimerTask;

class AbstractActivityController$RefreshTimerTask
  extends TimerTask
{
  final AbstractActivityController mController;
  final Handler mHandler;
  
  public void run()
  {
    mHandler.post(new Runnable()
    {
      public void run()
      {
        LogUtils.d(AbstractActivityController.LOG_TAG, "Delay done... calling onRefreshRequired", new Object[0]);
        mController.onRefreshRequired();
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.AbstractActivityController.RefreshTimerTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */