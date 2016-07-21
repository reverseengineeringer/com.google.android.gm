public final class gyz
  extends hlt
{
  public int a = 0;
  public int b = 0;
  public int c = 0;
  public boolean d = false;
  public boolean e = false;
  public String f = "";
  public int g = 0;
  public boolean h = false;
  public boolean i = false;
  
  public gyz()
  {
    E = -1;
  }
  
  protected final int a()
  {
    int k = super.a();
    int j = k;
    if ((a & 0x1) != 0) {
      j = k + hll.c(1, b);
    }
    k = j;
    if ((a & 0x2) != 0) {
      k = j + hll.c(2, c);
    }
    j = k;
    if ((a & 0x4) != 0) {
      j = k + (hll.b(3) + 1);
    }
    k = j;
    if ((a & 0x8) != 0) {
      k = j + (hll.b(4) + 1);
    }
    j = k;
    if ((a & 0x10) != 0) {
      j = k + hll.b(5, f);
    }
    k = j;
    if ((a & 0x20) != 0) {
      k = j + hll.c(6, g);
    }
    j = k;
    if ((a & 0x40) != 0) {
      j = k + (hll.b(7) + 1);
    }
    k = j;
    if ((a & 0x80) != 0) {
      k = j + (hll.b(8) + 1);
    }
    return k;
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
 * Qualified Name:     gyz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */