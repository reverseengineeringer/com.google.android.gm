package com.android.mail.ui;

import android.database.Cursor;
import android.widget.ListAdapter;
import com.android.mail.providers.Folder;

abstract interface FolderListFragment$FolderListFragmentCursorAdapter
  extends ListAdapter
{
  public abstract void destroy();
  
  public abstract Folder getFullFolder(FolderListFragment.FolderListAdapter.Item paramItem);
  
  public abstract void notifyDataSetChanged();
  
  public abstract void setCursor(Cursor paramCursor);
}

/* Location:
 * Qualified Name:     com.android.mail.ui.FolderListFragment.FolderListFragmentCursorAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */