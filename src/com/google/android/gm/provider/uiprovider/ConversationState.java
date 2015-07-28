package com.google.android.gm.provider.uiprovider;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Loader;
import android.content.Loader.OnLoadCompleteListener;
import android.database.Cursor;
import android.os.Handler;
import com.google.android.gm.provider.AttachmentStatusLoader;
import com.google.android.gm.provider.AttachmentStatusLoader.Result;
import com.google.android.gm.provider.LogUtils;
import com.google.android.gm.provider.MailEngine;
import com.google.android.gm.provider.MailSync.Message;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public class ConversationState
  implements Loader.OnLoadCompleteListener<List<AttachmentStatusLoader.Result>>
{
  private final String mAccount;
  private AttachmentStatusLoader mAttachmentStatusLoader;
  private final Context mContext;
  private final long mConversationId;
  private final DownloadManager mDownloadManager;
  private final MailEngine mEngine;
  private final Handler mLoaderHandler;
  private final Object mLoaderLock = new Object();
  private final WeakHashMap<Cursor, Object> mMessageAttachmentCursors = new WeakHashMap();
  private final Map<Long, MessageState> mMessageStateMap = Maps.newHashMap();
  
  public ConversationState(Context paramContext, String paramString, long paramLong, Handler paramHandler, MailEngine paramMailEngine)
  {
    mContext = paramContext;
    mDownloadManager = ((DownloadManager)mContext.getSystemService("download"));
    mAccount = paramString;
    mConversationId = paramLong;
    mLoaderHandler = paramHandler;
    mEngine = paramMailEngine;
  }
  
  private MessageState createMessageStateFromMessage(MailSync.Message paramMessage)
  {
    long l = messageId;
    synchronized (mMessageStateMap)
    {
      if (!mMessageStateMap.containsKey(Long.valueOf(l)))
      {
        localMessageState = new MessageState(mContext, mAccount, mConversationId, l, localMessageId);
        mMessageStateMap.put(Long.valueOf(l), localMessageState);
        localMessageState.initializeAttachmentsFromMessage(paramMessage);
        return localMessageState;
      }
      MessageState localMessageState = (MessageState)mMessageStateMap.get(Long.valueOf(l));
    }
  }
  
  public void addAttachmentCursor(Cursor paramCursor)
  {
    synchronized (mMessageAttachmentCursors)
    {
      mMessageAttachmentCursors.put(paramCursor, null);
      return;
    }
  }
  
  public void ensureAttachmentStatusLoaderStarted()
  {
    mLoaderHandler.post(new Runnable()
    {
      public void run()
      {
        synchronized (mLoaderLock)
        {
          if (mAttachmentStatusLoader == null)
          {
            ConversationState.access$102(ConversationState.this, new AttachmentStatusLoader(mContext, mAccount, mConversationId, mDownloadManager));
            mAttachmentStatusLoader.registerListener(0, ConversationState.this);
          }
          if (!mAttachmentStatusLoader.isStarted())
          {
            LogUtils.d("Gmail", "starting attachment loader for conversation %d", new Object[] { Long.valueOf(mConversationId) });
            mAttachmentStatusLoader.startLoading();
          }
          return;
        }
      }
    });
  }
  
  public MessageState getMessageState(long paramLong)
  {
    synchronized (mMessageStateMap)
    {
      MessageState localMessageState = (MessageState)mMessageStateMap.get(Long.valueOf(paramLong));
      return localMessageState;
    }
  }
  
  public MessageState getOrCreateMessageState(long paramLong)
  {
    MessageState localMessageState2 = getMessageState(paramLong);
    MessageState localMessageState1;
    if (localMessageState2 != null)
    {
      localMessageState1 = localMessageState2;
      if (localMessageState2.gmailAttachmentDataLoaded()) {}
    }
    else
    {
      MailSync.Message localMessage = mEngine.getMessage(paramLong, false);
      if (localMessage == null)
      {
        LogUtils.e("Gmail", "Message not found", new Object[0]);
        return null;
      }
      localMessageState1 = localMessageState2;
      if (localMessageState2 == null) {
        localMessageState1 = createMessageStateFromMessage(localMessage);
      }
    }
    return localMessageState1;
  }
  
  public MessageState getOrCreateMessageState(UIAttachment.UriParser paramUriParser)
  {
    MessageState localMessageState = getMessageState(mMessageId);
    MailSync.Message localMessage = mEngine.getLocalMessage(mLocalMessageId, false);
    if (localMessage == null)
    {
      LogUtils.e("Gmail", "Message not found", new Object[0]);
      return null;
    }
    if (localMessageState == null)
    {
      paramUriParser = createMessageStateFromMessage(localMessage);
      ensureAttachmentStatusLoaderStarted();
    }
    for (;;)
    {
      return paramUriParser;
      paramUriParser = localMessageState;
      if (!localMessageState.gmailAttachmentDataLoaded())
      {
        localMessageState.populateGmailAttachmentData(localMessage);
        paramUriParser = localMessageState;
      }
    }
  }
  
  public void handleCursorClose(Cursor arg1)
  {
    int i = 0;
    synchronized (mMessageAttachmentCursors)
    {
      mMessageAttachmentCursors.remove(???);
      if (mMessageAttachmentCursors.size() == 0) {
        i = 1;
      }
      if (i == 0) {}
    }
    synchronized (mLoaderLock)
    {
      if (mAttachmentStatusLoader != null)
      {
        LogUtils.d("Gmail", "attachment cursor closed, and stopping loader", new Object[0]);
        mAttachmentStatusLoader.abandon();
        mAttachmentStatusLoader.stopLoading();
        mAttachmentStatusLoader.reset();
        mAttachmentStatusLoader = null;
      }
      return;
      ??? = finally;
      throw ???;
    }
  }
  
  void notifyAttachmentChanges()
  {
    synchronized (mMessageStateMap)
    {
      Iterator localIterator = mMessageStateMap.values().iterator();
      if (localIterator.hasNext()) {
        ((MessageState)localIterator.next()).notifyAttachmentChange();
      }
    }
  }
  
  public void onLoadComplete(Loader<List<AttachmentStatusLoader.Result>> arg1, List<AttachmentStatusLoader.Result> paramList)
  {
    for (;;)
    {
      AttachmentStatusLoader.Result localResult;
      synchronized (mMessageStateMap)
      {
        LogUtils.d("Gmail", "onLoadComplete called on loader for conversation %d", new Object[] { Long.valueOf(mConversationId) });
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break;
        }
        localResult = (AttachmentStatusLoader.Result)paramList.next();
        MessageState localMessageState = getOrCreateMessageState(messageId);
        if (localMessageState != null) {
          localMessageState.updateAttachment(localResult);
        }
      }
      LogUtils.e("Gmail", "failed to find Message state for message id: %d", new Object[] { Long.valueOf(messageId) });
    }
    notifyAttachmentChanges();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.uiprovider.ConversationState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */