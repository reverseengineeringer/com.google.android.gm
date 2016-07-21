public final class hni
  extends hln<hni>
{
  private static volatile hni[] c;
  public hnj a = null;
  public hjx b = null;
  private int d = 0;
  private String e = "";
  private int f = 0;
  private long g = 0L;
  private String h = "";
  private long i = 0L;
  
  public hni()
  {
    q = null;
    E = -1;
  }
  
  public static hni[] b()
  {
    if (c == null) {}
    synchronized (hlr.c)
    {
      if (c == null) {
        c = new hni[0];
      }
      return c;
    }
  }
  
  protected final int a()
  {
    int k = super.a();
    int j = k;
    if ((d & 0x1) != 0) {
      j = k + hll.b(1, e);
    }
    k = j;
    if (a != null) {
      k = j + hll.d(2, a);
    }
    j = k;
    if ((d & 0x2) != 0) {
      j = k + hll.c(3, f);
    }
    k = j;
    if ((d & 0x4) != 0) {
      k = j + hll.c(4, g);
    }
    j = k;
    if ((d & 0x8) != 0) {
      j = k + hll.b(5, h);
    }
    k = j;
    if ((d & 0x10) != 0) {
      k = j + hll.c(6, i);
    }
    j = k;
    if (b != null) {
      j = k + hll.d(7, b);
    }
    return j;
  }
  
  public final void a(hll paramhll)
  {
    if ((d & 0x1) != 0) {
      paramhll.a(1, e);
    }
    if (a != null) {
      paramhll.b(2, a);
    }
    if ((d & 0x2) != 0) {
      paramhll.a(3, f);
    }
    if ((d & 0x4) != 0) {
      paramhll.a(4, g);
    }
    if ((d & 0x8) != 0) {
      paramhll.a(5, h);
    }
    if ((d & 0x10) != 0) {
      paramhll.a(6, i);
    }
    if (b != null) {
      paramhll.b(7, b);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hni
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */