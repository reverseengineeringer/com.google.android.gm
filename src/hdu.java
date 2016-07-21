public abstract class hdu<K, V>
  extends hel<K, V>
  implements hcu<K, V>
{
  public static <K, V> hdu<K, V> a(K paramK, V paramV)
  {
    return new hiq(paramK, paramV);
  }
  
  public abstract hdu<V, K> b();
  
  Object writeReplace()
  {
    return new hdw(this);
  }
}

/* Location:
 * Qualified Name:     hdu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */