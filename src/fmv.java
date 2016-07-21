public final class fmv
  extends fml<fmv>
{
  public String[] a = fmt.f;
  public String[] b = fmt.f;
  public int[] c = fmt.a;
  public long[] d = fmt.b;
  
  public fmv()
  {
    f = null;
    g = -1;
  }
  
  protected final int a()
  {
    int i2 = 0;
    int i1 = super.a();
    int j;
    int k;
    String str;
    int n;
    int m;
    if ((a != null) && (a.length > 0))
    {
      i = 0;
      j = 0;
      for (k = 0; i < a.length; k = m)
      {
        str = a[i];
        n = j;
        m = k;
        if (str != null)
        {
          m = k + 1;
          n = j + fmj.a(str);
        }
        i += 1;
        j = n;
      }
    }
    for (int i = i1 + j + k * 1;; i = i1)
    {
      j = i;
      if (b != null)
      {
        j = i;
        if (b.length > 0)
        {
          j = 0;
          k = 0;
          for (m = 0; j < b.length; m = n)
          {
            str = b[j];
            i1 = k;
            n = m;
            if (str != null)
            {
              n = m + 1;
              i1 = k + fmj.a(str);
            }
            j += 1;
            k = i1;
          }
          j = i + k + m * 1;
        }
      }
      i = j;
      if (c != null)
      {
        i = j;
        if (c.length > 0)
        {
          i = 0;
          k = 0;
          while (i < c.length)
          {
            k += fmj.a(c[i]);
            i += 1;
          }
          i = j + k + c.length * 1;
        }
      }
      j = i;
      if (d != null)
      {
        j = i;
        if (d.length > 0)
        {
          k = 0;
          j = i2;
          while (j < d.length)
          {
            k += fmj.a(d[j]);
            j += 1;
          }
          j = i + k + d.length * 1;
        }
      }
      return j;
    }
  }
  
  public final void a(fmj paramfmj)
  {
    int j = 0;
    int i;
    String str;
    if ((a != null) && (a.length > 0))
    {
      i = 0;
      while (i < a.length)
      {
        str = a[i];
        if (str != null) {
          paramfmj.a(1, str);
        }
        i += 1;
      }
    }
    if ((b != null) && (b.length > 0))
    {
      i = 0;
      while (i < b.length)
      {
        str = b[i];
        if (str != null) {
          paramfmj.a(2, str);
        }
        i += 1;
      }
    }
    if ((c != null) && (c.length > 0))
    {
      i = 0;
      while (i < c.length)
      {
        paramfmj.a(3, c[i]);
        i += 1;
      }
    }
    if ((d != null) && (d.length > 0))
    {
      i = j;
      while (i < d.length)
      {
        paramfmj.a(4, d[i]);
        i += 1;
      }
    }
    super.a(paramfmj);
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return bool1;
              bool1 = bool2;
            } while (!(paramObject instanceof fmv));
            paramObject = (fmv)paramObject;
            bool1 = bool2;
          } while (!fmp.a(a, a));
          bool1 = bool2;
        } while (!fmp.a(b, b));
        bool1 = bool2;
      } while (!fmp.a(c, c));
      bool1 = bool2;
    } while (!fmp.a(d, d));
    return a((fml)paramObject);
  }
  
  public final int hashCode()
  {
    return ((((fmp.a(a) + 527) * 31 + fmp.a(b)) * 31 + fmp.a(c)) * 31 + fmp.a(d)) * 31 + b();
  }
}

/* Location:
 * Qualified Name:     fmv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */