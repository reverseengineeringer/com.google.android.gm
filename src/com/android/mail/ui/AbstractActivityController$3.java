package com.android.mail.ui;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import com.android.mail.utils.LogUtils;
import java.util.ArrayList;

class AbstractActivityController$3
  extends DataSetObservable
{
  AbstractActivityController$3(AbstractActivityController paramAbstractActivityController) {}
  
  public void registerObserver(DataSetObserver paramDataSetObserver)
  {
    int i = mObservers.size();
    super.registerObserver(paramDataSetObserver);
    LogUtils.d(AbstractActivityController.LOG_TAG, "IN AAC.register(RecentFolder)Observer: %s before=%d after=%d", new Object[] { paramDataSetObserver, Integer.valueOf(i), Integer.valueOf(mObservers.size()) });
  }
  
  public void unregisterObserver(DataSetObserver paramDataSetObserver)
  {
    int i = mObservers.size();
    super.unregisterObserver(paramDataSetObserver);
    LogUtils.d(AbstractActivityController.LOG_TAG, "IN AAC.unregister(RecentFolder)Observer: %s before=%d after=%d", new Object[] { paramDataSetObserver, Integer.valueOf(i), Integer.valueOf(mObservers.size()) });
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.AbstractActivityController.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */