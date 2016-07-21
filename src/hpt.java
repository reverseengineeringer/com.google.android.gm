import java.util.Enumeration;
import java.util.Iterator;

final class hpt
  extends hpp
  implements Enumeration, Iterator
{
  hpt(hpl paramhpl)
  {
    super(paramhpl);
  }
  
  public final Object next()
  {
    return ac;
  }
  
  public final Object nextElement()
  {
    return ac;
  }
}

/* Location:
 * Qualified Name:     hpt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */