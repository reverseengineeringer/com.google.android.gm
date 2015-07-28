package com.google.android.gm.provider;

import android.content.Context;
import android.os.Handler;

final class MailEngine$3
  implements Runnable
{
  MailEngine$3(Context paramContext, String paramString, Handler paramHandler1, Handler paramHandler2, MailEngine.MailEngineResultCallback paramMailEngineResultCallback) {}
  
  public void run()
  {
    final MailEngine localMailEngine = MailEngine.getOrMakeMailEngine(val$context, val$account);
    localMailEngine.registerInitializationListener(val$handler, new MailEngine.MailEngineInitListener()
    {
      public void onInitializationComplete()
      {
        val$callerHandler.post(new Runnable()
        {
          public void run()
          {
            val$callback.onMailEngineResult(val$engine);
          }
        });
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailEngine.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */