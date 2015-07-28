package com.android.mail.ui;

import android.database.DataSetObserver;

public abstract interface RecentFolderController
{
  public abstract RecentFolderList getRecentFolders();
  
  public abstract void registerRecentFolderObserver(DataSetObserver paramDataSetObserver);
  
  public abstract void unregisterRecentFolderObserver(DataSetObserver paramDataSetObserver);
}

/* Location:
 * Qualified Name:     com.android.mail.ui.RecentFolderController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */