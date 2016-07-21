import java.io.Serializable;

final class hey<K>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  final hel<K, ?> a;
  
  hey(hel<K, ?> paramhel)
  {
    a = paramhel;
  }
  
  final Object readResolve()
  {
    return a.i();
  }
}

/* Location:
 * Qualified Name:     hey
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */