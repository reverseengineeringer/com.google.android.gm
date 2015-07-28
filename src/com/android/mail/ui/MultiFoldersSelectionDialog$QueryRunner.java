package com.android.mail.ui;

import android.app.AlertDialog.Builder;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import com.android.mail.providers.Account;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import com.android.mail.providers.UIProvider;
import com.android.mail.utils.Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

final class MultiFoldersSelectionDialog$QueryRunner
  extends AsyncTask<Void, Void, Void>
{
  private final Account mAccount;
  private final AlertDialog.Builder mBuilder;
  private final Context mContext;
  private final Folder mCurrentFolder;
  
  private MultiFoldersSelectionDialog$QueryRunner(MultiFoldersSelectionDialog paramMultiFoldersSelectionDialog, Context paramContext, Account paramAccount, AlertDialog.Builder paramBuilder, Folder paramFolder)
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
          localObject3 = MultiFoldersSelectionDialog.access$100(this$0).iterator();
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
    MultiFoldersSelectionDialog.access$200(this$0).addSection(new AddableFolderSelectorAdapter(mContext, AddableFolderSelectorAdapter.filterFolders(localUri), localHashSet, 2130968664, null));
    paramVarArgs = localUri;
    mBuilder.setAdapter(MultiFoldersSelectionDialog.access$200(this$0), this$0);
    if (localUri != null) {
      localUri.close();
    }
    return null;
  }
  
  protected void onPostExecute(Void paramVoid)
  {
    MultiFoldersSelectionDialog.access$302(this$0, mBuilder.create());
    MultiFoldersSelectionDialog.access$400(this$0);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.MultiFoldersSelectionDialog.QueryRunner
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */