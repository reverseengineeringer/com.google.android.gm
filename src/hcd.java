import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class hcd
  extends hhv<K, Collection<V>>
{
  final transient Map<K, Collection<V>> a;
  
  hcd(Map<K, Collection<V>> paramMap)
  {
    Map localMap;
    a = localMap;
  }
  
  protected final Set<Map.Entry<K, Collection<V>>> a()
  {
    return new hce(this);
  }
  
  public void clear()
  {
    if (a == b.a)
    {
      b.e();
      return;
    }
    hfu.c(new hcf(this));
  }
  
  public boolean containsKey(Object paramObject)
  {
    return hhk.b(a, paramObject);
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (a.equals(paramObject));
  }
  
  public int hashCode()
  {
    return a.hashCode();
  }
  
  public Set<K> keySet()
  {
    return b.h();
  }
  
  public int size()
  {
    return a.size();
  }
  
  public String toString()
  {
    return a.toString();
  }
}

/* Location:
 * Qualified Name:     hcd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */