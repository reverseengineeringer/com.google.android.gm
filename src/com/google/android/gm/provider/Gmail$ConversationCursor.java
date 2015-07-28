package com.google.android.gm.provider;

import android.database.Cursor;
import android.os.Handler;
import android.text.TextUtils.StringSplitter;
import android.util.LruCache;
import java.util.Map;
import java.util.Set;

public class Gmail$ConversationCursor
  extends Gmail.MailCursor
{
  private final int mConversationIdIndex = mCursor.getColumnIndexOrThrow("_id");
  private final int mDateIndex = mCursor.getColumnIndex("date");
  private final int mForceAllUnreadIndex = mCursor.getColumnIndexOrThrow("forceAllUnread");
  private final int mFromIndex = mCursor.getColumnIndexOrThrow("fromAddress");
  private final int mHasAttachmentsIndex = mCursor.getColumnIndexOrThrow("hasAttachments");
  private final int mHasMessagesWithErrorsIndex = mCursor.getColumnIndexOrThrow("hasMessagesWithErrors");
  private final int mLabelIdsIndex = mCursor.getColumnIndex("labelIds");
  private final TextUtils.StringSplitter mLabelIdsSplitter = Gmail.newConversationLabelIdsSplitter();
  private final int mLabelsIndex = mCursor.getColumnIndex("conversationLabels");
  private final int mMaxMessageIdIndex = mCursor.getColumnIndexOrThrow("maxMessageId");
  private final int mNumMessagesIndex = mCursor.getColumnIndexOrThrow("numMessages");
  private final LruCache<Long, Map<String, Label>> mParsedLabels = new LruCache(50);
  private final int mPersonalLevelIndex = mCursor.getColumnIndexOrThrow("personalLevel");
  private final int mSnippetIndex = mCursor.getColumnIndexOrThrow("snippet");
  private final int mSubjectIndex = mCursor.getColumnIndexOrThrow("subject");
  private final int mSyncedIndex = mCursor.getColumnIndex("synced");
  
  static
  {
    if (!Gmail.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private Gmail$ConversationCursor(Handler paramHandler, Gmail paramGmail, String paramString, Cursor paramCursor)
  {
    super(paramHandler, paramString, paramCursor);
  }
  
  private Gmail$ConversationCursor(Gmail paramGmail, String paramString, Cursor paramCursor)
  {
    this(new Handler(), paramGmail, paramString, paramCursor);
  }
  
  public long getConversationId()
  {
    return mCursor.getLong(mConversationIdIndex);
  }
  
  public long getDateMs()
  {
    if (mDateIndex > -1) {
      return mCursor.getLong(mDateIndex);
    }
    return 0L;
  }
  
  public boolean getForceAllUnread()
  {
    return (!mCursor.isNull(mForceAllUnreadIndex)) && (mCursor.getInt(mForceAllUnreadIndex) != 0);
  }
  
  public String getFromSnippetInstructions()
  {
    return getStringInColumn(mFromIndex);
  }
  
  public boolean getHasDraftMessage()
  {
    String str = getRawLabels();
    if (str != null) {
      return str.contains("^*^^r^*^");
    }
    return false;
  }
  
  public boolean getHasUnreadMessage()
  {
    String str = getRawLabels();
    if (str != null) {
      return str.contains("^*^^u^*^");
    }
    return false;
  }
  
  public Set<Long> getLabelIds()
  {
    if (mLabelIdsIndex != -1)
    {
      String str2 = mCursor.getString(mLabelIdsIndex);
      TextUtils.StringSplitter localStringSplitter = mLabelIdsSplitter;
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localStringSplitter.setString(str1);
      return Gmail.getLabelIdsFromLabelIdsString(mLabelIdsSplitter);
    }
    return Gmail.getLabelIdsFromLabelMap(getLabels());
  }
  
  public Map<String, Label> getLabels()
  {
    long l = getConversationId();
    synchronized (mParsedLabels)
    {
      Map localMap2 = (Map)mParsedLabels.get(Long.valueOf(getConversationId()));
      Map localMap1 = localMap2;
      if (localMap2 == null)
      {
        localMap1 = LabelManager.parseLabelQueryResult(mAccount, getRawLabels());
        mParsedLabels.put(Long.valueOf(l), localMap1);
      }
      return localMap1;
    }
  }
  
  MailEngine.ConversationCursorLogic getLogic()
  {
    return (MailEngine.ConversationCursorLogic)mCursor).mLogic;
  }
  
  public long getMaxServerMessageId()
  {
    return mCursor.getLong(mMaxMessageIdIndex);
  }
  
  public int getNumMessages()
  {
    return mCursor.getInt(mNumMessagesIndex);
  }
  
  public Gmail.PersonalLevel getPersonalLevel()
  {
    return Gmail.PersonalLevel.fromInt(mCursor.getInt(mPersonalLevelIndex));
  }
  
  public String getRawLabels()
  {
    if (mLabelsIndex > -1) {
      return mCursor.getString(mLabelsIndex);
    }
    return "";
  }
  
  public String getSnippet()
  {
    return getStringInColumn(mSnippetIndex);
  }
  
  public String getSubject()
  {
    return getStringInColumn(mSubjectIndex);
  }
  
  public boolean hasAttachments()
  {
    return mCursor.getInt(mHasAttachmentsIndex) != 0;
  }
  
  public boolean isSynced()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (mSyncedIndex > -1)
    {
      bool1 = bool2;
      if (mCursor.getInt(mSyncedIndex) != 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  protected void onCursorPositionChanged()
  {
    super.onCursorPositionChanged();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.Gmail.ConversationCursor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */