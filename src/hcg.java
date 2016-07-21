import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class hcg
  extends hht<K, Collection<V>>
{
  hcg(Map<K, Collection<V>> paramMap)
  {
    super(localMap);
  }
  
  public void clear()
  {
    hfu.c(iterator());
  }
  
  public boolean containsAll(Collection<?> paramCollection)
  {
    return c.keySet().containsAll(paramCollection);
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (c.keySet().equals(paramObject));
  }
  
  public int hashCode()
  {
    return c.keySet().hashCode();
  }
  
  public Iterator<K> iterator()
  {
    return new hch(this, c.entrySet().iterator());
  }
  
  public boolean remove(Object paramObject)
  {
    paramObject = (Collection)c.remove(paramObject);
    int i;
    if (paramObject != null)
    {
      i = ((Collection)paramObject).size();
      ((Collection)paramObject).clear();
      a.b -= i;
    }
    for (;;)
    {
      return i > 0;
      i = 0;
    }
  }
}

/* Location:
 * Qualified Name:     hcg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */