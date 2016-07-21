import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public final class hsl
  extends ArrayList
  implements Serializable
{
  private static final long serialVersionUID = 7308557606558767449L;
  
  public final hsl a(String paramString)
  {
    hsl localhsl = new hsl();
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
    {
      hsj localhsj = (hsj)localIterator.next();
      if (a.equals(paramString)) {
        localhsl.add(localhsj);
      }
    }
    return localhsl;
  }
  
  public final boolean add(Object paramObject)
  {
    if (!(paramObject instanceof hsj))
    {
      paramObject = String.valueOf(hsj.class.getName());
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
 * Qualified Name:     hsl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */