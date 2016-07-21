import android.content.Context;
import android.database.DefaultDatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public final class dsv
  extends SQLiteOpenHelper
{
  private dtm b;
  
  dsv(drp paramdrp, Context paramContext, String paramString)
  {
    super(paramContext, paramString, null, 202, new DefaultDatabaseErrorHandler());
    if (cxd.a()) {
      setWriteAheadLoggingEnabled(true);
    }
  }
  
  final dtm a(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      if (b == null) {
        b = new dtm(a, paramSQLiteDatabase);
      }
      paramSQLiteDatabase = b;
      return paramSQLiteDatabase;
    }
    finally {}
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    a(paramSQLiteDatabase).a();
  }
  
  public final void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.setMaxSqlCacheSize(50);
    if ((!cxd.a()) && (paramSQLiteDatabase != null) && (paramSQLiteDatabase.isOpen()) && (!paramSQLiteDatabase.isReadOnly())) {
      paramSQLiteDatabase.enableWriteAheadLogging();
    }
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase = a(paramSQLiteDatabase);
    if ((paramInt1 < 36) || ((paramInt1 < 100) && (paramInt1 > 80)))
    {
      paramSQLiteDatabase.a();
      return;
    }
    paramSQLiteDatabase.a(202);
  }
}

/* Location:
 * Qualified Name:     dsv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */