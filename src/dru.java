import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteQuery;

final class dru
  implements SQLiteDatabase.CursorFactory
{
  dru(drp paramdrp, dsw paramdsw) {}
  
  public final Cursor newCursor(SQLiteDatabase paramSQLiteDatabase, SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteQuery paramSQLiteQuery)
  {
    return new dsk(b, paramSQLiteDatabase, paramSQLiteCursorDriver, paramString, paramSQLiteQuery, a);
  }
}

/* Location:
 * Qualified Name:     dru
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */