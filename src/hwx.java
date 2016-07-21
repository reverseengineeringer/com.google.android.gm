import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public final class hwx
  extends ArrayList
  implements Serializable
{
  private static final long serialVersionUID = 1243262497035300445L;
  
  public hwx() {}
  
  public hwx(String paramString)
  {
    boolean bool = icf.a("ical4j.compatibility.outlook");
    paramString = new StringTokenizer(paramString, ",");
    while (paramString.hasMoreTokens()) {
      if (bool) {
        add(new hww(paramString.nextToken().replaceAll(" ", "")));
      } else {
        add(new hww(paramString.nextToken()));
      }
    }
  }
  
  public final boolean add(Object paramObject)
  {
    if (!(paramObject instanceof hww))
    {
      paramObject = String.valueOf(hww.class.getName());
      if (((String)paramObject).length() != 0) {}
      for (paramObject = "Argument not a ".concat((String)paramObject);; paramObject = new String("Argument not a ")) {
        throw new IllegalArgumentException((String)paramObject);
      }
    }
    return super.add(paramObject);
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = iterator();
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
 * Qualified Name:     hwx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */