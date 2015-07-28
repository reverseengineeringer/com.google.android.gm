package com.android.mail.ui;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.android.mail.providers.UIProvider;

class ConversationViewFragment$SetCookieTask
  extends AsyncTask<Void, Void, Void>
{
  final Uri mAccountCookieQueryUri;
  final ContentResolver mResolver;
  final String mUri;
  
  ConversationViewFragment$SetCookieTask(ConversationViewFragment paramConversationViewFragment, Context paramContext, Uri paramUri1, Uri paramUri2)
  {
    mUri = paramUri1.toString();
    mAccountCookieQueryUri = paramUri2;
    mResolver = paramContext.getContentResolver();
  }
  
  public Void doInBackground(Void... paramVarArgs)
  {
    paramVarArgs = mResolver.query(mAccountCookieQueryUri, UIProvider.ACCOUNT_COOKIE_PROJECTION, null, null, null);
    if (paramVarArgs == null) {
      return null;
    }
    try
    {
      if (paramVarArgs.moveToFirst())
      {
        String str = paramVarArgs.getString(paramVarArgs.getColumnIndex("cookie"));
        if (str != null)
        {
          CookieSyncManager localCookieSyncManager = CookieSyncManager.createInstance(this$0.getContext());
          CookieManager.getInstance().setCookie(mUri, str);
          localCookieSyncManager.sync();
        }
      }
      return null;
    }
    finally
    {
      paramVarArgs.close();
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.ConversationViewFragment.SetCookieTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */