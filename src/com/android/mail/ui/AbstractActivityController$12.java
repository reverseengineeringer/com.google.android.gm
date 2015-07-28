package com.android.mail.ui;

import com.android.mail.utils.Utils;

class AbstractActivityController$12
  implements ActionableToastBar.ActionClickedListener
{
  AbstractActivityController$12(AbstractActivityController paramAbstractActivityController) {}
  
  public void onActionClicked()
  {
    Utils.sendFeedback(this$0.mActivity.getActivityContext(), this$0.mAccount, true);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.AbstractActivityController.12
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */