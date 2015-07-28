package com.android.mail.ui;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import com.android.mail.ConversationListContext;
import com.android.mail.browse.ConversationPagerController;
import com.android.mail.providers.Account;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import com.android.mail.providers.Settings;
import com.android.mail.utils.LogUtils;

public final class OnePaneController
  extends AbstractActivityController
{
  private boolean mConversationListNeverShown = true;
  private boolean mConversationListVisible = false;
  private Folder mInbox;
  private int mLastConversationListTransactionId = -1;
  private int mLastConversationTransactionId = -1;
  private int mLastFolderListTransactionId = -1;
  private int mLastInboxConversationListTransactionId = -1;
  
  public OnePaneController(MailActivity paramMailActivity, ViewMode paramViewMode)
  {
    super(paramMailActivity, paramViewMode);
  }
  
  private void goUpFolderHierarchy(Folder paramFolder)
  {
    paramFolder = parent;
    if (paramFolder != null)
    {
      setHierarchyFolder(paramFolder);
      mLastFolderListTransactionId = replaceFragment(FolderListFragment.newInstance(paramFolder, childFoldersListUri, false), 4097, "tag-folder-list");
      mActionBarView.setBackButton();
      return;
    }
    showFolderList();
  }
  
  private static boolean inInbox(Account paramAccount, ConversationListContext paramConversationListContext)
  {
    if ((paramAccount == null) || (paramConversationListContext == null) || (folder == null) || (settings == null)) {}
    do
    {
      return false;
      paramAccount = Settings.getDefaultInboxUri(settings);
    } while ((ConversationListContext.isSearchResult(paramConversationListContext)) || (!folder.uri.equals(paramAccount)));
    return true;
  }
  
  private boolean isTransactionIdValid(int paramInt)
  {
    return paramInt >= 0;
  }
  
  private int replaceFragment(Fragment paramFragment, int paramInt, String paramString)
  {
    FragmentTransaction localFragmentTransaction = mActivity.getFragmentManager().beginTransaction();
    localFragmentTransaction.addToBackStack(null);
    localFragmentTransaction.setTransition(paramInt);
    localFragmentTransaction.replace(2131755198, paramFragment, paramString);
    paramInt = localFragmentTransaction.commitAllowingStateLoss();
    resetActionBarIcon();
    return paramInt;
  }
  
  private void safelyPopBackStack(int paramInt, boolean paramBoolean)
  {
    PopBackStackRunnable localPopBackStackRunnable = new PopBackStackRunnable(paramInt);
    if (paramBoolean)
    {
      mHandler.post(localPopBackStackRunnable);
      return;
    }
    if (safeToModifyFragments())
    {
      localPopBackStackRunnable.popBackStack();
      return;
    }
    LogUtils.i(LOG_TAG, "Activity has been saved; ignoring unsafe immediate request to pop back stack", new Object[0]);
  }
  
  private void transitionBackToConversationListMode(boolean paramBoolean)
  {
    int i = mViewMode.getMode();
    enableCabMode();
    if (i == 5)
    {
      mViewMode.enterSearchResultsListMode();
      if (!isTransactionIdValid(mLastConversationListTransactionId)) {
        break label76;
      }
      safelyPopBackStack(mLastConversationListTransactionId, paramBoolean);
    }
    for (;;)
    {
      resetActionBarIcon();
      mConversationListVisible = true;
      onConversationVisibilityChanged(false);
      onConversationListVisibilityChanged(true);
      return;
      mViewMode.enterConversationListMode();
      break;
      label76:
      if (isTransactionIdValid(mLastInboxConversationListTransactionId))
      {
        safelyPopBackStack(mLastInboxConversationListTransactionId, paramBoolean);
        onFolderChanged(mInbox);
      }
      else
      {
        ConversationListContext localConversationListContext = ConversationListContext.forFolder(mAccount, mInbox);
        onFolderChanged(mInbox);
        showConversationList(localConversationListContext);
      }
    }
  }
  
  private void transitionToInbox()
  {
    mViewMode.enterConversationListMode();
    if (mInbox == null)
    {
      loadAccountInbox();
      return;
    }
    ConversationListContext localConversationListContext = ConversationListContext.forFolder(mAccount, mInbox);
    onFolderChanged(mInbox);
    showConversationList(localConversationListContext);
  }
  
  public String getHelpContext()
  {
    switch (mViewMode.getMode())
    {
    default: 
      return super.getHelpContext();
    }
    return mContext.getString(2131492875);
  }
  
  public void hideWaitForInitialization()
  {
    transitionToInbox();
  }
  
  protected boolean isConversationListVisible()
  {
    return mConversationListVisible;
  }
  
  public void onAccountChanged(Account paramAccount)
  {
    super.onAccountChanged(paramAccount);
    mConversationListNeverShown = true;
  }
  
  public boolean onBackPressed()
  {
    int i = mViewMode.getMode();
    if (i == 3)
    {
      Folder localFolder = getHierarchyFolder();
      FolderListFragment localFolderListFragment = getFolderListFragment();
      if ((localFolderListFragment != null) && (localFolderListFragment.showingHierarchy()) && (localFolder != null)) {
        goUpFolderHierarchy(localFolder);
      }
    }
    for (;;)
    {
      mToastBar.hide(false);
      return true;
      mLastFolderListTransactionId = -1;
      transitionToInbox();
      continue;
      if (i == 4) {
        mActivity.finish();
      } else if ((mViewMode.isListMode()) && (!inInbox(mAccount, mConvListContext)))
      {
        if (mLastFolderListTransactionId != -1)
        {
          mViewMode.enterFolderListMode();
          mActivity.getFragmentManager().popBackStack(mLastFolderListTransactionId, 0);
        }
        else
        {
          transitionToInbox();
        }
      }
      else if ((i == 1) || (i == 5)) {
        transitionBackToConversationListMode(false);
      } else {
        mActivity.finish();
      }
    }
  }
  
  public boolean onCreate(Bundle paramBundle)
  {
    mActivity.setContentView(2130968668);
    return super.onCreate(paramBundle);
  }
  
  public void onError(Folder paramFolder, boolean paramBoolean)
  {
    switch (mViewMode.getMode())
    {
    case 3: 
    default: 
      return;
    }
    showErrorToast(paramFolder, paramBoolean);
  }
  
  public void onFolderSelected(Folder paramFolder)
  {
    if ((hasChildren) && (!paramFolder.equals(getHierarchyFolder())))
    {
      mViewMode.enterFolderListMode();
      setHierarchyFolder(paramFolder);
      mLastFolderListTransactionId = replaceFragment(FolderListFragment.newInstance(paramFolder, childFoldersListUri, false), 4097, "tag-folder-list");
      mActionBarView.setBackButton();
      return;
    }
    super.onFolderSelected(paramFolder);
  }
  
  public void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    if (paramBundle == null) {
      return;
    }
    mLastFolderListTransactionId = paramBundle.getInt("folder-list-transaction", -1);
    mLastInboxConversationListTransactionId = paramBundle.getInt("inbox_conversation-list-transaction", -1);
    mLastConversationListTransactionId = paramBundle.getInt("conversation-list-transaction", -1);
    mLastConversationTransactionId = paramBundle.getInt("conversation-transaction", -1);
    mConversationListVisible = paramBundle.getBoolean("conversation-list-visible");
    mConversationListNeverShown = paramBundle.getBoolean("conversation-list-never-shown");
    mInbox = ((Folder)paramBundle.getParcelable("m-inbox"));
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putInt("folder-list-transaction", mLastFolderListTransactionId);
    paramBundle.putInt("inbox_conversation-list-transaction", mLastInboxConversationListTransactionId);
    paramBundle.putInt("conversation-list-transaction", mLastConversationListTransactionId);
    paramBundle.putInt("conversation-transaction", mLastConversationTransactionId);
    paramBundle.putBoolean("conversation-list-visible", mConversationListVisible);
    paramBundle.putBoolean("conversation-list-never-shown", mConversationListNeverShown);
    paramBundle.putParcelable("m-inbox", mInbox);
  }
  
  public void onUndoAvailable(ToastBarOperation paramToastBarOperation)
  {
    int i;
    Object localObject;
    if ((paramToastBarOperation != null) && (mAccount.supportsCapability(16384)))
    {
      i = mViewMode.getMode();
      localObject = getConversationListFragment();
    }
    switch (i)
    {
    case 3: 
    default: 
      return;
    case 1: 
    case 5: 
      mToastBar.setConversationMode(true);
      ActionableToastBar localActionableToastBar = mToastBar;
      if (localObject != null) {}
      for (localObject = ((ConversationListFragment)localObject).getAnimatedAdapter();; localObject = null)
      {
        localActionableToastBar.show(getUndoClickedListener((AnimatedAdapter)localObject), 0, Html.fromHtml(paramToastBarOperation.getDescription(mActivity.getActivityContext(), mFolder)), true, 2131493023, true, paramToastBarOperation);
        return;
      }
    }
    if (localObject != null)
    {
      mToastBar.setConversationMode(false);
      mToastBar.show(getUndoClickedListener(((ConversationListFragment)localObject).getAnimatedAdapter()), 0, Html.fromHtml(paramToastBarOperation.getDescription(mActivity.getActivityContext(), mFolder)), true, 2131493023, true, paramToastBarOperation);
      return;
    }
    mActivity.setPendingToastOperation(paramToastBarOperation);
  }
  
  public boolean onUpPressed()
  {
    int i = mViewMode.getMode();
    if (i == 4) {
      mActivity.finish();
    }
    while (((inInbox(mAccount, mConvListContext)) || (!mViewMode.isListMode())) && (i != 1) && (i != 3) && (i != 5)) {
      return true;
    }
    mActivity.onBackPressed();
    return true;
  }
  
  public void onViewModeChanged(int paramInt)
  {
    super.onViewModeChanged(paramInt);
    if (ViewMode.isListMode(paramInt)) {
      mPagerController.hide(true);
    }
    if (!ViewMode.isConversationMode(paramInt)) {
      setCurrentConversation(null);
    }
    resetActionBarIcon();
  }
  
  public void resetActionBarIcon()
  {
    int i = mViewMode.getMode();
    if (i == 0) {
      return;
    }
    if ((!inInbox(mAccount, mConvListContext)) || (i == 4) || (i == 5) || (i == 1) || (i == 3))
    {
      mActionBarView.setBackButton();
      return;
    }
    mActionBarView.removeBackButton();
  }
  
  public boolean shouldShowFirstConversation()
  {
    return false;
  }
  
  protected void showConversation(Conversation paramConversation, boolean paramBoolean)
  {
    super.showConversation(paramConversation, paramBoolean);
    if (paramConversation == null)
    {
      transitionBackToConversationListMode(paramBoolean);
      return;
    }
    disableCabMode();
    if (ConversationListContext.isSearchResult(mConvListContext)) {
      mViewMode.enterSearchResultsConversationMode();
    }
    for (;;)
    {
      Object localObject = mActivity.getFragmentManager();
      FragmentTransaction localFragmentTransaction = ((FragmentManager)localObject).beginTransaction();
      localFragmentTransaction.addToBackStack(null);
      localObject = ((FragmentManager)localObject).findFragmentById(2131755198);
      if ((localObject != null) && (((Fragment)localObject).isAdded()))
      {
        localFragmentTransaction.setTransition(4097);
        localFragmentTransaction.remove((Fragment)localObject);
        localFragmentTransaction.commitAllowingStateLoss();
      }
      mPagerController.show(mAccount, mFolder, paramConversation, true);
      onConversationVisibilityChanged(true);
      resetActionBarIcon();
      mConversationListVisible = false;
      onConversationListVisibilityChanged(false);
      return;
      mViewMode.enterConversationMode();
    }
  }
  
  public void showConversationList(ConversationListContext paramConversationListContext)
  {
    super.showConversationList(paramConversationListContext);
    enableCabMode();
    int i;
    label35:
    ConversationListFragment localConversationListFragment;
    if (ConversationListContext.isSearchResult(paramConversationListContext))
    {
      mViewMode.enterSearchResultsListMode();
      if (!mConversationListNeverShown) {
        break label99;
      }
      i = 4099;
      localConversationListFragment = ConversationListFragment.newInstance(paramConversationListContext);
      if (inInbox(mAccount, mConvListContext)) {
        break label106;
      }
    }
    for (mLastConversationListTransactionId = replaceFragment(localConversationListFragment, i, "tag-conversation-list");; mLastConversationListTransactionId = -1)
    {
      mConversationListVisible = true;
      onConversationVisibilityChanged(false);
      onConversationListVisibilityChanged(true);
      mConversationListNeverShown = false;
      return;
      mViewMode.enterConversationListMode();
      break;
      label99:
      i = 4097;
      break label35;
      label106:
      mInbox = folder;
      mLastInboxConversationListTransactionId = replaceFragment(localConversationListFragment, i, "tag-conversation-list");
      mLastFolderListTransactionId = -1;
    }
  }
  
  public void showFolderList()
  {
    if (mAccount == null)
    {
      LogUtils.e(LOG_TAG, "Null account in showFolderList", new Object[0]);
      return;
    }
    setHierarchyFolder(null);
    mViewMode.enterFolderListMode();
    enableCabMode();
    mLastFolderListTransactionId = replaceFragment(FolderListFragment.newInstance(null, mAccount.folderListUri, false), 4097, "tag-folder-list");
    mConversationListVisible = false;
    onConversationVisibilityChanged(false);
    onConversationListVisibilityChanged(false);
  }
  
  public void showWaitForInitialization()
  {
    super.showWaitForInitialization();
    replaceFragment(WaitFragment.newInstance(mAccount), 4097, "wait-fragment");
  }
  
  private final class PopBackStackRunnable
    implements Runnable
  {
    private final int mTransactionId;
    
    public PopBackStackRunnable(int paramInt)
    {
      mTransactionId = paramInt;
    }
    
    public void popBackStack()
    {
      mActivity.getFragmentManager().popBackStack(mTransactionId, 0);
    }
    
    public void run()
    {
      if (safeToModifyFragments())
      {
        popBackStack();
        return;
      }
      LogUtils.i(AbstractActivityController.LOG_TAG, "Activity has been saved; ignoring unsafe deferred request to pop back stack", new Object[0]);
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.OnePaneController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */