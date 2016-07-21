public final class hnd
  extends hln<hnd>
{
  private static volatile hnd[] d;
  public int a = 0;
  public String b = "";
  public String c = "";
  private String e = "";
  private String f = "";
  private String g = "";
  private String h = "";
  private String i = "";
  private String j = "";
  private String k = "";
  private String l = "";
  private String m = "";
  
  public hnd()
  {
    q = null;
    E = -1;
  }
  
  public static hnd[] b()
  {
    if (d == null) {}
    synchronized (hlr.c)
    {
      if (d == null) {
        d = new hnd[0];
      }
      return d;
    }
  }
  
  protected final int a()
  {
    int i1 = super.a();
    int n = i1;
    if ((a & 0x1) != 0) {
      n = i1 + hll.b(1, e);
    }
    i1 = n;
    if ((a & 0x2) != 0) {
      i1 = n + hll.b(2, f);
    }
    n = i1;
    if ((a & 0x4) != 0) {
      n = i1 + hll.b(3, g);
    }
    i1 = n;
    if ((a & 0x8) != 0) {
      i1 = n + hll.b(4, b);
    }
    n = i1;
    if ((a & 0x10) != 0) {
      n = i1 + hll.b(5, c);
    }
    i1 = n;
    if ((a & 0x20) != 0) {
      i1 = n + hll.b(6, h);
    }
    n = i1;
    if ((a & 0x40) != 0) {
      n = i1 + hll.b(7, i);
    }
    i1 = n;
    if ((a & 0x80) != 0) {
      i1 = n + hll.b(8, j);
    }
    n = i1;
    if ((a & 0x100) != 0) {
      n = i1 + hll.b(9, k);
    }
    i1 = n;
    if ((a & 0x200) != 0) {
      i1 = n + hll.b(10, l);
    }
    n = i1;
    if ((a & 0x400) != 0) {
      n = i1 + hll.b(11, m);
    }
    return n;
  }
  
  public final void a(hll paramhll)
  {
    if ((a & 0x1) != 0) {
      paramhll.a(1, e);
    }
    if ((a & 0x2) != 0) {
      paramhll.a(2, f);
    }
    if ((a & 0x4) != 0) {
      paramhll.a(3, g);
    }
    if ((a & 0x8) != 0) {
      paramhll.a(4, b);
    }
    if ((a & 0x10) != 0) {
      paramhll.a(5, c);
    }
    if ((a & 0x20) != 0) {
      paramhll.a(6, h);
    }
    if ((a & 0x40) != 0) {
      paramhll.a(7, i);
    }
    if ((a & 0x80) != 0) {
      paramhll.a(8, j);
    }
    if ((a & 0x100) != 0) {
      paramhll.a(9, k);
    }
    if ((a & 0x200) != 0) {
      paramhll.a(10, l);
    }
    if ((a & 0x400) != 0) {
      paramhll.a(11, m);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hnd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */