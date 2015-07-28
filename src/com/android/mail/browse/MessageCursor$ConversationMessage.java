package com.android.mail.browse;

import android.net.Uri;
import com.android.mail.providers.Attachment;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Message;
import com.android.mail.ui.ConversationUpdater;
import com.google.common.base.Objects;
import java.util.Iterator;
import java.util.List;

public final class MessageCursor$ConversationMessage
  extends Message
{
  public final transient Conversation conversation;
  private final transient MessageCursor.ConversationController mController;
  
  public MessageCursor$ConversationMessage(MessageCursor paramMessageCursor, Conversation paramConversation, MessageCursor.ConversationController paramConversationController)
  {
    super(paramMessageCursor);
    conversation = paramConversation;
    mController = paramConversationController;
  }
  
  private int getAttachmentsStateHashCode()
  {
    int i = 0;
    Iterator localIterator = getAttachments().iterator();
    if (localIterator.hasNext())
    {
      Uri localUri = ((Attachment)localIterator.next()).getIdentifierUri();
      if (localUri != null) {}
      for (int j = localUri.hashCode();; j = 0)
      {
        i += j;
        break;
      }
    }
    return i;
  }
  
  public int getStateHashCode()
  {
    return Objects.hashCode(new Object[] { uri, Boolean.valueOf(read), Boolean.valueOf(starred), Integer.valueOf(getAttachmentsStateHashCode()) });
  }
  
  public boolean isConversationStarred()
  {
    MessageCursor localMessageCursor = mController.getMessageCursor();
    return (localMessageCursor != null) && (localMessageCursor.isConversationStarred());
  }
  
  public void star(boolean paramBoolean)
  {
    ConversationUpdater localConversationUpdater = mController.getListController();
    if (localConversationUpdater != null) {
      localConversationUpdater.starMessage(this, paramBoolean);
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.MessageCursor.ConversationMessage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */