import android.util.LruCache;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class anq<K, V extends anj>
  implements ank<K, V>
{
  private static final String e = anq.class.getSimpleName();
  private final LinkedHashMap<K, V> a = new LinkedHashMap(0, 0.75F, true);
  private final LinkedBlockingQueue<V> b = new LinkedBlockingQueue();
  private final int c;
  private final LruCache<K, V> d;
  
  public anq(int paramInt, float paramFloat)
  {
    int i = Math.round(paramInt * 0.0F);
    if (i > 0) {}
    for (d = new anr(this, i);; d = null)
    {
      c = (paramInt - i);
      return;
    }
  }
  
  protected int a(V paramV)
  {
    return 1;
  }
  
  public V a(K paramK, V paramV)
  {
    anj localanj = null;
    ans.a("cache put");
    if (paramV == null)
    {
      ans.a();
      return null;
    }
    for (;;)
    {
      synchronized (a)
      {
        if (paramV.c())
        {
          localanj = (anj)a.put(paramK, paramV);
          ans.a();
          return localanj;
        }
      }
      if (d != null) {
        localanj = (anj)d.put(paramK, paramV);
      }
    }
  }
  
  public V a(K paramK, boolean paramBoolean)
  {
    ans.a("cache get");
    synchronized (a)
    {
      anj localanj2 = (anj)a.get(paramK);
      anj localanj1 = localanj2;
      if (localanj2 == null)
      {
        localanj1 = localanj2;
        if (d != null) {
          localanj1 = (anj)d.get(paramK);
        }
      }
      if ((paramBoolean) && (localanj1 != null)) {
        localanj1.a();
      }
      ans.a();
      return localanj1;
    }
  }
  
  public V b()
  {
    ans.a("pool poll");
    Object localObject1 = (anj)b.poll();
    if (localObject1 != null)
    {
      ans.a();
      return (V)localObject1;
    }
    LinkedHashMap localLinkedHashMap = a;
    int i = 0;
    label184:
    label187:
    for (;;)
    {
      try
      {
        Iterator localIterator = a.entrySet().iterator();
        localObject1 = null;
        if (!localIterator.hasNext()) {
          break label184;
        }
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        anj localanj = (anj)localEntry.getValue();
        if ((localanj.b() > 0) || (!localanj.c())) {
          continue;
        }
        if (localObject1 == null)
        {
          localObject1 = localEntry;
          i = a(localanj) + i;
          if (i <= c) {
            break label187;
          }
          if (i <= c)
          {
            ans.a();
            return null;
          }
          a.remove(((Map.Entry)localObject1).getKey());
          ans.a();
          localObject1 = (anj)((Map.Entry)localObject1).getValue();
          return (V)localObject1;
        }
      }
      finally {}
      continue;
    }
  }
  
  public void b(V paramV)
  {
    ans.a("pool offer");
    if ((paramV.b() != 0) || (!paramV.c()))
    {
      ans.a();
      paramV = String.valueOf(paramV);
      throw new IllegalArgumentException(String.valueOf(paramV).length() + 39 + "unexpected offer of an invalid object: " + paramV);
    }
    b.offer(paramV);
    ans.a();
  }
}

/* Location:
 * Qualified Name:     anq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */