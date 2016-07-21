import java.util.Collection;
import java.util.List;
import java.util.Map;

abstract class hcb<K, V>
  extends hcc<K, V>
  implements hhw<K, V>
{
  private static final long serialVersionUID = 6588350623831699109L;
  
  protected hcb(Map<K, Collection<V>> paramMap)
  {
    super(paramMap);
  }
  
  abstract List<V> a();
  
  public List<V> a(K paramK)
  {
    return (List)super.b(paramK);
  }
  
  public boolean a(K paramK, V paramV)
  {
    return super.a(paramK, paramV);
  }
  
  public Map<K, Collection<V>> b()
  {
    return super.b();
  }
  
  public boolean equals(Object paramObject)
  {
    return super.equals(paramObject);
  }
}

/* Location:
 * Qualified Name:     hcb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */