import java.io.Serializable;

final class hev<K, V>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  final hel<K, V> a;
  
  hev(hel<K, V> paramhel)
  {
    a = paramhel;
  }
  
  final Object readResolve()
  {
    return a.g();
  }
}

/* Location:
 * Qualified Name:     hev
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */