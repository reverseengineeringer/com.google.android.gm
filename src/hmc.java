public final class hmc
  extends hln<hmc>
{
  private static volatile hmc[] b;
  public hlz a = null;
  private int c = 0;
  private long d = 0L;
  private String e = "";
  private String f = "";
  
  public hmc()
  {
    q = null;
    E = -1;
  }
  
  public static hmc[] b()
  {
    if (b == null) {}
    synchronized (hlr.c)
    {
      if (b == null) {
        b = new hmc[0];
      }
      return b;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if (a != null) {
      i = j + hll.d(1, a);
    }
    j = i;
    if ((c & 0x1) != 0) {
      j = i + hll.c(2, d);
    }
    i = j;
    if ((c & 0x2) != 0) {
      i = j + hll.b(3, e);
    }
    j = i;
    if ((c & 0x4) != 0) {
      j = i + hll.b(4, f);
    }
    return j;
  }
  
  public final void a(hll paramhll)
  {
    if (a != null) {
      paramhll.b(1, a);
    }
    if ((c & 0x1) != 0) {
      paramhll.a(2, d);
    }
    if ((c & 0x2) != 0) {
      paramhll.a(3, e);
    }
    if ((c & 0x4) != 0) {
      paramhll.a(4, f);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hmc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */