import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.os.Bundle;

class dsy
  extends SQLiteCursor
{
  dsz c;
  public final Object d = new Object();
  Bundle e = null;
  
  public dsy(drp paramdrp, SQLiteDatabase paramSQLiteDatabase, SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteQuery paramSQLiteQuery, dsz paramdsz)
  {
    super(paramSQLiteDatabase, paramSQLiteCursorDriver, paramString, paramSQLiteQuery);
    c = paramdsz;
  }
  
  public final void a(int paramInt)
  {
    if (e != null) {
      return;
    }
    synchronized (d)
    {
      e = c.a(paramInt);
      return;
    }
  }
  
  public final Bundle getExtras()
  {
    return e;
  }
  
  public boolean getWantsAllOnMoveCalls()
  {
    synchronized (d)
    {
      boolean bool = c.k();
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
    //   3: getfield 26	dsy:d	Ljava/lang/Object;
    //   6: astore_2
    //   7: aload_2
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 30	dsy:c	Ldsz;
    //   13: aload_1
    //   14: invokevirtual 49	dsz:a	(Landroid/os/Bundle;)Landroid/os/Bundle;
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
    //   0	34	0	this	dsy
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
 * Qualified Name:     dsy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */