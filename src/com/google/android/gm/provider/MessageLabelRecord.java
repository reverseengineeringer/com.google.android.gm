package com.google.android.gm.provider;

import android.text.TextUtils;

class MessageLabelRecord
{
  private final Long mDateReceived;
  private final String mJoinedLabelIds;
  private final long mMessageId;
  
  public MessageLabelRecord(String paramString, long paramLong1, long paramLong2)
  {
    mJoinedLabelIds = paramString;
    mMessageId = paramLong1;
    mDateReceived = Long.valueOf(paramLong2);
  }
  
  public MessageLabelRecord(String paramString, Long paramLong)
  {
    mJoinedLabelIds = paramString;
    mMessageId = paramLong.longValue();
    mDateReceived = null;
  }
  
  Long getDateReceived()
  {
    return mDateReceived;
  }
  
  String[] getLabelIds()
  {
    if (mJoinedLabelIds != null) {
      return TextUtils.split(mJoinedLabelIds, Gmail.COMMA_SEPARATOR_PATTERN);
    }
    return new String[0];
  }
  
  long getMessageId()
  {
    return mMessageId;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MessageLabelRecord
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */