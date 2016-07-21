public final class gzb
  extends hlt
{
  public int a = 0;
  public long b = 0L;
  public gzc[] c = gzc.b();
  public long d = 0L;
  public String[] e = hlw.f;
  private int f = 0;
  
  public gzb()
  {
    E = -1;
  }
  
  protected final int a()
  {
    int n = 0;
    int i = super.a();
    int j = i;
    if ((a & 0x1) != 0) {
      j = i + hll.c(1, f);
    }
    i = j;
    if ((a & 0x2) != 0) {
      i = j + hll.c(2, b);
    }
    j = i;
    Object localObject;
    int k;
    if (c != null)
    {
      j = i;
      if (c.length > 0)
      {
        j = 0;
        while (j < c.length)
        {
          localObject = c[j];
          k = i;
          if (localObject != null) {
            k = i + hll.c(3, (hlt)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if ((a & 0x4) != 0) {
      i = j + hll.c(4, d);
    }
    j = i;
    if (e != null)
    {
      j = i;
      if (e.length > 0)
      {
        k = 0;
        int m = 0;
        j = n;
        while (j < e.length)
        {
          localObject = e[j];
          int i1 = k;
          n = m;
          if (localObject != null)
          {
            n = m + 1;
            i1 = k + hll.a((String)localObject);
          }
          j += 1;
          k = i1;
          m = n;
        }
        j = i + k + m * 1;
      }
    }
    return j;
  }
  
  public final void a(hll paramhll)
  {
    int j = 0;
    if ((a & 0x1) != 0) {
      paramhll.a(1, f);
    }
    if ((a & 0x2) != 0) {
      paramhll.a(2, b);
    }
    int i;
    Object localObject;
    if ((c != null) && (c.length > 0))
    {
      i = 0;
      while (i < c.length)
      {
        localObject = c[i];
        if (localObject != null) {
          paramhll.a(3, (hlt)localObject);
        }
        i += 1;
      }
    }
    if ((a & 0x4) != 0) {
      paramhll.a(4, d);
    }
    if ((e != null) && (e.length > 0))
    {
      i = j;
      while (i < e.length)
      {
        localObject = e[i];
        if (localObject != null) {
          paramhll.a(5, (String)localObject);
        }
        i += 1;
      }
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */