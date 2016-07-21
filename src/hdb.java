import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class hdb<K, V>
  extends hdc
  implements Map<K, V>
{
  protected abstract Map<K, V> b();
  
  public void clear()
  {
    b().clear();
  }
  
  public boolean containsKey(Object paramObject)
  {
    return b().containsKey(paramObject);
  }
  
  public boolean containsValue(Object paramObject)
  {
    return b().containsValue(paramObject);
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    return b().entrySet();
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (b().equals(paramObject));
  }
  
  public V get(Object paramObject)
  {
    return (V)b().get(paramObject);
  }
  
  public int hashCode()
  {
    return b().hashCode();
  }
  
  public boolean isEmpty()
  {
    return b().isEmpty();
  }
  
  public Set<K> keySet()
  {
    return b().keySet();
  }
  
  public V put(K paramK, V paramV)
  {
    return (V)b().put(paramK, paramV);
  }
  
  public void putAll(Map<? extends K, ? extends V> paramMap)
  {
    b().putAll(paramMap);
  }
  
  public V remove(Object paramObject)
  {
    return (V)b().remove(paramObject);
  }
  
  public int size()
  {
    return b().size();
  }
  
  public Collection<V> values()
  {
    return b().values();
  }
}

/* Location:
 * Qualified Name:     hdb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */