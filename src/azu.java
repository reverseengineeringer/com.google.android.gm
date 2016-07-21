import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

final class azu
  implements Runnable
{
  azu(azt paramazt, SQLiteDatabase paramSQLiteDatabase, Context paramContext) {}
  
  public final void run()
  {
    c.a(a);
    Cursor localCursor = a.rawQuery("SELECT _id FROM Message WHERE threadId IS NULL OR threadId = 0 ORDER BY timeStamp DESC", null);
    if (localCursor != null) {
      try
      {
        cvm.b(azt.a, "Threading: Found %d unthreaded messages", new Object[] { Integer.valueOf(localCursor.getCount()) });
        while (localCursor.moveToNext())
        {
          long l = localCursor.getLong(0);
          beb localbeb = beb.a(b, l);
          c.a(b, localbeb.e(), l, a);
        }
        if (localCursor == null) {
          return;
        }
      }
      finally
      {
        if (localCursor != null) {
          localCursor.close();
        }
      }
    }
    localCursor.close();
  }
}

/* Location:
 * Qualified Name:     azu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */