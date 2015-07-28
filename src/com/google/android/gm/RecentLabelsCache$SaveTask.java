package com.google.android.gm;

import android.content.Context;
import android.os.AsyncTask;
import com.google.android.gm.provider.LabelManager;
import java.util.Map;

class RecentLabelsCache$SaveTask
  extends AsyncTask<Void, Void, Void>
{
  private final String mAccount;
  private final Context mContext;
  private final Map<String, Long> mTouchMap;
  
  RecentLabelsCache$SaveTask(Context paramContext, String paramString, Map<String, Long> paramMap)
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

/* Location:
 * Qualified Name:     com.google.android.gm.RecentLabelsCache.SaveTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */