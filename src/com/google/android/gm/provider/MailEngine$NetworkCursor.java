package com.google.android.gm.provider;

import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.os.Bundle;

class MailEngine$NetworkCursor
  extends SQLiteCursor
{
  MailEngine.NetworkCursorLogic mLogic;
  protected final Object mLogicLock = new Object();
  
  public MailEngine$NetworkCursor(MailEngine paramMailEngine, SQLiteDatabase paramSQLiteDatabase, SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteQuery paramSQLiteQuery, MailEngine.NetworkCursorLogic paramNetworkCursorLogic)
  {
    super(paramSQLiteDatabase, paramSQLiteCursorDriver, paramString, paramSQLiteQuery);
    mLogic = paramNetworkCursorLogic;
  }
  
  public final Bundle getExtras()
  {
    synchronized (mLogicLock)
    {
      Bundle localBundle = mLogic.getExtras();
      return localBundle;
    }
  }
  
  public boolean getWantsAllOnMoveCalls()
  {
    synchronized (mLogicLock)
    {
      boolean bool = mLogic.getWantsAllOnMoveCalls();
      return bool;
    }
  }
  
  /* Error */
  public Bundle respond(Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	com/google/android/gm/provider/MailEngine$NetworkCursor:mLogicLock	Ljava/lang/Object;
    //   6: astore_2
    //   7: aload_2
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 29	com/google/android/gm/provider/MailEngine$NetworkCursor:mLogic	Lcom/google/android/gm/provider/MailEngine$NetworkCursorLogic;
    //   13: aload_1
    //   14: invokevirtual 44	com/google/android/gm/provider/MailEngine$NetworkCursorLogic:respond	(Landroid/os/Bundle;)Landroid/os/Bundle;
    //   17: astore_1
    //   18: aload_2
    //   19: monitorexit
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_1
    //   23: areturn
    //   24: astore_1
    //   25: aload_2
    //   26: monitorexit
    //   27: aload_1
    //   28: athrow
    //   29: astore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	NetworkCursor
    //   0	34	1	paramBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   9	20	24	finally
    //   25	27	24	finally
    //   2	9	29	finally
    //   27	29	29	finally
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailEngine.NetworkCursor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */