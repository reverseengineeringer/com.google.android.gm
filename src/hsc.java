import java.io.Serializable;
import java.util.Iterator;

public final class hsc
  implements Serializable
{
  private static final long serialVersionUID = -1654118204678581940L;
  public hwm a;
  public hsl b;
  
  public hsc()
  {
    this(new hwm(), new hsl());
  }
  
  private hsc(hwm paramhwm, hsl paramhsl)
  {
    a = paramhwm;
    b = paramhsl;
  }
  
  public final hsj a(String paramString)
  {
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext())
    {
      hsj localhsj = (hsj)localIterator.next();
      if (a.equals(paramString)) {
        return localhsj;
      }
    }
    return null;
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof hsc))
    {
      paramObject = (hsc)paramObject;
      return idkaa, a).a(b, b).a;
    }
    return super.equals(paramObject);
  }
  
  public final int hashCode()
  {
    return idlaa).a(b).a;
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("BEGIN");
    localStringBuffer.append(':');
    localStringBuffer.append("VCALENDAR");
    localStringBuffer.append("\r\n");
    localStringBuffer.append(a);
    localStringBuffer.append(b);
    localStringBuffer.append("END");
    localStringBuffer.append(':');
    localStringBuffer.append("VCALENDAR");
    localStringBuffer.append("\r\n");
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     hsc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */