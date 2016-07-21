import java.util.NoSuchElementException;

abstract class hca<E>
  extends hjj<E>
{
  private final int a;
  private int b;
  
  protected hca(int paramInt1, int paramInt2)
  {
    hbe.b(paramInt2, paramInt1);
    a = paramInt1;
    b = paramInt2;
  }
  
  protected abstract E a(int paramInt);
  
  public final boolean hasNext()
  {
    return b < a;
  }
  
  public final boolean hasPrevious()
  {
    return b > 0;
  }
  
  public final E next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    int i = b;
    b = (i + 1);
    return (E)a(i);
  }
  
  public final int nextIndex()
  {
    return b;
  }
  
  public final E previous()
  {
    if (!hasPrevious()) {
      throw new NoSuchElementException();
    }
    int i = b - 1;
    b = i;
    return (E)a(i);
  }
  
  public final int previousIndex()
  {
    return b - 1;
  }
}

/* Location:
 * Qualified Name:     hca
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */