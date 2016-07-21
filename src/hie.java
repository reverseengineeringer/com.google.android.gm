import java.util.Map.Entry;

final class hie
  extends hdu<V, K>
{
  hie(hid paramhid) {}
  
  public final hdu<K, V> b()
  {
    return b;
  }
  
  final boolean d()
  {
    return false;
  }
  
  public final K get(Object paramObject)
  {
    if ((paramObject == null) || (b.c == null)) {}
    for (;;)
    {
      return null;
      int i = hdr.a(paramObject.hashCode());
      int j = b.e;
      for (her localher = b.c[(i & j)]; localher != null; localher = localher.b()) {
        if (paramObject.equals(localher.getValue())) {
          return (K)localher.getKey();
        }
      }
    }
  }
  
  final hfd<Map.Entry<V, K>> h()
  {
    return new hif(this);
  }
  
  public final int size()
  {
    return b.size();
  }
  
  final Object writeReplace()
  {
    return new hih(b);
  }
}

/* Location:
 * Qualified Name:     hie
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */