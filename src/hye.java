import java.util.HashMap;
import java.util.Map;

public final class hye
  extends hwz
{
  private static final long serialVersionUID = -269658210065896668L;
  public hsl d;
  private final Map e = new HashMap();
  
  public hye()
  {
    super("VTODO");
    e.put(iau.f, new hyf(this));
    e.put(iau.g, new hyg(this));
    e.put(iau.i, new hyh(this));
    e.put(iau.j, new hyi(this));
    e.put(iau.c, new hyj(this));
    e.put(iau.h, new hyk(this));
    e.put(iau.e, new hyl(this));
    e.put(iau.d, new hym(this));
    d = new hsl();
    b.add(new iah());
  }
  
  public hye(hwm paramhwm)
  {
    super("VTODO", paramhwm);
    e.put(iau.f, new hyf(this));
    e.put(iau.g, new hyg(this));
    e.put(iau.i, new hyh(this));
    e.put(iau.j, new hyi(this));
    e.put(iau.c, new hyj(this));
    e.put(iau.h, new hyk(this));
    e.put(iau.e, new hyl(this));
    e.put(iau.d, new hym(this));
    d = new hsl();
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof hye)) {
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
 * Qualified Name:     hye
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */