import java.util.Iterator;
import java.util.NoSuchElementException;

public final class ihq
  implements Iterator<String>
{
  int a = 0;
  private final int c;
  
  ihq(ihn paramihn, int paramInt)
  {
    c = paramInt;
  }
  
  private final boolean f()
  {
    return a < c;
  }
  
  public final String a()
  {
    if (!f()) {
      throw new NoSuchElementException();
    }
    String str = b();
    e();
    return str;
  }
  
  public final String b()
  {
    return b.a.substring(b.c[a], b.c[(a + 1)]);
  }
  
  public final boolean c()
  {
    while (f())
    {
      if (d() != ihr.q) {
        return true;
      }
      e();
    }
    return false;
  }
  
  public final ihr d()
  {
    return b.d[a];
  }
  
  public final void e()
  {
    if (!f()) {
      throw new NoSuchElementException();
    }
    a += 1;
  }
  
  public final boolean hasNext()
  {
    return f();
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     ihq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */