public final class hmb
  extends hln<hmb>
{
  private static volatile hmb[] b;
  public hlz a = null;
  private int c = 0;
  private String d = "";
  
  public hmb()
  {
    q = null;
    E = -1;
  }
  
  public static hmb[] b()
  {
    if (b == null) {}
    synchronized (hlr.c)
    {
      if (b == null) {
        b = new hmb[0];
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
      j = i + hll.b(2, d);
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
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hmb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */