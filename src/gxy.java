public final class gxy
  extends hlt
{
  private static volatile gxy[] e;
  public int a = 0;
  public long b = 0L;
  public boolean c = false;
  public boolean d = false;
  
  public gxy()
  {
    E = -1;
  }
  
  public static gxy[] b()
  {
    if (e == null) {}
    synchronized (hlr.c)
    {
      if (e == null) {
        e = new gxy[0];
      }
      return e;
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
    return i;
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
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gxy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */