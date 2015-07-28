package com.android.mail.ui;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.mail.providers.Folder;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class FolderSelectorAdapter
  extends BaseAdapter
{
  private Folder mExcludedFolder;
  protected final List<FolderRow> mFolderRows = Lists.newArrayList();
  private final String mHeader;
  private final LayoutInflater mInflater;
  private final int mLayout;
  
  public FolderSelectorAdapter(Context paramContext, Cursor paramCursor, int paramInt, String paramString, Folder paramFolder)
  {
    mInflater = LayoutInflater.from(paramContext);
    mLayout = paramInt;
    mHeader = paramString;
    mExcludedFolder = paramFolder;
    createFolderRows(paramCursor, null);
  }
  
  public FolderSelectorAdapter(Context paramContext, Cursor paramCursor, Set<String> paramSet, int paramInt, String paramString)
  {
    mInflater = LayoutInflater.from(paramContext);
    mLayout = paramInt;
    mHeader = paramString;
    createFolderRows(paramCursor, paramSet);
  }
  
  private final boolean hasHeader()
  {
    return mHeader != null;
  }
  
  public int correctPosition(int paramInt)
  {
    int i = paramInt;
    if (hasHeader()) {
      i = paramInt - 1;
    }
    return i;
  }
  
  protected void createFolderRows(Cursor paramCursor, Set<String> paramSet)
  {
    if (paramCursor == null) {
      return;
    }
    ArrayList localArrayList1 = Lists.newArrayList();
    ArrayList localArrayList2 = Lists.newArrayList();
    if (paramCursor.moveToFirst()) {}
    label157:
    label189:
    for (;;)
    {
      Folder localFolder = new Folder(paramCursor);
      boolean bool;
      FolderRow localFolderRow;
      if ((paramSet != null) && (paramSet.contains(uri.toString())))
      {
        bool = true;
        if ((meetsRequirements(localFolder)) && (!Objects.equal(localFolder, mExcludedFolder)))
        {
          localFolderRow = new FolderRow(localFolder, bool);
          if (!bool) {
            break label157;
          }
          mFolderRows.add(localFolderRow);
        }
      }
      for (;;)
      {
        if (paramCursor.moveToNext()) {
          break label189;
        }
        Collections.sort(mFolderRows);
        mFolderRows.addAll(localArrayList2);
        Collections.sort(localArrayList1);
        mFolderRows.addAll(localArrayList1);
        return;
        bool = false;
        break;
        if (localFolder.isProviderFolder()) {
          localArrayList2.add(localFolderRow);
        } else {
          localArrayList1.add(localFolderRow);
        }
      }
    }
  }
  
  public int getCount()
  {
    int j = mFolderRows.size();
    if (hasHeader()) {}
    for (int i = 1;; i = 0) {
      return i + j;
    }
  }
  
  public Object getItem(int paramInt)
  {
    if (isHeader(paramInt)) {
      return mHeader;
    }
    return mFolderRows.get(correctPosition(paramInt));
  }
  
  public long getItemId(int paramInt)
  {
    if (isHeader(paramInt)) {
      return -1L;
    }
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (isHeader(paramInt)) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (isHeader(paramInt))
    {
      if (paramView != null) {}
      for (paramView = (TextView)paramView;; paramView = (TextView)mInflater.inflate(2130968637, paramViewGroup, false))
      {
        paramView.setText(mHeader);
        return paramView;
      }
    }
    Object localObject1 = paramView;
    paramView = (View)localObject1;
    if (localObject1 == null) {
      paramView = mInflater.inflate(mLayout, paramViewGroup, false);
    }
    Object localObject2 = (FolderRow)getItem(paramInt);
    localObject1 = ((FolderRow)localObject2).getFolder();
    if (!TextUtils.isEmpty(hierarchicalDesc)) {}
    for (paramViewGroup = hierarchicalDesc;; paramViewGroup = name)
    {
      CompoundButton localCompoundButton = (CompoundButton)paramView.findViewById(2131755204);
      TextView localTextView = (TextView)paramView.findViewById(2131755245);
      if (localCompoundButton != null)
      {
        localCompoundButton.setClickable(false);
        localCompoundButton.setText(paramViewGroup);
        localCompoundButton.setChecked(((FolderRow)localObject2).isPresent());
      }
      if (localTextView != null) {
        localTextView.setText(paramViewGroup);
      }
      paramViewGroup = paramView.findViewById(2131755196);
      localObject2 = (ImageView)paramView.findViewById(2131755067);
      Folder.setFolderBlockColor((Folder)localObject1, paramViewGroup);
      Folder.setIcon((Folder)localObject1, (ImageView)localObject2);
      return paramView;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  protected final boolean isHeader(int paramInt)
  {
    return (paramInt == 0) && (hasHeader());
  }
  
  protected boolean meetsRequirements(Folder paramFolder)
  {
    return (paramFolder.supportsCapability(8)) && (type != 5) && (!Objects.equal(paramFolder, mExcludedFolder));
  }
  
  public static class FolderRow
    implements Comparable<FolderRow>
  {
    private final Folder mFolder;
    private boolean mIsPresent;
    
    public FolderRow(Folder paramFolder, boolean paramBoolean)
    {
      mFolder = paramFolder;
      mIsPresent = paramBoolean;
    }
    
    public int compareTo(FolderRow paramFolderRow)
    {
      if (equals(paramFolderRow)) {
        return 0;
      }
      if (mIsPresent != mIsPresent)
      {
        if (mIsPresent) {
          return -1;
        }
        return 1;
      }
      return mFolder.name.compareToIgnoreCase(mFolder.name);
    }
    
    public Folder getFolder()
    {
      return mFolder;
    }
    
    public boolean isPresent()
    {
      return mIsPresent;
    }
    
    public void setIsPresent(boolean paramBoolean)
    {
      mIsPresent = paramBoolean;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.FolderSelectorAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */