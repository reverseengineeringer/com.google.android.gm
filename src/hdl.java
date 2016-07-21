import java.util.Iterator;

final class hdl
  extends hht<V, K>
{
  hdl(hdh paramhdh)
  {
    super(paramhdh);
  }
  
  public final Iterator<V> iterator()
  {
    return new hdm(this);
  }
  
  public final boolean remove(Object paramObject)
  {
    paramObject = a.a.b(paramObject, hdr.a(paramObject));
    if (paramObject == null) {
      return false;
    }
    a.a.a((hdg)paramObject);
    return true;
  }
}

/* Location:
 * Qualified Name:     hdl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */