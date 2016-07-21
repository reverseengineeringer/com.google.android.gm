import java.io.Serializable;

final class hfc<V>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  final hel<?, V> a;
  
  hfc(hel<?, V> paramhel)
  {
    a = paramhel;
  }
  
  final Object readResolve()
  {
    return a.c();
  }
}

/* Location:
 * Qualified Name:     hfc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */