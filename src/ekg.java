import java.util.ArrayList;
import java.util.Iterator;

final class ekg
  extends ekh
{
  private final ArrayList<eit> c;
  
  public ekg(ArrayList<eit> paramArrayList)
  {
    super(paramArrayList);
    ArrayList localArrayList;
    c = localArrayList;
  }
  
  public final void a()
  {
    Iterator localIterator = c.iterator();
    while (localIterator.hasNext()) {
      ((eit)localIterator.next()).a(a.g);
    }
  }
}

/* Location:
 * Qualified Name:     ekg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */