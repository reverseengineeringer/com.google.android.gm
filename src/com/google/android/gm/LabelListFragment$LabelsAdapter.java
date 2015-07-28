package com.google.android.gm;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Paint;
import android.graphics.drawable.PaintDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gm.provider.Label;
import com.google.android.gm.provider.LabelList;
import com.google.android.gm.utils.LabelColorUtils;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class LabelListFragment$LabelsAdapter
  extends BaseAdapter
{
  private LabelList mData;
  private final DataSetObserver mDataSetObserver = new DataSetObserver()
  {
    public void onChanged()
    {
      if (mData != null)
      {
        LabelListFragment.LabelsAdapter.this.extractLabelList();
        notifyDataSetChanged();
      }
    }
  };
  private final List<LabelListFragment.LabelListItem> mItems = Lists.newArrayList();
  private RecentLabelsCache.RecentLabelList mRecentLabels;
  
  private LabelListFragment$LabelsAdapter(LabelListFragment paramLabelListFragment) {}
  
  private void addSection(int paramInt, List<Label> paramList)
  {
    if (!paramList.isEmpty()) {
      mItems.add(new LabelListFragment.LabelListItem(LabelListFragment.access$400(this$0).getString(paramInt)));
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Label localLabel = (Label)paramList.next();
      mItems.add(new LabelListFragment.LabelListItem(localLabel));
    }
  }
  
  private void addSplitLabelLists(List<Label> paramList)
  {
    ArrayList localArrayList = Lists.newArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject1 = (Label)paramList.next();
      if (((Label)localObject1).isSystemLabel()) {
        mItems.add(new LabelListFragment.LabelListItem((Label)localObject1));
      } else {
        localArrayList.add(localObject1);
      }
    }
    paramList = Lists.newArrayList();
    Object localObject1 = mRecentLabels.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = mData.get((String)localObject2);
      if ((localObject2 != null) && (!shouldHideLabel((Label)localObject2))) {
        paramList.add(localObject2);
      }
    }
    Collections.sort(paramList, RecentLabelsCache.getInstance(LabelListFragment.access$400(this$0)).getRecentLabelDisplayComparator());
    addSection(2131493341, paramList);
    addSection(2131493342, localArrayList);
  }
  
  private void extractLabelList()
  {
    mItems.clear();
    Object localObject = Lists.newArrayList();
    int i = 0;
    Label localLabel;
    while (i < mData.size())
    {
      localLabel = mData.get(i);
      if (!shouldHideLabel(localLabel)) {
        ((List)localObject).add(localLabel);
      }
      i += 1;
    }
    if (hasRecentLabels()) {
      addSplitLabelLists((List)localObject);
    }
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localLabel = (Label)((Iterator)localObject).next();
        mItems.add(new LabelListFragment.LabelListItem(localLabel));
      }
    }
  }
  
  private View getLabelItemView(int paramInt, View paramView, ViewGroup paramViewGroup, LayoutInflater paramLayoutInflater, Label paramLabel)
  {
    if (paramView == null)
    {
      paramView = paramLayoutInflater.inflate(2130968649, null);
      paramViewGroup = new LabelListFragment.ViewHolder(null);
      labelCountView = ((TextView)paramView.findViewById(2131755068));
      name = ((TextView)paramView.findViewById(2131755069));
      description = ((TextView)paramView.findViewById(2131755070));
      labelBox = ((ImageView)paramView.findViewById(2131755203));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      ((LabelItemView)paramView).bind(LabelListFragment.access$700(this$0), paramLabel, LabelListFragment.access$800(this$0));
      name.setText(paramLabel.getName());
      if (this$0.isManageLabelMode())
      {
        description.setVisibility(0);
        description.setText(LabelListFragment.access$900(this$0, paramLabel.getCanonicalName()));
        labelCountView.setVisibility(8);
      }
      paramLayoutInflater = Utils.getUnreadCountString(LabelListFragment.access$400(this$0), Utils.getLabelDisplayCount(paramLabel));
      labelCountView.setText(paramLayoutInflater);
      paramInt = paramLabel.getBackgroundColor();
      if (paramInt != LabelColorUtils.getDefaultLabelBackgroundColor()) {
        break;
      }
      labelBox.setBackgroundDrawable(null);
      return paramView;
      paramViewGroup = (LabelListFragment.ViewHolder)paramView.getTag();
    }
    paramLayoutInflater = new PaintDrawable();
    paramLayoutInflater.getPaint().setColor(paramInt);
    labelBox.setBackgroundDrawable(paramLayoutInflater);
    return paramView;
  }
  
  private boolean hasRecentLabels()
  {
    return (mRecentLabels != null) && (mRecentLabels.size() > 0);
  }
  
  private boolean shouldHideLabel(Label paramLabel)
  {
    return (this$0.isManageLabelMode()) && ((paramLabel.getForceSyncNone()) || (paramLabel.getForceSyncAll()));
  }
  
  public boolean areAllItemsEnabled()
  {
    return false;
  }
  
  public int getCount()
  {
    return mItems.size();
  }
  
  public Object getItem(int paramInt)
  {
    return mItems.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((LabelListFragment.LabelListItem)mItems.get(paramInt)).getItemType();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    LabelListFragment.LabelListItem localLabelListItem = (LabelListFragment.LabelListItem)getItem(paramInt);
    if (!localLabelListItem.isHeader()) {
      return getLabelItemView(paramInt, paramView, paramViewGroup, LabelListFragment.access$500(this$0), mLabel);
    }
    if (paramView == null)
    {
      paramView = LabelListFragment.access$500(this$0).inflate(2130968651, paramViewGroup, false);
      paramViewGroup = new LabelListFragment.ViewHolder(null);
      name = ((TextView)paramView.findViewById(2131755069));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      name.setText(mHeaderText);
      return paramView;
      paramViewGroup = (LabelListFragment.ViewHolder)paramView.getTag();
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public boolean isEnabled(int paramInt)
  {
    if (!hasRecentLabels()) {
      return true;
    }
    if (!((LabelListFragment.LabelListItem)mItems.get(paramInt)).isHeader()) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void setData(LabelList paramLabelList)
  {
    if (mData != null) {
      mData.unregisterDataSetObserver(mDataSetObserver);
    }
    mData = paramLabelList;
    mData.registerDataSetObserver(mDataSetObserver);
    extractLabelList();
    notifyDataSetChanged();
  }
  
  public void setRecentLabels(RecentLabelsCache.RecentLabelList paramRecentLabelList)
  {
    if (mRecentLabels != null) {
      mRecentLabels.unregisterObserver(mDataSetObserver);
    }
    mRecentLabels = paramRecentLabelList;
    mRecentLabels.registerObserver(mDataSetObserver);
    if (mData != null)
    {
      extractLabelList();
      notifyDataSetChanged();
    }
  }
  
  public void stopListening()
  {
    if (mData != null) {
      mData.unregisterDataSetObserver(mDataSetObserver);
    }
    if (mRecentLabels != null) {
      mRecentLabels.unregisterObserver(mDataSetObserver);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.LabelListFragment.LabelsAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */