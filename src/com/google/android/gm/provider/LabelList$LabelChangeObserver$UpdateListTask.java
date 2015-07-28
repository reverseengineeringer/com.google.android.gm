package com.google.android.gm.provider;

import android.os.AsyncTask;

class LabelList$LabelChangeObserver$UpdateListTask
  extends AsyncTask<Void, Void, LabelList>
{
  LabelList$LabelChangeObserver$UpdateListTask(LabelList.LabelChangeObserver paramLabelChangeObserver) {}
  
  protected LabelList doInBackground(Void... paramVarArgs)
  {
    return LabelManager.getLabelList(LabelList.LabelChangeObserver.access$400(this$0), LabelList.LabelChangeObserver.access$500(this$0), null, LabelList.LabelChangeObserver.access$600(this$0));
  }
  
  protected void onPostExecute(LabelList paramLabelList)
  {
    LabelList.LabelChangeObserver.access$700(this$0, paramLabelList);
    LabelList.LabelChangeObserver.access$802(this$0, null);
    if (LabelList.LabelChangeObserver.access$900(this$0)) {
      LabelList.LabelChangeObserver.access$1000(this$0);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.LabelList.LabelChangeObserver.UpdateListTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */