package com.google.android.gm.provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Handler;
import android.text.TextUtils;
import android.text.TextUtils.StringSplitter;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Set;

public class Gmail$MessageCursor
  extends Gmail.MailCursor
{
  private int mBccIndex;
  private int mBodyEmbedsExternalResourcesIndex;
  private int mBodyIndex;
  private int mCcIndex;
  private final ContentResolver mContentResolver;
  private int mConversationIdIndex;
  private boolean mCursorCloned = false;
  private int mCustomFromIndex;
  private int mDateReceivedMsIndex;
  private int mDateSentMsIndex;
  private int mErrorIndex;
  private int mForwardIndex;
  private int mFromIndex;
  private int mIdIndex;
  long mInReplyToLocalMessageId;
  private int mIncludeQuotedTextIndex;
  private int mIsDraftIndex;
  private int mIsInOutboxIndex;
  private int mIsStarredIndex;
  private int mIsUnreadIndex;
  private int mJoinedAttachmentInfosIndex;
  private int mLabelCountIndex;
  private int mLabelIdsIndex;
  private final TextUtils.StringSplitter mLabelIdsSplitter = Gmail.newMessageLabelIdsSplitter();
  private int mLabelsIndex;
  private int mListInfoIndex;
  private int mPersonalLevelIndex;
  boolean mPreserveAttachments;
  private int mQuoteStartPosIndex;
  private int mRefMessageIdIndex;
  private int mReplyToIndex;
  private int mServerMessageIdIndex;
  private int mSnippetIndex;
  private int mSubjectIndex;
  private int mToIndex;
  
  static
  {
    if (!Gmail.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private Gmail$MessageCursor(ContentResolver paramContentResolver, String paramString, Cursor paramCursor)
  {
    this(new Handler(), paramContentResolver, paramString, paramCursor);
  }
  
  public Gmail$MessageCursor(Handler paramHandler, ContentResolver paramContentResolver, String paramString, Cursor paramCursor)
  {
    super(paramHandler, paramString, paramCursor);
    if (paramCursor == null) {
      throw new IllegalArgumentException("null cursor passed to MessageCursor()");
    }
    mContentResolver = paramContentResolver;
    mIdIndex = mCursor.getColumnIndexOrThrow("_id");
    mServerMessageIdIndex = mCursor.getColumnIndexOrThrow("messageId");
    mConversationIdIndex = mCursor.getColumnIndexOrThrow("conversation");
    mSubjectIndex = mCursor.getColumnIndexOrThrow("subject");
    mSnippetIndex = mCursor.getColumnIndexOrThrow("snippet");
    mFromIndex = mCursor.getColumnIndexOrThrow("fromAddress");
    mCustomFromIndex = mCursor.getColumnIndexOrThrow("customFromAddress");
    mToIndex = mCursor.getColumnIndexOrThrow("toAddresses");
    mCcIndex = mCursor.getColumnIndexOrThrow("ccAddresses");
    mBccIndex = mCursor.getColumnIndexOrThrow("bccAddresses");
    mReplyToIndex = mCursor.getColumnIndexOrThrow("replyToAddresses");
    mDateSentMsIndex = mCursor.getColumnIndexOrThrow("dateSentMs");
    mDateReceivedMsIndex = mCursor.getColumnIndexOrThrow("dateReceivedMs");
    mListInfoIndex = mCursor.getColumnIndexOrThrow("listInfo");
    mPersonalLevelIndex = mCursor.getColumnIndexOrThrow("personalLevel");
    mBodyIndex = mCursor.getColumnIndexOrThrow("body");
    mBodyEmbedsExternalResourcesIndex = mCursor.getColumnIndexOrThrow("bodyEmbedsExternalResources");
    mLabelIdsIndex = mCursor.getColumnIndexOrThrow("labelIds");
    mJoinedAttachmentInfosIndex = mCursor.getColumnIndexOrThrow("joinedAttachmentInfos");
    mErrorIndex = mCursor.getColumnIndexOrThrow("error");
    mRefMessageIdIndex = mCursor.getColumnIndexOrThrow("refMessageId");
    mForwardIndex = mCursor.getColumnIndexOrThrow("forward");
    mIncludeQuotedTextIndex = mCursor.getColumnIndexOrThrow("includeQuotedText");
    mQuoteStartPosIndex = mCursor.getColumnIndexOrThrow("quoteStartPos");
    mLabelCountIndex = mCursor.getColumnIndexOrThrow("labelCount");
    mLabelsIndex = mCursor.getColumnIndexOrThrow("messageLabels");
    mIsStarredIndex = mCursor.getColumnIndexOrThrow("isStarred");
    mIsDraftIndex = mCursor.getColumnIndexOrThrow("isDraft");
    mIsInOutboxIndex = mCursor.getColumnIndexOrThrow("isInOutbox");
    mIsUnreadIndex = mCursor.getColumnIndexOrThrow("isUnread");
    mInReplyToLocalMessageId = 0L;
    mPreserveAttachments = false;
  }
  
  private String[] getAddresses(String paramString, int paramInt)
  {
    if (getUpdateValues().containsKey(paramString)) {}
    for (paramString = (String)getUpdateValues().get(paramString);; paramString = getStringInColumn(paramInt)) {
      return TextUtils.split(paramString, Gmail.EMAIL_SEPARATOR_PATTERN);
    }
  }
  
  public void addOrRemoveLabel(String paramString, boolean paramBoolean)
  {
    Gmail.addOrRemoveLabelOnMessage(mContentResolver, mAccount, getConversationId(), getLocalId(), paramString, paramBoolean);
  }
  
  public Object clone()
  {
    if (mCursor == null) {
      return new MessageCursor(new Handler(), mContentResolver, mAccount, null);
    }
    Object localObject = new MatrixCursor(mCursor.getColumnNames(), mCursor.getCount());
    mCursor.moveToPosition(-1);
    int i = mCursor.getColumnCount();
    while (mCursor.moveToNext())
    {
      Object[] arrayOfObject = new Object[i];
      arrayOfObject[mIdIndex] = Long.valueOf(mCursor.getLong(mIdIndex));
      arrayOfObject[mServerMessageIdIndex] = Long.valueOf(mCursor.getLong(mServerMessageIdIndex));
      arrayOfObject[mConversationIdIndex] = Long.valueOf(mCursor.getLong(mConversationIdIndex));
      arrayOfObject[mSubjectIndex] = mCursor.getString(mSubjectIndex);
      arrayOfObject[mSnippetIndex] = mCursor.getString(mSnippetIndex);
      arrayOfObject[mFromIndex] = mCursor.getString(mFromIndex);
      arrayOfObject[mCustomFromIndex] = mCursor.getString(mCustomFromIndex);
      arrayOfObject[mToIndex] = mCursor.getString(mToIndex);
      arrayOfObject[mCcIndex] = mCursor.getString(mCcIndex);
      arrayOfObject[mBccIndex] = mCursor.getString(mBccIndex);
      arrayOfObject[mReplyToIndex] = mCursor.getString(mReplyToIndex);
      arrayOfObject[mDateSentMsIndex] = Long.valueOf(mCursor.getLong(mDateSentMsIndex));
      arrayOfObject[mDateReceivedMsIndex] = Long.valueOf(mCursor.getLong(mDateSentMsIndex));
      arrayOfObject[mListInfoIndex] = mCursor.getString(mListInfoIndex);
      arrayOfObject[mPersonalLevelIndex] = Integer.valueOf(mCursor.getInt(mPersonalLevelIndex));
      arrayOfObject[mBodyIndex] = mCursor.getString(mBodyIndex);
      arrayOfObject[mBodyEmbedsExternalResourcesIndex] = Integer.valueOf(mCursor.getInt(mBodyEmbedsExternalResourcesIndex));
      arrayOfObject[mLabelIdsIndex] = mCursor.getString(mLabelIdsIndex);
      arrayOfObject[mJoinedAttachmentInfosIndex] = mCursor.getString(mJoinedAttachmentInfosIndex);
      arrayOfObject[mErrorIndex] = mCursor.getString(mErrorIndex);
      arrayOfObject[mRefMessageIdIndex] = Long.valueOf(mCursor.getLong(mRefMessageIdIndex));
      arrayOfObject[mForwardIndex] = Long.valueOf(mCursor.getLong(mForwardIndex));
      arrayOfObject[mLabelCountIndex] = Integer.valueOf(mCursor.getInt(mLabelCountIndex));
      arrayOfObject[mLabelsIndex] = mCursor.getString(mLabelsIndex);
      arrayOfObject[mIsStarredIndex] = Long.valueOf(mCursor.getLong(mIsStarredIndex));
      arrayOfObject[mIsDraftIndex] = Long.valueOf(mCursor.getLong(mIsDraftIndex));
      arrayOfObject[mIsInOutboxIndex] = Long.valueOf(mCursor.getLong(mIsInOutboxIndex));
      arrayOfObject[mIsUnreadIndex] = Long.valueOf(mCursor.getLong(mIsUnreadIndex));
      arrayOfObject[mIncludeQuotedTextIndex] = Long.valueOf(mCursor.getLong(mIncludeQuotedTextIndex));
      arrayOfObject[mQuoteStartPosIndex] = Integer.valueOf(mCursor.getInt(mQuoteStartPosIndex));
      ((MatrixCursor)localObject).addRow(arrayOfObject);
    }
    localObject = new MessageCursor(new Handler(), mContentResolver, mAccount, (Cursor)localObject);
    mCursorCloned = true;
    return localObject;
  }
  
  public ArrayList<Gmail.Attachment> getAttachmentInfos()
  {
    ArrayList localArrayList = Lists.newArrayList();
    localArrayList.addAll(Gmail.MessageModification.parseJoinedAttachmentString(mCursor.getString(mJoinedAttachmentInfosIndex)));
    return localArrayList;
  }
  
  public String[] getBccAddresses()
  {
    return getAddresses("bccAddresses", mBccIndex);
  }
  
  public String getBody()
  {
    return getStringInColumn(mBodyIndex);
  }
  
  public String[] getCcAddresses()
  {
    return getAddresses("ccAddresses", mCcIndex);
  }
  
  public long getConversationId()
  {
    checkCursor();
    return mCursor.getLong(mConversationIdIndex);
  }
  
  public long getDateSentMs()
  {
    checkCursor();
    return mCursor.getLong(mDateSentMsIndex);
  }
  
  public String getErrorText()
  {
    return mCursor.getString(mErrorIndex);
  }
  
  public String getFromAddress()
  {
    String str1 = getStringInColumn(mCustomFromIndex);
    String str2 = getStringInColumn(mFromIndex);
    if ((!TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str2))) {
      return str1;
    }
    return getStringInColumn(mFromIndex);
  }
  
  public boolean getIsUnread()
  {
    return mCursor.getLong(mIsUnreadIndex) != 0L;
  }
  
  public Set<Long> getLabelIds()
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
  
  public String getListInfo()
  {
    return getStringInColumn(mListInfoIndex);
  }
  
  public long getLocalId()
  {
    checkCursor();
    return mCursor.getLong(mIdIndex);
  }
  
  public Gmail.PersonalLevel getPersonalLevel()
  {
    checkCursor();
    return Gmail.PersonalLevel.fromInt(mCursor.getInt(mPersonalLevelIndex));
  }
  
  public String[] getReplyToAddress()
  {
    return TextUtils.split(getStringInColumn(mReplyToIndex), Gmail.EMAIL_SEPARATOR_PATTERN);
  }
  
  public String getSubject()
  {
    return getStringInColumn(mSubjectIndex);
  }
  
  public String[] getToAddresses()
  {
    return getAddresses("toAddresses", mToIndex);
  }
  
  protected void onCursorPositionChanged()
  {
    super.onCursorPositionChanged();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.Gmail.MessageCursor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */