package com.android.mail.ui;

import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import com.android.mail.browse.MessageCursor;
import com.android.mail.browse.MessageCursor.ConversationController;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.ListParams;
import com.android.mail.providers.UIProvider;

class AbstractConversationViewFragment$MessageLoader
  extends CursorLoader
{
  private final MessageCursor.ConversationController mController;
  private final Conversation mConversation;
  private boolean mDeliveredFirstResults = false;
  
  public AbstractConversationViewFragment$MessageLoader(Context paramContext, Conversation paramConversation, MessageCursor.ConversationController paramConversationController)
  {
    super(paramContext, messageListUri, UIProvider.MESSAGE_PROJECTION, null, null, null);
    mConversation = paramConversation;
    mController = paramConversationController;
  }
  
  public void deliverResult(Cursor paramCursor)
  {
    super.deliverResult(paramCursor);
    if (!mDeliveredFirstResults)
    {
      mDeliveredFirstResults = true;
      paramCursor = getUri();
      ListParams localListParams = new ListParams(-1, false);
      setUri(paramCursor.buildUpon().appendQueryParameter("listParams", localListParams.serialize()).build());
    }
  }
  
  public Cursor loadInBackground()
  {
    return new MessageCursor(super.loadInBackground(), mConversation, mController);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.AbstractConversationViewFragment.MessageLoader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */