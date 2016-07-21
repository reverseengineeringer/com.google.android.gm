import java.util.Iterator;

final class hdp
  extends hht<K, V>
{
  hdp(hdd paramhdd)
  {
    super(paramhdd);
  }
  
  public final Iterator<K> iterator()
  {
    return new hdq(this);
  }
  
  public final boolean remove(Object paramObject)
  {
    paramObject = a.a(paramObject, hdr.a(paramObject));
    if (paramObject == null) {
      return false;
    }
    a.a((hdg)paramObject);
    f = null;
    e = null;
    return true;
  }
}

/* Location:
 * Qualified Name:     hdp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */