final class hdk
  extends hcr<V, K>
{
  hdg<K, V> a;
  
  hdk(hdg<K, V> paramhdg)
  {
    hdg localhdg;
    a = localhdg;
  }
  
  public final V getKey()
  {
    return (V)a.h;
  }
  
  public final K getValue()
  {
    return (K)a.g;
  }
  
  public final K setValue(K paramK)
  {
    Object localObject = a.g;
    int i = hdr.a(paramK);
    if ((i == a.a) && (hbc.a(paramK, localObject))) {
      return paramK;
    }
    if (b.a.a.a.a(paramK, i) == null) {}
    for (boolean bool = true;; bool = false)
    {
      hbe.a(bool, "value already present: %s", paramK);
      b.a.a.a.a(a);
      paramK = new hdg(paramK, i, a.h, a.b);
      a = paramK;
      b.a.a.a.a(paramK, null);
      b.d = b.a.a.a.c;
      return (K)localObject;
    }
  }
}

/* Location:
 * Qualified Name:     hdk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */