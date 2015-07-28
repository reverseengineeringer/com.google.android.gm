package com.google.android.gm.provider.uiprovider;

import android.database.Cursor;
import android.net.Uri;
import com.google.android.gm.provider.Gmail;
import com.google.android.gm.provider.Label;
import com.google.android.gm.provider.LogUtils;
import com.google.android.gm.provider.MailEngine;
import com.google.android.gm.provider.UiProvider;
import com.google.common.collect.ImmutableSet;
import java.util.Set;

public class UILabelCursor
  extends UICursorWapper
{
  private static final Set<String> ALLOW_MARK_NOT_SPAM_LABELS = HIDDEN_REPORT_SPAM_LABELS;
  private static final Set<String> ARCHIVABLE_LABELS = ImmutableSet.of("^i", "^iim");
  private static final Set<String> DELETE_PROHIBITED_LABELS = ImmutableSet.of("^k", "^r");
  private static final Set<String> DESTRUCTIVE_MUTE_LABELS = ImmutableSet.of("^i", "^iim");
  private static final Set<String> HIDDEN_REPORT_PHISHING_LABELS = ImmutableSet.of("^s");
  private static final Set<String> HIDDEN_REPORT_SPAM_LABELS = ImmutableSet.of("^s");
  private final String mAccount;
  private String mCanonicalName;
  private final int mCanonicalNameIndex;
  private Uri mConversationListUri;
  private final MailEngine mEngine;
  private String mGmailLabelColor;
  private final int mGmailLabelColorIndex;
  private final int mIdColumnIndex;
  private final int mNameColumnIndex;
  private final int mNumConversationsIndex;
  private final int mNumUnreadConversationsIndex;
  private final Set<String> mSynchronizedLabelSet;
  private final int mSystemLabelIndex;
  
  public UILabelCursor(Cursor paramCursor, MailEngine paramMailEngine, String paramString, String[] paramArrayOfString)
  {
    super(paramCursor, paramArrayOfString);
    mAccount = paramString;
    mEngine = paramMailEngine;
    if (mEngine != null) {}
    for (paramMailEngine = ImmutableSet.copyOf(mEngine.getSynchronizedLabelSet());; paramMailEngine = null)
    {
      mSynchronizedLabelSet = paramMailEngine;
      mIdColumnIndex = paramCursor.getColumnIndex("_id");
      mNameColumnIndex = paramCursor.getColumnIndex("name");
      mCanonicalNameIndex = paramCursor.getColumnIndex("canonicalName");
      mNumConversationsIndex = paramCursor.getColumnIndex("numConversations");
      mNumUnreadConversationsIndex = paramCursor.getColumnIndex("numUnreadConversations");
      mSystemLabelIndex = paramCursor.getColumnIndex("systemLabel");
      mGmailLabelColorIndex = paramCursor.getColumnIndex("color");
      return;
    }
  }
  
  private void cachePositionValues()
  {
    int i;
    if (mCanonicalName == null)
    {
      mCanonicalName = super.getString(mCanonicalNameIndex);
      i = super.getInt(mIdColumnIndex);
      if (mEngine == null) {
        break label60;
      }
    }
    label60:
    for (mConversationListUri = UiProvider.getLabelConversationListUri(mAccount, i);; mConversationListUri = UiProvider.getLabelConversationListFromNameUri(mAccount, mCanonicalName))
    {
      mGmailLabelColor = super.getString(mGmailLabelColorIndex);
      return;
    }
  }
  
  public int getInt(int paramInt)
  {
    int j = 1;
    int i = 0;
    cachePositionValues();
    switch (paramInt)
    {
    case 1: 
    case 2: 
    case 6: 
    case 7: 
    case 10: 
    default: 
      LogUtils.e("Gmail", "UILabelCursor.getInt(%d): Unexpected column", new Object[] { Integer.valueOf(paramInt) });
      i = super.getInt(paramInt);
    case 3: 
      return i;
    case 0: 
      return mCanonicalName.hashCode();
    case 8: 
      return super.getInt(mNumUnreadConversationsIndex);
    case 9: 
      return super.getInt(mNumConversationsIndex);
    case 4: 
      i = 517;
      if (ARCHIVABLE_LABELS.contains(mCanonicalName)) {
        i = 0x205 | 0x10;
      }
      paramInt = i;
      if (!DELETE_PROHIBITED_LABELS.contains(mCanonicalName)) {
        paramInt = i | 0x20;
      }
      i = paramInt;
      if (!HIDDEN_REPORT_SPAM_LABELS.contains(mCanonicalName)) {
        i = paramInt | 0x40;
      }
      paramInt = i;
      if (ALLOW_MARK_NOT_SPAM_LABELS.contains(mCanonicalName)) {
        paramInt = i | 0x80;
      }
      i = paramInt;
      if (!HIDDEN_REPORT_PHISHING_LABELS.contains(mCanonicalName)) {
        i = paramInt | 0x2000;
      }
      paramInt = i;
      if (DESTRUCTIVE_MUTE_LABELS.contains(mCanonicalName)) {
        paramInt = i | 0x100;
      }
      i = paramInt;
      if (Gmail.isLabelUserSettable(mCanonicalName)) {
        i = paramInt | 0x8;
      }
      if (!"^im".equals(mCanonicalName))
      {
        paramInt = i;
        if (!"^iim".equals(mCanonicalName)) {}
      }
      else
      {
        paramInt = i | 0x400;
      }
      return paramInt;
    case 5: 
      if ((mSynchronizedLabelSet != null) && (mSynchronizedLabelSet.contains(mCanonicalName)))
      {
        paramInt = 1;
        if (paramInt == 0) {
          break label361;
        }
      }
      for (paramInt = j;; paramInt = 0)
      {
        return paramInt;
        paramInt = 0;
        break;
      }
    case 11: 
      i = 0;
      paramInt = 0;
      if (mEngine != null)
      {
        i = paramInt;
        if (mEngine.isBackgroundSyncInProgress()) {
          i = 0x0 | 0x4;
        }
        paramInt = i;
        if (mEngine.isLiveQueryInProgress()) {
          paramInt = i | 0x2;
        }
        i = paramInt;
        if (mEngine.isHandlingUserRefresh()) {
          i = paramInt | 0x1;
        }
      }
      return i;
    case 12: 
      label361:
      if (mEngine != null) {}
      for (paramInt = mEngine.getLastSyncResult();; paramInt = 0) {
        return paramInt;
      }
    }
    if (super.getInt(mSystemLabelIndex) != 0) {}
    for (boolean bool = true;; bool = false) {
      return UiProvider.getFolderType(bool, mCanonicalName);
    }
  }
  
  public long getLong(int paramInt)
  {
    cachePositionValues();
    switch (paramInt)
    {
    default: 
      LogUtils.e("Gmail", "UILabelCursor.getLong(%d): Unexpected column", new Object[] { Integer.valueOf(paramInt) });
      return super.getLong(paramInt);
    case 0: 
      return mCanonicalName.hashCode();
    }
    return 0L;
  }
  
  public String getString(int paramInt)
  {
    String str = null;
    cachePositionValues();
    switch (paramInt)
    {
    case 3: 
    case 4: 
    case 5: 
    case 8: 
    case 9: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    default: 
      LogUtils.e("Gmail", "UILabelCursor.getString(%d): Unexpected column", new Object[] { Integer.valueOf(paramInt) });
      str = super.getString(paramInt);
    case 7: 
    case 17: 
    case 18: 
      return str;
    case 1: 
      return UiProvider.getAccountLabelUri(mAccount, mCanonicalName).toString();
    case 2: 
      return super.getString(mNameColumnIndex);
    case 6: 
      return mConversationListUri.toString();
    case 10: 
      return UiProvider.getLabelRefreshUri(mAccount, mConversationListUri).toString();
    case 15: 
      return Label.getBackgroundColor(mAccount, mCanonicalName, mGmailLabelColor) + "";
    }
    return Label.getTextColor(mAccount, mCanonicalName, mGmailLabelColor) + "";
  }
  
  protected void resetCursorRowState()
  {
    super.resetCursorRowState();
    mCanonicalName = null;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.uiprovider.UILabelCursor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */