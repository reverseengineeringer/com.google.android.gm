public final class gzd
  extends hlt
{
  private boolean A = false;
  private boolean B = false;
  private boolean C = false;
  private boolean D = false;
  public int a = 0;
  public long b = 0L;
  public long c = 0L;
  public long d = 0L;
  public gzg[] e = gzg.b();
  public String f = "";
  public String g = "";
  public String h = "";
  public String i = "";
  public String j = "";
  public String k = "";
  public String l = "";
  public String m = "";
  public String n = "";
  public String o = "";
  public gwt p = null;
  public boolean q = false;
  public boolean r = false;
  public gwu[] s = gwu.b();
  public String t = "";
  public gze u = null;
  public boolean v = false;
  public boolean w = false;
  public boolean x = false;
  private String y = "";
  private String z = "";
  
  public gzd()
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
    Object localObject;
    int i3;
    if (e != null)
    {
      i2 = i1;
      if (e.length > 0)
      {
        i2 = 0;
        while (i2 < e.length)
        {
          localObject = e[i2];
          i3 = i1;
          if (localObject != null) {
            i3 = i1 + hll.c(4, (hlt)localObject);
          }
          i2 += 1;
          i1 = i3;
        }
        i2 = i1;
      }
    }
    i1 = i2;
    if ((a & 0x8) != 0) {
      i1 = i2 + hll.b(5, f);
    }
    i2 = i1;
    if ((a & 0x10) != 0) {
      i2 = i1 + hll.b(6, g);
    }
    i1 = i2;
    if ((a & 0x20) != 0) {
      i1 = i2 + hll.b(7, h);
    }
    i2 = i1;
    if ((a & 0x40) != 0) {
      i2 = i1 + hll.b(8, i);
    }
    i1 = i2;
    if ((a & 0x80) != 0) {
      i1 = i2 + hll.b(9, j);
    }
    i2 = i1;
    if ((a & 0x100) != 0) {
      i2 = i1 + hll.b(10, k);
    }
    i1 = i2;
    if ((a & 0x200) != 0) {
      i1 = i2 + hll.b(11, y);
    }
    i2 = i1;
    if ((a & 0x400) != 0) {
      i2 = i1 + hll.b(12, z);
    }
    i1 = i2;
    if ((a & 0x800) != 0) {
      i1 = i2 + hll.b(13, l);
    }
    i2 = i1;
    if ((a & 0x1000) != 0) {
      i2 = i1 + hll.b(14, m);
    }
    i1 = i2;
    if ((a & 0x2000) != 0) {
      i1 = i2 + hll.b(15, n);
    }
    i2 = i1;
    if ((a & 0x4000) != 0) {
      i2 = i1 + hll.b(16, o);
    }
    i1 = i2;
    if (p != null) {
      i1 = i2 + hll.d(17, p);
    }
    i2 = i1;
    if ((a & 0x8000) != 0) {
      i2 = i1 + (hll.b(18) + 1);
    }
    i1 = i2;
    if ((a & 0x10000) != 0) {
      i1 = i2 + (hll.b(19) + 1);
    }
    i2 = i1;
    if (s != null)
    {
      i2 = i1;
      if (s.length > 0)
      {
        i3 = i4;
        for (;;)
        {
          i2 = i1;
          if (i3 >= s.length) {
            break;
          }
          localObject = s[i3];
          i2 = i1;
          if (localObject != null) {
            i2 = i1 + hll.d(20, (hlt)localObject);
          }
          i3 += 1;
          i1 = i2;
        }
      }
    }
    i1 = i2;
    if ((a & 0x20000) != 0) {
      i1 = i2 + hll.b(21, t);
    }
    i2 = i1;
    if (u != null) {
      i2 = i1 + hll.c(22, u);
    }
    i1 = i2;
    if ((a & 0x40000) != 0) {
      i1 = i2 + (hll.b(23) + 1);
    }
    i2 = i1;
    if ((a & 0x80000) != 0) {
      i2 = i1 + (hll.b(24) + 1);
    }
    i1 = i2;
    if ((a & 0x100000) != 0) {
      i1 = i2 + (hll.b(25) + 1);
    }
    i2 = i1;
    if ((a & 0x200000) != 0) {
      i2 = i1 + (hll.b(26) + 1);
    }
    i1 = i2;
    if ((a & 0x400000) != 0) {
      i1 = i2 + (hll.b(27) + 1);
    }
    i2 = i1;
    if ((a & 0x800000) != 0) {
      i2 = i1 + (hll.b(28) + 1);
    }
    i1 = i2;
    if ((a & 0x1000000) != 0) {
      i1 = i2 + (hll.b(29) + 1);
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
    int i1;
    Object localObject;
    if ((e != null) && (e.length > 0))
    {
      i1 = 0;
      while (i1 < e.length)
      {
        localObject = e[i1];
        if (localObject != null) {
          paramhll.a(4, (hlt)localObject);
        }
        i1 += 1;
      }
    }
    if ((a & 0x8) != 0) {
      paramhll.a(5, f);
    }
    if ((a & 0x10) != 0) {
      paramhll.a(6, g);
    }
    if ((a & 0x20) != 0) {
      paramhll.a(7, h);
    }
    if ((a & 0x40) != 0) {
      paramhll.a(8, i);
    }
    if ((a & 0x80) != 0) {
      paramhll.a(9, j);
    }
    if ((a & 0x100) != 0) {
      paramhll.a(10, k);
    }
    if ((a & 0x200) != 0) {
      paramhll.a(11, y);
    }
    if ((a & 0x400) != 0) {
      paramhll.a(12, z);
    }
    if ((a & 0x800) != 0) {
      paramhll.a(13, l);
    }
    if ((a & 0x1000) != 0) {
      paramhll.a(14, m);
    }
    if ((a & 0x2000) != 0) {
      paramhll.a(15, n);
    }
    if ((a & 0x4000) != 0) {
      paramhll.a(16, o);
    }
    if (p != null) {
      paramhll.b(17, p);
    }
    if ((a & 0x8000) != 0) {
      paramhll.a(18, q);
    }
    if ((a & 0x10000) != 0) {
      paramhll.a(19, r);
    }
    if ((s != null) && (s.length > 0))
    {
      i1 = i2;
      while (i1 < s.length)
      {
        localObject = s[i1];
        if (localObject != null) {
          paramhll.b(20, (hlt)localObject);
        }
        i1 += 1;
      }
    }
    if ((a & 0x20000) != 0) {
      paramhll.a(21, t);
    }
    if (u != null) {
      paramhll.a(22, u);
    }
    if ((a & 0x40000) != 0) {
      paramhll.a(23, v);
    }
    if ((a & 0x80000) != 0) {
      paramhll.a(24, A);
    }
    if ((a & 0x100000) != 0) {
      paramhll.a(25, B);
    }
    if ((a & 0x200000) != 0) {
      paramhll.a(26, C);
    }
    if ((a & 0x400000) != 0) {
      paramhll.a(27, D);
    }
    if ((a & 0x800000) != 0) {
      paramhll.a(28, w);
    }
    if ((a & 0x1000000) != 0) {
      paramhll.a(29, x);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */