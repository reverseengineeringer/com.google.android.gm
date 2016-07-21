import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class gjk
{
  private final Map<String, String> a = new HashMap();
  private final Map<String, String> b = new HashMap();
  
  @Deprecated
  public gjk(String paramString)
  {
    this(paramString, (byte)0);
  }
  
  private gjk(String paramString, byte paramByte)
  {
    a("site_id", paramString);
    a("survey_url", "https://www.google.com/insights/consumersurveys/async_survey");
    a("locale", "en-US");
  }
  
  public final gjk a(String paramString1, String paramString2)
  {
    a.put(paramString1, paramString2);
    return this;
  }
  
  public final String a(String paramString)
  {
    return (String)a.get(paramString);
  }
  
  public final gjk b(String paramString1, String paramString2)
  {
    b.put(paramString1, paramString2);
    return this;
  }
  
  public final String b(String paramString)
  {
    return (String)b.get(paramString);
  }
  
  public final String c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(paramString).concat("['params'] = {};\n"));
    localStringBuilder.append(String.valueOf(paramString).concat("['logging_params'] = {};\n"));
    Iterator localIterator = a.entrySet().iterator();
    Map.Entry localEntry;
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      localStringBuilder.append(String.format(String.valueOf(paramString).concat("['params']['%s'] = '%s';\n"), new Object[] { localEntry.getKey(), localEntry.getValue() }));
    }
    localIterator = b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      localStringBuilder.append(String.format(String.valueOf(paramString).concat("['logging_params']['%s'] = '%s'\n;"), new Object[] { localEntry.getKey(), localEntry.getValue() }));
    }
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     gjk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */