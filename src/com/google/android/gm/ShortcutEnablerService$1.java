package com.google.android.gm;

import android.database.DataSetObserver;
import android.os.AsyncTask;
import com.google.android.gm.provider.LabelList;
import com.google.android.gm.provider.LabelManager;

class ShortcutEnablerService$1
  extends AsyncTask<Void, Void, LabelList>
{
  ShortcutEnablerService$1(ShortcutEnablerService paramShortcutEnablerService) {}
  
  protected LabelList doInBackground(Void... paramVarArgs)
  {
    return LabelManager.getLabelList(this$0, ShortcutEnablerService.access$000(this$0), null, false);
  }
  
  protected void onPostExecute(LabelList paramLabelList)
  {
    ShortcutEnablerService.access$102(this$0, paramLabelList);
    ShortcutEnablerService.access$100(this$0).registerForLabelChanges();
    ShortcutEnablerService.access$202(this$0, new DataSetObserver()
    {
      public void onChanged()
      {
        if (Utils.shortcutActivityEnabled(this$0)) {
          ShortcutEnablerService.access$300(this$0);
        }
        while (ShortcutEnablerService.access$100(this$0).get("^i") == null) {
          return;
        }
        ShortcutEnablerService.access$400(this$0);
      }
    });
    ShortcutEnablerService.access$100(this$0).registerDataSetObserver(ShortcutEnablerService.access$200(this$0));
    if (ShortcutEnablerService.access$100(this$0).get("^i") != null) {
      ShortcutEnablerService.access$400(this$0);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.ShortcutEnablerService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */