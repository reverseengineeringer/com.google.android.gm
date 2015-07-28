package com.google.android.gm;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import com.google.android.gm.provider.LogUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class RecentLabelsCache$RecentLabelList
  extends DataSetObservable
  implements Iterable<String>
{
  private final LRUCache<String, Void> mRecentLabelsLRU;
  
  private RecentLabelsCache$RecentLabelList(List<String> paramList, int paramInt)
  {
    int i;
    mRecentLabelsLRU = new LRUCache(i);
    paramList = paramInt.iterator();
    while (paramList.hasNext())
    {
      paramInt = (String)paramList.next();
      mRecentLabelsLRU.addElement(paramInt, null);
    }
  }
  
  private void addLabel(String paramString)
  {
    mRecentLabelsLRU.addElement(paramString, null);
  }
  
  public Iterator<String> iterator()
  {
    return mRecentLabelsLRU.keySet().iterator();
  }
  
  public void registerObserver(DataSetObserver paramDataSetObserver)
  {
    super.registerObserver(paramDataSetObserver);
    RecentLabelsCache.access$200(this$0).add(this);
    if (RecentLabelsCache.access$200(this$0).size() > 3) {
      LogUtils.w("Gmail", "global RLC update set size=%d", new Object[] { Integer.valueOf(RecentLabelsCache.access$200(this$0).size()) });
    }
  }
  
  public int size()
  {
    return mRecentLabelsLRU.size();
  }
  
  public void unregisterAll()
  {
    super.unregisterAll();
    RecentLabelsCache.access$200(this$0).remove(this);
  }
  
  public void unregisterObserver(DataSetObserver paramDataSetObserver)
  {
    super.unregisterObserver(paramDataSetObserver);
    if (mObservers.isEmpty()) {
      RecentLabelsCache.access$200(this$0).remove(this);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.RecentLabelsCache.RecentLabelList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */