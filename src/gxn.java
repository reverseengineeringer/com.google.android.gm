public final class gxn
  extends hlt
{
  public int a = 0;
  public int b = 1;
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  public boolean g = false;
  public String h = "";
  public String i = "";
  public int j = 0;
  public String k = "";
  public long l = 0L;
  public int m = 0;
  private int n = 0;
  private String o = "";
  
  public gxn()
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
    if ((a & 0x20) != 0) {
      i2 = i1 + (hll.b(6) + 1);
    }
    i1 = i2;
    if ((a & 0x40) != 0) {
      i1 = i2 + hll.b(7, h);
    }
    i2 = i1;
    if ((a & 0x80) != 0) {
      i2 = i1 + hll.b(8, i);
    }
    i1 = i2;
    if ((a & 0x100) != 0) {
      i1 = i2 + hll.c(9, j);
    }
    i2 = i1;
    if ((a & 0x200) != 0) {
      i2 = i1 + hll.c(10, n);
    }
    i1 = i2;
    if ((a & 0x400) != 0) {
      i1 = i2 + hll.b(11, o);
    }
    i2 = i1;
    if ((a & 0x800) != 0) {
      i2 = i1 + hll.b(12, k);
    }
    i1 = i2;
    if ((a & 0x1000) != 0) {
      i1 = i2 + hll.c(13, l);
    }
    i2 = i1;
    if ((a & 0x2000) != 0) {
      i2 = i1 + hll.c(14, m);
    }
    return i2;
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
      paramhll.a(10, n);
    }
    if ((a & 0x400) != 0) {
      paramhll.a(11, o);
    }
    if ((a & 0x800) != 0) {
      paramhll.a(12, k);
    }
    if ((a & 0x1000) != 0) {
      paramhll.a(13, l);
    }
    if ((a & 0x2000) != 0) {
      paramhll.a(14, m);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gxn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */