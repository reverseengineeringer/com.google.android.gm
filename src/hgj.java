import java.io.Serializable;
import java.lang.ref.ReferenceQueue;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;

final class hgj<K, V>
  extends AbstractMap<K, V>
  implements Serializable, ConcurrentMap<K, V>
{
  static final hhf<Object, Object> j = new hgk();
  private static final long serialVersionUID = 5L;
  final transient int a;
  final transient int b;
  final transient hgx<K, V>[] c;
  final int d;
  final has<Object> e;
  final has<Object> f;
  final hgz g;
  final hgz h;
  final transient hgn i;
  transient Set<K> k;
  transient Collection<V> l;
  transient Set<Map.Entry<K, V>> m;
  
  hgj(hgi paramhgi)
  {
    d = Math.min(paramhgi.b(), 65536);
    g = paramhgi.c();
    h = ((hgz)haz.a(e, hgz.a));
    e = ((has)haz.a(f, paramhgi.c().a()));
    f = h.a();
    i = hgn.a(g);
    int i4 = Math.min(paramhgi.a(), 1073741824);
    int n = 1;
    int i1 = 0;
    while (n < d)
    {
      i1 += 1;
      n <<= 1;
    }
    b = (32 - i1);
    a = (n - 1);
    c = new hgx[n];
    i1 = i4 / n;
    if (n * i1 < i4)
    {
      n = i1 + 1;
      i1 = i2;
    }
    for (;;)
    {
      i2 = i3;
      if (i1 < n)
      {
        i1 <<= 1;
      }
      else
      {
        while (i2 < c.length)
        {
          c[i2] = new hgx(this, i1, -1);
          i2 += 1;
        }
        return;
        n = i1;
        i1 = i2;
      }
    }
  }
  
  private final int a(Object paramObject)
  {
    has localhas = e;
    if (paramObject == null) {}
    for (int n = 0;; n = localhas.a(paramObject))
    {
      n += (n << 15 ^ 0xCD7D);
      n ^= n >>> 10;
      n += (n << 3);
      n ^= n >>> 6;
      n += (n << 2) + (n << 14);
      return n ^ n >>> 16;
    }
  }
  
  static V a(hgv<K, V> paramhgv)
  {
    if (paramhgv.d() == null) {}
    do
    {
      return null;
      paramhgv = paramhgv.a().get();
    } while (paramhgv == null);
    return paramhgv;
  }
  
  static <E> ArrayList<E> a(Collection<E> paramCollection)
  {
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    hfu.a(localArrayList, paramCollection.iterator());
    return localArrayList;
  }
  
  final hgx<K, V> a(int paramInt)
  {
    return c[(paramInt >>> b & a)];
  }
  
  final boolean a()
  {
    return g != hgz.a;
  }
  
  final boolean b()
  {
    return h != hgz.a;
  }
  
  public final void clear()
  {
    hgx[] arrayOfhgx = c;
    int i2 = arrayOfhgx.length;
    int n = 0;
    while (n < i2)
    {
      hgx localhgx = arrayOfhgx[n];
      if (b != 0) {
        localhgx.lock();
      }
      try
      {
        AtomicReferenceArray localAtomicReferenceArray = e;
        int i1 = 0;
        while (i1 < localAtomicReferenceArray.length())
        {
          localAtomicReferenceArray.set(i1, null);
          i1 += 1;
        }
        while ((a.a()) && (g.poll() != null)) {}
        while ((a.b()) && (h.poll() != null)) {}
        i.set(0);
        c += 1;
        b = 0;
        localhgx.unlock();
        n += 1;
      }
      finally
      {
        localhgx.unlock();
      }
    }
  }
  
  public final boolean containsKey(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    int n = a(paramObject);
    return a(n).b(paramObject, n);
  }
  
  public final boolean containsValue(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    hgx[] arrayOfhgx = c;
    int n = 0;
    long l1;
    for (long l2 = -1L; n < 3; l2 = l1)
    {
      int i3 = arrayOfhgx.length;
      l1 = 0L;
      int i1 = 0;
      while (i1 < i3)
      {
        hgx localhgx = arrayOfhgx[i1];
        int i2 = b;
        AtomicReferenceArray localAtomicReferenceArray = e;
        i2 = 0;
        while (i2 < localAtomicReferenceArray.length())
        {
          for (hgv localhgv = (hgv)localAtomicReferenceArray.get(i2); localhgv != null; localhgv = localhgv.b())
          {
            Object localObject1;
            if (localhgv.d() == null)
            {
              localhgx.a();
              localObject1 = null;
            }
            while ((localObject1 != null) && (f.a(paramObject, localObject1)))
            {
              return true;
              Object localObject2 = localhgv.a().get();
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                localhgx.a();
                localObject1 = null;
              }
            }
          }
          i2 += 1;
        }
        l1 += c;
        i1 += 1;
      }
      if (l1 == l2) {
        break;
      }
      n += 1;
    }
    return false;
  }
  
  public final Set<Map.Entry<K, V>> entrySet()
  {
    Object localObject = m;
    if (localObject != null) {
      return (Set<Map.Entry<K, V>>)localObject;
    }
    localObject = new hgr(this);
    m = ((Set)localObject);
    return (Set<Map.Entry<K, V>>)localObject;
  }
  
  public final V get(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    int n = a(paramObject);
    return (V)a(n).a(paramObject, n);
  }
  
  public final boolean isEmpty()
  {
    hgx[] arrayOfhgx = c;
    int n = 0;
    long l1 = 0L;
    if (n < arrayOfhgx.length) {
      if (b == 0) {}
    }
    label90:
    do
    {
      return false;
      l1 += c;
      n += 1;
      break;
      if (l1 == 0L) {
        break label96;
      }
      n = 0;
      for (;;)
      {
        if (n >= arrayOfhgx.length) {
          break label90;
        }
        if (b != 0) {
          break;
        }
        l1 -= c;
        n += 1;
      }
    } while (l1 != 0L);
    label96:
    return true;
  }
  
  public final Set<K> keySet()
  {
    Object localObject = k;
    if (localObject != null) {
      return (Set<K>)localObject;
    }
    localObject = new hgu(this);
    k = ((Set)localObject);
    return (Set<K>)localObject;
  }
  
  public final V put(K paramK, V paramV)
  {
    hbe.a(paramK);
    hbe.a(paramV);
    int n = a(paramK);
    return (V)a(n).a(paramK, n, paramV, false);
  }
  
  public final void putAll(Map<? extends K, ? extends V> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      put(localEntry.getKey(), localEntry.getValue());
    }
  }
  
  public final V putIfAbsent(K paramK, V paramV)
  {
    hbe.a(paramK);
    hbe.a(paramV);
    int n = a(paramK);
    return (V)a(n).a(paramK, n, paramV, true);
  }
  
  public final V remove(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    int n = a(paramObject);
    return (V)a(n).c(paramObject, n);
  }
  
  public final boolean remove(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == null) || (paramObject2 == null)) {
      return false;
    }
    int n = a(paramObject1);
    return a(n).b(paramObject1, n, paramObject2);
  }
  
  public final V replace(K paramK, V paramV)
  {
    hbe.a(paramK);
    hbe.a(paramV);
    int n = a(paramK);
    return (V)a(n).a(paramK, n, paramV);
  }
  
  public final boolean replace(K paramK, V paramV1, V paramV2)
  {
    hbe.a(paramK);
    hbe.a(paramV2);
    if (paramV1 == null) {
      return false;
    }
    int n = a(paramK);
    return a(n).a(paramK, n, paramV1, paramV2);
  }
  
  public final int size()
  {
    hgx[] arrayOfhgx = c;
    long l1 = 0L;
    int n = 0;
    while (n < arrayOfhgx.length)
    {
      l1 += b;
      n += 1;
    }
    return hks.a(l1);
  }
  
  public final Collection<V> values()
  {
    Object localObject = l;
    if (localObject != null) {
      return (Collection<V>)localObject;
    }
    localObject = new hhg(this);
    l = ((Collection)localObject);
    return (Collection<V>)localObject;
  }
  
  final Object writeReplace()
  {
    return new hgy(g, h, e, f, d, this);
  }
}

/* Location:
 * Qualified Name:     hgj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */