final class his<E>
  extends hfd<E>
{
  final transient E a;
  private transient int b;
  
  his(E paramE)
  {
    a = hbe.a(paramE);
  }
  
  his(E paramE, int paramInt)
  {
    a = paramE;
    b = paramInt;
  }
  
  final boolean I_()
  {
    return b != 0;
  }
  
  final int a(Object[] paramArrayOfObject, int paramInt)
  {
    paramArrayOfObject[paramInt] = a;
    return paramInt + 1;
  }
  
  public final hji<E> a()
  {
    return hfu.a(a);
  }
  
  public final boolean contains(Object paramObject)
  {
    return a.equals(paramObject);
  }
  
  final hef<E> d()
  {
    return hef.a(a);
  }
  
  final boolean e()
  {
    return false;
  }
  
  public final int hashCode()
  {
    int j = b;
    int i = j;
    if (j == 0)
    {
      i = a.hashCode();
      b = i;
    }
    return i;
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
 * Qualified Name:     his
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */