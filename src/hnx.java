public final class hnx
  extends hln<hnx>
{
  private static volatile hnx[] a;
  private int b = 0;
  private String c = "";
  private String d = "";
  
  public hnx()
  {
    q = null;
    E = -1;
  }
  
  public static hnx[] b()
  {
    if (a == null) {}
    synchronized (hlr.c)
    {
      if (a == null) {
        a = new hnx[0];
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
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hnx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */