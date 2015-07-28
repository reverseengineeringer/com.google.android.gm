package com.android.mail.ui;

import android.os.Handler;
import com.android.mail.utils.LogTag;
import com.android.mail.utils.LogUtils;
import java.util.concurrent.atomic.AtomicInteger;

public class UiHandler
{
  private static final String LOG_TAG = ;
  private AtomicInteger mCount = new AtomicInteger(0);
  private boolean mEnabled = true;
  private final Handler mHandler = new Handler();
  
  public void setEnabled(boolean paramBoolean)
  {
    mEnabled = paramBoolean;
    if (!mEnabled)
    {
      int i = mCount.getAndSet(0);
      if (i > 0) {
        LogUtils.e(LOG_TAG, "Disable UiHandler. Dropping %d Runnables.", new Object[] { Integer.valueOf(i) });
      }
      mHandler.removeCallbacksAndMessages(null);
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.UiHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */