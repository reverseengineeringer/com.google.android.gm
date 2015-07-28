package com.google.android.gm.provider.uiprovider;

import android.net.Uri;
import java.util.List;

public class UIAttachment$UriParser
{
  public final String mAccount;
  public final List<String> mContentTypeQueryParameters;
  public final long mConversationId;
  public final long mLocalMessageId;
  public final long mMessageId;
  public final String mPartId;
  
  private UIAttachment$UriParser(String paramString1, long paramLong1, long paramLong2, long paramLong3, String paramString2, List<String> paramList)
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

/* Location:
 * Qualified Name:     com.google.android.gm.provider.uiprovider.UIAttachment.UriParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */