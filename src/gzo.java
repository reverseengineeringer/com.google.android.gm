public final class gzo
  extends hlt
{
  private static volatile gzo[] h;
  public int a = 0;
  public boolean b = false;
  public boolean c = false;
  public int d = 0;
  public String e = "";
  public String f = "";
  public int g = 0;
  
  public gzo()
  {
    E = -1;
  }
  
  public static gzo[] b()
  {
    if (h == null) {}
    synchronized (hlr.c)
    {
      if (h == null) {
        h = new gzo[0];
      }
      return h;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((a & 0x1) != 0) {
      i = j + (hll.b(1) + 1);
    }
    j = i;
    if ((a & 0x2) != 0) {
      j = i + (hll.b(2) + 1);
    }
    i = j;
    if ((a & 0x4) != 0) {
      i = j + hll.c(3, d);
    }
    j = i;
    if ((a & 0x8) != 0) {
      j = i + hll.b(4, e);
    }
    i = j;
    if ((a & 0x10) != 0) {
      i = j + hll.b(5, f);
    }
    j = i;
    if ((a & 0x20) != 0) {
      j = i + hll.c(6, g);
    }
    return j;
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
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gzo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */