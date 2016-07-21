import android.util.Log;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class gmq
  extends Thread
{
  final ReferenceQueue<Object> a;
  final gmt b;
  final ConcurrentMap<Reference<?>, String> c = new ConcurrentHashMap();
  final Map<Reference<?>, String> d = new HashMap();
  final Deque<Object> e = new ArrayDeque(3);
  private final gmo f;
  
  gmq(ReferenceQueue<Object> paramReferenceQueue, gmt paramgmt, gmo paramgmo)
  {
    a = ((ReferenceQueue)gol.a(paramReferenceQueue));
    b = ((gmt)gol.a(paramgmt));
    f = ((gmo)gol.a(paramgmo));
  }
  
  private final void a()
  {
    boolean bool;
    if (!e.isEmpty())
    {
      bool = true;
      gol.a(bool, "The new cycle is not prepared.");
    }
    label46:
    int i;
    label95:
    label113:
    String str1;
    for (;;)
    {
      if (e.isEmpty()) {
        break label269;
      }
      Reference localReference;
      int j;
      if (!e.isEmpty())
      {
        bool = true;
        gol.a(bool);
        localObject = e.pop();
        localReference = b.a(localObject, a);
        j = 0;
      }
      for (;;)
      {
        if (j != 0) {
          break label228;
        }
        localObject = a.remove();
        i = j;
        if (localObject != null)
        {
          if (localReference == localObject) {
            if (i == 0)
            {
              bool = true;
              gol.a(bool, "Only one dummy object collected at a time.");
              i = 1;
            }
          }
          for (;;)
          {
            localObject = a.poll();
            break label95;
            bool = false;
            break;
            bool = false;
            break label46;
            bool = false;
            break label113;
            String str2 = (String)d.remove(localObject);
            str1 = str2;
            if (str2 == null) {
              str1 = (String)c.remove(localObject);
            }
            if (str1 != null) {
              f.a(str1);
            }
          }
        }
        j = i;
        if (i == 0)
        {
          f.a();
          j = i;
        }
      }
      label228:
      if (Log.isLoggable("LeakWatcherThread", 2))
      {
        i = e.size();
        new StringBuilder(38).append("Dummy collected, remaining ").append(i);
      }
    }
    label269:
    d.isEmpty();
    if (Log.isLoggable("LeakWatcherThread", 3))
    {
      i = d.size();
      new StringBuilder(45).append("Checking for leak: ").append(i).append(" leak(s) found.");
    }
    Object localObject = d.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      str1 = (String)((Iterator)localObject).next();
      f.b(str1);
    }
    f.a();
    d.clear();
  }
  
  public final void run()
  {
    while (!isInterrupted())
    {
      try
      {
        gol.a(d.isEmpty());
        Iterator localIterator = c.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          d.put((Reference)localEntry.getKey(), (String)localEntry.getValue());
          localIterator.remove();
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        interrupt();
      }
      int i = 0;
      while (i < 3)
      {
        e.push(new Object());
        i += 1;
      }
      Thread.sleep(5000L);
      a();
    }
    c.clear();
    d.clear();
    e.clear();
  }
}

/* Location:
 * Qualified Name:     gmq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */