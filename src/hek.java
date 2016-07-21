final class hek
  extends hef<E>
{
  final transient int a;
  final transient int b;
  
  hek(hef paramhef, int paramInt1, int paramInt2)
  {
    a = paramInt1;
    b = paramInt2;
  }
  
  public final hef<E> a(int paramInt1, int paramInt2)
  {
    hbe.a(paramInt1, paramInt2, b);
    return c.a(a + paramInt1, a + paramInt2);
  }
  
  final boolean e()
  {
    return true;
  }
  
  public final E get(int paramInt)
  {
    hbe.a(paramInt, b);
    return (E)c.get(a + paramInt);
  }
  
  public final int size()
  {
    return b;
  }
}

/* Location:
 * Qualified Name:     hek
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */