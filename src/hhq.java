import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

abstract class hhq<K, V>
  extends hip<Map.Entry<K, V>>
{
  abstract Map<K, V> a();
  
  public void clear()
  {
    a().clear();
  }
  
  public boolean contains(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof Map.Entry))
    {
      paramObject = (Map.Entry)paramObject;
      Object localObject1 = ((Map.Entry)paramObject).getKey();
      Object localObject2 = hhk.a(a(), localObject1);
      bool1 = bool2;
      if (hbc.a(localObject2, ((Map.Entry)paramObject).getValue())) {
        if (localObject2 == null)
        {
          bool1 = bool2;
          if (!a().containsKey(localObject1)) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean isEmpty()
  {
    return a().isEmpty();
  }
  
  public boolean remove(Object paramObject)
  {
    if (contains(paramObject))
    {
      paramObject = (Map.Entry)paramObject;
      return a().keySet().remove(((Map.Entry)paramObject).getKey());
    }
    return false;
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    try
    {
      boolean bool = super.removeAll((Collection)hbe.a(paramCollection));
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException) {}
    return hio.a(this, paramCollection.iterator());
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    try
    {
      boolean bool = super.retainAll((Collection)hbe.a(paramCollection));
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      HashSet localHashSet = hio.a(paramCollection.size());
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        Object localObject = paramCollection.next();
        if (contains(localObject)) {
          localHashSet.add(((Map.Entry)localObject).getKey());
        }
      }
      return a().keySet().retainAll(localHashSet);
    }
  }
  
  public int size()
  {
    return a().size();
  }
}

/* Location:
 * Qualified Name:     hhq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */