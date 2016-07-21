import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;

final class hcj
  extends hcd
  implements SortedMap<K, Collection<V>>
{
  SortedSet<K> c;
  
  hcj(SortedMap<K, Collection<V>> paramSortedMap)
  {
    super(paramSortedMap, localMap);
  }
  
  private final SortedSet<K> c()
  {
    return new hck(d, (SortedMap)a);
  }
  
  public final Comparator<? super K> comparator()
  {
    return ((SortedMap)a).comparator();
  }
  
  public final K firstKey()
  {
    return (K)((SortedMap)a).firstKey();
  }
  
  public final SortedMap<K, Collection<V>> headMap(K paramK)
  {
    return new hcj(d, ((SortedMap)a).headMap(paramK));
  }
  
  public final K lastKey()
  {
    return (K)((SortedMap)a).lastKey();
  }
  
  public final SortedMap<K, Collection<V>> subMap(K paramK1, K paramK2)
  {
    return new hcj(d, ((SortedMap)a).subMap(paramK1, paramK2));
  }
  
  public final SortedMap<K, Collection<V>> tailMap(K paramK)
  {
    return new hcj(d, ((SortedMap)a).tailMap(paramK));
  }
}

/* Location:
 * Qualified Name:     hcj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */