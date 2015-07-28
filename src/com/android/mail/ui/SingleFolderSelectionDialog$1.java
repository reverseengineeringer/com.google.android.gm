package com.android.mail.ui;

import android.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;

class SingleFolderSelectionDialog$1
  implements AdapterView.OnItemClickListener
{
  SingleFolderSelectionDialog$1(SingleFolderSelectionDialog paramSingleFolderSelectionDialog) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = SingleFolderSelectionDialog.access$300(this$0).getItem(paramInt);
    if ((paramAdapterView instanceof FolderSelectorAdapter.FolderRow))
    {
      paramAdapterView = ((FolderSelectorAdapter.FolderRow)paramAdapterView).getFolder();
      paramView = new ArrayList();
      paramView.add(new FolderOperation(SingleFolderSelectionDialog.access$200(this$0), Boolean.valueOf(false)));
      paramView.add(new FolderOperation(paramAdapterView, Boolean.valueOf(true)));
      SingleFolderSelectionDialog.access$900(this$0).assignFolder(paramView, SingleFolderSelectionDialog.access$700(this$0), SingleFolderSelectionDialog.access$800(this$0), true);
      SingleFolderSelectionDialog.access$500(this$0).dismiss();
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.SingleFolderSelectionDialog.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */