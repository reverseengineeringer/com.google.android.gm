package com.android.mail.ui;

import android.database.Cursor;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.android.mail.providers.Folder;
import com.android.mail.providers.RecentFolderObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class FolderListFragment$FolderListAdapter
  extends BaseAdapter
  implements FolderListFragment.FolderListFragmentCursorAdapter
{
  private Cursor mCursor = null;
  private final LayoutInflater mInflater;
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
  
  public FolderListFragment$FolderListAdapter(FolderListFragment paramFolderListFragment, int paramInt, boolean paramBoolean)
  {
    mInflater = LayoutInflater.from(FolderListFragment.access$000(paramFolderListFragment).getActivityContext());
    mIsSectioned = paramBoolean;
    paramFolderListFragment = FolderListFragment.access$000(paramFolderListFragment).getRecentFolderController();
    if ((paramFolderListFragment != null) && (mIsSectioned))
    {
      mRecentFolders = mRecentFolderObserver.initialize(paramFolderListFragment);
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
            if (FolderListFragment.access$1100(this$0) != null)
            {
              mCursor = FolderListFragment.access$1100(this$0);
              FolderListFragment.access$1102(this$0, null);
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
        paramView.bind(mFolder, FolderListFragment.access$000(this$0));
        if (FolderListFragment.access$500(this$0) != null)
        {
          boolean bool1 = bool2;
          if (mFolderType == FolderListFragment.access$600(this$0))
          {
            bool1 = bool2;
            if (mFolder.uri.equals(FolderListFragment.access$700(this$0))) {
              bool1 = true;
            }
          }
          FolderListFragment.access$500(this$0).setItemChecked(paramInt, bool1);
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

/* Location:
 * Qualified Name:     com.android.mail.ui.FolderListFragment.FolderListAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */