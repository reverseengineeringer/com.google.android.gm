import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReferenceArray;

abstract class hgs<E>
  implements Iterator<E>
{
  int b;
  int c;
  hgx<K, V> d;
  AtomicReferenceArray<hgv<K, V>> e;
  hgv<K, V> f;
  hhj g;
  hhj h;
  
  hgs(hgj paramhgj)
  {
    b = (c.length - 1);
    c = -1;
    b();
  }
  
  private final boolean a(hgv<K, V> paramhgv)
  {
    try
    {
      Object localObject = paramhgv.d();
      paramhgv = hgj.a(paramhgv);
      if (paramhgv != null)
      {
        g = new hhj(i, localObject, paramhgv);
        return true;
      }
      return false;
    }
    finally
    {
      d.b();
    }
  }
  
  private final void b()
  {
    g = null;
    if (c()) {}
    do
    {
      do
      {
        do
        {
          ;;
          while (d()) {}
        } while (b < 0);
        hgx[] arrayOfhgx = i.c;
        int j = b;
        b = (j - 1);
        d = arrayOfhgx[j];
      } while (d.b == 0);
      e = d.e;
      c = (e.length() - 1);
    } while (!d());
  }
  
  private final boolean c()
  {
    if (f != null) {
      for (f = f.b(); f != null; f = f.b()) {
        if (a(f)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private final boolean d()
  {
    while (c >= 0)
    {
      Object localObject = e;
      int j = c;
      c = (j - 1);
      localObject = (hgv)((AtomicReferenceArray)localObject).get(j);
      f = ((hgv)localObject);
      if ((localObject != null) && ((a(f)) || (c()))) {
        return true;
      }
    }
    return false;
  }
  
  final hhj a()
  {
    if (g == null) {
      throw new NoSuchElementException();
    }
    h = g;
    b();
    return h;
  }
  
  public boolean hasNext()
  {
    return g != null;
  }
  
  public void remove()
  {
    if (h != null) {}
    for (boolean bool = true;; bool = false)
    {
      hbe.b(bool, "no calls to next() since the last call to remove()");
      i.remove(h.getKey());
      h = null;
      return;
    }
  }
}

/* Location:
 * Qualified Name:     hgs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */