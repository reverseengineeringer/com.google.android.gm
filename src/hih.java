import java.io.Serializable;

final class hih<K, V>
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private final hdu<K, V> a;
  
  hih(hdu<K, V> paramhdu)
  {
    a = paramhdu;
  }
  
  final Object readResolve()
  {
    return a.b();
  }
}

/* Location:
 * Qualified Name:     hih
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */