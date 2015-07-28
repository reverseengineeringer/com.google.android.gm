package com.google.android.gm.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteTransactionListener;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

class GmailTransactionListener
  implements TransactionHelper.BetterTransactionListener
{
  private final boolean DEBUG = false;
  private final String mAccount;
  private final Context mContext;
  private final SQLiteDatabase mDb;
  private final MailEngine mEngine;
  private final ThreadLocal<GmailTransactionState> mState;
  private SQLiteTransactionListener mTestTransactionListener;
  
  public GmailTransactionListener(Context paramContext, MailEngine paramMailEngine, String paramString)
  {
    mContext = paramContext;
    mAccount = paramString;
    mEngine = paramMailEngine;
    mDb = mEngine.mDb;
    mState = new ThreadLocal()
    {
      protected GmailTransactionListener.GmailTransactionState initialValue()
      {
        return new GmailTransactionListener.GmailTransactionState(GmailTransactionListener.this);
      }
    };
  }
  
  private Set<Long> getConversationIdsSet()
  {
    return mState.get()).mConversationIds;
  }
  
  private Set<Long> getLabelIdsSet()
  {
    return mState.get()).mLabelIds;
  }
  
  public void addConversationToNotify(long paramLong)
  {
    if (!mDb.inTransaction()) {
      LogUtils.e("Gmail", "Must already be in a transaction with listener to add conversation to notify. (id=%d)", new Object[] { Long.valueOf(paramLong) });
    }
    while (!getConversationIdsSet().add(Long.valueOf(paramLong))) {
      return;
    }
    LogUtils.d("Gmail", "adding convId (%d) to notify", new Object[] { Long.valueOf(paramLong) });
  }
  
  public void addLabelToNotify(Set<Long> paramSet)
  {
    if (!mDb.inTransaction()) {
      LogUtils.e("Gmail", "Must already be in a transaction with listener to add label to notify. (ids=%s)", new Object[] { paramSet });
    }
    while (!getLabelIdsSet().addAll(paramSet)) {
      return;
    }
    LogUtils.d("Gmail", "adding labelIds (%s) to notify", new Object[] { paramSet });
  }
  
  public void enableGmailAccountNotifications(boolean paramBoolean)
  {
    if (!mDb.inTransaction()) {
      LogUtils.e("Gmail", "Must already be in a transaction with listener to enable notifications for account %s.", new Object[] { mAccount });
    }
    GmailTransactionState localGmailTransactionState;
    do
    {
      return;
      localGmailTransactionState = (GmailTransactionState)mState.get();
      mSendGmailAccountNotifications = true;
    } while ((!paramBoolean) || (mScheduleSyncOnAccountNotification));
    mScheduleSyncOnAccountNotification = true;
  }
  
  public void onBegin()
  {
    MailIndexerService.onContentProviderAccess(mAccount);
    if (mTestTransactionListener != null) {
      mTestTransactionListener.onBegin();
    }
  }
  
  public void onCommit()
  {
    if (mTestTransactionListener != null) {
      mTestTransactionListener.onCommit();
    }
  }
  
  public void onCommitCompleted(boolean paramBoolean)
  {
    if (!mDb.inTransaction())
    {
      Object localObject = getConversationIdsSet();
      if (!paramBoolean)
      {
        if (!((Set)localObject).isEmpty())
        {
          LogUtils.d("Gmail", "Outermost commit complete, notifying on conversations: %s", new Object[] { localObject });
          Iterator localIterator = ((Set)localObject).iterator();
          while (localIterator.hasNext())
          {
            Long localLong = (Long)localIterator.next();
            UiProvider.onConversationChanged(mContext, mAccount, localLong.longValue());
          }
        }
        UiProvider.broadcastAccountChangeNotification(mContext, mAccount);
      }
      ((Set)localObject).clear();
      localObject = getLabelIdsSet();
      mEngine.broadcastLabelNotificationsImpl((Set)localObject);
      ((Set)localObject).clear();
      localObject = (GmailTransactionState)mState.get();
      if (mSendGmailAccountNotifications) {
        mEngine.sendAccountNotifications(mScheduleSyncOnAccountNotification);
      }
      mSendGmailAccountNotifications = false;
      mScheduleSyncOnAccountNotification = false;
    }
  }
  
  public void onRollback()
  {
    if (mTestTransactionListener != null) {
      mTestTransactionListener.onRollback();
    }
  }
  
  public void onRollbackCompleted()
  {
    if (!mDb.inTransaction())
    {
      Set localSet = getConversationIdsSet();
      if (!localSet.isEmpty()) {
        LogUtils.d("Gmail", "Rolled back outermost conversation commit, NOT notifying on: %s", new Object[] { localSet });
      }
      localSet.clear();
      localSet = getLabelIdsSet();
      if (!localSet.isEmpty()) {
        LogUtils.d("Gmail", "Rolled back outermost label commit, NOT notifying on: %s", new Object[] { localSet });
      }
      localSet.clear();
    }
  }
  
  public void setTestTransactionListener(SQLiteTransactionListener paramSQLiteTransactionListener)
  {
    mTestTransactionListener = paramSQLiteTransactionListener;
  }
  
  private class GmailTransactionState
  {
    public final Set<Long> mConversationIds = Sets.newHashSet();
    public final Set<Long> mLabelIds = Sets.newHashSet();
    public boolean mScheduleSyncOnAccountNotification = false;
    public boolean mSendGmailAccountNotifications = false;
    private final Stack<Throwable> mStackTraces = (Stack)null;
    
    public GmailTransactionState() {}
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.GmailTransactionListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */