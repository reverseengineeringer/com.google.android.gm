package com.google.android.gm.provider;

class TransactionHelper$ThreadTransactionState
{
  public boolean mChildFailed = false;
  public final TransactionHelper.BetterTransactionListener mListener;
  public boolean mSuccess = false;
  
  public TransactionHelper$ThreadTransactionState(TransactionHelper.BetterTransactionListener paramBetterTransactionListener)
  {
    mListener = paramBetterTransactionListener;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.TransactionHelper.ThreadTransactionState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */