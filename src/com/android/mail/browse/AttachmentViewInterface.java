package com.android.mail.browse;

import com.android.mail.providers.Attachment;
import java.util.List;

public abstract interface AttachmentViewInterface
{
  public abstract List<Attachment> getAttachments();
  
  public abstract void onUpdateStatus();
  
  public abstract void updateProgress(boolean paramBoolean);
  
  public abstract void viewAttachment();
}

/* Location:
 * Qualified Name:     com.android.mail.browse.AttachmentViewInterface
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */