package com.android.mail;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.android.mail.providers.AccountObserver;
import com.android.mail.providers.Folder;
import com.android.mail.providers.FolderWatcher;
import com.android.mail.providers.RecentFolderObserver;
import com.android.mail.providers.Settings;
import com.android.mail.ui.ControllableActivity;
import com.android.mail.ui.ConversationListCallbacks;
import com.android.mail.ui.RecentFolderController;
import com.android.mail.ui.RecentFolderList;
import com.android.mail.utils.LogTag;
import com.android.mail.utils.LogUtils;
import com.android.mail.utils.Utils;
import java.util.ArrayList;

public class AccountSpinnerAdapter
  extends BaseAdapter
{
  private static final String LOG_TAG = ;
  final AccountObserver mAccountObserver = new AccountObserver()
  {
    public void onChanged(com.android.mail.providers.Account paramAnonymousAccount)
    {
      if (paramAnonymousAccount == null) {}
      while (uri.equals(AccountSpinnerAdapter.this.getCurrentAccountUri())) {
        return;
      }
      AccountSpinnerAdapter.access$202(AccountSpinnerAdapter.this, paramAnonymousAccount);
      if (mRecentFoldersVisible)
      {
        int i = com.android.mail.providers.Account.findPosition(mAllAccounts, uri);
        LogUtils.d(AccountSpinnerAdapter.LOG_TAG, "setCurrentAccount: mCurrentAccountPos = %d", new Object[] { Integer.valueOf(i) });
        if (i >= 0) {
          AccountSpinnerAdapter.this.requestRecentFolders();
        }
      }
      notifyDataSetChanged();
    }
  };
  private final ConversationListCallbacks mActivityController;
  private com.android.mail.providers.Account[] mAllAccounts = new com.android.mail.providers.Account[0];
  private final Context mContext;
  private com.android.mail.providers.Account mCurrentAccount = null;
  private Folder mCurrentFolder;
  private final FolderWatcher mFolderWatcher;
  private final LayoutInflater mInflater;
  private int mNumAccounts = 0;
  private RecentFolderController mRecentFolderController;
  private ArrayList<Folder> mRecentFolderList = new ArrayList();
  private RecentFolderObserver mRecentFolderObserver;
  private RecentFolderList mRecentFolders;
  private boolean mRecentFoldersVisible;
  private boolean mShowAllFoldersItem;
  private RecentFolderObserver mSpinnerRecentFolderObserver = new RecentFolderObserver()
  {
    public void onChanged()
    {
      AccountSpinnerAdapter.this.requestRecentFolders();
    }
  };
  
  public AccountSpinnerAdapter(ControllableActivity paramControllableActivity, Context paramContext, boolean paramBoolean)
  {
    mContext = paramContext;
    mInflater = LayoutInflater.from(paramContext);
    mShowAllFoldersItem = paramBoolean;
    mFolderWatcher = new FolderWatcher(paramControllableActivity, this);
    mCurrentAccount = mAccountObserver.initialize(paramControllableActivity.getAccountController());
    mActivityController = paramControllableActivity.getListHandler();
    mRecentFolderController = paramControllableActivity.getRecentFolderController();
  }
  
  private static void disableView(View paramView)
  {
    if (paramView != null) {
      paramView.setVisibility(8);
    }
  }
  
  private static void displayOrHide(View paramView, int paramInt, String paramString)
  {
    paramView = (TextView)paramView.findViewById(paramInt);
    if (paramView == null) {
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      paramView.setVisibility(8);
      return;
    }
    paramView.setText(paramString);
  }
  
  private static void enableView(View paramView)
  {
    if (paramView != null) {
      paramView.setVisibility(0);
    }
  }
  
  private com.android.mail.providers.Account getAccount(int paramInt)
  {
    if (paramInt >= mNumAccounts + 1) {
      return null;
    }
    return mAllAccounts[(paramInt - 1)];
  }
  
  private String getCurrentAccountName()
  {
    if (isCurrentAccountInvalid()) {
      return "";
    }
    return mCurrentAccount.name;
  }
  
  private Uri getCurrentAccountUri()
  {
    if (isCurrentAccountInvalid()) {
      return Uri.EMPTY;
    }
    return mCurrentAccount.uri;
  }
  
  private final int getRecentOffset(int paramInt)
  {
    return paramInt - mNumAccounts - 2;
  }
  
  private boolean isCurrentAccountInvalid()
  {
    return mCurrentAccount == null;
  }
  
  private final void populateUnreadCountView(TextView paramTextView, int paramInt)
  {
    paramTextView.setText(Utils.getUnreadCountString(mContext, paramInt));
  }
  
  private void requestRecentFolders()
  {
    if (mCurrentFolder == null) {}
    for (Uri localUri = null; mRecentFoldersVisible; localUri = mCurrentFolder.uri)
    {
      mRecentFolderList = mRecentFolders.getRecentFolderList(localUri);
      notifyDataSetChanged();
      return;
    }
    mRecentFolderList = null;
  }
  
  private static final void selectRelevant(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    View localView1 = paramView.findViewById(2131755035);
    View localView2 = paramView.findViewById(2131755037);
    View localView3 = paramView.findViewById(2131755038);
    View localView4 = paramView.findViewById(2131755008);
    paramView = paramView.findViewById(2131755039);
    disableView(localView1);
    disableView(localView2);
    disableView(localView3);
    disableView(localView4);
    disableView(paramView);
    switch (paramInt)
    {
    case 1: 
    default: 
      return;
    case 0: 
      enableView(localView1);
      return;
    case 2: 
      enableView(localView2);
      return;
    case 3: 
      enableView(localView3);
      return;
    case 4: 
      enableView(localView4);
      return;
    }
    enableView(paramView);
  }
  
  public boolean areAllItemsEnabled()
  {
    return false;
  }
  
  public void destroy()
  {
    mAccountObserver.unregisterAndDestroy();
    if (mRecentFolderObserver != null)
    {
      mRecentFolderObserver.unregisterAndDestroy();
      mRecentFolderObserver = null;
    }
  }
  
  public void disableRecentFolders()
  {
    if (mRecentFoldersVisible)
    {
      if (mRecentFolderObserver != null)
      {
        mRecentFolderObserver.unregisterAndDestroy();
        mRecentFolderObserver = null;
      }
      mRecentFolders = null;
      notifyDataSetChanged();
      mRecentFoldersVisible = false;
    }
  }
  
  public void enableRecentFolders()
  {
    if (!mRecentFoldersVisible)
    {
      mRecentFolderObserver = mSpinnerRecentFolderObserver;
      mRecentFolders = mRecentFolderObserver.initialize(mRecentFolderController);
      mRecentFoldersVisible = true;
      if ((mRecentFolderList == null) || (mRecentFolderList.size() <= 0)) {
        requestRecentFolders();
      }
    }
    else
    {
      return;
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    int j = 0;
    if (mRecentFolderList == null)
    {
      i = 0;
      if ((!mRecentFoldersVisible) || (i <= 0)) {
        break label57;
      }
      if (mShowAllFoldersItem) {
        j = 1;
      }
    }
    label57:
    for (int i = i + 1 + j;; i = 0)
    {
      return mNumAccounts + 1 + i;
      i = mRecentFolderList.size();
      break;
    }
  }
  
  public Object getItem(int paramInt)
  {
    switch (getType(paramInt))
    {
    case 4: 
    default: 
      return mRecentFolderList.get(getRecentOffset(paramInt));
    case 1: 
      return "dead header";
    case 2: 
      return getAccount(paramInt);
    case 3: 
      return "account spinner header";
    }
    return "show all folders";
  }
  
  public long getItemId(int paramInt)
  {
    int i = getType(paramInt);
    switch (i)
    {
    case 4: 
    default: 
      return mRecentFolderList.get(getRecentOffset(paramInt))).uri.hashCode();
    case 1: 
    case 3: 
    case 5: 
      return i;
    }
    return getAccounturi.hashCode();
  }
  
  public int getType(int paramInt)
  {
    if (paramInt == 0) {
      return 1;
    }
    if (paramInt <= mNumAccounts) {
      return 2;
    }
    if (paramInt == mNumAccounts + 1) {
      return 3;
    }
    if ((mShowAllFoldersItem) && (getRecentOffset(paramInt) >= mRecentFolderList.size())) {
      return 5;
    }
    return 4;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramInt == 0) {
      mActivityController.commitDestructiveActions(false);
    }
    int j = getType(paramInt);
    paramView = mInflater;
    if (mRecentFoldersVisible) {}
    View localView;
    for (int i = 2130968581;; i = 2130968583)
    {
      localView = paramView.inflate(i, null);
      selectRelevant(localView, j);
      switch (j)
      {
      case 1: 
      case 5: 
      default: 
        return localView;
      }
    }
    com.android.mail.providers.Account localAccount = getAccount(paramInt);
    Object localObject = localView.findViewById(2131755026);
    if (localAccount == null)
    {
      paramView = "";
      paramViewGroup = "";
      paramInt = 0;
      ((View)localObject).setVisibility(4);
      displayOrHide(localView, 2131755028, paramView);
      displayOrHide(localView, 2131755029, paramViewGroup);
      populateUnreadCountView((TextView)localView.findViewById(2131755027), paramInt);
      return localView;
    }
    paramView = settings.defaultInboxName;
    paramViewGroup = name;
    paramInt = color;
    if (paramInt != 0)
    {
      ((View)localObject).setVisibility(0);
      ((View)localObject).setBackgroundColor(paramInt);
      label213:
      localObject = mFolderWatcher.get(settings.defaultInbox);
      if (localObject == null) {
        break label253;
      }
    }
    label253:
    for (paramInt = unreadCount;; paramInt = 0)
    {
      break;
      ((View)localObject).setVisibility(4);
      break label213;
    }
    ((TextView)localView.findViewById(2131755034)).setText(getCurrentAccountName());
    return localView;
    paramView = (Folder)mRecentFolderList.get(getRecentOffset(paramInt));
    paramViewGroup = localView.findViewById(2131755030);
    localObject = name;
    paramInt = unreadCount;
    Folder.setFolderBlockColor(paramView, paramViewGroup);
    paramViewGroup.setVisibility(0);
    displayOrHide(localView, 2131755032, (String)localObject);
    displayOrHide(localView, 2131755033, "");
    populateUnreadCountView((TextView)localView.findViewById(2131755031), paramInt);
    return localView;
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return getType(paramInt) != 3;
  }
  
  public void onFolderUpdated(Folder paramFolder)
  {
    mCurrentFolder = paramFolder;
    notifyDataSetChanged();
  }
  
  public void setAccountArray(com.android.mail.providers.Account[] paramArrayOfAccount)
  {
    Uri localUri = getCurrentAccountUri();
    mAllAccounts = paramArrayOfAccount;
    mNumAccounts = paramArrayOfAccount.length;
    if (!isCurrentAccountInvalid())
    {
      i = com.android.mail.providers.Account.findPosition(paramArrayOfAccount, localUri);
      LogUtils.d(LOG_TAG, "setAccountArray: mCurrentAccountPos = %d", new Object[] { Integer.valueOf(i) });
    }
    int i = 0;
    while (i < mNumAccounts)
    {
      paramArrayOfAccount = mAllAccounts[i].settings.defaultInbox;
      mFolderWatcher.startWatching(paramArrayOfAccount);
      i += 1;
    }
    notifyDataSetChanged();
  }
  
  public boolean setCurrentFolder(Folder paramFolder)
  {
    if ((paramFolder != null) && (paramFolder != mCurrentFolder))
    {
      mCurrentFolder = paramFolder;
      requestRecentFolders();
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.AccountSpinnerAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */