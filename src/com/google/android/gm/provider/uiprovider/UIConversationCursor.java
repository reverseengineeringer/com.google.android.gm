package com.google.android.gm.provider.uiprovider;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.android.mail.providers.ConversationInfo;
import com.android.mail.providers.MessageInfo;
import com.google.android.gm.provider.CompactSenderInstructions;
import com.google.android.gm.provider.Gmail.CursorError;
import com.google.android.gm.provider.Gmail.CursorStatus;
import com.google.android.gm.provider.Gmail.PersonalLevel;
import com.google.android.gm.provider.Label;
import com.google.android.gm.provider.LabelManager;
import com.google.android.gm.provider.LogUtils;
import com.google.android.gm.provider.ObjectCache;
import com.google.android.gm.provider.ObjectCache.Callback;
import com.google.android.gm.provider.SenderInstructions;
import com.google.android.gm.provider.SenderInstructions.Sender;
import com.google.android.gm.provider.UiProvider;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class UIConversationCursor
  extends UICursorWapper
{
  private static final ObjectCache<ConversationInfo> CONVERSATION_INFO_CACHE = new ObjectCache(new ObjectCache.Callback()
  {
    public ConversationInfo newInstance()
    {
      return new ConversationInfo();
    }
    
    public void onObjectReleased(ConversationInfo paramAnonymousConversationInfo)
    {
      paramAnonymousConversationInfo.set(0, 0, null, null, null);
    }
  }, 2);
  private static final Map<String, Integer> GMAIL_ERROR_UI_ERROR_MAP;
  private static final Map<String, Integer> GMAIL_STATUS_UI_STATUS_MAP = new ImmutableMap.Builder().put(Gmail.CursorStatus.LOADED.toString(), Integer.valueOf(2)).put(Gmail.CursorStatus.LOADING.toString(), Integer.valueOf(1)).put(Gmail.CursorStatus.SEARCHING.toString(), Integer.valueOf(1)).put(Gmail.CursorStatus.ERROR.toString(), Integer.valueOf(4)).put(Gmail.CursorStatus.COMPLETE.toString(), Integer.valueOf(8)).build();
  private static final ObjectCache<MessageInfo> MESSAGE_INFO_CACHE = new ObjectCache(new ObjectCache.Callback()
  {
    public MessageInfo newInstance()
    {
      return new MessageInfo();
    }
    
    public void onObjectReleased(MessageInfo paramAnonymousMessageInfo)
    {
      paramAnonymousMessageInfo.set(false, false, null, 0);
    }
  }, 10);
  private static final ObjectCache<SenderInstructions> SENDER_INSTRUCTIONS_CACHE;
  private final String mAccount;
  private final Map<Long, Label> mCachedLabels = new HashMap();
  private final int mConversationIdIndex;
  private String mCurrentConversationUri;
  private final Map<String, Label> mCurrentLabels = Maps.newHashMap();
  private final int mDateIndex;
  private final int mFromIndex;
  private final int mHasAttachmentsIndex;
  private final HashMap<String, String[]> mLabelColorMap = Maps.newHashMap();
  private final int mLabelsIndex;
  private final int mNumMessagesIndex;
  private final int mPersonalLevelIndex;
  private boolean mRowDataCached = false;
  private final SparseArray<String> mSerializedFolderMap = new SparseArray();
  private String mSnippet;
  private final int mSnippetIndex;
  private final int mSubjectIndex;
  private final int mSyncedIndex;
  
  static
  {
    GMAIL_ERROR_UI_ERROR_MAP = new ImmutableMap.Builder().put(Gmail.CursorError.AUTH_ERROR.toString(), Integer.valueOf(2)).put(Gmail.CursorError.DB_ERROR.toString(), Integer.valueOf(5)).put(Gmail.CursorError.IO_ERROR.toString(), Integer.valueOf(1)).put(Gmail.CursorError.PARSE_ERROR.toString(), Integer.valueOf(5)).put(Gmail.CursorError.UNKNOWN_ERROR.toString(), Integer.valueOf(5)).build();
    SENDER_INSTRUCTIONS_CACHE = new ObjectCache(new ObjectCache.Callback()
    {
      public SenderInstructions newInstance()
      {
        return new SenderInstructions();
      }
      
      public void onObjectReleased(SenderInstructions paramAnonymousSenderInstructions)
      {
        paramAnonymousSenderInstructions.reset();
      }
    }, 2);
  }
  
  public UIConversationCursor(Cursor paramCursor, String paramString, String[] paramArrayOfString)
  {
    super(paramCursor, paramArrayOfString);
    mAccount = paramString;
    mConversationIdIndex = paramCursor.getColumnIndexOrThrow("_id");
    mSubjectIndex = paramCursor.getColumnIndexOrThrow("subject");
    mSnippetIndex = paramCursor.getColumnIndexOrThrow("snippet");
    mFromIndex = paramCursor.getColumnIndexOrThrow("fromAddress");
    mDateIndex = paramCursor.getColumnIndex("date");
    mPersonalLevelIndex = paramCursor.getColumnIndexOrThrow("personalLevel");
    mNumMessagesIndex = paramCursor.getColumnIndexOrThrow("numMessages");
    mHasAttachmentsIndex = paramCursor.getColumnIndexOrThrow("hasAttachments");
    mLabelsIndex = paramCursor.getColumnIndex("conversationLabels");
    mSyncedIndex = paramCursor.getColumnIndex("synced");
  }
  
  private void cachePositionValues(boolean paramBoolean)
  {
    if ((!mRowDataCached) || (mCurrentConversationUri == null))
    {
      if (mCurrentConversationUri == null) {
        mCurrentConversationUri = UiProvider.getConversationUri(mAccount, getConversationId()).toString();
      }
      if (!paramBoolean)
      {
        loadLabels(mCurrentLabels);
        mSnippet = getSnippet();
        mRowDataCached = true;
      }
    }
  }
  
  private String generateConversationInfo()
  {
    String str = getStringInColumn(mFromIndex);
    int i = super.getInt(mNumMessagesIndex);
    ConversationInfo localConversationInfo = (ConversationInfo)CONVERSATION_INFO_CACHE.get();
    try
    {
      generateConversationInfo(str, i, mSnippet, localConversationInfo, mCurrentLabels.containsKey("^u"));
      str = ConversationInfo.toString(localConversationInfo);
      return str;
    }
    finally
    {
      MessageInfo localMessageInfo;
      Iterator localIterator = messageInfos.iterator();
      while (localIterator.hasNext())
      {
        localMessageInfo = (MessageInfo)localIterator.next();
        MESSAGE_INFO_CACHE.release(localMessageInfo);
      }
      messageInfos.clear();
      CONVERSATION_INFO_CACHE.release(localConversationInfo);
    }
  }
  
  public static void generateConversationInfo(String paramString1, int paramInt, String paramString2, ConversationInfo paramConversationInfo, boolean paramBoolean)
  {
    SenderInstructions localSenderInstructions = (SenderInstructions)SENDER_INSTRUCTIONS_CACHE.get();
    for (;;)
    {
      try
      {
        localSenderInstructions.reset();
        CompactSenderInstructions.parseCompactSenderInstructions(paramString1, localSenderInstructions);
        int i = localSenderInstructions.getNumDrafts();
        paramString1 = localSenderInstructions.getSenders();
        paramConversationInfo.set(paramInt, i, paramString2, paramString2, paramString2);
        paramString1 = paramString1.iterator();
        if (!paramString1.hasNext()) {
          break;
        }
        paramString2 = (SenderInstructions.Sender)paramString1.next();
        MessageInfo localMessageInfo = (MessageInfo)MESSAGE_INFO_CACHE.get();
        if (!paramBoolean) {
          unread = false;
        }
        boolean bool;
        if (!unread)
        {
          bool = true;
          localMessageInfo.set(bool, false, name, priority);
          paramConversationInfo.addMessage(localMessageInfo);
        }
        else
        {
          bool = false;
        }
      }
      finally
      {
        SENDER_INSTRUCTIONS_CACHE.release(localSenderInstructions);
      }
    }
    SENDER_INSTRUCTIONS_CACHE.release(localSenderInstructions);
  }
  
  private long getConversationId()
  {
    return super.getLong(mConversationIdIndex);
  }
  
  private int getConversationPersonalLevel()
  {
    Gmail.PersonalLevel localPersonalLevel = Gmail.PersonalLevel.fromInt(super.getInt(mPersonalLevelIndex));
    if (localPersonalLevel == Gmail.PersonalLevel.NOT_TO_ME) {}
    do
    {
      return 0;
      if (localPersonalLevel == Gmail.PersonalLevel.ONLY_TO_ME) {
        return 2;
      }
    } while (localPersonalLevel != Gmail.PersonalLevel.TO_ME_AND_OTHERS);
    return 1;
  }
  
  private String getRawLabels()
  {
    return super.getString(mLabelsIndex);
  }
  
  private String getSnippet()
  {
    return getStringInColumn(mSnippetIndex);
  }
  
  private String getSubject()
  {
    return getStringInColumn(mSubjectIndex);
  }
  
  private void loadLabels(Map<String, Label> paramMap)
  {
    LabelManager.parseLabelQueryResult(mAccount, getRawLabels(), paramMap, mCachedLabels);
  }
  
  public Bundle getExtras()
  {
    Object localObject2 = super.getExtras();
    Bundle localBundle = new Bundle((Bundle)localObject2);
    Object localObject1 = ((Bundle)localObject2).getString("status");
    localObject2 = ((Bundle)localObject2).getString("error");
    int i = ((Integer)GMAIL_STATUS_UI_STATUS_MAP.get(localObject1)).intValue();
    localObject1 = (Integer)GMAIL_ERROR_UI_ERROR_MAP.get(localObject2);
    localBundle.putInt("cursor_status", i);
    if (localObject1 != null) {
      localBundle.putInt("cursor_error", ((Integer)localObject1).intValue());
    }
    return localBundle;
  }
  
  public int getInt(int paramInt)
  {
    int i = 1;
    int j = 0;
    cachePositionValues(false);
    switch (paramInt)
    {
    case 14: 
    case 21: 
    case 22: 
    case 23: 
    default: 
      LogUtils.e("Gmail", "UIConversationCursor.getInt(%d): Unexpected column", new Object[] { Integer.valueOf(paramInt) });
      paramInt = super.getInt(paramInt);
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return paramInt;
                  return super.getInt(mHasAttachmentsIndex);
                  return super.getInt(mNumMessagesIndex);
                  paramInt = i;
                } while (mCurrentLabels.containsKey("^r"));
                return 0;
                boolean bool1 = mCurrentLabels.containsKey("^^out");
                boolean bool2 = mCurrentLabels.containsKey("^f");
                if (bool1) {
                  return 2;
                }
                if (bool2) {
                  return 3;
                }
                return 0;
                paramInt = i;
              } while (mCurrentLabels.containsKey("^io_im"));
              return 0;
              if (mCurrentLabels.containsKey("^u")) {}
              for (paramInt = j;; paramInt = 1) {
                return paramInt;
              }
              paramInt = i;
            } while (mCurrentLabels.containsKey("^t"));
            return 0;
            paramInt = i;
          } while (mCurrentLabels.containsKey("^s"));
          return 0;
          paramInt = i;
        } while (mCurrentLabels.containsKey("^p"));
        return 0;
        paramInt = i;
      } while (mCurrentLabels.containsKey("^g"));
      return 0;
      return 0;
      return getConversationPersonalLevel();
      return 0;
      paramInt = i;
    } while (super.getInt(mSyncedIndex) == 0);
    return 0;
  }
  
  public long getLong(int paramInt)
  {
    String str = mResultProjection[paramInt];
    if (TextUtils.equals(str, "_id")) {
      return getConversationId();
    }
    if (TextUtils.equals(str, "dateReceivedMs")) {
      return super.getLong(mDateIndex);
    }
    LogUtils.e("Gmail", "UIConversationCursor.getLong(%d): Unexpected column", new Object[] { str });
    return super.getLong(paramInt);
  }
  
  public String getString(int paramInt)
  {
    if (paramInt == 1) {}
    for (boolean bool = true;; bool = false)
    {
      cachePositionValues(bool);
      switch (paramInt)
      {
      default: 
        LogUtils.e("Gmail", "UIConversationCursor.getString(%d): Unexpected column", new Object[] { Integer.valueOf(paramInt) });
        return super.getString(paramInt);
      }
    }
    return mCurrentConversationUri;
    return getSubject();
    return mSnippet;
    return UiProvider.getConversationMessageListUri(mAccount, getConversationId()).toString();
    return null;
    return generateConversationInfo();
    return UiProvider.getSerializedFolderString(mAccount, mCurrentLabels, mSerializedFolderMap, mLabelColorMap);
    return null;
    return UiProvider.getConversationBaseUri(mAccount).toString();
  }
  
  protected void resetCursorRowState()
  {
    super.resetCursorRowState();
    mCurrentLabels.clear();
    mCurrentConversationUri = null;
    mRowDataCached = false;
  }
  
  public Bundle respond(Bundle paramBundle)
  {
    Bundle localBundle1 = new Bundle();
    Bundle localBundle2 = new Bundle();
    String str;
    if (paramBundle.containsKey("allowNetwork"))
    {
      if (paramBundle.getBoolean("allowNetwork"))
      {
        str = "activate";
        localBundle2.putString("command", str);
        if (!"ok".equals(super.respond(localBundle2).getString("commandResponse"))) {
          break label176;
        }
        str = "ok";
        label76:
        localBundle1.putString("allowNetwork", str);
      }
    }
    else if (paramBundle.containsKey("setVisibility"))
    {
      boolean bool = paramBundle.getBoolean("setVisibility");
      if (bool)
      {
        localBundle2.clear();
        localBundle2.putString("command", "setVisible");
        localBundle2.putBoolean("visible", bool);
        if (!"ok".equals(super.respond(localBundle2).getString("commandResponse"))) {
          break label183;
        }
      }
    }
    label176:
    label183:
    for (paramBundle = "ok";; paramBundle = "failed")
    {
      localBundle1.putString("setVisibility", paramBundle);
      return localBundle1;
      str = "deactivate";
      break;
      str = "failed";
      break label76;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.uiprovider.UIConversationCursor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */