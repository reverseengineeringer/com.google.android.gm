public final class how
  extends hln<how>
{
  public hoc a = null;
  public hov[] b = hov.b();
  public hox[] c = hox.b();
  public hox[] d = hox.b();
  public hox[] e = hox.b();
  private int f = 0;
  private String g = "";
  
  public how()
  {
    q = null;
    E = -1;
  }
  
  protected final int a()
  {
    int m = 0;
    int i = super.a();
    int j = i;
    if (a != null) {
      j = i + hll.d(1, a);
    }
    i = j;
    if ((f & 0x1) != 0) {
      i = j + hll.b(2, g);
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
            k = i + hll.d(3, (hlt)localObject);
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
            k = i + hll.d(4, (hlt)localObject);
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
            k = i + hll.d(5, (hlt)localObject);
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
            k = i + hll.d(6, (hlt)localObject);
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
    if ((f & 0x1) != 0) {
      paramhll.a(2, g);
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
          paramhll.b(3, (hlt)localObject);
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
          paramhll.b(4, (hlt)localObject);
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
          paramhll.b(5, (hlt)localObject);
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
          paramhll.b(6, (hlt)localObject);
        }
        i += 1;
      }
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     how
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */