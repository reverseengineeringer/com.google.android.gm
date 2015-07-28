package com.google.android.gm;

import android.content.AsyncTaskLoader;
import android.content.Context;

public class RecentLabelLoader
  extends AsyncTaskLoader<RecentLabelsCache.RecentLabelList>
{
  private final String mAccount;
  private UiHandler mDefaultTouchHandler;
  
  public RecentLabelLoader(Context paramContext, String paramString, UiHandler paramUiHandler)
  {
    super(paramContext);
    mAccount = paramString;
    mDefaultTouchHandler = paramUiHandler;
  }
  
  public RecentLabelsCache.RecentLabelList loadInBackground()
  {
    return RecentLabelsCache.getInstance(getContext()).getRecentLabelNames(mAccount, mDefaultTouchHandler);
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
    cancelLoad();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.RecentLabelLoader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */