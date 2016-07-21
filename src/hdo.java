import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class hdo<T>
  implements Iterator<T>
{
  hdg<K, V> b = e.a;
  hdg<K, V> c = null;
  int d = e.c;
  
  hdo(hdd paramhdd) {}
  
  abstract T a(hdg<K, V> paramhdg);
  
  public boolean hasNext()
  {
    if (e.c != d) {
      throw new ConcurrentModificationException();
    }
    return b != null;
  }
  
  public T next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    hdg localhdg = b;
    b = e;
    c = localhdg;
    return (T)a(localhdg);
  }
  
  public void remove()
  {
    if (e.c != d) {
      throw new ConcurrentModificationException();
    }
    if (c != null) {}
    for (boolean bool = true;; bool = false)
    {
      hbe.b(bool, "no calls to next() since the last call to remove()");
      e.a(c);
      d = e.c;
      c = null;
      return;
    }
  }
}

/* Location:
 * Qualified Name:     hdo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */