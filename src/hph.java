import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

final class hph
  implements Iterator
{
  @Deprecated
  final Iterator a = b.a.entrySet().iterator();
  
  hph(hpg paramhpg) {}
  
  public final boolean hasNext()
  {
    return a.hasNext();
  }
  
  public final Object next()
  {
    return ((Map.Entry)a.next()).getKey();
  }
  
  public final void remove()
  {
    a.remove();
  }
}

/* Location:
 * Qualified Name:     hph
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */