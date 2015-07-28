package com.android.mail.ui;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import com.android.mail.providers.Account;
import com.android.mail.providers.Folder;
import com.android.mail.utils.LogUtils;
import com.android.mail.utils.Utils;

class RecentFolderList$StoreRecent
  extends AsyncTask<Void, Void, Void>
{
  private final Account mAccount;
  private final Folder mFolder;
  
  static
  {
    if (!RecentFolderList.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public RecentFolderList$StoreRecent(RecentFolderList paramRecentFolderList, Account paramAccount, Folder paramFolder)
  {
    assert ((paramAccount != null) && (paramFolder != null));
    mAccount = paramAccount;
    mFolder = paramFolder;
  }
  
  protected Void doInBackground(Void... paramVarArgs)
  {
    paramVarArgs = mAccount.recentFolderListUri;
    if (!Utils.isEmpty(paramVarArgs))
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put(mFolder.uri.toString(), Integer.valueOf(0));
      LogUtils.i("RecentFolderList", "Save: %s", new Object[] { mFolder.name });
      RecentFolderList.access$100(this$0).getContentResolver().update(paramVarArgs, localContentValues, null, null);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.RecentFolderList.StoreRecent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */