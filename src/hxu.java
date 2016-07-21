import java.util.HashMap;
import java.util.Map;

public final class hxu
  extends hwz
{
  private static final long serialVersionUID = 1046534053331139832L;
  private final Map d = new HashMap();
  
  public hxu()
  {
    super("VFREEBUSY");
    d.put(iau.c, new hxv(this));
    d.put(iau.e, new hxw(this));
    d.put(iau.d, new hxx(this));
    b.add(new iah());
  }
  
  public hxu(hwm paramhwm)
  {
    super("VFREEBUSY", paramhwm);
    d.put(iau.c, new hxv(this));
    d.put(iau.e, new hxw(this));
    d.put(iau.d, new hxx(this));
  }
}

/* Location:
 * Qualified Name:     hxu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */