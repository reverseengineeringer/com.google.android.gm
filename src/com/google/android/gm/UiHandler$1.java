package com.google.android.gm;

import java.util.concurrent.atomic.AtomicInteger;

class UiHandler$1
  implements Runnable
{
  UiHandler$1(UiHandler paramUiHandler, Runnable paramRunnable) {}
  
  public void run()
  {
    UiHandler.access$000(this$0).decrementAndGet();
    val$r.run();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.UiHandler.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */