final class hir<E>
  extends hef<E>
{
  final transient E a;
  
  hir(E paramE)
  {
    a = hbe.a(paramE);
  }
  
  public final hef<E> a(int paramInt1, int paramInt2)
  {
    hbe.a(paramInt1, paramInt2, 1);
    Object localObject = this;
    if (paramInt1 == paramInt2) {
      localObject = hii.a;
    }
    return (hef<E>)localObject;
  }
  
  public final hji<E> a()
  {
    return hfu.a(a);
  }
  
  final boolean e()
  {
    return false;
  }
  
  public final E get(int paramInt)
  {
    hbe.a(paramInt, 1);
    return (E)a;
  }
  
  public final int size()
  {
    return 1;
  }
  
  public final String toString()
  {
    String str = a.toString();
    return str.length() + 2 + '[' + str + ']';
  }
}

/* Location:
 * Qualified Name:     hir
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */