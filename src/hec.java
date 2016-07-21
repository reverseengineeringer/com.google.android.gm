import java.io.Serializable;
import java.util.EnumMap;

final class hec<K extends Enum<K>, V>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  final EnumMap<K, V> a;
  
  hec(EnumMap<K, V> paramEnumMap)
  {
    a = paramEnumMap;
  }
  
  final Object readResolve()
  {
    return new heb(a);
  }
}

/* Location:
 * Qualified Name:     hec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */