package com.android.mail.ui;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.database.Cursor;
import android.net.Uri;
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
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class MultiFoldersSelectionDialog
  extends FolderSelectionDialog
  implements DialogInterface.OnClickListener
{
  private final SeparatedFolderListAdapter mAdapter;
  private final boolean mBatch;
  private AlertDialog mDialog;
  private final HashMap<Uri, FolderOperation> mOperations;
  private final QueryRunner mRunner;
  private final boolean mSingle;
  private final Collection<Conversation> mTarget;
  private final ConversationUpdater mUpdater;
  
  private MultiFoldersSelectionDialog(Context paramContext, Account paramAccount, ConversationUpdater paramConversationUpdater, Collection<Conversation> paramCollection, boolean paramBoolean, Folder paramFolder)
  {
    mUpdater = paramConversationUpdater;
    mTarget = paramCollection;
    mBatch = paramBoolean;
    mOperations = new HashMap();
    paramConversationUpdater = new AlertDialog.Builder(paramContext);
    paramConversationUpdater.setTitle(2131493088);
    paramConversationUpdater.setPositiveButton(2131493074, this);
    paramConversationUpdater.setNegativeButton(2131493075, this);
    if (!paramAccount.supportsCapability(8192)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      mSingle = paramBoolean;
      mAdapter = new SeparatedFolderListAdapter(paramContext);
      mRunner = new QueryRunner(paramContext, paramAccount, paramConversationUpdater, paramFolder, null);
      return;
    }
  }
  
  public static MultiFoldersSelectionDialog getInstance(Context paramContext, Account paramAccount, ConversationUpdater paramConversationUpdater, Collection<Conversation> paramCollection, boolean paramBoolean, Folder paramFolder)
  {
    if (isShown()) {
      return null;
    }
    return new MultiFoldersSelectionDialog(paramContext, paramAccount, paramConversationUpdater, paramCollection, paramBoolean, paramFolder);
  }
  
  private final void showInternal()
  {
    mDialog.show();
    mDialog.getListView().setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        paramAnonymousAdapterView = mAdapter.getItem(paramAnonymousInt);
        if ((paramAnonymousAdapterView instanceof FolderSelectorAdapter.FolderRow)) {
          MultiFoldersSelectionDialog.this.update((FolderSelectorAdapter.FolderRow)paramAnonymousAdapterView);
        }
      }
    });
    mDialog.setOnDismissListener(this);
  }
  
  private final void update(FolderSelectorAdapter.FolderRow paramFolderRow)
  {
    boolean bool;
    if (!paramFolderRow.isPresent()) {
      bool = true;
    }
    while (mSingle) {
      if (!bool)
      {
        return;
        bool = false;
      }
      else
      {
        int i = 0;
        int j = mAdapter.getCount();
        while (i < j)
        {
          Object localObject = mAdapter.getItem(i);
          if ((localObject instanceof FolderSelectorAdapter.FolderRow))
          {
            ((FolderSelectorAdapter.FolderRow)localObject).setIsPresent(false);
            localObject = ((FolderSelectorAdapter.FolderRow)localObject).getFolder();
            mOperations.put(uri, new FolderOperation((Folder)localObject, Boolean.valueOf(false)));
          }
          i += 1;
        }
      }
    }
    paramFolderRow.setIsPresent(bool);
    mAdapter.notifyDataSetChanged();
    paramFolderRow = paramFolderRow.getFolder();
    mOperations.put(uri, new FolderOperation(paramFolderRow, Boolean.valueOf(bool)));
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (mUpdater == null);
    mUpdater.assignFolder(mOperations.values(), mTarget, mBatch, true);
  }
  
  public void show()
  {
    super.show();
    mRunner.execute(new Void[0]);
  }
  
  private final class QueryRunner
    extends AsyncTask<Void, Void, Void>
  {
    private final Account mAccount;
    private final AlertDialog.Builder mBuilder;
    private final Context mContext;
    private final Folder mCurrentFolder;
    
    private QueryRunner(Context paramContext, Account paramAccount, AlertDialog.Builder paramBuilder, Folder paramFolder)
    {
      mContext = paramContext;
      mAccount = paramAccount;
      mBuilder = paramBuilder;
      mCurrentFolder = paramFolder;
    }
    
    protected Void doInBackground(Void... paramVarArgs)
    {
      HashSet localHashSet = null;
      paramVarArgs = localHashSet;
      Uri localUri;
      for (;;)
      {
        try
        {
          Object localObject3 = mContext.getContentResolver();
          paramVarArgs = localHashSet;
          if (!Utils.isEmpty(mAccount.fullFolderListUri))
          {
            paramVarArgs = localHashSet;
            Object localObject1 = mAccount.fullFolderListUri;
            paramVarArgs = localHashSet;
            localObject1 = ((ContentResolver)localObject3).query((Uri)localObject1, UIProvider.FOLDERS_PROJECTION, null, null, null);
            paramVarArgs = (Void[])localObject1;
            localHashSet = new HashSet();
            paramVarArgs = (Void[])localObject1;
            localObject3 = mTarget.iterator();
            paramVarArgs = (Void[])localObject1;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            paramVarArgs = (Void[])localObject1;
            Conversation localConversation = (Conversation)((Iterator)localObject3).next();
            paramVarArgs = (Void[])localObject1;
            ArrayList localArrayList = localConversation.getRawFolders();
            if ((localConversation == null) || (localArrayList == null)) {
              break label178;
            }
            paramVarArgs = (Void[])localObject1;
            if (localArrayList.size() <= 0) {
              break label178;
            }
            paramVarArgs = (Void[])localObject1;
            localHashSet.addAll(Arrays.asList(Folder.getUriArray(localArrayList)));
            continue;
          }
          paramVarArgs = localHashSet;
        }
        finally
        {
          if (paramVarArgs != null) {
            paramVarArgs.close();
          }
        }
        localUri = mAccount.folderListUri;
        continue;
        label178:
        paramVarArgs = localUri;
        localHashSet.add(mCurrentFolder.uri.toString());
      }
      paramVarArgs = localUri;
      mAdapter.addSection(new AddableFolderSelectorAdapter(mContext, AddableFolderSelectorAdapter.filterFolders(localUri), localHashSet, 2130968664, null));
      paramVarArgs = localUri;
      mBuilder.setAdapter(mAdapter, MultiFoldersSelectionDialog.this);
      if (localUri != null) {
        localUri.close();
      }
      return null;
    }
    
    protected void onPostExecute(Void paramVoid)
    {
      MultiFoldersSelectionDialog.access$302(MultiFoldersSelectionDialog.this, mBuilder.create());
      MultiFoldersSelectionDialog.this.showInternal();
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.MultiFoldersSelectionDialog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */