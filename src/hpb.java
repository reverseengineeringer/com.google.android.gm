public final class hpb
  extends hln<hpb>
{
  public hoc a = null;
  public hpa[] b = hpa.b();
  public hpc[] c = hpc.b();
  private int d = 0;
  private String e = "";
  
  public hpb()
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
    if ((d & 0x1) != 0) {
      j = i + hll.b(2, e);
    }
    i = j;
    Object localObject;
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
            k = i + hll.d(3, (hlt)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    int k = i;
    if (c != null)
    {
      k = i;
      if (c.length > 0)
      {
        j = m;
        for (;;)
        {
          k = i;
          if (j >= c.length) {
            break;
          }
          localObject = c[j];
          k = i;
          if (localObject != null) {
            k = i + hll.d(4, (hlt)localObject);
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
    if ((d & 0x1) != 0) {
      paramhll.a(2, e);
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
      i = j;
      while (i < c.length)
      {
        localObject = c[i];
        if (localObject != null) {
          paramhll.b(4, (hlt)localObject);
        }
        i += 1;
      }
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hpb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */