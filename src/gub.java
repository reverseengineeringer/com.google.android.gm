import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class gub
  implements Iterator<Map.Entry<String, Object>>
{
  private boolean b;
  private final Iterator<Map.Entry<String, Object>> c;
  private final Iterator<Map.Entry<String, Object>> d;
  
  gub(gua paramgua, gtx paramgtx)
  {
    c = paramgtx.a();
    d = b.entrySet().iterator();
  }
  
  public final boolean hasNext()
  {
    return (c.hasNext()) || (d.hasNext());
  }
  
  public final void remove()
  {
    if (b) {
      d.remove();
    }
    c.remove();
  }
}

/* Location:
 * Qualified Name:     gub
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */