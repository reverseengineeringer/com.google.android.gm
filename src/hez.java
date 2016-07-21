final class hez<K, V>
  extends hdx<V>
{
  final hel<K, V> a;
  
  hez(hel<K, V> paramhel)
  {
    a = paramhel;
  }
  
  public final hji<V> a()
  {
    return new hfa(this);
  }
  
  public final boolean contains(Object paramObject)
  {
    return (paramObject != null) && (hfu.a(a(), paramObject));
  }
  
  final boolean e()
  {
    return true;
  }
  
  public final hef<V> f()
  {
    return new hfb(this, a.g().f());
  }
  
  public final int size()
  {
    return a.size();
  }
  
  final Object writeReplace()
  {
    return new hfc(a);
  }
}

/* Location:
 * Qualified Name:     hez
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */