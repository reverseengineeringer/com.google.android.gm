package com.android.mail.ui;

import android.database.DataSetObserver;
import com.android.mail.browse.ConversationCursor;
import com.android.mail.providers.Conversation;

public abstract interface ConversationListCallbacks
{
  public abstract void commitDestructiveActions(boolean paramBoolean);
  
  public abstract ConversationCursor getConversationListCursor();
  
  public abstract Conversation getCurrentConversation();
  
  public abstract boolean isAnimating();
  
  public abstract boolean isInitialConversationLoading();
  
  public abstract void onConversationSeen(Conversation paramConversation);
  
  public abstract void onConversationSelected(Conversation paramConversation, boolean paramBoolean);
  
  public abstract void registerConversationListObserver(DataSetObserver paramDataSetObserver);
  
  public abstract void registerConversationLoadedObserver(DataSetObserver paramDataSetObserver);
  
  public abstract void setCurrentConversation(Conversation paramConversation);
  
  public abstract void unregisterConversationListObserver(DataSetObserver paramDataSetObserver);
  
  public abstract void unregisterConversationLoadedObserver(DataSetObserver paramDataSetObserver);
}

/* Location:
 * Qualified Name:     com.android.mail.ui.ConversationListCallbacks
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */