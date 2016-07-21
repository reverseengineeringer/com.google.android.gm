import java.util.Map.Entry;

final class hiq<K, V>
  extends hdu<K, V>
{
  final transient K b;
  final transient V c;
  transient hdu<V, K> d;
  
  hiq(K paramK, V paramV)
  {
    hcw.a(paramK, paramV);
    b = paramK;
    c = paramV;
  }
  
  private hiq(K paramK, V paramV, hdu<V, K> paramhdu)
  {
    b = paramK;
    c = paramV;
    d = paramhdu;
  }
  
  public final hdu<V, K> b()
  {
    hdu localhdu = d;
    Object localObject = localhdu;
    if (localhdu == null)
    {
      localObject = new hiq(c, b, this);
      d = ((hdu)localObject);
    }
    return (hdu<V, K>)localObject;
  }
  
  public final boolean containsKey(Object paramObject)
  {
    return b.equals(paramObject);
  }
  
  public final boolean containsValue(Object paramObject)
  {
    return c.equals(paramObject);
  }
  
  final boolean d()
  {
    return false;
  }
  
  public final V get(Object paramObject)
  {
    if (b.equals(paramObject)) {
      return (V)c;
    }
    return null;
  }
  
  final hfd<Map.Entry<K, V>> h()
  {
    return hfd.b(hhk.a(b, c));
  }
  
  final hfd<K> j()
  {
    return hfd.b(b);
  }
  
  public final int size()
  {
    return 1;
  }
}

/* Location:
 * Qualified Name:     hiq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */