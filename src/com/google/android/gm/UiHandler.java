package com.google.android.gm;

import android.os.Handler;
import com.google.android.gm.provider.LogUtils;
import java.util.concurrent.atomic.AtomicInteger;

public class UiHandler
{
  private AtomicInteger mCount = new AtomicInteger(0);
  private boolean mEnabled = true;
  private final Handler mHandler = new Handler();
  
  public void post(final Runnable paramRunnable)
  {
    if (mEnabled)
    {
      mCount.incrementAndGet();
      mHandler.post(new Runnable()
      {
        public void run()
        {
          mCount.decrementAndGet();
          paramRunnable.run();
        }
      });
      return;
    }
    LogUtils.d("Gmail", "UiHandler is disabled in post(). Dropping Runnable.", new Object[0]);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    mEnabled = paramBoolean;
    if (!mEnabled)
    {
      int i = mCount.getAndSet(0);
      if (i > 0) {
        LogUtils.e("Gmail", "Disable UiHandler. Dropping %d Runnables.", new Object[] { Integer.valueOf(i) });
      }
      mHandler.removeCallbacksAndMessages(null);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.UiHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */