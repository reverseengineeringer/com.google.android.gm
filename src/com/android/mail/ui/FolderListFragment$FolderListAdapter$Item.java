package com.android.mail.ui;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.android.mail.providers.Folder;

class FolderListFragment$FolderListAdapter$Item
{
  public final Folder mFolder;
  public final int mFolderType;
  public int mPosition;
  public final int mResource;
  public final int mType;
  
  private FolderListFragment$FolderListAdapter$Item(FolderListFragment.FolderListAdapter paramFolderListAdapter, int paramInt)
  {
    mFolder = null;
    mResource = paramInt;
    mType = 1;
    mFolderType = 0;
  }
  
  private FolderListFragment$FolderListAdapter$Item(FolderListFragment.FolderListAdapter paramFolderListAdapter, Folder paramFolder, int paramInt1, int paramInt2)
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
    for (paramView = (FolderItemView)paramView;; paramView = (FolderItemView)FolderListFragment.FolderListAdapter.access$400(this$1).inflate(2130968638, null, false))
    {
      paramView.bind(mFolder, FolderListFragment.access$000(this$1.this$0));
      if (FolderListFragment.access$500(this$1.this$0) != null)
      {
        boolean bool1 = bool2;
        if (mFolderType == FolderListFragment.access$600(this$1.this$0))
        {
          bool1 = bool2;
          if (mFolder.uri.equals(FolderListFragment.access$700(this$1.this$0))) {
            bool1 = true;
          }
        }
        FolderListFragment.access$500(this$1.this$0).setItemChecked(paramInt, bool1);
      }
      Folder.setFolderBlockColor(mFolder, paramView.findViewById(2131755196));
      Folder.setIcon(mFolder, (ImageView)paramView.findViewById(2131755067));
      return paramView;
    }
  }
  
  private final View getHeaderView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null) {}
    for (paramView = (TextView)paramView;; paramView = (TextView)FolderListFragment.FolderListAdapter.access$400(this$1).inflate(2130968640, paramViewGroup, false))
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

/* Location:
 * Qualified Name:     com.android.mail.ui.FolderListFragment.FolderListAdapter.Item
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */