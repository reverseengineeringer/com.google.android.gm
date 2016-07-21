import java.util.Map.Entry;

final class hex<K, V>
  extends hff<K>
{
  private final hel<K, V> a;
  
  hex(hel<K, V> paramhel)
  {
    a = paramhel;
  }
  
  public final hji<K> a()
  {
    return a.J_();
  }
  
  final K a(int paramInt)
  {
    return (K)((Map.Entry)a.g().f().get(paramInt)).getKey();
  }
  
  public final boolean contains(Object paramObject)
  {
    return a.containsKey(paramObject);
  }
  
  final boolean e()
  {
    return true;
  }
  
  public final int size()
  {
    return a.size();
  }
  
  final Object writeReplace()
  {
    return new hey(a);
  }
}

/* Location:
 * Qualified Name:     hex
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */