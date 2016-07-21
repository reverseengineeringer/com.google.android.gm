class het<K, V>
  extends her<K, V>
{
  private final transient her<K, V> a;
  
  het(K paramK, V paramV, her<K, V> paramher)
  {
    super(paramK, paramV);
    a = paramher;
  }
  
  final her<K, V> a()
  {
    return a;
  }
  
  final boolean c()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     het
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */