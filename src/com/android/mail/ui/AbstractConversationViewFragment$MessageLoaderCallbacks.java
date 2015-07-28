package com.android.mail.ui;

import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import com.android.mail.browse.MessageCursor;
import com.android.mail.providers.Conversation;
import com.android.mail.utils.LogUtils;

class AbstractConversationViewFragment$MessageLoaderCallbacks
  implements LoaderManager.LoaderCallbacks<Cursor>
{
  private AbstractConversationViewFragment$MessageLoaderCallbacks(AbstractConversationViewFragment paramAbstractConversationViewFragment) {}
  
  public Loader<Cursor> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    return new AbstractConversationViewFragment.MessageLoader(this$0.mActivity.getActivityContext(), this$0.mConversation, this$0);
  }
  
  public void onLoadFinished(Loader<Cursor> paramLoader, Cursor paramCursor)
  {
    if (AbstractConversationViewFragment.access$500(this$0) == paramCursor) {
      return;
    }
    paramCursor = (MessageCursor)paramCursor;
    if (LogUtils.isLoggable(AbstractConversationViewFragment.access$600(), 3)) {
      LogUtils.d(AbstractConversationViewFragment.access$600(), "LOADED CONVERSATION= %s", new Object[] { paramCursor.getDebugDump() });
    }
    if ((paramCursor.getCount() == 0) && (AbstractConversationViewFragment.access$500(this$0) != null))
    {
      if (AbstractConversationViewFragment.access$700(this$0)) {
        AbstractConversationViewFragment.access$800(this$0);
      }
      for (;;)
      {
        AbstractConversationViewFragment.access$502(this$0, null);
        return;
        LogUtils.i(AbstractConversationViewFragment.access$600(), "CVF: offscreen conv has no messages, ignoring update in anticipation of conv cursor update. c=%s", new Object[] { this$0.mConversation.uri });
      }
    }
    if (!paramCursor.isLoaded())
    {
      AbstractConversationViewFragment.access$502(this$0, null);
      return;
    }
    MessageCursor localMessageCursor = AbstractConversationViewFragment.access$500(this$0);
    AbstractConversationViewFragment.access$502(this$0, paramCursor);
    this$0.onMessageCursorLoadFinished(paramLoader, AbstractConversationViewFragment.access$500(this$0), localMessageCursor);
  }
  
  public void onLoaderReset(Loader<Cursor> paramLoader)
  {
    AbstractConversationViewFragment.access$502(this$0, null);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.AbstractConversationViewFragment.MessageLoaderCallbacks
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */