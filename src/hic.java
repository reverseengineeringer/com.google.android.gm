class hic<E>
  extends hds<E>
{
  private final hdx<E> a;
  private final hef<? extends E> b;
  
  hic(hdx<E> paramhdx, hef<? extends E> paramhef)
  {
    a = paramhdx;
    b = paramhef;
  }
  
  hic(hdx<E> paramhdx, Object[] paramArrayOfObject)
  {
    this(paramhdx, hef.b(paramArrayOfObject, paramArrayOfObject.length));
  }
  
  final int a(Object[] paramArrayOfObject, int paramInt)
  {
    return b.a(paramArrayOfObject, paramInt);
  }
  
  public final hjj<E> a(int paramInt)
  {
    return b.a(paramInt);
  }
  
  hdx<E> b()
  {
    return a;
  }
  
  public E get(int paramInt)
  {
    return (E)b.get(paramInt);
  }
}

/* Location:
 * Qualified Name:     hic
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */