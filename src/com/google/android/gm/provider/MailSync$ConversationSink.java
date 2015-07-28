package com.google.android.gm.provider;

public abstract interface MailSync$ConversationSink
{
  public abstract void finalizeSink();
  
  public abstract void handleConversation(MailSync.Conversation paramConversation);
  
  public abstract void prepareSink();
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailSync.ConversationSink
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */