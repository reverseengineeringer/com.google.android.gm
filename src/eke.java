import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

final class eke
  extends ekh
{
  private final ArrayList<eit> c;
  
  public eke(ArrayList<eit> paramArrayList)
  {
    super(paramArrayList);
    ArrayList localArrayList;
    c = localArrayList;
  }
  
  public final void a()
  {
    Set localSet = a.a.o;
    if (localSet.isEmpty()) {
      localSet = a.j();
    }
    for (;;)
    {
      Iterator localIterator = c.iterator();
      while (localIterator.hasNext()) {
        ((eit)localIterator.next()).a(a.g, localSet);
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     eke
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */