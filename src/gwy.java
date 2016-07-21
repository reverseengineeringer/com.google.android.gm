public final class gwy
  extends hlt
{
  private static volatile gwy[] a;
  private int b = 0;
  private int c = 0;
  private String d = "";
  
  public gwy()
  {
    E = -1;
  }
  
  public static gwy[] b()
  {
    if (a == null) {}
    synchronized (hlr.c)
    {
      if (a == null) {
        a = new gwy[0];
      }
      return a;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((b & 0x1) != 0) {
      i = j + hll.c(1, c);
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
 * Qualified Name:     gwy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */