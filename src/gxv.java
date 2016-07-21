public final class gxv
  extends hlt
{
  public int a = 0;
  public long b = 0L;
  public int c = 0;
  public gxw[] d = gxw.b();
  public int e = 0;
  public int f = 0;
  
  public gxv()
  {
    E = -1;
  }
  
  protected final int a()
  {
    int i = super.a();
    int j = i;
    if ((a & 0x1) != 0) {
      j = i + hll.c(1, b);
    }
    i = j;
    if ((a & 0x2) != 0) {
      i = j + hll.c(2, c);
    }
    j = i;
    if (d != null)
    {
      j = i;
      if (d.length > 0)
      {
        j = 0;
        while (j < d.length)
        {
          gxw localgxw = d[j];
          int k = i;
          if (localgxw != null) {
            k = i + hll.c(3, localgxw);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if ((a & 0x4) != 0) {
      i = j + hll.c(4, e);
    }
    j = i;
    if ((a & 0x8) != 0) {
      j = i + hll.c(5, f);
    }
    return j;
  }
  
  public final void a(hll paramhll)
  {
    if ((a & 0x1) != 0) {
      paramhll.a(1, b);
    }
    if ((a & 0x2) != 0) {
      paramhll.a(2, c);
    }
    if ((d != null) && (d.length > 0))
    {
      int i = 0;
      while (i < d.length)
      {
        gxw localgxw = d[i];
        if (localgxw != null) {
          paramhll.a(3, localgxw);
        }
        i += 1;
      }
    }
    if ((a & 0x4) != 0) {
      paramhll.a(4, e);
    }
    if ((a & 0x8) != 0) {
      paramhll.a(5, f);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gxv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */