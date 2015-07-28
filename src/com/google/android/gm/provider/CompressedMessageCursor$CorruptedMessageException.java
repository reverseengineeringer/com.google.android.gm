package com.google.android.gm.provider;

public class CompressedMessageCursor$CorruptedMessageException
  extends RuntimeException
{
  private final long mMessageId;
  
  public CompressedMessageCursor$CorruptedMessageException(CompressedMessageCursor paramCompressedMessageCursor, long paramLong, Throwable paramThrowable) {}
  
  public long getMessageId()
  {
    return mMessageId;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.CompressedMessageCursor.CorruptedMessageException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */