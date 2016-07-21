public final class gzg
  extends hlt
{
  private static volatile gzg[] j;
  public int a = 0;
  public int b = 0;
  public String c = "";
  public String d = "";
  public int e = 0;
  public int f = 0;
  public int g = 0;
  public String h = "";
  public int i = 0;
  
  public gzg()
  {
    E = -1;
  }
  
  public static gzg[] b()
  {
    if (j == null) {}
    synchronized (hlr.c)
    {
      if (j == null) {
        j = new gzg[0];
      }
      return j;
    }
  }
  
  protected final int a()
  {
    int m = super.a();
    int k = m;
    if ((a & 0x1) != 0) {
      k = m + hll.c(1, b);
    }
    m = k;
    if ((a & 0x2) != 0) {
      m = k + hll.b(2, c);
    }
    k = m;
    if ((a & 0x4) != 0) {
      k = m + hll.b(3, d);
    }
    m = k;
    if ((a & 0x8) != 0) {
      m = k + hll.c(4, e);
    }
    k = m;
    if ((a & 0x10) != 0) {
      k = m + hll.c(5, f);
    }
    m = k;
    if ((a & 0x20) != 0) {
      m = k + hll.c(6, g);
    }
    k = m;
    if ((a & 0x40) != 0) {
      k = m + hll.b(7, h);
    }
    m = k;
    if ((a & 0x80) != 0) {
      m = k + hll.c(8, i);
    }
    return m;
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
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gzg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */