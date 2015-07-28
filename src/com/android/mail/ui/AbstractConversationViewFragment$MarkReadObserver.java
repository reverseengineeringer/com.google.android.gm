package com.android.mail.ui;

import android.database.DataSetObserver;
import com.android.mail.providers.Conversation;
import com.android.mail.utils.LogUtils;

class AbstractConversationViewFragment$MarkReadObserver
  extends DataSetObserver
{
  private final ConversationUpdater mListController;
  
  private AbstractConversationViewFragment$MarkReadObserver(AbstractConversationViewFragment paramAbstractConversationViewFragment, ConversationUpdater paramConversationUpdater)
  {
    mListController = paramConversationUpdater;
  }
  
  public void onChanged()
  {
    if (mListController.getConversationListCursor() == null) {
      return;
    }
    mListController.unregisterConversationListObserver(this);
    AbstractConversationViewFragment.access$1002(this$0, null);
    LogUtils.i(AbstractConversationViewFragment.access$600(), "running deferred conv mark read on open, id=%d", new Object[] { Long.valueOf(this$0.mConversation.id) });
    this$0.markReadOnSeen(mListController);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.AbstractConversationViewFragment.MarkReadObserver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */