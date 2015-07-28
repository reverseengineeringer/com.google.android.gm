package com.android.mail.ui;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.android.mail.providers.Account;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import com.android.mail.providers.UIProvider;
import com.android.mail.utils.Utils;
import java.util.ArrayList;
import java.util.Collection;

public class SingleFolderSelectionDialog
  extends FolderSelectionDialog
  implements DialogInterface.OnClickListener
{
  private Account mAccount;
  private SeparatedFolderListAdapter mAdapter;
  private boolean mBatch;
  private AlertDialog.Builder mBuilder;
  private AlertDialog mDialog;
  private Folder mExcludeFolder;
  final QueryRunner mRunner;
  private final Collection<Conversation> mTarget;
  private ConversationUpdater mUpdater;
  
  private SingleFolderSelectionDialog(Context paramContext, Account paramAccount, ConversationUpdater paramConversationUpdater, Collection<Conversation> paramCollection, boolean paramBoolean, Folder paramFolder)
  {
    mUpdater = paramConversationUpdater;
    mTarget = paramCollection;
    mBatch = paramBoolean;
    mExcludeFolder = paramFolder;
    mBuilder = new AlertDialog.Builder(paramContext);
    mBuilder.setTitle(2131493088);
    mBuilder.setNegativeButton(2131493075, this);
    mAccount = paramAccount;
    mAdapter = new SeparatedFolderListAdapter(paramContext);
    mRunner = new QueryRunner(paramContext, null);
  }
  
  public static SingleFolderSelectionDialog getInstance(Context paramContext, Account paramAccount, ConversationUpdater paramConversationUpdater, Collection<Conversation> paramCollection, boolean paramBoolean, Folder paramFolder)
  {
    if (isShown()) {
      return null;
    }
    return new SingleFolderSelectionDialog(paramContext, paramAccount, paramConversationUpdater, paramCollection, paramBoolean, paramFolder);
  }
  
  private final void showInternal()
  {
    mDialog.show();
    mDialog.getListView().setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        paramAnonymousAdapterView = mAdapter.getItem(paramAnonymousInt);
        if ((paramAnonymousAdapterView instanceof FolderSelectorAdapter.FolderRow))
        {
          paramAnonymousAdapterView = ((FolderSelectorAdapter.FolderRow)paramAnonymousAdapterView).getFolder();
          paramAnonymousView = new ArrayList();
          paramAnonymousView.add(new FolderOperation(mExcludeFolder, Boolean.valueOf(false)));
          paramAnonymousView.add(new FolderOperation(paramAnonymousAdapterView, Boolean.valueOf(true)));
          mUpdater.assignFolder(paramAnonymousView, mTarget, mBatch, true);
          mDialog.dismiss();
        }
      }
    });
    mDialog.setOnDismissListener(this);
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt) {}
  
  public void show()
  {
    super.show();
    mRunner.execute(new Void[0]);
  }
  
  private final class QueryRunner
    extends AsyncTask<Void, Void, Void>
  {
    private final Context mContext;
    
    private QueryRunner(Context paramContext)
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
          if (!Utils.isEmpty(mAccount.fullFolderListUri))
          {
            paramVarArgs = mAccount.fullFolderListUri;
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
          mAdapter.addSection(new SystemFolderSelectorAdapter(mContext, paramVarArgs, 2130968680, null, mExcludeFolder));
          mAdapter.addSection(new HierarchicalFolderSelectorAdapter(mContext, AddableFolderSelectorAdapter.filterFolders(paramVarArgs), 2130968680, localObject1[2], mExcludeFolder));
          mBuilder.setAdapter(mAdapter, SingleFolderSelectionDialog.this);
          if (paramVarArgs != null) {
            paramVarArgs.close();
          }
          return null;
        }
        finally {}
        paramVarArgs = mAccount.folderListUri;
      }
      if (paramVarArgs != null) {
        paramVarArgs.close();
      }
      throw ((Throwable)localObject2);
    }
    
    protected void onPostExecute(Void paramVoid)
    {
      SingleFolderSelectionDialog.access$502(SingleFolderSelectionDialog.this, mBuilder.create());
      SingleFolderSelectionDialog.this.showInternal();
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.SingleFolderSelectionDialog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */