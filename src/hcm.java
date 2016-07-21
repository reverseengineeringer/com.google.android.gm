import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

class hcm
  implements Iterator<V>
{
  final Iterator<V> a;
  final Collection<V> b = c.c;
  
  hcm(hcl paramhcl)
  {
    paramhcl = c;
    if ((paramhcl instanceof List)) {}
    for (paramhcl = ((List)paramhcl).listIterator();; paramhcl = paramhcl.iterator())
    {
      a = paramhcl;
      return;
    }
  }
  
  hcm(Iterator<V> paramIterator)
  {
    Iterator localIterator;
    a = localIterator;
  }
  
  final void a()
  {
    c.a();
    if (c.c != b) {
      throw new ConcurrentModificationException();
    }
  }
  
  public boolean hasNext()
  {
    a();
    return a.hasNext();
  }
  
  public V next()
  {
    a();
    return (V)a.next();
  }
  
  public void remove()
  {
    a.remove();
    hcc.a(c.f);
    c.b();
  }
}

/* Location:
 * Qualified Name:     hcm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */