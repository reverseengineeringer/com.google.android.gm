import java.lang.ref.ReferenceQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;

final class hgx<K, V>
  extends ReentrantLock
{
  final hgj<K, V> a;
  volatile int b;
  int c;
  int d;
  volatile AtomicReferenceArray<hgv<K, V>> e;
  final int f;
  final ReferenceQueue<K> g;
  final ReferenceQueue<V> h;
  final AtomicInteger i = new AtomicInteger();
  
  hgx(hgj<K, V> paramhgj, int paramInt1, int paramInt2)
  {
    a = paramhgj;
    f = -1;
    Object localObject1 = a(paramInt1);
    d = (((AtomicReferenceArray)localObject1).length() * 3 / 4);
    if (d == f) {
      d += 1;
    }
    e = ((AtomicReferenceArray)localObject1);
    if (paramhgj.a()) {}
    for (localObject1 = new ReferenceQueue();; localObject1 = null)
    {
      g = ((ReferenceQueue)localObject1);
      localObject1 = localObject2;
      if (paramhgj.b()) {
        localObject1 = new ReferenceQueue();
      }
      h = ((ReferenceQueue)localObject1);
      return;
    }
  }
  
  private final hgv<K, V> a(hgv<K, V> paramhgv1, hgv<K, V> paramhgv2)
  {
    if (paramhgv1.d() == null) {}
    hhf localhhf;
    Object localObject;
    do
    {
      return null;
      localhhf = paramhgv1.a();
      localObject = localhhf.get();
    } while (localObject == null);
    paramhgv1 = a.i.a(this, paramhgv1.d(), paramhgv1.c(), paramhgv2);
    paramhgv1.a(localhhf.a(h, localObject, paramhgv1));
    return paramhgv1;
  }
  
  private static AtomicReferenceArray<hgv<K, V>> a(int paramInt)
  {
    return new AtomicReferenceArray(paramInt);
  }
  
  private final void a(hgv<K, V> paramhgv, V paramV)
  {
    paramhgv.a(a.h.a(this, paramhgv, paramV));
  }
  
  private boolean a(hgv<K, V> paramhgv, int paramInt)
  {
    lock();
    try
    {
      int j = b;
      AtomicReferenceArray localAtomicReferenceArray = e;
      paramInt &= localAtomicReferenceArray.length() - 1;
      hgv localhgv2 = (hgv)localAtomicReferenceArray.get(paramInt);
      for (hgv localhgv1 = localhgv2; localhgv1 != null; localhgv1 = localhgv1.b()) {
        if (localhgv1 == paramhgv)
        {
          c += 1;
          paramhgv = b(localhgv2, localhgv1);
          j = b;
          localAtomicReferenceArray.set(paramInt, paramhgv);
          b = (j - 1);
          return true;
        }
      }
      return false;
    }
    finally
    {
      unlock();
    }
  }
  
  private static boolean a(hhf<K, V> paramhhf)
  {
    return paramhhf.get() == null;
  }
  
  private boolean a(K paramK, int paramInt, hhf<K, V> paramhhf)
  {
    lock();
    try
    {
      int j = b;
      AtomicReferenceArray localAtomicReferenceArray = e;
      j = paramInt & localAtomicReferenceArray.length() - 1;
      hgv localhgv2 = (hgv)localAtomicReferenceArray.get(j);
      for (hgv localhgv1 = localhgv2; localhgv1 != null; localhgv1 = localhgv1.b())
      {
        Object localObject = localhgv1.d();
        if ((localhgv1.c() == paramInt) && (localObject != null) && (a.e.a(paramK, localObject)))
        {
          if (localhgv1.a() == paramhhf)
          {
            c += 1;
            paramK = b(localhgv2, localhgv1);
            paramInt = b;
            localAtomicReferenceArray.set(j, paramK);
            b = (paramInt - 1);
            return true;
          }
          return false;
        }
      }
      return false;
    }
    finally
    {
      unlock();
    }
  }
  
  private final hgv<K, V> b(hgv<K, V> paramhgv1, hgv<K, V> paramhgv2)
  {
    int j = b;
    hgv localhgv = paramhgv2.b();
    Object localObject = paramhgv1;
    paramhgv1 = localhgv;
    if (localObject != paramhgv2)
    {
      localhgv = a((hgv)localObject, paramhgv1);
      if (localhgv != null) {
        paramhgv1 = localhgv;
      }
      for (;;)
      {
        localObject = ((hgv)localObject).b();
        break;
        j -= 1;
      }
    }
    b = j;
    return paramhgv1;
  }
  
  private final void c()
  {
    int k = 0;
    int j;
    if (a.a()) {
      j = 0;
    }
    for (;;)
    {
      Object localObject = g.poll();
      hgj localhgj;
      if (localObject != null)
      {
        localObject = (hgv)localObject;
        localhgj = a;
        int m = ((hgv)localObject).c();
        localhgj.a(m).a((hgv)localObject, m);
        j += 1;
        if (j != 16) {}
      }
      else
      {
        if (a.b())
        {
          j = k;
          do
          {
            localObject = h.poll();
            if (localObject == null) {
              break;
            }
            localObject = (hhf)localObject;
            localhgj = a;
            hgv localhgv = ((hhf)localObject).a();
            k = localhgv.c();
            localhgj.a(k).a(localhgv.d(), k, (hhf)localObject);
            k = j + 1;
            j = k;
          } while (k != 16);
        }
        return;
      }
    }
  }
  
  private final hgv<K, V> d(Object paramObject, int paramInt)
  {
    if (b != 0)
    {
      Object localObject1 = e;
      localObject1 = (hgv)((AtomicReferenceArray)localObject1).get(((AtomicReferenceArray)localObject1).length() - 1 & paramInt);
      if (localObject1 != null)
      {
        Object localObject2;
        if (((hgv)localObject1).c() == paramInt)
        {
          localObject2 = ((hgv)localObject1).d();
          if (localObject2 != null) {
            break label69;
          }
          a();
        }
        label69:
        while (!a.e.a(paramObject, localObject2))
        {
          localObject1 = ((hgv)localObject1).b();
          break;
        }
        return (hgv<K, V>)localObject1;
      }
    }
    return null;
  }
  
  private final void d()
  {
    if (tryLock()) {}
    try
    {
      c();
      i.set(0);
      return;
    }
    finally
    {
      unlock();
    }
  }
  
  private final hgv<K, V> e(Object paramObject, int paramInt)
  {
    hgv localhgv = d(paramObject, paramInt);
    paramObject = localhgv;
    if (localhgv == null) {
      paramObject = null;
    }
    return (hgv<K, V>)paramObject;
  }
  
  final V a(Object paramObject, int paramInt)
  {
    try
    {
      paramObject = e(paramObject, paramInt);
      if (paramObject == null) {
        return null;
      }
      paramObject = ((hgv)paramObject).a().get();
      if (paramObject == null) {
        a();
      }
      return (V)paramObject;
    }
    finally
    {
      b();
    }
  }
  
  final V a(K paramK, int paramInt, V paramV)
  {
    lock();
    try
    {
      d();
      AtomicReferenceArray localAtomicReferenceArray = e;
      int j = paramInt & localAtomicReferenceArray.length() - 1;
      hgv localhgv2 = (hgv)localAtomicReferenceArray.get(j);
      for (hgv localhgv1 = localhgv2; localhgv1 != null; localhgv1 = localhgv1.b())
      {
        Object localObject = localhgv1.d();
        if ((localhgv1.c() == paramInt) && (localObject != null) && (a.e.a(paramK, localObject)))
        {
          paramK = localhgv1.a();
          localObject = paramK.get();
          if (localObject == null)
          {
            if (a(paramK))
            {
              paramInt = b;
              c += 1;
              paramK = b(localhgv2, localhgv1);
              paramInt = b;
              localAtomicReferenceArray.set(j, paramK);
              b = (paramInt - 1);
            }
            return null;
          }
          c += 1;
          a(localhgv1, paramV);
          return (V)localObject;
        }
      }
      return null;
    }
    finally
    {
      unlock();
    }
  }
  
  final V a(K paramK, int paramInt, V paramV, boolean paramBoolean)
  {
    lock();
    for (;;)
    {
      int m;
      Object localObject3;
      int k;
      try
      {
        d();
        j = b + 1;
        if (j <= d) {
          break label537;
        }
        Object localObject4 = e;
        int i1 = ((AtomicReferenceArray)localObject4).length();
        Object localObject1;
        if (i1 < 1073741824)
        {
          j = b;
          AtomicReferenceArray localAtomicReferenceArray = a(i1 << 1);
          d = (localAtomicReferenceArray.length() * 3 / 4);
          int i2 = localAtomicReferenceArray.length() - 1;
          m = 0;
          if (m < i1)
          {
            localObject3 = (hgv)((AtomicReferenceArray)localObject4).get(m);
            k = j;
            if (localObject3 != null)
            {
              localObject1 = ((hgv)localObject3).b();
              k = ((hgv)localObject3).c() & i2;
              if (localObject1 != null) {
                break label549;
              }
              localAtomicReferenceArray.set(k, localObject3);
              break label540;
              if (localObject1 != null)
              {
                int n = ((hgv)localObject1).c() & i2;
                if (n == k) {
                  break label534;
                }
                localObject2 = localObject1;
                k = n;
                localObject1 = ((hgv)localObject1).b();
                continue;
              }
              localAtomicReferenceArray.set(k, localObject2);
              localObject1 = localObject3;
              k = j;
              if (localObject1 != localObject2)
              {
                k = ((hgv)localObject1).c() & i2;
                localObject3 = a((hgv)localObject1, (hgv)localAtomicReferenceArray.get(k));
                if (localObject3 == null) {
                  break label556;
                }
                localAtomicReferenceArray.set(k, localObject3);
                localObject1 = ((hgv)localObject1).b();
                continue;
              }
            }
          }
          else
          {
            e = localAtomicReferenceArray;
            b = j;
          }
        }
        else
        {
          j = b + 1;
          localObject3 = e;
          k = paramInt & ((AtomicReferenceArray)localObject3).length() - 1;
          localObject2 = (hgv)((AtomicReferenceArray)localObject3).get(k);
          localObject1 = localObject2;
          if (localObject1 != null)
          {
            localObject4 = ((hgv)localObject1).d();
            if ((((hgv)localObject1).c() == paramInt) && (localObject4 != null) && (a.e.a(paramK, localObject4)))
            {
              paramK = ((hgv)localObject1).a().get();
              if (paramK == null)
              {
                c += 1;
                a((hgv)localObject1, paramV);
                b = b;
                return null;
              }
              if (paramBoolean) {
                return paramK;
              }
              c += 1;
              a((hgv)localObject1, paramV);
              return paramK;
            }
            localObject1 = ((hgv)localObject1).b();
            continue;
          }
          c += 1;
          paramK = a.i.a(this, paramK, paramInt, (hgv)localObject2);
          a(paramK, paramV);
          ((AtomicReferenceArray)localObject3).set(k, paramK);
          b = j;
          return null;
        }
      }
      finally
      {
        unlock();
      }
      int j = k;
      break label540;
      label534:
      continue;
      label537:
      continue;
      label540:
      m += 1;
      continue;
      label549:
      Object localObject2 = localObject3;
      continue;
      label556:
      j -= 1;
    }
  }
  
  final void a()
  {
    if (tryLock()) {}
    try
    {
      c();
      return;
    }
    finally
    {
      unlock();
    }
  }
  
  final boolean a(K paramK, int paramInt, V paramV1, V paramV2)
  {
    lock();
    try
    {
      d();
      AtomicReferenceArray localAtomicReferenceArray = e;
      int j = paramInt & localAtomicReferenceArray.length() - 1;
      hgv localhgv2 = (hgv)localAtomicReferenceArray.get(j);
      for (hgv localhgv1 = localhgv2; localhgv1 != null; localhgv1 = localhgv1.b())
      {
        Object localObject = localhgv1.d();
        if ((localhgv1.c() == paramInt) && (localObject != null) && (a.e.a(paramK, localObject)))
        {
          paramK = localhgv1.a();
          localObject = paramK.get();
          if (localObject == null)
          {
            if (a(paramK))
            {
              paramInt = b;
              c += 1;
              paramK = b(localhgv2, localhgv1);
              paramInt = b;
              localAtomicReferenceArray.set(j, paramK);
              b = (paramInt - 1);
            }
            return false;
          }
          if (a.f.a(paramV1, localObject))
          {
            c += 1;
            a(localhgv1, paramV2);
            return true;
          }
          return false;
        }
      }
      return false;
    }
    finally
    {
      unlock();
    }
  }
  
  final void b()
  {
    if ((i.incrementAndGet() & 0x3F) == 0) {
      d();
    }
  }
  
  final boolean b(Object paramObject, int paramInt)
  {
    boolean bool = false;
    try
    {
      if (b != 0)
      {
        paramObject = e(paramObject, paramInt);
        if (paramObject == null) {
          return false;
        }
        paramObject = ((hgv)paramObject).a().get();
        if (paramObject != null) {
          bool = true;
        }
        return bool;
      }
      return false;
    }
    finally
    {
      b();
    }
  }
  
  final boolean b(Object paramObject1, int paramInt, Object paramObject2)
  {
    boolean bool1 = false;
    lock();
    try
    {
      d();
      int j = b;
      AtomicReferenceArray localAtomicReferenceArray = e;
      j = paramInt & localAtomicReferenceArray.length() - 1;
      hgv localhgv2 = (hgv)localAtomicReferenceArray.get(j);
      for (hgv localhgv1 = localhgv2; localhgv1 != null; localhgv1 = localhgv1.b())
      {
        Object localObject = localhgv1.d();
        if ((localhgv1.c() == paramInt) && (localObject != null) && (a.e.a(paramObject1, localObject)))
        {
          paramObject1 = localhgv1.a();
          localObject = ((hhf)paramObject1).get();
          if (a.f.a(paramObject2, localObject)) {
            bool1 = true;
          }
          boolean bool2;
          do
          {
            c += 1;
            paramObject1 = b(localhgv2, localhgv1);
            paramInt = b;
            localAtomicReferenceArray.set(j, paramObject1);
            b = (paramInt - 1);
            return bool1;
            bool2 = a((hhf)paramObject1);
          } while (bool2);
          return false;
        }
      }
      return false;
    }
    finally
    {
      unlock();
    }
  }
  
  final V c(Object paramObject, int paramInt)
  {
    lock();
    try
    {
      d();
      int j = b;
      AtomicReferenceArray localAtomicReferenceArray = e;
      j = paramInt & localAtomicReferenceArray.length() - 1;
      hgv localhgv2 = (hgv)localAtomicReferenceArray.get(j);
      for (hgv localhgv1 = localhgv2; localhgv1 != null; localhgv1 = localhgv1.b())
      {
        Object localObject = localhgv1.d();
        if ((localhgv1.c() == paramInt) && (localObject != null) && (a.e.a(paramObject, localObject)))
        {
          localObject = localhgv1.a();
          paramObject = ((hhf)localObject).get();
          if (paramObject == null)
          {
            boolean bool = a((hhf)localObject);
            if (!bool) {
              return null;
            }
          }
          c += 1;
          localhgv1 = b(localhgv2, localhgv1);
          paramInt = b;
          localAtomicReferenceArray.set(j, localhgv1);
          b = (paramInt - 1);
          return (V)paramObject;
        }
      }
      return null;
    }
    finally
    {
      unlock();
    }
  }
}

/* Location:
 * Qualified Name:     hgx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */