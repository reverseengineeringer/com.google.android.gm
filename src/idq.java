import java.io.IOException;
import java.security.PrivilegedAction;
import java.util.Enumeration;
import org.apache.commons.logging.LogFactory;

public final class idq
  implements PrivilegedAction
{
  private final ClassLoader a;
  private final String b;
  
  public idq(ClassLoader paramClassLoader, String paramString)
  {
    a = paramClassLoader;
    b = paramString;
  }
  
  public final Object run()
  {
    try
    {
      if (a != null) {
        return a.getResources(b);
      }
      Enumeration localEnumeration = ClassLoader.getSystemResources(b);
      return localEnumeration;
    }
    catch (IOException localIOException)
    {
      if (LogFactory.isDiagnosticsEnabled())
      {
        LogFactory.access$000("Exception while trying to find configuration file " + b + ":" + localIOException.getMessage());
        return null;
      }
    }
    catch (NoSuchMethodError localNoSuchMethodError) {}
    return null;
  }
}

/* Location:
 * Qualified Name:     idq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */