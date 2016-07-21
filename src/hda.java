import java.util.concurrent.ConcurrentMap;

public abstract class hda<K, V>
  extends hdb<K, V>
  implements ConcurrentMap<K, V>
{
  protected abstract ConcurrentMap<K, V> a();
  
  public V putIfAbsent(K paramK, V paramV)
  {
    return (V)a().putIfAbsent(paramK, paramV);
  }
  
  public boolean remove(Object paramObject1, Object paramObject2)
  {
    return a().remove(paramObject1, paramObject2);
  }
  
  public V replace(K paramK, V paramV)
  {
    return (V)a().replace(paramK, paramV);
  }
  
  public boolean replace(K paramK, V paramV1, V paramV2)
  {
    return a().replace(paramK, paramV1, paramV2);
  }
}

/* Location:
 * Qualified Name:     hda
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */