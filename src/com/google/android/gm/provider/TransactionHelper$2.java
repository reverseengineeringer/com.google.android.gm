package com.google.android.gm.provider;

import java.util.Stack;

class TransactionHelper$2
  extends ThreadLocal<Stack<TransactionHelper.ThreadTransactionState>>
{
  TransactionHelper$2(TransactionHelper paramTransactionHelper) {}
  
  protected Stack<TransactionHelper.ThreadTransactionState> initialValue()
  {
    return new Stack();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.TransactionHelper.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */