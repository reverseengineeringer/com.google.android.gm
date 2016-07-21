import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;

public final class dso
  extends AsyncTask<Void, Void, Void>
{
  private final long b;
  
  public dso(dsn paramdsn, long paramLong)
  {
    b = paramLong;
  }
  
  private final Void a()
  {
    a.l.r.a();
    try
    {
      String[] arrayOfString = new String[1];
      arrayOfString[0] = Long.toString(b);
      a.l.p.delete("conversations", "queryId != 0 AND queryId != ?", arrayOfString);
      a.l.p.delete("conversation_labels", "queryId != 0 AND queryId != ?", arrayOfString);
      a.l.r.c();
      return null;
    }
    finally
    {
      a.l.r.d();
    }
  }
}

/* Location:
 * Qualified Name:     dso
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */