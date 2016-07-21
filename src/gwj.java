public final class gwj
  extends hlt
{
  public int a = 0;
  public boolean b = false;
  public boolean c = false;
  public boolean d = false;
  public boolean e = false;
  public boolean f = false;
  public boolean g = false;
  public boolean h = false;
  public int i = 0;
  public boolean j = false;
  public boolean k = false;
  public boolean l = false;
  public boolean m = false;
  public boolean n = false;
  
  public gwj()
  {
    E = -1;
  }
  
  protected final int a()
  {
    int i2 = super.a();
    int i1 = i2;
    if ((a & 0x1) != 0) {
      i1 = i2 + (hll.b(1) + 1);
    }
    i2 = i1;
    if ((a & 0x2) != 0) {
      i2 = i1 + (hll.b(2) + 1);
    }
    i1 = i2;
    if ((a & 0x4) != 0) {
      i1 = i2 + (hll.b(3) + 1);
    }
    i2 = i1;
    if ((a & 0x8) != 0) {
      i2 = i1 + (hll.b(4) + 1);
    }
    i1 = i2;
    if ((a & 0x10) != 0) {
      i1 = i2 + (hll.b(5) + 1);
    }
    i2 = i1;
    if ((a & 0x20) != 0) {
      i2 = i1 + (hll.b(6) + 1);
    }
    i1 = i2;
    if ((a & 0x40) != 0) {
      i1 = i2 + (hll.b(7) + 1);
    }
    i2 = i1;
    if ((a & 0x80) != 0) {
      i2 = i1 + hll.c(8, i);
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
      i1 = i2 + (hll.b(11) + 1);
    }
    i2 = i1;
    if ((a & 0x800) != 0) {
      i2 = i1 + (hll.b(12) + 1);
    }
    i1 = i2;
    if ((a & 0x1000) != 0) {
      i1 = i2 + (hll.b(13) + 1);
    }
    return i1;
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
    if ((a & 0x800) != 0) {
      paramhll.a(12, m);
    }
    if ((a & 0x1000) != 0) {
      paramhll.a(13, n);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gwj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */