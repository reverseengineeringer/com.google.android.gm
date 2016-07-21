public final class dop
  extends hlt
{
  public int a = 0;
  public doq[] b = doq.b();
  public String c = "";
  public int d = 0;
  public String e = "";
  public String f = "";
  public int g = 0;
  public int h = 0;
  public int i = 0;
  public boolean j = false;
  public boolean k = false;
  public boolean l = false;
  public int m = 0;
  private long n = 0L;
  private boolean o = false;
  
  public dop()
  {
    E = -1;
  }
  
  protected final int a()
  {
    int i1 = super.a();
    int i2 = i1;
    if (b != null)
    {
      i2 = i1;
      if (b.length > 0)
      {
        int i3 = 0;
        for (;;)
        {
          i2 = i1;
          if (i3 >= b.length) {
            break;
          }
          doq localdoq = b[i3];
          i2 = i1;
          if (localdoq != null) {
            i2 = i1 + hll.d(1, localdoq);
          }
          i3 += 1;
          i1 = i2;
        }
      }
    }
    i1 = i2;
    if ((a & 0x1) != 0) {
      i1 = i2 + hll.b(2, c);
    }
    i2 = i1;
    if ((a & 0x2) != 0) {
      i2 = i1 + hll.c(3, d);
    }
    i1 = i2;
    if ((a & 0x4) != 0) {
      i1 = i2 + hll.b(4, e);
    }
    i2 = i1;
    if ((a & 0x8) != 0) {
      i2 = i1 + hll.b(5, f);
    }
    i1 = i2;
    if ((a & 0x10) != 0) {
      i1 = i2 + hll.c(6, g);
    }
    i2 = i1;
    if ((a & 0x20) != 0) {
      i2 = i1 + hll.c(7, h);
    }
    i1 = i2;
    if ((a & 0x40) != 0) {
      i1 = i2 + hll.c(8, i);
    }
    i2 = i1;
    if ((a & 0x80) != 0) {
      i2 = i1 + (hll.b(9) + 1);
    }
    i1 = i2;
    if ((a & 0x100) != 0) {
      i1 = i2 + hll.c(10, n);
    }
    i2 = i1;
    if ((a & 0x200) != 0) {
      i2 = i1 + (hll.b(11) + 1);
    }
    i1 = i2;
    if ((a & 0x400) != 0) {
      i1 = i2 + (hll.b(12) + 1);
    }
    i2 = i1;
    if ((a & 0x800) != 0) {
      i2 = i1 + (hll.b(13) + 1);
    }
    i1 = i2;
    if ((a & 0x1000) != 0) {
      i1 = i2 + hll.c(14, m);
    }
    return i1;
  }
  
  public final void a(hll paramhll)
  {
    if ((b != null) && (b.length > 0))
    {
      int i1 = 0;
      while (i1 < b.length)
      {
        doq localdoq = b[i1];
        if (localdoq != null) {
          paramhll.b(1, localdoq);
        }
        i1 += 1;
      }
    }
    if ((a & 0x1) != 0) {
      paramhll.a(2, c);
    }
    if ((a & 0x2) != 0) {
      paramhll.a(3, d);
    }
    if ((a & 0x4) != 0) {
      paramhll.a(4, e);
    }
    if ((a & 0x8) != 0) {
      paramhll.a(5, f);
    }
    if ((a & 0x10) != 0) {
      paramhll.a(6, g);
    }
    if ((a & 0x20) != 0) {
      paramhll.a(7, h);
    }
    if ((a & 0x40) != 0) {
      paramhll.a(8, i);
    }
    if ((a & 0x80) != 0) {
      paramhll.a(9, j);
    }
    if ((a & 0x100) != 0) {
      paramhll.a(10, n);
    }
    if ((a & 0x200) != 0) {
      paramhll.a(11, k);
    }
    if ((a & 0x400) != 0) {
      paramhll.a(12, l);
    }
    if ((a & 0x800) != 0) {
      paramhll.a(13, o);
    }
    if ((a & 0x1000) != 0) {
      paramhll.a(14, m);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     dop
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */