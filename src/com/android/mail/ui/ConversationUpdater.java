package com.android.mail.ui;

import android.net.Uri;
import com.android.mail.browse.ConversationItemView;
import com.android.mail.browse.MessageCursor.ConversationMessage;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import java.util.Collection;
import java.util.Set;

public abstract interface ConversationUpdater
  extends ConversationListCallbacks
{
  public abstract void assignFolder(Collection<FolderOperation> paramCollection, Collection<Conversation> paramCollection1, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void delete(int paramInt, Collection<Conversation> paramCollection, DestructiveAction paramDestructiveAction);
  
  public abstract void delete(int paramInt, Collection<Conversation> paramCollection, Collection<ConversationItemView> paramCollection1, DestructiveAction paramDestructiveAction);
  
  public abstract DestructiveAction getBatchAction(int paramInt);
  
  public abstract DestructiveAction getDeferredBatchAction(int paramInt);
  
  public abstract DestructiveAction getDeferredRemoveFolder(Collection<Conversation> paramCollection, Folder paramFolder, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  public abstract void markConversationMessagesUnread(Conversation paramConversation, Set<Uri> paramSet, String paramString);
  
  public abstract void markConversationsRead(Collection<Conversation> paramCollection, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void refreshConversationList();
  
  public abstract void showNextConversation(Collection<Conversation> paramCollection);
  
  public abstract void starMessage(MessageCursor.ConversationMessage paramConversationMessage, boolean paramBoolean);
  
  public abstract void updateConversation(Collection<Conversation> paramCollection, String paramString, int paramInt);
  
  public abstract void updateConversation(Collection<Conversation> paramCollection, String paramString, boolean paramBoolean);
}

/* Location:
 * Qualified Name:     com.android.mail.ui.ConversationUpdater
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */