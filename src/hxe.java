import java.util.HashMap;
import java.util.Map;

public final class hxe
  extends hwz
{
  private static final long serialVersionUID = -8193965477414653802L;
  private final Map d = new HashMap();
  private final hwv e;
  
  public hxe()
  {
    super("VALARM");
    d.put(hzp.c, new hxf(this));
    d.put(hzp.d, new hxg(this));
    d.put(hzp.e, new hxh(this));
    d.put(hzp.f, new hxj(this));
    e = new hxi(this);
  }
  
  public hxe(hwm paramhwm)
  {
    super("VALARM", paramhwm);
    d.put(hzp.c, new hxf(this));
    d.put(hzp.d, new hxg(this));
    d.put(hzp.e, new hxh(this));
    d.put(hzp.f, new hxj(this));
    e = new hxi(this);
  }
}

/* Location:
 * Qualified Name:     hxe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */