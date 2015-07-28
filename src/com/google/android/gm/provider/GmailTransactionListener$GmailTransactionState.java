package com.google.android.gm.provider;

import com.google.common.collect.Sets;
import java.util.Set;
import java.util.Stack;

class GmailTransactionListener$GmailTransactionState
{
  public final Set<Long> mConversationIds = Sets.newHashSet();
  public final Set<Long> mLabelIds = Sets.newHashSet();
  public boolean mScheduleSyncOnAccountNotification = false;
  public boolean mSendGmailAccountNotifications = false;
  private final Stack<Throwable> mStackTraces = (Stack)null;
  
  public GmailTransactionListener$GmailTransactionState(GmailTransactionListener paramGmailTransactionListener) {}
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.GmailTransactionListener.GmailTransactionState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */