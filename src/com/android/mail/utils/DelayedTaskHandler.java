package com.android.mail.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

public abstract class DelayedTaskHandler
  extends Handler
{
  private final int mDelayMs;
  private long mLastTaskExecuteTime = -1L;
  
  public DelayedTaskHandler(Looper paramLooper, int paramInt)
  {
    super(paramLooper);
    mDelayMs = paramInt;
  }
  
  public void dispatchMessage(Message paramMessage)
  {
    onTaskExecution();
    performTask();
  }
  
  public void onTaskExecution()
  {
    mLastTaskExecuteTime = SystemClock.elapsedRealtime();
  }
  
  protected abstract void performTask();
  
  public void scheduleTask()
  {
    long l = SystemClock.elapsedRealtime();
    removeMessages(0);
    if ((mLastTaskExecuteTime == -1L) || (mLastTaskExecuteTime + mDelayMs < l))
    {
      sendEmptyMessage(0);
      return;
    }
    sendEmptyMessageDelayed(0, mDelayMs);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.utils.DelayedTaskHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */