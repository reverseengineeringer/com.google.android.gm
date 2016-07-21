public final class gzq
  extends hlt
{
  private static volatile gzq[] e;
  public int a = 0;
  public String b = "";
  public String c = "";
  public int d = 0;
  
  public gzq()
  {
    E = -1;
  }
  
  public static gzq[] b()
  {
    if (e == null) {}
    synchronized (hlr.c)
    {
      if (e == null) {
        e = new gzq[0];
      }
      return e;
    }
  }
  
  protected final int a()
  {
    int j = super.a() + hll.b(1, b);
    int i = j;
    if ((a & 0x1) != 0) {
      i = j + hll.b(2, c);
    }
    j = i;
    if ((a & 0x2) != 0) {
      j = i + hll.c(3, d);
    }
    return j;
  }
  
  public final void a(hll paramhll)
  {
    paramhll.a(1, b);
    if ((a & 0x1) != 0) {
      paramhll.a(2, c);
    }
    if ((a & 0x2) != 0) {
      paramhll.a(3, d);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gzq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */