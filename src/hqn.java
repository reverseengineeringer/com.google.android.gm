public final class hqn
  extends hln<hqn>
{
  public int a = Integer.MIN_VALUE;
  public int b = Integer.MIN_VALUE;
  public Long c = null;
  public hrk[] d = hrk.b();
  public hrh[] e = hrh.b();
  
  public hqn()
  {
    E = -1;
  }
  
  protected final int a()
  {
    int m = 0;
    int j = super.a();
    int i = j;
    if (a != Integer.MIN_VALUE) {
      i = j + hll.c(1, a);
    }
    int k = i;
    if (b != Integer.MIN_VALUE) {
      k = i + hll.c(2, b);
    }
    j = k;
    if (c != null) {
      j = k + hll.c(3, c.longValue());
    }
    i = j;
    Object localObject;
    if (d != null)
    {
      i = j;
      if (d.length > 0)
      {
        i = j;
        j = 0;
        while (j < d.length)
        {
          localObject = d[j];
          k = i;
          if (localObject != null) {
            k = i + hll.d(4, (hlt)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    k = i;
    if (e != null)
    {
      k = i;
      if (e.length > 0)
      {
        j = m;
        for (;;)
        {
          k = i;
          if (j >= e.length) {
            break;
          }
          localObject = e[j];
          k = i;
          if (localObject != null) {
            k = i + hll.d(5, (hlt)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    return k;
  }
  
  public final void a(hll paramhll)
  {
    int j = 0;
    if (a != Integer.MIN_VALUE) {
      paramhll.a(1, a);
    }
    if (b != Integer.MIN_VALUE) {
      paramhll.a(2, b);
    }
    if (c != null) {
      paramhll.a(3, c.longValue());
    }
    int i;
    Object localObject;
    if ((d != null) && (d.length > 0))
    {
      i = 0;
      while (i < d.length)
      {
        localObject = d[i];
        if (localObject != null) {
          paramhll.b(4, (hlt)localObject);
        }
        i += 1;
      }
    }
    if ((e != null) && (e.length > 0))
    {
      i = j;
      while (i < e.length)
      {
        localObject = e[i];
        if (localObject != null) {
          paramhll.b(5, (hlt)localObject);
        }
        i += 1;
      }
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hqn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */