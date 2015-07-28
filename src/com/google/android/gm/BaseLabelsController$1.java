package com.google.android.gm;

import android.os.AsyncTask;
import com.google.android.gm.preference.PreferenceUtils;
import com.google.android.gm.provider.Gmail;
import com.google.android.gm.provider.Gmail.Settings;

class BaseLabelsController$1
  extends AsyncTask<Void, Void, Void>
{
  BaseLabelsController$1(BaseLabelsController paramBaseLabelsController) {}
  
  protected Void doInBackground(Void... paramVarArgs)
  {
    this$0.mSettings.setLabelsIncluded(BaseLabelsController.access$000(this$0));
    this$0.mSettings.setLabelsPartial(BaseLabelsController.access$100(this$0));
    this$0.mGmail.setSettings(this$0.mAccount, this$0.mSettings);
    PreferenceUtils.validateNotificationsForAccount(this$0.mContext, this$0.mAccount);
    return null;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.BaseLabelsController.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */