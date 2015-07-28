package com.google.android.gm;

import android.database.DataSetObserver;
import com.google.android.gm.provider.LabelList;

class ShortcutEnablerService$1$1
  extends DataSetObserver
{
  ShortcutEnablerService$1$1(ShortcutEnablerService.1 param1) {}
  
  public void onChanged()
  {
    if (Utils.shortcutActivityEnabled(this$1.this$0)) {
      ShortcutEnablerService.access$300(this$1.this$0);
    }
    while (ShortcutEnablerService.access$100(this$1.this$0).get("^i") == null) {
      return;
    }
    ShortcutEnablerService.access$400(this$1.this$0);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.ShortcutEnablerService.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */