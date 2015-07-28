package com.android.mail.ui;

import android.database.Cursor;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.android.mail.providers.Folder;

class FolderListFragment$HierarchicalFolderListAdapter
  extends ArrayAdapter<Folder>
  implements FolderListFragment.FolderListFragmentCursorAdapter
{
  private Cursor mCursor;
  private final FolderItemView.DropHandler mDropHandler;
  private final Folder mParent;
  private final Uri mParentUri;
  
  public FolderListFragment$HierarchicalFolderListAdapter(FolderListFragment paramFolderListFragment, Cursor paramCursor, Folder paramFolder)
  {
    super(FolderListFragment.access$000(paramFolderListFragment).getActivityContext(), 2130968638);
    mDropHandler = FolderListFragment.access$000(paramFolderListFragment);
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
      mCursor = FolderListFragment.access$1100(this$0);
      FolderListFragment.access$1102(this$0, null);
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
      if (uri.equals(FolderListFragment.access$700(this$0))) {
        this$0.getListView().setItemChecked(paramInt, true);
      }
      Folder.setFolderBlockColor(paramViewGroup, paramView.findViewById(2131755067));
      return paramView;
    }
    if (bool) {}
    for (int i = 2130968638;; i = 2130968595)
    {
      paramView = (FolderItemView)LayoutInflater.from(FolderListFragment.access$000(this$0).getActivityContext()).inflate(i, null);
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

/* Location:
 * Qualified Name:     com.android.mail.ui.FolderListFragment.HierarchicalFolderListAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */