import java.io.Serializable;
import java.util.Iterator;
import java.util.Map.Entry;

class heq
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  private final Object[] a;
  private final Object[] b;
  
  heq(hel<?, ?> paramhel)
  {
    a = new Object[paramhel.size()];
    b = new Object[paramhel.size()];
    paramhel = paramhel.g().a();
    int i = 0;
    while (paramhel.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramhel.next();
      a[i] = localEntry.getKey();
      b[i] = localEntry.getValue();
      i += 1;
    }
  }
  
  final Object a(hen<Object, Object> paramhen)
  {
    int i = 0;
    while (i < a.length)
    {
      paramhen.b(a[i], b[i]);
      i += 1;
    }
    return paramhen.b();
  }
  
  Object readResolve()
  {
    return a(new hen(a.length));
  }
}

/* Location:
 * Qualified Name:     heq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */