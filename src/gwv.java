public final class gwv
  extends hlt
{
  private static volatile gwv[] m;
  public long a = 0L;
  public int b = 0;
  public long c = 0L;
  public long d = 0L;
  public String e = "";
  public String f = "";
  public String g = "";
  public String h = "";
  public String i = "";
  public String j = "";
  public byte[] k = hlw.h;
  public int l = 0;
  private int n = 0;
  
  public gwv()
  {
    E = -1;
  }
  
  public static gwv[] b()
  {
    if (m == null) {}
    synchronized (hlr.c)
    {
      if (m == null) {
        m = new gwv[0];
      }
      return m;
    }
  }
  
  protected final int a()
  {
    int i2 = super.a();
    int i1 = i2;
    if ((n & 0x1) != 0) {
      i1 = i2 + hll.c(1, a);
    }
    i2 = i1;
    if ((n & 0x2) != 0) {
      i2 = i1 + hll.c(2, b);
    }
    i1 = i2;
    if ((n & 0x4) != 0) {
      i1 = i2 + hll.c(3, c);
    }
    i2 = i1;
    if ((n & 0x8) != 0) {
      i2 = i1 + hll.c(4, d);
    }
    i1 = i2;
    if ((n & 0x10) != 0) {
      i1 = i2 + hll.b(5, e);
    }
    i2 = i1;
    if ((n & 0x20) != 0) {
      i2 = i1 + hll.b(6, f);
    }
    i1 = i2;
    if ((n & 0x40) != 0) {
      i1 = i2 + hll.b(7, g);
    }
    i2 = i1;
    if ((n & 0x80) != 0) {
      i2 = i1 + hll.b(8, h);
    }
    i1 = i2;
    if ((n & 0x100) != 0) {
      i1 = i2 + hll.b(9, i);
    }
    i2 = i1;
    if ((n & 0x200) != 0) {
      i2 = i1 + hll.b(10, j);
    }
    i1 = i2;
    if ((n & 0x400) != 0) {
      i1 = i2 + hll.b(11, k);
    }
    i2 = i1;
    if ((n & 0x800) != 0) {
      i2 = i1 + hll.c(12, l);
    }
    return i2;
  }
  
  public final void a(hll paramhll)
  {
    if ((n & 0x1) != 0) {
      paramhll.a(1, a);
    }
    if ((n & 0x2) != 0) {
      paramhll.a(2, b);
    }
    if ((n & 0x4) != 0) {
      paramhll.a(3, c);
    }
    if ((n & 0x8) != 0) {
      paramhll.a(4, d);
    }
    if ((n & 0x10) != 0) {
      paramhll.a(5, e);
    }
    if ((n & 0x20) != 0) {
      paramhll.a(6, f);
    }
    if ((n & 0x40) != 0) {
      paramhll.a(7, g);
    }
    if ((n & 0x80) != 0) {
      paramhll.a(8, h);
    }
    if ((n & 0x100) != 0) {
      paramhll.a(9, i);
    }
    if ((n & 0x200) != 0) {
      paramhll.a(10, j);
    }
    if ((n & 0x400) != 0) {
      paramhll.a(11, k);
    }
    if ((n & 0x800) != 0) {
      paramhll.a(12, l);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gwv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */