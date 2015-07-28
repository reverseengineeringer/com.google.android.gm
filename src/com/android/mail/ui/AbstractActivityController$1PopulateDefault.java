package com.android.mail.ui;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;

final class AbstractActivityController$1PopulateDefault
  extends AsyncTask<Uri, Void, Void>
{
  AbstractActivityController$1PopulateDefault(AbstractActivityController paramAbstractActivityController) {}
  
  protected Void doInBackground(Uri... paramVarArgs)
  {
    this$0.mContext.getContentResolver().update(paramVarArgs[0], null, null, null);
    return null;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.AbstractActivityController.1PopulateDefault
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */