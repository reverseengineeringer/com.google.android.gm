package com.google.android.gm.provider;

public abstract interface MailStore$OperationSink
{
  public abstract void conversationLabelAddedOrRemoved(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean);
  
  public abstract void messageExpunged(long paramLong1, long paramLong2);
  
  public abstract void messageLabelAdded(long paramLong1, long paramLong2, long paramLong3);
  
  public abstract void messageLabelRemoved(long paramLong1, long paramLong2, long paramLong3);
  
  public abstract void messageSavedOrSent(long paramLong1, MailSync.Message paramMessage, long paramLong2, long paramLong3, boolean paramBoolean);
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailStore.OperationSink
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */