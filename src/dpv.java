import android.database.sqlite.SQLiteDatabase;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class dpv
{
  public final drp a;
  public final SQLiteDatabase b;
  public final int c;
  
  dpv(drp paramdrp, SQLiteDatabase paramSQLiteDatabase)
  {
    a = paramdrp;
    b = paramSQLiteDatabase;
    c = paramSQLiteDatabase.getVersion();
  }
  
  private final int c(int paramInt)
  {
    buo.a().a("GmailDbInitializer", "upgrade_from", String.valueOf(paramInt), 0L);
    paramInt = b(paramInt);
    Method localMethod = d(paramInt);
    Throwable localThrowable = null;
    try
    {
      localMethod.invoke(this, new Object[0]);
      b.setVersion(paramInt);
      if (localThrowable != null) {
        throw new IllegalStateException("Failed to invoke upgrade Method", localThrowable);
      }
      return paramInt;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;) {}
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;) {}
    }
  }
  
  private final Method d(int paramInt)
  {
    Object localObject = getClass();
    try
    {
      localObject = ((Class)localObject).getMethod(22 + "upgradeDbTo" + paramInt, null);
      return (Method)localObject;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      throw new IllegalStateException(39 + "Missing upgrade to version: " + paramInt, localNoSuchMethodException);
    }
  }
  
  public abstract void a();
  
  final void a(int paramInt)
  {
    for (int i = c; i < paramInt; i = c(i)) {}
  }
  
  int b(int paramInt)
  {
    return paramInt + 1;
  }
}

/* Location:
 * Qualified Name:     dpv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */