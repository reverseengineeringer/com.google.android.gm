public final class gyu
  extends hlt
{
  public String A = "";
  public String B = "";
  public gzp[] C = gzp.b();
  public gwr D = null;
  private byte[] F = hlw.h;
  private String G = "";
  private int H = 0;
  private int I = 0;
  private boolean J = false;
  private String K = "";
  private String L = "";
  private String M = "";
  private String N = "";
  private String O = "";
  private String P = "";
  public int a = 0;
  public long b = 0L;
  public gwq c = null;
  public long d = 0L;
  public long e = 0L;
  public String f = "";
  public String g = "";
  public int h = 0;
  public boolean i = false;
  public gwq[] j = gwq.b();
  public gwq[] k = gwq.b();
  public gwq[] l = gwq.b();
  public gwq[] m = gwq.b();
  public String n = "";
  public boolean o = false;
  public int[] p = hlw.a;
  public gyv[] q = gyv.b();
  public byte[] r = hlw.h;
  public long s = 0L;
  public String t = "";
  public int u = -1;
  public int v = 0;
  public String w = "";
  public boolean x = false;
  public boolean y = false;
  public String z = "";
  
  public gyu()
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
    if (c != null) {
      i2 = i1 + hll.d(2, c);
    }
    i1 = i2;
    if ((a & 0x2) != 0) {
      i1 = i2 + hll.c(3, d);
    }
    i2 = i1;
    if ((a & 0x4) != 0) {
      i2 = i1 + hll.c(4, e);
    }
    i1 = i2;
    if ((a & 0x8) != 0) {
      i1 = i2 + hll.b(5, f);
    }
    i2 = i1;
    if ((a & 0x10) != 0) {
      i2 = i1 + hll.b(6, g);
    }
    int i3 = i2;
    if ((a & 0x20) != 0) {
      i3 = i2 + hll.c(7, h);
    }
    i1 = i3;
    if ((a & 0x40) != 0) {
      i1 = i3 + (hll.b(8) + 1);
    }
    i2 = i1;
    Object localObject;
    if (j != null)
    {
      i2 = i1;
      if (j.length > 0)
      {
        i2 = 0;
        while (i2 < j.length)
        {
          localObject = j[i2];
          i3 = i1;
          if (localObject != null) {
            i3 = i1 + hll.d(9, (hlt)localObject);
          }
          i2 += 1;
          i1 = i3;
        }
        i2 = i1;
      }
    }
    i1 = i2;
    if (k != null)
    {
      i1 = i2;
      if (k.length > 0)
      {
        i1 = i2;
        i2 = 0;
        while (i2 < k.length)
        {
          localObject = k[i2];
          i3 = i1;
          if (localObject != null) {
            i3 = i1 + hll.d(10, (hlt)localObject);
          }
          i2 += 1;
          i1 = i3;
        }
      }
    }
    i2 = i1;
    if (l != null)
    {
      i2 = i1;
      if (l.length > 0)
      {
        i2 = 0;
        while (i2 < l.length)
        {
          localObject = l[i2];
          i3 = i1;
          if (localObject != null) {
            i3 = i1 + hll.d(11, (hlt)localObject);
          }
          i2 += 1;
          i1 = i3;
        }
        i2 = i1;
      }
    }
    i1 = i2;
    if (m != null)
    {
      i1 = i2;
      if (m.length > 0)
      {
        i1 = i2;
        i2 = 0;
        while (i2 < m.length)
        {
          localObject = m[i2];
          i3 = i1;
          if (localObject != null) {
            i3 = i1 + hll.d(12, (hlt)localObject);
          }
          i2 += 1;
          i1 = i3;
        }
      }
    }
    i2 = i1;
    if ((a & 0x80) != 0) {
      i2 = i1 + hll.b(13, n);
    }
    i1 = i2;
    if (p != null)
    {
      i1 = i2;
      if (p.length > 0)
      {
        i1 = 0;
        i3 = 0;
        while (i1 < p.length)
        {
          i3 += hll.a(p[i1]);
          i1 += 1;
        }
        i1 = i2 + i3 + p.length * 1;
      }
    }
    i2 = i1;
    if (q != null)
    {
      i2 = i1;
      if (q.length > 0)
      {
        i2 = 0;
        while (i2 < q.length)
        {
          localObject = q[i2];
          i3 = i1;
          if (localObject != null) {
            i3 = i1 + hll.c(15, (hlt)localObject);
          }
          i2 += 1;
          i1 = i3;
        }
        i2 = i1;
      }
    }
    i1 = i2;
    if ((a & 0x200) != 0) {
      i1 = i2 + hll.b(16, r);
    }
    i2 = i1;
    if ((a & 0x400) != 0) {
      i2 = i1 + hll.c(17, s);
    }
    i1 = i2;
    if ((a & 0x800) != 0) {
      i1 = i2 + hll.b(18, F);
    }
    i2 = i1;
    if ((a & 0x1000) != 0) {
      i2 = i1 + hll.b(19, t);
    }
    i1 = i2;
    if ((a & 0x2000) != 0) {
      i1 = i2 + hll.c(20, u);
    }
    i2 = i1;
    if ((a & 0x4000) != 0) {
      i2 = i1 + hll.c(21, v);
    }
    i1 = i2;
    if ((a & 0x8000) != 0) {
      i1 = i2 + hll.b(22, w);
    }
    i2 = i1;
    if ((a & 0x10000) != 0) {
      i2 = i1 + (hll.b(23) + 1);
    }
    i1 = i2;
    if ((a & 0x20000) != 0) {
      i1 = i2 + hll.b(24, G);
    }
    i2 = i1;
    if ((a & 0x40000) != 0) {
      i2 = i1 + (hll.b(25) + 1);
    }
    i1 = i2;
    if ((a & 0x80000) != 0) {
      i1 = i2 + hll.b(26, z);
    }
    i2 = i1;
    if ((a & 0x100) != 0) {
      i2 = i1 + (hll.b(27) + 1);
    }
    i1 = i2;
    if ((a & 0x100000) != 0) {
      i1 = i2 + hll.c(28, H);
    }
    i2 = i1;
    if ((a & 0x200000) != 0) {
      i2 = i1 + hll.c(29, I);
    }
    i1 = i2;
    if ((a & 0x400000) != 0) {
      i1 = i2 + hll.b(30, A);
    }
    i2 = i1;
    if ((a & 0x800000) != 0) {
      i2 = i1 + hll.b(31, B);
    }
    i1 = i2;
    if ((a & 0x1000000) != 0) {
      i1 = i2 + (hll.b(32) + 1);
    }
    i2 = i1;
    if (C != null)
    {
      i2 = i1;
      if (C.length > 0)
      {
        i3 = i4;
        for (;;)
        {
          i2 = i1;
          if (i3 >= C.length) {
            break;
          }
          localObject = C[i3];
          i2 = i1;
          if (localObject != null) {
            i2 = i1 + hll.d(33, (hlt)localObject);
          }
          i3 += 1;
          i1 = i2;
        }
      }
    }
    i1 = i2;
    if ((a & 0x2000000) != 0) {
      i1 = i2 + hll.b(34, K);
    }
    i2 = i1;
    if (D != null) {
      i2 = i1 + hll.d(35, D);
    }
    i1 = i2;
    if ((a & 0x4000000) != 0) {
      i1 = i2 + hll.b(36, L);
    }
    i2 = i1;
    if ((a & 0x8000000) != 0) {
      i2 = i1 + hll.b(37, M);
    }
    i1 = i2;
    if ((a & 0x10000000) != 0) {
      i1 = i2 + hll.b(38, N);
    }
    i2 = i1;
    if ((a & 0x20000000) != 0) {
      i2 = i1 + hll.b(39, O);
    }
    i1 = i2;
    if ((a & 0x40000000) != 0) {
      i1 = i2 + hll.b(40, P);
    }
    return i1;
  }
  
  public final void a(hll paramhll)
  {
    int i2 = 0;
    if ((a & 0x1) != 0) {
      paramhll.a(1, b);
    }
    if (c != null) {
      paramhll.b(2, c);
    }
    if ((a & 0x2) != 0) {
      paramhll.a(3, d);
    }
    if ((a & 0x4) != 0) {
      paramhll.a(4, e);
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
    int i1;
    Object localObject;
    if ((j != null) && (j.length > 0))
    {
      i1 = 0;
      while (i1 < j.length)
      {
        localObject = j[i1];
        if (localObject != null) {
          paramhll.b(9, (hlt)localObject);
        }
        i1 += 1;
      }
    }
    if ((k != null) && (k.length > 0))
    {
      i1 = 0;
      while (i1 < k.length)
      {
        localObject = k[i1];
        if (localObject != null) {
          paramhll.b(10, (hlt)localObject);
        }
        i1 += 1;
      }
    }
    if ((l != null) && (l.length > 0))
    {
      i1 = 0;
      while (i1 < l.length)
      {
        localObject = l[i1];
        if (localObject != null) {
          paramhll.b(11, (hlt)localObject);
        }
        i1 += 1;
      }
    }
    if ((m != null) && (m.length > 0))
    {
      i1 = 0;
      while (i1 < m.length)
      {
        localObject = m[i1];
        if (localObject != null) {
          paramhll.b(12, (hlt)localObject);
        }
        i1 += 1;
      }
    }
    if ((a & 0x80) != 0) {
      paramhll.a(13, n);
    }
    if ((p != null) && (p.length > 0))
    {
      i1 = 0;
      while (i1 < p.length)
      {
        paramhll.a(14, p[i1]);
        i1 += 1;
      }
    }
    if ((q != null) && (q.length > 0))
    {
      i1 = 0;
      while (i1 < q.length)
      {
        localObject = q[i1];
        if (localObject != null) {
          paramhll.a(15, (hlt)localObject);
        }
        i1 += 1;
      }
    }
    if ((a & 0x200) != 0) {
      paramhll.a(16, r);
    }
    if ((a & 0x400) != 0) {
      paramhll.a(17, s);
    }
    if ((a & 0x800) != 0) {
      paramhll.a(18, F);
    }
    if ((a & 0x1000) != 0) {
      paramhll.a(19, t);
    }
    if ((a & 0x2000) != 0) {
      paramhll.a(20, u);
    }
    if ((a & 0x4000) != 0) {
      paramhll.a(21, v);
    }
    if ((a & 0x8000) != 0) {
      paramhll.a(22, w);
    }
    if ((a & 0x10000) != 0) {
      paramhll.a(23, x);
    }
    if ((a & 0x20000) != 0) {
      paramhll.a(24, G);
    }
    if ((a & 0x40000) != 0) {
      paramhll.a(25, y);
    }
    if ((a & 0x80000) != 0) {
      paramhll.a(26, z);
    }
    if ((a & 0x100) != 0) {
      paramhll.a(27, o);
    }
    if ((a & 0x100000) != 0) {
      paramhll.a(28, H);
    }
    if ((a & 0x200000) != 0) {
      paramhll.a(29, I);
    }
    if ((a & 0x400000) != 0) {
      paramhll.a(30, A);
    }
    if ((a & 0x800000) != 0) {
      paramhll.a(31, B);
    }
    if ((a & 0x1000000) != 0) {
      paramhll.a(32, J);
    }
    if ((C != null) && (C.length > 0))
    {
      i1 = i2;
      while (i1 < C.length)
      {
        localObject = C[i1];
        if (localObject != null) {
          paramhll.b(33, (hlt)localObject);
        }
        i1 += 1;
      }
    }
    if ((a & 0x2000000) != 0) {
      paramhll.a(34, K);
    }
    if (D != null) {
      paramhll.b(35, D);
    }
    if ((a & 0x4000000) != 0) {
      paramhll.a(36, L);
    }
    if ((a & 0x8000000) != 0) {
      paramhll.a(37, M);
    }
    if ((a & 0x10000000) != 0) {
      paramhll.a(38, N);
    }
    if ((a & 0x20000000) != 0) {
      paramhll.a(39, O);
    }
    if ((a & 0x40000000) != 0) {
      paramhll.a(40, P);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gyu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */