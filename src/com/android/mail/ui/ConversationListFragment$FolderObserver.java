package com.android.mail.ui;

import android.database.DataSetObserver;

class ConversationListFragment$FolderObserver
  extends DataSetObserver
{
  private ConversationListFragment$FolderObserver(ConversationListFragment paramConversationListFragment) {}
  
  public void onChanged()
  {
    if (ConversationListFragment.access$200(this$0) == null) {}
    FolderController localFolderController;
    do
    {
      return;
      localFolderController = ConversationListFragment.access$200(this$0).getFolderController();
    } while (localFolderController == null);
    this$0.onFolderUpdated(localFolderController.getFolder());
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.ConversationListFragment.FolderObserver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */