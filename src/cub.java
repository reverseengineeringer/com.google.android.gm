import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class cub<K, V>
{
  public final Map<K, Deque<V>> a = new HashMap();
  
  public final void a(cuc<V> paramcuc)
  {
    Iterator localIterator1 = a.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((Deque)((Map.Entry)localIterator1.next()).getValue()).iterator();
      while (localIterator2.hasNext()) {
        paramcuc.a(localIterator2.next());
      }
    }
  }
  
  public final void a(K paramK, V paramV)
  {
    Deque localDeque = (Deque)a.get(paramK);
    Object localObject = localDeque;
    if (localDeque == null)
    {
      localObject = new LinkedList();
      a.put(paramK, localObject);
    }
    ((Deque)localObject).add(paramV);
  }
}

/* Location:
 * Qualified Name:     cub
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */