import java.util.Iterator;
import java.util.NoSuchElementException;

public final class fws<T>
  implements Iterable<T>, Iterator<T>
{
  public final boolean hasNext()
  {
    return false;
  }
  
  public final Iterator<T> iterator()
  {
    return this;
  }
  
  public final T next()
  {
    throw new NoSuchElementException();
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     fws
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */