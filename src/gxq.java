public final class gxq
  extends hlt
{
  private static volatile gxq[] f;
  public int a = 0;
  public String b = "";
  public String c = "";
  public String d = "";
  public byte[] e = hlw.h;
  
  public gxq()
  {
    E = -1;
  }
  
  public static gxq[] b()
  {
    if (f == null) {}
    synchronized (hlr.c)
    {
      if (f == null) {
        f = new gxq[0];
      }
      return f;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((a & 0x1) != 0) {
      i = j + hll.b(1, b);
    }
    j = i;
    if ((a & 0x2) != 0) {
      j = i + hll.b(2, c);
    }
    i = j;
    if ((a & 0x4) != 0) {
      i = j + hll.b(3, d);
    }
    j = i;
    if ((a & 0x8) != 0) {
      j = i + hll.b(4, e);
    }
    return j;
  }
  
  public final void a(hll paramhll)
  {
    if ((a & 0x1) != 0) {
      paramhll.a(1, b);
    }
    if ((a & 0x2) != 0) {
      paramhll.a(2, c);
    }
    if ((a & 0x4) != 0) {
      paramhll.a(3, d);
    }
    if ((a & 0x8) != 0) {
      paramhll.a(4, e);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gxq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */