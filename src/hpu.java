import java.util.Iterator;

final class hpu
  extends hpe
{
  hpu(hpl paramhpl) {}
  
  public final void clear()
  {
    a.clear();
  }
  
  public final boolean contains(Object paramObject)
  {
    return a.containsValue(paramObject);
  }
  
  public final Iterator iterator()
  {
    return new hpt(a);
  }
  
  public final int size()
  {
    return a.size();
  }
}

/* Location:
 * Qualified Name:     hpu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */