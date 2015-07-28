package com.google.android.gm;

import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.os.Bundle;

class LabelListFragment$RecentLabelsLoaderCallbacks
  implements LoaderManager.LoaderCallbacks<RecentLabelsCache.RecentLabelList>
{
  private LabelListFragment$RecentLabelsLoaderCallbacks(LabelListFragment paramLabelListFragment) {}
  
  public Loader<RecentLabelsCache.RecentLabelList> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    return new RecentLabelLoader(LabelListFragment.access$400(this$0), LabelListFragment.access$700(this$0), LabelListFragment.access$1000(this$0));
  }
  
  public void onLoadFinished(Loader<RecentLabelsCache.RecentLabelList> paramLoader, RecentLabelsCache.RecentLabelList paramRecentLabelList)
  {
    LabelListFragment.access$1100(this$0).setRecentLabels(paramRecentLabelList);
  }
  
  public void onLoaderReset(Loader<RecentLabelsCache.RecentLabelList> paramLoader) {}
}

/* Location:
 * Qualified Name:     com.google.android.gm.LabelListFragment.RecentLabelsLoaderCallbacks
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */