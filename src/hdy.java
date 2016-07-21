import java.util.Collection;

class hdy<E>
  extends hdz<E>
{
  Object[] a;
  int b;
  
  hdy(int paramInt)
  {
    hcw.a(4, "initialCapacity");
    a = new Object[4];
    b = 0;
  }
  
  private final void a(int paramInt)
  {
    if (a.length < paramInt) {
      a = hhz.a(a, a(a.length, paramInt));
    }
  }
  
  public hdy<E> a(E paramE)
  {
    hbe.a(paramE);
    a(b + 1);
    Object[] arrayOfObject = a;
    int i = b;
    b = (i + 1);
    arrayOfObject[i] = paramE;
    return this;
  }
  
  public hdz<E> a(Iterable<? extends E> paramIterable)
  {
    if ((paramIterable instanceof Collection))
    {
      Collection localCollection = (Collection)paramIterable;
      int i = b;
      a(localCollection.size() + i);
    }
    super.a(paramIterable);
    return this;
  }
  
  public hdz<E> a(E... paramVarArgs)
  {
    hhz.b(paramVarArgs, paramVarArgs.length);
    a(b + paramVarArgs.length);
    System.arraycopy(paramVarArgs, 0, a, b, paramVarArgs.length);
    b += paramVarArgs.length;
    return this;
  }
}

/* Location:
 * Qualified Name:     hdy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */