package com.google.android.gm.contentprovider;

import android.net.Uri;

public final class GmailAccess
{
  public static final String[] LABEL_PROJECTION = { "_id", "labelUri", "canonicalName", "name", "numConversations", "numUnreadConversations", "text_color", "background_color" };
  
  public static Uri getLabelsUri(String paramString)
  {
    return Uri.parse("content://com.google.android.gm/" + paramString + "/labels");
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.contentprovider.GmailAccess
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */