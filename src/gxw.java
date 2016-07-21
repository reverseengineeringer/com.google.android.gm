public final class gxw
  extends hlt
{
  private static volatile gxw[] f;
  public int a = 0;
  public long b = 0L;
  public boolean c = false;
  public boolean d = false;
  public int e = 0;
  
  public gxw()
  {
    E = -1;
  }
  
  public static gxw[] b()
  {
    if (f == null) {}
    synchronized (hlr.c)
    {
      if (f == null) {
        f = new gxw[0];
      }
      return f;
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
      j = i + (hll.b(2) + 1);
    }
    i = j;
    if ((a & 0x4) != 0) {
      i = j + (hll.b(3) + 1);
    }
    j = i;
    if ((a & 0x8) != 0) {
      j = i + hll.c(4, e);
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
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gxw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */