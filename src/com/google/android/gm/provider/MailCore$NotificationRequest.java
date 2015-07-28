package com.google.android.gm.provider;

import java.util.Iterator;
import java.util.Set;

public final class MailCore$NotificationRequest
{
  private final long mLabelId;
  private final Set<Long> mRequiredAbsentLabelIds;
  private final Set<Long> mRequiredPresentLabelIds;
  private final long mTagLabelId;
  
  public MailCore$NotificationRequest(long paramLong1, long paramLong2, Set<Long> paramSet1, Set<Long> paramSet2)
  {
    mLabelId = paramLong1;
    mTagLabelId = paramLong2;
    mRequiredPresentLabelIds = paramSet1;
    mRequiredAbsentLabelIds = paramSet2;
  }
  
  public final boolean conversationMatches(Set<Long> paramSet)
  {
    if (!paramSet.containsAll(mRequiredPresentLabelIds)) {
      return false;
    }
    Iterator localIterator = mRequiredAbsentLabelIds.iterator();
    while (localIterator.hasNext()) {
      if (paramSet.contains((Long)localIterator.next())) {
        return false;
      }
    }
    return true;
  }
  
  public final long getLabelId()
  {
    return mLabelId;
  }
  
  public final long getTagLabelId()
  {
    return mTagLabelId;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailCore.NotificationRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */