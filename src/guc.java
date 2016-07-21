import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

final class guc
  extends AbstractSet<Map.Entry<String, Object>>
{
  private final gtx b;
  
  guc(gua paramgua)
  {
    b = new gtu(paramgua, c.b).a();
  }
  
  public final void clear()
  {
    a.b.clear();
    b.clear();
  }
  
  public final Iterator<Map.Entry<String, Object>> iterator()
  {
    return new gub(a, b);
  }
  
  public final int size()
  {
    return a.b.size() + b.size();
  }
}

/* Location:
 * Qualified Name:     guc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */