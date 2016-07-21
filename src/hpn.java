import java.util.Iterator;
import java.util.Map.Entry;

final class hpn
  extends hpj
{
  hpn(hpl paramhpl) {}
  
  public final void clear()
  {
    a.clear();
  }
  
  public final boolean contains(Object paramObject)
  {
    if (!(paramObject instanceof Map.Entry)) {}
    Object localObject;
    do
    {
      return false;
      paramObject = (Map.Entry)paramObject;
      localObject = a.get(((Map.Entry)paramObject).getKey());
    } while ((localObject == null) || (!localObject.equals(((Map.Entry)paramObject).getValue())));
    return true;
  }
  
  public final Iterator iterator()
  {
    return new hpm(a);
  }
  
  public final boolean remove(Object paramObject)
  {
    if (!(paramObject instanceof Map.Entry)) {}
    Object localObject2;
    Object localObject1;
    int i;
    do
    {
      do
      {
        return false;
        localObject2 = (Map.Entry)paramObject;
        paramObject = a;
        localObject1 = ((Map.Entry)localObject2).getKey();
        localObject2 = ((Map.Entry)localObject2).getValue();
      } while (localObject2 == null);
      i = hpl.a(localObject1.hashCode());
    } while (((hpl)paramObject).b(i).b(localObject1, i, localObject2) == null);
    return true;
  }
  
  public final int size()
  {
    return a.size();
  }
}

/* Location:
 * Qualified Name:     hpn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */