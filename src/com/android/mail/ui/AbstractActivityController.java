package com.android.mail.ui;

import android.app.ActionBar;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.CursorLoader;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.Loader;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.provider.SearchRecentSuggestions;
import android.text.TextUtils;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.Toast;
import com.android.mail.ConversationListContext;
import com.android.mail.browse.ConversationCursor;
import com.android.mail.browse.ConversationItemView;
import com.android.mail.browse.ConversationItemViewModel;
import com.android.mail.browse.ConversationPagerController;
import com.android.mail.browse.MessageCursor.ConversationMessage;
import com.android.mail.browse.SelectedConversationsActionMenu;
import com.android.mail.browse.SyncErrorDialogFragment;
import com.android.mail.compose.ComposeActivity;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.ConversationInfo;
import com.android.mail.providers.Folder;
import com.android.mail.providers.MailAppProvider;
import com.android.mail.providers.Message;
import com.android.mail.providers.Settings;
import com.android.mail.providers.UIProvider;
import com.android.mail.providers.UIProvider.ConversationColumns;
import com.android.mail.providers.UIProvider.MessageColumns;
import com.android.mail.utils.ContentProviderTask;
import com.android.mail.utils.ContentProviderTask.Result;
import com.android.mail.utils.ContentProviderTask.UpdateTask;
import com.android.mail.utils.LogTag;
import com.android.mail.utils.LogUtils;
import com.android.mail.utils.Utils;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TimerTask;

public abstract class AbstractActivityController
  implements ActivityController
{
  protected static final String LOG_TAG = ;
  protected boolean isLoaderInitialized = false;
  protected com.android.mail.providers.Account mAccount;
  private final DataSetObservable mAccountObservers = new DataSetObservable()
  {
    public void registerObserver(DataSetObserver paramAnonymousDataSetObserver)
    {
      int i = mObservers.size();
      super.registerObserver(paramAnonymousDataSetObserver);
      LogUtils.d(AbstractActivityController.LOG_TAG, "IN AAC.register(Account)Observer: %s before=%d after=%d", new Object[] { paramAnonymousDataSetObserver, Integer.valueOf(i), Integer.valueOf(mObservers.size()) });
    }
    
    public void unregisterObserver(DataSetObserver paramAnonymousDataSetObserver)
    {
      int i = mObservers.size();
      super.unregisterObserver(paramAnonymousDataSetObserver);
      LogUtils.d(AbstractActivityController.LOG_TAG, "IN AAC.unregister(Account)Observer: %s before=%d after=%d", new Object[] { paramAnonymousDataSetObserver, Integer.valueOf(i), Integer.valueOf(mObservers.size()) });
    }
  };
  protected MailActionBarView mActionBarView;
  protected final ControllableActivity mActivity;
  private AsyncRefreshTask mAsyncRefreshTask;
  SelectedConversationsActionMenu mCabActionMenu;
  protected final Context mContext;
  protected ConversationListContext mConvListContext;
  protected ConversationCursor mConversationListCursor;
  private final DataSetObservable mConversationListObservable = new DataSetObservable()
  {
    public void registerObserver(DataSetObserver paramAnonymousDataSetObserver)
    {
      int i = mObservers.size();
      super.registerObserver(paramAnonymousDataSetObserver);
      LogUtils.d(AbstractActivityController.LOG_TAG, "IN AAC.register(List)Observer: %s before=%d after=%d", new Object[] { paramAnonymousDataSetObserver, Integer.valueOf(i), Integer.valueOf(mObservers.size()) });
    }
    
    public void unregisterObserver(DataSetObserver paramAnonymousDataSetObserver)
    {
      int i = mObservers.size();
      super.unregisterObserver(paramAnonymousDataSetObserver);
      LogUtils.d(AbstractActivityController.LOG_TAG, "IN AAC.unregister(List)Observer: %s before=%d after=%d", new Object[] { paramAnonymousDataSetObserver, Integer.valueOf(i), Integer.valueOf(mObservers.size()) });
    }
  };
  private RefreshTimerTask mConversationListRefreshTask;
  private final Set<Uri> mCurrentAccountUris = Sets.newHashSet();
  protected Conversation mCurrentConversation;
  private boolean mDestroyed;
  private AsyncTask<String, Void, Void> mEnableShareIntents;
  protected Folder mFolder;
  private boolean mFolderChanged = false;
  private final int mFolderItemUpdateDelayMs;
  private Folder mFolderListFolder;
  private final DataSetObservable mFolderObservable = new DataSetObservable();
  protected AsyncRefreshTask mFolderSyncTask;
  private final FragmentManager mFragmentManager;
  protected Handler mHandler = new Handler();
  private boolean mIsDragHappening;
  private final ConversationListLoaderCallbacks mListCursorCallbacks = new ConversationListLoaderCallbacks(null);
  private SuppressNotificationReceiver mNewEmailReceiver = null;
  protected ConversationPagerController mPagerController;
  private DestructiveAction mPendingDestruction;
  protected final RecentFolderList mRecentFolderList;
  private final DataSetObservable mRecentFolderObservers = new DataSetObservable()
  {
    public void registerObserver(DataSetObserver paramAnonymousDataSetObserver)
    {
      int i = mObservers.size();
      super.registerObserver(paramAnonymousDataSetObserver);
      LogUtils.d(AbstractActivityController.LOG_TAG, "IN AAC.register(RecentFolder)Observer: %s before=%d after=%d", new Object[] { paramAnonymousDataSetObserver, Integer.valueOf(i), Integer.valueOf(mObservers.size()) });
    }
    
    public void unregisterObserver(DataSetObserver paramAnonymousDataSetObserver)
    {
      int i = mObservers.size();
      super.unregisterObserver(paramAnonymousDataSetObserver);
      LogUtils.d(AbstractActivityController.LOG_TAG, "IN AAC.unregister(RecentFolder)Observer: %s before=%d after=%d", new Object[] { paramAnonymousDataSetObserver, Integer.valueOf(i), Integer.valueOf(mObservers.size()) });
    }
  };
  private boolean mRecentsDataUpdated;
  protected ContentResolver mResolver;
  private boolean mSafeToModifyFragments = true;
  private final ConversationSelectionSet mSelectedSet = new ConversationSelectionSet();
  private int mShowUndoBarDelay;
  protected ActionableToastBar mToastBar;
  protected final ConversationPositionTracker mTracker;
  protected final ViewMode mViewMode;
  
  public AbstractActivityController(MailActivity paramMailActivity, ViewMode paramViewMode)
  {
    mActivity = paramMailActivity;
    mFragmentManager = mActivity.getFragmentManager();
    mViewMode = paramViewMode;
    mContext = paramMailActivity.getApplicationContext();
    mRecentFolderList = new RecentFolderList(mContext);
    mTracker = new ConversationPositionTracker(this);
    mSelectedSet.addObserver(this);
    mFolderItemUpdateDelayMs = mContext.getResources().getInteger(2131361825);
    mShowUndoBarDelay = mContext.getResources().getInteger(2131361826);
  }
  
  private boolean accountsUpdated(Cursor paramCursor)
  {
    if ((mAccount == null) || (!paramCursor.moveToFirst())) {}
    int j;
    do
    {
      do
      {
        return true;
      } while (mCurrentAccountUris.size() != paramCursor.getCount());
      int i = 0;
      do
      {
        Uri localUri = Uri.parse(paramCursor.getString(3));
        j = i;
        if (i == 0)
        {
          j = i;
          if (mAccount.uri.equals(localUri)) {
            j = 1;
          }
        }
        if (!mCurrentAccountUris.contains(localUri)) {
          break;
        }
        i = j;
      } while (paramCursor.moveToNext());
    } while (j == 0);
    return false;
  }
  
  private void attachActionBar()
  {
    ActionBar localActionBar = mActivity.getActionBar();
    if ((localActionBar != null) && (mActionBarView != null))
    {
      localActionBar.setCustomView(mActionBarView, new ActionBar.LayoutParams(-1, -1));
      localActionBar.setDisplayOptions(18, 26);
      mActionBarView.attach();
    }
    mViewMode.addListener(mActionBarView);
  }
  
  private void cancelRefreshTask()
  {
    if (mConversationListRefreshTask != null)
    {
      mConversationListRefreshTask.cancel();
      mConversationListRefreshTask = null;
    }
  }
  
  private void changeFolder(Folder paramFolder, String paramString)
  {
    if (!Objects.equal(mFolder, paramFolder)) {
      commitDestructiveActions(false);
    }
    if (((paramFolder != null) && (!paramFolder.equals(mFolder))) || (mViewMode.getMode() != 2))
    {
      setListContext(paramFolder, paramString);
      showConversationList(mConvListContext);
    }
  }
  
  private final void destroyPending(DestructiveAction paramDestructiveAction)
  {
    if (mPendingDestruction != null) {
      mPendingDestruction.performAction();
    }
    mPendingDestruction = paramDestructiveAction;
  }
  
  private void disableNotifications()
  {
    mNewEmailReceiver.activate(mContext, this);
  }
  
  private void disableNotificationsOnAccountChange(com.android.mail.providers.Account paramAccount)
  {
    if ((mNewEmailReceiver.activated()) && (!mNewEmailReceiver.notificationsDisabledForAccount(paramAccount)))
    {
      mNewEmailReceiver.deactivate();
      mNewEmailReceiver.activate(mContext, this);
    }
  }
  
  private void enableNotifications()
  {
    mNewEmailReceiver.deactivate();
  }
  
  private void fetchSearchFolder(Intent paramIntent)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("query", paramIntent.getStringExtra("query"));
    mActivity.getLoaderManager().restartLoader(6, localBundle, this);
  }
  
  private ActionableToastBar.ActionClickedListener getInternalErrorClickedListener()
  {
    new ActionableToastBar.ActionClickedListener()
    {
      public void onActionClicked()
      {
        Utils.sendFeedback(mActivity.getActivityContext(), mAccount, true);
      }
    };
  }
  
  private ActionableToastBar.ActionClickedListener getRetryClickedListener(final Folder paramFolder)
  {
    new ActionableToastBar.ActionClickedListener()
    {
      public void onActionClicked()
      {
        Uri localUri = paramFolderrefreshUri;
        if (localUri != null) {
          AbstractActivityController.this.startAsyncRefreshTask(localUri);
        }
      }
    };
  }
  
  private ActionableToastBar.ActionClickedListener getSignInClickedListener()
  {
    new ActionableToastBar.ActionClickedListener()
    {
      public void onActionClicked()
      {
        AbstractActivityController.this.promptUserForAuthentication(mAccount);
      }
    };
  }
  
  private ActionableToastBar.ActionClickedListener getStorageErrorClickedListener()
  {
    new ActionableToastBar.ActionClickedListener()
    {
      public void onActionClicked()
      {
        AbstractActivityController.this.showStorageErrorDialog();
      }
    };
  }
  
  private void handleIntent(Intent paramIntent)
  {
    Object localObject = null;
    boolean bool;
    if ("android.intent.action.VIEW".equals(paramIntent.getAction()))
    {
      if (paramIntent.hasExtra("account")) {
        setAccount(com.android.mail.providers.Account.newinstance(paramIntent.getStringExtra("account")));
      }
      if (mAccount == null) {
        return;
      }
      bool = paramIntent.hasExtra("conversationUri");
      if ((bool) && (mViewMode.getMode() == 0))
      {
        mViewMode.enterConversationMode();
        if (paramIntent.hasExtra("folder")) {
          localObject = Folder.fromString(paramIntent.getStringExtra("folder"));
        }
        if (localObject == null) {
          break label359;
        }
        onFolderChanged((Folder)localObject);
      }
    }
    label357:
    label359:
    for (int i = 1;; i = 0)
    {
      if (bool)
      {
        LogUtils.d(LOG_TAG, "SHOW THE CONVERSATION at %s", new Object[] { paramIntent.getParcelableExtra("conversationUri") });
        paramIntent = (Conversation)paramIntent.getParcelableExtra("conversationUri");
        if ((paramIntent != null) && (position < 0)) {
          position = 0;
        }
        showConversation(paramIntent);
        i = 1;
      }
      if (i == 0) {
        loadAccountInbox();
      }
      for (;;)
      {
        if (mAccount == null) {
          break label357;
        }
        restartOptionalLoader(7);
        return;
        mViewMode.enterConversationListMode();
        break;
        if ("android.intent.action.SEARCH".equals(paramIntent.getAction()))
        {
          if (paramIntent.hasExtra("account"))
          {
            localObject = paramIntent.getStringExtra("query");
            String str = mContext.getString(2131492882);
            new SearchRecentSuggestions(mContext, str, 1).saveRecentQuery((String)localObject, null);
            if (Utils.showTwoPaneSearchResults(mActivity.getActivityContext())) {
              mViewMode.enterSearchResultsConversationMode();
            }
            for (;;)
            {
              setAccount((com.android.mail.providers.Account)paramIntent.getParcelableExtra("account"));
              restartOptionalLoader(3);
              fetchSearchFolder(paramIntent);
              break;
              mViewMode.enterSearchResultsListMode();
            }
          }
          LogUtils.e(LOG_TAG, "Missing account extra from search intent.  Finishing", new Object[0]);
          mActivity.finish();
        }
      }
      break;
    }
  }
  
  private void initializeActionBar()
  {
    ActionBar localActionBar = mActivity.getActionBar();
    if (localActionBar == null) {
      return;
    }
    LayoutInflater localLayoutInflater = LayoutInflater.from(localActionBar.getThemedContext());
    if ((mActivity.getIntent() != null) && ("android.intent.action.SEARCH".equals(mActivity.getIntent().getAction())))
    {
      i = 1;
      if (i == 0) {
        break label106;
      }
    }
    label106:
    for (int i = 2130968676;; i = 2130968588)
    {
      mActionBarView = ((MailActionBarView)localLayoutInflater.inflate(i, null));
      mActionBarView.initialize(mActivity, this, mViewMode, localActionBar, mRecentFolderList);
      return;
      i = 0;
      break;
    }
  }
  
  private boolean isDragging()
  {
    return mIsDragHappening;
  }
  
  private static final boolean isValidFragment(Fragment paramFragment)
  {
    return (paramFragment != null) && (paramFragment.getActivity() != null) && (paramFragment.getView() != null);
  }
  
  private void loadRecentFolders(Cursor paramCursor)
  {
    mRecentFolderList.loadFromUiProvider(paramCursor);
    if (isAnimating())
    {
      mRecentsDataUpdated = true;
      return;
    }
    mRecentFolderObservers.notifyChanged();
  }
  
  private void markConversationsRead(Collection<Conversation> paramCollection, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramBoolean3) && (!paramBoolean1)) {
      showNextConversation(paramCollection);
    }
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Conversation localConversation = (Conversation)paramCollection.next();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put(UIProvider.ConversationColumns.READ, Boolean.valueOf(paramBoolean1));
      if (paramBoolean2) {
        localContentValues.put("viewed", Boolean.valueOf(true));
      }
      ConversationInfo localConversationInfo = conversationInfo;
      if ((localConversationInfo != null) && (localConversationInfo.markRead(paramBoolean1))) {
        localContentValues.put("conversationInfo", ConversationInfo.toString(localConversationInfo));
      }
      localArrayList.add(mConversationListCursor.getOperationForConversation(localConversation, 2, localContentValues));
      read = paramBoolean1;
      if (paramBoolean2) {
        localConversation.markViewed();
      }
    }
    mConversationListCursor.updateBulkValues(mContext, localArrayList);
  }
  
  private void promptUserForAuthentication(com.android.mail.providers.Account paramAccount)
  {
    if ((paramAccount != null) && (!Utils.isEmpty(reauthenticationIntentUri)))
    {
      paramAccount = new Intent("android.intent.action.VIEW", reauthenticationIntentUri);
      mActivity.startActivityForResult(paramAccount, 2);
    }
  }
  
  private final void registerDestructiveAction(DestructiveAction paramDestructiveAction)
  {
    destroyPending(paramDestructiveAction);
  }
  
  private void requestFolderRefresh()
  {
    if (mFolder != null)
    {
      if (mAsyncRefreshTask != null) {
        mAsyncRefreshTask.cancel(true);
      }
      mAsyncRefreshTask = new AsyncRefreshTask(mContext, mFolder.refreshUri);
      mAsyncRefreshTask.execute(new Void[0]);
    }
  }
  
  private void requestUpdate(Collection<Conversation> paramCollection, DestructiveAction paramDestructiveAction)
  {
    paramDestructiveAction.performAction();
    refreshConversationList();
  }
  
  private void restartOptionalLoader(int paramInt)
  {
    LoaderManager localLoaderManager = mActivity.getLoaderManager();
    localLoaderManager.destroyLoader(paramInt);
    localLoaderManager.restartLoader(paramInt, Bundle.EMPTY, this);
  }
  
  private final void restoreSelectedConversations(Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      mSelectedSet.clear();
      return;
    }
    paramBundle = (ConversationSelectionSet)paramBundle.getParcelable("saved-selected-set");
    if ((paramBundle == null) || (paramBundle.isEmpty()))
    {
      mSelectedSet.clear();
      return;
    }
    mSelectedSet.putAll(paramBundle);
  }
  
  private void setAccount(com.android.mail.providers.Account paramAccount)
  {
    if (paramAccount == null)
    {
      LogUtils.w(LOG_TAG, new Error(), "AAC ignoring null (presumably invalid) account restoration", new Object[0]);
      return;
    }
    LogUtils.d(LOG_TAG, "AbstractActivityController.setAccount(): account = %s", new Object[] { uri });
    mAccount = paramAccount;
    restartOptionalLoader(3);
    mActivity.invalidateOptionsMenu();
    disableNotificationsOnAccountChange(mAccount);
    restartOptionalLoader(7);
    MailAppProvider.getInstance().setLastViewedAccount(mAccount.uri.toString());
    if (settings == null)
    {
      LogUtils.w(LOG_TAG, new Error(), "AAC ignoring account with null settings.", new Object[0]);
      return;
    }
    mAccountObservers.notifyChanged();
  }
  
  private final void setHasFolderChanged(Folder paramFolder)
  {
    if (paramFolder == null) {}
    while ((mFolder != null) && (uri.equals(mFolder.uri))) {
      return;
    }
    mFolderChanged = true;
  }
  
  private void setListContext(Folder paramFolder, String paramString)
  {
    updateFolder(paramFolder);
    if (paramString != null) {}
    for (mConvListContext = ConversationListContext.forSearchQuery(mAccount, mFolder, paramString);; mConvListContext = ConversationListContext.forFolder(mAccount, mFolder))
    {
      cancelRefreshTask();
      return;
    }
  }
  
  private final void showConversation(Conversation paramConversation)
  {
    showConversation(paramConversation, false);
  }
  
  private void showStorageErrorDialog()
  {
    DialogFragment localDialogFragment = (DialogFragment)mFragmentManager.findFragmentByTag("SyncErrorDialogFragment");
    Object localObject = localDialogFragment;
    if (localDialogFragment == null) {
      localObject = SyncErrorDialogFragment.newInstance();
    }
    ((DialogFragment)localObject).show(mFragmentManager, "SyncErrorDialogFragment");
  }
  
  private void startAsyncRefreshTask(Uri paramUri)
  {
    if (mFolderSyncTask != null) {
      mFolderSyncTask.cancel(true);
    }
    mFolderSyncTask = new AsyncRefreshTask(mActivity.getActivityContext(), paramUri);
    mFolderSyncTask.execute(new Void[0]);
  }
  
  private void switchAccount(com.android.mail.providers.Account paramAccount, boolean paramBoolean)
  {
    mAccount = paramAccount;
    LogUtils.d(LOG_TAG, "AbstractActivityController.switchAccount(): mAccount = %s", new Object[] { mAccount.uri });
    cancelRefreshTask();
    mAccountObservers.notifyChanged();
    if (paramBoolean) {
      loadAccountInbox();
    }
    restartOptionalLoader(3);
    mActivity.invalidateOptionsMenu();
    disableNotificationsOnAccountChange(mAccount);
    restartOptionalLoader(7);
    MailAppProvider.getInstance().setLastViewedAccount(mAccount.uri.toString());
    if ((mAccount != null) && (!Uri.EMPTY.equals(mAccount.settings.setupIntentUri)))
    {
      paramAccount = new Intent("android.intent.action.EDIT");
      paramAccount.setData(mAccount.settings.setupIntentUri);
      mActivity.startActivity(paramAccount);
    }
  }
  
  private boolean updateAccounts(Cursor paramCursor)
  {
    if ((paramCursor == null) || (!paramCursor.moveToFirst())) {
      return false;
    }
    com.android.mail.providers.Account[] arrayOfAccount = com.android.mail.providers.Account.getAllAccounts(paramCursor);
    paramCursor = null;
    mCurrentAccountUris.clear();
    int j = arrayOfAccount.length;
    int i = 0;
    com.android.mail.providers.Account localAccount;
    if (i < j)
    {
      localAccount = arrayOfAccount[i];
      LogUtils.d(LOG_TAG, "updateAccounts(%s)", new Object[] { localAccount });
      mCurrentAccountUris.add(uri);
      if ((mAccount == null) || (!uri.equals(mAccount.uri))) {
        break label248;
      }
      paramCursor = localAccount;
    }
    label232:
    label240:
    label248:
    for (;;)
    {
      i += 1;
      break;
      localAccount = arrayOfAccount[0];
      if (paramCursor != null)
      {
        if (paramCursor.equals(mAccount)) {
          break label240;
        }
        i = 1;
      }
      for (;;)
      {
        if (i != 0) {
          onAccountChanged(paramCursor);
        }
        mActionBarView.setAccounts(arrayOfAccount);
        if (arrayOfAccount.length > 0)
        {
          return true;
          if (mAccount == null)
          {
            String str = MailAppProvider.getInstance().getLastViewedAccount();
            if (str != null)
            {
              j = arrayOfAccount.length;
              i = 0;
              for (;;)
              {
                if (i >= j) {
                  break label232;
                }
                paramCursor = arrayOfAccount[i];
                if (str.equals(uri.toString()))
                {
                  i = 1;
                  break;
                }
                i += 1;
              }
            }
          }
        }
        else
        {
          return false;
        }
        paramCursor = localAccount;
        i = 1;
        continue;
        paramCursor = localAccount;
        i = 0;
      }
    }
  }
  
  private final void updateConversationListFragment()
  {
    ConversationListFragment localConversationListFragment = getConversationListFragment();
    if (localConversationListFragment != null)
    {
      refreshConversationList();
      if (localConversationListFragment.isVisible()) {
        informCursorVisiblity(true);
      }
    }
  }
  
  private void updateFolder(Folder paramFolder)
  {
    if ((paramFolder == null) || (!paramFolder.isInitialized()))
    {
      LogUtils.e(LOG_TAG, new Error(), "AAC.setFolder(%s): Bad input", new Object[] { paramFolder });
      return;
    }
    if (paramFolder.equals(mFolder))
    {
      LogUtils.d(LOG_TAG, "AAC.setFolder(%s): Input matches mFolder", new Object[] { paramFolder });
      return;
    }
    int i;
    LoaderManager localLoaderManager;
    if (mFolder == null)
    {
      i = 1;
      LogUtils.d(LOG_TAG, "AbstractActivityController.setFolder(%s)", new Object[] { name });
      localLoaderManager = mActivity.getLoaderManager();
      setHasFolderChanged(paramFolder);
      mFolder = paramFolder;
      mActionBarView.setFolder(mFolder);
      if (localLoaderManager.getLoader(2) != null) {
        break label173;
      }
      localLoaderManager.initLoader(2, null, this);
    }
    for (;;)
    {
      if ((i == 0) && (localLoaderManager.getLoader(4) != null)) {
        break label184;
      }
      localLoaderManager.initLoader(4, null, mListCursorCallbacks);
      return;
      i = 0;
      break;
      label173:
      localLoaderManager.restartLoader(2, null, this);
    }
    label184:
    localLoaderManager.destroyLoader(4);
    localLoaderManager.initLoader(4, null, mListCursorCallbacks);
  }
  
  private void updateRecentFolderList()
  {
    if (mFolder != null) {
      mRecentFolderList.touchFolder(mFolder, mAccount);
    }
  }
  
  public final void assignFolder(Collection<FolderOperation> paramCollection, Collection<Conversation> paramCollection1, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((mFolder.supportsCapability(8)) && (FolderOperation.isDestructive(paramCollection, mFolder))) {}
    for (boolean bool = true;; bool = false)
    {
      LogUtils.d(LOG_TAG, "onFolderChangesCommit: isDestructive = %b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break;
      }
      Iterator localIterator = paramCollection1.iterator();
      while (localIterator.hasNext()) {
        nextlocalDeleteOnUpdate = true;
      }
    }
    if (bool)
    {
      delete(0, paramCollection1, getDeferredFolderChange(paramCollection1, paramCollection, bool, paramBoolean1, paramBoolean2));
      return;
    }
    requestUpdate(paramCollection1, getFolderChange(paramCollection1, paramCollection, bool, paramBoolean1, paramBoolean2));
  }
  
  public void commitDestructiveActions(boolean paramBoolean)
  {
    ConversationListFragment localConversationListFragment = getConversationListFragment();
    if (localConversationListFragment != null) {
      localConversationListFragment.commitDestructiveActions(paramBoolean);
    }
  }
  
  protected void confirmAndDelete(final Collection<Conversation> paramCollection, boolean paramBoolean, int paramInt, final DestructiveAction paramDestructiveAction)
  {
    if (paramBoolean)
    {
      paramDestructiveAction = new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          if (paramAnonymousInt == -1) {
            delete(0, paramCollection, paramDestructiveAction);
          }
        }
      };
      paramCollection = Utils.formatPlural(mContext, paramInt, paramCollection.size());
      new AlertDialog.Builder(mActivity.getActivityContext()).setMessage(paramCollection).setPositiveButton(2131493074, paramDestructiveAction).setNegativeButton(2131493075, null).create().show();
      return;
    }
    delete(0, paramCollection, paramDestructiveAction);
  }
  
  public void delete(int paramInt, Collection<Conversation> paramCollection, DestructiveAction paramDestructiveAction)
  {
    delete(paramInt, paramCollection, null, paramDestructiveAction);
  }
  
  public void delete(int paramInt, Collection<Conversation> paramCollection, Collection<ConversationItemView> paramCollection1, DestructiveAction paramDestructiveAction)
  {
    showNextConversation(paramCollection);
    ConversationListFragment localConversationListFragment = getConversationListFragment();
    if (localConversationListFragment != null)
    {
      LogUtils.d(LOG_TAG, "AAC.requestDelete: ListFragment is handling delete.", new Object[0]);
      localConversationListFragment.requestDelete(paramInt, paramCollection, paramCollection1, paramDestructiveAction);
      return;
    }
    paramDestructiveAction.performAction();
  }
  
  protected void disableCabMode()
  {
    commitDestructiveActions(true);
    if (mCabActionMenu != null) {
      mCabActionMenu.deactivate();
    }
  }
  
  public void disablePagerUpdates()
  {
    mPagerController.stopListening();
  }
  
  protected void enableCabMode()
  {
    if (mCabActionMenu != null) {
      mCabActionMenu.activate();
    }
  }
  
  protected final void exitCabMode()
  {
    mSelectedSet.clear();
  }
  
  public void exitSearchMode()
  {
    if (mViewMode.getMode() == 4) {
      mActivity.finish();
    }
  }
  
  public com.android.mail.providers.Account getAccount()
  {
    return mAccount;
  }
  
  public final DestructiveAction getBatchAction(int paramInt)
  {
    ConversationAction localConversationAction = new ConversationAction(paramInt, mSelectedSet.values(), true);
    registerDestructiveAction(localConversationAction);
    return localConversationAction;
  }
  
  public final ConversationCursor getConversationListCursor()
  {
    return mConversationListCursor;
  }
  
  protected ConversationListFragment getConversationListFragment()
  {
    Fragment localFragment = mFragmentManager.findFragmentByTag("tag-conversation-list");
    if (isValidFragment(localFragment)) {
      return (ConversationListFragment)localFragment;
    }
    return null;
  }
  
  public com.android.mail.providers.Account getCurrentAccount()
  {
    return mAccount;
  }
  
  public Conversation getCurrentConversation()
  {
    return mCurrentConversation;
  }
  
  public ConversationListContext getCurrentListContext()
  {
    return mConvListContext;
  }
  
  public DestructiveAction getDeferredAction(int paramInt, Collection<Conversation> paramCollection, boolean paramBoolean)
  {
    return new ConversationAction(paramInt, paramCollection, paramBoolean);
  }
  
  public final DestructiveAction getDeferredBatchAction(int paramInt)
  {
    return getDeferredAction(paramInt, mSelectedSet.values(), true);
  }
  
  public final DestructiveAction getDeferredFolderChange(Collection<Conversation> paramCollection, Collection<FolderOperation> paramCollection1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    return new FolderDestruction(paramCollection, paramCollection1, paramBoolean1, paramBoolean2, paramBoolean3, 2131755303, null);
  }
  
  public final DestructiveAction getDeferredRemoveFolder(Collection<Conversation> paramCollection, Folder paramFolder, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new FolderOperation(paramFolder, Boolean.valueOf(false)));
    return new FolderDestruction(paramCollection, localArrayList, paramBoolean1, paramBoolean2, paramBoolean3, 2131755300, null);
  }
  
  public Folder getFolder()
  {
    return mFolder;
  }
  
  public final DestructiveAction getFolderChange(Collection<Conversation> paramCollection, Collection<FolderOperation> paramCollection1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    paramCollection = getDeferredFolderChange(paramCollection, paramCollection1, paramBoolean1, paramBoolean2, paramBoolean3);
    registerDestructiveAction(paramCollection);
    return paramCollection;
  }
  
  protected FolderListFragment getFolderListFragment()
  {
    Fragment localFragment = mFragmentManager.findFragmentByTag("tag-folder-list");
    if (isValidFragment(localFragment)) {
      return (FolderListFragment)localFragment;
    }
    return null;
  }
  
  public String getHelpContext()
  {
    switch (mViewMode.getMode())
    {
    }
    for (int i = 2131492877;; i = 2131492876) {
      return mContext.getString(i);
    }
  }
  
  public Folder getHierarchyFolder()
  {
    return mFolderListFolder;
  }
  
  public RecentFolderList getRecentFolders()
  {
    return mRecentFolderList;
  }
  
  public ConversationSelectionSet getSelectedSet()
  {
    return mSelectedSet;
  }
  
  public SubjectDisplayChanger getSubjectDisplayChanger()
  {
    return mActionBarView;
  }
  
  protected final ActionableToastBar.ActionClickedListener getUndoClickedListener(final AnimatedAdapter paramAnimatedAdapter)
  {
    new ActionableToastBar.ActionClickedListener()
    {
      public void onActionClicked()
      {
        if (mAccount.undoUri != null)
        {
          if (mConversationListCursor != null) {
            mConversationListCursor.undo(mActivity.getActivityContext(), mAccount.undoUri);
          }
          if (paramAnimatedAdapter != null) {
            paramAnimatedAdapter.setUndo(true);
          }
        }
      }
    };
  }
  
  public void handleDrop(DragEvent paramDragEvent, Folder paramFolder)
  {
    if (!supportsDrag(paramDragEvent, paramFolder)) {
      return;
    }
    paramDragEvent = mSelectedSet.values();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new FolderOperation(paramFolder, Boolean.valueOf(true)));
    if ((!mFolder.isViewAll()) && (mFolder.supportsCapability(8))) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        localArrayList.add(new FolderOperation(mFolder, Boolean.valueOf(false)));
      }
      paramFolder = getFolderChange(paramDragEvent, localArrayList, bool, true, true);
      if (!bool) {
        break;
      }
      delete(0, paramDragEvent, paramFolder);
      return;
    }
    paramFolder.performAction();
  }
  
  public void hideWaitForInitialization() {}
  
  public boolean inWaitMode()
  {
    WaitFragment localWaitFragment = (WaitFragment)mActivity.getFragmentManager().findFragmentByTag("wait-fragment");
    if (localWaitFragment != null) {
      return (getAccounturi.equals(mAccount.uri)) && (mViewMode.getMode() == 6);
    }
    return false;
  }
  
  protected void informCursorVisiblity(boolean paramBoolean)
  {
    try
    {
      if (mConversationListCursor != null)
      {
        Utils.setConversationCursorVisibility(mConversationListCursor, paramBoolean, mFolderChanged);
        mFolderChanged = false;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean isAnimating()
  {
    boolean bool2 = false;
    Object localObject = getConversationListFragment();
    boolean bool1 = bool2;
    if (localObject != null)
    {
      localObject = ((ConversationListFragment)localObject).getAnimatedAdapter();
      bool1 = bool2;
      if (localObject != null) {
        bool1 = ((AnimatedAdapter)localObject).isAnimating();
      }
    }
    return bool1;
  }
  
  protected abstract boolean isConversationListVisible();
  
  public boolean isDestroyed()
  {
    return mDestroyed;
  }
  
  public boolean isInitialConversationLoading()
  {
    return mPagerController.isInitialConversationLoading();
  }
  
  public void loadAccountInbox()
  {
    restartOptionalLoader(5);
  }
  
  public void markConversationMessagesUnread(Conversation paramConversation, Set<Uri> paramSet, String paramString)
  {
    int j = 1;
    showConversation(null);
    read = false;
    if (mConversationListCursor == null)
    {
      LogUtils.e(LOG_TAG, "null ConversationCursor in markConversationMessagesUnread", new Object[0]);
      return;
    }
    if (paramSet == null)
    {
      i = 0;
      int k = paramConversation.getNumMessages();
      if ((k <= 1) || (i <= 0) || (i >= k)) {
        break label98;
      }
    }
    label98:
    for (int i = j;; i = 0)
    {
      if (i != 0) {
        break label104;
      }
      markConversationsRead(Collections.singletonList(paramConversation), false, false, false);
      return;
      i = paramSet.size();
      break;
    }
    label104:
    mConversationListCursor.setConversationColumn(uri, UIProvider.ConversationColumns.READ, Integer.valueOf(0));
    if (paramString != null) {
      mConversationListCursor.setConversationColumn(uri, "conversationInfo", paramString);
    }
    paramString = Lists.newArrayList();
    paramConversation = null;
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
    {
      Uri localUri = (Uri)localIterator.next();
      paramSet = paramConversation;
      if (paramConversation == null) {
        paramSet = localUri.getAuthority();
      }
      paramString.add(ContentProviderOperation.newUpdate(localUri).withValue(UIProvider.MessageColumns.READ, Integer.valueOf(0)).build());
      paramConversation = paramSet;
    }
    new ContentProviderTask()
    {
      protected void onPostExecute(ContentProviderTask.Result paramAnonymousResult) {}
    }.run(mResolver, paramConversation, paramString);
  }
  
  public void markConversationsRead(Collection<Conversation> paramCollection, boolean paramBoolean1, boolean paramBoolean2)
  {
    markConversationsRead(paramCollection, paramBoolean1, paramBoolean2, true);
  }
  
  public void onAccessibilityStateChanged()
  {
    ConversationItemViewModel.onAccessibilityUpdated();
    Object localObject = getConversationListFragment();
    if (localObject != null)
    {
      localObject = ((ConversationListFragment)localObject).getAnimatedAdapter();
      if (localObject != null) {
        ((AnimatedAdapter)localObject).notifyDataSetInvalidated();
      }
    }
  }
  
  public void onAccountChanged(com.android.mail.providers.Account paramAccount)
  {
    boolean bool1;
    boolean bool2;
    if (mAccount == null)
    {
      bool1 = true;
      LogUtils.d(LOG_TAG, "onAccountChanged (%s) called. firstLoad=%s", new Object[] { paramAccount, Boolean.valueOf(bool1) });
      if ((!bool1) && (uri.equals(mAccount.uri))) {
        break label141;
      }
      bool2 = true;
      label58:
      if ((!bool1) && (settings.equals(mAccount.settings))) {
        break label147;
      }
    }
    label141:
    label147:
    for (int i = 1;; i = 0)
    {
      if ((bool2) || (i != 0))
      {
        if (paramAccount != null)
        {
          final String str = name;
          mHandler.post(new Runnable()
          {
            public void run()
            {
              MailActivity.setForegroundNdef(MailActivity.getMailtoNdef(str));
            }
          });
        }
        if (bool2) {
          commitDestructiveActions(false);
        }
        switchAccount(paramAccount, bool2);
      }
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label58;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    paramIntent = null;
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        return;
        if (paramInt2 == -1)
        {
          mActivity.getLoaderManager().initLoader(0, null, this);
          return;
        }
        mActivity.finish();
        return;
      } while (paramInt2 != -1);
      if (mFolder != null) {
        paramIntent = mFolder.refreshUri;
      }
    } while (paramIntent == null);
    startAsyncRefreshTask(paramIntent);
  }
  
  public void onAnimationEnd(AnimatedAdapter paramAnimatedAdapter)
  {
    if (mConversationListCursor == null) {
      LogUtils.e(LOG_TAG, "null ConversationCursor in onAnimationEnd", new Object[0]);
    }
    do
    {
      return;
      if (mConversationListCursor.isRefreshReady())
      {
        LogUtils.d(LOG_TAG, "Stopped animating: try sync", new Object[0]);
        onRefreshReady();
      }
      if (mConversationListCursor.isRefreshRequired())
      {
        LogUtils.d(LOG_TAG, "Stopped animating: refresh", new Object[0]);
        mConversationListCursor.refresh();
      }
      if (mRecentsDataUpdated)
      {
        mRecentsDataUpdated = false;
        mRecentFolderObservers.notifyChanged();
      }
      paramAnimatedAdapter = getFolderListFragment();
    } while (paramAnimatedAdapter == null);
    paramAnimatedAdapter.onAnimationEnd();
  }
  
  public void onConversationListVisibilityChanged(boolean paramBoolean)
  {
    informCursorVisiblity(paramBoolean);
  }
  
  public void onConversationSeen(Conversation paramConversation)
  {
    mPagerController.onConversationSeen(paramConversation);
  }
  
  public final void onConversationSelected(Conversation paramConversation, boolean paramBoolean)
  {
    commitDestructiveActions(Utils.useTabletUI(mContext));
    showConversation(paramConversation, paramBoolean);
  }
  
  public void onConversationVisibilityChanged(boolean paramBoolean) {}
  
  public boolean onCreate(Bundle paramBundle)
  {
    initializeActionBar();
    mActivity.setDefaultKeyMode(2);
    mResolver = mActivity.getContentResolver();
    mNewEmailReceiver = new SuppressNotificationReceiver();
    mRecentFolderList.initialize(mActivity);
    mViewMode.addListener(this);
    mPagerController = new ConversationPagerController(mActivity, this);
    mToastBar = ((ActionableToastBar)mActivity.findViewById(2131755217));
    attachActionBar();
    FolderSelectionDialog.setDialogDismissed();
    Intent localIntent = mActivity.getIntent();
    if (paramBundle != null)
    {
      if (paramBundle.containsKey("saved-account")) {
        setAccount((com.android.mail.providers.Account)paramBundle.getParcelable("saved-account"));
      }
      if (paramBundle.containsKey("saved-folder")) {
        setListContext((Folder)paramBundle.getParcelable("saved-folder"), paramBundle.getString("saved-query", null));
      }
      mViewMode.handleRestore(paramBundle);
    }
    for (;;)
    {
      mActivity.getLoaderManager().initLoader(0, null, this);
      return true;
      if (localIntent != null) {
        handleIntent(localIntent);
      }
    }
  }
  
  public Dialog onCreateDialog(int paramInt, Bundle paramBundle)
  {
    return null;
  }
  
  public Loader<Cursor> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    case 1: 
    case 4: 
    default: 
      LogUtils.wtf(LOG_TAG, "Loader returned unexpected id: %d", new Object[] { Integer.valueOf(paramInt) });
    case 0: 
    case 2: 
    case 3: 
    case 5: 
      do
      {
        do
        {
          return null;
          return new CursorLoader(mContext, MailAppProvider.getAccountsUri(), UIProvider.ACCOUNTS_PROJECTION, null, null, null);
          paramBundle = new CursorLoader(mContext, mFolder.uri, UIProvider.FOLDERS_PROJECTION, null, null, null);
          paramBundle.setUpdateThrottle(mFolderItemUpdateDelayMs);
          return paramBundle;
        } while ((mAccount == null) || (mAccount.recentFolderListUri == null));
        return new CursorLoader(mContext, mAccount.recentFolderListUri, UIProvider.FOLDERS_PROJECTION, null, null, null);
        Uri localUri = Settings.getDefaultInboxUri(mAccount.settings);
        paramBundle = localUri;
        if (localUri.equals(Uri.EMPTY)) {
          paramBundle = mAccount.folderListUri;
        }
        LogUtils.d(LOG_TAG, "Loading the default inbox: %s", new Object[] { paramBundle });
      } while (paramBundle == null);
      return new CursorLoader(mContext, paramBundle, UIProvider.FOLDERS_PROJECTION, null, null, null);
    case 6: 
      return Folder.forSearchResults(mAccount, paramBundle.getString("query"), mActivity.getActivityContext());
    }
    return new CursorLoader(mContext, mAccount.uri, UIProvider.ACCOUNTS_PROJECTION, null, null, null);
  }
  
  public final boolean onCreateOptionsMenu(Menu paramMenu)
  {
    mActivity.getMenuInflater().inflate(mActionBarView.getOptionsMenuId(), paramMenu);
    mActionBarView.onCreateOptionsMenu(paramMenu);
    return true;
  }
  
  public final void onDataSetChanged()
  {
    updateConversationListFragment();
    mConversationListObservable.notifyChanged();
    mSelectedSet.validateAgainstCursor(mConversationListCursor);
  }
  
  public void onDestroy()
  {
    mPagerController.onDestroy();
    mActionBarView.onDestroy();
    mRecentFolderList.destroy();
    mDestroyed = true;
  }
  
  public void onFolderChanged(Folder paramFolder)
  {
    changeFolder(paramFolder, null);
  }
  
  public void onFolderSelected(Folder paramFolder)
  {
    onFolderChanged(paramFolder);
  }
  
  public void onFooterViewErrorActionClick(Folder paramFolder, int paramInt)
  {
    Object localObject2 = null;
    switch (paramInt)
    {
    case 3: 
    default: 
    case 1: 
      Object localObject1;
      do
      {
        return;
        localObject1 = localObject2;
        if (paramFolder != null)
        {
          localObject1 = localObject2;
          if (refreshUri != null) {
            localObject1 = refreshUri;
          }
        }
      } while (localObject1 == null);
      startAsyncRefreshTask((Uri)localObject1);
      return;
    case 2: 
      promptUserForAuthentication(mAccount);
      return;
    case 4: 
      showStorageErrorDialog();
      return;
    }
    Utils.sendFeedback(mActivity.getActivityContext(), mAccount, true);
  }
  
  public void onFooterViewLoadMoreClick(Folder paramFolder)
  {
    if ((paramFolder != null) && (loadMoreUri != null)) {
      startAsyncRefreshTask(loadMoreUri);
    }
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public void onLoadFinished(Loader<Cursor> paramLoader, Cursor paramCursor)
  {
    if (paramCursor == null) {
      LogUtils.e(LOG_TAG, "Received null cursor from loader id: %d", new Object[] { Integer.valueOf(paramLoader.getId()) });
    }
    switch (paramLoader.getId())
    {
    case 1: 
    case 4: 
    default: 
    case 0: 
    case 7: 
      boolean bool;
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
                for (;;)
                {
                  return;
                  if (paramCursor != null)
                  {
                    if (paramCursor.getCount() != 0) {
                      break;
                    }
                    if (paramCursor.getExtras().getInt("accounts_loaded") != 0) {}
                    for (int i = 1;; i = 0)
                    {
                      if (i == 0) {
                        break label142;
                      }
                      paramLoader = MailAppProvider.getNoAccountIntent(mContext);
                      if (paramLoader == null) {
                        break;
                      }
                      mActivity.startActivityForResult(paramLoader, 1);
                      return;
                    }
                  }
                }
                bool = accountsUpdated(paramCursor);
              } while ((isLoaderInitialized) && (!bool));
              isLoaderInitialized = updateAccounts(paramCursor);
              return;
            } while ((paramCursor == null) || (!paramCursor.moveToFirst()));
            paramLoader = new com.android.mail.providers.Account(paramCursor);
            if (!uri.equals(mAccount.uri)) {
              break;
            }
            paramCursor = mAccount.settings;
            mAccount = paramLoader;
            LogUtils.d(LOG_TAG, "AbstractActivityController.onLoadFinished(): mAccount = %s", new Object[] { mAccount.uri });
            if (!Objects.equal(mAccount.settings, paramCursor)) {
              mAccountObservers.notifyChanged();
            }
          } while (paramLoader.isAccountInitializationRequired());
          bool = inWaitMode();
          if ((paramLoader.isAccountSyncRequired()) && (!bool))
          {
            showWaitForInitialization();
            return;
          }
          if (paramLoader.isAccountSyncRequired()) {
            break;
          }
        } while (!bool);
        hideWaitForInitialization();
        return;
      } while ((!paramLoader.isAccountSyncRequired()) || (!bool));
      updateWaitMode();
      return;
      LogUtils.e(LOG_TAG, "Got update for account: %s with current account: %s", new Object[] { uri, mAccount.uri });
      restartOptionalLoader(7);
      return;
    case 2: 
      if ((paramCursor != null) && (paramCursor.moveToFirst()))
      {
        paramLoader = new Folder(paramCursor);
        LogUtils.d(LOG_TAG, "FOLDER STATUS = %d", new Object[] { Integer.valueOf(syncStatus) });
        setHasFolderChanged(paramLoader);
        mFolder = paramLoader;
        mFolderObservable.notifyChanged();
        return;
      }
      paramCursor = LOG_TAG;
      if (mFolder != null) {}
      for (paramLoader = mAccount.name;; paramLoader = "")
      {
        LogUtils.d(paramCursor, "Unable to get the folder %s", new Object[] { paramLoader });
        return;
      }
    case 3: 
      if ((paramCursor != null) && (paramCursor.getCount() <= 1) && (!Utils.useTabletUI(mContext)))
      {
        paramLoader = mAccount.defaultRecentFolderListUri;
        LogUtils.v(LOG_TAG, "Default recents at %s", new Object[] { paramLoader });
        new AsyncTask()
        {
          protected Void doInBackground(Uri... paramAnonymousVarArgs)
          {
            mContext.getContentResolver().update(paramAnonymousVarArgs[0], null, null, null);
            return null;
          }
        }.execute(new Uri[] { paramLoader });
        return;
      }
      LogUtils.v(LOG_TAG, "Reading recent folders from the cursor.", new Object[0]);
      loadRecentFolders(paramCursor);
      return;
    case 5: 
      label142:
      if ((paramCursor != null) && (!paramCursor.isClosed()) && (paramCursor.moveToFirst()))
      {
        onFolderChanged(new Folder(paramCursor));
        mActivity.getLoaderManager().destroyLoader(5);
        return;
      }
      paramCursor = LOG_TAG;
      if (mAccount != null) {}
      for (paramLoader = mAccount.name;; paramLoader = "")
      {
        LogUtils.d(paramCursor, "Unable to get the account inbox for account %s", new Object[] { paramLoader });
        return;
      }
    }
    if ((paramCursor != null) && (paramCursor.getCount() > 0))
    {
      paramCursor.moveToFirst();
      updateFolder(new Folder(paramCursor));
      mConvListContext = ConversationListContext.forSearchQuery(mAccount, mFolder, mActivity.getIntent().getStringExtra("query"));
      showConversationList(mConvListContext);
      mActivity.invalidateOptionsMenu();
      mActivity.getLoaderManager().destroyLoader(6);
      return;
    }
    LogUtils.e(LOG_TAG, "Null or empty cursor returned by LOADER_SEARCH loader", new Object[0]);
  }
  
  public void onLoaderReset(Loader<Cursor> paramLoader) {}
  
  public final boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int i = paramMenuItem.getItemId();
    LogUtils.d(LOG_TAG, "AbstractController.onOptionsItemSelected(%d) called.", new Object[] { Integer.valueOf(i) });
    boolean bool = true;
    Collection localCollection = Conversation.listOf(mCurrentConversation);
    if (mAccount == null)
    {
      paramMenuItem = null;
      commitDestructiveActions(true);
      switch (i)
      {
      default: 
        bool = false;
      }
    }
    for (;;)
    {
      return bool;
      paramMenuItem = mAccount.settings;
      break;
      if ((paramMenuItem != null) && (confirmArchive)) {}
      for (bool = true;; bool = false)
      {
        confirmAndDelete(localCollection, bool, 2131820548, getDeferredAction(2131755299, localCollection, false));
        return true;
      }
      delete(2131755300, localCollection, getDeferredRemoveFolder(localCollection, mFolder, true, false, true));
      return true;
      if ((paramMenuItem != null) && (confirmDelete)) {}
      for (bool = true;; bool = false)
      {
        confirmAndDelete(localCollection, bool, 2131820547, getDeferredAction(2131755301, localCollection, false));
        return true;
      }
      if ((paramMenuItem != null) && (confirmDelete)) {}
      for (bool = true;; bool = false)
      {
        confirmAndDelete(localCollection, bool, 2131820549, getDeferredAction(2131755302, localCollection, false));
        return true;
      }
      updateConversation(Conversation.listOf(mCurrentConversation), UIProvider.ConversationColumns.PRIORITY, 1);
      return true;
      if ((mFolder != null) && (mFolder.isImportantOnly()))
      {
        delete(2131755306, localCollection, getDeferredAction(2131755306, localCollection, false));
        return true;
      }
      updateConversation(Conversation.listOf(mCurrentConversation), UIProvider.ConversationColumns.PRIORITY, 0);
      return true;
      delete(2131755307, localCollection, getDeferredAction(2131755307, localCollection, false));
      return true;
      delete(2131755308, localCollection, getDeferredAction(2131755308, localCollection, false));
      return true;
      delete(2131755309, localCollection, getDeferredAction(2131755309, localCollection, false));
      return true;
      delete(2131755310, localCollection, getDeferredAction(2131755310, localCollection, false));
      return true;
      onUpPressed();
      return true;
      ComposeActivity.compose(mActivity.getActivityContext(), mAccount);
      return true;
      showFolderList();
      return true;
      requestFolderRefresh();
      return true;
      Utils.showSettings(mActivity.getActivityContext(), mAccount);
      return true;
      Utils.showFolderSettings(mActivity.getActivityContext(), mAccount, mFolder);
      return true;
      Utils.showHelp(mActivity.getActivityContext(), mAccount, getHelpContext());
      return true;
      Utils.sendFeedback(mActivity.getActivityContext(), mAccount, false);
      return true;
      Utils.showManageFolder(mActivity.getActivityContext(), mAccount);
      return true;
      if (mAccount.supportsCapability(8192)) {}
      for (paramMenuItem = MultiFoldersSelectionDialog.getInstance(mActivity.getActivityContext(), mAccount, this, Conversation.listOf(mCurrentConversation), false, mFolder); paramMenuItem != null; paramMenuItem = SingleFolderSelectionDialog.getInstance(mActivity.getActivityContext(), mAccount, this, Conversation.listOf(mCurrentConversation), false, mFolder))
      {
        paramMenuItem.show();
        return true;
      }
    }
  }
  
  public void onPause()
  {
    isLoaderInitialized = false;
    enableNotifications();
  }
  
  public void onPrepareDialog(int paramInt, Dialog paramDialog, Bundle paramBundle) {}
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    return mActionBarView.onPrepareOptionsMenu(paramMenu);
  }
  
  public final void onRefreshReady()
  {
    if (!isAnimating()) {
      mConversationListCursor.sync();
    }
    mTracker.onCursorUpdated();
  }
  
  public final void onRefreshRequired()
  {
    if ((isAnimating()) || (isDragging())) {
      LogUtils.d(LOG_TAG, "onRefreshRequired: delay until animating done", new Object[0]);
    }
    while (!mConversationListCursor.isRefreshRequired()) {
      return;
    }
    mConversationListCursor.refresh();
  }
  
  public void onRestart()
  {
    DialogFragment localDialogFragment = (DialogFragment)mFragmentManager.findFragmentByTag("SyncErrorDialogFragment");
    if (localDialogFragment != null) {
      localDialogFragment.dismiss();
    }
    if (mToastBar != null) {
      mToastBar.hide(false);
    }
  }
  
  public void onRestoreInstanceState(Bundle paramBundle)
  {
    LogUtils.d(LOG_TAG, "IN AAC.onRestoreInstanceState", new Object[0]);
    Object localObject;
    if (paramBundle.containsKey("saved-conversation"))
    {
      localObject = (Conversation)paramBundle.getParcelable("saved-conversation");
      if ((localObject != null) && (position < 0)) {
        position = 0;
      }
      showConversation((Conversation)localObject);
    }
    if (paramBundle.containsKey("saved-toast-bar-op"))
    {
      localObject = (ToastBarOperation)paramBundle.getParcelable("saved-toast-bar-op");
      if (localObject != null)
      {
        if (((ToastBarOperation)localObject).getType() != 0) {
          break label140;
        }
        onUndoAvailable((ToastBarOperation)localObject);
      }
    }
    for (;;)
    {
      localObject = paramBundle.getString("saved-hierarchical-folder", null);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        mFolderListFolder = Folder.fromString((String)localObject);
      }
      localObject = getConversationListFragment();
      if (localObject != null) {
        ((ConversationListFragment)localObject).getAnimatedAdapter().onRestoreInstanceState(paramBundle);
      }
      restoreSelectedConversations(paramBundle);
      return;
      label140:
      if (((ToastBarOperation)localObject).getType() == 1) {
        onError(mFolder, true);
      }
    }
  }
  
  public void onResume()
  {
    disableNotifications();
    mSafeToModifyFragments = true;
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    mViewMode.handleSaveInstanceState(paramBundle);
    if (mAccount != null)
    {
      LogUtils.d(LOG_TAG, "Saving the account now", new Object[0]);
      paramBundle.putParcelable("saved-account", mAccount);
    }
    if (mFolder != null) {
      paramBundle.putParcelable("saved-folder", mFolder);
    }
    if (ConversationListContext.isSearchResult(mConvListContext)) {
      paramBundle.putString("saved-query", mConvListContext.searchQuery);
    }
    if ((mCurrentConversation != null) && (mViewMode.isConversationMode())) {
      paramBundle.putParcelable("saved-conversation", mCurrentConversation);
    }
    if (!mSelectedSet.isEmpty()) {
      paramBundle.putParcelable("saved-selected-set", mSelectedSet);
    }
    if (mToastBar.getVisibility() == 0) {
      paramBundle.putParcelable("saved-toast-bar-op", mToastBar.getOperation());
    }
    Object localObject = getConversationListFragment();
    if (localObject != null) {
      ((ConversationListFragment)localObject).getAnimatedAdapter().onSaveInstanceState(paramBundle);
    }
    mSafeToModifyFragments = false;
    if (mFolderListFolder != null) {}
    for (localObject = Folder.toString(mFolderListFolder);; localObject = null)
    {
      paramBundle.putString("saved-hierarchical-folder", (String)localObject);
      return;
    }
  }
  
  public void onSearchRequested(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.SEARCH");
    localIntent.putExtra("query", paramString);
    localIntent.putExtra("account", mAccount);
    localIntent.setComponent(mActivity.getComponentName());
    mActionBarView.collapseSearch();
    mActivity.startActivity(localIntent);
  }
  
  public void onSetChanged(ConversationSelectionSet paramConversationSelectionSet) {}
  
  public void onSetEmpty() {}
  
  public void onSetPopulated(ConversationSelectionSet paramConversationSelectionSet)
  {
    ConversationListFragment localConversationListFragment = getConversationListFragment();
    if (localConversationListFragment == null) {
      return;
    }
    mCabActionMenu = new SelectedConversationsActionMenu(mActivity, paramConversationSelectionSet, mFolder, (SwipeableListView)localConversationListFragment.getListView());
    enableCabMode();
  }
  
  public void onStart()
  {
    mSafeToModifyFragments = true;
  }
  
  public void onStop()
  {
    if (mEnableShareIntents != null) {
      mEnableShareIntents.cancel(true);
    }
  }
  
  public void onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) && (mToastBar != null) && (!mToastBar.isEventInToastBar(paramMotionEvent))) {
      mToastBar.hide(true);
    }
  }
  
  public void onViewModeChanged(int paramInt)
  {
    if (!ViewMode.isConversationMode(paramInt)) {
      setCurrentConversation(null);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    ConversationListFragment localConversationListFragment = getConversationListFragment();
    if ((paramBoolean) && (localConversationListFragment != null) && (localConversationListFragment.isVisible())) {
      informCursorVisiblity(true);
    }
  }
  
  public final void refreshConversationList()
  {
    ConversationListFragment localConversationListFragment = getConversationListFragment();
    if (localConversationListFragment == null) {
      return;
    }
    localConversationListFragment.requestListRefresh();
  }
  
  public void registerAccountObserver(DataSetObserver paramDataSetObserver)
  {
    mAccountObservers.registerObserver(paramDataSetObserver);
  }
  
  public void registerConversationListObserver(DataSetObserver paramDataSetObserver)
  {
    mConversationListObservable.registerObserver(paramDataSetObserver);
  }
  
  public void registerConversationLoadedObserver(DataSetObserver paramDataSetObserver)
  {
    mPagerController.registerConversationLoadedObserver(paramDataSetObserver);
  }
  
  public void registerFolderObserver(DataSetObserver paramDataSetObserver)
  {
    mFolderObservable.registerObserver(paramDataSetObserver);
  }
  
  public void registerRecentFolderObserver(DataSetObserver paramDataSetObserver)
  {
    mRecentFolderObservers.registerObserver(paramDataSetObserver);
  }
  
  protected boolean safeToModifyFragments()
  {
    return mSafeToModifyFragments;
  }
  
  public void setCurrentConversation(Conversation paramConversation)
  {
    mTracker.initialize(mCurrentConversation);
    mCurrentConversation = paramConversation;
    if (mCurrentConversation != null)
    {
      mActionBarView.setCurrentConversation(mCurrentConversation);
      getSubjectDisplayChanger().setSubject(mCurrentConversation.subject);
      mActivity.invalidateOptionsMenu();
    }
  }
  
  public void setHierarchyFolder(Folder paramFolder)
  {
    mFolderListFolder = paramFolder;
  }
  
  protected void showConversation(Conversation paramConversation, boolean paramBoolean)
  {
    setCurrentConversation(paramConversation);
    updateRecentFolderList();
  }
  
  public void showConversationList(ConversationListContext paramConversationListContext) {}
  
  protected final void showErrorToast(Folder paramFolder, boolean paramBoolean)
  {
    mToastBar.setConversationMode(false);
    int j = lastSyncResult;
    int i;
    switch (j & 0xF)
    {
    case 3: 
    default: 
    case 1: 
      label88:
      do
      {
        return;
        int k = j >> 4;
        if ((k & 0x1) == 0) {
          break;
        }
        i = 1;
        if ((i != 0) || ((syncWindow <= 0) && ((k & 0x4) == 0))) {
          break label147;
        }
        i = 1;
      } while (i != 0);
      paramFolder = getRetryClickedListener(paramFolder);
      i = 2131492865;
    }
    for (;;)
    {
      mToastBar.show(paramFolder, 2130837550, Utils.getSyncStatusText(mActivity.getActivityContext(), j), false, i, paramBoolean, new ToastBarOperation(1, 0, 1, false));
      return;
      i = 0;
      break;
      label147:
      i = 0;
      break label88;
      paramFolder = getSignInClickedListener();
      i = 2131493109;
      continue;
      paramFolder = getStorageErrorClickedListener();
      i = 2131493110;
      continue;
      paramFolder = getInternalErrorClickedListener();
      i = 2131493111;
    }
  }
  
  public void showNextConversation(Collection<Conversation> paramCollection)
  {
    if ((mViewMode.getMode() == 1) && (Conversation.contains(paramCollection, mCurrentConversation))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramCollection = mTracker.getNextConversation(Settings.getAutoAdvanceSetting(mAccount.settings), paramCollection);
        LogUtils.d(LOG_TAG, "showNextConversation: showing %s next.", new Object[] { paramCollection });
        showConversation(paramCollection);
      }
      return;
    }
  }
  
  public void showWaitForInitialization()
  {
    mViewMode.enterWaitingForInitializationMode();
  }
  
  public void starMessage(MessageCursor.ConversationMessage paramConversationMessage, boolean paramBoolean)
  {
    int i = 1;
    if (starred == paramBoolean) {
      return;
    }
    starred = paramBoolean;
    boolean bool;
    ContentValues localContentValues;
    String str;
    if ((paramBoolean) || (paramConversationMessage.isConversationStarred()))
    {
      bool = true;
      if (bool != conversation.starred)
      {
        conversation.starred = bool;
        mConversationListCursor.setConversationColumn(conversation.uri, UIProvider.ConversationColumns.STARRED, Boolean.valueOf(bool));
      }
      localContentValues = new ContentValues(1);
      str = UIProvider.MessageColumns.STARRED;
      if (!paramBoolean) {
        break label133;
      }
    }
    for (;;)
    {
      localContentValues.put(str, Integer.valueOf(i));
      new ContentProviderTask.UpdateTask()
      {
        protected void onPostExecute(ContentProviderTask.Result paramAnonymousResult) {}
      }.run(mResolver, uri, localContentValues, null, null);
      return;
      bool = false;
      break;
      label133:
      i = 0;
    }
  }
  
  public void startDragMode()
  {
    mIsDragHappening = true;
  }
  
  public void startSearch()
  {
    if (mAccount == null)
    {
      LogUtils.d(LOG_TAG, "AbstractActivityController.startSearch(): null account", new Object[0]);
      return;
    }
    if ((mAccount.supportsCapability(2048) | mAccount.supportsCapability(32)))
    {
      onSearchRequested(mActionBarView.getQuery());
      return;
    }
    Toast.makeText(mActivity.getActivityContext(), mActivity.getActivityContext().getString(2131493028), 0).show();
  }
  
  public void stopDragMode()
  {
    mIsDragHappening = false;
    if (mConversationListCursor.isRefreshReady())
    {
      LogUtils.d(LOG_TAG, "Stopped animating: try sync", new Object[0]);
      onRefreshReady();
    }
    if (mConversationListCursor.isRefreshRequired())
    {
      LogUtils.d(LOG_TAG, "Stopped animating: refresh", new Object[0]);
      mConversationListCursor.refresh();
    }
  }
  
  public boolean supportsDrag(DragEvent paramDragEvent, Folder paramFolder)
  {
    return (paramFolder != null) && (paramDragEvent != null) && (paramDragEvent.getClipDescription() != null) && (paramFolder.supportsCapability(8)) && (paramFolder.supportsCapability(4)) && (!mFolder.uri.equals(uri));
  }
  
  public void unregisterAccountObserver(DataSetObserver paramDataSetObserver)
  {
    mAccountObservers.unregisterObserver(paramDataSetObserver);
  }
  
  public void unregisterConversationListObserver(DataSetObserver paramDataSetObserver)
  {
    mConversationListObservable.unregisterObserver(paramDataSetObserver);
  }
  
  public void unregisterConversationLoadedObserver(DataSetObserver paramDataSetObserver)
  {
    mPagerController.unregisterConversationLoadedObserver(paramDataSetObserver);
  }
  
  public void unregisterFolderObserver(DataSetObserver paramDataSetObserver)
  {
    mFolderObservable.unregisterObserver(paramDataSetObserver);
  }
  
  public void unregisterRecentFolderObserver(DataSetObserver paramDataSetObserver)
  {
    mRecentFolderObservers.unregisterObserver(paramDataSetObserver);
  }
  
  public void updateConversation(Collection<Conversation> paramCollection, String paramString, int paramInt)
  {
    mConversationListCursor.updateInt(mContext, paramCollection, paramString, paramInt);
    refreshConversationList();
  }
  
  public void updateConversation(Collection<Conversation> paramCollection, String paramString, boolean paramBoolean)
  {
    mConversationListCursor.updateBoolean(mContext, paramCollection, paramString, paramBoolean);
    refreshConversationList();
  }
  
  public void updateWaitMode()
  {
    WaitFragment localWaitFragment = (WaitFragment)mActivity.getFragmentManager().findFragmentByTag("wait-fragment");
    if (localWaitFragment != null) {
      localWaitFragment.updateAccount(mAccount);
    }
  }
  
  public class ConversationAction
    implements DestructiveAction
  {
    private final int mAction;
    private boolean mCompleted;
    private final boolean mIsSelectedSet;
    private final Collection<Conversation> mTarget;
    
    public ConversationAction(Collection<Conversation> paramCollection, boolean paramBoolean)
    {
      mAction = paramCollection;
      mTarget = ImmutableList.copyOf(paramBoolean);
      boolean bool;
      mIsSelectedSet = bool;
    }
    
    /* Error */
    private boolean isPerformed()
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore_1
      //   2: aload_0
      //   3: monitorenter
      //   4: aload_0
      //   5: getfield 53	com/android/mail/ui/AbstractActivityController$ConversationAction:mCompleted	Z
      //   8: istore_2
      //   9: iload_2
      //   10: ifeq +7 -> 17
      //   13: aload_0
      //   14: monitorexit
      //   15: iload_1
      //   16: ireturn
      //   17: aload_0
      //   18: iconst_1
      //   19: putfield 53	com/android/mail/ui/AbstractActivityController$ConversationAction:mCompleted	Z
      //   22: iconst_0
      //   23: istore_1
      //   24: goto -11 -> 13
      //   27: astore_3
      //   28: aload_0
      //   29: monitorexit
      //   30: aload_3
      //   31: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	32	0	this	ConversationAction
      //   1	23	1	bool1	boolean
      //   8	2	2	bool2	boolean
      //   27	4	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   4	9	27	finally
      //   17	22	27	finally
    }
    
    public void performAction()
    {
      if (isPerformed()) {
        return;
      }
      boolean bool2 = mAccount.supportsCapability(16384);
      if (LogUtils.isLoggable(AbstractActivityController.LOG_TAG, 3)) {
        LogUtils.d(AbstractActivityController.LOG_TAG, "ConversationAction.performAction():\nmTarget=%s\nCurrent=%s", new Object[] { Conversation.toString(mTarget), mCurrentConversation });
      }
      if (mConversationListCursor == null)
      {
        LogUtils.e(AbstractActivityController.LOG_TAG, "null ConversationCursor in ConversationAction.performAction():\nmTarget=%s\nCurrent=%s", new Object[] { Conversation.toString(mTarget), mCurrentConversation });
        return;
      }
      boolean bool1 = bool2;
      switch (mAction)
      {
      default: 
        bool1 = bool2;
      }
      for (;;)
      {
        if (bool1) {
          mHandler.postDelayed(new Runnable()
          {
            public void run()
            {
              onUndoAvailable(new ToastBarOperation(mTarget.size(), mAction, 0, mIsSelectedSet));
            }
          }, mShowUndoBarDelay);
        }
        refreshConversationList();
        if (!mIsSelectedSet) {
          break;
        }
        mSelectedSet.clear();
        return;
        LogUtils.d(AbstractActivityController.LOG_TAG, "Archiving", new Object[0]);
        mConversationListCursor.archive(mContext, mTarget);
        bool1 = bool2;
        continue;
        LogUtils.d(AbstractActivityController.LOG_TAG, "Deleting", new Object[0]);
        mConversationListCursor.delete(mContext, mTarget);
        bool1 = bool2;
        if (mFolder.supportsCapability(2048))
        {
          bool1 = false;
          continue;
          LogUtils.d(AbstractActivityController.LOG_TAG, "Muting", new Object[0]);
          Iterator localIterator;
          if (mFolder.supportsCapability(256))
          {
            localIterator = mTarget.iterator();
            while (localIterator.hasNext()) {
              nextlocalDeleteOnUpdate = true;
            }
          }
          mConversationListCursor.mute(mContext, mTarget);
          bool1 = bool2;
          continue;
          LogUtils.d(AbstractActivityController.LOG_TAG, "Reporting spam", new Object[0]);
          mConversationListCursor.reportSpam(mContext, mTarget);
          bool1 = bool2;
          continue;
          LogUtils.d(AbstractActivityController.LOG_TAG, "Marking not spam", new Object[0]);
          mConversationListCursor.reportNotSpam(mContext, mTarget);
          bool1 = bool2;
          continue;
          LogUtils.d(AbstractActivityController.LOG_TAG, "Reporting phishing", new Object[0]);
          mConversationListCursor.reportPhishing(mContext, mTarget);
          bool1 = bool2;
          continue;
          LogUtils.d(AbstractActivityController.LOG_TAG, "Removing star", new Object[0]);
          mConversationListCursor.updateBoolean(mContext, mTarget, UIProvider.ConversationColumns.STARRED, false);
          bool1 = bool2;
          continue;
          LogUtils.d(AbstractActivityController.LOG_TAG, "Marking not-important", new Object[0]);
          if ((mFolder != null) && (mFolder.isImportantOnly()))
          {
            localIterator = mTarget.iterator();
            while (localIterator.hasNext()) {
              nextlocalDeleteOnUpdate = true;
            }
          }
          mConversationListCursor.updateInt(mContext, mTarget, UIProvider.ConversationColumns.PRIORITY, 0);
          bool1 = bool2;
          continue;
          LogUtils.d(AbstractActivityController.LOG_TAG, "Discarding draft messages", new Object[0]);
          if ((mFolder != null) && (mFolder.isDraft()))
          {
            localIterator = mTarget.iterator();
            while (localIterator.hasNext()) {
              nextlocalDeleteOnUpdate = true;
            }
          }
          mConversationListCursor.discardDrafts(mContext, mTarget);
          bool1 = false;
        }
      }
    }
  }
  
  private class ConversationListLoaderCallbacks
    implements LoaderManager.LoaderCallbacks<ConversationCursor>
  {
    private ConversationListLoaderCallbacks() {}
    
    public Loader<ConversationCursor> onCreateLoader(int paramInt, Bundle paramBundle)
    {
      return new ConversationCursorLoader((Activity)mActivity, mAccount, mFolder.conversationListUri, mFolder.name);
    }
    
    public void onLoadFinished(Loader<ConversationCursor> paramLoader, ConversationCursor paramConversationCursor)
    {
      LogUtils.d(AbstractActivityController.LOG_TAG, "IN AAC.ConversationCursor.onLoadFinished, data=%s loader=%s", new Object[] { paramConversationCursor, paramLoader });
      AbstractActivityController.this.destroyPending(null);
      mConversationListCursor = paramConversationCursor;
      mConversationListCursor.addListener(AbstractActivityController.this);
      mTracker.onCursorUpdated();
      mConversationListObservable.notifyChanged();
      paramLoader = getConversationListFragment();
      if ((paramLoader != null) && (paramLoader.isVisible())) {
        informCursorVisiblity(true);
      }
      if ((shouldShowFirstConversation()) && (mConversationListCursor.getCount() > 0))
      {
        mConversationListCursor.moveToPosition(0);
        paramLoader = new Conversation(mConversationListCursor);
        position = 0;
        onConversationSelected(paramLoader, true);
      }
    }
    
    public void onLoaderReset(Loader<ConversationCursor> paramLoader)
    {
      LogUtils.d(AbstractActivityController.LOG_TAG, "IN AAC.ConversationCursor.onLoaderReset, data=%s loader=%s", new Object[] { mConversationListCursor, paramLoader });
      if (mConversationListCursor != null)
      {
        mConversationListCursor.removeListener(AbstractActivityController.this);
        mConversationListCursor = null;
        mTracker.onCursorUpdated();
        mConversationListObservable.notifyChanged();
      }
    }
  }
  
  private class FolderDestruction
    implements DestructiveAction
  {
    private int mAction;
    private boolean mCompleted;
    private final ArrayList<FolderOperation> mFolderOps = new ArrayList();
    private final boolean mIsDestructive;
    private boolean mIsSelectedSet;
    private boolean mShowUndo;
    private final Collection<Conversation> mTarget;
    
    private FolderDestruction(Collection<FolderOperation> paramCollection, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
    {
      mTarget = ImmutableList.copyOf(paramCollection);
      mFolderOps.addAll(paramBoolean1);
      mIsDestructive = paramBoolean2;
      mIsSelectedSet = paramBoolean3;
      mShowUndo = paramInt;
      int i;
      mAction = i;
    }
    
    /* Error */
    private boolean isPerformed()
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore_1
      //   2: aload_0
      //   3: monitorenter
      //   4: aload_0
      //   5: getfield 66	com/android/mail/ui/AbstractActivityController$FolderDestruction:mCompleted	Z
      //   8: istore_2
      //   9: iload_2
      //   10: ifeq +7 -> 17
      //   13: aload_0
      //   14: monitorexit
      //   15: iload_1
      //   16: ireturn
      //   17: aload_0
      //   18: iconst_1
      //   19: putfield 66	com/android/mail/ui/AbstractActivityController$FolderDestruction:mCompleted	Z
      //   22: iconst_0
      //   23: istore_1
      //   24: goto -11 -> 13
      //   27: astore_3
      //   28: aload_0
      //   29: monitorexit
      //   30: aload_3
      //   31: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	32	0	this	FolderDestruction
      //   1	23	1	bool1	boolean
      //   8	2	2	bool2	boolean
      //   27	4	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   4	9	27	finally
      //   17	22	27	finally
    }
    
    public void performAction()
    {
      if (isPerformed()) {}
      do
      {
        return;
        if ((mIsDestructive) && (mShowUndo))
        {
          localObject1 = new ToastBarOperation(mTarget.size(), mAction, 0, mIsSelectedSet);
          onUndoAvailable((ToastBarOperation)localObject1);
        }
        Object localObject1 = new ArrayList(mTarget.size());
        Iterator localIterator = mTarget.iterator();
        while (localIterator.hasNext())
        {
          Object localObject2 = (Conversation)localIterator.next();
          HashMap localHashMap = Folder.hashMapForFolders(((Conversation)localObject2).getRawFolders());
          if (mIsDestructive) {
            localDeleteOnUpdate = true;
          }
          localObject2 = mFolderOps.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            FolderOperation localFolderOperation = (FolderOperation)((Iterator)localObject2).next();
            if (mAdd) {
              localHashMap.put(mFolder.uri, mFolder);
            } else {
              localHashMap.remove(mFolder.uri);
            }
          }
          ((ArrayList)localObject1).add(Folder.getSerializedFolderString(localHashMap.values()));
        }
        if (mConversationListCursor != null) {
          mConversationListCursor.updateStrings(mContext, mTarget, "rawFolders", (ArrayList)localObject1);
        }
        refreshConversationList();
      } while (!mIsSelectedSet);
      mSelectedSet.clear();
    }
  }
  
  static class RefreshTimerTask
    extends TimerTask
  {
    final AbstractActivityController mController;
    final Handler mHandler;
    
    public void run()
    {
      mHandler.post(new Runnable()
      {
        public void run()
        {
          LogUtils.d(AbstractActivityController.LOG_TAG, "Delay done... calling onRefreshRequired", new Object[0]);
          mController.onRefreshRequired();
        }
      });
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.AbstractActivityController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */