package com.android.mail.ui;

import android.graphics.Bitmap;
import com.android.mail.providers.Attachment;

public abstract interface AttachmentTile$AttachmentPreviewCache
{
  public abstract Bitmap get(Attachment paramAttachment);
  
  public abstract void set(Attachment paramAttachment, Bitmap paramBitmap);
}

/* Location:
 * Qualified Name:     com.android.mail.ui.AttachmentTile.AttachmentPreviewCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */