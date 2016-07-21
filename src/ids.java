import java.security.PrivilegedAction;

public final class ids
  implements PrivilegedAction
{
  private final String a;
  private final String b;
  
  public ids(String paramString1, String paramString2)
  {
    a = paramString1;
    b = paramString2;
  }
  
  public final Object run()
  {
    return System.getProperty(a, b);
  }
}

/* Location:
 * Qualified Name:     ids
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */