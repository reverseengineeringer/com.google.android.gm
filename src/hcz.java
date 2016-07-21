final class hcz<E>
  extends hfp<E>
{
  private final hfp<E> c;
  
  hcz(hfp<E> paramhfp)
  {
    super(hia.a(paramhfp.comparator()).a());
    c = paramhfp;
  }
  
  final hfp<E> H_()
  {
    throw new AssertionError("should never be called");
  }
  
  final int a(Object paramObject)
  {
    int i = c.a(paramObject);
    if (i == -1) {
      return i;
    }
    return size() - 1 - i;
  }
  
  final hfp<E> a(E paramE, boolean paramBoolean)
  {
    return c.d(paramE, paramBoolean).b();
  }
  
  final hfp<E> a(E paramE1, boolean paramBoolean1, E paramE2, boolean paramBoolean2)
  {
    return c.b(paramE2, paramBoolean2, paramE1, paramBoolean1).b();
  }
  
  public final hji<E> a()
  {
    return c.c();
  }
  
  public final hfp<E> b()
  {
    return c;
  }
  
  final hfp<E> b(E paramE, boolean paramBoolean)
  {
    return c.c(paramE, paramBoolean).b();
  }
  
  public final hji<E> c()
  {
    return c.a();
  }
  
  public final E ceiling(E paramE)
  {
    return (E)c.floor(paramE);
  }
  
  public final boolean contains(Object paramObject)
  {
    return c.contains(paramObject);
  }
  
  final boolean e()
  {
    return c.e();
  }
  
  public final E floor(E paramE)
  {
    return (E)c.ceiling(paramE);
  }
  
  public final E higher(E paramE)
  {
    return (E)c.lower(paramE);
  }
  
  public final E lower(E paramE)
  {
    return (E)c.higher(paramE);
  }
  
  public final int size()
  {
    return c.size();
  }
}

/* Location:
 * Qualified Name:     hcz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */