package com.google.android.gm;

import android.accounts.Account;
import android.content.ContentResolver;
import android.os.AsyncTask;
import android.os.Bundle;

class Utils$ScheduleSyncTask
  extends AsyncTask<Void, Void, Void>
{
  private final String mAccount;
  
  public Utils$ScheduleSyncTask(String paramString)
  {
    mAccount = paramString;
  }
  
  protected Void doInBackground(Void... paramVarArgs)
  {
    paramVarArgs = new Bundle();
    paramVarArgs.putBoolean("force", true);
    paramVarArgs.putBoolean("do_not_retry", true);
    paramVarArgs.putBoolean("expedited", true);
    ContentResolver.requestSync(new Account(mAccount, "com.google"), "gmail-ls", paramVarArgs);
    return null;
  }
  
  protected void onPostExecute(Void paramVoid)
  {
    Utils.access$102(null);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.Utils.ScheduleSyncTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */