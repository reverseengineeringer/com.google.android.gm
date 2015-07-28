package com.android.mail.ui;

import android.database.DataSetObserver;
import com.android.mail.providers.Folder;

public abstract interface FolderController
{
  public abstract Folder getFolder();
  
  public abstract void registerFolderObserver(DataSetObserver paramDataSetObserver);
  
  public abstract void unregisterFolderObserver(DataSetObserver paramDataSetObserver);
}

/* Location:
 * Qualified Name:     com.android.mail.ui.FolderController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */