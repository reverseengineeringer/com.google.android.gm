import java.util.ListIterator;
import java.util.NoSuchElementException;

final class hpy
  implements ListIterator
{
  @Deprecated
  final Object[] a;
  @Deprecated
  int b;
  @Deprecated
  int c;
  @Deprecated
  int d;
  
  hpy(Object[] paramArrayOfObject, int paramInt1, int paramInt2, int paramInt3)
  {
    a = paramArrayOfObject;
    c = paramInt1;
    d = paramInt2;
    b = paramInt3;
  }
  
  public final void add(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean hasNext()
  {
    return b < d;
  }
  
  public final boolean hasPrevious()
  {
    return b > c;
  }
  
  public final Object next()
  {
    if (b == d) {
      throw new NoSuchElementException();
    }
    Object[] arrayOfObject = a;
    int i = b;
    b = (i + 1);
    return arrayOfObject[i];
  }
  
  public final int nextIndex()
  {
    return b - c;
  }
  
  public final Object previous()
  {
    if (b == c) {
      throw new NoSuchElementException();
    }
    Object[] arrayOfObject = a;
    int i = b - 1;
    b = i;
    return arrayOfObject[i];
  }
  
  public final int previousIndex()
  {
    return b - c - 1;
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException();
  }
  
  public final void set(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     hpy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */