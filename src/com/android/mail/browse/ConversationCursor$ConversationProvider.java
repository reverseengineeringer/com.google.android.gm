package com.android.mail.browse;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import com.android.mail.providers.Conversation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public abstract class ConversationCursor$ConversationProvider
  extends ContentProvider
{
  public static String AUTHORITY;
  private ArrayList<Uri> mUndoDeleteUris = new ArrayList();
  private int mUndoSequence = 0;
  
  private void insertLocal(Uri paramUri, ContentValues paramContentValues) {}
  
  void addToUndoSequence(Uri paramUri)
  {
    if (ConversationCursor.access$1200() != mUndoSequence)
    {
      mUndoSequence = ConversationCursor.access$1200();
      mUndoDeleteUris.clear();
    }
    mUndoDeleteUris.add(paramUri);
  }
  
  public int apply(Collection<ConversationCursor.ConversationOperation> paramCollection, final ConversationCursor paramConversationCursor)
  {
    final HashMap localHashMap = new HashMap();
    ConversationCursor.access$1208();
    int i = 0;
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      ConversationCursor.ConversationOperation localConversationOperation = (ConversationCursor.ConversationOperation)localIterator.next();
      Uri localUri = ConversationCursor.access$1000(ConversationCursor.ConversationOperation.access$1700(localConversationOperation));
      String str = localUri.getAuthority();
      Object localObject = (ArrayList)localHashMap.get(str);
      paramCollection = (Collection<ConversationCursor.ConversationOperation>)localObject;
      if (localObject == null)
      {
        paramCollection = new ArrayList();
        localHashMap.put(str, paramCollection);
      }
      localObject = ConversationCursor.ConversationOperation.access$1800(localConversationOperation, localUri);
      if (localObject != null) {
        paramCollection.add(localObject);
      }
      if (ConversationCursor.ConversationOperation.access$1900(localConversationOperation)) {
        i = 1;
      }
    }
    if (i != 0) {
      ConversationCursor.access$1500(paramConversationCursor);
    }
    ConversationCursor.access$1600(paramConversationCursor);
    paramCollection = localHashMap.keySet().iterator();
    for (;;)
    {
      if (paramCollection.hasNext()) {
        paramConversationCursor = (String)paramCollection.next();
      }
      try
      {
        if (ConversationCursor.offUiThread()) {
          ConversationCursor.access$1100().applyBatch(paramConversationCursor, (ArrayList)localHashMap.get(paramConversationCursor));
        } else {
          new Thread(new Runnable()
          {
            public void run()
            {
              try
              {
                ConversationCursor.access$1100().applyBatch(paramConversationCursor, (ArrayList)localHashMap.get(paramConversationCursor));
                return;
              }
              catch (OperationApplicationException localOperationApplicationException) {}catch (RemoteException localRemoteException) {}
            }
          }).start();
        }
      }
      catch (OperationApplicationException paramConversationCursor)
      {
        continue;
        return ConversationCursor.access$1200();
      }
      catch (RemoteException paramConversationCursor) {}
    }
  }
  
  boolean clearMostlyDead(Uri paramUri, ConversationCursor paramConversationCursor)
  {
    return paramConversationCursor.clearMostlyDead(ConversationCursor.access$1300(paramUri));
  }
  
  void commitMostlyDead(Conversation paramConversation, ConversationCursor paramConversationCursor)
  {
    paramConversationCursor.commitMostlyDead(paramConversation);
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    throw new IllegalStateException("Unexpected call to ConversationProvider.delete");
  }
  
  void deleteLocal(Uri paramUri, ConversationCursor paramConversationCursor)
  {
    ConversationCursor.access$1400(paramConversationCursor, ConversationCursor.access$1300(paramUri), "__deleted__", Boolean.valueOf(true));
    addToUndoSequence(paramUri);
  }
  
  protected abstract String getAuthority();
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    insertLocal(paramUri, paramContentValues);
    return ProviderExecute.opInsert(paramUri, paramContentValues);
  }
  
  public boolean onCreate()
  {
    ConversationCursor.sProvider = this;
    AUTHORITY = getAuthority();
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return ConversationCursor.access$1100().query(ConversationCursor.access$1000(paramUri), paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
  }
  
  void setMostlyDead(Conversation paramConversation, ConversationCursor paramConversationCursor)
  {
    Uri localUri = uri;
    paramConversationCursor.setMostlyDead(ConversationCursor.access$1300(localUri), paramConversation);
    addToUndoSequence(localUri);
  }
  
  void undeleteLocal(Uri paramUri, ConversationCursor paramConversationCursor)
  {
    ConversationCursor.access$1400(paramConversationCursor, ConversationCursor.access$1300(paramUri), "__deleted__", Boolean.valueOf(false));
  }
  
  public void undo(ConversationCursor paramConversationCursor)
  {
    if (ConversationCursor.access$1200() == mUndoSequence)
    {
      Iterator localIterator = mUndoDeleteUris.iterator();
      while (localIterator.hasNext())
      {
        Uri localUri = (Uri)localIterator.next();
        if (!clearMostlyDead(localUri, paramConversationCursor)) {
          undeleteLocal(localUri, paramConversationCursor);
        }
      }
      mUndoSequence = 0;
      ConversationCursor.access$1500(paramConversationCursor);
      ConversationCursor.access$1600(paramConversationCursor);
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    throw new IllegalStateException("Unexpected call to ConversationProvider.delete");
  }
  
  void updateLocal(Uri paramUri, ContentValues paramContentValues, ConversationCursor paramConversationCursor)
  {
    if (paramContentValues == null) {}
    for (;;)
    {
      return;
      paramUri = ConversationCursor.access$1300(paramUri);
      Iterator localIterator = paramContentValues.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ConversationCursor.access$1400(paramConversationCursor, paramUri, str, paramContentValues.get(str));
      }
    }
  }
  
  static class ProviderExecute
    implements Runnable
  {
    final int mCode;
    final Uri mUri;
    final ContentValues mValues;
    
    ProviderExecute(int paramInt, Uri paramUri, ContentValues paramContentValues)
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
}

/* Location:
 * Qualified Name:     com.android.mail.browse.ConversationCursor.ConversationProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */