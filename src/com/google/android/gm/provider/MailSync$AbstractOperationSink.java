package com.google.android.gm.provider;

abstract class MailSync$AbstractOperationSink
  implements MailStore.OperationSink
{
  private MailSync$AbstractOperationSink(MailSync paramMailSync) {}
  
  public abstract int getNumOperations();
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailSync.AbstractOperationSink
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */