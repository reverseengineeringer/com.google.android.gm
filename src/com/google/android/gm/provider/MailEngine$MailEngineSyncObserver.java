package com.google.android.gm.provider;

class MailEngine$MailEngineSyncObserver
  implements MailSyncObserver
{
  private int mNumMessages = 0;
  private int mNumOperations = 0;
  
  public boolean changesReceived()
  {
    return (mNumMessages != 0) || (mNumOperations != 0);
  }
  
  public int getOperationCount()
  {
    return mNumOperations;
  }
  
  public void onMessageReceived()
  {
    mNumMessages += 1;
  }
  
  public void onOperationReceived()
  {
    mNumOperations += 1;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailEngine.MailEngineSyncObserver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */