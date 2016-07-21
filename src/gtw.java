import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class gtw
  implements Iterator<Map.Entry<String, Object>>
{
  private int b = -1;
  private gtz c;
  private Object d;
  private boolean e;
  private boolean f;
  private gtz g;
  
  gtw(gtu paramgtu) {}
  
  public final boolean hasNext()
  {
    if (!f)
    {
      f = true;
      for (d = null; d == null; d = c.a(a.a))
      {
        int i = b + 1;
        b = i;
        if (i >= a.b.d.size()) {
          break;
        }
        c = a.b.a((String)a.b.d.get(b));
      }
    }
    return d != null;
  }
  
  public final void remove()
  {
    if ((g != null) && (!e)) {}
    for (boolean bool = true;; bool = false)
    {
      hbe.b(bool);
      e = true;
      g.a(a.a, null);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     gtw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */