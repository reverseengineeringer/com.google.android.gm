final class hei<E>
  extends hef<E>
{
  private final transient hef<E> a;
  
  hei(hef<E> paramhef)
  {
    a = paramhef;
  }
  
  private final int b(int paramInt)
  {
    return size() - 1 - paramInt;
  }
  
  public final hef<E> a(int paramInt1, int paramInt2)
  {
    hbe.a(paramInt1, paramInt2, size());
    return a.a(size() - paramInt2, size() - paramInt1).c();
  }
  
  public final hef<E> c()
  {
    return a;
  }
  
  public final boolean contains(Object paramObject)
  {
    return a.contains(paramObject);
  }
  
  final boolean e()
  {
    return a.e();
  }
  
  public final E get(int paramInt)
  {
    hbe.a(paramInt, size());
    return (E)a.get(b(paramInt));
  }
  
  public final int indexOf(Object paramObject)
  {
    int i = a.lastIndexOf(paramObject);
    if (i >= 0) {
      return b(i);
    }
    return -1;
  }
  
  public final int lastIndexOf(Object paramObject)
  {
    int i = a.indexOf(paramObject);
    if (i >= 0) {
      return b(i);
    }
    return -1;
  }
  
  public final int size()
  {
    return a.size();
  }
}

/* Location:
 * Qualified Name:     hei
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */