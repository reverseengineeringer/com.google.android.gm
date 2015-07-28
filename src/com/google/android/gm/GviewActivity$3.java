package com.google.android.gm;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class GviewActivity$3
  implements DialogInterface.OnClickListener
{
  GviewActivity$3(GviewActivity paramGviewActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (GviewActivity.access$100(this$0)) {
      this$0.dismissDialog(1);
    }
    this$0.finish();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.GviewActivity.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */