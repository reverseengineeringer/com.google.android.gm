package com.google.android.gm.provider;

import com.google.android.common.http.PartSource;
import java.io.IOException;
import java.io.InputStream;

class MailSync$AttachmentPartSource
  implements PartSource
{
  private final Gmail.Attachment mAttachment;
  InputStream mInputStream;
  long mLength;
  private final long mMessageId;
  
  public MailSync$AttachmentPartSource(MailSync paramMailSync, long paramLong, Gmail.Attachment paramAttachment)
    throws IOException, SecurityException
  {
    mMessageId = paramLong;
    mAttachment = paramAttachment;
    mInputStream = newInputStream();
    mLength = mInputStream.available();
  }
  
  private InputStream newInputStream()
    throws IOException, SecurityException
  {
    return MailSync.access$300(this$0).getInputStreamForUploadedAttachment(mMessageId, mAttachment);
  }
  
  public InputStream createInputStream()
    throws IOException, SecurityException
  {
    if (mInputStream != null)
    {
      InputStream localInputStream = mInputStream;
      mInputStream = null;
      return localInputStream;
    }
    return newInputStream();
  }
  
  public String getFileName()
  {
    return mAttachment.name;
  }
  
  public long getLength()
  {
    return mLength;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailSync.AttachmentPartSource
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */