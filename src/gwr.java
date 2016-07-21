public final class gwr
  extends hlt
{
  public int a = 0;
  public String b = "";
  public long c = 0L;
  public long d = 0L;
  public boolean e = false;
  public String f = "";
  public gwq g = null;
  public gwq[] h = gwq.b();
  public int i = 0;
  public String j = "";
  public String k = "";
  public gwq l = null;
  public int m = 0;
  
  public gwr()
  {
    E = -1;
  }
  
  protected final int a()
  {
    int i1 = super.a();
    int n = i1;
    if ((a & 0x1) != 0) {
      n = i1 + hll.b(1, b);
    }
    i1 = n;
    if ((a & 0x2) != 0) {
      i1 = n + hll.c(2, c);
    }
    n = i1;
    if ((a & 0x4) != 0) {
      n = i1 + hll.c(3, d);
    }
    i1 = n;
    if ((a & 0x8) != 0) {
      i1 = n + (hll.b(4) + 1);
    }
    int i2 = i1;
    if ((a & 0x10) != 0) {
      i2 = i1 + hll.b(5, f);
    }
    n = i2;
    if (g != null) {
      n = i2 + hll.d(6, g);
    }
    i1 = n;
    if (h != null)
    {
      i1 = n;
      if (h.length > 0)
      {
        i1 = 0;
        while (i1 < h.length)
        {
          gwq localgwq = h[i1];
          i2 = n;
          if (localgwq != null) {
            i2 = n + hll.d(7, localgwq);
          }
          i1 += 1;
          n = i2;
        }
        i1 = n;
      }
    }
    n = i1;
    if ((a & 0x20) != 0) {
      n = i1 + hll.c(8, i);
    }
    i1 = n;
    if ((a & 0x40) != 0) {
      i1 = n + hll.b(9, j);
    }
    n = i1;
    if ((a & 0x80) != 0) {
      n = i1 + hll.b(10, k);
    }
    i1 = n;
    if (l != null) {
      i1 = n + hll.d(11, l);
    }
    n = i1;
    if ((a & 0x100) != 0) {
      n = i1 + hll.c(12, m);
    }
    return n;
  }
  
  public final void a(hll paramhll)
  {
    if ((a & 0x1) != 0) {
      paramhll.a(1, b);
    }
    if ((a & 0x2) != 0) {
      paramhll.a(2, c);
    }
    if ((a & 0x4) != 0) {
      paramhll.a(3, d);
    }
    if ((a & 0x8) != 0) {
      paramhll.a(4, e);
    }
    if ((a & 0x10) != 0) {
      paramhll.a(5, f);
    }
    if (g != null) {
      paramhll.b(6, g);
    }
    if ((h != null) && (h.length > 0))
    {
      int n = 0;
      while (n < h.length)
      {
        gwq localgwq = h[n];
        if (localgwq != null) {
          paramhll.b(7, localgwq);
        }
        n += 1;
      }
    }
    if ((a & 0x20) != 0) {
      paramhll.a(8, i);
    }
    if ((a & 0x40) != 0) {
      paramhll.a(9, j);
    }
    if ((a & 0x80) != 0) {
      paramhll.a(10, k);
    }
    if (l != null) {
      paramhll.b(11, l);
    }
    if ((a & 0x100) != 0) {
      paramhll.a(12, m);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gwr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */