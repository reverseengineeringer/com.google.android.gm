package com.google.android.gm;

import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.AsyncTask;
import com.google.android.gm.provider.Label;
import com.google.android.gm.provider.LabelList;
import com.google.android.gm.provider.LabelManager;
import com.google.android.gm.provider.LogUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RecentLabelsCache
{
  private static RecentLabelsCache sInstance;
  private String mAccount;
  private final Context mContext;
  private String[] mDefaultRecentLabels;
  private final Comparator<Label> mDisplayComparator;
  private final Map<String, Long> mMap;
  private final Set<RecentLabelList> mUpdateLists = Sets.newHashSet();
  
  private RecentLabelsCache(Context paramContext)
  {
    mContext = paramContext;
    mMap = Maps.newHashMap();
    mDisplayComparator = new Comparator()
    {
      public int compare(Label paramAnonymousLabel1, Label paramAnonymousLabel2)
      {
        return paramAnonymousLabel1.getName().compareToIgnoreCase(paramAnonymousLabel2.getName());
      }
    };
  }
  
  public static RecentLabelsCache getInstance(Context paramContext)
  {
    try
    {
      if (sInstance == null) {
        sInstance = new RecentLabelsCache(paramContext.getApplicationContext());
      }
      paramContext = sInstance;
      return paramContext;
    }
    finally {}
  }
  
  private List<String> getSortedRecentCanonicalNames(LabelList paramLabelList)
  {
    Object localObject = Lists.newArrayList();
    int i = 0;
    while (i < paramLabelList.size())
    {
      ((List)localObject).add(paramLabelList.get(i));
      i += 1;
    }
    Collections.sort((List)localObject, new Comparator()
    {
      public int compare(Label paramAnonymousLabel1, Label paramAnonymousLabel2)
      {
        long l1 = paramAnonymousLabel1.getLastTouched();
        long l2 = paramAnonymousLabel2.getLastTouched();
        if (l1 < l2) {
          return -1;
        }
        if (l1 == l2) {
          return 0;
        }
        return 1;
      }
    });
    paramLabelList = Lists.newArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramLabelList.add(((Label)((Iterator)localObject).next()).getCanonicalName());
    }
    return paramLabelList;
  }
  
  void clear()
  {
    mMap.clear();
  }
  
  public Comparator<Label> getRecentLabelDisplayComparator()
  {
    return mDisplayComparator;
  }
  
  public RecentLabelList getRecentLabelNames(String paramString, int paramInt, UiHandler paramUiHandler)
  {
    return getRecentLabelNames(paramString, paramInt, paramUiHandler, true);
  }
  
  RecentLabelList getRecentLabelNames(String paramString, int paramInt, UiHandler paramUiHandler, boolean paramBoolean)
  {
    paramString = getSortedRecentCanonicalNames(getRecentLabels(paramString, paramInt));
    if ((paramBoolean) && (paramString.isEmpty()))
    {
      if (mDefaultRecentLabels == null) {
        mDefaultRecentLabels = mContext.getResources().getStringArray(2131623947);
      }
      final String[] arrayOfString = mDefaultRecentLabels;
      if (arrayOfString.length > 0)
      {
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          paramString.add(arrayOfString[i]);
          i += 1;
        }
        paramUiHandler.post(new Runnable()
        {
          public void run()
          {
            String[] arrayOfString = arrayOfString;
            int j = arrayOfString.length;
            int i = 0;
            while (i < j)
            {
              String str = arrayOfString[i];
              touch(str);
              i += 1;
            }
          }
        });
      }
    }
    return new RecentLabelList(paramString, paramInt, null);
  }
  
  public RecentLabelList getRecentLabelNames(String paramString, UiHandler paramUiHandler)
  {
    return getRecentLabelNames(paramString, 5, paramUiHandler);
  }
  
  LabelList getRecentLabels(String paramString, int paramInt)
  {
    if ((mAccount != null) && (!mAccount.equals(paramString)))
    {
      save();
      mUpdateLists.clear();
    }
    mAccount = paramString;
    return LabelManager.getRecentLabelList(mContext, paramString, System.currentTimeMillis(), paramInt);
  }
  
  public void save()
  {
    if (!mMap.isEmpty())
    {
      HashMap localHashMap = Maps.newHashMap(mMap);
      new SaveTask(mContext, mAccount, localHashMap).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
      mMap.clear();
    }
  }
  
  void saveSync()
  {
    LabelManager.updateRecentLabels(mContext, mAccount, mMap);
  }
  
  public void touch(String paramString)
  {
    touch(paramString, System.currentTimeMillis());
  }
  
  void touch(String paramString, long paramLong)
  {
    mMap.put(paramString, Long.valueOf(paramLong));
    Iterator localIterator = mUpdateLists.iterator();
    while (localIterator.hasNext())
    {
      RecentLabelList localRecentLabelList = (RecentLabelList)localIterator.next();
      localRecentLabelList.addLabel(paramString);
      localRecentLabelList.notifyChanged();
    }
  }
  
  public class RecentLabelList
    extends DataSetObservable
    implements Iterable<String>
  {
    private final LRUCache<String, Void> mRecentLabelsLRU;
    
    private RecentLabelList(int paramInt)
    {
      int i;
      mRecentLabelsLRU = new LRUCache(i);
      this$1 = paramInt.iterator();
      while (hasNext())
      {
        paramInt = (String)next();
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
      mUpdateLists.add(this);
      if (mUpdateLists.size() > 3) {
        LogUtils.w("Gmail", "global RLC update set size=%d", new Object[] { Integer.valueOf(mUpdateLists.size()) });
      }
    }
    
    public int size()
    {
      return mRecentLabelsLRU.size();
    }
    
    public void unregisterAll()
    {
      super.unregisterAll();
      mUpdateLists.remove(this);
    }
    
    public void unregisterObserver(DataSetObserver paramDataSetObserver)
    {
      super.unregisterObserver(paramDataSetObserver);
      if (mObservers.isEmpty()) {
        mUpdateLists.remove(this);
      }
    }
  }
  
  private static class SaveTask
    extends AsyncTask<Void, Void, Void>
  {
    private final String mAccount;
    private final Context mContext;
    private final Map<String, Long> mTouchMap;
    
    SaveTask(Context paramContext, String paramString, Map<String, Long> paramMap)
    {
      mContext = paramContext;
      mAccount = paramString;
      mTouchMap = paramMap;
    }
    
    protected Void doInBackground(Void... paramVarArgs)
    {
      LabelManager.updateRecentLabels(mContext, mAccount, mTouchMap);
      return null;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.RecentLabelsCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */