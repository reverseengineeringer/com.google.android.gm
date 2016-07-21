import java.io.Serializable;

class hea<K, V>
  extends hcr<K, V>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  final K g;
  final V h;
  
  hea(K paramK, V paramV)
  {
    g = paramK;
    h = paramV;
  }
  
  public final K getKey()
  {
    return (K)g;
  }
  
  public final V getValue()
  {
    return (V)h;
  }
  
  public final V setValue(V paramV)
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     hea
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */