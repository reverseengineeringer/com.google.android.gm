import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class hub
  implements Serializable
{
  private static final long serialVersionUID = -1913059830016450169L;
  final List a;
  
  public hub()
  {
    this(false);
  }
  
  public hub(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a = Collections.unmodifiableList(new ArrayList());
      return;
    }
    a = new hpw();
  }
  
  public final boolean a(hsy paramhsy)
  {
    if (paramhsy == null) {
      throw new IllegalArgumentException("Trying to add null Parameter");
    }
    return a.add(paramhsy);
  }
  
  public final boolean b(hsy paramhsy)
  {
    Object localObject = a;
    hub localhub = new hub();
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      hsy localhsy = (hsy)localIterator.next();
      if (a.equalsIgnoreCase((String)localObject)) {
        localhub.a(localhsy);
      }
    }
    localObject = a.iterator();
    while (((Iterator)localObject).hasNext()) {
      c((hsy)((Iterator)localObject).next());
    }
    return a(paramhsy);
  }
  
  public final boolean c(hsy paramhsy)
  {
    return a.remove(paramhsy);
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof hub))
    {
      paramObject = (hub)paramObject;
      return idh.a(a, a);
    }
    return super.equals(paramObject);
  }
  
  public final int hashCode()
  {
    return idlaa).a;
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      localStringBuffer.append(';');
      localStringBuffer.append(localIterator.next().toString());
    }
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     hub
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */