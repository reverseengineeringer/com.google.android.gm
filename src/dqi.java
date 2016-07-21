import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

final class dqi
  implements bgs
{
  private long a = 0L;
  private long b = 0L;
  private SQLiteDatabase c;
  
  dqi(SQLiteDatabase paramSQLiteDatabase)
  {
    c = paramSQLiteDatabase;
    try
    {
      paramSQLiteDatabase = c.rawQuery("SELECT min(_id), max(_id) FROM search_sequence", null);
      try
      {
        if (paramSQLiteDatabase.moveToNext())
        {
          a = paramSQLiteDatabase.getLong(0);
          b = paramSQLiteDatabase.getLong(1);
        }
        return;
      }
      finally
      {
        paramSQLiteDatabase.close();
      }
      return;
    }
    catch (SQLiteException paramSQLiteDatabase)
    {
      buo.a().a("index_scheduling", "failure", "no_search_sequence_table", 0L);
      dri.e(dqh.b, paramSQLiteDatabase, "Finding range in search_sequence failed. Aborting indexing.", new Object[0]);
    }
  }
  
  public final long a()
  {
    return a;
  }
  
  public final void a(long paramLong)
  {
    c.beginTransaction();
    try
    {
      c.delete("search_sequence", "_id <= ?", new String[] { String.valueOf(paramLong) });
      ContentValues localContentValues = new ContentValues(1);
      localContentValues.put("seqnos_trimmed", Integer.valueOf(1));
      c.update("search_status", localContentValues, null, null);
      c.setTransactionSuccessful();
      return;
    }
    finally
    {
      c.endTransaction();
    }
  }
  
  public final long b()
  {
    return b;
  }
}

/* Location:
 * Qualified Name:     dqi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */