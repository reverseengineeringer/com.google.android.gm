import android.content.Context;
import android.content.SharedPreferences;

public final class dyb
{
  static final nx<Integer> a = new nx();
  static boolean b = false;
  
  public static int a(long paramLong)
  {
    try
    {
      int i = ((Integer)a.a(paramLong, Integer.valueOf(0))).intValue();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void a(long paramLong, int paramInt)
  {
    try
    {
      a.b(paramLong, Integer.valueOf(paramInt));
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private static boolean a(Context paramContext)
  {
    return ghz.a(paramContext.getContentResolver(), "gmail-cal-promo-event-text", b);
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    return (a(paramContext)) && (!c(paramContext, paramString));
  }
  
  public static void b(Context paramContext, String paramString)
  {
    paramContext = cfg.b(paramContext, paramString);
    paramContext.d(10);
    paramContext.a(System.currentTimeMillis());
  }
  
  public static boolean c(Context paramContext, String paramString)
  {
    return d(paramContext, paramString) >= 10;
  }
  
  public static int d(Context paramContext, String paramString)
  {
    cfg localcfg = cfg.b(paramContext, paramString);
    int j = d.getInt("calendar-promotion-count", 0);
    if ((j >= 10) && (a(paramContext)))
    {
      long l = bd.getLong("calendar-promotion-time", 0L);
      if (System.currentTimeMillis() > l + 31449600000L) {}
      for (int i = 1; i != 0; i = 0)
      {
        localcfg.d(0);
        return 0;
      }
    }
    return j;
  }
  
  public static void e(Context paramContext, String paramString)
  {
    cfg localcfg = cfg.b(paramContext, paramString);
    localcfg.d(d(paramContext, paramString) + 1);
    localcfg.a(System.currentTimeMillis());
  }
}

/* Location:
 * Qualified Name:     dyb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */