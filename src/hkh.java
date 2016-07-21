public final class hkh
  extends hln<hkh>
{
  public int a = 0;
  public int b = 0;
  public int c = 0;
  public long d = 0L;
  public long e = 0L;
  public long f = 0L;
  public long g = 0L;
  public int[] h = hlw.a;
  public hkf[] i = hkf.b();
  public int j = 0;
  public int[] k = hlw.a;
  public int l = 0;
  public int m = 0;
  public int n = 0;
  public long o = 0L;
  public long p = 0L;
  
  public hkh()
  {
    q = null;
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
    int i3;
    if (h != null)
    {
      i1 = i2;
      if (h.length > 0)
      {
        i1 = 0;
        i3 = 0;
        while (i1 < h.length)
        {
          i3 += hll.a(h[i1]);
          i1 += 1;
        }
        i1 = i2 + i3 + h.length * 1;
      }
    }
    i2 = i1;
    if (i != null)
    {
      i2 = i1;
      if (i.length > 0)
      {
        i2 = 0;
        while (i2 < i.length)
        {
          hkf localhkf = i[i2];
          i3 = i1;
          if (localhkf != null) {
            i3 = i1 + hll.d(8, localhkf);
          }
          i2 += 1;
          i1 = i3;
        }
        i2 = i1;
      }
    }
    i1 = i2;
    if ((a & 0x40) != 0) {
      i1 = i2 + hll.c(9, j);
    }
    i2 = i1;
    if (k != null)
    {
      i2 = i1;
      if (k.length > 0)
      {
        i3 = 0;
        i2 = i4;
        while (i2 < k.length)
        {
          i3 += hll.a(k[i2]);
          i2 += 1;
        }
        i2 = i1 + i3 + k.length * 1;
      }
    }
    i1 = i2;
    if ((a & 0x80) != 0) {
      i1 = i2 + hll.c(11, l);
    }
    i2 = i1;
    if ((a & 0x100) != 0) {
      i2 = i1 + hll.c(12, m);
    }
    i1 = i2;
    if ((a & 0x200) != 0) {
      i1 = i2 + hll.c(13, n);
    }
    i2 = i1;
    if ((a & 0x400) != 0) {
      i2 = i1 + hll.c(14, o);
    }
    i1 = i2;
    if ((a & 0x800) != 0) {
      i1 = i2 + hll.c(15, p);
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
    int i1;
    if ((h != null) && (h.length > 0))
    {
      i1 = 0;
      while (i1 < h.length)
      {
        paramhll.a(7, h[i1]);
        i1 += 1;
      }
    }
    if ((i != null) && (i.length > 0))
    {
      i1 = 0;
      while (i1 < i.length)
      {
        hkf localhkf = i[i1];
        if (localhkf != null) {
          paramhll.b(8, localhkf);
        }
        i1 += 1;
      }
    }
    if ((a & 0x40) != 0) {
      paramhll.a(9, j);
    }
    if ((k != null) && (k.length > 0))
    {
      i1 = i2;
      while (i1 < k.length)
      {
        paramhll.a(10, k[i1]);
        i1 += 1;
      }
    }
    if ((a & 0x80) != 0) {
      paramhll.a(11, l);
    }
    if ((a & 0x100) != 0) {
      paramhll.a(12, m);
    }
    if ((a & 0x200) != 0) {
      paramhll.a(13, n);
    }
    if ((a & 0x400) != 0) {
      paramhll.a(14, o);
    }
    if ((a & 0x800) != 0) {
      paramhll.a(15, p);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hkh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */