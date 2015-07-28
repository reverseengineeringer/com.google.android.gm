package com.google.android.gm.provider;

import android.content.ContentResolver;
import android.database.Cursor;

public final class Gmail$DetachedMessageCursor
  extends Gmail.MessageCursor
{
  public Gmail$DetachedMessageCursor(ContentResolver paramContentResolver, String paramString, Cursor paramCursor)
  {
    super(null, paramContentResolver, paramString, paramCursor);
  }
  
  public void onChange(boolean paramBoolean) {}
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.Gmail.DetachedMessageCursor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */