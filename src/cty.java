import android.database.sqlite.SQLiteDatabase;
import java.util.Locale;

public final class cty
{
  public static void a(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {}
    for (paramString = "DROP TABLE IF EXISTS ".concat(paramString);; paramString = new String("DROP TABLE IF EXISTS "))
    {
      paramSQLiteDatabase.execSQL(paramString);
      return;
    }
  }
  
  public static void a(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2)
  {
    String str = String.valueOf(paramString1.toLowerCase(Locale.ENGLISH));
    paramSQLiteDatabase.execSQL(String.valueOf(str).length() + 21 + String.valueOf(paramString2).length() + String.valueOf(paramString1).length() + String.valueOf(paramString2).length() + "CREATE INDEX " + str + "_" + paramString2 + " ON " + paramString1 + " (" + paramString2 + ")");
  }
}

/* Location:
 * Qualified Name:     cty
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */