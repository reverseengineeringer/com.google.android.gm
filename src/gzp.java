public final class gzp
  extends hlt
{
  private static volatile gzp[] a;
  private int b = 0;
  private String c = "";
  private float d = 0.0F;
  private String e = "";
  
  public gzp()
  {
    E = -1;
  }
  
  public static gzp[] b()
  {
    if (a == null) {}
    synchronized (hlr.c)
    {
      if (a == null) {
        a = new gzp[0];
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
      j = i + (hll.b(2) + 4);
    }
    i = j;
    if ((b & 0x4) != 0) {
      i = j + hll.b(3, e);
    }
    return i;
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
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gzp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */