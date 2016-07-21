import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public final class cgd
{
  private static final String[] a = { "_id", "save", "message", "attachment", "retries" };
  
  public static int a(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    try
    {
      int i = d(paramSQLiteDatabase, paramLong);
      ContentValues localContentValues = new ContentValues(1);
      localContentValues.put("retries", Integer.valueOf(i + 1));
      return paramSQLiteDatabase.update("drive_operations", localContentValues, "_id=?", new String[] { Long.toString(paramLong) });
    }
    catch (IllegalArgumentException paramSQLiteDatabase) {}
    return 0;
  }
  
  public static long a(SQLiteDatabase paramSQLiteDatabase, ContentValues paramContentValues)
  {
    Cursor localCursor = chb.i(paramSQLiteDatabase, paramContentValues.getAsLong("save").longValue());
    try
    {
      if (localCursor.getCount() > 0)
      {
        long l = paramSQLiteDatabase.insert("drive_operations", null, paramContentValues);
        return l;
      }
      return -1L;
    }
    finally
    {
      localCursor.close();
    }
  }
  
  public static void a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE drive_operations (_id INTEGER PRIMARY KEY AUTOINCREMENT,save INTEGER,message TEXT,attachment TEXT,retries INTEGER)");
  }
  
  public static int b(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    return paramSQLiteDatabase.delete("drive_operations", "save=?", new String[] { Long.toString(paramLong) });
  }
  
  public static void b(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS drive_operations");
  }
  
  public static Cursor c(SQLiteDatabase paramSQLiteDatabase)
  {
    return paramSQLiteDatabase.query("drive_operations", a, null, null, null, null, "_id asc");
  }
  
  public static Cursor c(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    return paramSQLiteDatabase.query("drive_operations", a, "_id=?", new String[] { Long.toString(paramLong) }, null, null, null);
  }
  
  private static int d(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    paramSQLiteDatabase = c(paramSQLiteDatabase, paramLong);
    try
    {
      if (paramSQLiteDatabase.moveToFirst())
      {
        int i = paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndex("retries"));
        return i;
      }
      throw new IllegalArgumentException(31 + "Invalid id " + paramLong);
    }
    finally
    {
      paramSQLiteDatabase.close();
    }
  }
}

/* Location:
 * Qualified Name:     cgd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */