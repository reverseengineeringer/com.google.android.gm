import java.util.Iterator;
import java.util.NoSuchElementException;

public final class elp<T>
  implements Iterator<T>
{
  public final eli<T> a;
  public int b;
  
  public elp(eli<T> parameli)
  {
    a = ((eli)enz.a(parameli));
    b = -1;
  }
  
  public final boolean hasNext()
  {
    return b < a.c() - 1;
  }
  
  public final T next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException("Cannot advance the iterator beyond " + b);
    }
    eli localeli = a;
    int i = b + 1;
    b = i;
    return (T)localeli.a(i);
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
  }
}

/* Location:
 * Qualified Name:     elp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */