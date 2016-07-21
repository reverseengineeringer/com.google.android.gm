public final class hmf
  extends hln<hmf>
{
  private static volatile hmf[] c;
  public hlz a = null;
  public hjx b = null;
  private int d = 0;
  private String e = "";
  
  public hmf()
  {
    q = null;
    E = -1;
  }
  
  public static hmf[] b()
  {
    if (c == null) {}
    synchronized (hlr.c)
    {
      if (c == null) {
        c = new hmf[0];
      }
      return c;
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
    if ((d & 0x1) != 0) {
      j = i + hll.b(2, e);
    }
    i = j;
    if (b != null) {
      i = j + hll.d(3, b);
    }
    return i;
  }
  
  public final void a(hll paramhll)
  {
    if (a != null) {
      paramhll.b(1, a);
    }
    if ((d & 0x1) != 0) {
      paramhll.a(2, e);
    }
    if (b != null) {
      paramhll.b(3, b);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hmf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */