package com.google.android.gm.provider;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.google.android.gsf.Gservices;
import com.google.common.collect.ImmutableSet;
import java.util.List;
import java.util.Set;

public class MimeType
{
  static final String EML_ATTACHMENT_CONTENT_TYPE = "application/eml";
  static final String GENERIC_MIMETYPE = "application/octet-stream";
  private static final Set<String> UNACCEPTABLE_ATTACHMENT_TYPES = ImmutableSet.of("application/zip", "application/x-gzip", "application/x-bzip2", "application/x-compress", "application/x-compressed", "application/x-tar", new String[0]);
  private static Set<String> sGviewSupportedTypes = ImmutableSet.of("application/pdf", "application/vnd.ms-powerpoint", "image/tiff", "application/msword", "application/vnd.openxmlformats-officedocument.wordprocessingml.document", "application/vnd.openxmlformats-officedocument.presentationml.presentation", new String[0]);
  
  private static String getFilenameExtension(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramString.lastIndexOf('.');
      localObject1 = localObject2;
      if (i > 0)
      {
        localObject1 = localObject2;
        if (i < paramString.length() - 1) {
          localObject1 = paramString.substring(i + 1).toLowerCase();
        }
      }
    }
    return (String)localObject1;
  }
  
  static String inferMimeType(String paramString1, String paramString2)
  {
    String str = getFilenameExtension(paramString1);
    if (TextUtils.isEmpty(str)) {}
    do
    {
      return paramString2;
      if (("text/plain".equalsIgnoreCase(paramString2)) || ("application/octet-stream".equalsIgnoreCase(paramString2))) {}
      for (int i = 1;; i = 0)
      {
        paramString1 = null;
        if ((i != 0) || (TextUtils.isEmpty(paramString2))) {
          paramString1 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
        }
        if (TextUtils.isEmpty(paramString1)) {
          break;
        }
        return paramString1;
      }
      if (str.equals("eml")) {
        return "application/eml";
      }
    } while (!TextUtils.isEmpty(paramString2));
    return "application/octet-stream";
  }
  
  public static boolean isBlocked(String paramString)
  {
    return UNACCEPTABLE_ATTACHMENT_TYPES.contains(paramString);
  }
  
  public static boolean isPreviewable(Context paramContext, String paramString)
  {
    paramContext = Gservices.getString(paramContext.getContentResolver(), "gmail_gview_supported_types");
    if (paramContext != null) {
      sGviewSupportedTypes = ImmutableSet.copyOf(TextUtils.split(paramContext, ","));
    }
    return sGviewSupportedTypes.contains(paramString);
  }
  
  public static boolean isViewable(Context paramContext, Uri paramUri, String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0) || ("null".equals(paramString))) {}
    for (;;)
    {
      return false;
      if (!isBlocked(paramString))
      {
        Intent localIntent = new Intent("android.intent.action.VIEW");
        localIntent.setDataAndType(paramUri, paramString);
        try
        {
          paramContext = paramContext.getPackageManager();
          if (paramContext.queryIntentActivities(localIntent, 65536).size() > 0) {
            return true;
          }
        }
        catch (UnsupportedOperationException paramContext) {}
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MimeType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */