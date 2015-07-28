package com.google.android.gm.provider;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteTransactionListener;
import java.util.Stack;

public class TransactionHelper
{
  private final SQLiteDatabase mDb;
  private final ThreadLocal<Stack<ThreadTransactionState>> mStates;
  private final ThreadLocal<Boolean> mSuppressUiNotifications = new ThreadLocal()
  {
    protected Boolean initialValue()
    {
      return Boolean.FALSE;
    }
  };
  
  public TransactionHelper(SQLiteDatabase paramSQLiteDatabase)
  {
    mDb = paramSQLiteDatabase;
    mStates = new ThreadLocal()
    {
      protected Stack<TransactionHelper.ThreadTransactionState> initialValue()
      {
        return new Stack();
      }
    };
  }
  
  private Stack<ThreadTransactionState> getStates()
  {
    return (Stack)mStates.get();
  }
  
  public void beginTransactionNonExclusive()
  {
    getStates().push(new ThreadTransactionState(null));
    mDb.beginTransactionNonExclusive();
  }
  
  public void beginTransactionWithListenerNonExclusive(BetterTransactionListener paramBetterTransactionListener)
  {
    getStates().push(new ThreadTransactionState(paramBetterTransactionListener));
    mDb.beginTransactionWithListenerNonExclusive(paramBetterTransactionListener);
  }
  
  public void endTransaction()
  {
    mDb.endTransaction();
    Object localObject = (ThreadTransactionState)getStates().pop();
    int i;
    if ((mSuccess) && (!mChildFailed))
    {
      i = 1;
      if (mListener != null)
      {
        if (i == 0) {
          break label100;
        }
        mListener.onCommitCompleted(((Boolean)mSuppressUiNotifications.get()).booleanValue());
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        localObject = getStates();
        if (!((Stack)localObject).empty()) {
          peekmChildFailed = true;
        }
      }
      return;
      i = 0;
      break;
      label100:
      mListener.onRollbackCompleted();
    }
  }
  
  public void setTransactionSuccessful()
  {
    mDb.setTransactionSuccessful();
    getStatespeekmSuccess = true;
  }
  
  void suppressUiNotifications()
  {
    mSuppressUiNotifications.set(Boolean.TRUE);
  }
  
  public static abstract interface BetterTransactionListener
    extends SQLiteTransactionListener
  {
    public abstract void onCommitCompleted(boolean paramBoolean);
    
    public abstract void onRollbackCompleted();
  }
  
  private static class ThreadTransactionState
  {
    public boolean mChildFailed = false;
    public final TransactionHelper.BetterTransactionListener mListener;
    public boolean mSuccess = false;
    
    public ThreadTransactionState(TransactionHelper.BetterTransactionListener paramBetterTransactionListener)
    {
      mListener = paramBetterTransactionListener;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.TransactionHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */