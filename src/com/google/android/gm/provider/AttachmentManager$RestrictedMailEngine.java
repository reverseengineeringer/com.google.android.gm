package com.google.android.gm.provider;

public abstract interface AttachmentManager$RestrictedMailEngine
{
  public abstract void enqueueAttachmentDownloadTask();
  
  public abstract String getAuthToken()
    throws Exception;
  
  public abstract int getRequestVersion();
  
  public abstract void postBackgroundTask(Runnable paramRunnable);
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.AttachmentManager.RestrictedMailEngine
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */