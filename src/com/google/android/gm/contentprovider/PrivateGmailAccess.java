package com.google.android.gm.contentprovider;

import android.net.Uri;
import android.net.Uri.Builder;

public class PrivateGmailAccess
{
  private static Uri getLabelUri(String paramString)
  {
    return Uri.parse("content://com.google.android.gm/" + paramString + "/label/");
  }
  
  public static Uri getLabelUriForId(String paramString, long paramLong)
  {
    return getLabelUri(paramString).buildUpon().appendPath(Long.toString(paramLong)).build();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.contentprovider.PrivateGmailAccess
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */