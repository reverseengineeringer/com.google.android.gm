package com.google.android.gm.provider.uiprovider;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.android.mail.providers.Attachment;
import com.google.android.gm.EmailAddress;
import com.google.android.gm.persistence.Persistence;
import com.google.android.gm.provider.Gmail;
import com.google.android.gm.provider.Gmail.Attachment;
import com.google.android.gm.provider.Gmail.CursorStatus;
import com.google.android.gm.provider.Gmail.MessageModification;
import com.google.android.gm.provider.LogUtils;
import com.google.android.gm.provider.SpamReasonType;
import com.google.android.gm.provider.UiProvider;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;

public class UIMessageCursor
  extends UICursorWapper
{
  private static final Map<String, Integer> GMAIL_STATUS_UI_STATUS_MAP = new ImmutableMap.Builder().put(Gmail.CursorStatus.LOADED.toString(), Integer.valueOf(2)).put(Gmail.CursorStatus.LOADING.toString(), Integer.valueOf(1)).put(Gmail.CursorStatus.SEARCHING.toString(), Integer.valueOf(1)).put(Gmail.CursorStatus.ERROR.toString(), Integer.valueOf(4)).put(Gmail.CursorStatus.COMPLETE.toString(), Integer.valueOf(8)).build();
  private final String mAccount;
  private final List<Gmail.Attachment> mAttachments = Lists.newArrayList();
  private final int mBccIndex;
  private final int mBodyEmbedsExternalResourcesIndex;
  private final int mBodyIndex;
  private final int mCcIndex;
  private final Context mContext;
  private long mConversationId;
  private final int mConversationIdIndex;
  private final int mCustomFromIndex;
  private final int mDateReceivedMsIndex;
  private final Bundle mExtras;
  private final int mForwardIndex;
  private String mFromAddress;
  private final int mFromIndex;
  private final String mGmailQuote;
  private final int mIdIndex;
  private final int mIsDraftIndex;
  private final int mIsInOutboxIndex;
  private final int mIsStarredIndex;
  private final int mIsUnreadIndex;
  private final int mJoinedAttachmentInfosIndex;
  private long mLocalMessageId;
  private String mMessageBody;
  private final Persistence mPersistence;
  private final int mQuoteStartPosIndex;
  private final int mRefMessageIdIndex;
  private final int mReplyToIndex;
  private boolean mRowDataIsCached = false;
  private long mServerMessageId;
  private final int mServerMessageIdIndex;
  private final int mSnippetIndex;
  private int mSpamReason;
  private final int mSubjectIndex;
  private final int mToIndex;
  
  public UIMessageCursor(Context paramContext, Cursor paramCursor, String paramString1, Persistence paramPersistence, String paramString2, String[] paramArrayOfString)
  {
    super(paramCursor, paramArrayOfString);
    mAccount = paramString1;
    mPersistence = paramPersistence;
    mContext = paramContext;
    mGmailQuote = paramString2;
    mIdIndex = paramCursor.getColumnIndexOrThrow("_id");
    mServerMessageIdIndex = paramCursor.getColumnIndexOrThrow("messageId");
    mConversationIdIndex = paramCursor.getColumnIndexOrThrow("conversation");
    mSubjectIndex = paramCursor.getColumnIndexOrThrow("subject");
    mSnippetIndex = paramCursor.getColumnIndexOrThrow("snippet");
    mFromIndex = paramCursor.getColumnIndexOrThrow("fromAddress");
    mCustomFromIndex = paramCursor.getColumnIndexOrThrow("customFromAddress");
    mToIndex = paramCursor.getColumnIndexOrThrow("toAddresses");
    mCcIndex = paramCursor.getColumnIndexOrThrow("ccAddresses");
    mBccIndex = paramCursor.getColumnIndexOrThrow("bccAddresses");
    mReplyToIndex = paramCursor.getColumnIndexOrThrow("replyToAddresses");
    mDateReceivedMsIndex = paramCursor.getColumnIndexOrThrow("dateReceivedMs");
    mBodyIndex = paramCursor.getColumnIndexOrThrow("body");
    mBodyEmbedsExternalResourcesIndex = paramCursor.getColumnIndexOrThrow("bodyEmbedsExternalResources");
    mRefMessageIdIndex = paramCursor.getColumnIndexOrThrow("refMessageId");
    mIsDraftIndex = paramCursor.getColumnIndexOrThrow("isDraft");
    mForwardIndex = paramCursor.getColumnIndexOrThrow("forward");
    mJoinedAttachmentInfosIndex = paramCursor.getColumnIndexOrThrow("joinedAttachmentInfos");
    mIsUnreadIndex = paramCursor.getColumnIndexOrThrow("isUnread");
    mIsStarredIndex = paramCursor.getColumnIndexOrThrow("isStarred");
    mIsInOutboxIndex = paramCursor.getColumnIndexOrThrow("isInOutbox");
    mQuoteStartPosIndex = paramCursor.getColumnIndexOrThrow("quoteStartPos");
    mExtras = getExtrasInternal();
  }
  
  private void cacheRowValues()
  {
    if (!mRowDataIsCached)
    {
      loadAttachmentInfos();
      mServerMessageId = super.getLong(mServerMessageIdIndex);
      mLocalMessageId = super.getLong(mIdIndex);
      mConversationId = super.getLong(mConversationIdIndex);
      mFromAddress = getFromAddress();
      mSpamReason = getSpamReason();
      mRowDataIsCached = true;
    }
  }
  
  private String[] getAddresses(String paramString, int paramInt)
  {
    return TextUtils.split(getStringInColumn(paramInt), Gmail.EMAIL_SEPARATOR_PATTERN);
  }
  
  private int getDraftType()
  {
    int i = 0;
    if (getIsDraft())
    {
      if (getForward()) {
        i = 4;
      }
    }
    else {
      return i;
    }
    if (getRefMessageId() != 0L)
    {
      if (getToAddresses().length + getCcAddresses().length + getBccAddresses().length > 1) {
        return 3;
      }
      return 2;
    }
    return 1;
  }
  
  private static EmailAddress getEmailAddress(String paramString)
  {
    return EmailAddress.getEmailAddress(paramString);
  }
  
  private Bundle getExtrasInternal()
  {
    Object localObject = super.getExtras();
    Bundle localBundle = new Bundle();
    int j = 2;
    int i = j;
    if (((Bundle)localObject).containsKey("status"))
    {
      localObject = ((Bundle)localObject).getString("status");
      i = j;
      if (GMAIL_STATUS_UI_STATUS_MAP.containsKey(localObject)) {
        i = ((Integer)GMAIL_STATUS_UI_STATUS_MAP.get(localObject)).intValue();
      }
    }
    j = i;
    if (i == 2)
    {
      j = i;
      if (getCount() == 0)
      {
        LogUtils.e("Gmail", "Unexpected loaded state for empty cursor", new Object[0]);
        j = 1;
      }
    }
    localBundle.putInt("cursor_status", j);
    return localBundle;
  }
  
  private boolean getForward()
  {
    return super.getLong(mForwardIndex) != 0L;
  }
  
  private static String getGmailAttachmentsAsJson(Collection<Gmail.Attachment> paramCollection, String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    Gmail.Attachment localAttachment = null;
    Object localObject = localAttachment;
    if (paramCollection != null)
    {
      localObject = localAttachment;
      if (!paramCollection.isEmpty()) {
        try
        {
          localObject = new JSONArray();
          paramCollection = paramCollection.iterator();
          while (paramCollection.hasNext())
          {
            localAttachment = (Gmail.Attachment)paramCollection.next();
            Uri localUri = UiProvider.getMessageAttachmentUri(paramString, paramLong1, paramLong2, paramLong3, partId, contentType, localAttachment.toJoinedString());
            ((JSONArray)localObject).put(Attachment.toJSON(name, size, localUri, null, contentType, null));
          }
          localObject = ((JSONArray)localObject).toString();
        }
        catch (JSONException paramCollection)
        {
          throw new IllegalArgumentException(paramCollection);
        }
      }
    }
    return (String)localObject;
  }
  
  private boolean getIsDraft()
  {
    return super.getLong(mIsDraftIndex) != 0L;
  }
  
  private boolean getIsStarred()
  {
    return super.getLong(mIsStarredIndex) != 0L;
  }
  
  private boolean getIsUnread()
  {
    return super.getLong(mIsUnreadIndex) != 0L;
  }
  
  private String getMessageBody()
  {
    if (mMessageBody == null) {
      mMessageBody = super.getString(mBodyIndex);
    }
    return mMessageBody;
  }
  
  private int getQuotedTextOffset()
  {
    int i = getQuoteStartPos();
    if (i <= 0)
    {
      String str = getMessageBody();
      if (TextUtils.isEmpty(str)) {
        return -1;
      }
      return str.indexOf(mGmailQuote);
    }
    return i;
  }
  
  private long getRefMessageId()
  {
    return super.getLong(mRefMessageIdIndex);
  }
  
  private int getSpamReason()
  {
    return -1;
  }
  
  private String getViaDomain()
  {
    return null;
  }
  
  private void loadAttachmentInfos()
  {
    String str = super.getString(mJoinedAttachmentInfosIndex);
    mAttachments.addAll(Gmail.MessageModification.parseJoinedAttachmentString(str));
  }
  
  public String[] getBccAddresses()
  {
    return getAddresses("bccAddresses", mBccIndex);
  }
  
  public String[] getCcAddresses()
  {
    return getAddresses("ccAddresses", mCcIndex);
  }
  
  public Bundle getExtras()
  {
    return mExtras;
  }
  
  public String getFromAddress()
  {
    Object localObject = getStringInColumn(mFromIndex);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      return (String)localObject;
    }
    String str = getStringInColumn(mCustomFromIndex);
    if (!TextUtils.isEmpty(str)) {
      localObject = str;
    }
    for (;;)
    {
      return (String)localObject;
    }
  }
  
  public int getInt(int paramInt)
  {
    int j = 1;
    int k = 0;
    cacheRowValues();
    int i;
    if (mAttachments.size() > 0) {
      i = 1;
    }
    switch (paramInt)
    {
    case 15: 
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    case 23: 
    case 28: 
    case 29: 
    case 30: 
    case 31: 
    case 32: 
    case 35: 
    default: 
      LogUtils.e("Gmail", "UIMessageCursor.getInt(%d): Unexpected column", new Object[] { Integer.valueOf(paramInt) });
      paramInt = super.getInt(paramInt);
    case 14: 
    case 16: 
    case 18: 
    case 25: 
    case 26: 
    case 36: 
    case 24: 
    case 17: 
    case 27: 
    case 33: 
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
                  i = 0;
                  break;
                  return super.getInt(mBodyEmbedsExternalResourcesIndex);
                  return getDraftType();
                  paramInt = j;
                } while (i != 0);
                return 0;
                if (getIsUnread()) {}
                for (paramInt = k;; paramInt = 1) {
                  return paramInt;
                }
                paramInt = j;
              } while (getIsStarred());
              return 0;
              paramInt = j;
            } while (getIsInOutbox());
            return 0;
            localObject = getEmailAddress(mFromAddress).getAddress();
            paramInt = j;
          } while (mPersistence.getDisplayImagesFromSender(mContext, (String)localObject));
          return 0;
          paramInt = j;
        } while (getQuotedTextOffset() >= 0);
        return 0;
        return getQuotedTextOffset();
        if (mSpamReason == -1) {
          return 0;
        }
        paramInt = j;
      } while (!SpamReasonType.HIGH_WARNING_LEVEL_SPAM_TYPES.contains(Integer.valueOf(mSpamReason)));
      return 2;
    }
    Object localObject = (Integer)SpamReasonType.WARNING_LINK_TYPE_MAP.get(Integer.valueOf(mSpamReason));
    if (localObject == null) {
      return 0;
    }
    return ((Integer)localObject).intValue();
  }
  
  public boolean getIsInOutbox()
  {
    return super.getLong(mIsInOutboxIndex) != 0L;
  }
  
  public long getLong(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      LogUtils.e("Gmail", "UIMessageCursor.getLong(%d): Unexpected column", new Object[] { Integer.valueOf(paramInt) });
      return super.getLong(paramInt);
    case 0: 
      return super.getLong(mIdIndex);
    case 11: 
      return super.getLong(mDateReceivedMsIndex);
    }
    return 0L;
  }
  
  public int getQuoteStartPos()
  {
    return super.getInt(mQuoteStartPosIndex);
  }
  
  public String getReplyToAddress()
  {
    String[] arrayOfString = TextUtils.split(getStringInColumn(mReplyToIndex), Gmail.EMAIL_SEPARATOR_PATTERN);
    if ((arrayOfString == null) || (arrayOfString.length == 0)) {
      return null;
    }
    return arrayOfString[0];
  }
  
  public String getString(int paramInt)
  {
    int i = 1;
    Object localObject2 = null;
    cacheRowValues();
    Object localObject1 = localObject2;
    switch (paramInt)
    {
    case 11: 
    case 14: 
    case 16: 
    case 17: 
    case 18: 
    case 20: 
    case 24: 
    case 25: 
    case 26: 
    case 27: 
    case 33: 
    case 34: 
    default: 
      LogUtils.e("Gmail", "UIMessageCursor.getString(%d): Unexpected column", new Object[] { Integer.valueOf(paramInt) });
      localObject1 = super.getString(paramInt);
    case 13: 
    case 30: 
    case 31: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 29: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 12: 
    case 15: 
    case 19: 
    case 21: 
    case 22: 
    case 23: 
    case 28: 
    case 32: 
      Integer localInteger;
      do
      {
        do
        {
          return (String)localObject1;
          return Long.toString(mServerMessageId);
          return UiProvider.getMessageByIdUri(mAccount, mLocalMessageId).toString();
          return UiProvider.getConversationUri(mAccount, mConversationId).toString();
          return super.getString(mSubjectIndex);
          return super.getString(mSnippetIndex);
          return mFromAddress;
          return super.getString(mCustomFromIndex);
          return TextUtils.join(", ", getToAddresses());
          return TextUtils.join(", ", getCcAddresses());
          return TextUtils.join(", ", getBccAddresses());
          return getReplyToAddress();
          return getMessageBody();
          return Long.toString(getRefMessageId());
          if (mAttachments.size() > 0) {}
          for (paramInt = i;; paramInt = 0)
          {
            localObject1 = localObject2;
            if (paramInt == 0) {
              break;
            }
            return UiProvider.getMessageAttachmentsUri(mAccount, mConversationId, mServerMessageId, mLocalMessageId).toString();
          }
          return Gmail.MessageModification.joinedAttachmentsString(mAttachments);
          return UiProvider.getSaveMessageUri(mAccount).toString();
          return UiProvider.getSendMessageUri(mAccount).toString();
          return getGmailAttachmentsAsJson(mAttachments, mAccount, mConversationId, mServerMessageId, mLocalMessageId);
          localInteger = (Integer)SpamReasonType.SPAM_REASON_TO_STRING_MAP.get(Integer.valueOf(mSpamReason));
          localObject1 = localObject2;
        } while (localInteger == null);
        localObject1 = localObject2;
      } while (localInteger.intValue() == 0);
      return mContext.getResources().getString(localInteger.intValue());
    }
    return getViaDomain();
  }
  
  public String[] getToAddresses()
  {
    return getAddresses("toAddresses", mToIndex);
  }
  
  protected void resetCursorRowState()
  {
    super.resetCursorRowState();
    mAttachments.clear();
    mMessageBody = null;
    mRowDataIsCached = false;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.uiprovider.UIMessageCursor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */