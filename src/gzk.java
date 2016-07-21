public final class gzk
  extends hlt
{
  public int a = 0;
  public gzl[] b = gzl.b();
  public gzm[] c = gzm.b();
  public long d = 0L;
  
  public gzk()
  {
    E = -1;
  }
  
  protected final int a()
  {
    int m = 0;
    int j = super.a();
    int i = j;
    Object localObject;
    int k;
    if (b != null)
    {
      i = j;
      if (b.length > 0)
      {
        i = j;
        j = 0;
        while (j < b.length)
        {
          localObject = b[j];
          k = i;
          if (localObject != null) {
            k = i + hll.c(1, (hlt)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    j = i;
    if (c != null)
    {
      j = i;
      if (c.length > 0)
      {
        k = m;
        for (;;)
        {
          j = i;
          if (k >= c.length) {
            break;
          }
          localObject = c[k];
          j = i;
          if (localObject != null) {
            j = i + hll.c(2, (hlt)localObject);
          }
          k += 1;
          i = j;
        }
      }
    }
    i = j;
    if ((a & 0x1) != 0) {
      i = j + hll.c(3, d);
    }
    return i;
  }
  
  public final void a(hll paramhll)
  {
    int j = 0;
    int i;
    Object localObject;
    if ((b != null) && (b.length > 0))
    {
      i = 0;
      while (i < b.length)
      {
        localObject = b[i];
        if (localObject != null) {
          paramhll.a(1, (hlt)localObject);
        }
        i += 1;
      }
    }
    if ((c != null) && (c.length > 0))
    {
      i = j;
      while (i < c.length)
      {
        localObject = c[i];
        if (localObject != null) {
          paramhll.a(2, (hlt)localObject);
        }
        i += 1;
      }
    }
    if ((a & 0x1) != 0) {
      paramhll.a(3, d);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gzk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */