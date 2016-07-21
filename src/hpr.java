import java.util.Iterator;

final class hpr
  extends hpj
{
  hpr(hpl paramhpl) {}
  
  public final void clear()
  {
    a.clear();
  }
  
  public final boolean contains(Object paramObject)
  {
    return a.containsKey(paramObject);
  }
  
  public final Iterator iterator()
  {
    return new hpq(a);
  }
  
  public final boolean remove(Object paramObject)
  {
    return a.remove(paramObject) != null;
  }
  
  public final int size()
  {
    return a.size();
  }
}

/* Location:
 * Qualified Name:     hpr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */