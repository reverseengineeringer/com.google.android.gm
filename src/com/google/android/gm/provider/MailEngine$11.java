package com.google.android.gm.provider;

import java.util.concurrent.Semaphore;

class MailEngine$11
  implements Runnable
{
  MailEngine$11(MailEngine paramMailEngine, Semaphore paramSemaphore) {}
  
  public void run()
  {
    LogUtils.i("Gmail", "blockUntilBackgroundTasksComplete: finished", new Object[0]);
    val$semaphore.release();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailEngine.11
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */