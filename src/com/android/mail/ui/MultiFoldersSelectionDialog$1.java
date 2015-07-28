package com.android.mail.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class MultiFoldersSelectionDialog$1
  implements AdapterView.OnItemClickListener
{
  MultiFoldersSelectionDialog$1(MultiFoldersSelectionDialog paramMultiFoldersSelectionDialog) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = MultiFoldersSelectionDialog.access$200(this$0).getItem(paramInt);
    if ((paramAdapterView instanceof FolderSelectorAdapter.FolderRow)) {
      MultiFoldersSelectionDialog.access$500(this$0, (FolderSelectorAdapter.FolderRow)paramAdapterView);
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.MultiFoldersSelectionDialog.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */