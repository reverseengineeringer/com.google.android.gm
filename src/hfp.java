import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Comparator;
import java.util.NavigableSet;

public abstract class hfp<E>
  extends hfs<E>
  implements hit<E>, NavigableSet<E>
{
  final transient Comparator<? super E> a;
  transient hfp<E> b;
  
  hfp(Comparator<? super E> paramComparator)
  {
    a = paramComparator;
  }
  
  static <E> hil<E> a(Comparator<? super E> paramComparator)
  {
    if (hhy.a.equals(paramComparator)) {
      return hil.c;
    }
    return new hil(hii.a, paramComparator);
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    throw new InvalidObjectException("Use SerializedForm");
  }
  
  hfp<E> H_()
  {
    return new hcz(this);
  }
  
  abstract int a(Object paramObject);
  
  abstract hfp<E> a(E paramE, boolean paramBoolean);
  
  abstract hfp<E> a(E paramE1, boolean paramBoolean1, E paramE2, boolean paramBoolean2);
  
  public abstract hji<E> a();
  
  final int b(Object paramObject1, Object paramObject2)
  {
    return a.compare(paramObject1, paramObject2);
  }
  
  public hfp<E> b()
  {
    hfp localhfp2 = b;
    hfp localhfp1 = localhfp2;
    if (localhfp2 == null)
    {
      localhfp1 = H_();
      b = localhfp1;
      b = this;
    }
    return localhfp1;
  }
  
  abstract hfp<E> b(E paramE, boolean paramBoolean);
  
  public final hfp<E> b(E paramE1, boolean paramBoolean1, E paramE2, boolean paramBoolean2)
  {
    hbe.a(paramE1);
    hbe.a(paramE2);
    if (a.compare(paramE1, paramE2) <= 0) {}
    for (boolean bool = true;; bool = false)
    {
      hbe.a(bool);
      return a(paramE1, paramBoolean1, paramE2, paramBoolean2);
    }
  }
  
  public final hfp<E> c(E paramE, boolean paramBoolean)
  {
    return a(hbe.a(paramE), paramBoolean);
  }
  
  public abstract hji<E> c();
  
  public E ceiling(E paramE)
  {
    return (E)hft.b(d(paramE, true));
  }
  
  public Comparator<? super E> comparator()
  {
    return a;
  }
  
  public final hfp<E> d(E paramE, boolean paramBoolean)
  {
    return b(hbe.a(paramE), paramBoolean);
  }
  
  public E first()
  {
    return (E)a().next();
  }
  
  public E floor(E paramE)
  {
    return (E)hfu.b(c(paramE, true).c(), null);
  }
  
  public E higher(E paramE)
  {
    return (E)hft.b(d(paramE, false));
  }
  
  public E last()
  {
    return (E)c().next();
  }
  
  public E lower(E paramE)
  {
    return (E)hfu.b(c(paramE, false).c(), null);
  }
  
  @Deprecated
  public final E pollFirst()
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final E pollLast()
  {
    throw new UnsupportedOperationException();
  }
  
  Object writeReplace()
  {
    return new hfr(a, toArray());
  }
}

/* Location:
 * Qualified Name:     hfp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */