import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public final class hwm
  extends ArrayList
  implements Serializable
{
  private static final long serialVersionUID = -8875923766224921031L;
  
  public final hue a(String paramString)
  {
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
    {
      hue localhue = (hue)localIterator.next();
      if (a.equalsIgnoreCase(paramString)) {
        return localhue;
      }
    }
    return null;
  }
  
  public final boolean add(Object paramObject)
  {
    if (!(paramObject instanceof hue))
    {
      paramObject = String.valueOf(hue.class.getName());
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
    while (localIterator.hasNext()) {
      localStringBuffer.append(localIterator.next().toString());
    }
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     hwm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */