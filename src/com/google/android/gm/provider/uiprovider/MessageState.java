package com.google.android.gm.provider.uiprovider;

import android.content.Context;
import com.google.android.gm.provider.AttachmentStatusLoader.Result;
import com.google.android.gm.provider.Gmail.Attachment;
import com.google.android.gm.provider.Gmail.AttachmentRendition;
import com.google.android.gm.provider.LogUtils;
import com.google.android.gm.provider.MailSync.Message;
import com.google.android.gm.provider.UiProvider;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MessageState
{
  private final String mAccount;
  private final Context mContext;
  private final long mConversationId;
  private final long mLocalMessageId;
  private final List<UIAttachment> mMessageAttachments = Lists.newArrayList();
  boolean mMessageAttachmentsInitialized = false;
  private final long mMessageId;
  
  public MessageState(Context paramContext, String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    mContext = paramContext;
    mAccount = paramString;
    mConversationId = paramLong1;
    mMessageId = paramLong2;
    mLocalMessageId = paramLong3;
  }
  
  private int getMessageAttachmentIndex(String paramString)
  {
    List localList = mMessageAttachments;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < mMessageAttachments.size())
        {
          if (((UIAttachment)mMessageAttachments.get(i)).getPartId().equalsIgnoreCase(paramString)) {
            return i;
          }
        }
        else {
          return -1;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public UIAttachment getMessageAttachment(String paramString)
  {
    synchronized (mMessageAttachments)
    {
      Iterator localIterator = mMessageAttachments.iterator();
      while (localIterator.hasNext())
      {
        UIAttachment localUIAttachment = (UIAttachment)localIterator.next();
        if (localUIAttachment.getPartId().equalsIgnoreCase(paramString)) {
          return localUIAttachment;
        }
      }
      return null;
    }
  }
  
  public List<UIAttachment> getMessageAttachments()
  {
    synchronized (mMessageAttachments)
    {
      ImmutableList localImmutableList = ImmutableList.copyOf(mMessageAttachments);
      return localImmutableList;
    }
  }
  
  boolean gmailAttachmentDataLoaded()
  {
    if (!mMessageAttachmentsInitialized) {
      return false;
    }
    synchronized (mMessageAttachments)
    {
      Iterator localIterator = mMessageAttachments.iterator();
      while (localIterator.hasNext()) {
        if (((UIAttachment)localIterator.next()).getOriginal() == null) {
          return false;
        }
      }
    }
    return true;
  }
  
  void initializeAttachmentsFromMessage(MailSync.Message paramMessage)
  {
    if (mMessageAttachments.size() > 0)
    {
      LogUtils.e("Gmail", "Attempting to initialize attachment when attachmentshave already been configured", new Object[0]);
      return;
    }
    synchronized (mMessageAttachments)
    {
      paramMessage = attachments.iterator();
      if (paramMessage.hasNext())
      {
        Gmail.Attachment localAttachment = (Gmail.Attachment)paramMessage.next();
        mMessageAttachments.add(localAttachment);
      }
    }
    mMessageAttachmentsInitialized = true;
  }
  
  public void notifyAttachmentChange()
  {
    HashSet localHashSet = Sets.newHashSet();
    Iterator localIterator = getMessageAttachments().iterator();
    while (localIterator.hasNext()) {
      localHashSet.add(((UIAttachment)localIterator.next()).getPartId());
    }
    LogUtils.v("Gmail", "Notifying about attachment change conversation message %d/%d", new Object[] { Long.valueOf(mConversationId), Long.valueOf(mMessageId) });
    UiProvider.notifyMessageAttachmentsChanged(mContext, mAccount, mConversationId, mMessageId, mLocalMessageId, localHashSet);
  }
  
  void populateGmailAttachmentData(MailSync.Message arg1)
  {
    if (!mMessageAttachmentsInitialized) {
      initializeAttachmentsFromMessage(???);
    }
    HashMap localHashMap = Maps.newHashMap();
    ??? = attachments.iterator();
    Object localObject2;
    while (???.hasNext())
    {
      localObject2 = (Gmail.Attachment)???.next();
      localHashMap.put(((Gmail.Attachment)localObject2).getPartId(), localObject2);
    }
    synchronized (mMessageAttachments)
    {
      localObject2 = mMessageAttachments.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        UIAttachment localUIAttachment = (UIAttachment)((Iterator)localObject2).next();
        if (localUIAttachment.getOriginal() == null)
        {
          Gmail.Attachment localAttachment = (Gmail.Attachment)localHashMap.get(localUIAttachment.getPartId());
          if (localAttachment != null) {
            mOriginalAttachment = localAttachment;
          }
        }
      }
    }
  }
  
  public void updateAttachment(AttachmentStatusLoader.Result paramResult)
  {
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      synchronized (mMessageAttachments)
      {
        int i = getMessageAttachmentIndex(paramResult.getPartId());
        if (i != -1)
        {
          localObject1 = (UIAttachment)mMessageAttachments.get(i);
          localObject2 = ((UIAttachment)localObject1).getOriginal();
          if (rendition == Gmail.AttachmentRendition.BEST)
          {
            mOriginalAttachment = ((Gmail.Attachment)localObject2);
            if (((!paramResult.isDownloading()) && (!paramResult.isStatusPending()) && (!paramResult.isStatusPaused()) && (!paramResult.isStatusSuccess()) && (!paramResult.isStatusError()) && (paramResult.isStatusValid())) || ((paramResult.isStatusPending()) && (((UIAttachment)localObject1).isDownloading()))) {
              paramResult.updateState(2, ((UIAttachment)localObject1).getDestination(), null);
            }
            mMessageAttachments.remove(i);
            mMessageAttachments.add(i, paramResult);
            return;
          }
          LogUtils.d("Gmail", "Dropping attachment update, as this is an thumbnail attachment: %s", new Object[] { paramResult });
        }
      }
      if (LogUtils.isLoggable("Gmail", 3))
      {
        localObject1 = Sets.newHashSet();
        localObject2 = mMessageAttachments.iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((Set)localObject1).add(((UIAttachment)((Iterator)localObject2).next()).getPartId());
        }
        LogUtils.d("Gmail", "Got unexpected attachment. messageId: %d partId: %s set: %s", new Object[] { Long.valueOf(mMessageId), paramResult.getPartId(), localObject1 });
      }
      mMessageAttachments.add(paramResult);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.uiprovider.MessageState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */