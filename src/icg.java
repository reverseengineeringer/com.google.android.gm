import java.util.Properties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public final class icg
{
  private static final Log a = LogFactory.getLog(icg.class);
  private static final Properties b = new Properties();
  
  static
  {
    try
    {
      b.load(icn.b("ical4j.properties"));
      return;
    }
    catch (Exception localException)
    {
      a.info("ical4j.properties not found.");
    }
  }
  
  public static String a(String paramString)
  {
    String str2 = b.getProperty(paramString);
    String str1 = str2;
    if (str2 == null) {
      str1 = System.getProperty(paramString);
    }
    return str1;
  }
}

/* Location:
 * Qualified Name:     icg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */