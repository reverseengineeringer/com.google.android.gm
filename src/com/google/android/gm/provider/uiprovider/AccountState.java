package com.google.android.gm.provider.uiprovider;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Handler;
import android.util.LruCache;
import com.google.android.gm.provider.MailEngine;
import com.google.common.collect.Maps;
import java.lang.ref.WeakReference;
import java.util.Map;

public class AccountState
{
  private final String mAccount;
  private final LruCache<String, WeakReference<UIConversationCursor>> mConversationCursorMap = new LruCache(3);
  private final Map<Long, ConversationState> mConversationStateMap = Maps.newHashMap();
  private final MailEngine mEngine;
  private final Handler mLoaderHandler;
  private final Map<String, Integer> mSearchInfo = Maps.newHashMap();
  
  public AccountState(String paramString, Handler paramHandler, MailEngine paramMailEngine)
  {
    mAccount = paramString;
    mLoaderHandler = paramHandler;
    mEngine = paramMailEngine;
  }
  
  private static String generateConversationCursorKey(Uri paramUri)
  {
    return paramUri.buildUpon().clearQuery().build().toString();
  }
  
  private void updateSearchInfoMapForQuery(String paramString)
  {
    if (!mSearchInfo.containsKey(paramString))
    {
      mSearchInfo.clear();
      mSearchInfo.put(paramString, Integer.valueOf(0));
    }
  }
  
  public void cacheConversationCursor(Uri paramUri, UIConversationCursor paramUIConversationCursor)
  {
    paramUri = generateConversationCursorKey(paramUri);
    mConversationCursorMap.put(paramUri, new WeakReference(paramUIConversationCursor));
  }
  
  public UIConversationCursor getConversationCursor(Uri paramUri)
  {
    paramUri = generateConversationCursorKey(paramUri);
    paramUri = (WeakReference)mConversationCursorMap.get(paramUri);
    if (paramUri != null) {
      return (UIConversationCursor)paramUri.get();
    }
    return null;
  }
  
  public ConversationState getConversationState(long paramLong)
  {
    synchronized (mConversationStateMap)
    {
      ConversationState localConversationState = (ConversationState)mConversationStateMap.get(Long.valueOf(paramLong));
      return localConversationState;
    }
  }
  
  public int getNumSearchResults(String paramString)
  {
    updateSearchInfoMapForQuery(paramString);
    return ((Integer)mSearchInfo.get(paramString)).intValue();
  }
  
  public ConversationState getOrCreateConversationState(Context paramContext, long paramLong)
  {
    synchronized (mConversationStateMap)
    {
      if (mConversationStateMap.containsKey(Long.valueOf(paramLong)))
      {
        paramContext = (ConversationState)mConversationStateMap.get(Long.valueOf(paramLong));
        return paramContext;
      }
      paramContext = new ConversationState(paramContext, mAccount, paramLong, mLoaderHandler, mEngine);
      mConversationStateMap.put(Long.valueOf(paramLong), paramContext);
    }
  }
  
  public void notifyAttachmentChange(long paramLong)
  {
    synchronized (mConversationStateMap)
    {
      ConversationState localConversationState = (ConversationState)mConversationStateMap.get(Long.valueOf(paramLong));
      if (localConversationState != null) {
        localConversationState.notifyAttachmentChanges();
      }
      return;
    }
  }
  
  public void setNumSearchResults(String paramString, int paramInt)
  {
    updateSearchInfoMapForQuery(paramString);
    mSearchInfo.put(paramString, Integer.valueOf(paramInt));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.uiprovider.AccountState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */