import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class icq
{
  private static final Pattern a = Pattern.compile("(?i)^cid:.*");
  private static final Pattern b = Pattern.compile("[<>]");
  
  public static String a(String paramString)
  {
    String str = paramString;
    if (icf.a("ical4j.compatibility.notes"))
    {
      str = paramString;
      if (a.matcher(paramString).matches()) {
        str = b.matcher(paramString).replaceAll("");
      }
    }
    return str;
  }
  
  public static String b(String paramString)
  {
    return paramString;
  }
  
  public static URI c(String paramString)
  {
    try
    {
      URI localURI1 = new URI(a(paramString));
      return localURI1;
    }
    catch (URISyntaxException localURISyntaxException1)
    {
      if (icf.a("ical4j.parsing.relaxed"))
      {
        Object localObject = a(paramString);
        int i = ((String)localObject).indexOf(':');
        if ((i != -1) && (i < ((String)localObject).length() - 1)) {
          try
          {
            localObject = new URI(((String)localObject).substring(0, i), ((String)localObject).substring(i + 1), null);
            return (URI)localObject;
          }
          catch (URISyntaxException localURISyntaxException2) {}
        }
        try
        {
          URI localURI2 = new URI("net.fortunal.ical4j.invalid", paramString, null);
          return localURI2;
        }
        catch (URISyntaxException localURISyntaxException3)
        {
          paramString = String.valueOf(paramString);
          if (paramString.length() == 0) {}
        }
        for (paramString = "Could not build URI from ".concat(paramString);; paramString = new String("Could not build URI from ")) {
          throw new IllegalArgumentException(paramString);
        }
      }
      throw localURISyntaxException3;
    }
  }
}

/* Location:
 * Qualified Name:     icq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */