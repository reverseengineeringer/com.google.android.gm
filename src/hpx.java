import java.util.ListIterator;
import java.util.NoSuchElementException;

final class hpx
  implements ListIterator
{
  @Deprecated
  final Object[] a;
  @Deprecated
  int b;
  
  hpx(Object[] paramArrayOfObject, int paramInt)
  {
    a = paramArrayOfObject;
    b = paramInt;
  }
  
  public final void add(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean hasNext()
  {
    return b < a.length;
  }
  
  public final boolean hasPrevious()
  {
    return b > 0;
  }
  
  public final Object next()
  {
    try
    {
      Object localObject = a;
      int i = b;
      b = (i + 1);
      localObject = localObject[i];
      return localObject;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      throw new NoSuchElementException();
    }
  }
  
  public final int nextIndex()
  {
    return b;
  }
  
  public final Object previous()
  {
    try
    {
      Object localObject = a;
      int i = b - 1;
      b = i;
      localObject = localObject[i];
      return localObject;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      throw new NoSuchElementException();
    }
  }
  
  public final int previousIndex()
  {
    return b - 1;
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
 * Qualified Name:     hpx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */