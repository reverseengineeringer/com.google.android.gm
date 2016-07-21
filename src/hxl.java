import java.util.HashMap;
import java.util.Map;

public final class hxl
  extends hwz
{
  private static final long serialVersionUID = 2547948989200697335L;
  public hsl d;
  private final Map e = new HashMap();
  
  public hxl()
  {
    super("VEVENT");
    e.put(iau.f, new hxm(this));
    e.put(iau.g, new hxn(this));
    e.put(iau.i, new hxo(this));
    e.put(iau.j, new hxp(this));
    e.put(iau.c, new hxq(this));
    e.put(iau.h, new hxr(this));
    e.put(iau.e, new hxs(this));
    e.put(iau.d, new hxt(this));
    d = new hsl();
    b.add(new iah());
  }
  
  public hxl(hwm paramhwm)
  {
    super("VEVENT", paramhwm);
    e.put(iau.f, new hxm(this));
    e.put(iau.g, new hxn(this));
    e.put(iau.i, new hxo(this));
    e.put(iau.j, new hxp(this));
    e.put(iau.c, new hxq(this));
    e.put(iau.h, new hxr(this));
    e.put(iau.e, new hxs(this));
    e.put(iau.d, new hxt(this));
    d = new hsl();
  }
  
  public final iai a()
  {
    return (iai)b("DTSTART");
  }
  
  public final iak b()
  {
    return (iak)b("DURATION");
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof hxl)) {
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
 * Qualified Name:     hxl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */