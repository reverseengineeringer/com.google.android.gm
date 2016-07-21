import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteQuery;
import android.os.Bundle;

public final class dup
  implements SQLiteDatabase.CursorFactory
{
  final String a;
  
  public dup(String paramString)
  {
    a = paramString;
  }
  
  private static Cursor a(SQLiteDatabase paramSQLiteDatabase, Cursor paramCursor)
  {
    Object localObject = "";
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT incarnation FROM search_status", null);
    paramSQLiteDatabase = (SQLiteDatabase)localObject;
    try
    {
      if (localCursor.moveToNext()) {
        paramSQLiteDatabase = localCursor.getString(0);
      }
      localCursor.close();
      localObject = new Bundle(paramCursor.getExtras());
      ((Bundle)localObject).putString("com.google.android.gms.appdatasearch.CONTENT_INCARNATION_KEY", paramSQLiteDatabase);
      return new ect(paramCursor, (Bundle)localObject);
    }
    finally
    {
      localCursor.close();
    }
  }
  
  public final Cursor newCursor(SQLiteDatabase paramSQLiteDatabase, SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteQuery paramSQLiteQuery)
  {
    if (a.equals("documents")) {}
    for (paramSQLiteCursorDriver = new dpq(paramSQLiteDatabase, paramSQLiteCursorDriver, paramString, paramSQLiteQuery, "section_body");; paramSQLiteCursorDriver = new SQLiteCursor(paramSQLiteDatabase, paramSQLiteCursorDriver, paramString, paramSQLiteQuery)) {
      return a(paramSQLiteDatabase, paramSQLiteCursorDriver);
    }
  }
}

/* Location:
 * Qualified Name:     dup
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */