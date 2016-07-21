import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public final class imn
{
  private static Map a;
  
  static
  {
    try
    {
      Object localObject = System.getProperty("dnsjava.options");
      if (localObject != null)
      {
        localObject = new StringTokenizer((String)localObject, ",");
        while (((StringTokenizer)localObject).hasMoreTokens())
        {
          String str2 = ((StringTokenizer)localObject).nextToken();
          int i = str2.indexOf('=');
          if (i == -1)
          {
            if (a == null) {
              a = new HashMap();
            }
            a.put(str2.toLowerCase(), "true");
          }
          else
          {
            String str1 = str2.substring(0, i);
            str2 = str2.substring(i + 1);
            if (a == null) {
              a = new HashMap();
            }
            a.put(str1.toLowerCase(), str2.toLowerCase());
          }
        }
      }
      return;
    }
    catch (SecurityException localSecurityException) {}
  }
  
  public static boolean a(String paramString)
  {
    if (a == null) {}
    while (a.get(paramString.toLowerCase()) == null) {
      return false;
    }
    return true;
  }
  
  public static int b(String paramString)
  {
    if (a == null) {}
    for (paramString = null; paramString != null; paramString = (String)a.get(paramString.toLowerCase())) {
      try
      {
        int i = Integer.parseInt(paramString);
        if (i <= 0) {
          break;
        }
        return i;
      }
      catch (NumberFormatException paramString) {}
    }
    return -1;
  }
}

/* Location:
 * Qualified Name:     imn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */