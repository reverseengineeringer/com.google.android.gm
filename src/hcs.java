import java.util.Collection;
import java.util.Map;
import java.util.Set;

abstract class hcs<K, V>
  implements hhw<K, V>
{
  private transient Set<K> a;
  private transient Map<K, Collection<V>> b;
  
  public boolean a(K paramK, V paramV)
  {
    return b(paramK).add(paramV);
  }
  
  public Map<K, Collection<V>> b()
  {
    Map localMap2 = b;
    Map localMap1 = localMap2;
    if (localMap2 == null)
    {
      localMap1 = g();
      b = localMap1;
    }
    return localMap1;
  }
  
  public boolean b(Object paramObject1, Object paramObject2)
  {
    paramObject1 = (Collection)b().get(paramObject1);
    return (paramObject1 != null) && (((Collection)paramObject1).remove(paramObject2));
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof hhw))
    {
      paramObject = (hhw)paramObject;
      return b().equals(((hhw)paramObject).b());
    }
    return false;
  }
  
  Set<K> f()
  {
    return new hht(b());
  }
  
  abstract Map<K, Collection<V>> g();
  
  public Set<K> h()
  {
    Set localSet2 = a;
    Set localSet1 = localSet2;
    if (localSet2 == null)
    {
      localSet1 = f();
      a = localSet1;
    }
    return localSet1;
  }
  
  public int hashCode()
  {
    return b().hashCode();
  }
  
  public String toString()
  {
    return b().toString();
  }
}

/* Location:
 * Qualified Name:     hcs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */