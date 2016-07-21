public final class gxj
  extends hlt
{
  private static volatile gxj[] p;
  public int a = 0;
  public long b = 0L;
  public gxo c = null;
  public gxk d = null;
  public gxp e = null;
  public long f = 0L;
  public gyb g = null;
  public gzs h = null;
  public gxl i = null;
  public gxn j = null;
  public gxz k = null;
  public gyc l = null;
  public gya m = null;
  public gxr n = null;
  public gxm o = null;
  private long q = 0L;
  
  public gxj()
  {
    E = -1;
  }
  
  public static gxj[] b()
  {
    if (p == null) {}
    synchronized (hlr.c)
    {
      if (p == null) {
        p = new gxj[0];
      }
      return p;
    }
  }
  
  protected final int a()
  {
    int i2 = super.a();
    int i1 = i2;
    if ((a & 0x1) != 0) {
      i1 = i2 + hll.c(1, b);
    }
    i2 = i1;
    if (c != null) {
      i2 = i1 + hll.c(2, c);
    }
    i1 = i2;
    if (d != null) {
      i1 = i2 + hll.c(3, d);
    }
    i2 = i1;
    if (e != null) {
      i2 = i1 + hll.c(4, e);
    }
    i1 = i2;
    if ((a & 0x2) != 0) {
      i1 = i2 + hll.c(5, f);
    }
    i2 = i1;
    if ((a & 0x4) != 0) {
      i2 = i1 + hll.c(6, q);
    }
    i1 = i2;
    if (g != null) {
      i1 = i2 + hll.c(7, g);
    }
    i2 = i1;
    if (h != null) {
      i2 = i1 + hll.d(8, h);
    }
    i1 = i2;
    if (i != null) {
      i1 = i2 + hll.c(9, i);
    }
    i2 = i1;
    if (j != null) {
      i2 = i1 + hll.c(10, j);
    }
    i1 = i2;
    if (k != null) {
      i1 = i2 + hll.c(11, k);
    }
    i2 = i1;
    if (l != null) {
      i2 = i1 + hll.c(12, l);
    }
    i1 = i2;
    if (m != null) {
      i1 = i2 + hll.c(13, m);
    }
    i2 = i1;
    if (n != null) {
      i2 = i1 + hll.c(14, n);
    }
    i1 = i2;
    if (o != null) {
      i1 = i2 + hll.c(15, o);
    }
    return i1;
  }
  
  public final void a(hll paramhll)
  {
    if ((a & 0x1) != 0) {
      paramhll.a(1, b);
    }
    if (c != null) {
      paramhll.a(2, c);
    }
    if (d != null) {
      paramhll.a(3, d);
    }
    if (e != null) {
      paramhll.a(4, e);
    }
    if ((a & 0x2) != 0) {
      paramhll.a(5, f);
    }
    if ((a & 0x4) != 0) {
      paramhll.a(6, q);
    }
    if (g != null) {
      paramhll.a(7, g);
    }
    if (h != null) {
      paramhll.b(8, h);
    }
    if (i != null) {
      paramhll.a(9, i);
    }
    if (j != null) {
      paramhll.a(10, j);
    }
    if (k != null) {
      paramhll.a(11, k);
    }
    if (l != null) {
      paramhll.a(12, l);
    }
    if (m != null) {
      paramhll.a(13, m);
    }
    if (n != null) {
      paramhll.a(14, n);
    }
    if (o != null) {
      paramhll.a(15, o);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gxj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */