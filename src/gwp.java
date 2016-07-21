public final class gwp
  extends hlt
{
  public int a = 0;
  public long b = 0L;
  public long c = 0L;
  public long d = 0L;
  public String e = "";
  public String f = "";
  public int g = 0;
  public long h = 0L;
  public int i = 0;
  public boolean j = false;
  public gzn k = null;
  public int[] l = hlw.a;
  public int[] m = hlw.a;
  public boolean n = false;
  
  public gwp()
  {
    E = -1;
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
      i2 = i1 + hll.b(4, e);
    }
    i1 = i2;
    if ((a & 0x10) != 0) {
      i1 = i2 + hll.b(5, f);
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
      i2 = i1 + hll.c(8, i);
    }
    int i3 = i2;
    if ((a & 0x100) != 0) {
      i3 = i2 + (hll.b(9) + 1);
    }
    i1 = i3;
    if (k != null) {
      i1 = i3 + hll.d(10, k);
    }
    i2 = i1;
    if (l != null)
    {
      i2 = i1;
      if (l.length > 0)
      {
        i2 = 0;
        i3 = 0;
        while (i2 < l.length)
        {
          i3 += hll.a(l[i2]);
          i2 += 1;
        }
        i2 = i1 + i3 + l.length * 1;
      }
    }
    i1 = i2;
    if (m != null)
    {
      i1 = i2;
      if (m.length > 0)
      {
        i3 = 0;
        i1 = i4;
        while (i1 < m.length)
        {
          i3 += hll.a(m[i1]);
          i1 += 1;
        }
        i1 = i2 + i3 + m.length * 1;
      }
    }
    i2 = i1;
    if ((a & 0x200) != 0) {
      i2 = i1 + (hll.b(13) + 1);
    }
    return i2;
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
      paramhll.a(8, i);
    }
    if ((a & 0x100) != 0) {
      paramhll.a(9, j);
    }
    if (k != null) {
      paramhll.b(10, k);
    }
    int i1;
    if ((l != null) && (l.length > 0))
    {
      i1 = 0;
      while (i1 < l.length)
      {
        paramhll.a(11, l[i1]);
        i1 += 1;
      }
    }
    if ((m != null) && (m.length > 0))
    {
      i1 = i2;
      while (i1 < m.length)
      {
        paramhll.a(12, m[i1]);
        i1 += 1;
      }
    }
    if ((a & 0x200) != 0) {
      paramhll.a(13, n);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gwp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */