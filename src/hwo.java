import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class hwo
  implements Serializable
{
  private static final long serialVersionUID = -417427815871330636L;
  private List a = new hpw();
  
  public hwo() {}
  
  public hwo(String paramString)
  {
    Matcher localMatcher = Pattern.compile("([^\\\\](?:\\\\{2})),|([^\\\\]),").matcher(paramString);
    if (localMatcher.find()) {}
    for (paramString = localMatcher.replaceAll("$1$2&quot;").split("&quot;");; paramString = paramString.split("(?<!\\\\),"))
    {
      int i = 0;
      while (i < paramString.length)
      {
        a.add(ico.c(paramString[i]));
        i += 1;
      }
    }
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      localStringBuffer.append(ico.b((String)localIterator.next()));
      if (localIterator.hasNext()) {
        localStringBuffer.append(',');
      }
    }
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     hwo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */