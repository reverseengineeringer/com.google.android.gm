package com.android.mail.providers;

import android.database.DataSetObserver;
import com.android.mail.ui.RecentFolderController;
import com.android.mail.ui.RecentFolderList;
import com.android.mail.utils.LogTag;
import com.android.mail.utils.LogUtils;

public abstract class RecentFolderObserver
  extends DataSetObserver
{
  private static final String LOG_TAG = ;
  private RecentFolderController mController;
  
  public RecentFolderList initialize(RecentFolderController paramRecentFolderController)
  {
    if (paramRecentFolderController == null) {
      LogUtils.wtf(LOG_TAG, "RecentFolderObserver initialized with null controller!", new Object[0]);
    }
    mController = paramRecentFolderController;
    mController.registerRecentFolderObserver(this);
    return mController.getRecentFolders();
  }
  
  public void unregisterAndDestroy()
  {
    if (mController == null) {
      return;
    }
    mController.unregisterRecentFolderObserver(this);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.providers.RecentFolderObserver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */