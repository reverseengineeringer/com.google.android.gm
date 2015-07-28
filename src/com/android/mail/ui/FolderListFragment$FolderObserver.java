package com.android.mail.ui;

import android.database.DataSetObserver;

final class FolderListFragment$FolderObserver
  extends DataSetObserver
{
  private FolderListFragment$FolderObserver(FolderListFragment paramFolderListFragment) {}
  
  public void onChanged()
  {
    if (FolderListFragment.access$000(this$0) == null) {}
    FolderController localFolderController;
    do
    {
      return;
      localFolderController = FolderListFragment.access$000(this$0).getFolderController();
    } while (localFolderController == null);
    FolderListFragment.access$100(this$0, localFolderController.getFolder());
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.FolderListFragment.FolderObserver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */