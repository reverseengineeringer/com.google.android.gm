import java.util.NoSuchElementException;

final class hfv
  extends hjj<Object>
{
  public final boolean hasNext()
  {
    return false;
  }
  
  public final boolean hasPrevious()
  {
    return false;
  }
  
  public final Object next()
  {
    throw new NoSuchElementException();
  }
  
  public final int nextIndex()
  {
    return 0;
  }
  
  public final Object previous()
  {
    throw new NoSuchElementException();
  }
  
  public final int previousIndex()
  {
    return -1;
  }
}

/* Location:
 * Qualified Name:     hfv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */