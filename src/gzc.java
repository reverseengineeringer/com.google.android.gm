public final class gzc
  extends hlt
{
  private static volatile gzc[] r;
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
  public String m = "";
  public String[] n = hlw.f;
  public int[] o = hlw.a;
  public String p = "";
  public boolean q = false;
  
  public gzc()
  {
    E = -1;
  }
  
  public static gzc[] b()
  {
    if (r == null) {}
    synchronized (hlr.c)
    {
      if (r == null) {
        r = new gzc[0];
      }
      return r;
    }
  }
  
  protected final int a()
  {
    int i7 = 0;
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
    if ((a & 0x200) != 0) {
      i1 = i2 + hll.b(12, m);
    }
    i2 = i1;
    if (n != null)
    {
      i2 = i1;
      if (n.length > 0)
      {
        i2 = 0;
        i3 = 0;
        int i5;
        for (int i4 = 0; i2 < n.length; i4 = i5)
        {
          String str = n[i2];
          int i6 = i3;
          i5 = i4;
          if (str != null)
          {
            i5 = i4 + 1;
            i6 = i3 + hll.a(str);
          }
          i2 += 1;
          i3 = i6;
        }
        i2 = i1 + i3 + i4 * 1;
      }
    }
    i1 = i2;
    if (o != null)
    {
      i1 = i2;
      if (o.length > 0)
      {
        i3 = 0;
        i1 = i7;
        while (i1 < o.length)
        {
          i3 += hll.a(o[i1]);
          i1 += 1;
        }
        i1 = i2 + i3 + o.length * 1;
      }
    }
    i2 = i1;
    if ((a & 0x400) != 0) {
      i2 = i1 + hll.b(15, p);
    }
    i1 = i2;
    if ((a & 0x800) != 0) {
      i1 = i2 + (hll.b(16) + 1);
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
    if ((a & 0x200) != 0) {
      paramhll.a(12, m);
    }
    if ((n != null) && (n.length > 0))
    {
      i1 = 0;
      while (i1 < n.length)
      {
        String str = n[i1];
        if (str != null) {
          paramhll.a(13, str);
        }
        i1 += 1;
      }
    }
    if ((o != null) && (o.length > 0))
    {
      i1 = i2;
      while (i1 < o.length)
      {
        paramhll.a(14, o[i1]);
        i1 += 1;
      }
    }
    if ((a & 0x400) != 0) {
      paramhll.a(15, p);
    }
    if ((a & 0x800) != 0) {
      paramhll.a(16, q);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */