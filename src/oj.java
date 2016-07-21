public class oj<E>
  implements Cloneable
{
  public static final Object a = new Object();
  public int[] b;
  public Object[] c;
  public int d;
  private boolean e = false;
  
  public oj()
  {
    this(10);
  }
  
  public oj(int paramInt)
  {
    if (paramInt == 0) {
      b = nu.a;
    }
    for (c = nu.c;; c = new Object[paramInt])
    {
      d = 0;
      return;
      paramInt = nu.a(paramInt);
      b = new int[paramInt];
    }
  }
  
  private final oj<E> c()
  {
    try
    {
      oj localoj = (oj)super.clone();
      return localCloneNotSupportedException1;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException1)
    {
      try
      {
        b = ((int[])b.clone());
        c = ((Object[])c.clone());
        return localoj;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException2) {}
      localCloneNotSupportedException1 = localCloneNotSupportedException1;
      return null;
    }
  }
  
  private final void d()
  {
    int m = d;
    int[] arrayOfInt = b;
    Object[] arrayOfObject = c;
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
          arrayOfInt[j] = arrayOfInt[i];
          arrayOfObject[j] = localObject;
          arrayOfObject[i] = null;
        }
        k = j + 1;
      }
      i += 1;
    }
    e = false;
    d = j;
  }
  
  public final int a()
  {
    if (e) {
      d();
    }
    return d;
  }
  
  public final E a(int paramInt)
  {
    paramInt = nu.a(b, d, paramInt);
    if ((paramInt < 0) || (c[paramInt] == a)) {
      return null;
    }
    return (E)c[paramInt];
  }
  
  public void a(int paramInt, E paramE)
  {
    int i = nu.a(b, d, paramInt);
    if (i >= 0)
    {
      c[i] = paramE;
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    if ((j < d) && (c[j] == a))
    {
      b[j] = paramInt;
      c[j] = paramE;
      return;
    }
    i = j;
    if (e)
    {
      i = j;
      if (d >= b.length)
      {
        d();
        i = nu.a(b, d, paramInt) ^ 0xFFFFFFFF;
      }
    }
    if (d >= b.length)
    {
      j = nu.a(d + 1);
      int[] arrayOfInt = new int[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(b, 0, arrayOfInt, 0, b.length);
      System.arraycopy(c, 0, arrayOfObject, 0, c.length);
      b = arrayOfInt;
      c = arrayOfObject;
    }
    if (d - i != 0)
    {
      System.arraycopy(b, i, b, i + 1, d - i);
      System.arraycopy(c, i, c, i + 1, d - i);
    }
    b[i] = paramInt;
    c[i] = paramE;
    d += 1;
  }
  
  public void b()
  {
    int j = d;
    Object[] arrayOfObject = c;
    int i = 0;
    while (i < j)
    {
      arrayOfObject[i] = null;
      i += 1;
    }
    d = 0;
    e = false;
  }
  
  public void b(int paramInt)
  {
    paramInt = nu.a(b, d, paramInt);
    if ((paramInt >= 0) && (c[paramInt] != a))
    {
      c[paramInt] = a;
      e = true;
    }
  }
  
  public void c(int paramInt)
  {
    b(paramInt);
  }
  
  public void d(int paramInt)
  {
    if (c[paramInt] != a)
    {
      c[paramInt] = a;
      e = true;
    }
  }
  
  public final int e(int paramInt)
  {
    if (e) {
      d();
    }
    return b[paramInt];
  }
  
  public final E f(int paramInt)
  {
    if (e) {
      d();
    }
    return (E)c[paramInt];
  }
  
  public final int g(int paramInt)
  {
    if (e) {
      d();
    }
    return nu.a(b, d, paramInt);
  }
  
  public String toString()
  {
    if (a() <= 0) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder(d * 28);
    localStringBuilder.append('{');
    int i = 0;
    if (i < d)
    {
      if (i > 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append(e(i));
      localStringBuilder.append('=');
      Object localObject = f(i);
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
 * Qualified Name:     oj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */