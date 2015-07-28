package com.google.android.gm;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class GviewActivity$2
  implements DialogInterface.OnDismissListener
{
  GviewActivity$2(GviewActivity paramGviewActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (GviewActivity.access$000(this$0).isLoading())
    {
      GviewActivity.access$000(this$0).cancel(true);
      this$0.finish();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.GviewActivity.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */