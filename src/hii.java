public final class hii<E>
  extends hef<E>
{
  public static final hef<Object> a = new hii(hhz.a);
  private final transient int b;
  private final transient int c;
  private final transient Object[] d;
  
  hii(Object[] paramArrayOfObject)
  {
    this(paramArrayOfObject, 0, paramArrayOfObject.length);
  }
  
  private hii(Object[] paramArrayOfObject, int paramInt1, int paramInt2)
  {
    b = paramInt1;
    c = paramInt2;
    d = paramArrayOfObject;
  }
  
  final int a(Object[] paramArrayOfObject, int paramInt)
  {
    System.arraycopy(d, b, paramArrayOfObject, paramInt, c);
    return c + paramInt;
  }
  
  public final hjj<E> a(int paramInt)
  {
    return hfu.a(d, b, c, paramInt);
  }
  
  final hef<E> b(int paramInt1, int paramInt2)
  {
    return new hii(d, b + paramInt1, paramInt2 - paramInt1);
  }
  
  final boolean e()
  {
    return c != d.length;
  }
  
  public final E get(int paramInt)
  {
    hbe.a(paramInt, c);
    return (E)d[(b + paramInt)];
  }
  
  public final int size()
  {
    return c;
  }
}

/* Location:
 * Qualified Name:     hii
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */