import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

final class chd
  extends SQLiteOpenHelper
{
  public chd(Context paramContext)
  {
    super(paramContext, "suggestions.db", null, 768);
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE suggestions (_id INTEGER PRIMARY KEY,display1 TEXT UNIQUE ON CONFLICT REPLACE,query TEXT,date LONG);");
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (((paramInt1 & 0xFF00) == 512) && ((paramInt2 & 0xFF00) == 768)) {
      return;
    }
    cty.a(paramSQLiteDatabase, "suggestions");
    onCreate(paramSQLiteDatabase);
  }
}

/* Location:
 * Qualified Name:     chd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */