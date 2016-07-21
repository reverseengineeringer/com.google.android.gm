import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteQuery;

final class drt
  implements SQLiteDatabase.CursorFactory
{
  drt(drp paramdrp, dsn paramdsn) {}
  
  public final Cursor newCursor(SQLiteDatabase paramSQLiteDatabase, SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteQuery paramSQLiteQuery)
  {
    return new dsm(b, paramSQLiteDatabase, paramSQLiteCursorDriver, paramString, paramSQLiteQuery, a);
  }
}

/* Location:
 * Qualified Name:     drt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */