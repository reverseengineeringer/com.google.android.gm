package com.android.mail.ui;

import android.database.DataSetObserver;

class MailActionBarView$FolderObserver
  extends DataSetObserver
{
  private MailActionBarView$FolderObserver(MailActionBarView paramMailActionBarView) {}
  
  public void onChanged()
  {
    this$0.onFolderUpdated(this$0.mController.getFolder());
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.MailActionBarView.FolderObserver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */