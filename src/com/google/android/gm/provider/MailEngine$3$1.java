package com.google.android.gm.provider;

import android.os.Handler;

class MailEngine$3$1
  implements MailEngine.MailEngineInitListener
{
  MailEngine$3$1(MailEngine.3 param3, MailEngine paramMailEngine) {}
  
  public void onInitializationComplete()
  {
    this$0.val$callerHandler.post(new Runnable()
    {
      public void run()
      {
        this$0.val$callback.onMailEngineResult(val$engine);
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailEngine.3.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */