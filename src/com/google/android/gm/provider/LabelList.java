package com.google.android.gm.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class LabelList
{
  private static Map<LabelChangeObserver, Set<LabelList>> sAutoUpdateLists = Maps.newHashMap();
  private static Map<Uri, LabelChangeObserver> sLabelChangeObservers;
  private static Object sLabelListObserverLock = new Object();
  private final String mAccount;
  private final Context mContext;
  private final DataSetObservable mDataSetObservable = new DataSetObservable();
  private final boolean mIncludeHiddenLabels;
  private Uri mLabelUri;
  private final ArrayList<Label> mList = new ArrayList();
  
  static
  {
    sLabelChangeObservers = Maps.newHashMap();
  }
  
  LabelList(Context paramContext, String paramString, Uri paramUri, boolean paramBoolean)
  {
    mContext = paramContext;
    mAccount = paramString;
    mIncludeHiddenLabels = paramBoolean;
    if (paramContext == null) {
      LogUtils.e("Gmail", "Attempt to construct LabelList without context. Uri: %s", new Object[] { paramUri });
    }
    do
    {
      return;
      paramUri = paramContext.getContentResolver().query(paramUri, Gmail.LABEL_PROJECTION, null, null, null);
    } while (paramUri == null);
    try
    {
      paramContext = new LabelManager.LabelFactory(paramContext, paramString, paramUri);
      while (paramUri.moveToNext())
      {
        paramString = paramContext.newLabel(paramUri);
        mList.add(paramString);
      }
    }
    finally
    {
      paramUri.close();
    }
  }
  
  private void onLabelDataSetChanged()
  {
    mDataSetObservable.notifyChanged();
  }
  
  public Label get(int paramInt)
  {
    return (Label)mList.get(paramInt);
  }
  
  public Label get(String paramString)
  {
    if (paramString != null)
    {
      int j = size();
      int i = 0;
      while (i < j)
      {
        Label localLabel = get(i);
        if (paramString.equals(localLabel.getCanonicalName())) {
          return localLabel;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    mDataSetObservable.registerObserver(paramDataSetObserver);
  }
  
  public void registerForLabelChanges()
  {
    mLabelUri = Gmail.getLabelUri(mAccount);
    synchronized (sLabelListObserverLock)
    {
      Object localObject3 = (LabelChangeObserver)sLabelChangeObservers.get(mLabelUri);
      Object localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject1 = new LabelChangeObserver(mContext, mAccount, mIncludeHiddenLabels);
        sLabelChangeObservers.put(mLabelUri, localObject1);
      }
      Set localSet = (Set)sAutoUpdateLists.get(localObject1);
      localObject3 = localSet;
      if (localSet == null)
      {
        localObject3 = Sets.newHashSet();
        sAutoUpdateLists.put(localObject1, localObject3);
      }
      ((Set)localObject3).add(this);
      mContext.getContentResolver().registerContentObserver(mLabelUri, true, (ContentObserver)localObject1);
      return;
    }
  }
  
  public int size()
  {
    return mList.size();
  }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    mDataSetObservable.unregisterObserver(paramDataSetObserver);
  }
  
  public void unregisterForLabelChanges()
  {
    int j = 0;
    synchronized (sLabelListObserverLock)
    {
      LabelChangeObserver localLabelChangeObserver = (LabelChangeObserver)sLabelChangeObservers.get(mLabelUri);
      if (localLabelChangeObserver == null) {
        return;
      }
      Set localSet = (Set)sAutoUpdateLists.get(localLabelChangeObserver);
      int i = j;
      if (localSet != null)
      {
        localSet.remove(this);
        i = j;
        if (localSet.size() == 0)
        {
          sAutoUpdateLists.remove(localLabelChangeObserver);
          i = 1;
        }
      }
      if (i != 0)
      {
        mContext.getContentResolver().unregisterContentObserver(localLabelChangeObserver);
        return;
      }
    }
  }
  
  private static class LabelChangeObserver
    extends ContentObserver
  {
    private final String mAccount;
    private final Context mContext;
    private final boolean mIncludeHiddenLabels;
    private UpdateListTask mListRefreshTask = null;
    private boolean mUpdateRequested = false;
    
    public LabelChangeObserver(Context paramContext, String paramString, boolean paramBoolean)
    {
      super();
      mContext = paramContext.getApplicationContext();
      mAccount = paramString;
      mIncludeHiddenLabels = paramBoolean;
    }
    
    private void startUpdateTask()
    {
      mListRefreshTask = new UpdateListTask();
      mListRefreshTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
      mUpdateRequested = false;
    }
    
    private void updateAllRegisteredLists(LabelList paramLabelList)
    {
      synchronized (LabelList.sLabelListObserverLock)
      {
        Object localObject2 = (Set)LabelList.sAutoUpdateLists.get(this);
        if (localObject2 == null) {
          return;
        }
        localObject2 = Sets.newHashSet((Iterable)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          LabelList localLabelList = (LabelList)((Iterator)localObject2).next();
          mList.clear();
          mList.addAll(mList);
          localLabelList.onLabelDataSetChanged();
        }
      }
    }
    
    public boolean deliverSelfNotifications()
    {
      return true;
    }
    
    public void onChange(boolean paramBoolean)
    {
      if (mListRefreshTask == null)
      {
        startUpdateTask();
        return;
      }
      mUpdateRequested = true;
    }
    
    class UpdateListTask
      extends AsyncTask<Void, Void, LabelList>
    {
      UpdateListTask() {}
      
      protected LabelList doInBackground(Void... paramVarArgs)
      {
        return LabelManager.getLabelList(mContext, mAccount, null, mIncludeHiddenLabels);
      }
      
      protected void onPostExecute(LabelList paramLabelList)
      {
        LabelList.LabelChangeObserver.this.updateAllRegisteredLists(paramLabelList);
        LabelList.LabelChangeObserver.access$802(LabelList.LabelChangeObserver.this, null);
        if (mUpdateRequested) {
          LabelList.LabelChangeObserver.this.startUpdateTask();
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.LabelList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */