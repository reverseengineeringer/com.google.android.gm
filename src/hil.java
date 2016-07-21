import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public final class hil<E>
  extends hfp<E>
{
  public static final hil<Comparable> c = new hil(hii.a, hhy.a);
  final transient hef<E> d;
  
  hil(hef<E> paramhef, Comparator<? super E> paramComparator)
  {
    super(paramComparator);
    d = paramhef;
  }
  
  final hfp<E> H_()
  {
    hia localhia = hia.a(a).a();
    if (isEmpty()) {
      return a(localhia);
    }
    return new hil(d.c(), localhia);
  }
  
  final int a(Object paramObject)
  {
    if (paramObject == null) {}
    for (;;)
    {
      return -1;
      try
      {
        int i = hiv.a(d, paramObject, a, hja.a, hiw.c);
        if (i >= 0) {
          return i;
        }
      }
      catch (ClassCastException paramObject) {}
    }
    return -1;
  }
  
  final int a(Object[] paramArrayOfObject, int paramInt)
  {
    return d.a(paramArrayOfObject, paramInt);
  }
  
  final hfp<E> a(E paramE, boolean paramBoolean)
  {
    return a(0, e(paramE, paramBoolean));
  }
  
  final hfp<E> a(E paramE1, boolean paramBoolean1, E paramE2, boolean paramBoolean2)
  {
    return b(paramE1, paramBoolean1).a(paramE2, paramBoolean2);
  }
  
  final hil<E> a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == size())) {
      return this;
    }
    if (paramInt1 < paramInt2) {
      return new hil(d.a(paramInt1, paramInt2), a);
    }
    return a(a);
  }
  
  public final hji<E> a()
  {
    return d.a();
  }
  
  final hfp<E> b(E paramE, boolean paramBoolean)
  {
    return a(f(paramE, paramBoolean), size());
  }
  
  public final hji<E> c()
  {
    return d.c().a();
  }
  
  public final E ceiling(E paramE)
  {
    int i = f(paramE, true);
    if (i == size()) {
      return null;
    }
    return (E)d.get(i);
  }
  
  public final boolean contains(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null) {}
    try
    {
      int i = Collections.binarySearch(d, paramObject, a);
      bool1 = bool2;
      if (i >= 0) {
        bool1 = true;
      }
      return bool1;
    }
    catch (ClassCastException paramObject) {}
    return false;
  }
  
  public final boolean containsAll(Collection<?> paramCollection)
  {
    boolean bool2 = true;
    Object localObject = paramCollection;
    if ((paramCollection instanceof hhx)) {
      localObject = ((hhx)paramCollection).a();
    }
    boolean bool1;
    if ((!hiu.a(comparator(), (Iterable)localObject)) || (((Collection)localObject).size() <= 1)) {
      bool1 = super.containsAll((Collection)localObject);
    }
    for (;;)
    {
      return bool1;
      hib localhib = hfu.d(d.a());
      localObject = ((Collection)localObject).iterator();
      paramCollection = ((Iterator)localObject).next();
      try
      {
        for (;;)
        {
          if (localhib.hasNext())
          {
            int i = b(localhib.a(), paramCollection);
            if (i < 0)
            {
              localhib.next();
            }
            else
            {
              if (i == 0)
              {
                bool1 = bool2;
                if (!((Iterator)localObject).hasNext()) {
                  break;
                }
                paramCollection = ((Iterator)localObject).next();
                continue;
              }
              if (i > 0) {
                return false;
              }
            }
          }
        }
      }
      catch (ClassCastException paramCollection)
      {
        return false;
        return false;
      }
      catch (NullPointerException paramCollection) {}
    }
    return false;
  }
  
  final hef<E> d()
  {
    if (size() <= 1) {
      return d;
    }
    return new hfi(this, d);
  }
  
  final int e(E paramE, boolean paramBoolean)
  {
    hef localhef = d;
    Object localObject = hbe.a(paramE);
    Comparator localComparator = comparator();
    if (paramBoolean) {}
    for (paramE = hja.d;; paramE = hja.c) {
      return hiv.a(localhef, localObject, localComparator, paramE, hiw.b);
    }
  }
  
  final boolean e()
  {
    return d.e();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    for (;;)
    {
      return true;
      if (!(paramObject instanceof Set)) {
        return false;
      }
      paramObject = (Set)paramObject;
      if (size() != ((Set)paramObject).size()) {
        return false;
      }
      if (!isEmpty()) {
        if (hiu.a(a, (Iterable)paramObject))
        {
          paramObject = ((Set)paramObject).iterator();
          try
          {
            hji localhji = d.a();
            int i;
            do
            {
              if (!localhji.hasNext()) {
                break;
              }
              Object localObject1 = localhji.next();
              Object localObject2 = ((Iterator)paramObject).next();
              if (localObject2 == null) {
                break label112;
              }
              i = b(localObject1, localObject2);
            } while (i == 0);
            label112:
            return false;
          }
          catch (ClassCastException paramObject)
          {
            return false;
          }
          catch (NoSuchElementException paramObject)
          {
            return false;
          }
        }
      }
    }
    return containsAll((Collection)paramObject);
  }
  
  final int f(E paramE, boolean paramBoolean)
  {
    hef localhef = d;
    Object localObject = hbe.a(paramE);
    Comparator localComparator = comparator();
    if (paramBoolean) {}
    for (paramE = hja.c;; paramE = hja.d) {
      return hiv.a(localhef, localObject, localComparator, paramE, hiw.b);
    }
  }
  
  public final E first()
  {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    return (E)d.get(0);
  }
  
  public final E floor(E paramE)
  {
    int i = e(paramE, true) - 1;
    if (i == -1) {
      return null;
    }
    return (E)d.get(i);
  }
  
  public final E higher(E paramE)
  {
    int i = f(paramE, false);
    if (i == size()) {
      return null;
    }
    return (E)d.get(i);
  }
  
  public final E last()
  {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    return (E)d.get(size() - 1);
  }
  
  public final E lower(E paramE)
  {
    int i = e(paramE, false) - 1;
    if (i == -1) {
      return null;
    }
    return (E)d.get(i);
  }
  
  public final int size()
  {
    return d.size();
  }
}

/* Location:
 * Qualified Name:     hil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */