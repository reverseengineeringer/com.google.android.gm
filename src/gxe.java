public final class gxe
  extends hlt
{
  public int a = 0;
  public long b = 0L;
  public int c = 0;
  public long d = 0L;
  public boolean e = false;
  public int f = 0;
  public boolean g = false;
  public boolean h = false;
  public boolean i = false;
  public int j = 0;
  public int k = 4;
  public boolean l = false;
  public boolean m = false;
  public long n = 0L;
  public boolean o = false;
  public boolean p = false;
  public boolean q = false;
  public boolean r = false;
  public boolean s = false;
  public boolean t = false;
  private int u = 0;
  private int v = 0;
  private boolean w = false;
  private int x = 0;
  
  public gxe()
  {
    E = -1;
  }
  
  protected final int a()
  {
    int i2 = super.a();
    int i1 = i2;
    if ((a & 0x1) != 0) {
      i1 = i2 + hll.c(1, b);
    }
    i2 = i1;
    if ((a & 0x4) != 0) {
      i2 = i1 + hll.c(2, d);
    }
    i1 = i2;
    if ((a & 0x2) != 0) {
      i1 = i2 + hll.c(3, c);
    }
    i2 = i1;
    if ((a & 0x8) != 0) {
      i2 = i1 + hll.c(4, u);
    }
    i1 = i2;
    if ((a & 0x10) != 0) {
      i1 = i2 + hll.c(5, v);
    }
    i2 = i1;
    if ((a & 0x20) != 0) {
      i2 = i1 + (hll.b(6) + 1);
    }
    i1 = i2;
    if ((a & 0x40) != 0) {
      i1 = i2 + hll.c(7, f);
    }
    i2 = i1;
    if ((a & 0x80) != 0) {
      i2 = i1 + (hll.b(8) + 1);
    }
    i1 = i2;
    if ((a & 0x100) != 0) {
      i1 = i2 + (hll.b(9) + 1);
    }
    i2 = i1;
    if ((a & 0x200) != 0) {
      i2 = i1 + (hll.b(10) + 1);
    }
    i1 = i2;
    if ((a & 0x400) != 0) {
      i1 = i2 + hll.c(11, j);
    }
    i2 = i1;
    if ((a & 0x800) != 0) {
      i2 = i1 + hll.c(12, k);
    }
    i1 = i2;
    if ((a & 0x1000) != 0) {
      i1 = i2 + (hll.b(13) + 1);
    }
    i2 = i1;
    if ((a & 0x2000) != 0) {
      i2 = i1 + (hll.b(14) + 1);
    }
    i1 = i2;
    if ((a & 0x4000) != 0) {
      i1 = i2 + (hll.b(15) + 1);
    }
    i2 = i1;
    if ((a & 0x8000) != 0) {
      i2 = i1 + hll.c(16, x);
    }
    i1 = i2;
    if ((a & 0x10000) != 0) {
      i1 = i2 + hll.c(17, n);
    }
    i2 = i1;
    if ((a & 0x20000) != 0) {
      i2 = i1 + (hll.b(18) + 1);
    }
    i1 = i2;
    if ((a & 0x40000) != 0) {
      i1 = i2 + (hll.b(19) + 1);
    }
    i2 = i1;
    if ((a & 0x80000) != 0) {
      i2 = i1 + (hll.b(20) + 1);
    }
    i1 = i2;
    if ((a & 0x100000) != 0) {
      i1 = i2 + (hll.b(21) + 1);
    }
    i2 = i1;
    if ((a & 0x200000) != 0) {
      i2 = i1 + (hll.b(22) + 1);
    }
    i1 = i2;
    if ((a & 0x400000) != 0) {
      i1 = i2 + (hll.b(23) + 1);
    }
    return i1;
  }
  
  public final gxe a(int paramInt)
  {
    v = paramInt;
    a |= 0x10;
    return this;
  }
  
  public final void a(hll paramhll)
  {
    if ((a & 0x1) != 0) {
      paramhll.a(1, b);
    }
    if ((a & 0x4) != 0) {
      paramhll.a(2, d);
    }
    if ((a & 0x2) != 0) {
      paramhll.a(3, c);
    }
    if ((a & 0x8) != 0) {
      paramhll.a(4, u);
    }
    if ((a & 0x10) != 0) {
      paramhll.a(5, v);
    }
    if ((a & 0x20) != 0) {
      paramhll.a(6, e);
    }
    if ((a & 0x40) != 0) {
      paramhll.a(7, f);
    }
    if ((a & 0x80) != 0) {
      paramhll.a(8, g);
    }
    if ((a & 0x100) != 0) {
      paramhll.a(9, h);
    }
    if ((a & 0x200) != 0) {
      paramhll.a(10, i);
    }
    if ((a & 0x400) != 0) {
      paramhll.a(11, j);
    }
    if ((a & 0x800) != 0) {
      paramhll.a(12, k);
    }
    if ((a & 0x1000) != 0) {
      paramhll.a(13, w);
    }
    if ((a & 0x2000) != 0) {
      paramhll.a(14, l);
    }
    if ((a & 0x4000) != 0) {
      paramhll.a(15, m);
    }
    if ((a & 0x8000) != 0) {
      paramhll.a(16, x);
    }
    if ((a & 0x10000) != 0) {
      paramhll.a(17, n);
    }
    if ((a & 0x20000) != 0) {
      paramhll.a(18, o);
    }
    if ((a & 0x40000) != 0) {
      paramhll.a(19, p);
    }
    if ((a & 0x80000) != 0) {
      paramhll.a(20, q);
    }
    if ((a & 0x100000) != 0) {
      paramhll.a(21, r);
    }
    if ((a & 0x200000) != 0) {
      paramhll.a(22, s);
    }
    if ((a & 0x400000) != 0) {
      paramhll.a(23, t);
    }
    super.a(paramhll);
  }
  
  public final gxe b(int paramInt)
  {
    x = paramInt;
    a |= 0x8000;
    return this;
  }
}

/* Location:
 * Qualified Name:     gxe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */