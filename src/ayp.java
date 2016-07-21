import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public final class ayp
  extends bgr
{
  private static final String b = cvm.a;
  private static ayp c;
  
  private ayp(Context paramContext)
  {
    super(paramContext);
  }
  
  public static ayp a(Context paramContext)
  {
    if (!b(paramContext)) {
      return null;
    }
    if (c != null) {
      return c;
    }
    return new ayp(paramContext);
  }
  
  protected final bgs a(SQLiteDatabase paramSQLiteDatabase, android.accounts.Account paramAccount)
  {
    com.android.emailcommon.provider.Account localAccount = com.android.emailcommon.provider.Account.a(a, name);
    if (localAccount == null)
    {
      cvm.d(b, "EmailAppDataSearch: Cannot find account %s", new Object[] { cvm.a(name) });
      return null;
    }
    return new ayr(paramSQLiteDatabase, D);
  }
}

/* Location:
 * Qualified Name:     ayp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */