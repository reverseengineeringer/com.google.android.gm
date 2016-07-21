public final class nx<E>
  implements Cloneable
{
  private static final Object a = new Object();
  private boolean b = false;
  private long[] c;
  private Object[] d;
  private int e;
  
  public nx()
  {
    this((byte)0);
  }
  
  private nx(byte paramByte)
  {
    paramByte = nu.b(10);
    c = new long[paramByte];
    d = new Object[paramByte];
    e = 0;
  }
  
  private final nx<E> c()
  {
    try
    {
      nx localnx = (nx)super.clone();
      return localCloneNotSupportedException1;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException1)
    {
      try
      {
        c = ((long[])c.clone());
        d = ((Object[])d.clone());
        return localnx;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException2) {}
      localCloneNotSupportedException1 = localCloneNotSupportedException1;
      return null;
    }
  }
  
  private final void d()
  {
    int m = e;
    long[] arrayOfLong = c;
    Object[] arrayOfObject = d;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      Object localObject = arrayOfObject[i];
      k = j;
      if (localObject != a)
      {
        if (i != j)
        {
          arrayOfLong[j] = arrayOfLong[i];
          arrayOfObject[j] = localObject;
          arrayOfObject[i] = null;
        }
        k = j + 1;
      }
      i += 1;
    }
    b = false;
    e = j;
  }
  
  public final int a()
  {
    if (b) {
      d();
    }
    return e;
  }
  
  public final E a(long paramLong, E paramE)
  {
    int i = nu.a(c, e, paramLong);
    if ((i < 0) || (d[i] == a)) {
      return paramE;
    }
    return (E)d[i];
  }
  
  public final void a(int paramInt)
  {
    if (d[paramInt] != a)
    {
      d[paramInt] = a;
      b = true;
    }
  }
  
  public final void a(long paramLong)
  {
    int i = nu.a(c, e, paramLong);
    if ((i >= 0) && (d[i] != a))
    {
      d[i] = a;
      b = true;
    }
  }
  
  public final int b(long paramLong)
  {
    if (b) {
      d();
    }
    return nu.a(c, e, paramLong);
  }
  
  public final long b(int paramInt)
  {
    if (b) {
      d();
    }
    return c[paramInt];
  }
  
  public final void b()
  {
    int j = e;
    Object[] arrayOfObject = d;
    int i = 0;
    while (i < j)
    {
      arrayOfObject[i] = null;
      i += 1;
    }
    e = 0;
    b = false;
  }
  
  public final void b(long paramLong, E paramE)
  {
    int i = nu.a(c, e, paramLong);
    if (i >= 0)
    {
      d[i] = paramE;
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    if ((j < e) && (d[j] == a))
    {
      c[j] = paramLong;
      d[j] = paramE;
      return;
    }
    i = j;
    if (b)
    {
      i = j;
      if (e >= c.length)
      {
        d();
        i = nu.a(c, e, paramLong) ^ 0xFFFFFFFF;
      }
    }
    if (e >= c.length)
    {
      j = nu.b(e + 1);
      long[] arrayOfLong = new long[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(c, 0, arrayOfLong, 0, c.length);
      System.arraycopy(d, 0, arrayOfObject, 0, d.length);
      c = arrayOfLong;
      d = arrayOfObject;
    }
    if (e - i != 0)
    {
      System.arraycopy(c, i, c, i + 1, e - i);
      System.arraycopy(d, i, d, i + 1, e - i);
    }
    c[i] = paramLong;
    d[i] = paramE;
    e += 1;
  }
  
  public final E c(int paramInt)
  {
    if (b) {
      d();
    }
    return (E)d[paramInt];
  }
  
  public final String toString()
  {
    if (a() <= 0) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder(e * 28);
    localStringBuilder.append('{');
    int i = 0;
    if (i < e)
    {
      if (i > 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append(b(i));
      localStringBuilder.append('=');
      Object localObject = c(i);
      if (localObject != this) {
        localStringBuilder.append(localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append("(this Map)");
      }
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     nx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */