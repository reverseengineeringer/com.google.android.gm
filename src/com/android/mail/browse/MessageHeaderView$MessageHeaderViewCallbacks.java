package com.android.mail.browse;

import com.android.mail.providers.Message;

public abstract interface MessageHeaderView$MessageHeaderViewCallbacks
{
  public abstract void setMessageDetailsExpanded(ConversationViewAdapter.MessageHeaderItem paramMessageHeaderItem, boolean paramBoolean, int paramInt);
  
  public abstract void setMessageExpanded(ConversationViewAdapter.MessageHeaderItem paramMessageHeaderItem, int paramInt);
  
  public abstract void setMessageSpacerHeight(ConversationViewAdapter.MessageHeaderItem paramMessageHeaderItem, int paramInt);
  
  public abstract void showExternalResources(Message paramMessage);
}

/* Location:
 * Qualified Name:     com.android.mail.browse.MessageHeaderView.MessageHeaderViewCallbacks
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */