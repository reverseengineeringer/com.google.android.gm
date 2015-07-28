package com.android.mail.browse;

import android.database.ContentObserver;
import android.os.Handler;

class ConversationCursor$CursorObserver
  extends ContentObserver
{
  public ConversationCursor$CursorObserver(ConversationCursor paramConversationCursor, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public void onChange(boolean paramBoolean)
  {
    ConversationCursor.access$900(this$0);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.ConversationCursor.CursorObserver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */