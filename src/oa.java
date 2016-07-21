import java.util.Iterator;

final class oa<T>
  implements Iterator<T>
{
  final int a;
  int b;
  int c;
  boolean d = false;
  
  oa(nz paramnz, int paramInt)
  {
    a = paramInt;
    b = paramnz.a();
  }
  
  public final boolean hasNext()
  {
    return c < b;
  }
  
  public final T next()
  {
    Object localObject = e.a(c, a);
    c += 1;
    d = true;
    return (T)localObject;
  }
  
  public final void remove()
  {
    if (!d) {
      throw new IllegalStateException();
    }
    c -= 1;
    b -= 1;
    d = false;
    e.a(c);
  }
}

/* Location:
 * Qualified Name:     oa
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */