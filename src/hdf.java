final class hdf
  extends hcr<K, V>
{
  hdg<K, V> a;
  
  hdf(hdg<K, V> paramhdg)
  {
    hdg localhdg;
    a = localhdg;
  }
  
  public final K getKey()
  {
    return (K)a.g;
  }
  
  public final V getValue()
  {
    return (V)a.h;
  }
  
  public final V setValue(V paramV)
  {
    Object localObject = a.h;
    int i = hdr.a(paramV);
    if ((i == a.b) && (hbc.a(paramV, localObject))) {
      return paramV;
    }
    if (b.a.b(paramV, i) == null) {}
    for (boolean bool = true;; bool = false)
    {
      hbe.a(bool, "value already present: %s", paramV);
      b.a.a(a);
      paramV = new hdg(a.g, a.a, paramV, i);
      b.a.a(paramV, a);
      a.f = null;
      a.e = null;
      b.d = b.a.c;
      if (b.c == a) {
        b.c = paramV;
      }
      a = paramV;
      return (V)localObject;
    }
  }
}

/* Location:
 * Qualified Name:     hdf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */