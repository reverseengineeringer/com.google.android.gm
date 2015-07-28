package com.android.mail.ui;

import android.app.ListFragment;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.android.mail.providers.Folder;
import com.android.mail.providers.RecentFolderObserver;
import com.android.mail.providers.UIProvider;
import com.android.mail.utils.LogTag;
import com.android.mail.utils.LogUtils;
import com.android.mail.utils.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class FolderListFragment
  extends ListFragment
  implements LoaderManager.LoaderCallbacks<Cursor>
{
  private static final String LOG_TAG = ;
  private ControllableActivity mActivity;
  private ConversationListCallbacks mConversationListCallback;
  private FolderListFragmentCursorAdapter mCursorAdapter;
  private View mEmptyView;
  private Uri mFolderListUri;
  private FolderObserver mFolderObserver = null;
  private Cursor mFutureData;
  private boolean mIsSectioned;
  private ListView mListView;
  private FolderListSelectionListener mListener;
  private Folder mParentFolder;
  private int mSelectedFolderType = 0;
  private Uri mSelectedFolderUri = Uri.EMPTY;
  
  public static FolderListFragment newInstance(Folder paramFolder, Uri paramUri, boolean paramBoolean)
  {
    FolderListFragment localFolderListFragment = new FolderListFragment();
    Bundle localBundle = new Bundle();
    if (paramFolder != null) {
      localBundle.putParcelable("arg-parent-folder", paramFolder);
    }
    localBundle.putString("arg-folder-list-uri", paramUri.toString());
    localBundle.putBoolean("arg-is-sectioned", paramBoolean);
    localFolderListFragment.setArguments(localBundle);
    return localFolderListFragment;
  }
  
  private void setSelectedFolder(Folder paramFolder)
  {
    if (paramFolder == null) {
      mSelectedFolderUri = Uri.EMPTY;
    }
    do
    {
      return;
      mSelectedFolderUri = uri;
      setSelectedFolderType(paramFolder);
    } while (mCursorAdapter == null);
    mCursorAdapter.notifyDataSetChanged();
  }
  
  private void setSelectedFolderType(Folder paramFolder)
  {
    if (mSelectedFolderType != 0) {
      return;
    }
    if (paramFolder.isProviderFolder()) {}
    for (int i = 1;; i = 3)
    {
      mSelectedFolderType = i;
      return;
    }
  }
  
  private void updateCursorAdapter(Cursor paramCursor)
  {
    mCursorAdapter.setCursor(paramCursor);
    if ((paramCursor == null) || (paramCursor.getCount() == 0))
    {
      mEmptyView.setVisibility(0);
      mListView.setEmptyView(mEmptyView);
    }
  }
  
  private void viewFolder(int paramInt)
  {
    Object localObject1 = getListAdapter().getItem(paramInt);
    if ((localObject1 instanceof FolderListFragment.FolderListAdapter.Item))
    {
      localObject2 = (FolderListFragment.FolderListAdapter.Item)localObject1;
      localObject1 = mCursorAdapter.getFullFolder((FolderListFragment.FolderListAdapter.Item)localObject2);
      mSelectedFolderType = mFolderType;
      if (localObject1 == null) {
        break label113;
      }
      if (!((Folder)localObject1).equals(mParentFolder)) {
        break label105;
      }
    }
    label105:
    for (Object localObject2 = null;; localObject2 = mParentFolder)
    {
      parent = ((Folder)localObject2);
      mListener.onFolderSelected((Folder)localObject1);
      return;
      if ((localObject1 instanceof Folder))
      {
        localObject1 = (Folder)localObject1;
        break;
      }
      localObject1 = new Folder((Cursor)localObject1);
      break;
    }
    label113:
    LogUtils.d(LOG_TAG, "FolderListFragment unable to get a full fledged folder to hand to the listener for position %d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    Object localObject = null;
    super.onActivityCreated(paramBundle);
    paramBundle = getActivity();
    if (!(paramBundle instanceof ControllableActivity)) {
      LogUtils.wtf(LOG_TAG, "FolderListFragment expects only a ControllableActivity tocreate it. Cannot proceed.", new Object[0]);
    }
    mActivity = ((ControllableActivity)paramBundle);
    mConversationListCallback = mActivity.getListHandler();
    paramBundle = mActivity.getFolderController();
    mFolderObserver = new FolderObserver(null);
    if (paramBundle != null) {
      paramBundle.registerFolderObserver(mFolderObserver);
    }
    mListener = mActivity.getFolderListSelectionListener();
    if (mActivity.isFinishing()) {
      return;
    }
    if (mParentFolder != null)
    {
      mCursorAdapter = new HierarchicalFolderListAdapter(null, mParentFolder);
      paramBundle = mActivity.getHierarchyFolder();
      if ((paramBundle != null) && (!uri.equals(mSelectedFolderUri))) {
        setSelectedFolder(paramBundle);
      }
      setListAdapter(mCursorAdapter);
      getLoaderManager().initLoader(0, Bundle.EMPTY, this);
      return;
    }
    mCursorAdapter = new FolderListAdapter(2130968638, mIsSectioned);
    if (paramBundle == null) {}
    for (paramBundle = (Bundle)localObject;; paramBundle = paramBundle.getFolder()) {
      break;
    }
  }
  
  public void onAnimationEnd()
  {
    if (mFutureData != null)
    {
      updateCursorAdapter(mFutureData);
      mFutureData = null;
    }
  }
  
  public Loader<Cursor> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    mListView.setEmptyView(null);
    mEmptyView.setVisibility(8);
    return new CursorLoader(mActivity.getActivityContext(), mFolderListUri, UIProvider.FOLDERS_PROJECTION, null, null, null);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = getArguments();
    mFolderListUri = Uri.parse(paramViewGroup.getString("arg-folder-list-uri"));
    mParentFolder = ((Folder)paramViewGroup.getParcelable("arg-parent-folder"));
    mIsSectioned = paramViewGroup.getBoolean("arg-is-sectioned");
    paramLayoutInflater = paramLayoutInflater.inflate(2130968639, null);
    mListView = ((ListView)paramLayoutInflater.findViewById(16908298));
    mListView.setHeaderDividersEnabled(false);
    mListView.setChoiceMode(1);
    mListView.setEmptyView(null);
    if ((paramBundle != null) && (paramBundle.containsKey("flf-list-state"))) {
      mListView.onRestoreInstanceState(paramBundle.getParcelable("flf-list-state"));
    }
    mEmptyView = paramLayoutInflater.findViewById(2131755106);
    if ((paramBundle != null) && (paramBundle.containsKey("flf-selected-folder")))
    {
      mSelectedFolderUri = Uri.parse(paramBundle.getString("flf-selected-folder"));
      mSelectedFolderType = paramBundle.getInt("flf-selected-type");
    }
    while (mParentFolder == null) {
      return paramLayoutInflater;
    }
    mSelectedFolderUri = mParentFolder.uri;
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    if (mCursorAdapter != null) {
      mCursorAdapter.destroy();
    }
    setListAdapter(null);
    if (mFolderObserver != null)
    {
      FolderController localFolderController = mActivity.getFolderController();
      if (localFolderController != null)
      {
        localFolderController.unregisterFolderObserver(mFolderObserver);
        mFolderObserver = null;
      }
    }
    super.onDestroyView();
  }
  
  public void onListItemClick(ListView paramListView, View paramView, int paramInt, long paramLong)
  {
    viewFolder(paramInt);
  }
  
  public void onLoadFinished(Loader<Cursor> paramLoader, Cursor paramCursor)
  {
    if ((mConversationListCallback == null) || (!mConversationListCallback.isAnimating()))
    {
      updateCursorAdapter(paramCursor);
      return;
    }
    mFutureData = paramCursor;
    mCursorAdapter.setCursor(null);
  }
  
  public void onLoaderReset(Loader<Cursor> paramLoader)
  {
    mCursorAdapter.setCursor(null);
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    Utils.fixSubTreeLayoutIfOrphaned(getView(), "FolderListFragment");
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (mListView != null) {
      paramBundle.putParcelable("flf-list-state", mListView.onSaveInstanceState());
    }
    if (mSelectedFolderUri != null) {
      paramBundle.putString("flf-selected-folder", mSelectedFolderUri.toString());
    }
    paramBundle.putInt("flf-selected-type", mSelectedFolderType);
    paramBundle.putBoolean("arg-is-sectioned", mIsSectioned);
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  public boolean showingHierarchy()
  {
    return mParentFolder != null;
  }
  
  private class FolderListAdapter
    extends BaseAdapter
    implements FolderListFragment.FolderListFragmentCursorAdapter
  {
    private Cursor mCursor = null;
    private final LayoutInflater mInflater = LayoutInflater.from(mActivity.getActivityContext());
    private final boolean mIsSectioned;
    private final List<Item> mItemList = new ArrayList();
    private final RecentFolderObserver mRecentFolderObserver = new RecentFolderObserver()
    {
      public void onChanged()
      {
        FolderListFragment.FolderListAdapter.this.recalculateList();
      }
    };
    private final RecentFolderList mRecentFolders;
    
    public FolderListAdapter(int paramInt, boolean paramBoolean)
    {
      mIsSectioned = paramBoolean;
      this$1 = mActivity.getRecentFolderController();
      if ((FolderListFragment.this != null) && (mIsSectioned))
      {
        mRecentFolders = mRecentFolderObserver.initialize(FolderListFragment.this);
        return;
      }
      mRecentFolders = null;
    }
    
    private final List<Folder> getRecentFolders(RecentFolderList paramRecentFolderList)
    {
      ArrayList localArrayList = new ArrayList();
      if (paramRecentFolderList == null) {}
      for (;;)
      {
        return localArrayList;
        paramRecentFolderList = paramRecentFolderList.getRecentFolderList(null).iterator();
        while (paramRecentFolderList.hasNext())
        {
          Folder localFolder = (Folder)paramRecentFolderList.next();
          if (!localFolder.isProviderFolder()) {
            localArrayList.add(localFolder);
          }
        }
      }
    }
    
    private void recalculateList()
    {
      if ((mCursor == null) || (mCursor.isClosed()) || (mCursor.getCount() <= 0) || (!mCursor.moveToFirst())) {
        return;
      }
      mItemList.clear();
      if (!mIsSectioned)
      {
        do
        {
          localObject1 = Folder.getDeficientDisplayOnlyFolder(mCursor);
          mItemList.add(new Item((Folder)localObject1, 3, mCursor.getPosition(), null));
        } while (mCursor.moveToNext());
        notifyDataSetChanged();
        return;
      }
      Object localObject1 = new ArrayList();
      Object localObject2;
      for (;;)
      {
        localObject2 = Folder.getDeficientDisplayOnlyFolder(mCursor);
        if (((Folder)localObject2).isProviderFolder()) {
          mItemList.add(new Item((Folder)localObject2, 1, mCursor.getPosition(), null));
        }
        while (!mCursor.moveToNext())
        {
          localObject2 = getRecentFolders(mRecentFolders);
          if (((List)localObject2).size() <= 0) {
            break label300;
          }
          mItemList.add(new Item(2131493128, null));
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Folder localFolder = (Folder)((Iterator)localObject2).next();
            mItemList.add(new Item(localFolder, 2, -1, null));
          }
          ((List)localObject1).add(new Item((Folder)localObject2, 3, mCursor.getPosition(), null));
        }
      }
      label300:
      if (((List)localObject1).size() > 0)
      {
        mItemList.add(new Item(2131493127, null));
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Item)((Iterator)localObject1).next();
          mItemList.add(localObject2);
        }
      }
      notifyDataSetChanged();
    }
    
    public boolean areAllItemsEnabled()
    {
      return false;
    }
    
    public final void destroy()
    {
      mRecentFolderObserver.unregisterAndDestroy();
    }
    
    public int getCount()
    {
      return mItemList.size();
    }
    
    public Folder getFullFolder(Item paramItem)
    {
      Object localObject2 = null;
      Object localObject1;
      if (mFolderType == 2) {
        localObject1 = mFolder;
      }
      do
      {
        do
        {
          do
          {
            int i;
            do
            {
              return (Folder)localObject1;
              i = mPosition;
              if (mFutureData != null)
              {
                mCursor = mFutureData;
                FolderListFragment.access$1102(FolderListFragment.this, null);
              }
              localObject1 = localObject2;
            } while (i <= -1);
            localObject1 = localObject2;
          } while (mCursor == null);
          localObject1 = localObject2;
        } while (mCursor.isClosed());
        localObject1 = localObject2;
      } while (!mCursor.moveToPosition(mPosition));
      return new Folder(mCursor);
    }
    
    public Object getItem(int paramInt)
    {
      return mItemList.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return getItem(paramInt).hashCode();
    }
    
    public int getItemViewType(int paramInt)
    {
      return getItemmType;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      return ((Item)getItem(paramInt)).getView(paramInt, paramView, paramViewGroup);
    }
    
    public int getViewTypeCount()
    {
      return 2;
    }
    
    public boolean isEnabled(int paramInt)
    {
      return getItemmType != 1;
    }
    
    public void setCursor(Cursor paramCursor)
    {
      mCursor = paramCursor;
      recalculateList();
    }
    
    private class Item
    {
      public final Folder mFolder;
      public final int mFolderType;
      public int mPosition;
      public final int mResource;
      public final int mType;
      
      private Item(int paramInt)
      {
        mFolder = null;
        mResource = paramInt;
        mType = 1;
        mFolderType = 0;
      }
      
      private Item(Folder paramFolder, int paramInt1, int paramInt2)
      {
        mFolder = paramFolder;
        mResource = -1;
        mType = 0;
        mFolderType = paramInt1;
        mPosition = paramInt2;
      }
      
      private final View getFolderView(int paramInt, View paramView, ViewGroup paramViewGroup)
      {
        boolean bool2 = false;
        if (paramView != null) {}
        for (paramView = (FolderItemView)paramView;; paramView = (FolderItemView)mInflater.inflate(2130968638, null, false))
        {
          paramView.bind(mFolder, mActivity);
          if (mListView != null)
          {
            boolean bool1 = bool2;
            if (mFolderType == mSelectedFolderType)
            {
              bool1 = bool2;
              if (mFolder.uri.equals(mSelectedFolderUri)) {
                bool1 = true;
              }
            }
            mListView.setItemChecked(paramInt, bool1);
          }
          Folder.setFolderBlockColor(mFolder, paramView.findViewById(2131755196));
          Folder.setIcon(mFolder, (ImageView)paramView.findViewById(2131755067));
          return paramView;
        }
      }
      
      private final View getHeaderView(int paramInt, View paramView, ViewGroup paramViewGroup)
      {
        if (paramView != null) {}
        for (paramView = (TextView)paramView;; paramView = (TextView)mInflater.inflate(2130968640, paramViewGroup, false))
        {
          paramView.setText(mResource);
          return paramView;
        }
      }
      
      private final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
      {
        if (mType == 0) {
          return getFolderView(paramInt, paramView, paramViewGroup);
        }
        return getHeaderView(paramInt, paramView, paramViewGroup);
      }
    }
  }
  
  private static abstract interface FolderListFragmentCursorAdapter
    extends ListAdapter
  {
    public abstract void destroy();
    
    public abstract Folder getFullFolder(FolderListFragment.FolderListAdapter.Item paramItem);
    
    public abstract void notifyDataSetChanged();
    
    public abstract void setCursor(Cursor paramCursor);
  }
  
  public static abstract interface FolderListSelectionListener
  {
    public abstract void onFolderSelected(Folder paramFolder);
  }
  
  private final class FolderObserver
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
      FolderListFragment.this.setSelectedFolder(localFolderController.getFolder());
    }
  }
  
  private class HierarchicalFolderListAdapter
    extends ArrayAdapter<Folder>
    implements FolderListFragment.FolderListFragmentCursorAdapter
  {
    private Cursor mCursor;
    private final FolderItemView.DropHandler mDropHandler = mActivity;
    private final Folder mParent;
    private final Uri mParentUri;
    
    public HierarchicalFolderListAdapter(Cursor paramCursor, Folder paramFolder)
    {
      super(2130968638);
      mParent = paramFolder;
      mParentUri = uri;
      setCursor(paramCursor);
    }
    
    public void destroy() {}
    
    public Folder getFullFolder(FolderListFragment.FolderListAdapter.Item paramItem)
    {
      Object localObject2 = null;
      int i = mPosition;
      if ((mCursor == null) || (mCursor.isClosed()))
      {
        mCursor = mFutureData;
        FolderListFragment.access$1102(FolderListFragment.this, null);
      }
      Object localObject1 = localObject2;
      if (i > -1)
      {
        localObject1 = localObject2;
        if (mCursor != null)
        {
          localObject1 = localObject2;
          if (!mCursor.isClosed())
          {
            localObject1 = localObject2;
            if (mCursor.moveToPosition(mPosition)) {
              localObject1 = new Folder(mCursor);
            }
          }
        }
      }
      return (Folder)localObject1;
    }
    
    public int getItemViewType(int paramInt)
    {
      if (getItemuri.equals(mParentUri)) {
        return 0;
      }
      return 1;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      paramViewGroup = (Folder)getItem(paramInt);
      boolean bool = uri.equals(mParentUri);
      if (paramView != null)
      {
        paramView = (FolderItemView)paramView;
        paramView.bind(paramViewGroup, mDropHandler);
        if (uri.equals(mSelectedFolderUri)) {
          getListView().setItemChecked(paramInt, true);
        }
        Folder.setFolderBlockColor(paramViewGroup, paramView.findViewById(2131755067));
        return paramView;
      }
      if (bool) {}
      for (int i = 2130968638;; i = 2130968595)
      {
        paramView = (FolderItemView)LayoutInflater.from(mActivity.getActivityContext()).inflate(i, null);
        break;
      }
    }
    
    public int getViewTypeCount()
    {
      return 2;
    }
    
    public void setCursor(Cursor paramCursor)
    {
      mCursor = paramCursor;
      clear();
      if (mParent != null) {
        add(mParent);
      }
      if ((paramCursor != null) && (paramCursor.getCount() > 0))
      {
        paramCursor.moveToFirst();
        do
        {
          Folder localFolder = new Folder(paramCursor);
          parent = mParent;
          add(localFolder);
        } while (paramCursor.moveToNext());
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.FolderListFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */