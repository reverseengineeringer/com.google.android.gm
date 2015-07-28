package com.google.android.gm;

import android.app.ListFragment;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.Loader;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.Paint;
import android.graphics.drawable.PaintDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.gm.persistence.Persistence;
import com.google.android.gm.provider.Label;
import com.google.android.gm.provider.LabelList;
import com.google.android.gm.provider.LabelLoader;
import com.google.android.gm.utils.LabelColorUtils;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class LabelListFragment
  extends ListFragment
  implements LoaderManager.LoaderCallbacks<LabelList>, LabelSettingsObserver
{
  private String mAccount;
  private LabelsAdapter mAdapter;
  private LabelListCallbacks mCallbacks;
  private Context mContext;
  private LabelItemView.DropHandler mDropHandler;
  private LayoutInflater mInflater;
  private String mLabel;
  private ListView mListView;
  private int mMode;
  private int mOptions;
  private Persistence mPersistence;
  private final RecentLabelsLoaderCallbacks mRecentsCallbacks = new RecentLabelsLoaderCallbacks(null);
  private Resources mResources;
  private Parcelable mSavedListState;
  private LabelSettingsObservable mSettingsObservable;
  private UiHandler mUiHandler;
  
  private String getLabelDescription(String paramString)
  {
    boolean bool = mPersistence.shouldNotifyForLabel(mContext, mAccount, paramString);
    String str;
    if (mSettingsObservable.getIncludedLabels().contains(paramString)) {
      str = mResources.getString(2131493086);
    }
    while (bool)
    {
      return mResources.getString(2131493347, new Object[] { str, Utils.getLabelNotificationSummary(mContext, mAccount, paramString) });
      if (mSettingsObservable.getPartialLabels().contains(paramString))
      {
        str = Utils.formatPlural(mContext, 2131820568, mSettingsObservable.getNumberOfSyncDays());
      }
      else
      {
        str = mResources.getString(2131493346);
        bool = false;
      }
    }
    return str;
  }
  
  public static LabelListFragment newInstance(String paramString1, String paramString2, int paramInt)
  {
    return newInstance(paramString1, paramString2, paramInt, 0);
  }
  
  public static LabelListFragment newInstance(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    LabelListFragment localLabelListFragment = new LabelListFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("account", paramString1);
    localBundle.putString("label", paramString2);
    localBundle.putInt("mode", paramInt1);
    localBundle.putInt("options", paramInt2);
    localLabelListFragment.setArguments(localBundle);
    return localLabelListFragment;
  }
  
  boolean hideRecentLabels()
  {
    return (mOptions & 0x1) != 0;
  }
  
  boolean isManageLabelMode()
  {
    return mMode == 1;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    paramBundle = getActivity();
    mContext = paramBundle;
    mInflater = LayoutInflater.from(mContext);
    mResources = mContext.getResources();
    mPersistence = Persistence.getInstance();
    mCallbacks = ((LabelListCallbacks)paramBundle);
    if ((paramBundle instanceof LabelItemView.DropHandler)) {
      mDropHandler = ((LabelItemView.DropHandler)paramBundle);
    }
    if ((paramBundle instanceof LabelSettingsObservable))
    {
      mSettingsObservable = ((LabelSettingsObservable)paramBundle);
      mSettingsObservable.registerObserver(this);
    }
    mUiHandler = ((RestrictedActivity)paramBundle).getUiHandler();
    mAdapter = new LabelsAdapter(null);
    setListAdapter(mAdapter);
    getLoaderManager().initLoader(0, Bundle.EMPTY, this);
    if (!hideRecentLabels()) {
      getLoaderManager().initLoader(1, Bundle.EMPTY, mRecentsCallbacks);
    }
  }
  
  public void onChanged()
  {
    mAdapter.notifyDataSetChanged();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Bundle localBundle = getArguments();
    mAccount = localBundle.getString("account");
    mLabel = localBundle.getString("label");
    if ((paramBundle != null) && (paramBundle.containsKey("label"))) {
      mLabel = paramBundle.getString("label");
    }
    mMode = localBundle.getInt("mode");
    mOptions = localBundle.getInt("options");
    if (paramBundle != null) {
      mSavedListState = paramBundle.getParcelable("list-state");
    }
  }
  
  public Loader<LabelList> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    return new LabelLoader(getActivity(), mAccount, true);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130968650, null);
    mListView = ((ListView)paramLayoutInflater.findViewById(16908298));
    mListView.setEmptyView(null);
    mListView.setChoiceMode(1);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    if ((getActivity() instanceof LabelSettingsObservable)) {
      mSettingsObservable.unregisterObserver(this);
    }
    mAdapter.stopListening();
    mAdapter = null;
    super.onDestroyView();
  }
  
  public void onListItemClick(ListView paramListView, View paramView, int paramInt, long paramLong)
  {
    paramListView = (LabelListItem)paramListView.getItemAtPosition(paramInt);
    if (paramListView.isHeader()) {}
    do
    {
      return;
      paramListView = mLabel.getCanonicalName();
      mCallbacks.onLabelSelected(paramListView);
    } while (mLabel == null);
    mLabel = paramListView;
  }
  
  public void onLoadFinished(Loader<LabelList> paramLoader, LabelList paramLabelList)
  {
    mAdapter.setData(paramLabelList);
    mListView.setEmptyView(getView().findViewById(2131755106));
    if (mSavedListState != null)
    {
      mListView.onRestoreInstanceState(mSavedListState);
      mSavedListState = null;
    }
    if (mLabel != null) {
      setSelectedLabel(mLabel);
    }
  }
  
  public void onLoaderReset(Loader<LabelList> paramLoader) {}
  
  public void onPause()
  {
    super.onPause();
    if (mLabel == null) {
      mListView.clearChoices();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    mCallbacks.onLabelListResumed(this);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (mLabel != null) {
      paramBundle.putString("label", mLabel);
    }
    if (mListView != null) {
      paramBundle.putParcelable("list-state", mListView.onSaveInstanceState());
    }
  }
  
  public void setSelectedLabel(String paramString)
  {
    int k = -1;
    ListAdapter localListAdapter = getListAdapter();
    int i = 0;
    int j = k;
    if (i < localListAdapter.getCount())
    {
      Object localObject = (LabelListItem)localListAdapter.getItem(i);
      if (((LabelListItem)localObject).isHeader()) {}
      do
      {
        i += 1;
        break;
        localObject = mLabel;
      } while ((localObject == null) || (!((Label)localObject).getCanonicalName().equals(paramString)));
      j = i;
    }
    if (j != -1)
    {
      getListView().setItemChecked(j, true);
      getListView().smoothScrollToPosition(j);
    }
  }
  
  public static abstract interface LabelListCallbacks
  {
    public abstract void onLabelListResumed(LabelListFragment paramLabelListFragment);
    
    public abstract void onLabelSelected(String paramString);
  }
  
  private static class LabelListItem
  {
    final String mHeaderText;
    final Label mLabel;
    
    public LabelListItem(Label paramLabel)
    {
      mLabel = paramLabel;
      mHeaderText = null;
    }
    
    public LabelListItem(String paramString)
    {
      mHeaderText = paramString;
      mLabel = null;
    }
    
    public int getItemType()
    {
      if (mHeaderText != null) {
        return 0;
      }
      return 1;
    }
    
    public boolean isHeader()
    {
      return getItemType() == 0;
    }
  }
  
  private class LabelsAdapter
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
    
    private LabelsAdapter() {}
    
    private void addSection(int paramInt, List<Label> paramList)
    {
      if (!paramList.isEmpty()) {
        mItems.add(new LabelListFragment.LabelListItem(mContext.getString(paramInt)));
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
      Collections.sort(paramList, RecentLabelsCache.getInstance(mContext).getRecentLabelDisplayComparator());
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
        ((LabelItemView)paramView).bind(mAccount, paramLabel, mDropHandler);
        name.setText(paramLabel.getName());
        if (isManageLabelMode())
        {
          description.setVisibility(0);
          description.setText(LabelListFragment.this.getLabelDescription(paramLabel.getCanonicalName()));
          labelCountView.setVisibility(8);
        }
        paramLayoutInflater = Utils.getUnreadCountString(mContext, Utils.getLabelDisplayCount(paramLabel));
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
      return (isManageLabelMode()) && ((paramLabel.getForceSyncNone()) || (paramLabel.getForceSyncAll()));
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
        return getLabelItemView(paramInt, paramView, paramViewGroup, mInflater, mLabel);
      }
      if (paramView == null)
      {
        paramView = mInflater.inflate(2130968651, paramViewGroup, false);
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
  
  private class RecentLabelsLoaderCallbacks
    implements LoaderManager.LoaderCallbacks<RecentLabelsCache.RecentLabelList>
  {
    private RecentLabelsLoaderCallbacks() {}
    
    public Loader<RecentLabelsCache.RecentLabelList> onCreateLoader(int paramInt, Bundle paramBundle)
    {
      return new RecentLabelLoader(mContext, mAccount, mUiHandler);
    }
    
    public void onLoadFinished(Loader<RecentLabelsCache.RecentLabelList> paramLoader, RecentLabelsCache.RecentLabelList paramRecentLabelList)
    {
      mAdapter.setRecentLabels(paramRecentLabelList);
    }
    
    public void onLoaderReset(Loader<RecentLabelsCache.RecentLabelList> paramLoader) {}
  }
  
  private static class ViewHolder
  {
    TextView description;
    ImageView labelBox;
    TextView labelCountView;
    TextView name;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.LabelListFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */