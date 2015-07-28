package com.android.mail.browse;

import android.content.AsyncQueryHandler;
import android.content.ContentValues;
import android.content.Context;
import com.android.mail.providers.Message;

class MessageInviteView$InviteCommandHandler
  extends AsyncQueryHandler
{
  public MessageInviteView$InviteCommandHandler(MessageInviteView paramMessageInviteView)
  {
    super(paramMessageInviteView.getContext().getContentResolver());
  }
  
  public void sendCommand(ContentValues paramContentValues)
  {
    startUpdate(0, null, access$000this$0).uri, paramContentValues, null, null);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.MessageInviteView.InviteCommandHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */