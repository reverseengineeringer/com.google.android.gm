package com.google.android.gm.provider;

public class MailEngine$SyncInfo
{
  public boolean backgroundSync = false;
  public long conversationId = -1L;
  public long messageId = -1L;
  public boolean normalSync = true;
  public boolean receivedHandledClientOp = false;
  
  public String toString()
  {
    return "SyncInfo: normalSync = " + normalSync + ", conversationId = " + conversationId + ", messageId = " + messageId + ", receivedHandledClientOp = " + receivedHandledClientOp;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailEngine.SyncInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */