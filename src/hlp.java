public final class hlp
  implements Cloneable
{
  static final hlq a = new hlq();
  boolean b = false;
  int[] c;
  hlq[] d;
  int e;
  
  hlp()
  {
    this(10);
  }
  
  private hlp(int paramInt)
  {
    paramInt = b(paramInt);
    c = new int[paramInt];
    d = new hlq[paramInt];
    e = 0;
  }
  
  static int b(int paramInt)
  {
    int j = paramInt * 4;
    paramInt = 4;
    for (;;)
    {
      int i = j;
      if (paramInt < 32)
      {
        if (j <= (1 << paramInt) - 12) {
          i = (1 << paramInt) - 12;
        }
      }
      else {
        return i / 4;
      }
      paramInt += 1;
    }
  }
  
  final hlq a(int paramInt)
  {
    if (b) {
      a();
    }
    return d[paramInt];
  }
  
  final void a()
  {
    int m = e;
    int[] arrayOfInt = c;
    hlq[] arrayOfhlq = d;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      hlq localhlq = arrayOfhlq[i];
      k = j;
      if (localhlq != a)
      {
        if (i != j)
        {
          arrayOfInt[j] = arrayOfInt[i];
          arrayOfhlq[j] = localhlq;
          arrayOfhlq[i] = null;
        }
        k = j + 1;
      }
      i += 1;
    }
    b = false;
    e = j;
  }
  
  final int b()
  {
    if (b) {
      a();
    }
    return e;
  }
  
  final int c(int paramInt)
  {
    int j = e;
    int i = 0;
    j -= 1;
    while (i <= j)
    {
      int k = i + j >>> 1;
      int m = c[k];
      if (m < paramInt)
      {
        i = k + 1;
      }
      else
      {
        j = k;
        if (m <= paramInt) {
          return j;
        }
        j = k - 1;
      }
    }
    j = i ^ 0xFFFFFFFF;
    return j;
  }
  
  public final hlp c()
  {
    int i = 0;
    int j = b();
    hlp localhlp = new hlp(j);
    System.arraycopy(c, 0, c, 0, j);
    while (i < j)
    {
      if (d[i] != null) {
        d[i] = d[i].b();
      }
      i += 1;
    }
    e = j;
    return localhlp;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    label71:
    label93:
    label131:
    label138:
    label141:
    for (;;)
    {
      return true;
      if (!(paramObject instanceof hlp)) {
        return false;
      }
      paramObject = (hlp)paramObject;
      if (b() != ((hlp)paramObject).b()) {
        return false;
      }
      Object localObject = c;
      int[] arrayOfInt = c;
      int j = e;
      int i = 0;
      if (i < j) {
        if (localObject[i] != arrayOfInt[i])
        {
          i = 0;
          if (i != 0)
          {
            localObject = d;
            paramObject = d;
            j = e;
            i = 0;
            if (i >= j) {
              break label138;
            }
            if (localObject[i].equals(paramObject[i])) {
              break label131;
            }
          }
        }
      }
      for (i = 0;; i = 1)
      {
        if (i != 0) {
          break label141;
        }
        return false;
        i += 1;
        break;
        i = 1;
        break label71;
        i += 1;
        break label93;
      }
    }
  }
  
  public final int hashCode()
  {
    if (b) {
      a();
    }
    int j = 17;
    int i = 0;
    while (i < e)
    {
      j = (j * 31 + c[i]) * 31 + d[i].hashCode();
      i += 1;
    }
    return j;
  }
}

/* Location:
 * Qualified Name:     hlp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */