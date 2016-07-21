import java.util.Iterator;

final class hgu
  extends hgw<K>
{
  hgu(hgj paramhgj) {}
  
  public final void clear()
  {
    a.clear();
  }
  
  public final boolean contains(Object paramObject)
  {
    return a.containsKey(paramObject);
  }
  
  public final boolean isEmpty()
  {
    return a.isEmpty();
  }
  
  public final Iterator<K> iterator()
  {
    return new hgt(a);
  }
  
  public final boolean remove(Object paramObject)
  {
    return a.remove(paramObject) != null;
  }
  
  public final int size()
  {
    return a.size();
  }
}

/* Location:
 * Qualified Name:     hgu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */