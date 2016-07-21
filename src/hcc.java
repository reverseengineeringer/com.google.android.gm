import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

abstract class hcc<K, V>
  extends hcs<K, V>
  implements Serializable
{
  private static final long serialVersionUID = 2447537837011683357L;
  transient Map<K, Collection<V>> a;
  transient int b;
  
  protected hcc(Map<K, Collection<V>> paramMap)
  {
    hbe.a(paramMap.isEmpty());
    a = paramMap;
  }
  
  final Collection<V> a(K paramK, Collection<V> paramCollection)
  {
    if ((paramCollection instanceof SortedSet)) {
      return new hcq(this, paramK, (SortedSet)paramCollection, null);
    }
    if ((paramCollection instanceof Set)) {
      return new hcp(this, paramK, (Set)paramCollection);
    }
    if ((paramCollection instanceof List)) {
      return a(paramK, (List)paramCollection, null);
    }
    return new hcl(this, paramK, paramCollection, null);
  }
  
  final List<V> a(K paramK, List<V> paramList, hcl paramhcl)
  {
    if ((paramList instanceof RandomAccess)) {
      return new hci(this, paramK, paramList, paramhcl);
    }
    return new hcn(this, paramK, paramList, paramhcl);
  }
  
  public boolean a(K paramK, V paramV)
  {
    Collection localCollection = (Collection)a.get(paramK);
    if (localCollection == null)
    {
      localCollection = c();
      if (localCollection.add(paramV))
      {
        b += 1;
        a.put(paramK, localCollection);
        return true;
      }
      throw new AssertionError("New Collection violated the Collection spec");
    }
    if (localCollection.add(paramV))
    {
      b += 1;
      return true;
    }
    return false;
  }
  
  public Collection<V> b(K paramK)
  {
    Collection localCollection2 = (Collection)a.get(paramK);
    Collection localCollection1 = localCollection2;
    if (localCollection2 == null) {
      localCollection1 = c();
    }
    return a(paramK, localCollection1);
  }
  
  abstract Collection<V> c();
  
  public boolean c(Object paramObject)
  {
    return a.containsKey(paramObject);
  }
  
  public int d()
  {
    return b;
  }
  
  public void e()
  {
    Iterator localIterator = a.values().iterator();
    while (localIterator.hasNext()) {
      ((Collection)localIterator.next()).clear();
    }
    a.clear();
    b = 0;
  }
  
  final Set<K> f()
  {
    if ((a instanceof SortedMap)) {
      return new hck(this, (SortedMap)a);
    }
    return new hcg(this, a);
  }
  
  final Map<K, Collection<V>> g()
  {
    if ((a instanceof SortedMap)) {
      return new hcj(this, (SortedMap)a);
    }
    return new hcd(this, a);
  }
}

/* Location:
 * Qualified Name:     hcc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */