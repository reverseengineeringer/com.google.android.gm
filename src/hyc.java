import java.util.Date;
import java.util.Iterator;

public final class hyc
  extends hwz
{
  private static final long serialVersionUID = 5629679741050917815L;
  public hsl d = new hsl();
  private final hwv e = new hyd(this);
  
  public hyc()
  {
    super("VTIMEZONE");
  }
  
  public hyc(hwm paramhwm)
  {
    super("VTIMEZONE", paramhwm);
  }
  
  public final hxc a(hsn paramhsn)
  {
    Object localObject2 = null;
    Iterator localIterator = d.iterator();
    Object localObject1 = null;
    Object localObject3;
    if (localIterator.hasNext())
    {
      hxc localhxc = (hxc)localIterator.next();
      localObject3 = localhxc.a(paramhsn);
      if ((localObject2 != null) && ((localObject3 == null) || (!((hsn)localObject3).after((Date)localObject2)))) {
        break label80;
      }
      localObject2 = localhxc;
      localObject1 = localObject3;
    }
    for (;;)
    {
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
      break;
      return (hxc)localObject1;
      label80:
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof hyc)) {
      return (super.equals(paramObject)) && (idh.a(d, d));
    }
    return super.equals(paramObject);
  }
  
  public final int hashCode()
  {
    return idlaa).a(b).a(d).a;
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("BEGIN");
    localStringBuffer.append(':');
    localStringBuffer.append(a);
    localStringBuffer.append("\r\n");
    localStringBuffer.append(b);
    localStringBuffer.append(d);
    localStringBuffer.append("END");
    localStringBuffer.append(':');
    localStringBuffer.append(a);
    localStringBuffer.append("\r\n");
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     hyc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */