package com.android.mail.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.google.common.collect.ImmutableSet;
import java.util.List;
import java.util.Set;

public class MimeType
{
  static final String EML_ATTACHMENT_CONTENT_TYPE = "application/eml";
  static final String GENERIC_MIMETYPE = "application/octet-stream";
  private static final String LOG_TAG = ;
  private static final Set<String> UNACCEPTABLE_ATTACHMENT_TYPES = ImmutableSet.of("application/zip", "application/x-gzip", "application/x-bzip2", "application/x-compress", "application/x-compressed", "application/x-tar", new String[0]);
  private static Set<String> sGviewSupportedTypes = ImmutableSet.of("application/pdf", "application/vnd.ms-powerpoint", "image/tiff", "application/msword", "application/vnd.openxmlformats-officedocument.wordprocessingml.document", "application/vnd.openxmlformats-officedocument.presentationml.presentation", new String[0]);
  
  public static boolean isBlocked(String paramString)
  {
    return UNACCEPTABLE_ATTACHMENT_TYPES.contains(paramString);
  }
  
  public static boolean isInstallable(String paramString)
  {
    return "application/vnd.android.package-archive".equals(paramString);
  }
  
  public static boolean isViewable(Context paramContext, Uri paramUri, String paramString)
  {
    boolean bool = true;
    if ((paramString == null) || (paramString.length() == 0) || ("null".equals(paramString)))
    {
      LogUtils.d(LOG_TAG, "Attachment with null content type. '%s", new Object[] { paramUri });
      return false;
    }
    if (isBlocked(paramString))
    {
      LogUtils.d(LOG_TAG, "content type '%s' is blocked. '%s", new Object[] { paramString, paramUri });
      return false;
    }
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setFlags(524289);
    if (paramUri != null) {
      Utils.setIntentDataAndTypeAndNormalize(localIntent, paramUri, paramString);
    }
    for (;;)
    {
      try
      {
        paramContext = paramContext.getPackageManager();
        paramContext = paramContext.queryIntentActivities(localIntent, 65536);
        if (paramContext.size() == 0) {
          LogUtils.w(LOG_TAG, "Unable to find supporting activity. mime-type: %s, uri: %s, normalized mime-type: %s normalized uri: %s", new Object[] { paramString, paramUri, localIntent.getType(), localIntent.getData() });
        }
        if (paramContext.size() <= 0) {
          break label186;
        }
        return bool;
      }
      catch (UnsupportedOperationException paramContext)
      {
        return false;
      }
      Utils.setIntentTypeAndNormalize(localIntent, paramString);
      continue;
      label186:
      bool = false;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.utils.MimeType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */