public final class gzm
  extends hlt
{
  private static volatile gzm[] d;
  public long a = 0L;
  public long b = 0L;
  public long c = 0L;
  private int e = 0;
  
  public gzm()
  {
    E = -1;
  }
  
  public static gzm[] b()
  {
    if (d == null) {}
    synchronized (hlr.c)
    {
      if (d == null) {
        d = new gzm[0];
      }
      return d;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((e & 0x1) != 0) {
      i = j + hll.c(1, a);
    }
    j = i;
    if ((e & 0x2) != 0) {
      j = i + hll.c(2, b);
    }
    i = j;
    if ((e & 0x4) != 0) {
      i = j + hll.c(3, c);
    }
    return i;
  }
  
  public final void a(hll paramhll)
  {
    if ((e & 0x1) != 0) {
      paramhll.a(1, a);
    }
    if ((e & 0x2) != 0) {
      paramhll.a(2, b);
    }
    if ((e & 0x4) != 0) {
      paramhll.a(3, c);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gzm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */