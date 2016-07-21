import com.android.mail.providers.Folder;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

final class cur
  implements Comparable<cur>
{
  public cuq a;
  public final List<cur> b = new ArrayList();
  public final PriorityQueue<cur> c = new PriorityQueue();
  public boolean d = false;
  
  cur(cuq paramcuq)
  {
    a = paramcuq;
  }
  
  final void a(cur paramcur)
  {
    if (a.a.a())
    {
      b.add(paramcur);
      return;
    }
    c.add(paramcur);
  }
}

/* Location:
 * Qualified Name:     cur
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */