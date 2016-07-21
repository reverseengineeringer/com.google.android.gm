import java.util.Iterator;
import java.util.NoSuchElementException;

final class hfy
  implements Iterator<Object>
{
  public final boolean hasNext()
  {
    return false;
  }
  
  public final Object next()
  {
    throw new NoSuchElementException();
  }
  
  public final void remove()
  {
    hbe.b(false, "no calls to next() since the last call to remove()");
  }
}

/* Location:
 * Qualified Name:     hfy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */