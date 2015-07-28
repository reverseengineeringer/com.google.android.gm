package com.android.mail.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import java.util.Collection;

class AbstractActivityController$7
  implements DialogInterface.OnClickListener
{
  AbstractActivityController$7(AbstractActivityController paramAbstractActivityController, Collection paramCollection, DestructiveAction paramDestructiveAction) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == -1) {
      this$0.delete(0, val$target, val$action);
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.AbstractActivityController.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */