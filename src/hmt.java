public final class hmt
  extends hln<hmt>
{
  public hoc a = null;
  public hmw[] b = hmw.b();
  public hmv[] c = hmv.b();
  public hmx[] d = hmx.b();
  public hmu[] e = hmu.b();
  
  public hmt()
  {
    q = null;
    E = -1;
  }
  
  protected final int a()
  {
    int m = 0;
    int j = super.a();
    int i = j;
    if (a != null) {
      i = j + hll.d(1, a);
    }
    j = i;
    Object localObject;
    if (b != null)
    {
      j = i;
      if (b.length > 0)
      {
        j = 0;
        while (j < b.length)
        {
          localObject = b[j];
          k = i;
          if (localObject != null) {
            k = i + hll.d(2, (hlt)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    int k = j;
    if (c != null)
    {
      k = j;
      if (c.length > 0)
      {
        i = j;
        j = 0;
        while (j < c.length)
        {
          localObject = c[j];
          k = i;
          if (localObject != null) {
            k = i + hll.d(3, (hlt)localObject);
          }
          j += 1;
          i = k;
        }
        k = i;
      }
    }
    i = k;
    if (d != null)
    {
      i = k;
      if (d.length > 0)
      {
        i = k;
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
    if (a != null) {
      paramhll.b(1, a);
    }
    int i;
    Object localObject;
    if ((b != null) && (b.length > 0))
    {
      i = 0;
      while (i < b.length)
      {
        localObject = b[i];
        if (localObject != null) {
          paramhll.b(2, (hlt)localObject);
        }
        i += 1;
      }
    }
    if ((c != null) && (c.length > 0))
    {
      i = 0;
      while (i < c.length)
      {
        localObject = c[i];
        if (localObject != null) {
          paramhll.b(3, (hlt)localObject);
        }
        i += 1;
      }
    }
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
 * Qualified Name:     hmt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */