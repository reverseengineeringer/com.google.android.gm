import java.util.EnumMap;
import java.util.Map.Entry;
import java.util.Set;

final class heb<K extends Enum<K>, V>
  extends heo<K, V>
{
  private final transient EnumMap<K, V> b;
  
  heb(EnumMap<K, V> paramEnumMap)
  {
    b = paramEnumMap;
    if (!paramEnumMap.isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      hbe.a(bool);
      return;
    }
  }
  
  final hji<K> J_()
  {
    return hfu.a(b.keySet().iterator());
  }
  
  final hji<Map.Entry<K, V>> b()
  {
    return hhk.c(b.entrySet().iterator());
  }
  
  public final boolean containsKey(Object paramObject)
  {
    return b.containsKey(paramObject);
  }
  
  final boolean d()
  {
    return false;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    Object localObject = paramObject;
    if ((paramObject instanceof heb)) {
      localObject = b;
    }
    return b.equals(localObject);
  }
  
  public final V get(Object paramObject)
  {
    return (V)b.get(paramObject);
  }
  
  public final int size()
  {
    return b.size();
  }
  
  final Object writeReplace()
  {
    return new hec(b);
  }
}

/* Location:
 * Qualified Name:     heb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */