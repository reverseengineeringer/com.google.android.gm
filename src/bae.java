import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;

public final class bae
{
  final PriorityQueue<bag> a = new PriorityQueue(10, new baf());
  public final ConcurrentHashMap<Long, bag> b = new ConcurrentHashMap();
  private final int c = 10;
  private final Object d = new Object();
  
  public final bag a()
  {
    synchronized (d)
    {
      bag localbag = (bag)a.poll();
      long l;
      if (localbag != null)
      {
        l = c;
        b.remove(Long.valueOf(l));
      }
      if (localbag != null) {
        l = c;
      }
      return localbag;
    }
  }
  
  public final bag a(long paramLong)
  {
    if (paramLong < 0L) {
      return null;
    }
    synchronized (d)
    {
      bag localbag = (bag)b.get(Long.valueOf(paramLong));
      return localbag;
    }
  }
  
  public final boolean a(bag parambag)
  {
    long l = c;
    if (l < 0L)
    {
      cvm.b("AttachmentService", "Not adding a DownloadRequest with an invalid attachment id", new Object[0]);
      return false;
    }
    synchronized (d)
    {
      if (!b.containsKey(Long.valueOf(l)))
      {
        a.offer(parambag);
        b.put(Long.valueOf(l), parambag);
      }
      return true;
    }
  }
  
  public final int b()
  {
    synchronized (d)
    {
      int i = b.size();
      return i;
    }
  }
  
  public final boolean b(bag parambag)
  {
    if (parambag == null) {
      return true;
    }
    long l = c;
    synchronized (d)
    {
      boolean bool = a.remove(parambag);
      if (bool) {
        b.remove(Long.valueOf(c));
      }
      return bool;
    }
  }
  
  public final boolean c()
  {
    synchronized (d)
    {
      boolean bool = b.isEmpty();
      return bool;
    }
  }
}

/* Location:
 * Qualified Name:     bae
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */