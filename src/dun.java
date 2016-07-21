import android.database.sqlite.SQLiteDatabase;

public final class dun
{
  public static void a(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    paramSQLiteDatabase.delete("promotions", "_id = ?", new String[] { Long.toString(paramLong) });
  }
}

/* Location:
 * Qualified Name:     dun
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */