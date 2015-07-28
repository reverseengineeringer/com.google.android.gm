package com.android.mail.ui;

import android.content.ContentResolver;
import android.graphics.Bitmap;

public abstract interface AttachmentBitmapHolder
{
  public abstract boolean bitmapSetToDefault();
  
  public abstract ContentResolver getResolver();
  
  public abstract int getThumbnailHeight();
  
  public abstract int getThumbnailWidth();
  
  public abstract void setThumbnail(Bitmap paramBitmap);
  
  public abstract void setThumbnailToDefault();
}

/* Location:
 * Qualified Name:     com.android.mail.ui.AttachmentBitmapHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */