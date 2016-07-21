import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Map.Entry;
import java.util.Set;

final class hdh
  extends AbstractMap<V, K>
  implements hcu<V, K>, Serializable
{
  hdh(hdd paramhdd) {}
  
  public final hcu<K, V> a()
  {
    return a;
  }
  
  public final void clear()
  {
    a.clear();
  }
  
  public final boolean containsKey(Object paramObject)
  {
    return a.containsValue(paramObject);
  }
  
  public final Set<Map.Entry<V, K>> entrySet()
  {
    return new hdi(this);
  }
  
  public final K get(Object paramObject)
  {
    return (K)hhk.b(a.b(paramObject, hdr.a(paramObject)));
  }
  
  public final Set<V> keySet()
  {
    return new hdl(this);
  }
  
  public final K put(V paramV, K paramK)
  {
    hdd localhdd = a;
    int i = hdr.a(paramV);
    int j = hdr.a(paramK);
    hdg localhdg1 = localhdd.b(paramV, i);
    if ((localhdg1 != null) && (j == a) && (hbc.a(paramK, g))) {
      return paramK;
    }
    hdg localhdg2 = localhdd.a(paramK, j);
    if (localhdg2 != null)
    {
      paramV = String.valueOf(paramK);
      throw new IllegalArgumentException(String.valueOf(paramV).length() + 23 + "value already present: " + paramV);
    }
    if (localhdg1 != null) {
      localhdd.a(localhdg1);
    }
    localhdd.a(new hdg(paramK, j, paramV, i), localhdg2);
    if (localhdg2 != null)
    {
      f = null;
      e = null;
    }
    localhdd.b();
    return (K)hhk.b(localhdg1);
  }
  
  public final K remove(Object paramObject)
  {
    paramObject = a.b(paramObject, hdr.a(paramObject));
    if (paramObject == null) {
      return null;
    }
    a.a((hdg)paramObject);
    f = null;
    e = null;
    return (K)g;
  }
  
  public final int size()
  {
    return a.b;
  }
  
  final Object writeReplace()
  {
    return new hdn(a);
  }
}

/* Location:
 * Qualified Name:     hdh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */