package com.google.android.gm.provider;

public class MailSync$ConversationInfo
{
  public final long highestFetchedMessageId;
  public final long id;
  
  public MailSync$ConversationInfo(long paramLong1, long paramLong2)
  {
    id = paramLong1;
    highestFetchedMessageId = paramLong2;
  }
  
  public boolean equals(Object paramObject)
  {
    return toString().equals(paramObject.toString());
  }
  
  public String toString()
  {
    return "[ConversationInfo id: " + id + ", highest: " + highestFetchedMessageId + "]";
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailSync.ConversationInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */