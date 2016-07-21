public final class gwz
  extends hlt
{
  private static volatile gwz[] e;
  public int a = 0;
  public String b = "";
  public int c = 0;
  public String d = "";
  
  public gwz()
  {
    E = -1;
  }
  
  public static gwz[] b()
  {
    if (e == null) {}
    synchronized (hlr.c)
    {
      if (e == null) {
        e = new gwz[0];
      }
      return e;
    }
  }
  
  protected final int a()
  {
    int j = super.a() + hll.b(1, b);
    int i = j;
    if ((a & 0x1) != 0) {
      i = j + hll.c(2, c);
    }
    j = i;
    if ((a & 0x2) != 0) {
      j = i + hll.b(3, d);
    }
    return j;
  }
  
  public final void a(hll paramhll)
  {
    paramhll.a(1, b);
    if ((a & 0x1) != 0) {
      paramhll.a(2, c);
    }
    if ((a & 0x2) != 0) {
      paramhll.a(3, d);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gwz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */