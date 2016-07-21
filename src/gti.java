import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class gti
{
  private final Map<String, gtj> a = new gte();
  private final Map<Field, gtj> b = new gte();
  private final Object c;
  
  public gti(Object paramObject)
  {
    c = paramObject;
  }
  
  public final void a()
  {
    Iterator localIterator = a.entrySet().iterator();
    Map.Entry localEntry;
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      ((Map)c).put((String)localEntry.getKey(), ((gtj)localEntry.getValue()).a());
    }
    localIterator = b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      gtz.a((Field)localEntry.getKey(), c, ((gtj)localEntry.getValue()).a());
    }
  }
  
  public final void a(Field paramField, Class<?> paramClass, Object paramObject)
  {
    gtj localgtj2 = (gtj)b.get(paramField);
    gtj localgtj1 = localgtj2;
    if (localgtj2 == null)
    {
      localgtj1 = new gtj(paramClass);
      b.put(paramField, localgtj1);
    }
    if (paramClass == a) {}
    for (boolean bool = true;; bool = false)
    {
      hbe.a(bool);
      b.add(paramObject);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     gti
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */