package com.google.android.gm.provider;

class MailEngine$5
  implements Runnable
{
  MailEngine$5(MailEngine paramMailEngine) {}
  
  public void run()
  {
    AttachmentManager localAttachmentManager = MailEngine.access$1200(this$0);
    if (localAttachmentManager != null)
    {
      localAttachmentManager.maybeStartNextAttachmentDownload();
      return;
    }
    LogUtils.e("Gmail", "null AttachmentManager instance", new Object[0]);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailEngine.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */