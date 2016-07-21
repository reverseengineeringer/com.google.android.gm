import java.util.Iterator;

abstract class hjg<F, T>
  implements Iterator<T>
{
  final Iterator<? extends F> b;
  
  hjg(Iterator<? extends F> paramIterator)
  {
    b = ((Iterator)hbe.a(paramIterator));
  }
  
  abstract T a(F paramF);
  
  public final boolean hasNext()
  {
    return b.hasNext();
  }
  
  public final T next()
  {
    return (T)a(b.next());
  }
  
  public final void remove()
  {
    b.remove();
  }
}

/* Location:
 * Qualified Name:     hjg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */