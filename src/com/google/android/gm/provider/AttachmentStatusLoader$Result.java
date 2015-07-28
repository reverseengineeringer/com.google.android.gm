package com.google.android.gm.provider;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gm.provider.uiprovider.UIAttachment;

public class AttachmentStatusLoader$Result
  implements UIAttachment
{
  public String contentType;
  public final long conversationId;
  public int downloadStatus;
  public int downloadedSize;
  public final String fileName;
  public Gmail.Attachment mOriginalAttachment;
  public final long messageId;
  public final String partId;
  public final Gmail.AttachmentRendition rendition;
  public final boolean saveToSd;
  public int size;
  public final int state;
  public final int status;
  private Integer transientDestination;
  private String transientSavedFileUri;
  private Integer transientStatus;
  
  public AttachmentStatusLoader$Result(long paramLong1, long paramLong2, String paramString1, boolean paramBoolean, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    conversationId = paramLong1;
    messageId = paramLong2;
    partId = paramString1;
    saveToSd = paramBoolean;
    fileName = paramString2;
    contentType = paramString3;
    status = paramInt;
    rendition = Gmail.AttachmentRendition.valueOf(paramString4);
    if ((AttachmentManager.isStatusSuccess(paramInt)) && (AttachmentManager.isDownloadStillPresent(paramString2)))
    {
      if (paramBoolean) {}
      for (paramInt = 3;; paramInt = 2)
      {
        state = paramInt;
        return;
      }
    }
    if (AttachmentManager.isStatusRunning(paramInt))
    {
      state = 1;
      return;
    }
    state = 0;
  }
  
  private boolean updatedToCompleteState()
  {
    return (!TextUtils.isEmpty(transientSavedFileUri)) && (transientStatus != null) && (transientStatus.intValue() == 3);
  }
  
  public boolean downloadCompletedSuccessfully()
  {
    return getStatus() == 3;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if ((paramObject == null) || (paramObject.getClass() != getClass())) {
        return false;
      }
      paramObject = (Result)paramObject;
    } while ((messageId == messageId) && (partId.equals(partId)));
    return false;
  }
  
  public String getContentType()
  {
    return contentType;
  }
  
  public int getDestination()
  {
    if (transientDestination != null) {
      return transientDestination.intValue();
    }
    if (saveToSd) {
      return 1;
    }
    return 0;
  }
  
  public int getDownloadedSize()
  {
    return downloadedSize;
  }
  
  public Uri getExternalFilePath()
  {
    if (isDownloadedToSd()) {
      return Uri.parse(fileName);
    }
    if ((getStatus() == 3) && (getDestination() == 1) && (transientSavedFileUri != null)) {
      return Uri.parse(transientSavedFileUri);
    }
    return null;
  }
  
  public String getJoinedAttachmentInfo()
  {
    if (mOriginalAttachment != null) {
      return mOriginalAttachment.toJoinedString();
    }
    return null;
  }
  
  public String getName()
  {
    if (mOriginalAttachment != null)
    {
      String str = mOriginalAttachment.getName();
      if (!TextUtils.isEmpty(str)) {
        return str;
      }
    }
    return Uri.parse(fileName).getLastPathSegment();
  }
  
  public Gmail.AttachmentOrigin getOrigin()
  {
    return null;
  }
  
  public String getOriginExtras()
  {
    return null;
  }
  
  public Gmail.Attachment getOriginal()
  {
    return mOriginalAttachment;
  }
  
  public String getPartId()
  {
    return partId;
  }
  
  public int getSize()
  {
    if ((mOriginalAttachment != null) && (mOriginalAttachment.getSize() != 0)) {
      return mOriginalAttachment.getSize();
    }
    LogUtils.e("Gmail", "Returning inaccurate attachment size", new Object[0]);
    return downloadedSize;
  }
  
  public int getStatus()
  {
    if (isStatusError()) {
      return 1;
    }
    if (state == 1) {
      return 2;
    }
    if ((transientStatus != null) && (((AttachmentManager.isStatusSuccess(status)) && (!AttachmentManager.isDownloadStillPresent(fileName))) || (AttachmentManager.isStatusPending(status)) || ((transientStatus.intValue() == 2) && ((AttachmentManager.isStatusError(status)) || (AttachmentManager.isStatusSuccess(status)))))) {
      return transientStatus.intValue();
    }
    if ((isDownloadedToSd()) || (isDownloadedToCache()) || (updatedToCompleteState())) {
      return 3;
    }
    return 0;
  }
  
  public int hashCode()
  {
    return (int)(messageId ^ partId.hashCode());
  }
  
  public boolean isDownloadedToCache()
  {
    return state == 2;
  }
  
  public boolean isDownloadedToSd()
  {
    return state == 3;
  }
  
  public boolean isDownloading()
  {
    return getStatus() == 2;
  }
  
  public boolean isStatusError()
  {
    if (transientStatus != null) {}
    for (int i = transientStatus.intValue();; i = status) {
      return AttachmentManager.isStatusError(i);
    }
  }
  
  public boolean isStatusPaused()
  {
    return (AttachmentManager.isStatusPaused(status)) || (downloadStatus == 4);
  }
  
  public boolean isStatusPending()
  {
    return AttachmentManager.isStatusPending(status);
  }
  
  public boolean isStatusSuccess()
  {
    if (transientStatus != null) {}
    for (int i = transientStatus.intValue();; i = status) {
      return AttachmentManager.isStatusSuccess(i);
    }
  }
  
  public boolean isStatusValid()
  {
    return AttachmentManager.isStatusValid(status);
  }
  
  public boolean supportsOrigin()
  {
    return false;
  }
  
  public String toString()
  {
    return String.format("Result: conv=%d msg=%d part=%s fname=%s status=%d state=%d size=%d dled=%d transientStatus=%s, transientDestination=%s, transientFile=%s", new Object[] { Long.valueOf(conversationId), Long.valueOf(messageId), partId, fileName, Integer.valueOf(status), Integer.valueOf(state), Integer.valueOf(size), Integer.valueOf(downloadedSize), transientStatus, transientDestination, transientSavedFileUri });
  }
  
  public void updateState(int paramInt1, int paramInt2, String paramString)
  {
    transientStatus = Integer.valueOf(paramInt1);
    transientDestination = Integer.valueOf(paramInt2);
    transientSavedFileUri = paramString;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.AttachmentStatusLoader.Result
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */