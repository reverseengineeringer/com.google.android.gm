final class hhc<K, V>
  implements hgv<K, V>
{
  final K a;
  final int b;
  final hgv<K, V> c;
  volatile hhf<K, V> d = hgj.j;
  
  hhc(K paramK, int paramInt, hgv<K, V> paramhgv)
  {
    a = paramK;
    b = paramInt;
    c = paramhgv;
  }
  
  public final hhf<K, V> a()
  {
    return d;
  }
  
  public final void a(hhf<K, V> paramhhf)
  {
    hhf localhhf = d;
    d = paramhhf;
    localhhf.b();
  }
  
  public final hgv<K, V> b()
  {
    return c;
  }
  
  public final int c()
  {
    return b;
  }
  
  public final K d()
  {
    return (K)a;
  }
}

/* Location:
 * Qualified Name:     hhc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */