public final class gxa
  extends hlt
{
  public int a = 0;
  public int b = 0;
  public String[] c = hlw.f;
  public String[] d = hlw.f;
  
  public gxa()
  {
    E = -1;
  }
  
  protected final int a()
  {
    int i2 = 0;
    int j = super.a();
    int i = j;
    if ((a & 0x1) != 0) {
      i = j + hll.c(1, b);
    }
    j = i;
    int k;
    int m;
    String str;
    int i1;
    int n;
    if (c != null)
    {
      j = i;
      if (c.length > 0)
      {
        j = 0;
        k = 0;
        for (m = 0; j < c.length; m = n)
        {
          str = c[j];
          i1 = k;
          n = m;
          if (str != null)
          {
            n = m + 1;
            i1 = k + hll.a(str);
          }
          j += 1;
          k = i1;
        }
        j = i + k + m * 1;
      }
    }
    i = j;
    if (d != null)
    {
      i = j;
      if (d.length > 0)
      {
        k = 0;
        m = 0;
        i = i2;
        while (i < d.length)
        {
          str = d[i];
          i1 = k;
          n = m;
          if (str != null)
          {
            n = m + 1;
            i1 = k + hll.a(str);
          }
          i += 1;
          k = i1;
          m = n;
        }
        i = j + k + m * 1;
      }
    }
    return i;
  }
  
  public final void a(hll paramhll)
  {
    int j = 0;
    if ((a & 0x1) != 0) {
      paramhll.a(1, b);
    }
    int i;
    String str;
    if ((c != null) && (c.length > 0))
    {
      i = 0;
      while (i < c.length)
      {
        str = c[i];
        if (str != null) {
          paramhll.a(2, str);
        }
        i += 1;
      }
    }
    if ((d != null) && (d.length > 0))
    {
      i = j;
      while (i < d.length)
      {
        str = d[i];
        if (str != null) {
          paramhll.a(3, str);
        }
        i += 1;
      }
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gxa
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */