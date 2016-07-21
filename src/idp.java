import java.security.PrivilegedAction;

public final class idp
  implements PrivilegedAction
{
  private final ClassLoader a;
  private final String b;
  
  public idp(ClassLoader paramClassLoader, String paramString)
  {
    a = paramClassLoader;
    b = paramString;
  }
  
  public final Object run()
  {
    if (a != null) {
      return a.getResourceAsStream(b);
    }
    return ClassLoader.getSystemResourceAsStream(b);
  }
}

/* Location:
 * Qualified Name:     idp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */