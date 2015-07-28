package com.google.android.gm.provider;

public class Operations$OperationInfo
{
  public String mAction;
  public long mConversationId;
  public int mDelay;
  public long mLabelId;
  public long mMessageId;
  public long mNextTimeToAttempt;
  public int mNumAttempts;
  
  public Operations$OperationInfo(long paramLong1, long paramLong2, String paramString, long paramLong3)
  {
    this(paramLong1, paramLong2, paramString, paramLong3, 0, 0, 0L);
  }
  
  public Operations$OperationInfo(long paramLong1, long paramLong2, String paramString, long paramLong3, int paramInt1, int paramInt2, long paramLong4)
  {
    mConversationId = paramLong1;
    mMessageId = paramLong2;
    mAction = paramString;
    mLabelId = paramLong3;
    mNumAttempts = paramInt1;
    mDelay = paramInt2;
    mNextTimeToAttempt = paramLong4;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.Operations.OperationInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */