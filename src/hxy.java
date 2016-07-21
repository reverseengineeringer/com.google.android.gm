import java.util.HashMap;
import java.util.Map;

public final class hxy
  extends hwz
{
  private static final long serialVersionUID = -7635140949183238830L;
  private final Map d = new HashMap();
  
  public hxy()
  {
    super("VJOURNAL");
    d.put(iau.f, new hxz(this));
    d.put(iau.g, new hya(this));
    d.put(iau.c, new hyb(this));
    b.add(new iah());
  }
  
  public hxy(hwm paramhwm)
  {
    super("VJOURNAL", paramhwm);
    d.put(iau.f, new hxz(this));
    d.put(iau.g, new hya(this));
    d.put(iau.c, new hyb(this));
  }
}

/* Location:
 * Qualified Name:     hxy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */