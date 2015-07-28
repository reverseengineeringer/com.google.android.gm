package com.android.mail.ui;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.AsyncTask;
import com.android.mail.providers.MailAppProvider;
import com.android.mail.providers.UIProvider;

class MailboxSelectionActivity$1
  extends AsyncTask<Void, Void, Void>
{
  MailboxSelectionActivity$1(MailboxSelectionActivity paramMailboxSelectionActivity, ContentResolver paramContentResolver) {}
  
  protected Void doInBackground(Void... paramVarArgs)
  {
    paramVarArgs = null;
    try
    {
      Cursor localCursor = val$resolver.query(MailAppProvider.getAccountsUri(), UIProvider.ACCOUNTS_PROJECTION, null, null, null);
      paramVarArgs = localCursor;
      MailboxSelectionActivity.access$000(this$0, localCursor);
      return null;
    }
    finally
    {
      if (paramVarArgs != null) {
        paramVarArgs.close();
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.MailboxSelectionActivity.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */