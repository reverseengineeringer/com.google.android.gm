package com.android.mail.ui;

import android.app.Activity;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.database.DataSetObservable;
import android.os.Bundle;
import com.android.mail.browse.ConversationCursor;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import com.android.mail.utils.LogUtils;

class AbstractActivityController$ConversationListLoaderCallbacks
  implements LoaderManager.LoaderCallbacks<ConversationCursor>
{
  private AbstractActivityController$ConversationListLoaderCallbacks(AbstractActivityController paramAbstractActivityController) {}
  
  public Loader<ConversationCursor> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    return new ConversationCursorLoader((Activity)this$0.mActivity, this$0.mAccount, this$0.mFolder.conversationListUri, this$0.mFolder.name);
  }
  
  public void onLoadFinished(Loader<ConversationCursor> paramLoader, ConversationCursor paramConversationCursor)
  {
    LogUtils.d(AbstractActivityController.LOG_TAG, "IN AAC.ConversationCursor.onLoadFinished, data=%s loader=%s", new Object[] { paramConversationCursor, paramLoader });
    AbstractActivityController.access$600(this$0, null);
    this$0.mConversationListCursor = paramConversationCursor;
    this$0.mConversationListCursor.addListener(this$0);
    this$0.mTracker.onCursorUpdated();
    AbstractActivityController.access$700(this$0).notifyChanged();
    paramLoader = this$0.getConversationListFragment();
    if ((paramLoader != null) && (paramLoader.isVisible())) {
      this$0.informCursorVisiblity(true);
    }
    if ((this$0.shouldShowFirstConversation()) && (this$0.mConversationListCursor.getCount() > 0))
    {
      this$0.mConversationListCursor.moveToPosition(0);
      paramLoader = new Conversation(this$0.mConversationListCursor);
      position = 0;
      this$0.onConversationSelected(paramLoader, true);
    }
  }
  
  public void onLoaderReset(Loader<ConversationCursor> paramLoader)
  {
    LogUtils.d(AbstractActivityController.LOG_TAG, "IN AAC.ConversationCursor.onLoaderReset, data=%s loader=%s", new Object[] { this$0.mConversationListCursor, paramLoader });
    if (this$0.mConversationListCursor != null)
    {
      this$0.mConversationListCursor.removeListener(this$0);
      this$0.mConversationListCursor = null;
      this$0.mTracker.onCursorUpdated();
      AbstractActivityController.access$700(this$0).notifyChanged();
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.AbstractActivityController.ConversationListLoaderCallbacks
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */