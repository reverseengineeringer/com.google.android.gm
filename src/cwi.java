import java.util.Deque;
import java.util.LinkedList;

public final class cwi<T>
{
  private final Deque<T> a = new LinkedList();
  private final cwj<T> b;
  private final int c;
  
  public cwi()
  {
    cwj localcwj;
    b = localcwj;
    c = 2;
  }
  
  public final T a()
  {
    synchronized (a)
    {
      Object localObject2 = a.poll();
      ??? = localObject2;
      if (localObject2 == null) {
        ??? = b.a();
      }
      return (T)???;
    }
  }
  
  public final void a(T paramT)
  {
    synchronized (a)
    {
      if (a.size() < c)
      {
        b.a(paramT);
        a.add(paramT);
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     cwi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */