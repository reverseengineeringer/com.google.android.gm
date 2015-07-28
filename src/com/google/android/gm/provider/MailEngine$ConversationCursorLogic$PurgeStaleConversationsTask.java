package com.google.android.gm.provider;

import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;

class MailEngine$ConversationCursorLogic$PurgeStaleConversationsTask
  extends AsyncTask<Void, Void, Void>
{
  private final long mCurrentQueryId;
  
  public MailEngine$ConversationCursorLogic$PurgeStaleConversationsTask(MailEngine.ConversationCursorLogic paramConversationCursorLogic, long paramLong)
  {
    mCurrentQueryId = paramLong;
  }
  
  protected Void doInBackground(Void... paramVarArgs)
  {
    this$1.this$0.mTransaction.beginTransactionNonExclusive();
    try
    {
      paramVarArgs = new String[1];
      paramVarArgs[0] = Long.toString(mCurrentQueryId);
      this$1.this$0.mDb.delete("conversations", "queryId != 0 AND queryId != ?", paramVarArgs);
      this$1.this$0.mDb.delete("conversation_labels", "queryId != 0 AND queryId != ?", paramVarArgs);
      this$1.this$0.mTransaction.setTransactionSuccessful();
      return null;
    }
    finally
    {
      this$1.this$0.mTransaction.endTransaction();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailEngine.ConversationCursorLogic.PurgeStaleConversationsTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */