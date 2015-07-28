package com.android.mail.ui;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.android.mail.ConversationListContext;
import com.android.mail.browse.ConversationPagerController;
import com.android.mail.providers.Account;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import com.android.mail.utils.LogUtils;
import com.android.mail.utils.Utils;

public final class TwoPaneController
  extends AbstractActivityController
{
  private Conversation mConversationToShow;
  private TwoPaneLayout mLayout;
  
  public TwoPaneController(MailActivity paramMailActivity, ViewMode paramViewMode)
  {
    super(paramMailActivity, paramViewMode);
  }
  
  private void createFolderListFragment(Folder paramFolder, Uri paramUri)
  {
    setHierarchyFolder(paramFolder);
    paramFolder = FolderListFragment.newInstance(paramFolder, paramUri, true);
    paramUri = mActivity.getFragmentManager().beginTransaction();
    if (Utils.useFolderListFragmentTransition(mActivity.getActivityContext())) {
      paramUri.setTransition(4097);
    }
    paramUri.replace(2131755198, paramFolder, "tag-folder-list");
    paramUri.commitAllowingStateLoss();
    resetActionBarIcon();
  }
  
  private final void enableOrDisableCab()
  {
    if (mLayout.isConversationListCollapsed())
    {
      disableCabMode();
      return;
    }
    enableCabMode();
  }
  
  private int getUndoBarWidth(int paramInt, ToastBarOperation paramToastBarOperation)
  {
    int j = -1;
    int k = -1;
    int i = k;
    switch (paramInt)
    {
    default: 
      i = k;
    }
    for (;;)
    {
      paramInt = j;
      if (i != -1) {
        paramInt = (int)mContext.getResources().getDimension(i);
      }
      return paramInt;
      i = 2131427342;
      continue;
      i = 2131427339;
      continue;
      if (paramToastBarOperation.isBatchUndo()) {
        i = 2131427341;
      } else {
        i = 2131427340;
      }
    }
  }
  
  private void goUpFolderHierarchy(Folder paramFolder)
  {
    paramFolder = parent;
    if (parent != null)
    {
      createFolderListFragment(parent, parent.childFoldersListUri);
      mActionBarView.setBackButton();
      return;
    }
    onFolderSelected(paramFolder);
  }
  
  private void initializeConversationListFragment(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (!"android.intent.action.SEARCH".equals(mActivity.getIntent().getAction())) {
        break label63;
      }
      if (!Utils.showTwoPaneSearchResults(mActivity.getActivityContext())) {
        break label52;
      }
      mViewMode.enterSearchResultsConversationMode();
    }
    for (;;)
    {
      renderConversationList();
      return;
      label52:
      mViewMode.enterSearchResultsListMode();
      continue;
      label63:
      mViewMode.enterConversationListMode();
    }
  }
  
  private void renderConversationList()
  {
    if (mActivity == null) {
      return;
    }
    FragmentTransaction localFragmentTransaction = mActivity.getFragmentManager().beginTransaction();
    localFragmentTransaction.setTransition(4099);
    localFragmentTransaction.replace(2131755260, ConversationListFragment.newInstance(mConvListContext), "tag-conversation-list");
    localFragmentTransaction.commitAllowingStateLoss();
  }
  
  private void renderFolderList()
  {
    if (mActivity == null) {
      return;
    }
    createFolderListFragment(null, mAccount.folderListUri);
  }
  
  public void exitSearchMode()
  {
    int i = mViewMode.getMode();
    if ((i == 4) || ((i == 5) && (Utils.showTwoPaneSearchResults(mActivity.getApplicationContext())))) {
      mActivity.finish();
    }
  }
  
  public void hideWaitForInitialization()
  {
    WaitFragment localWaitFragment = (WaitFragment)mActivity.getFragmentManager().findFragmentByTag("wait-fragment");
    if (localWaitFragment != null)
    {
      FragmentTransaction localFragmentTransaction = mActivity.getFragmentManager().beginTransaction();
      localFragmentTransaction.remove(localWaitFragment);
      localFragmentTransaction.commitAllowingStateLoss();
    }
  }
  
  protected boolean isConversationListVisible()
  {
    return !mLayout.isConversationListCollapsed();
  }
  
  public void onAccountChanged(Account paramAccount)
  {
    super.onAccountChanged(paramAccount);
    renderFolderList();
  }
  
  public boolean onBackPressed()
  {
    mToastBar.hide(false);
    popView(false);
    return true;
  }
  
  public void onConversationListVisibilityChanged(boolean paramBoolean)
  {
    super.onConversationListVisibilityChanged(paramBoolean);
    enableOrDisableCab();
  }
  
  public void onConversationVisibilityChanged(boolean paramBoolean)
  {
    super.onConversationVisibilityChanged(paramBoolean);
    if (!paramBoolean) {
      mPagerController.hide(false);
    }
    while (mConversationToShow == null) {
      return;
    }
    mPagerController.show(mAccount, mFolder, mConversationToShow, false);
    mConversationToShow = null;
  }
  
  public boolean onCreate(Bundle paramBundle)
  {
    mActivity.setContentView(2130968687);
    mLayout = ((TwoPaneLayout)mActivity.findViewById(2131755259));
    if (mLayout == null) {
      LogUtils.wtf(LOG_TAG, "mLayout is null!", new Object[0]);
    }
    mLayout.setController(this, "android.intent.action.SEARCH".equals(mActivity.getIntent().getAction()));
    mViewMode.addListener(mLayout);
    return super.onCreate(paramBundle);
  }
  
  public void onError(Folder paramFolder, boolean paramBoolean)
  {
    int i = mViewMode.getMode();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)mToastBar.getLayoutParams();
    switch (i)
    {
    }
    for (;;)
    {
      showErrorToast(paramFolder, paramBoolean);
      return;
      width = (mLayout.computeConversationListWidth() - leftMargin - rightMargin);
      gravity = 85;
      mToastBar.setLayoutParams(localLayoutParams);
      continue;
      gravity = 83;
      width = (mLayout.computeConversationListWidth() - leftMargin - rightMargin);
      mToastBar.setLayoutParams(localLayoutParams);
    }
  }
  
  public void onFolderChanged(Folder paramFolder)
  {
    super.onFolderChanged(paramFolder);
    exitCabMode();
    if ((getFolderListFragment() == null) && (mViewMode.getMode() == 2)) {
      renderFolderList();
    }
  }
  
  public void onFolderSelected(Folder paramFolder)
  {
    if ((hasChildren) && (!paramFolder.equals(getHierarchyFolder())))
    {
      createFolderListFragment(paramFolder, childFoldersListUri);
      mActionBarView.setBackButton();
      super.onFolderSelected(paramFolder);
      return;
    }
    setHierarchyFolder(paramFolder);
    super.onFolderSelected(paramFolder);
  }
  
  public void onUndoAvailable(ToastBarOperation paramToastBarOperation)
  {
    int i = mViewMode.getMode();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)mToastBar.getLayoutParams();
    ConversationListFragment localConversationListFragment = getConversationListFragment();
    int j = getUndoBarWidth(i, paramToastBarOperation);
    switch (i)
    {
    }
    for (;;)
    {
      return;
      width = (j - leftMargin - rightMargin);
      gravity = 85;
      mToastBar.setLayoutParams(localLayoutParams);
      mToastBar.setConversationMode(false);
      if (localConversationListFragment != null)
      {
        mToastBar.show(getUndoClickedListener(localConversationListFragment.getAnimatedAdapter()), 0, Html.fromHtml(paramToastBarOperation.getDescription(mActivity.getActivityContext(), mFolder)), true, 2131493023, true, paramToastBarOperation);
        return;
        if (paramToastBarOperation.isBatchUndo())
        {
          gravity = 83;
          width = (j - leftMargin - rightMargin);
          mToastBar.setLayoutParams(localLayoutParams);
          mToastBar.setConversationMode(false);
        }
        while (localConversationListFragment != null)
        {
          mToastBar.show(getUndoClickedListener(localConversationListFragment.getAnimatedAdapter()), 0, Html.fromHtml(paramToastBarOperation.getDescription(mActivity.getActivityContext(), mFolder)), true, 2131493023, true, paramToastBarOperation);
          return;
          gravity = 85;
          width = (j - leftMargin - rightMargin);
          mToastBar.setLayoutParams(localLayoutParams);
          mToastBar.setConversationMode(true);
        }
      }
    }
  }
  
  public boolean onUpPressed()
  {
    int i = mViewMode.getMode();
    if (i == 1) {
      mActivity.onBackPressed();
    }
    do
    {
      return true;
      if (i == 5)
      {
        if ((mLayout.isConversationListCollapsed()) || ((ConversationListContext.isSearchResult(mConvListContext)) && (!Utils.showTwoPaneSearchResults(mActivity.getApplicationContext()))))
        {
          onBackPressed();
          return true;
        }
        mActivity.finish();
        return true;
      }
      if (i == 4)
      {
        mActivity.finish();
        return true;
      }
    } while (i != 2);
    popView(true);
    return true;
  }
  
  public void onViewModeChanged(int paramInt)
  {
    super.onViewModeChanged(paramInt);
    if (paramInt != 6) {
      hideWaitForInitialization();
    }
    if ((paramInt == 1) || (paramInt == 2)) {
      enableOrDisableCab();
    }
    resetActionBarIcon();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if ((paramBoolean) && (!mLayout.isConversationListCollapsed())) {
      informCursorVisiblity(true);
    }
  }
  
  protected void popView(boolean paramBoolean)
  {
    int i = mViewMode.getMode();
    if (i == 4) {
      mActivity.finish();
    }
    do
    {
      return;
      if (i == 1)
      {
        mViewMode.enterConversationListMode();
        return;
      }
      if (i == 5)
      {
        mViewMode.enterSearchResultsListMode();
        return;
      }
      Object localObject = getFolderListFragment();
      if ((i == 2) && (localObject != null) && (((FolderListFragment)localObject).showingHierarchy()))
      {
        localObject = getHierarchyFolder();
        if (parent != null)
        {
          goUpFolderHierarchy((Folder)localObject);
          return;
        }
        createFolderListFragment(null, mAccount.folderListUri);
        loadAccountInbox();
        return;
      }
    } while (paramBoolean);
    mActivity.finish();
  }
  
  public void resetActionBarIcon()
  {
    if (mViewMode.getMode() == 0) {
      return;
    }
    if (mViewMode.isListMode())
    {
      mActionBarView.removeBackButton();
      return;
    }
    mActionBarView.setBackButton();
  }
  
  public void setCurrentConversation(Conversation paramConversation)
  {
    long l2 = -1L;
    long l1;
    if (mCurrentConversation != null)
    {
      l1 = mCurrentConversation.id;
      if (paramConversation != null) {
        l2 = id;
      }
      if (l1 == l2) {
        break label79;
      }
    }
    label79:
    for (boolean bool = true;; bool = false)
    {
      super.setCurrentConversation(paramConversation);
      ConversationListFragment localConversationListFragment = getConversationListFragment();
      if ((localConversationListFragment != null) && (paramConversation != null)) {
        localConversationListFragment.setSelected(position, bool);
      }
      return;
      l1 = -1L;
      break;
    }
  }
  
  public boolean shouldShowFirstConversation()
  {
    return ("android.intent.action.SEARCH".equals(mActivity.getIntent().getAction())) && (Utils.showTwoPaneSearchResults(mActivity.getApplicationContext()));
  }
  
  protected void showConversation(Conversation paramConversation, boolean paramBoolean)
  {
    super.showConversation(paramConversation, paramBoolean);
    if (mActivity == null) {}
    for (;;)
    {
      return;
      if (paramConversation == null)
      {
        onBackPressed();
        return;
      }
      enableOrDisableCab();
      mConversationToShow = paramConversation;
      int i = mViewMode.getMode();
      if ((i == 4) || (i == 5)) {}
      for (paramBoolean = mViewMode.enterSearchResultsConversationMode(); !paramBoolean; paramBoolean = mViewMode.enterConversationMode())
      {
        onConversationVisibilityChanged(true);
        return;
      }
    }
  }
  
  public void showConversationList(ConversationListContext paramConversationListContext)
  {
    super.showConversationList(paramConversationListContext);
    initializeConversationListFragment(true);
  }
  
  public void showFolderList()
  {
    onUpPressed();
  }
  
  public void showWaitForInitialization()
  {
    super.showWaitForInitialization();
    WaitFragment localWaitFragment = WaitFragment.newInstance(mAccount);
    FragmentTransaction localFragmentTransaction = mActivity.getFragmentManager().beginTransaction();
    localFragmentTransaction.setTransition(4097);
    localFragmentTransaction.replace(2131755076, localWaitFragment, "wait-fragment");
    localFragmentTransaction.commitAllowingStateLoss();
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.TwoPaneController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */