import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

final class hch
  implements Iterator<K>
{
  Map.Entry<K, Collection<V>> a;
  
  hch(hcg paramhcg, Iterator paramIterator) {}
  
  public final boolean hasNext()
  {
    return b.hasNext();
  }
  
  public final K next()
  {
    a = ((Map.Entry)b.next());
    return (K)a.getKey();
  }
  
  public final void remove()
  {
    if (a != null) {}
    for (boolean bool = true;; bool = false)
    {
      hbe.b(bool, "no calls to next() since the last call to remove()");
      Collection localCollection = (Collection)a.getValue();
      b.remove();
      c.a.b -= localCollection.size();
      localCollection.clear();
      return;
    }
  }
}

/* Location:
 * Qualified Name:     hch
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */