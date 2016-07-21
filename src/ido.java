import java.security.PrivilegedAction;
import org.apache.commons.logging.LogFactory;

public final class ido
  implements PrivilegedAction
{
  private final String a;
  private final ClassLoader b;
  
  public ido(String paramString, ClassLoader paramClassLoader)
  {
    a = paramString;
    b = paramClassLoader;
  }
  
  public final Object run()
  {
    return LogFactory.createFactory(a, b);
  }
}

/* Location:
 * Qualified Name:     ido
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */