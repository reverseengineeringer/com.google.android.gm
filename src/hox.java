public final class hox
  extends hln<hox>
{
  private static volatile hox[] b;
  public hoy a = null;
  private int c = 0;
  private String d = "";
  private String e = "";
  private String f = "";
  private String g = "";
  private String h = "";
  private String i = "";
  private long j = 0L;
  private long k = 0L;
  private boolean l = false;
  
  public hox()
  {
    q = null;
    E = -1;
  }
  
  public static hox[] b()
  {
    if (b == null) {}
    synchronized (hlr.c)
    {
      if (b == null) {
        b = new hox[0];
      }
      return b;
    }
  }
  
  protected final int a()
  {
    int n = super.a();
    int m = n;
    if (a != null) {
      m = n + hll.d(1, a);
    }
    n = m;
    if ((c & 0x1) != 0) {
      n = m + hll.b(2, d);
    }
    m = n;
    if ((c & 0x2) != 0) {
      m = n + hll.b(3, e);
    }
    n = m;
    if ((c & 0x4) != 0) {
      n = m + hll.b(4, f);
    }
    m = n;
    if ((c & 0x8) != 0) {
      m = n + hll.b(5, g);
    }
    n = m;
    if ((c & 0x10) != 0) {
      n = m + hll.b(6, h);
    }
    m = n;
    if ((c & 0x20) != 0) {
      m = n + hll.b(7, i);
    }
    n = m;
    if ((c & 0x40) != 0) {
      n = m + hll.c(8, j);
    }
    m = n;
    if ((c & 0x80) != 0) {
      m = n + hll.c(9, k);
    }
    n = m;
    if ((c & 0x100) != 0) {
      n = m + (hll.b(10) + 1);
    }
    return n;
  }
  
  public final void a(hll paramhll)
  {
    if (a != null) {
      paramhll.b(1, a);
    }
    if ((c & 0x1) != 0) {
      paramhll.a(2, d);
    }
    if ((c & 0x2) != 0) {
      paramhll.a(3, e);
    }
    if ((c & 0x4) != 0) {
      paramhll.a(4, f);
    }
    if ((c & 0x8) != 0) {
      paramhll.a(5, g);
    }
    if ((c & 0x10) != 0) {
      paramhll.a(6, h);
    }
    if ((c & 0x20) != 0) {
      paramhll.a(7, i);
    }
    if ((c & 0x40) != 0) {
      paramhll.a(8, j);
    }
    if ((c & 0x80) != 0) {
      paramhll.a(9, k);
    }
    if ((c & 0x100) != 0) {
      paramhll.a(10, l);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hox
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */