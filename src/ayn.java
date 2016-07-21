import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public final class ayn
  extends SQLiteOpenHelper
{
  final Context a;
  
  public ayn(Context paramContext, String paramString)
  {
    super(paramContext, paramString, null, 101);
    a = paramContext;
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    cvm.b("EmailProvider", "Creating EmailProviderBody database", new Object[0]);
    aym.u(paramSQLiteDatabase);
    cfm.a(a).c(true);
  }
  
  public final void onOpen(SQLiteDatabase paramSQLiteDatabase) {}
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt1 < 5) {
      aym.v(paramSQLiteDatabase);
    }
    if (paramInt1 < 6) {
      aym.w(paramSQLiteDatabase);
    }
    if (paramInt1 < 8) {
      aym.x(paramSQLiteDatabase);
    }
    if (paramInt1 < 101) {
      aym.d(a, paramSQLiteDatabase);
    }
  }
}

/* Location:
 * Qualified Name:     ayn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */