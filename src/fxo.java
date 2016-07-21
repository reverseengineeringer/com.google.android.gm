import android.util.Log;

public final class fxo
{
  private static volatile boolean a;
  
  public static void a(String paramString1, String paramString2)
  {
    if (a(5)) {
      Log.w(paramString1, paramString2);
    }
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a(5)) {
      Log.w(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (a) || (Log.isLoggable("PeopleService", paramInt));
  }
}

/* Location:
 * Qualified Name:     fxo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */