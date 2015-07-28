package com.android.mail.ui;

import android.app.FragmentManager;
import com.android.mail.utils.LogUtils;

final class OnePaneController$PopBackStackRunnable
  implements Runnable
{
  private final int mTransactionId;
  
  public OnePaneController$PopBackStackRunnable(OnePaneController paramOnePaneController, int paramInt)
  {
    mTransactionId = paramInt;
  }
  
  public void popBackStack()
  {
    this$0.mActivity.getFragmentManager().popBackStack(mTransactionId, 0);
  }
  
  public void run()
  {
    if (this$0.safeToModifyFragments())
    {
      popBackStack();
      return;
    }
    LogUtils.i(AbstractActivityController.LOG_TAG, "Activity has been saved; ignoring unsafe deferred request to pop back stack", new Object[0]);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.OnePaneController.PopBackStackRunnable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */