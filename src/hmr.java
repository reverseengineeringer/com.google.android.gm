public final class hmr
  extends hln<hmr>
{
  private static volatile hmr[] a;
  private int b = 0;
  private int c = 0;
  private String d = "";
  private String e = "";
  private String f = "";
  private String g = "";
  private String h = "";
  private String i = "";
  
  public hmr()
  {
    q = null;
    E = -1;
  }
  
  public static hmr[] b()
  {
    if (a == null) {}
    synchronized (hlr.c)
    {
      if (a == null) {
        a = new hmr[0];
      }
      return a;
    }
  }
  
  protected final int a()
  {
    int k = super.a();
    int j = k;
    if ((b & 0x1) != 0) {
      j = k + hll.c(1, c);
    }
    k = j;
    if ((b & 0x2) != 0) {
      k = j + hll.b(2, d);
    }
    j = k;
    if ((b & 0x4) != 0) {
      j = k + hll.b(3, e);
    }
    k = j;
    if ((b & 0x8) != 0) {
      k = j + hll.b(4, f);
    }
    j = k;
    if ((b & 0x10) != 0) {
      j = k + hll.b(5, g);
    }
    k = j;
    if ((b & 0x20) != 0) {
      k = j + hll.b(6, h);
    }
    j = k;
    if ((b & 0x40) != 0) {
      j = k + hll.b(7, i);
    }
    return j;
  }
  
  public final void a(hll paramhll)
  {
    if ((b & 0x1) != 0) {
      paramhll.a(1, c);
    }
    if ((b & 0x2) != 0) {
      paramhll.a(2, d);
    }
    if ((b & 0x4) != 0) {
      paramhll.a(3, e);
    }
    if ((b & 0x8) != 0) {
      paramhll.a(4, f);
    }
    if ((b & 0x10) != 0) {
      paramhll.a(5, g);
    }
    if ((b & 0x20) != 0) {
      paramhll.a(6, h);
    }
    if ((b & 0x40) != 0) {
      paramhll.a(7, i);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hmr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */