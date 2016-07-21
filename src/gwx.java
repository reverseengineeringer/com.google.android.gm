public final class gwx
  extends hlt
{
  public gwz[] a = gwz.b();
  public gwy[] b = gwy.b();
  private int c = 0;
  private long d = 0L;
  private String e = "";
  
  public gwx()
  {
    E = -1;
  }
  
  protected final int a()
  {
    int m = 0;
    int j = super.a();
    int i = j;
    if ((c & 0x1) != 0) {
      i = j + (hll.b(1) + 8);
    }
    j = i;
    if ((c & 0x2) != 0) {
      j = i + hll.b(2, e);
    }
    i = j;
    Object localObject;
    if (a != null)
    {
      i = j;
      if (a.length > 0)
      {
        i = j;
        j = 0;
        while (j < a.length)
        {
          localObject = a[j];
          k = i;
          if (localObject != null) {
            k = i + hll.c(3, (hlt)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    int k = i;
    if (b != null)
    {
      k = i;
      if (b.length > 0)
      {
        j = m;
        for (;;)
        {
          k = i;
          if (j >= b.length) {
            break;
          }
          localObject = b[j];
          k = i;
          if (localObject != null) {
            k = i + hll.c(4, (hlt)localObject);
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
    if ((c & 0x1) != 0) {
      paramhll.b(1, d);
    }
    if ((c & 0x2) != 0) {
      paramhll.a(2, e);
    }
    int i;
    Object localObject;
    if ((a != null) && (a.length > 0))
    {
      i = 0;
      while (i < a.length)
      {
        localObject = a[i];
        if (localObject != null) {
          paramhll.a(3, (hlt)localObject);
        }
        i += 1;
      }
    }
    if ((b != null) && (b.length > 0))
    {
      i = j;
      while (i < b.length)
      {
        localObject = b[i];
        if (localObject != null) {
          paramhll.a(4, (hlt)localObject);
        }
        i += 1;
      }
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gwx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */