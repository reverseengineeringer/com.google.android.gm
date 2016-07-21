final class fmn
  implements Cloneable
{
  private static final fmo a = new fmo();
  private boolean b = false;
  private int[] c;
  private fmo[] d;
  private int e;
  
  public fmn()
  {
    this(10);
  }
  
  private fmn(int paramInt)
  {
    paramInt = b(paramInt * 4) / 4;
    c = new int[paramInt];
    d = new fmo[paramInt];
    e = 0;
  }
  
  private static int b(int paramInt)
  {
    int i = 4;
    for (;;)
    {
      int j = paramInt;
      if (i < 32)
      {
        if (paramInt <= (1 << i) - 12) {
          j = (1 << i) - 12;
        }
      }
      else {
        return j;
      }
      i += 1;
    }
  }
  
  private final void d()
  {
    int m = e;
    int[] arrayOfInt = c;
    fmo[] arrayOffmo = d;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      fmo localfmo = arrayOffmo[i];
      k = j;
      if (localfmo != a)
      {
        if (i != j)
        {
          arrayOfInt[j] = arrayOfInt[i];
          arrayOffmo[j] = localfmo;
          arrayOffmo[i] = null;
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
  
  public final fmo a(int paramInt)
  {
    if (b) {
      d();
    }
    return d[paramInt];
  }
  
  public final boolean b()
  {
    return a() == 0;
  }
  
  public final fmn c()
  {
    int i = 0;
    int j = a();
    fmn localfmn = new fmn(j);
    System.arraycopy(c, 0, c, 0, j);
    while (i < j)
    {
      if (d[i] != null) {
        d[i] = d[i].b();
      }
      i += 1;
    }
    e = j;
    return localfmn;
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
      if (!(paramObject instanceof fmn)) {
        return false;
      }
      paramObject = (fmn)paramObject;
      if (a() != ((fmn)paramObject).a()) {
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
      d();
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
 * Qualified Name:     fmn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */