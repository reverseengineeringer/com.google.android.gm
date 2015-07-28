package com.android.mail.ui;

import android.app.ListFragment;
import android.app.LoaderManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.android.mail.ConversationListContext;
import com.android.mail.browse.ConversationCursor;
import com.android.mail.browse.ConversationItemView;
import com.android.mail.browse.ConversationItemViewModel;
import com.android.mail.browse.ConversationListFooterView;
import com.android.mail.browse.ToggleableItem;
import com.android.mail.providers.Account;
import com.android.mail.providers.AccountObserver;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import com.android.mail.providers.Settings;
import com.android.mail.utils.LogTag;
import com.android.mail.utils.LogUtils;
import com.android.mail.utils.Utils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public final class ConversationListFragment
  extends ListFragment
  implements AdapterView.OnItemLongClickListener, SwipeableListView.ListItemSwipedListener, ViewMode.ModeChangeListener
{
  private static final String LOG_TAG = ;
  private static int TIMESTAMP_UPDATE_INTERVAL = 0;
  private static boolean mTabletDevice;
  private Account mAccount;
  private final AccountObserver mAccountObserver = new AccountObserver()
  {
    public void onChanged(Account paramAnonymousAccount)
    {
      ConversationListFragment.access$002(ConversationListFragment.this, paramAnonymousAccount);
      ConversationListFragment.this.setSwipeAction();
    }
  };
  private ControllableActivity mActivity;
  private ConversationListCallbacks mCallbacks;
  private int mConversationCursorHash;
  private DataSetObserver mConversationListStatusObserver;
  private View mEmptyView;
  private ErrorListener mErrorListener;
  private Folder mFolder;
  private DataSetObserver mFolderObserver;
  private ConversationListFooterView mFooterView;
  private final Handler mHandler = new Handler();
  private AnimatedAdapter mListAdapter;
  private SwipeableListView mListView;
  private TextView mSearchResultCountTextView;
  private TextView mSearchStatusTextView;
  private View mSearchStatusView;
  private ConversationSelectionSet mSelectedSet;
  private Runnable mUpdateTimestampsRunnable = null;
  private ConversationUpdater mUpdater;
  private ConversationListContext mViewContext;
  
  private ConversationCursor getConversationListCursor()
  {
    if (mCallbacks != null) {
      return mCallbacks.getConversationListCursor();
    }
    return null;
  }
  
  private void initializeUiForFirstDisplay()
  {
    mSearchStatusView = mActivity.findViewById(2131755237);
    mSearchStatusTextView = ((TextView)mActivity.findViewById(2131755238));
    mSearchResultCountTextView = ((TextView)mActivity.findViewById(2131755239));
  }
  
  public static ConversationListFragment newInstance(ConversationListContext paramConversationListContext)
  {
    ConversationListFragment localConversationListFragment = new ConversationListFragment();
    Bundle localBundle = new Bundle();
    localBundle.putBundle("conversation-list", paramConversationListContext.toBundle());
    localConversationListFragment.setArguments(localBundle);
    return localConversationListFragment;
  }
  
  private void onCursorUpdated()
  {
    if ((mCallbacks == null) || (mListAdapter == null)) {
      return;
    }
    Object localObject = mCallbacks.getConversationListCursor();
    mListAdapter.swapCursor((Cursor)localObject);
    if (localObject == null) {}
    for (int i = 0;; i = ((ConversationCursor)localObject).hashCode())
    {
      if ((mConversationCursorHash == i) && (mConversationCursorHash != 0)) {
        mListAdapter.notifyDataSetChanged();
      }
      mConversationCursorHash = i;
      localObject = mCallbacks.getCurrentConversation();
      if ((localObject == null) || (mListView.getCheckedItemPosition() != -1)) {
        break;
      }
      setSelected(position);
      return;
    }
  }
  
  private void onFolderStatusUpdated()
  {
    Object localObject = getConversationListCursor();
    int i;
    label36:
    int k;
    if (localObject != null)
    {
      localObject = ((ConversationCursor)localObject).getExtras();
      if (!((Bundle)localObject).containsKey("cursor_error")) {
        break label107;
      }
      i = ((Bundle)localObject).getInt("cursor_error");
      k = ((Bundle)localObject).getInt("cursor_status");
      if (mFolder == null) {
        break label112;
      }
    }
    label107:
    label112:
    for (int j = mFolder.totalCount;; j = 0)
    {
      if (((i == 0) && ((k == 2) || (k == 8))) || (j > 0))
      {
        updateSearchResultHeader(j);
        if (j == 0) {
          mListView.setEmptyView(mEmptyView);
        }
      }
      return;
      localObject = Bundle.EMPTY;
      break;
      i = 0;
      break label36;
    }
  }
  
  private void setSwipeAction()
  {
    int i = Settings.getSwipeSetting(mAccount.settings);
    if ((i == 2) || (!mAccount.supportsCapability(16384)) || ((mFolder != null) && (mFolder.isTrash())))
    {
      mListView.enableSwipe(false);
      mListView.setCurrentFolder(mFolder);
      return;
    }
    if ((ConversationListContext.isSearchResult(mViewContext)) || ((mFolder != null) && (mFolder.type == 6))) {
      i = 2131755301;
    }
    for (;;)
    {
      mListView.setSwipeAction(i);
      break;
      if (mFolder == null)
      {
        i = 2131755300;
      }
      else
      {
        switch (i)
        {
        }
        do
        {
          do
          {
            i = 2131755301;
            break;
          } while (!mAccount.supportsCapability(8));
          if (mFolder.supportsCapability(16))
          {
            i = 2131755299;
            break;
          }
        } while (!mFolder.supportsCapability(8));
        i = 2131755300;
      }
    }
  }
  
  private void showList()
  {
    mListView.setEmptyView(null);
    onFolderUpdated(mActivity.getFolderController().getFolder());
    onConversationListStatusUpdated();
  }
  
  private void updateSearchResultHeader(int paramInt)
  {
    if (mActivity == null) {}
    Resources localResources;
    do
    {
      return;
      localResources = getResources();
    } while (!ConversationListContext.isSearchResult(mViewContext));
    mSearchStatusTextView.setText(localResources.getString(2131493027));
    mSearchResultCountTextView.setText(localResources.getString(2131493091, new Object[] { Integer.valueOf(paramInt) }));
  }
  
  public void commitDestructiveActions(boolean paramBoolean)
  {
    if (mListView != null) {
      mListView.commitDestructiveActions(paramBoolean);
    }
  }
  
  void configureSearchResultHeader()
  {
    if (mActivity == null) {
      return;
    }
    Object localObject = getResources();
    boolean bool = ConversationListContext.isSearchResult(mViewContext);
    if (bool)
    {
      mSearchStatusTextView.setText(((Resources)localObject).getString(2131493036));
      mSearchResultCountTextView.setText("");
    }
    View localView = mSearchStatusView;
    if (bool)
    {
      i = 0;
      localView.setVisibility(i);
      if (!bool) {
        break label111;
      }
    }
    label111:
    for (int i = (int)((Resources)localObject).getDimension(2131427392);; i = 0)
    {
      localObject = (ViewGroup.MarginLayoutParams)mListView.getLayoutParams();
      topMargin = i;
      mListView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      i = 8;
      break;
    }
  }
  
  public AnimatedAdapter getAnimatedAdapter()
  {
    return mListAdapter;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    paramBundle = getActivity();
    if (!(paramBundle instanceof ControllableActivity)) {
      LogUtils.e(LOG_TAG, "ConversationListFragment expects only a ControllableActivity tocreate it. Cannot proceed.", new Object[0]);
    }
    mActivity = ((ControllableActivity)paramBundle);
    mAccount = mAccountObserver.initialize(mActivity.getAccountController());
    mCallbacks = mActivity.getListHandler();
    mErrorListener = mActivity.getErrorListener();
    mFooterView = ((ConversationListFooterView)LayoutInflater.from(mActivity.getActivityContext()).inflate(2130968610, null));
    mFooterView.setClickListener(mActivity);
    paramBundle = getConversationListCursor();
    mListAdapter = new AnimatedAdapter(mActivity.getApplicationContext(), -1, paramBundle, mActivity.getSelectedSet(), mActivity, mListView);
    mListAdapter.addFooter(mFooterView);
    mListView.setAdapter(mListAdapter);
    mSelectedSet = mActivity.getSelectedSet();
    mListView.setSelectionSet(mSelectedSet);
    mListAdapter.hideFooter();
    mFolderObserver = new FolderObserver(null);
    mActivity.getFolderController().registerFolderObserver(mFolderObserver);
    mConversationListStatusObserver = new ConversationListStatusObserver(null);
    mUpdater = mActivity.getConversationUpdater();
    mUpdater.registerConversationListObserver(mConversationListStatusObserver);
    mTabletDevice = Utils.useTabletUI(mActivity.getApplicationContext());
    initializeUiForFirstDisplay();
    configureSearchResultHeader();
    onViewModeChanged(mActivity.getViewMode().getMode());
    mActivity.getViewMode().addListener(this);
    if (mActivity.isFinishing()) {
      return;
    }
    if (paramBundle == null) {}
    for (int i = 0;; i = paramBundle.hashCode())
    {
      mConversationCursorHash = i;
      if ((paramBundle != null) && (paramBundle.isRefreshReady())) {
        paramBundle.sync();
      }
      showList();
      paramBundle = mActivity.getPendingToastOperation();
      if (paramBundle == null) {
        break;
      }
      mActivity.setPendingToastOperation(null);
      mActivity.onUndoAvailable(paramBundle);
      return;
    }
  }
  
  public void onConversationListStatusUpdated()
  {
    ConversationCursor localConversationCursor = getConversationListCursor();
    if ((localConversationCursor != null) && (mFooterView.updateStatus(localConversationCursor))) {}
    for (boolean bool = true;; bool = false)
    {
      onFolderStatusUpdated();
      mListAdapter.setFooterVisibility(bool);
      onCursorUpdated();
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    TIMESTAMP_UPDATE_INTERVAL = getResources().getInteger(2131361815);
    mUpdateTimestampsRunnable = new Runnable()
    {
      public void run()
      {
        mListView.invalidateViews();
        mHandler.postDelayed(mUpdateTimestampsRunnable, ConversationListFragment.TIMESTAMP_UPDATE_INTERVAL);
      }
    };
    mViewContext = ConversationListContext.forBundle(getArguments().getBundle("conversation-list"));
    mAccount = mViewContext.account;
    setRetainInstance(false);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130968609, null);
    mEmptyView = paramLayoutInflater.findViewById(2131755106);
    mListView = ((SwipeableListView)paramLayoutInflater.findViewById(16908298));
    mListView.setHeaderDividersEnabled(false);
    mListView.setChoiceMode(1);
    mListView.setOnItemLongClickListener(this);
    mListView.enableSwipe(mAccount.supportsCapability(16384));
    mListView.setSwipedListener(this);
    if ((paramBundle != null) && (paramBundle.containsKey("list-state")))
    {
      mListView.onRestoreInstanceState(paramBundle.getParcelable("list-state"));
      mListView.clearChoices();
    }
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    mListAdapter.destroy();
    mListView.setAdapter(null);
    mActivity.unsetViewModeListener(this);
    if (!mActivity.isChangingConfigurations()) {
      mActivity.getLoaderManager().destroyLoader(mViewContext.hashCode());
    }
    if (mFolderObserver != null)
    {
      mActivity.getFolderController().unregisterFolderObserver(mFolderObserver);
      mFolderObserver = null;
    }
    if (mConversationListStatusObserver != null)
    {
      mUpdater.unregisterConversationListObserver(mConversationListStatusObserver);
      mConversationListStatusObserver = null;
    }
    mAccountObserver.unregisterAndDestroy();
    super.onDestroyView();
  }
  
  public void onFolderUpdated(Folder paramFolder)
  {
    mFolder = paramFolder;
    setSwipeAction();
    if (mFolder == null) {
      return;
    }
    mListAdapter.setFolder(mFolder);
    mFooterView.setFolder(mFolder);
    if (!mFolder.wasSyncSuccessful()) {
      mErrorListener.onError(mFolder, false);
    }
    onFolderStatusUpdated();
    ConversationItemViewModel.onFolderUpdated(mFolder);
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!(paramView instanceof ConversationItemView)) {
      return true;
    }
    ((ConversationItemView)paramView).toggleCheckMarkOrBeginDrag();
    return true;
  }
  
  public void onListItemClick(ListView paramListView, View paramView, int paramInt, long paramLong)
  {
    if (!(paramView instanceof ToggleableItem)) {
      return;
    }
    if ((mAccount.settings.hideCheckboxes) && (!mSelectedSet.isEmpty())) {
      ((ToggleableItem)paramView).toggleCheckMarkOrBeginDrag();
    }
    for (;;)
    {
      commitDestructiveActions(Utils.useTabletUI(mActivity.getActivityContext()));
      return;
      viewConversation(paramInt);
    }
  }
  
  public void onListItemSwiped(Collection<Conversation> paramCollection)
  {
    mUpdater.showNextConversation(paramCollection);
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    Utils.fixSubTreeLayoutIfOrphaned(getView(), "ConversationListFragment");
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (mListView != null) {
      paramBundle.putParcelable("list-state", mListView.onSaveInstanceState());
    }
  }
  
  public void onStart()
  {
    super.onStart();
    mHandler.postDelayed(mUpdateTimestampsRunnable, TIMESTAMP_UPDATE_INTERVAL);
  }
  
  public void onStop()
  {
    super.onStop();
    mHandler.removeCallbacks(mUpdateTimestampsRunnable);
  }
  
  public void onViewModeChanged(int paramInt)
  {
    if (mTabletDevice) {
      if (paramInt == 1) {
        mListView.setBackgroundResource(2130837643);
      }
    }
    for (;;)
    {
      if (mFooterView != null) {
        mFooterView.onViewModeChanged(paramInt);
      }
      return;
      if ((paramInt == 2) || (paramInt == 4))
      {
        mListView.clearChoices();
        mListView.setBackgroundDrawable(null);
        continue;
        mListView.setBackgroundDrawable(null);
      }
    }
  }
  
  public void requestDelete(int paramInt, Collection<Conversation> paramCollection, Collection<ConversationItemView> paramCollection1, final DestructiveAction paramDestructiveAction)
  {
    Object localObject = paramCollection.iterator();
    while (((Iterator)localObject).hasNext()) {
      nextlocalDeleteOnUpdate = true;
    }
    paramDestructiveAction = new SwipeableListView.ListItemsRemovedListener()
    {
      public void onListItemsRemoved()
      {
        paramDestructiveAction.performAction();
      }
    };
    localObject = (SwipeableListView)getListView();
    if (((SwipeableListView)localObject).getSwipeAction() == paramInt)
    {
      if (paramCollection1 == null)
      {
        ((SwipeableListView)localObject).destroyItems(paramCollection, paramDestructiveAction);
        return;
      }
      ((SwipeableListView)localObject).destroyItems(new ArrayList(paramCollection1), paramDestructiveAction);
      return;
    }
    mListAdapter.delete(paramCollection, paramDestructiveAction);
  }
  
  public void requestListRefresh()
  {
    mListAdapter.notifyDataSetChanged();
  }
  
  protected final void setSelected(int paramInt)
  {
    setSelected(paramInt, true);
  }
  
  public void setSelected(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      mListView.smoothScrollToPosition(paramInt);
    }
    mListView.setItemChecked(paramInt, true);
  }
  
  protected void viewConversation(int paramInt)
  {
    LogUtils.d(LOG_TAG, "ConversationListFragment.viewConversation(%d)", new Object[] { Integer.valueOf(paramInt) });
    setSelected(paramInt);
    Object localObject = getConversationListCursor();
    if ((localObject != null) && (((ConversationCursor)localObject).moveToPosition(paramInt)))
    {
      localObject = new Conversation((Cursor)localObject);
      position = paramInt;
      mCallbacks.onConversationSelected((Conversation)localObject, false);
    }
  }
  
  private class ConversationListStatusObserver
    extends DataSetObserver
  {
    private ConversationListStatusObserver() {}
    
    public void onChanged()
    {
      onConversationListStatusUpdated();
    }
  }
  
  private class FolderObserver
    extends DataSetObserver
  {
    private FolderObserver() {}
    
    public void onChanged()
    {
      if (mActivity == null) {}
      FolderController localFolderController;
      do
      {
        return;
        localFolderController = mActivity.getFolderController();
      } while (localFolderController == null);
      onFolderUpdated(localFolderController.getFolder());
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.ConversationListFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */