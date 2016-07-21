import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class gzt<T>
  implements Iterator<T>
{
  int a = gzv.b;
  private T b;
  
  protected abstract T a();
  
  public final boolean hasNext()
  {
    if (a != gzv.d) {}
    for (boolean bool = true;; bool = false)
    {
      hbe.b(bool);
      switch (gzu.a[(a - 1)])
      {
      default: 
        a = gzv.d;
        b = a();
        if (a == gzv.c) {
          break;
        }
        a = gzv.a;
      case 1: 
        return true;
      }
    }
    return false;
    return false;
  }
  
  public final T next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    a = gzv.b;
    Object localObject = b;
    b = null;
    return (T)localObject;
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     gzt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */