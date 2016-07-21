import java.io.Serializable;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class hel<K, V>
  implements Serializable, Map<K, V>
{
  static final Map.Entry<?, ?>[] a = new Map.Entry[0];
  private transient hfd<Map.Entry<K, V>> b;
  private transient hfd<K> c;
  private transient hdx<V> d;
  
  public static <K, V> hel<K, V> a(K paramK1, V paramV1, K paramK2, V paramV2)
  {
    return hij.a(2, new Map.Entry[] { c(paramK1, paramV1), c(paramK2, paramV2) });
  }
  
  public static <K, V> hel<K, V> a(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4, K paramK5, V paramV5)
  {
    return hij.a(5, new Map.Entry[] { c(paramK1, paramV1), c(paramK2, paramV2), c(paramK3, paramV3), c(paramK4, paramV4), c(paramK5, paramV5) });
  }
  
  public static <K, V> hel<K, V> a(Map<? extends K, ? extends V> paramMap)
  {
    Object localObject;
    if (((paramMap instanceof hel)) && (!(paramMap instanceof hfj)))
    {
      localObject = (hel)paramMap;
      if (!((hel)localObject).d()) {
        return (hel<K, V>)localObject;
      }
    }
    else if ((paramMap instanceof EnumMap))
    {
      paramMap = new EnumMap((EnumMap)paramMap);
      localObject = paramMap.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        hcw.a(localEntry.getKey(), localEntry.getValue());
      }
      switch (paramMap.size())
      {
      default: 
        return new heb(paramMap);
      case 0: 
        return hid.b;
      }
      paramMap = (Map.Entry)hft.a(paramMap.entrySet());
      return hdu.a((Enum)paramMap.getKey(), paramMap.getValue());
    }
    paramMap = (Map.Entry[])hft.a(paramMap.entrySet(), a);
    switch (paramMap.length)
    {
    default: 
      return hij.a(paramMap.length, paramMap);
    case 0: 
      return hid.b;
    }
    paramMap = paramMap[0];
    return hdu.a(paramMap.getKey(), paramMap.getValue());
  }
  
  static void a(boolean paramBoolean, String paramString, Map.Entry<?, ?> paramEntry1, Map.Entry<?, ?> paramEntry2)
  {
    if (!paramBoolean)
    {
      paramEntry1 = String.valueOf(paramEntry1);
      paramEntry2 = String.valueOf(paramEntry2);
      throw new IllegalArgumentException(String.valueOf(paramString).length() + 34 + String.valueOf(paramEntry1).length() + String.valueOf(paramEntry2).length() + "Multiple entries with same " + paramString + ": " + paramEntry1 + " and " + paramEntry2);
    }
  }
  
  public static <K, V> hel<K, V> b(K paramK, V paramV)
  {
    return hdu.a(paramK, paramV);
  }
  
  static <K, V> her<K, V> c(K paramK, V paramV)
  {
    return new her(paramK, paramV);
  }
  
  public static <K, V> hel<K, V> e()
  {
    return hid.b;
  }
  
  public static <K, V> hen<K, V> f()
  {
    return new hen();
  }
  
  hji<K> J_()
  {
    return new hem(this, g().a());
  }
  
  public hdx<V> c()
  {
    hdx localhdx = d;
    Object localObject = localhdx;
    if (localhdx == null)
    {
      localObject = new hez(this);
      d = ((hdx)localObject);
    }
    return (hdx<V>)localObject;
  }
  
  @Deprecated
  public final void clear()
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean containsKey(Object paramObject)
  {
    return get(paramObject) != null;
  }
  
  public boolean containsValue(Object paramObject)
  {
    return c().contains(paramObject);
  }
  
  abstract boolean d();
  
  public boolean equals(Object paramObject)
  {
    return hhk.d(this, paramObject);
  }
  
  public hfd<Map.Entry<K, V>> g()
  {
    hfd localhfd2 = b;
    hfd localhfd1 = localhfd2;
    if (localhfd2 == null)
    {
      localhfd1 = h();
      b = localhfd1;
    }
    return localhfd1;
  }
  
  public abstract V get(Object paramObject);
  
  abstract hfd<Map.Entry<K, V>> h();
  
  public int hashCode()
  {
    return hio.a(g());
  }
  
  public hfd<K> i()
  {
    hfd localhfd2 = c;
    hfd localhfd1 = localhfd2;
    if (localhfd2 == null)
    {
      localhfd1 = j();
      c = localhfd1;
    }
    return localhfd1;
  }
  
  public boolean isEmpty()
  {
    return size() == 0;
  }
  
  hfd<K> j()
  {
    if (isEmpty()) {
      return hik.a;
    }
    return new hex(this);
  }
  
  boolean k()
  {
    return false;
  }
  
  @Deprecated
  public final V put(K paramK, V paramV)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final void putAll(Map<? extends K, ? extends V> paramMap)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final V remove(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public String toString()
  {
    return hhk.b(this);
  }
  
  Object writeReplace()
  {
    return new heq(this);
  }
}

/* Location:
 * Qualified Name:     hel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */