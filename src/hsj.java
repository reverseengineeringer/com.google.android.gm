import java.io.Serializable;
import java.util.Iterator;

public class hsj
  implements Serializable
{
  private static final long serialVersionUID = 4943193483665822201L;
  public String a;
  public hwm b;
  
  public hsj(String paramString)
  {
    this(paramString, new hwm());
  }
  
  public hsj(String paramString, hwm paramhwm)
  {
    a = paramString;
    b = paramhwm;
  }
  
  public final hwm a(String paramString)
  {
    Object localObject = b;
    hwm localhwm = new hwm();
    localObject = ((hwm)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      hue localhue = (hue)((Iterator)localObject).next();
      if (a.equalsIgnoreCase(paramString)) {
        localhwm.add(localhue);
      }
    }
    return localhwm;
  }
  
  public final hue b(String paramString)
  {
    return b.a(paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof hsj))
    {
      paramObject = (hsj)paramObject;
      return idkaa, a).a(b, b).a;
    }
    return super.equals(paramObject);
  }
  
  public int hashCode()
  {
    return idlaa).a(b).a;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("BEGIN");
    localStringBuffer.append(':');
    localStringBuffer.append(a);
    localStringBuffer.append("\r\n");
    localStringBuffer.append(b);
    localStringBuffer.append("END");
    localStringBuffer.append(':');
    localStringBuffer.append(a);
    localStringBuffer.append("\r\n");
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     hsj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */