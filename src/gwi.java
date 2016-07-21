public final class gwi
  extends hlt
{
  private static volatile gwi[] A;
  public int a = 0;
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  public byte[] h = hlw.h;
  public String i = "";
  public long j = 0L;
  public int k = 0;
  public String l = "";
  public String m = "";
  public String n = "";
  public String o = "";
  public String p = "";
  public String q = "";
  public String r = "";
  public String[] s = hlw.f;
  public String t = "";
  public gwk u = null;
  public gwn v = null;
  public int[] w = hlw.a;
  public String x = "";
  public int y = 1;
  public String[] z = hlw.f;
  
  public gwi()
  {
    E = -1;
  }
  
  public static gwi[] b()
  {
    if (A == null) {}
    synchronized (hlr.c)
    {
      if (A == null) {
        A = new gwi[0];
      }
      return A;
    }
  }
  
  protected final int a()
  {
    int i7 = 0;
    int i2 = super.a();
    int i1 = i2;
    if ((a & 0x1) != 0) {
      i1 = i2 + hll.b(1, b);
    }
    i2 = i1;
    if ((a & 0x2) != 0) {
      i2 = i1 + hll.b(2, c);
    }
    i1 = i2;
    if ((a & 0x4) != 0) {
      i1 = i2 + hll.b(3, d);
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
    if ((a & 0x40) != 0) {
      i2 = i1 + hll.b(6, h);
    }
    i1 = i2;
    if ((a & 0x80) != 0) {
      i1 = i2 + hll.b(7, i);
    }
    i2 = i1;
    if ((a & 0x100) != 0) {
      i2 = i1 + hll.c(8, j);
    }
    i1 = i2;
    if ((a & 0x200) != 0) {
      i1 = i2 + hll.c(9, k);
    }
    i2 = i1;
    if ((a & 0x400) != 0) {
      i2 = i1 + hll.b(10, l);
    }
    i1 = i2;
    if ((a & 0x800) != 0) {
      i1 = i2 + hll.b(11, m);
    }
    i2 = i1;
    if ((a & 0x1000) != 0) {
      i2 = i1 + hll.b(12, n);
    }
    i1 = i2;
    if ((a & 0x20) != 0) {
      i1 = i2 + hll.b(13, g);
    }
    i2 = i1;
    if ((a & 0x2000) != 0) {
      i2 = i1 + hll.b(14, o);
    }
    i1 = i2;
    if ((a & 0x4000) != 0) {
      i1 = i2 + hll.b(15, p);
    }
    i2 = i1;
    if ((a & 0x8000) != 0) {
      i2 = i1 + hll.b(16, q);
    }
    i1 = i2;
    if ((a & 0x10000) != 0) {
      i1 = i2 + hll.b(17, r);
    }
    i2 = i1;
    if ((a & 0x20000) != 0) {
      i2 = i1 + hll.b(18, t);
    }
    int i3 = i2;
    if (u != null) {
      i3 = i2 + hll.d(19, u);
    }
    i1 = i3;
    if (v != null) {
      i1 = i3 + hll.d(20, v);
    }
    i2 = i1;
    if (w != null)
    {
      i2 = i1;
      if (w.length > 0)
      {
        i2 = 0;
        i3 = 0;
        while (i2 < w.length)
        {
          i3 += hll.a(w[i2]);
          i2 += 1;
        }
        i2 = i1 + i3 + w.length * 2;
      }
    }
    i3 = i2;
    if ((a & 0x40000) != 0) {
      i3 = i2 + hll.b(22, x);
    }
    i1 = i3;
    if ((a & 0x80000) != 0) {
      i1 = i3 + hll.c(23, y);
    }
    i2 = i1;
    int i4;
    String str;
    int i6;
    int i5;
    if (s != null)
    {
      i2 = i1;
      if (s.length > 0)
      {
        i2 = 0;
        i3 = 0;
        for (i4 = 0; i2 < s.length; i4 = i5)
        {
          str = s[i2];
          i6 = i3;
          i5 = i4;
          if (str != null)
          {
            i5 = i4 + 1;
            i6 = i3 + hll.a(str);
          }
          i2 += 1;
          i3 = i6;
        }
        i2 = i1 + i3 + i4 * 2;
      }
    }
    i1 = i2;
    if (z != null)
    {
      i1 = i2;
      if (z.length > 0)
      {
        i3 = 0;
        i4 = 0;
        i1 = i7;
        while (i1 < z.length)
        {
          str = z[i1];
          i6 = i3;
          i5 = i4;
          if (str != null)
          {
            i5 = i4 + 1;
            i6 = i3 + hll.a(str);
          }
          i1 += 1;
          i3 = i6;
          i4 = i5;
        }
        i1 = i2 + i3 + i4 * 2;
      }
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
    if ((a & 0x40) != 0) {
      paramhll.a(6, h);
    }
    if ((a & 0x80) != 0) {
      paramhll.a(7, i);
    }
    if ((a & 0x100) != 0) {
      paramhll.a(8, j);
    }
    if ((a & 0x200) != 0) {
      paramhll.a(9, k);
    }
    if ((a & 0x400) != 0) {
      paramhll.a(10, l);
    }
    if ((a & 0x800) != 0) {
      paramhll.a(11, m);
    }
    if ((a & 0x1000) != 0) {
      paramhll.a(12, n);
    }
    if ((a & 0x20) != 0) {
      paramhll.a(13, g);
    }
    if ((a & 0x2000) != 0) {
      paramhll.a(14, o);
    }
    if ((a & 0x4000) != 0) {
      paramhll.a(15, p);
    }
    if ((a & 0x8000) != 0) {
      paramhll.a(16, q);
    }
    if ((a & 0x10000) != 0) {
      paramhll.a(17, r);
    }
    if ((a & 0x20000) != 0) {
      paramhll.a(18, t);
    }
    if (u != null) {
      paramhll.b(19, u);
    }
    if (v != null) {
      paramhll.b(20, v);
    }
    int i1;
    if ((w != null) && (w.length > 0))
    {
      i1 = 0;
      while (i1 < w.length)
      {
        paramhll.a(21, w[i1]);
        i1 += 1;
      }
    }
    if ((a & 0x40000) != 0) {
      paramhll.a(22, x);
    }
    if ((a & 0x80000) != 0) {
      paramhll.a(23, y);
    }
    String str;
    if ((s != null) && (s.length > 0))
    {
      i1 = 0;
      while (i1 < s.length)
      {
        str = s[i1];
        if (str != null) {
          paramhll.a(24, str);
        }
        i1 += 1;
      }
    }
    if ((z != null) && (z.length > 0))
    {
      i1 = i2;
      while (i1 < z.length)
      {
        str = z[i1];
        if (str != null) {
          paramhll.a(25, str);
        }
        i1 += 1;
      }
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gwi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */