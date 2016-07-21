public final class hkf
  extends hln<hkf>
{
  private static volatile hkf[] m;
  public int a = 0;
  public int b = 0;
  public int c = 0;
  public int d = 0;
  public int e = 0;
  public int f = 0;
  public int g = 0;
  public int h = 0;
  public int i = 0;
  public int j = 0;
  public int k = 0;
  public int l = 0;
  
  public hkf()
  {
    q = null;
    E = -1;
  }
  
  public static hkf[] b()
  {
    if (m == null) {}
    synchronized (hlr.c)
    {
      if (m == null) {
        m = new hkf[0];
      }
      return m;
    }
  }
  
  protected final int a()
  {
    int i1 = super.a();
    int n = i1;
    if ((a & 0x1) != 0) {
      n = i1 + hll.c(1, b);
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
      i1 = n + hll.c(4, e);
    }
    n = i1;
    if ((a & 0x10) != 0) {
      n = i1 + hll.c(5, f);
    }
    i1 = n;
    if ((a & 0x20) != 0) {
      i1 = n + hll.c(6, g);
    }
    n = i1;
    if ((a & 0x40) != 0) {
      n = i1 + hll.c(7, h);
    }
    i1 = n;
    if ((a & 0x80) != 0) {
      i1 = n + hll.c(8, i);
    }
    n = i1;
    if ((a & 0x100) != 0) {
      n = i1 + hll.c(9, j);
    }
    i1 = n;
    if ((a & 0x200) != 0) {
      i1 = n + hll.c(10, k);
    }
    n = i1;
    if ((a & 0x400) != 0) {
      n = i1 + hll.c(11, l);
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
    if ((a & 0x200) != 0) {
      paramhll.a(10, k);
    }
    if ((a & 0x400) != 0) {
      paramhll.a(11, l);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hkf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */