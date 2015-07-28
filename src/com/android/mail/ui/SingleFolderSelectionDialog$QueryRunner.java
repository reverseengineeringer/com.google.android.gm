package com.android.mail.ui;

import android.app.AlertDialog.Builder;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.AsyncTask;
import com.android.mail.providers.Account;
import com.android.mail.providers.UIProvider;
import com.android.mail.utils.Utils;

final class SingleFolderSelectionDialog$QueryRunner
  extends AsyncTask<Void, Void, Void>
{
  private final Context mContext;
  
  private SingleFolderSelectionDialog$QueryRunner(SingleFolderSelectionDialog paramSingleFolderSelectionDialog, Context paramContext)
  {
    mContext = paramContext;
  }
  
  protected Void doInBackground(Void... paramVarArgs)
  {
    for (;;)
    {
      try
      {
        localObject1 = mContext.getContentResolver();
        if (!Utils.isEmpty(access$100this$0).fullFolderListUri))
        {
          paramVarArgs = access$100this$0).fullFolderListUri;
          paramVarArgs = ((ContentResolver)localObject1).query(paramVarArgs, UIProvider.FOLDERS_PROJECTION, null, null, null);
        }
      }
      finally
      {
        Object localObject1;
        paramVarArgs = null;
      }
      try
      {
        localObject1 = mContext.getResources().getStringArray(2131623944);
        SingleFolderSelectionDialog.access$300(this$0).addSection(new SystemFolderSelectorAdapter(mContext, paramVarArgs, 2130968680, null, SingleFolderSelectionDialog.access$200(this$0)));
        SingleFolderSelectionDialog.access$300(this$0).addSection(new HierarchicalFolderSelectorAdapter(mContext, AddableFolderSelectorAdapter.filterFolders(paramVarArgs), 2130968680, localObject1[2], SingleFolderSelectionDialog.access$200(this$0)));
        SingleFolderSelectionDialog.access$400(this$0).setAdapter(SingleFolderSelectionDialog.access$300(this$0), this$0);
        if (paramVarArgs != null) {
          paramVarArgs.close();
        }
        return null;
      }
      finally {}
      paramVarArgs = access$100this$0).folderListUri;
    }
    if (paramVarArgs != null) {
      paramVarArgs.close();
    }
    throw ((Throwable)localObject2);
  }
  
  protected void onPostExecute(Void paramVoid)
  {
    SingleFolderSelectionDialog.access$502(this$0, SingleFolderSelectionDialog.access$400(this$0).create());
    SingleFolderSelectionDialog.access$600(this$0);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.SingleFolderSelectionDialog.QueryRunner
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */