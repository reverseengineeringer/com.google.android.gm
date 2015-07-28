package com.google.android.gsf;

import android.accounts.Account;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.provider.BaseColumns;

public class SubscribedFeeds
{
  public static Uri addFeed(ContentResolver paramContentResolver, String paramString1, Account paramAccount, String paramString2, String paramString3)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("feed", paramString1);
    localContentValues.put("_sync_account", name);
    localContentValues.put("_sync_account_type", type);
    localContentValues.put("authority", paramString2);
    localContentValues.put("service", paramString3);
    return paramContentResolver.insert(Feeds.CONTENT_URI, localContentValues);
  }
  
  public static final class Feeds
    implements BaseColumns
  {
    public static final Uri CONTENT_URI = Uri.parse("content://subscribedfeeds/feeds");
    public static final Uri DELETED_CONTENT_URI = Uri.parse("content://subscribedfeeds/deleted_feeds");
  }
}

/* Location:
 * Qualified Name:     com.google.android.gsf.SubscribedFeeds
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */