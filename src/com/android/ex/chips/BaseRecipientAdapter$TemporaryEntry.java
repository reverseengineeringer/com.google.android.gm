package com.android.ex.chips;

import android.database.Cursor;

class BaseRecipientAdapter$TemporaryEntry
{
  public final long contactId;
  public final long dataId;
  public final String destination;
  public final String destinationLabel;
  public final int destinationType;
  public final String displayName;
  public final int displayNameSource;
  public final String thumbnailUriString;
  
  public BaseRecipientAdapter$TemporaryEntry(Cursor paramCursor)
  {
    displayName = paramCursor.getString(0);
    destination = paramCursor.getString(1);
    destinationType = paramCursor.getInt(2);
    destinationLabel = paramCursor.getString(3);
    contactId = paramCursor.getLong(4);
    dataId = paramCursor.getLong(5);
    thumbnailUriString = paramCursor.getString(6);
    displayNameSource = paramCursor.getInt(7);
  }
}

/* Location:
 * Qualified Name:     com.android.ex.chips.BaseRecipientAdapter.TemporaryEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */