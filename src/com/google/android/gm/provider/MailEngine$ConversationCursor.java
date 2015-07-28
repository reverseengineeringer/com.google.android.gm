package com.google.android.gm.provider;

import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.os.Bundle;
import android.text.TextUtils;

class MailEngine$ConversationCursor
  extends MailEngine.NetworkCursor
{
  boolean mContentsVisibleToUser = false;
  
  public MailEngine$ConversationCursor(MailEngine paramMailEngine, SQLiteDatabase paramSQLiteDatabase, SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteQuery paramSQLiteQuery, MailEngine.NetworkCursorLogic paramNetworkCursorLogic)
  {
    super(paramMailEngine, paramSQLiteDatabase, paramSQLiteCursorDriver, paramString, paramSQLiteQuery, paramNetworkCursorLogic);
  }
  
  MailEngine.ConversationCursorLogic getActiveConversationLogicOrNull()
  {
    synchronized (mLogicLock)
    {
      MailEngine.ConversationCursorLogic localConversationCursorLogic = (MailEngine.ConversationCursorLogic)mLogic;
      if (localConversationCursorLogic.isActiveNetworkCursor()) {
        return localConversationCursorLogic;
      }
      return null;
    }
  }
  
  public boolean onMove(int paramInt1, int paramInt2)
  {
    synchronized (mLogicLock)
    {
      MailEngine.ConversationCursorLogic localConversationCursorLogic = (MailEngine.ConversationCursorLogic)mLogic;
      localConversationCursorLogic.onMove(paramInt1, paramInt2, this);
      return super.onMove(paramInt1, paramInt2);
    }
  }
  
  public boolean requery()
  {
    MailEngine.ConversationCursorLogic localConversationCursorLogic = getActiveConversationLogicOrNull();
    if (localConversationCursorLogic != null)
    {
      localConversationCursorLogic.requery(this, mContentsVisibleToUser);
      String[] arrayOfString = localConversationCursorLogic.getSelectionArgs();
      if (arrayOfString != null) {
        setSelectionArguments(arrayOfString);
      }
    }
    boolean bool = super.requery();
    if (localConversationCursorLogic != null) {
      localConversationCursorLogic.onMove(0, 0, this);
    }
    return bool;
  }
  
  public Bundle respond(Bundle arg1)
  {
    Object localObject = ???.getString("command");
    Bundle localBundle1 = new Bundle();
    if (("setVisible".equals(localObject)) && (!???.getBoolean("visible")))
    {
      localBundle1.putString("commandResponse", "ok");
      return localBundle1;
    }
    if ("activate".equals(localObject)) {
      synchronized (mLogicLock)
      {
        localObject = (MailEngine.ConversationCursorLogic)mLogic;
        String str = ((MailEngine.ConversationCursorLogic)localObject).getQuery();
        if (!TextUtils.equals(MailEngine.access$3700(this$0), str))
        {
          localObject = new MailEngine.ConversationCursorLogic(this$0, str, true, null, MailEngine.ConversationCursorLogic.access$3800((MailEngine.ConversationCursorLogic)localObject));
          ((MailEngine.ConversationCursorLogic)localObject).configure(this);
          mLogic = ((MailEngine.NetworkCursorLogic)localObject);
          localBundle1.putString("commandResponse", "ok");
          return localBundle1;
        }
        mIsActiveNetworkCursor = true;
      }
    }
    if ("deactivate".equals(localObject)) {
      for (;;)
      {
        synchronized (mLogicLock)
        {
          localObject = (MailEngine.ConversationCursorLogic)mLogic;
          if (((MailEngine.ConversationCursorLogic)localObject).isActiveNetworkCursor())
          {
            mIsActiveNetworkCursor = false;
            localBundle2.putString("commandResponse", "ok");
            return localBundle2;
          }
        }
        localBundle3.putString("commandResponse", "failed");
      }
    }
    if ("setVisible".equals(localObject))
    {
      ??? = getActiveConversationLogicOrNull();
      if (??? != null) {
        MailEngine.ConversationCursorLogic.access$3900(???);
      }
      localBundle3.putString("commandResponse", "ok");
      return localBundle3;
    }
    return super.respond(???);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailEngine.ConversationCursor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */