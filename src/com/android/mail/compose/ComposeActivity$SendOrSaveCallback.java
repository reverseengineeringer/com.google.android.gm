package com.android.mail.compose;

import com.android.mail.providers.Message;

public abstract interface ComposeActivity$SendOrSaveCallback
{
  public abstract Message getMessage();
  
  public abstract void initializeSendOrSave(ComposeActivity.SendOrSaveTask paramSendOrSaveTask);
  
  public abstract void notifyMessageIdAllocated(ComposeActivity.SendOrSaveMessage paramSendOrSaveMessage, Message paramMessage);
  
  public abstract void sendOrSaveFinished(ComposeActivity.SendOrSaveTask paramSendOrSaveTask, boolean paramBoolean);
}

/* Location:
 * Qualified Name:     com.android.mail.compose.ComposeActivity.SendOrSaveCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */