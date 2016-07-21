import java.util.Iterator;
import java.util.Map.Entry;

final class gtg
  implements Iterator<Map.Entry<K, V>>
{
  private boolean b;
  private int c;
  
  gtg(gte paramgte) {}
  
  public final boolean hasNext()
  {
    return c < a.a;
  }
  
  public final void remove()
  {
    int i = c - 1;
    if ((b) || (i < 0)) {
      throw new IllegalArgumentException();
    }
    a.b(i << 1);
    b = true;
  }
}

/* Location:
 * Qualified Name:     gtg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */