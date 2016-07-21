import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class hht<K, V>
  extends hip<K>
{
  final Map<K, V> c;
  
  hht(Map<K, V> paramMap)
  {
    c = ((Map)hbe.a(paramMap));
  }
  
  public void clear()
  {
    c.clear();
  }
  
  public boolean contains(Object paramObject)
  {
    return c.containsKey(paramObject);
  }
  
  public boolean isEmpty()
  {
    return c.isEmpty();
  }
  
  public Iterator<K> iterator()
  {
    return hhk.a(c.entrySet().iterator());
  }
  
  public boolean remove(Object paramObject)
  {
    if (contains(paramObject))
    {
      c.remove(paramObject);
      return true;
    }
    return false;
  }
  
  public int size()
  {
    return c.size();
  }
}

/* Location:
 * Qualified Name:     hht
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */