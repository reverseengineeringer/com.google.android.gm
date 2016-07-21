public final class gyv
  extends hlt
{
  private static volatile gyv[] h;
  public int a = 0;
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public int f = 0;
  public int g = 0;
  
  public gyv()
  {
    E = -1;
  }
  
  public static gyv[] b()
  {
    if (h == null) {}
    synchronized (hlr.c)
    {
      if (h == null) {
        h = new gyv[0];
      }
      return h;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((a & 0x1) != 0) {
      i = j + hll.b(1, b);
    }
    j = i;
    if ((a & 0x2) != 0) {
      j = i + hll.b(2, c);
    }
    i = j;
    if ((a & 0x4) != 0) {
      i = j + hll.b(3, d);
    }
    j = i;
    if ((a & 0x8) != 0) {
      j = i + hll.b(4, e);
    }
    i = j;
    if ((a & 0x10) != 0) {
      i = j + hll.c(5, f);
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
 * Qualified Name:     gyv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */