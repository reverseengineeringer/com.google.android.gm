package com.google.android.gm;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.google.android.gm.persistence.Persistence;

class LabelSettingsFragment$2
  implements DialogInterface.OnClickListener
{
  LabelSettingsFragment$2(LabelSettingsFragment paramLabelSettingsFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    LabelSettingsFragment.access$300(this$0).setEnableNotifications(LabelSettingsFragment.access$100(this$0), LabelSettingsFragment.access$200(this$0), true);
    LabelSettingsFragment.access$402(this$0, true);
    LabelSettingsFragment.access$502(this$0, true);
    LabelSettingsFragment.access$600(this$0);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.LabelSettingsFragment.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */