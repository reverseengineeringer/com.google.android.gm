package com.android.mail.browse;

public class GmailConversationProvider
  extends ConversationCursor.ConversationProvider
{
  protected String getAuthority()
  {
    return "com.google.android.gm2.conversation.provider";
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.GmailConversationProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */