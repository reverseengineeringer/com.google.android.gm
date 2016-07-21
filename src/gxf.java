public final class gxf
  extends hlt
{
  public int a = 0;
  public boolean b = false;
  public boolean c = false;
  public boolean d = false;
  public boolean e = false;
  public String f = "";
  public int g = 0;
  public gwj h = null;
  public String i = "";
  public String j = "";
  private boolean k = false;
  private int l = 0;
  private String m = "";
  private boolean n = false;
  
  public gxf()
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
      i2 = i1 + hll.c(2, l);
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
      i1 = i2 + hll.b(7, f);
    }
    i2 = i1;
    if ((a & 0x80) != 0) {
      i2 = i1 + hll.c(8, g);
    }
    i1 = i2;
    if ((a & 0x100) != 0) {
      i1 = i2 + hll.b(9, m);
    }
    i2 = i1;
    if ((a & 0x200) != 0) {
      i2 = i1 + (hll.b(10) + 1);
    }
    i1 = i2;
    if (h != null) {
      i1 = i2 + hll.d(11, h);
    }
    i2 = i1;
    if ((a & 0x400) != 0) {
      i2 = i1 + hll.b(12, i);
    }
    i1 = i2;
    if ((a & 0x800) != 0) {
      i1 = i2 + hll.b(13, j);
    }
    return i1;
  }
  
  public final gxf a(int paramInt)
  {
    l = paramInt;
    a |= 0x2;
    return this;
  }
  
  public final gxf a(boolean paramBoolean)
  {
    k = paramBoolean;
    a |= 0x1;
    return this;
  }
  
  public final void a(hll paramhll)
  {
    if ((a & 0x1) != 0) {
      paramhll.a(1, k);
    }
    if ((a & 0x2) != 0) {
      paramhll.a(2, l);
    }
    if ((a & 0x4) != 0) {
      paramhll.a(3, b);
    }
    if ((a & 0x8) != 0) {
      paramhll.a(4, c);
    }
    if ((a & 0x10) != 0) {
      paramhll.a(5, d);
    }
    if ((a & 0x20) != 0) {
      paramhll.a(6, e);
    }
    if ((a & 0x40) != 0) {
      paramhll.a(7, f);
    }
    if ((a & 0x80) != 0) {
      paramhll.a(8, g);
    }
    if ((a & 0x100) != 0) {
      paramhll.a(9, m);
    }
    if ((a & 0x200) != 0) {
      paramhll.a(10, n);
    }
    if (h != null) {
      paramhll.b(11, h);
    }
    if ((a & 0x400) != 0) {
      paramhll.a(12, i);
    }
    if ((a & 0x800) != 0) {
      paramhll.a(13, j);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gxf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */