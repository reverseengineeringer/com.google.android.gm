package com.google.android.gm.provider;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LogUtils
  extends com.android.mail.utils.LogUtils
{
  private static Boolean sDebugLoggingEnabledForTests = null;
  
  public static String contentUriToString(Uri paramUri)
  {
    if (isDebugLoggingEnabled("Gmail")) {
      return paramUri.toString();
    }
    List localList = paramUri.getPathSegments();
    paramUri = new Uri.Builder().scheme(paramUri.getScheme()).authority(paramUri.getAuthority()).query(paramUri.getQuery()).fragment(paramUri.getFragment()).appendPath(String.valueOf(((String)localList.get(0)).hashCode()));
    int i = 1;
    while (i < localList.size())
    {
      paramUri.appendPath((String)localList.get(i));
      i += 1;
    }
    return paramUri.toString();
  }
  
  public static String labelSetToString(Set<String> paramSet)
  {
    if ((isDebugLoggingEnabled("Gmail")) || (paramSet == null))
    {
      if (paramSet != null) {
        return paramSet.toString();
      }
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder("[");
    int i = 0;
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      String str = (String)paramSet.next();
      if (i > 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append(sanitizeLabelName(str));
      i += 1;
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public static String sanitizeLabelName(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    do
    {
      do
      {
        return str;
        str = paramString;
      } while (isDebugLoggingEnabled("Gmail"));
      str = paramString;
    } while (Gmail.isSystemLabel(paramString));
    return "userlabel:" + String.valueOf(paramString.hashCode());
  }
  
  static void setDebugLoggingEnabledForTests(boolean paramBoolean)
  {
    sDebugLoggingEnabledForTests = Boolean.valueOf(paramBoolean);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.LogUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */