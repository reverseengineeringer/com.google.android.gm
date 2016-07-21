import java.util.Map;

public abstract interface hcu<K, V>
  extends Map<K, V>
{
  public abstract hcu<V, K> a();
  
  public abstract V put(K paramK, V paramV);
}

/* Location:
 * Qualified Name:     hcu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */