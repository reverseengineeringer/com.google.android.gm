package com.android.mail.browse;

import android.database.Cursor;
import android.os.AsyncTask;
import com.android.mail.utils.LogUtils;

class ConversationCursor$RefreshTask
  extends AsyncTask<Void, Void, Void>
{
  private Cursor mCursor = null;
  
  private ConversationCursor$RefreshTask(ConversationCursor paramConversationCursor) {}
  
  protected Void doInBackground(Void... paramVarArgs)
  {
    LogUtils.i("ConversationCursor", "[Start refresh of %s: %d]", new Object[] { ConversationCursor.access$000(this$0), Integer.valueOf(hashCode()) });
    mCursor = ConversationCursor.access$100(this$0, false);
    mCursor.getCount();
    return null;
  }
  
  protected void onCancelled()
  {
    LogUtils.i("ConversationCursor", "[Ignoring refresh result: %d]", new Object[] { Integer.valueOf(hashCode()) });
    if (mCursor != null) {
      mCursor.close();
    }
  }
  
  protected void onPostExecute(Void arg1)
  {
    synchronized (ConversationCursor.access$200(this$0))
    {
      if (this$0.isClosed())
      {
        onCancelled();
        return;
      }
      ConversationCursor.access$302(this$0, mCursor);
      ConversationCursor.access$402(this$0, true);
      LogUtils.i("ConversationCursor", "[Query done %s: %d]", new Object[] { ConversationCursor.access$000(this$0), Integer.valueOf(hashCode()) });
      if ((!ConversationCursor.access$500(this$0)) && (!ConversationCursor.access$600(this$0))) {
        ConversationCursor.access$700(this$0);
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.ConversationCursor.RefreshTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */