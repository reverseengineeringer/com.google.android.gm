import java.util.Iterator;

final class hgb<E>
  implements hib<E>
{
  private final Iterator<? extends E> a;
  private boolean b;
  private E c;
  
  public hgb(Iterator<? extends E> paramIterator)
  {
    a = ((Iterator)hbe.a(paramIterator));
  }
  
  public final E a()
  {
    if (!b)
    {
      c = a.next();
      b = true;
    }
    return (E)c;
  }
  
  public final boolean hasNext()
  {
    return (b) || (a.hasNext());
  }
  
  public final E next()
  {
    if (!b) {
      return (E)a.next();
    }
    Object localObject = c;
    b = false;
    c = null;
    return (E)localObject;
  }
  
  public final void remove()
  {
    if (!b) {}
    for (boolean bool = true;; bool = false)
    {
      hbe.b(bool, "Can't remove after you've peeked at next");
      a.remove();
      return;
    }
  }
}

/* Location:
 * Qualified Name:     hgb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */