package com.android.mail.browse;

import android.content.AsyncQueryHandler;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;

class AttachmentCommandHandler
  extends AsyncQueryHandler
{
  public AttachmentCommandHandler(Context paramContext)
  {
    super(paramContext.getContentResolver());
  }
  
  public void sendCommand(Uri paramUri, ContentValues paramContentValues)
  {
    startUpdate(0, null, paramUri, paramContentValues, null, null);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.AttachmentCommandHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */