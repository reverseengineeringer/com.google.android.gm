package com.google.android.gm.provider.uiprovider;

import android.net.Uri;
import com.google.android.gm.provider.Gmail.Attachment;
import com.google.android.gm.provider.Gmail.AttachmentOrigin;
import java.util.List;

public abstract interface UIAttachment
{
  public abstract boolean downloadCompletedSuccessfully();
  
  public abstract String getContentType();
  
  public abstract int getDestination();
  
  public abstract int getDownloadedSize();
  
  public abstract Uri getExternalFilePath();
  
  public abstract String getJoinedAttachmentInfo();
  
  public abstract String getName();
  
  public abstract Gmail.AttachmentOrigin getOrigin();
  
  public abstract String getOriginExtras();
  
  public abstract Gmail.Attachment getOriginal();
  
  public abstract String getPartId();
  
  public abstract int getSize();
  
  public abstract int getStatus();
  
  public abstract boolean isDownloading();
  
  public abstract boolean supportsOrigin();
  
  public abstract void updateState(int paramInt1, int paramInt2, String paramString);
  
  public static class UriParser
  {
    public final String mAccount;
    public final List<String> mContentTypeQueryParameters;
    public final long mConversationId;
    public final long mLocalMessageId;
    public final long mMessageId;
    public final String mPartId;
    
    private UriParser(String paramString1, long paramLong1, long paramLong2, long paramLong3, String paramString2, List<String> paramList)
    {
      mAccount = paramString1;
      mConversationId = paramLong1;
      mMessageId = paramLong2;
      mLocalMessageId = paramLong3;
      mPartId = paramString2;
      mContentTypeQueryParameters = paramList;
    }
    
    public static UriParser parse(Uri paramUri)
    {
      Object localObject = paramUri.getPathSegments();
      String str = (String)((List)localObject).get(0);
      List localList = paramUri.getQueryParameters("contentType");
      long l1 = Long.parseLong((String)((List)localObject).get(2));
      long l2 = Long.parseLong((String)((List)localObject).get(3));
      if (((List)localObject).size() >= 5) {}
      for (localObject = (String)((List)localObject).get(4);; localObject = null) {
        return new UriParser(str, l1, Long.parseLong(paramUri.getQueryParameter("serverMessageId")), l2, (String)localObject, localList);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.uiprovider.UIAttachment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */