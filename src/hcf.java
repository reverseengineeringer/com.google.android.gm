import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class hcf
  implements Iterator<Map.Entry<K, Collection<V>>>
{
  final Iterator<Map.Entry<K, Collection<V>>> a = c.a.entrySet().iterator();
  Collection<V> b;
  
  hcf(hcd paramhcd) {}
  
  public final boolean hasNext()
  {
    return a.hasNext();
  }
  
  public final void remove()
  {
    a.remove();
    c.b.b -= b.size();
    b.clear();
  }
}

/* Location:
 * Qualified Name:     hcf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */