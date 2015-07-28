package com.google.android.gm.provider;

import android.content.Context;
import android.database.ContentObserver;
import android.os.AsyncTask;
import android.os.Handler;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class LabelList$LabelChangeObserver
  extends ContentObserver
{
  private final String mAccount;
  private final Context mContext;
  private final boolean mIncludeHiddenLabels;
  private UpdateListTask mListRefreshTask = null;
  private boolean mUpdateRequested = false;
  
  public LabelList$LabelChangeObserver(Context paramContext, String paramString, boolean paramBoolean)
  {
    super(new Handler());
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
    synchronized ()
    {
      Object localObject2 = (Set)LabelList.access$100().get(this);
      if (localObject2 == null) {
        return;
      }
      localObject2 = Sets.newHashSet((Iterable)localObject2).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        LabelList localLabelList = (LabelList)((Iterator)localObject2).next();
        LabelList.access$200(localLabelList).clear();
        LabelList.access$200(localLabelList).addAll(LabelList.access$200(paramLabelList));
        LabelList.access$300(localLabelList);
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

/* Location:
 * Qualified Name:     com.google.android.gm.provider.LabelList.LabelChangeObserver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */