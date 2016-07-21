import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

public final class hhk
{
  static final hay a = new hay(hcx.a, "=");
  
  static <K> hav<Map.Entry<K, ?>, K> a()
  {
    return hhn.a;
  }
  
  static <V> V a(Map<?, V> paramMap, Object paramObject)
  {
    hbe.a(paramMap);
    try
    {
      paramMap = paramMap.get(paramObject);
      return paramMap;
    }
    catch (ClassCastException paramMap)
    {
      return null;
    }
    catch (NullPointerException paramMap) {}
    return null;
  }
  
  public static <K, V> HashMap<K, V> a(int paramInt)
  {
    return new HashMap(b(paramInt));
  }
  
  static <K, V> Iterator<K> a(Iterator<Map.Entry<K, V>> paramIterator)
  {
    return hfu.a(paramIterator, hhn.a);
  }
  
  public static <K, V> LinkedHashMap<K, V> a(Map<? extends K, ? extends V> paramMap)
  {
    return new LinkedHashMap(paramMap);
  }
  
  public static <K, V> Map.Entry<K, V> a(K paramK, V paramV)
  {
    return new hea(paramK, paramV);
  }
  
  static <K, V> Map.Entry<K, V> a(Map.Entry<? extends K, ? extends V> paramEntry)
  {
    hbe.a(paramEntry);
    return new hhl(paramEntry);
  }
  
  static int b(int paramInt)
  {
    if (paramInt < 3)
    {
      hcw.a(paramInt, "expectedSize");
      return paramInt + 1;
    }
    if (paramInt < 1073741824) {
      return (int)(paramInt / 0.75F + 1.0F);
    }
    return Integer.MAX_VALUE;
  }
  
  static <V> hav<Map.Entry<?, V>, V> b()
  {
    return hhn.b;
  }
  
  static <K> K b(Map.Entry<K, ?> paramEntry)
  {
    if (paramEntry == null) {
      return null;
    }
    return (K)paramEntry.getKey();
  }
  
  static String b(Map<?, ?> paramMap)
  {
    StringBuilder localStringBuilder = hcx.a(paramMap.size()).append('{');
    a.a(localStringBuilder, paramMap.entrySet().iterator());
    return '}';
  }
  
  static <K, V> Iterator<V> b(Iterator<Map.Entry<K, V>> paramIterator)
  {
    return hfu.a(paramIterator, hhn.b);
  }
  
  static boolean b(Map<?, ?> paramMap, Object paramObject)
  {
    hbe.a(paramMap);
    try
    {
      boolean bool = paramMap.containsKey(paramObject);
      return bool;
    }
    catch (ClassCastException paramMap)
    {
      return false;
    }
    catch (NullPointerException paramMap) {}
    return false;
  }
  
  static <K, V> hji<Map.Entry<K, V>> c(Iterator<Map.Entry<K, V>> paramIterator)
  {
    return new hhm(paramIterator);
  }
  
  static <V> V c(Map.Entry<?, V> paramEntry)
  {
    if (paramEntry == null) {
      return null;
    }
    return (V)paramEntry.getValue();
  }
  
  static <V> V c(Map<?, V> paramMap, Object paramObject)
  {
    hbe.a(paramMap);
    try
    {
      paramMap = paramMap.remove(paramObject);
      return paramMap;
    }
    catch (ClassCastException paramMap)
    {
      return null;
    }
    catch (NullPointerException paramMap) {}
    return null;
  }
  
  public static <K, V> HashMap<K, V> c()
  {
    return new HashMap();
  }
  
  public static <K, V> LinkedHashMap<K, V> d()
  {
    return new LinkedHashMap();
  }
  
  static boolean d(Map<?, ?> paramMap, Object paramObject)
  {
    if (paramMap == paramObject) {
      return true;
    }
    if ((paramObject instanceof Map))
    {
      paramObject = (Map)paramObject;
      return paramMap.entrySet().equals(((Map)paramObject).entrySet());
    }
    return false;
  }
  
  public static <K, V> ConcurrentMap<K, V> e()
  {
    return new hgi().d();
  }
}

/* Location:
 * Qualified Name:     hhk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */