import java.security.PrivilegedAction;
import org.apache.commons.logging.LogFactory;

public final class idn
  implements PrivilegedAction
{
  public final Object run()
  {
    return LogFactory.directGetContextClassLoader();
  }
}

/* Location:
 * Qualified Name:     idn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */