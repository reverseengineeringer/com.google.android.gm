package com.android.mail.browse;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;

class ConversationCursor$ConversationProvider$ProviderExecute
  implements Runnable
{
  final int mCode;
  final Uri mUri;
  final ContentValues mValues;
  
  ConversationCursor$ConversationProvider$ProviderExecute(int paramInt, Uri paramUri, ContentValues paramContentValues)
  {
    mCode = paramInt;
    mUri = ConversationCursor.access$1000(paramUri);
    mValues = paramContentValues;
  }
  
  static Uri opInsert(Uri paramUri, ContentValues paramContentValues)
  {
    paramUri = new ProviderExecute(1, paramUri, paramContentValues);
    if (ConversationCursor.offUiThread()) {
      return (Uri)paramUri.go();
    }
    new Thread(paramUri).start();
    return null;
  }
  
  public Object go()
  {
    switch (mCode)
    {
    default: 
      return null;
    case 0: 
      return Integer.valueOf(ConversationCursor.access$1100().delete(mUri, null, null));
    case 1: 
      return ConversationCursor.access$1100().insert(mUri, mValues);
    }
    return Integer.valueOf(ConversationCursor.access$1100().update(mUri, mValues, null, null));
  }
  
  public void run()
  {
    go();
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.ConversationCursor.ConversationProvider.ProviderExecute
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */