package com.google.android.gm.provider;

import android.content.AsyncTaskLoader;
import android.content.Context;

public class LabelLoader
  extends AsyncTaskLoader<LabelList>
{
  private final String mAccount;
  private final boolean mAutoRefresh;
  private LabelList mLabelList;
  
  public LabelLoader(Context paramContext, String paramString, boolean paramBoolean)
  {
    super(paramContext);
    mAccount = paramString;
    mAutoRefresh = paramBoolean;
  }
  
  public void deliverResult(LabelList paramLabelList)
  {
    super.deliverResult(paramLabelList);
    if (mAutoRefresh)
    {
      if (mLabelList != null) {
        mLabelList.unregisterForLabelChanges();
      }
      mLabelList = paramLabelList;
      if (mLabelList != null) {
        mLabelList.registerForLabelChanges();
      }
    }
  }
  
  public LabelList loadInBackground()
  {
    return LabelManager.getLabelList(getContext(), mAccount, null, false);
  }
  
  protected void onReset()
  {
    stopLoading();
  }
  
  protected void onStartLoading()
  {
    forceLoad();
  }
  
  protected void onStopLoading()
  {
    if ((mAutoRefresh) && (mLabelList != null))
    {
      mLabelList.unregisterForLabelChanges();
      mLabelList = null;
    }
    cancelLoad();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.LabelLoader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */