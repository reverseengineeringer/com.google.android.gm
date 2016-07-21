public final class hpa
  extends hln<hpa>
{
  private static volatile hpa[] a;
  private int b = 0;
  private String c = "";
  private String d = "";
  private String e = "";
  private String f = "";
  
  public hpa()
  {
    q = null;
    E = -1;
  }
  
  public static hpa[] b()
  {
    if (a == null) {}
    synchronized (hlr.c)
    {
      if (a == null) {
        a = new hpa[0];
      }
      return a;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((b & 0x1) != 0) {
      i = j + hll.b(1, c);
    }
    j = i;
    if ((b & 0x2) != 0) {
      j = i + hll.b(2, d);
    }
    i = j;
    if ((b & 0x4) != 0) {
      i = j + hll.b(3, e);
    }
    j = i;
    if ((b & 0x8) != 0) {
      j = i + hll.b(4, f);
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
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hpa
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */