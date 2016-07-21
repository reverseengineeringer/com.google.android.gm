import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;

final class hck
  extends hcg
  implements SortedSet<K>
{
  hck(SortedMap<K, Collection<V>> paramSortedMap)
  {
    super(paramSortedMap, localMap);
  }
  
  public final Comparator<? super K> comparator()
  {
    return ((SortedMap)c).comparator();
  }
  
  public final K first()
  {
    return (K)((SortedMap)c).firstKey();
  }
  
  public final SortedSet<K> headSet(K paramK)
  {
    return new hck(b, ((SortedMap)c).headMap(paramK));
  }
  
  public final K last()
  {
    return (K)((SortedMap)c).lastKey();
  }
  
  public final SortedSet<K> subSet(K paramK1, K paramK2)
  {
    return new hck(b, ((SortedMap)c).subMap(paramK1, paramK2));
  }
  
  public final SortedSet<K> tailSet(K paramK)
  {
    return new hck(b, ((SortedMap)c).tailMap(paramK));
  }
}

/* Location:
 * Qualified Name:     hck
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */