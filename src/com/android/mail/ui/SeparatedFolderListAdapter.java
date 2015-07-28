package com.android.mail.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.Iterator;

public class SeparatedFolderListAdapter
  extends BaseAdapter
{
  public final ArrayList<FolderSelectorAdapter> sections = new ArrayList();
  
  public SeparatedFolderListAdapter(Context paramContext) {}
  
  public void addSection(FolderSelectorAdapter paramFolderSelectorAdapter)
  {
    sections.add(paramFolderSelectorAdapter);
  }
  
  public boolean areAllItemsEnabled()
  {
    return false;
  }
  
  public int getCount()
  {
    int i = 0;
    Iterator localIterator = sections.iterator();
    while (localIterator.hasNext()) {
      i += ((FolderSelectorAdapter)localIterator.next()).getCount();
    }
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    Iterator localIterator = sections.iterator();
    while (localIterator.hasNext())
    {
      FolderSelectorAdapter localFolderSelectorAdapter = (FolderSelectorAdapter)localIterator.next();
      int i = localFolderSelectorAdapter.getCount();
      if ((paramInt == 0) || (paramInt < i)) {
        return localFolderSelectorAdapter.getItem(paramInt);
      }
      paramInt -= i;
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    int j = 0;
    Iterator localIterator = sections.iterator();
    int i = paramInt;
    paramInt = j;
    while (localIterator.hasNext())
    {
      FolderSelectorAdapter localFolderSelectorAdapter = (FolderSelectorAdapter)localIterator.next();
      j = localFolderSelectorAdapter.getCount();
      if ((i == 0) || (i < j)) {
        return localFolderSelectorAdapter.getItemViewType(i) + paramInt;
      }
      i -= j;
      paramInt += localFolderSelectorAdapter.getViewTypeCount();
    }
    return -1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Iterator localIterator = sections.iterator();
    while (localIterator.hasNext())
    {
      FolderSelectorAdapter localFolderSelectorAdapter = (FolderSelectorAdapter)localIterator.next();
      int i = localFolderSelectorAdapter.getCount();
      if ((paramInt == 0) || (paramInt < i)) {
        return localFolderSelectorAdapter.getView(paramInt, paramView, paramViewGroup);
      }
      paramInt -= i;
    }
    return null;
  }
  
  public int getViewTypeCount()
  {
    int i = 0;
    Iterator localIterator = sections.iterator();
    while (localIterator.hasNext()) {
      i += ((FolderSelectorAdapter)localIterator.next()).getViewTypeCount();
    }
    return i;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return getItemViewType(paramInt) != 0;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.SeparatedFolderListAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */