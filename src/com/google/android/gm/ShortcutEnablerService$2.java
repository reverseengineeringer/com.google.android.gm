package com.google.android.gm;

import android.os.AsyncTask;

class ShortcutEnablerService$2
  extends AsyncTask<Void, Void, Void>
{
  ShortcutEnablerService$2(ShortcutEnablerService paramShortcutEnablerService) {}
  
  protected Void doInBackground(Void... paramVarArgs)
  {
    Utils.enableLabelShortcutActivity(this$0);
    return null;
  }
  
  protected void onPostExecute(Void paramVoid)
  {
    ShortcutEnablerService.access$300(this$0);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.ShortcutEnablerService.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */