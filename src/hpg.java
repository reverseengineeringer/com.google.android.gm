import java.util.Iterator;

final class hpg
  extends hpj
{
  hpg(hpf paramhpf) {}
  
  public final boolean contains(Object paramObject)
  {
    return a.containsKey(paramObject);
  }
  
  public final Iterator iterator()
  {
    return new hph(this);
  }
  
  public final int size()
  {
    return a.size();
  }
}

/* Location:
 * Qualified Name:     hpg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */