package com.android.mail.ui;

import com.android.mail.browse.ConversationCursor;
import com.android.mail.providers.Account;

class AbstractActivityController$8
  implements ActionableToastBar.ActionClickedListener
{
  AbstractActivityController$8(AbstractActivityController paramAbstractActivityController, AnimatedAdapter paramAnimatedAdapter) {}
  
  public void onActionClicked()
  {
    if (this$0.mAccount.undoUri != null)
    {
      if (this$0.mConversationListCursor != null) {
        this$0.mConversationListCursor.undo(this$0.mActivity.getActivityContext(), this$0.mAccount.undoUri);
      }
      if (val$listAdapter != null) {
        val$listAdapter.setUndo(true);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.AbstractActivityController.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */