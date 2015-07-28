package com.google.android.gm.provider;

import android.database.sqlite.SQLiteTransactionListener;

public abstract interface TransactionHelper$BetterTransactionListener
  extends SQLiteTransactionListener
{
  public abstract void onCommitCompleted(boolean paramBoolean);
  
  public abstract void onRollbackCompleted();
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.TransactionHelper.BetterTransactionListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */