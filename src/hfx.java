import java.util.NoSuchElementException;

final class hfx
  extends hji<T>
{
  boolean a;
  
  hfx(Object paramObject) {}
  
  public final boolean hasNext()
  {
    return !a;
  }
  
  public final T next()
  {
    if (a) {
      throw new NoSuchElementException();
    }
    a = true;
    return (T)b;
  }
}

/* Location:
 * Qualified Name:     hfx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */