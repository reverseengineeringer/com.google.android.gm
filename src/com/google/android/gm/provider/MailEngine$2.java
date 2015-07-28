package com.google.android.gm.provider;

class MailEngine$2
  implements Runnable
{
  MailEngine$2(MailEngine paramMailEngine) {}
  
  public void run()
  {
    try
    {
      if ((!MailEngine.access$200(this$0)) && (!this$0.isLiveQueryInProgress()) && (!this$0.isBackgroundSyncInProgress())) {
        MailEngine.access$300(this$0, 1);
      }
      MailEngine.access$202(this$0, true);
      MailEngine.access$400(this$0, 4, false);
      return;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailEngine.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */