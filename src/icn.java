import java.io.InputStream;
import java.net.URL;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class icn
{
  private static final Log a = LogFactory.getLog(icn.class);
  
  public static URL a(String paramString)
  {
    try
    {
      URL localURL = Thread.currentThread().getContextClassLoader().getResource(paramString);
      localObject = localURL;
      if (localURL == null)
      {
        paramString = String.valueOf(paramString);
        if (paramString.length() != 0)
        {
          paramString = "/".concat(paramString);
          localObject = icn.class.getResource(paramString);
        }
      }
      else
      {
        return (URL)localObject;
      }
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        Object localObject = a;
        String str = String.valueOf(localSecurityException.getMessage());
        if (str.length() != 0) {}
        for (str = "Unable to access context classloader, using default. ".concat(str);; str = new String("Unable to access context classloader, using default. "))
        {
          ((Log)localObject).info(str);
          str = null;
          break;
        }
        paramString = new String("/");
      }
    }
  }
  
  public static InputStream b(String paramString)
  {
    try
    {
      InputStream localInputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(paramString);
      localObject = localInputStream;
      if (localInputStream == null)
      {
        paramString = String.valueOf(paramString);
        if (paramString.length() != 0)
        {
          paramString = "/".concat(paramString);
          localObject = icn.class.getResourceAsStream(paramString);
        }
      }
      else
      {
        return (InputStream)localObject;
      }
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        Object localObject = a;
        String str = String.valueOf(localSecurityException.getMessage());
        if (str.length() != 0) {}
        for (str = "Unable to access context classloader, using default. ".concat(str);; str = new String("Unable to access context classloader, using default. "))
        {
          ((Log)localObject).info(str);
          str = null;
          break;
        }
        paramString = new String("/");
      }
    }
  }
}

/* Location:
 * Qualified Name:     icn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */