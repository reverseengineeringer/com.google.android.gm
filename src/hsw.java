import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public final class hsw
  implements Serializable
{
  private static final long serialVersionUID = -9181735547604179160L;
  private List a = new hpw();
  
  public hsw() {}
  
  public hsw(String paramString)
  {
    paramString = new StringTokenizer(paramString, ",");
    while (paramString.hasMoreTokens()) {
      a.add(paramString.nextToken());
    }
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      localStringBuffer.append(localIterator.next());
      if (localIterator.hasNext()) {
        localStringBuffer.append(',');
      }
    }
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     hsw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */