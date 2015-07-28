package com.android.mail.compose;

import android.content.ContentValues;
import com.android.mail.providers.ReplyFromAccount;

public class ComposeActivity$SendOrSaveMessage
{
  final ReplyFromAccount mAccount;
  final String mRefMessageId;
  final int mRequestId;
  public final boolean mSave;
  final ContentValues mValues;
  
  public ComposeActivity$SendOrSaveMessage(ReplyFromAccount paramReplyFromAccount, ContentValues paramContentValues, String paramString, boolean paramBoolean)
  {
    mAccount = paramReplyFromAccount;
    mValues = paramContentValues;
    mRefMessageId = paramString;
    mSave = paramBoolean;
    mRequestId = (mValues.hashCode() ^ hashCode());
  }
  
  int requestId()
  {
    return mRequestId;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.compose.ComposeActivity.SendOrSaveMessage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */