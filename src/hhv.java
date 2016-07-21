import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map.Entry;
import java.util.Set;

abstract class hhv<K, V>
  extends AbstractMap<K, V>
{
  private transient Set<Map.Entry<K, V>> a;
  private transient Set<K> b;
  private transient Collection<V> c;
  
  abstract Set<Map.Entry<K, V>> a();
  
  Set<K> b()
  {
    return new hht(this);
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    Set localSet2 = a;
    Set localSet1 = localSet2;
    if (localSet2 == null)
    {
      localSet1 = a();
      a = localSet1;
    }
    return localSet1;
  }
  
  public Set<K> keySet()
  {
    Set localSet2 = b;
    Set localSet1 = localSet2;
    if (localSet2 == null)
    {
      localSet1 = b();
      b = localSet1;
    }
    return localSet1;
  }
  
  public Collection<V> values()
  {
    Collection localCollection = c;
    Object localObject = localCollection;
    if (localCollection == null)
    {
      localObject = new hhu(this);
      c = ((Collection)localObject);
    }
    return (Collection<V>)localObject;
  }
}

/* Location:
 * Qualified Name:     hhv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */