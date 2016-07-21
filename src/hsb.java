import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public final class hsb
  implements Serializable
{
  private static final long serialVersionUID = 81383256078213569L;
  private List a = new hpw();
  
  public hsb() {}
  
  public hsb(String paramString)
  {
    paramString = new StringTokenizer(paramString, ",");
    while (paramString.hasMoreTokens())
    {
      try
      {
        a.add(new URI(icq.a(ico.a(paramString.nextToken()))));
      }
      catch (URISyntaxException localURISyntaxException) {}
      if (!icf.a("ical4j.parsing.relaxed")) {
        throw localURISyntaxException;
      }
    }
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      localStringBuffer.append(ico.a(icq.b(ico.b(localIterator.next()))));
      if (localIterator.hasNext()) {
        localStringBuffer.append(',');
      }
    }
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     hsb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */