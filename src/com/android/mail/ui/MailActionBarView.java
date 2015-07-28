package com.android.mail.ui;

import android.app.ActionBar;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.SearchView.OnSuggestionListener;
import android.widget.TextView;
import com.android.mail.AccountSpinnerAdapter;
import com.android.mail.browse.SnippetTextView;
import com.android.mail.providers.AccountObserver;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import com.android.mail.utils.LogTag;
import com.android.mail.utils.LogUtils;
import com.android.mail.utils.Utils;

public class MailActionBarView
  extends LinearLayout
  implements MenuItem.OnActionExpandListener, SearchView.OnQueryTextListener, SearchView.OnSuggestionListener, SubjectDisplayChanger, ViewMode.ModeChangeListener
{
  public static final String LOG_TAG = ;
  private com.android.mail.providers.Account mAccount;
  private final AccountObserver mAccountObserver = new AccountObserver()
  {
    public void onChanged(com.android.mail.providers.Account paramAnonymousAccount)
    {
      MailActionBarView.access$002(MailActionBarView.this, paramAnonymousAccount);
      if (mFolderAccountName != null) {
        mFolderAccountName.setText(mAccount.name);
      }
      mSpinner.setAccount(mAccount);
    }
  };
  protected ActionBar mActionBar;
  protected ControllableActivity mActivity;
  protected ActivityController mController;
  private Conversation mCurrentConversation;
  private Folder mFolder;
  private TextView mFolderAccountName;
  private DataSetObserver mFolderObserver;
  private MenuItem mFolderSettingsItem;
  private View mFolderView;
  private final Handler mHandler = new Handler();
  private boolean mHasManyAccounts;
  private MenuItem mHelpItem;
  private final Runnable mInvalidateMenu = new Runnable()
  {
    public void run()
    {
      mActivity.invalidateOptionsMenu();
    }
  };
  private final boolean mIsOnTablet;
  private int mMode = 0;
  private View mRefreshActionView;
  private boolean mRefreshInProgress;
  private MenuItem mRefreshItem;
  private MenuItem mSearch;
  private SearchView mSearchWidget;
  private MenuItem mSendFeedbackItem;
  private final boolean mShowConversationSubject = getResources().getBoolean(2131689475);
  private MailSpinner mSpinner;
  private AccountSpinnerAdapter mSpinnerAdapter;
  private SnippetTextView mSubjectView;
  
  public MailActionBarView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MailActionBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MailActionBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    mIsOnTablet = Utils.useTabletUI(paramContext);
  }
  
  private final void enableDisableSpinnner()
  {
    boolean bool2 = true;
    if (!mIsOnTablet) {
      return;
    }
    boolean bool1 = bool2;
    if (!mHasManyAccounts)
    {
      bool1 = bool2;
      if (mMode != 1) {
        if (mMode != 5) {
          break label48;
        }
      }
    }
    label48:
    for (bool1 = bool2;; bool1 = false)
    {
      mSpinner.changeEnabledState(bool1);
      return;
    }
  }
  
  private void onRefreshStarted()
  {
    setRefreshInProgress(true);
  }
  
  private void onRefreshStopped()
  {
    setRefreshInProgress(false);
  }
  
  private boolean setRefreshInProgress(boolean paramBoolean)
  {
    if (paramBoolean != mRefreshInProgress)
    {
      mRefreshInProgress = paramBoolean;
      if ((mSearch == null) || (!mSearch.isActionViewExpanded())) {
        mHandler.post(mInvalidateMenu);
      }
      return true;
    }
    return false;
  }
  
  private void setStandardMode()
  {
    mSpinner.setVisibility(8);
    mFolderView.setVisibility(0);
    mFolderAccountName.setVisibility(0);
  }
  
  private void showNavList()
  {
    mSpinner.setVisibility(0);
    mFolderView.setVisibility(8);
    mFolderAccountName.setVisibility(8);
  }
  
  public void attach() {}
  
  public void clearSubject()
  {
    if (!mShowConversationSubject) {
      return;
    }
    mSubjectView.setText(null);
  }
  
  public void collapseSearch()
  {
    if (mSearch != null) {
      mSearch.collapseActionView();
    }
  }
  
  protected int getMode()
  {
    return mMode;
  }
  
  public int getOptionsMenuId()
  {
    int i = mMode;
    return new int[] { 2131886082, 2131886081, 2131886082, 2131886086, 2131886083, 2131886085, 2131886095 }[i];
  }
  
  public String getQuery()
  {
    if (mSearchWidget != null) {
      return mSearchWidget.getQuery().toString();
    }
    return "";
  }
  
  protected MenuItem getSearch()
  {
    return mSearch;
  }
  
  public String getUnshownSubject(String paramString)
  {
    if (!mShowConversationSubject) {
      return paramString;
    }
    return mSubjectView.getTextRemainder(paramString);
  }
  
  public void initialize(ControllableActivity paramControllableActivity, ActivityController paramActivityController, ViewMode paramViewMode, ActionBar paramActionBar, RecentFolderList paramRecentFolderList)
  {
    mActionBar = paramActionBar;
    mController = paramActivityController;
    mActivity = paramControllableActivity;
    mFolderObserver = new FolderObserver(null);
    mController.registerFolderObserver(mFolderObserver);
    if (!Utils.useTabletUI(getContext())) {}
    for (boolean bool = true;; bool = false)
    {
      mSpinnerAdapter = new AccountSpinnerAdapter(paramControllableActivity, getContext(), bool);
      mSpinner = ((MailSpinner)findViewById(2131755053));
      mSpinner.setAdapter(mSpinnerAdapter);
      mSpinner.setController(mController);
      mAccount = mAccountObserver.initialize(paramControllableActivity.getAccountController());
      return;
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    if (mMode == 0) {
      return false;
    }
    mSearch = paramMenu.findItem(2131755311);
    if (mSearch != null)
    {
      mSearchWidget = ((SearchView)mSearch.getActionView());
      mSearch.setOnActionExpandListener(this);
      Object localObject = (SearchManager)mActivity.getActivityContext().getSystemService("search");
      if ((localObject != null) && (mSearchWidget != null))
      {
        localObject = ((SearchManager)localObject).getSearchableInfo(mActivity.getComponentName());
        mSearchWidget.setSearchableInfo((SearchableInfo)localObject);
        mSearchWidget.setOnQueryTextListener(this);
        mSearchWidget.setOnSuggestionListener(this);
        mSearchWidget.setIconifiedByDefault(true);
      }
    }
    mHelpItem = paramMenu.findItem(2131755298);
    mSendFeedbackItem = paramMenu.findItem(2131755297);
    mRefreshItem = paramMenu.findItem(2131755312);
    mFolderSettingsItem = paramMenu.findItem(2131755313);
    return true;
  }
  
  public void onDestroy()
  {
    if (mFolderObserver != null)
    {
      mController.unregisterFolderObserver(mFolderObserver);
      mFolderObserver = null;
    }
    mSpinnerAdapter.destroy();
    mAccountObserver.unregisterAndDestroy();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    mSubjectView = ((SnippetTextView)findViewById(2131755052));
    mFolderView = findViewById(2131755050);
    mFolderAccountName = ((TextView)mFolderView.findViewById(2131755037));
  }
  
  public void onFolderUpdated(Folder paramFolder)
  {
    mSpinner.onFolderUpdated(paramFolder);
    int i = syncStatus;
    if (paramFolder.isSyncInProgress())
    {
      onRefreshStarted();
      return;
    }
    onRefreshStopped();
  }
  
  public boolean onMenuItemActionCollapse(MenuItem paramMenuItem)
  {
    setVisibility(0);
    return true;
  }
  
  public boolean onMenuItemActionExpand(MenuItem paramMenuItem)
  {
    return true;
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    boolean bool2 = true;
    LogUtils.d(LOG_TAG, "ActionBarView.onPrepareOptionsMenu().", new Object[0]);
    label63:
    MenuItem localMenuItem;
    if (mRefreshInProgress) {
      if (mRefreshItem != null)
      {
        if (mRefreshActionView == null)
        {
          mRefreshItem.setActionView(2130968584);
          mRefreshActionView = mRefreshItem.getActionView();
        }
      }
      else
      {
        if (mHelpItem != null)
        {
          localMenuItem = mHelpItem;
          if ((mAccount == null) || (!mAccount.supportsCapability(32768))) {
            break label272;
          }
          bool1 = true;
          label98:
          localMenuItem.setVisible(bool1);
        }
        if (mSendFeedbackItem != null)
        {
          localMenuItem = mSendFeedbackItem;
          if ((mAccount == null) || (!mAccount.supportsCapability(65536))) {
            break label277;
          }
          bool1 = true;
          label142:
          localMenuItem.setVisible(bool1);
        }
        if (mFolderSettingsItem != null)
        {
          localMenuItem = mFolderSettingsItem;
          if ((mFolder == null) || (!mFolder.supportsCapability(512))) {
            break label282;
          }
        }
      }
    }
    label272:
    label277:
    label282:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localMenuItem.setVisible(bool1);
      switch (mMode)
      {
      case 3: 
      case 4: 
      default: 
        return false;
        mRefreshItem.setActionView(mRefreshActionView);
        break label63;
        if (mRefreshItem == null) {
          break label63;
        }
        mRefreshItem.setActionView(null);
        break label63;
        bool1 = false;
        break label98;
        bool1 = false;
        break label142;
      }
    }
    setConversationModeOptions(paramMenu);
    return false;
    Utils.setMenuItemVisibility(paramMenu, 2131755311, mAccount.supportsCapability(64));
    return false;
  }
  
  public boolean onQueryTextChange(String paramString)
  {
    return false;
  }
  
  public boolean onQueryTextSubmit(String paramString)
  {
    if (mSearch != null)
    {
      mSearch.collapseActionView();
      mSearchWidget.setQuery("", false);
    }
    mActivity.onSearchRequested(paramString.trim());
    return true;
  }
  
  public boolean onSuggestionClick(int paramInt)
  {
    Object localObject = mSearchWidget.getSuggestionsAdapter().getCursor();
    if ((localObject != null) && (((Cursor)localObject).moveToPosition(paramInt))) {}
    for (paramInt = 1; paramInt == 0; paramInt = 0)
    {
      LogUtils.d(LOG_TAG, "onSuggestionClick: Couldn't get a search query", new Object[0]);
      return true;
    }
    collapseSearch();
    String str2 = mSearchWidget.getQuery().toString();
    String str3 = ((Cursor)localObject).getString(((Cursor)localObject).getColumnIndex("suggest_intent_query"));
    String str1 = str3;
    if (!TextUtils.isEmpty(str2))
    {
      str1 = str3;
      if (str3.indexOf(str2) != 0)
      {
        paramInt = str2.lastIndexOf(" ");
        localObject = str2;
        if (paramInt > -1) {
          localObject = str2.substring(0, paramInt);
        }
        str1 = str3;
        if (paramInt > -1)
        {
          str1 = str3;
          if (!TextUtils.isEmpty(str3))
          {
            str1 = str3;
            if (str3.contains((CharSequence)localObject))
            {
              str1 = str3;
              if (((String)localObject).length() < str3.length())
              {
                paramInt = str3.indexOf((String)localObject);
                str1 = str3.substring(0, paramInt) + str3.substring(((String)localObject).length() + paramInt);
              }
            }
          }
        }
      }
    }
    mController.onSearchRequested(str1.trim());
    return true;
  }
  
  public boolean onSuggestionSelect(int paramInt)
  {
    return onSuggestionClick(paramInt);
  }
  
  public void onViewModeChanged(int paramInt)
  {
    mMode = paramInt;
    enableDisableSpinnner();
    mActivity.invalidateOptionsMenu();
    int i;
    label94:
    View localView;
    if ((!mIsOnTablet) || (mMode == 1))
    {
      mSpinnerAdapter.enableRecentFolders();
      i = 0;
      paramInt = i;
      switch (mMode)
      {
      default: 
        paramInt = i;
      case 4: 
      case 5: 
        localView = mFolderView;
        if (paramInt == 0) {
          break;
        }
      }
    }
    for (paramInt = 0;; paramInt = 8)
    {
      localView.setVisibility(paramInt);
      return;
      mSpinnerAdapter.disableRecentFolders();
      break;
      paramInt = i;
      if (mSearch == null) {
        break label94;
      }
      mSearch.collapseActionView();
      paramInt = i;
      break label94;
      showNavList();
      paramInt = i;
      break label94;
      mActionBar.setDisplayHomeAsUpEnabled(true);
      if (!mShowConversationSubject)
      {
        showNavList();
        paramInt = i;
        break label94;
      }
      setStandardMode();
      paramInt = i;
      break label94;
      mActionBar.setDisplayHomeAsUpEnabled(true);
      setStandardMode();
      paramInt = 1;
      break label94;
      showNavList();
      paramInt = i;
      break label94;
    }
  }
  
  public void removeBackButton()
  {
    if (mActionBar == null) {
      return;
    }
    mActionBar.setDisplayOptions(2, 6);
    mActivity.getActionBar().setHomeButtonEnabled(false);
  }
  
  public void setAccounts(com.android.mail.providers.Account[] paramArrayOfAccount)
  {
    boolean bool = true;
    mSpinnerAdapter.setAccountArray(paramArrayOfAccount);
    if (paramArrayOfAccount.length > 1) {}
    for (;;)
    {
      mHasManyAccounts = bool;
      enableDisableSpinnner();
      return;
      bool = false;
    }
  }
  
  public void setBackButton()
  {
    if (mActionBar == null) {
      return;
    }
    mActionBar.setDisplayOptions(6, 6);
    mActivity.getActionBar().setHomeButtonEnabled(true);
  }
  
  public void setConversationModeOptions(Menu paramMenu)
  {
    boolean bool2 = true;
    if (mCurrentConversation == null) {
      return;
    }
    int i;
    if (!mCurrentConversation.isImportant())
    {
      i = 1;
      if ((i == 0) || (!mAccount.supportsCapability(131072))) {
        break label508;
      }
      bool1 = true;
      label42:
      Utils.setMenuItemVisibility(paramMenu, 2131755305, bool1);
      if ((i != 0) || (!mAccount.supportsCapability(131072))) {
        break label513;
      }
      bool1 = true;
      label69:
      Utils.setMenuItemVisibility(paramMenu, 2131755306, bool1);
      if ((mFolder == null) || (!mFolder.supportsCapability(32))) {
        break label518;
      }
      bool1 = true;
      label98:
      Utils.setMenuItemVisibility(paramMenu, 2131755301, bool1);
      if ((bool1) || (mFolder == null) || (!mFolder.isDraft()) || (!mAccount.supportsCapability(1048576))) {
        break label523;
      }
      bool1 = true;
      label142:
      Utils.setMenuItemVisibility(paramMenu, 2131755302, bool1);
      if ((!mAccount.supportsCapability(8)) || (mFolder == null) || (!mFolder.supportsCapability(16)) || (mFolder.isTrash())) {
        break label528;
      }
      bool1 = true;
      label193:
      Utils.setMenuItemVisibility(paramMenu, 2131755299, bool1);
      if ((bool1) || (mFolder == null) || (!mFolder.supportsCapability(8)) || (mFolder.isProviderFolder())) {
        break label533;
      }
      bool1 = true;
      label236:
      Utils.setMenuItemVisibility(paramMenu, 2131755300, bool1);
      MenuItem localMenuItem = paramMenu.findItem(2131755300);
      if (localMenuItem != null) {
        localMenuItem.setTitle(mActivity.getApplicationContext().getString(2131492928, new Object[] { mFolder.name }));
      }
      if ((!mAccount.supportsCapability(2)) || (mFolder == null) || (!mFolder.supportsCapability(64)) || (mCurrentConversation.spam)) {
        break label538;
      }
      bool1 = true;
      label339:
      Utils.setMenuItemVisibility(paramMenu, 2131755308, bool1);
      if ((!mAccount.supportsCapability(2)) || (mFolder == null) || (!mFolder.supportsCapability(128)) || (!mCurrentConversation.spam)) {
        break label543;
      }
      bool1 = true;
      label390:
      Utils.setMenuItemVisibility(paramMenu, 2131755309, bool1);
      if ((!mAccount.supportsCapability(4)) || (mFolder == null) || (!mFolder.supportsCapability(8192)) || (mCurrentConversation.phishing)) {
        break label548;
      }
      bool1 = true;
      label441:
      Utils.setMenuItemVisibility(paramMenu, 2131755310, bool1);
      if ((!mAccount.supportsCapability(16)) || (mFolder == null) || (!mFolder.supportsCapability(256)) || (mCurrentConversation.muted)) {
        break label553;
      }
    }
    label508:
    label513:
    label518:
    label523:
    label528:
    label533:
    label538:
    label543:
    label548:
    label553:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Utils.setMenuItemVisibility(paramMenu, 2131755307, bool1);
      return;
      i = 0;
      break;
      bool1 = false;
      break label42;
      bool1 = false;
      break label69;
      bool1 = false;
      break label98;
      bool1 = false;
      break label142;
      bool1 = false;
      break label193;
      bool1 = false;
      break label236;
      bool1 = false;
      break label339;
      bool1 = false;
      break label390;
      bool1 = false;
      break label441;
    }
  }
  
  public void setCurrentConversation(Conversation paramConversation)
  {
    mCurrentConversation = paramConversation;
  }
  
  protected void setEmptyMode()
  {
    mSpinner.setVisibility(8);
    mFolderView.setVisibility(8);
    mFolderAccountName.setVisibility(8);
  }
  
  public void setFolder(Folder paramFolder)
  {
    setRefreshInProgress(false);
    mFolder = paramFolder;
    mSpinner.setFolder(paramFolder);
    mActivity.invalidateOptionsMenu();
  }
  
  public void setSubject(String paramString)
  {
    if (!mShowConversationSubject) {
      return;
    }
    mSubjectView.setText(paramString);
  }
  
  protected boolean showConversationSubject()
  {
    return ((mMode == 5) || (mMode == 1)) && (mShowConversationSubject);
  }
  
  private class FolderObserver
    extends DataSetObserver
  {
    private FolderObserver() {}
    
    public void onChanged()
    {
      onFolderUpdated(mController.getFolder());
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.MailActionBarView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */