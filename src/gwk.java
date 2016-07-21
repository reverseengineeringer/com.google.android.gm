public final class gwk
  extends hlt
{
  public int a = 0;
  public boolean b = true;
  public boolean c = false;
  public boolean d = false;
  public boolean e = false;
  public boolean f = false;
  public boolean g = false;
  public boolean h = false;
  private boolean i = false;
  private boolean j = false;
  
  public gwk()
  {
    E = -1;
  }
  
  protected final int a()
  {
    int m = super.a();
    int k = m;
    if ((a & 0x1) != 0) {
      k = m + (hll.b(1) + 1);
    }
    m = k;
    if ((a & 0x2) != 0) {
      m = k + (hll.b(2) + 1);
    }
    k = m;
    if ((a & 0x4) != 0) {
      k = m + (hll.b(3) + 1);
    }
    m = k;
    if ((a & 0x8) != 0) {
      m = k + (hll.b(4) + 1);
    }
    k = m;
    if ((a & 0x10) != 0) {
      k = m + (hll.b(5) + 1);
    }
    m = k;
    if ((a & 0x20) != 0) {
      m = k + (hll.b(6) + 1);
    }
    k = m;
    if ((a & 0x40) != 0) {
      k = m + (hll.b(7) + 1);
    }
    m = k;
    if ((a & 0x80) != 0) {
      m = k + (hll.b(8) + 1);
    }
    k = m;
    if ((a & 0x100) != 0) {
      k = m + (hll.b(9) + 1);
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
      paramhll.a(5, i);
    }
    if ((a & 0x20) != 0) {
      paramhll.a(6, j);
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
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gwk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */