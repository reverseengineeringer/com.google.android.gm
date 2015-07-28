package com.android.mail.utils;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.android.mail.providers.Attachment;
import com.google.common.collect.ImmutableMap.Builder;
import java.text.DecimalFormat;
import java.util.Map;

public class AttachmentUtils
{
  private static Map<String, String> sDisplayNameMap;
  
  public static String convertToHumanReadableSize(Context paramContext, long paramLong)
  {
    if (paramLong == 0L) {
      return "";
    }
    if (paramLong < 1024L) {
      return paramLong + paramContext.getString(2131492966);
    }
    if (paramLong < 1048576L) {
      return paramLong / 1024L + paramContext.getString(2131492967);
    }
    DecimalFormat localDecimalFormat = new DecimalFormat("0.#");
    return localDecimalFormat.format((float)paramLong / 1048576.0F) + paramContext.getString(2131492968);
  }
  
  public static String getDisplayType(Context paramContext, Attachment paramAttachment)
  {
    Object localObject2 = getMimeTypeDisplayName(paramContext, contentType);
    if (!TextUtils.isEmpty(contentType)) {}
    for (int i = contentType.indexOf('/');; i = -1)
    {
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (i > 0) {
          localObject1 = getMimeTypeDisplayName(paramContext, contentType.substring(0, i));
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        paramAttachment = Utils.getFileExtension(name);
        localObject2 = localObject1;
        if (paramAttachment != null)
        {
          localObject2 = localObject1;
          if (paramAttachment.length() > 1)
          {
            localObject2 = localObject1;
            if (paramAttachment.indexOf('.') == 0) {
              localObject2 = paramContext.getString(2131492977, new Object[] { paramAttachment.substring(1).toUpperCase() });
            }
          }
        }
      }
      paramContext = (Context)localObject2;
      if (localObject2 == null) {
        paramContext = "";
      }
      return paramContext;
    }
  }
  
  public static String getIdentifier(Attachment paramAttachment)
  {
    paramAttachment = contentUri;
    if (paramAttachment != null) {
      return paramAttachment.toString();
    }
    return null;
  }
  
  public static String getMimeTypeDisplayName(Context paramContext, String paramString)
  {
    try
    {
      if (sDisplayNameMap == null)
      {
        String str1 = paramContext.getString(2131492973);
        String str2 = paramContext.getString(2131492974);
        String str3 = paramContext.getString(2131492975);
        sDisplayNameMap = new ImmutableMap.Builder().put("image", paramContext.getString(2131492969)).put("audio", paramContext.getString(2131492971)).put("video", paramContext.getString(2131492970)).put("text", paramContext.getString(2131492972)).put("application/pdf", paramContext.getString(2131492976)).put("application/msword", str1).put("application/vnd.openxmlformats-officedocument.wordprocessingml.document", str1).put("application/vnd.ms-powerpoint", str2).put("application/vnd.openxmlformats-officedocument.presentationml.presentation", str2).put("application/vnd.ms-excel", str3).put("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", str3).build();
      }
      paramContext = (String)sDisplayNameMap.get(paramString);
      return paramContext;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     com.android.mail.utils.AttachmentUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */