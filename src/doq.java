public final class doq
  extends hlt
{
  private static volatile doq[] q;
  public int a = 0;
  public int b = 1;
  public int c = 1;
  public long d = 0L;
  public long e = 0L;
  public long f = 0L;
  public int g = 0;
  public long h = 0L;
  public int i = 0;
  public int[] j = hlw.a;
  public long k = 0L;
  public int l = 0;
  public int[] m = hlw.a;
  public int n = 0;
  public long o = 0L;
  public long p = 0L;
  private int r = 0;
  
  public doq()
  {
    E = -1;
  }
  
  public static doq[] b()
  {
    if (q == null) {}
    synchronized (hlr.c)
    {
      if (q == null) {
        q = new doq[0];
      }
      return q;
    }
  }
  
  protected final int a()
  {
    int i4 = 0;
    int i2 = super.a();
    int i1 = i2;
    if ((a & 0x1) != 0) {
      i1 = i2 + hll.c(1, b);
    }
    i2 = i1;
    if ((a & 0x2) != 0) {
      i2 = i1 + hll.c(2, c);
    }
    i1 = i2;
    if ((a & 0x4) != 0) {
      i1 = i2 + hll.c(3, d);
    }
    i2 = i1;
    if ((a & 0x8) != 0) {
      i2 = i1 + hll.c(4, e);
    }
    i1 = i2;
    if ((a & 0x10) != 0) {
      i1 = i2 + hll.c(5, f);
    }
    i2 = i1;
    if ((a & 0x20) != 0) {
      i2 = i1 + hll.c(6, g);
    }
    i1 = i2;
    if ((a & 0x40) != 0) {
      i1 = i2 + hll.c(7, h);
    }
    i2 = i1;
    if ((a & 0x80) != 0) {
      i2 = i1 + hll.c(8, r);
    }
    i1 = i2;
    if ((a & 0x100) != 0) {
      i1 = i2 + hll.c(9, i);
    }
    i2 = i1;
    if (j != null)
    {
      i2 = i1;
      if (j.length > 0)
      {
        i2 = 0;
        i3 = 0;
        while (i2 < j.length)
        {
          i3 += hll.a(j[i2]);
          i2 += 1;
        }
        i2 = i1 + i3 + j.length * 1;
      }
    }
    int i3 = i2;
    if ((a & 0x200) != 0) {
      i3 = i2 + hll.c(11, k);
    }
    i1 = i3;
    if ((a & 0x400) != 0) {
      i1 = i3 + hll.c(12, l);
    }
    i2 = i1;
    if (m != null)
    {
      i2 = i1;
      if (m.length > 0)
      {
        i3 = 0;
        i2 = i4;
        while (i2 < m.length)
        {
          i3 += hll.a(m[i2]);
          i2 += 1;
        }
        i2 = i1 + i3 + m.length * 1;
      }
    }
    i1 = i2;
    if ((a & 0x800) != 0) {
      i1 = i2 + hll.c(14, n);
    }
    i2 = i1;
    if ((a & 0x1000) != 0) {
      i2 = i1 + hll.c(15, o);
    }
    i1 = i2;
    if ((a & 0x2000) != 0) {
      i1 = i2 + hll.c(16, p);
    }
    return i1;
  }
  
  public final void a(hll paramhll)
  {
    int i2 = 0;
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
    if ((a & 0x20) != 0) {
      paramhll.a(6, g);
    }
    if ((a & 0x40) != 0) {
      paramhll.a(7, h);
    }
    if ((a & 0x80) != 0) {
      paramhll.a(8, r);
    }
    if ((a & 0x100) != 0) {
      paramhll.a(9, i);
    }
    int i1;
    if ((j != null) && (j.length > 0))
    {
      i1 = 0;
      while (i1 < j.length)
      {
        paramhll.a(10, j[i1]);
        i1 += 1;
      }
    }
    if ((a & 0x200) != 0) {
      paramhll.a(11, k);
    }
    if ((a & 0x400) != 0) {
      paramhll.a(12, l);
    }
    if ((m != null) && (m.length > 0))
    {
      i1 = i2;
      while (i1 < m.length)
      {
        paramhll.a(13, m[i1]);
        i1 += 1;
      }
    }
    if ((a & 0x800) != 0) {
      paramhll.a(14, n);
    }
    if ((a & 0x1000) != 0) {
      paramhll.a(15, o);
    }
    if ((a & 0x2000) != 0) {
      paramhll.a(16, p);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     doq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */