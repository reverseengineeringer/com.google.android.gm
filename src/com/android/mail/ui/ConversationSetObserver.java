package com.android.mail.ui;

public abstract interface ConversationSetObserver
{
  public abstract void onSetChanged(ConversationSelectionSet paramConversationSelectionSet);
  
  public abstract void onSetEmpty();
  
  public abstract void onSetPopulated(ConversationSelectionSet paramConversationSelectionSet);
}

/* Location:
 * Qualified Name:     com.android.mail.ui.ConversationSetObserver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */