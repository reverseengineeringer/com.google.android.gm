import java.util.NoSuchElementException;

abstract class ihd
{
  private ijd a;
  
  public final boolean a()
  {
    if (a == null) {
      a = c();
    }
    return a != null;
  }
  
  public final ijd b()
  {
    if (a == null) {
      a = c();
    }
    ijd localijd = a;
    if (localijd == null) {
      throw new NoSuchElementException();
    }
    a = null;
    return localijd;
  }
  
  protected abstract ijd c();
}

/* Location:
 * Qualified Name:     ihd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */