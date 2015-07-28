package com.google.android.gm.provider;

public abstract interface MailSyncObserver
{
  public abstract void onMessageReceived();
  
  public abstract void onOperationReceived();
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailSyncObserver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */