package com.android.mail.browse;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import com.android.mail.providers.Account;
import com.android.mail.providers.AccountObserver;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import com.android.mail.providers.MailAppProvider;
import com.android.mail.providers.Settings;
import com.android.mail.providers.UIProvider.ConversationColumns;
import com.android.mail.ui.ControllableActivity;
import com.android.mail.ui.ConversationListCallbacks;
import com.android.mail.ui.ConversationSelectionSet;
import com.android.mail.ui.ConversationSetObserver;
import com.android.mail.ui.ConversationUpdater;
import com.android.mail.ui.DestructiveAction;
import com.android.mail.ui.FolderSelectionDialog;
import com.android.mail.ui.MultiFoldersSelectionDialog;
import com.android.mail.ui.SingleFolderSelectionDialog;
import com.android.mail.ui.SwipeableListView;
import com.android.mail.utils.LogTag;
import com.android.mail.utils.LogUtils;
import com.android.mail.utils.Utils;
import java.util.Collection;
import java.util.Iterator;

public class SelectedConversationsActionMenu
  implements ActionMode.Callback, ConversationSetObserver
{
  private static final String LOG_TAG = ;
  private Account mAccount;
  private AccountObserver mAccountObserver;
  private ActionMode mActionMode;
  private boolean mActivated = false;
  private final ControllableActivity mActivity;
  private final Context mContext;
  private final Folder mFolder;
  private final ConversationListCallbacks mListController;
  private Menu mMenu;
  protected final ConversationSelectionSet mSelectionSet;
  private final ConversationUpdater mUpdater;
  
  public SelectedConversationsActionMenu(ControllableActivity paramControllableActivity, ConversationSelectionSet paramConversationSelectionSet, Folder paramFolder, SwipeableListView paramSwipeableListView)
  {
    mActivity = paramControllableActivity;
    mListController = paramControllableActivity.getListHandler();
    mSelectionSet = paramConversationSelectionSet;
    mAccountObserver = new AccountObserver()
    {
      public void onChanged(Account paramAnonymousAccount)
      {
        SelectedConversationsActionMenu.access$002(SelectedConversationsActionMenu.this, paramAnonymousAccount);
      }
    };
    mAccount = mAccountObserver.initialize(paramControllableActivity.getAccountController());
    mFolder = paramFolder;
    mContext = mActivity.getActivityContext();
    mUpdater = paramControllableActivity.getConversationUpdater();
    FolderSelectionDialog.setDialogDismissed();
  }
  
  private void clearSelection()
  {
    mSelectionSet.clear();
  }
  
  private void destroy()
  {
    deactivate();
    mSelectionSet.removeObserver(this);
    clearSelection();
    mUpdater.refreshConversationList();
    if (mAccountObserver != null)
    {
      mAccountObserver.unregisterAndDestroy();
      mAccountObserver = null;
    }
  }
  
  private void destroy(int paramInt, Collection<Conversation> paramCollection, Collection<ConversationItemView> paramCollection1, DestructiveAction paramDestructiveAction)
  {
    mUpdater.delete(paramInt, paramCollection, paramCollection1, paramDestructiveAction);
  }
  
  private void markConversationsImportant(boolean paramBoolean)
  {
    Object localObject = mSelectionSet.values();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      mUpdater.updateConversation((Collection)localObject, UIProvider.ConversationColumns.PRIORITY, i);
      localObject = ((Collection)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        nextpriority = i;
      }
    }
    updateSelection();
  }
  
  private void markConversationsRead(boolean paramBoolean)
  {
    Collection localCollection = mSelectionSet.values();
    mUpdater.markConversationsRead(localCollection, paramBoolean, false);
    updateSelection();
  }
  
  private void performDestructiveAction(final int paramInt)
  {
    final DestructiveAction localDestructiveAction = mUpdater.getDeferredBatchAction(paramInt);
    Object localObject = mAccount.settings;
    final Collection localCollection1 = mSelectionSet.values();
    final Collection localCollection2 = mSelectionSet.views();
    boolean bool;
    int i;
    if ((localObject != null) && ((paramInt == 2131755301) || (paramInt == 2131755302)))
    {
      bool = confirmDelete;
      if (!bool) {
        break label178;
      }
      switch (paramInt)
      {
      default: 
        i = 2131820548;
      }
    }
    for (;;)
    {
      localObject = Utils.formatPlural(mContext, i, localCollection1.size());
      new AlertDialog.Builder(mContext).setMessage((CharSequence)localObject).setPositiveButton(2131493074, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          SelectedConversationsActionMenu.this.destroy(paramInt, localCollection1, localCollection2, localDestructiveAction);
        }
      }).setNegativeButton(2131493075, null).create().show();
      return;
      bool = confirmArchive;
      break;
      i = 2131820547;
      continue;
      i = 2131820549;
    }
    label178:
    destroy(paramInt, localCollection1, localCollection2, localDestructiveAction);
  }
  
  private void starConversations(boolean paramBoolean)
  {
    Object localObject = mSelectionSet.values();
    mUpdater.updateConversation((Collection)localObject, UIProvider.ConversationColumns.STARRED, paramBoolean);
    localObject = ((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      nextstarred = paramBoolean;
    }
    updateSelection();
  }
  
  private void updateCount()
  {
    if (mActionMode != null) {
      mActionMode.setTitle(mContext.getString(2131493012, new Object[] { Integer.valueOf(mSelectionSet.size()) }));
    }
  }
  
  private void updateSelection()
  {
    mUpdater.refreshConversationList();
    if (mActionMode != null) {
      onPrepareActionMode(mActionMode, mActionMode.getMenu());
    }
  }
  
  public void activate()
  {
    if (mSelectionSet.isEmpty()) {}
    do
    {
      return;
      mActivated = true;
    } while (mActionMode != null);
    mActivity.startActionMode(this);
  }
  
  public void deactivate()
  {
    if (mActionMode != null)
    {
      mActivated = false;
      mActionMode.finish();
    }
  }
  
  public boolean isActivated()
  {
    return mActivated;
  }
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    boolean bool2 = true;
    mListController.commitDestructiveActions(true);
    boolean bool1;
    switch (paramMenuItem.getItemId())
    {
    default: 
      bool1 = false;
    case 2131755301: 
    case 2131755302: 
    case 2131755299: 
    case 2131755300: 
    case 2131755307: 
    case 2131755308: 
    case 2131755309: 
    case 2131755310: 
    case 2131755315: 
    case 2131755068: 
    case 2131755104: 
    case 2131755316: 
    case 2131755303: 
      int j;
      do
      {
        return bool1;
        performDestructiveAction(2131755301);
        return true;
        performDestructiveAction(2131755302);
        return true;
        performDestructiveAction(2131755299);
        return true;
        destroy(2131755300, mSelectionSet.values(), mSelectionSet.views(), mUpdater.getDeferredRemoveFolder(mSelectionSet.values(), mFolder, true, true, true));
        return true;
        mUpdater.delete(2131755307, mSelectionSet.values(), mUpdater.getBatchAction(2131755307));
        return true;
        mUpdater.delete(2131755308, mSelectionSet.values(), mUpdater.getBatchAction(2131755308));
        return true;
        mUpdater.delete(2131755309, mSelectionSet.values(), mUpdater.getBatchAction(2131755309));
        return true;
        mUpdater.delete(2131755310, mSelectionSet.values(), mUpdater.getBatchAction(2131755310));
        return true;
        markConversationsRead(true);
        return true;
        markConversationsRead(false);
        return true;
        starConversations(true);
        return true;
        if (mFolder.type == 7)
        {
          LogUtils.d(LOG_TAG, "We are in a starred folder, removing the star", new Object[0]);
          performDestructiveAction(2131755316);
          return true;
        }
        LogUtils.d(LOG_TAG, "Not in a starred folder.", new Object[0]);
        starConversations(false);
        return true;
        j = 0;
        int k = 0;
        Account localAccount = mAccount;
        paramMenuItem = localAccount;
        if (mFolder.supportsCapability(4096))
        {
          paramActionMode = null;
          paramMenuItem = mSelectionSet.values().iterator();
          Conversation localConversation;
          do
          {
            for (;;)
            {
              i = k;
              if (!paramMenuItem.hasNext()) {
                break label541;
              }
              localConversation = (Conversation)paramMenuItem.next();
              if (paramActionMode != null) {
                break;
              }
              paramActionMode = accountUri;
            }
          } while (paramActionMode.equals(accountUri));
          Toast.makeText(mContext, 2131493104, 1).show();
          int i = 1;
          paramMenuItem = localAccount;
          j = i;
          if (i == 0)
          {
            paramMenuItem = MailAppProvider.getAccountFromAccountUri(paramActionMode);
            j = i;
          }
        }
        bool1 = bool2;
      } while (j != 0);
      if (mAccount.supportsCapability(8192)) {}
      for (paramActionMode = MultiFoldersSelectionDialog.getInstance(mContext, paramMenuItem, mUpdater, mSelectionSet.values(), true, mFolder);; paramActionMode = SingleFolderSelectionDialog.getInstance(mContext, paramMenuItem, mUpdater, mSelectionSet.values(), true, mFolder))
      {
        bool1 = bool2;
        if (paramActionMode == null) {
          break;
        }
        paramActionMode.show();
        return true;
      }
    case 2131755305: 
      label541:
      markConversationsImportant(true);
      return true;
    }
    if (mFolder.supportsCapability(1024))
    {
      performDestructiveAction(2131755306);
      return true;
    }
    markConversationsImportant(false);
    return true;
  }
  
  public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    mSelectionSet.addObserver(this);
    mActivity.getMenuInflater().inflate(2131886084, paramMenu);
    mActionMode = paramActionMode;
    mMenu = paramMenu;
    updateCount();
    return true;
  }
  
  public void onDestroyActionMode(ActionMode paramActionMode)
  {
    mActionMode = null;
    if (mActivated)
    {
      destroy();
      mActivity.getListHandler().commitDestructiveActions(true);
    }
    mMenu = null;
  }
  
  public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    paramActionMode = mSelectionSet.values();
    boolean bool2 = false;
    boolean bool1 = false;
    int k = 0;
    int i = 0;
    int j = 0;
    paramActionMode = paramActionMode.iterator();
    int n;
    int m;
    int i1;
    boolean bool4;
    boolean bool3;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              n = j;
              m = k;
              i1 = i;
              bool4 = bool1;
              bool3 = bool2;
              if (!paramActionMode.hasNext()) {
                break;
              }
              Conversation localConversation = (Conversation)paramActionMode.next();
              bool3 = bool2;
              if (!starred) {
                bool3 = true;
              }
              bool4 = bool1;
              if (read) {
                bool4 = true;
              }
              m = k;
              if (!localConversation.isImportant()) {
                m = 1;
              }
              i1 = i;
              if (spam) {
                i1 = 1;
              }
              n = j;
              if (!phishing) {
                n = 1;
              }
              j = n;
              k = m;
              i = i1;
              bool1 = bool4;
              bool2 = bool3;
            } while (!bool3);
            j = n;
            k = m;
            i = i1;
            bool1 = bool4;
            bool2 = bool3;
          } while (!bool4);
          j = n;
          k = m;
          i = i1;
          bool1 = bool4;
          bool2 = bool3;
        } while (m == 0);
        j = n;
        k = m;
        i = i1;
        bool1 = bool4;
        bool2 = bool3;
      } while (i1 == 0);
      j = n;
      k = m;
      i = i1;
      bool1 = bool4;
      bool2 = bool3;
    } while (n == 0);
    paramMenu.findItem(2131755104).setVisible(bool3);
    paramActionMode = paramMenu.findItem(2131755316);
    if (!bool3)
    {
      bool1 = true;
      paramActionMode.setVisible(bool1);
      paramActionMode = paramMenu.findItem(2131755315);
      if (bool4) {
        break label947;
      }
      bool1 = true;
      label324:
      paramActionMode.setVisible(bool1);
      paramMenu.findItem(2131755068).setVisible(bool4);
      paramActionMode = paramMenu.findItem(2131755300);
      if ((mFolder == null) || (mFolder.type != 0) || (!mFolder.supportsCapability(8)) || (mFolder.isProviderFolder())) {
        break label953;
      }
      bool2 = true;
      label402:
      paramActionMode.setVisible(bool2);
      if ((mFolder != null) && (bool2)) {
        paramActionMode.setTitle(mActivity.getActivityContext().getString(2131492928, new Object[] { mFolder.name }));
      }
      paramActionMode = paramMenu.findItem(2131755299);
      bool3 = mAccount.supportsCapability(8);
      if ((!bool3) || (!mFolder.supportsCapability(16))) {
        break label959;
      }
      bool1 = true;
      label500:
      if (paramActionMode != null) {
        break label965;
      }
      bool1 = false;
      label507:
      if ((!bool1) && (bool3) && (!bool2) && (Utils.shouldShowDisabledArchiveIcon(mActivity.getActivityContext())))
      {
        paramActionMode.setEnabled(false);
        paramActionMode.setVisible(true);
      }
      paramActionMode = paramMenu.findItem(2131755308);
      if ((i1 != 0) || (!mAccount.supportsCapability(2)) || (!mFolder.supportsCapability(64))) {
        break label977;
      }
      bool1 = true;
      label594:
      paramActionMode.setVisible(bool1);
      paramActionMode = paramMenu.findItem(2131755309);
      if ((i1 == 0) || (!mAccount.supportsCapability(2)) || (!mFolder.supportsCapability(128))) {
        break label983;
      }
      bool1 = true;
      label645:
      paramActionMode.setVisible(bool1);
      paramActionMode = paramMenu.findItem(2131755310);
      if ((n == 0) || (!mAccount.supportsCapability(4)) || (!mFolder.supportsCapability(8192))) {
        break label989;
      }
      bool1 = true;
      label696:
      paramActionMode.setVisible(bool1);
      paramActionMode = paramMenu.findItem(2131755307);
      if (paramActionMode != null)
      {
        if ((!mAccount.supportsCapability(16)) || (mFolder == null) || (mFolder.type != 1)) {
          break label995;
        }
        bool1 = true;
        label752:
        paramActionMode.setVisible(bool1);
      }
      paramActionMode = paramMenu.findItem(2131755305);
      if ((m == 0) || (!mAccount.supportsCapability(131072))) {
        break label1001;
      }
      bool1 = true;
      label792:
      paramActionMode.setVisible(bool1);
      paramActionMode = paramMenu.findItem(2131755306);
      if ((m != 0) || (!mAccount.supportsCapability(131072))) {
        break label1007;
      }
      bool1 = true;
      label832:
      paramActionMode.setVisible(bool1);
      if ((mFolder == null) || (!mFolder.supportsCapability(32))) {
        break label1013;
      }
      bool1 = true;
      label863:
      paramMenu.findItem(2131755301).setVisible(bool1);
      if ((bool1) || (mFolder == null) || (!mFolder.isDraft()) || (!mAccount.supportsCapability(1048576))) {
        break label1019;
      }
    }
    label947:
    label953:
    label959:
    label965:
    label977:
    label983:
    label989:
    label995:
    label1001:
    label1007:
    label1013:
    label1019:
    for (bool1 = true;; bool1 = false)
    {
      paramActionMode = paramMenu.findItem(2131755302);
      if (paramActionMode != null) {
        paramActionMode.setVisible(bool1);
      }
      return true;
      bool1 = false;
      break;
      bool1 = false;
      break label324;
      bool2 = false;
      break label402;
      bool1 = false;
      break label500;
      paramActionMode.setVisible(bool1);
      break label507;
      bool1 = false;
      break label594;
      bool1 = false;
      break label645;
      bool1 = false;
      break label696;
      bool1 = false;
      break label752;
      bool1 = false;
      break label792;
      bool1 = false;
      break label832;
      bool1 = false;
      break label863;
    }
  }
  
  public void onSetChanged(ConversationSelectionSet paramConversationSelectionSet)
  {
    if (paramConversationSelectionSet.isEmpty()) {
      return;
    }
    updateCount();
  }
  
  public void onSetEmpty()
  {
    LogUtils.d(LOG_TAG, "onSetEmpty called.", new Object[0]);
    destroy();
  }
  
  public void onSetPopulated(ConversationSelectionSet paramConversationSelectionSet) {}
}

/* Location:
 * Qualified Name:     com.android.mail.browse.SelectedConversationsActionMenu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */