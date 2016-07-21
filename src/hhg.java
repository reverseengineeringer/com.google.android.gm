import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Iterator;

final class hhg
  extends AbstractCollection<V>
{
  hhg(hgj paramhgj) {}
  
  public final void clear()
  {
    a.clear();
  }
  
  public final boolean contains(Object paramObject)
  {
    return a.containsValue(paramObject);
  }
  
  public final boolean isEmpty()
  {
    return a.isEmpty();
  }
  
  public final Iterator<V> iterator()
  {
    return new hhe(a);
  }
  
  public final int size()
  {
    return a.size();
  }
  
  public final Object[] toArray()
  {
    return hgj.a(this).toArray();
  }
  
  public final <E> E[] toArray(E[] paramArrayOfE)
  {
    return hgj.a(this).toArray(paramArrayOfE);
  }
}

/* Location:
 * Qualified Name:     hhg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */