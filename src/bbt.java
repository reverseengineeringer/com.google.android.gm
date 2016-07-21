import android.content.Context;

public abstract class bbt
{
  private static String a = null;
  private static bbt b = new bbu();
  
  public static String a(Context paramContext)
  {
    return c(paramContext, null);
  }
  
  public static String a(Context paramContext, String paramString)
  {
    return c(paramContext, paramString);
  }
  
  private static String c(Context paramContext, String paramString)
  {
    bbt localbbt;
    try
    {
      if (a != null) {
        break label54;
      }
      localbbt = b;
      if (paramContext == null) {
        throw new IllegalStateException("getDeviceId requires a Context");
      }
    }
    finally {}
    String str = localbbt.b(paramContext);
    if (str != null)
    {
      paramString = str;
      a = paramString;
      label54:
      paramContext = a;
      return paramContext;
    }
    if (paramString != null) {}
    for (;;)
    {
      localbbt.b(paramContext, paramString);
      break;
      paramString = localbbt.c(paramContext);
      if (paramString != null)
      {
        paramString = String.valueOf(paramString);
        if (paramString.length() != 0) {
          paramString = "androidc".concat(paramString);
        } else {
          paramString = new String("androidc");
        }
      }
      else
      {
        long l = System.currentTimeMillis();
        paramString = 27 + "android" + l;
      }
    }
  }
  
  protected abstract String b(Context paramContext);
  
  protected abstract void b(Context paramContext, String paramString);
  
  protected abstract String c(Context paramContext);
}

/* Location:
 * Qualified Name:     bbt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */