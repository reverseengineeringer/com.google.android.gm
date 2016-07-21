import java.io.Serializable;

final class hdn<K, V>
  implements Serializable
{
  private final hdd<K, V> a;
  
  hdn(hdd<K, V> paramhdd)
  {
    a = paramhdd;
  }
  
  final Object readResolve()
  {
    return a.a();
  }
}

/* Location:
 * Qualified Name:     hdn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */