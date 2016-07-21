import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ns<K, V>
  extends oi<K, V>
  implements Map<K, V>
{
  nz<K, V> a;
  
  private final nz<K, V> a()
  {
    if (a == null) {
      a = new nt(this);
    }
    return a;
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    nz localnz = a();
    if (b == null) {
      b = new ob(localnz);
    }
    return b;
  }
  
  public Set<K> keySet()
  {
    nz localnz = a();
    if (c == null) {
      c = new oc(localnz);
    }
    return c;
  }
  
  public void putAll(Map<? extends K, ? extends V> paramMap)
  {
    int i = h + paramMap.size();
    Object localObject;
    if (f.length < i)
    {
      localObject = f;
      Object[] arrayOfObject = g;
      super.a(i);
      if (h > 0)
      {
        System.arraycopy(localObject, 0, f, 0, h);
        System.arraycopy(arrayOfObject, 0, g, 0, h << 1);
      }
      oi.a((int[])localObject, arrayOfObject, h);
    }
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      localObject = (Map.Entry)paramMap.next();
      put(((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue());
    }
  }
  
  public Collection<V> values()
  {
    nz localnz = a();
    if (d == null) {
      d = new oe(localnz);
    }
    return d;
  }
}

/* Location:
 * Qualified Name:     ns
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */