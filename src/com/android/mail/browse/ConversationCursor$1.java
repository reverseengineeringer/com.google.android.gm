package com.android.mail.browse;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.android.mail.providers.UIProvider;

class ConversationCursor$1
  implements Runnable
{
  ConversationCursor$1(ConversationCursor paramConversationCursor, Context paramContext, Uri paramUri) {}
  
  public void run()
  {
    Cursor localCursor = val$context.getContentResolver().query(val$undoUri, UIProvider.UNDO_PROJECTION, null, null, null);
    if (localCursor != null) {
      localCursor.close();
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.ConversationCursor.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */