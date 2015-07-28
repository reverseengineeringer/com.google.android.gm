package com.android.mail.browse;

import android.database.Cursor;
import android.database.CursorWrapper;
import android.net.Uri;
import android.os.Bundle;
import com.android.mail.providers.Attachment;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Message;
import com.android.mail.ui.ConversationUpdater;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MessageCursor
  extends CursorWrapper
{
  private final Map<Long, ConversationMessage> mCache = Maps.newHashMap();
  private final ConversationController mController;
  private final Conversation mConversation;
  private Integer mStatus;
  
  public MessageCursor(Cursor paramCursor, Conversation paramConversation, ConversationController paramConversationController)
  {
    super(paramCursor);
    mConversation = paramConversation;
    mController = paramConversationController;
  }
  
  public String getDebugDump()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format("conv subj='%s' status=%d messages:\n", new Object[] { mConversation.subject, Integer.valueOf(getStatus()) }));
    int i = -1;
    for (;;)
    {
      i += 1;
      if (!moveToPosition(i)) {
        break;
      }
      ConversationMessage localConversationMessage = getMessage();
      ArrayList localArrayList = Lists.newArrayList();
      Iterator localIterator = localConversationMessage.getAttachments().iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(nexturi);
      }
      localStringBuilder.append(String.format("[Message #%d hash=%s uri=%s id=%s serverId=%s from='%s' draftType=%d isSending=%s read=%s starred=%s attUris=%s]\n", new Object[] { Integer.valueOf(i), Integer.valueOf(localConversationMessage.getStateHashCode()), uri, Long.valueOf(id), serverId, from, Integer.valueOf(draftType), Boolean.valueOf(isSending), Boolean.valueOf(read), Boolean.valueOf(starred), localArrayList }));
    }
    return localStringBuilder.toString();
  }
  
  public ConversationMessage getMessage()
  {
    long l = getWrappedCursor().getLong(0);
    ConversationMessage localConversationMessage2 = (ConversationMessage)mCache.get(Long.valueOf(l));
    ConversationMessage localConversationMessage1 = localConversationMessage2;
    if (localConversationMessage2 == null)
    {
      localConversationMessage1 = new ConversationMessage(this, mConversation, mController);
      mCache.put(Long.valueOf(l), localConversationMessage1);
    }
    return localConversationMessage1;
  }
  
  public int getStateHashCode()
  {
    return getStateHashCode(0);
  }
  
  public int getStateHashCode(int paramInt)
  {
    int i = 17;
    int j = -1;
    int k = getCount();
    for (;;)
    {
      j += 1;
      if ((!moveToPosition(j)) || (j >= k - paramInt)) {
        break;
      }
      i = i * 31 + getMessage().getStateHashCode();
    }
    return i;
  }
  
  public int getStatus()
  {
    if (mStatus != null) {
      return mStatus.intValue();
    }
    mStatus = Integer.valueOf(2);
    Bundle localBundle = getExtras();
    if ((localBundle != null) && (localBundle.containsKey("cursor_status"))) {
      mStatus = Integer.valueOf(localBundle.getInt("cursor_status"));
    }
    return mStatus.intValue();
  }
  
  public boolean isConversationRead()
  {
    int i = -1;
    do
    {
      i += 1;
      if (!moveToPosition(i)) {
        break;
      }
    } while (getMessageread);
    return false;
    return true;
  }
  
  public boolean isConversationStarred()
  {
    int i = -1;
    do
    {
      i += 1;
      if (!moveToPosition(i)) {
        break;
      }
    } while (!getMessagestarred);
    return true;
    return false;
  }
  
  public boolean isLoaded()
  {
    return (getStatus() >= 2) || (getCount() > 0);
  }
  
  public void markMessagesRead()
  {
    int i = -1;
    for (;;)
    {
      i += 1;
      if (!moveToPosition(i)) {
        break;
      }
      getMessageread = true;
    }
  }
  
  public static abstract interface ConversationController
  {
    public abstract ConversationUpdater getListController();
    
    public abstract MessageCursor getMessageCursor();
  }
  
  public static final class ConversationMessage
    extends Message
  {
    public final transient Conversation conversation;
    private final transient MessageCursor.ConversationController mController;
    
    public ConversationMessage(MessageCursor paramMessageCursor, Conversation paramConversation, MessageCursor.ConversationController paramConversationController)
    {
      super();
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
}

/* Location:
 * Qualified Name:     com.android.mail.browse.MessageCursor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */