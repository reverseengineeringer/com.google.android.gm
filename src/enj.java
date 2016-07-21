import android.util.Log;

public final class enj
{
  public static final int a = 15;
  private static final String b = null;
  private final String c;
  private final String d;
  
  public enj(String paramString)
  {
    this(paramString, b);
  }
  
  private enj(String paramString1, String paramString2)
  {
    enz.a(paramString1, "log tag cannot be null");
    if (paramString1.length() <= 23) {}
    for (int i = 1; i == 0; i = 0) {
      throw new IllegalArgumentException(String.format("tag \"%s\" is longer than the %d character maximum", new Object[] { paramString1, Integer.valueOf(23) }));
    }
    c = paramString1;
    if ((paramString2 == null) || (paramString2.length() <= 0))
    {
      d = b;
      return;
    }
    d = paramString2;
  }
  
  public final String a(String paramString)
  {
    if (d == null) {
      return paramString;
    }
    return d.concat(paramString);
  }
  
  public final boolean a(int paramInt)
  {
    return Log.isLoggable(c, paramInt);
  }
}

/* Location:
 * Qualified Name:     enj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */