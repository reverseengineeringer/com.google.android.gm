import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class fnl<K, V>
  extends fnv<K, V>
  implements Map<K, V>
{
  fnp<K, V> a;
  
  private final fnp<K, V> b()
  {
    if (a == null) {
      a = new fnm(this);
    }
    return a;
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    fnp localfnp = b();
    if (b == null) {
      b = new fnr(localfnp);
    }
    return b;
  }
  
  public Set<K> keySet()
  {
    fnp localfnp = b();
    if (c == null) {
      c = new fns(localfnp);
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
      fnv.a((int[])localObject, arrayOfObject, h);
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
    fnp localfnp = b();
    if (d == null) {
      d = new fnu(localfnp);
    }
    return d;
  }
}

/* Location:
 * Qualified Name:     fnl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */