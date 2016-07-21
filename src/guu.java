import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class guu
  implements Iterator<T>
{
  final int a = Array.getLength(c.a);
  int b = 0;
  
  guu(gut paramgut) {}
  
  public final boolean hasNext()
  {
    return b < a;
  }
  
  public final T next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    Object localObject = c.a;
    int i = b;
    b = (i + 1);
    return (T)Array.get(localObject, i);
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     guu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */