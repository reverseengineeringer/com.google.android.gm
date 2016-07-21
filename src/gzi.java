public final class gzi
  extends hlt
{
  private static volatile gzi[] h;
  public int a = 0;
  public int b = 0;
  public int c = 0;
  public int d = 0;
  public int e = 0;
  public String f = "";
  public int g = 0;
  
  public gzi()
  {
    E = -1;
  }
  
  public static gzi[] b()
  {
    if (h == null) {}
    synchronized (hlr.c)
    {
      if (h == null) {
        h = new gzi[0];
      }
      return h;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((a & 0x1) != 0) {
      i = j + hll.c(1, b);
    }
    j = i;
    if ((a & 0x2) != 0) {
      j = i + hll.c(2, c);
    }
    i = j;
    if ((a & 0x4) != 0) {
      i = j + hll.c(3, d);
    }
    j = i;
    if ((a & 0x8) != 0) {
      j = i + hll.c(4, e);
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
 * Qualified Name:     gzi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */