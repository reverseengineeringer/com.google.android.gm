public abstract class fnd<T>
{
  public static fnh a = null;
  public static int b = 0;
  private static final Object e = new Object();
  private static String f = "com.google.android.providers.gsf.permission.READ_GSERVICES";
  public final String c;
  public final T d;
  private T g = null;
  
  protected fnd(String paramString, T paramT)
  {
    c = paramString;
    d = paramT;
  }
  
  public static fnd<Integer> a(String paramString, Integer paramInteger)
  {
    return new fnf(paramString, paramInteger);
  }
  
  public static fnd<Long> a(String paramString, Long paramLong)
  {
    return new fne(paramString, paramLong);
  }
  
  public static fnd<String> a(String paramString1, String paramString2)
  {
    return new fng(paramString1, paramString2);
  }
  
  protected abstract T a();
  
  public final T b()
  {
    if (g != null) {
      return (T)g;
    }
    return (T)a();
  }
}

/* Location:
 * Qualified Name:     fnd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */