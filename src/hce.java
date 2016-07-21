import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

final class hce
  extends hhq<K, Collection<V>>
{
  hce(hcd paramhcd) {}
  
  final Map<K, Collection<V>> a()
  {
    return a;
  }
  
  public final boolean contains(Object paramObject)
  {
    return hcx.a(a.a.entrySet(), paramObject);
  }
  
  public final Iterator<Map.Entry<K, Collection<V>>> iterator()
  {
    return new hcf(a);
  }
  
  public final boolean remove(Object paramObject)
  {
    if (!contains(paramObject)) {
      return false;
    }
    Object localObject = (Map.Entry)paramObject;
    paramObject = a.b;
    localObject = ((Map.Entry)localObject).getKey();
    localObject = (Collection)hhk.c(a, localObject);
    if (localObject != null)
    {
      int i = ((Collection)localObject).size();
      ((Collection)localObject).clear();
      b -= i;
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     hce
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */