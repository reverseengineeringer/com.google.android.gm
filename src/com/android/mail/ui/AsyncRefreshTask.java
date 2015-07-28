package com.android.mail.ui;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;

public class AsyncRefreshTask
  extends AsyncTask<Void, Void, Void>
{
  private final Context mContext;
  private final Uri mRefreshUri;
  
  public AsyncRefreshTask(Context paramContext, Uri paramUri)
  {
    mContext = paramContext;
    mRefreshUri = paramUri;
  }
  
  protected Void doInBackground(Void... paramVarArgs)
  {
    if (mRefreshUri != null) {
      mContext.getContentResolver().query(mRefreshUri, null, null, null, null);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.AsyncRefreshTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */