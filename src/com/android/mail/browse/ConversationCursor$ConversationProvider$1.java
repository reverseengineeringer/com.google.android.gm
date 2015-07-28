package com.android.mail.browse;

import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

class ConversationCursor$ConversationProvider$1
  implements Runnable
{
  ConversationCursor$ConversationProvider$1(ConversationCursor.ConversationProvider paramConversationProvider, String paramString, HashMap paramHashMap) {}
  
  public void run()
  {
    try
    {
      ConversationCursor.access$1100().applyBatch(val$auth, (ArrayList)val$batchMap.get(val$auth));
      return;
    }
    catch (OperationApplicationException localOperationApplicationException) {}catch (RemoteException localRemoteException) {}
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.ConversationCursor.ConversationProvider.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */