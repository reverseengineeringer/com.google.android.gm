public final class gwq
  extends hlt
{
  private static volatile gwq[] d;
  public int a = 0;
  public String b = "";
  public String c = "";
  
  public gwq()
  {
    E = -1;
  }
  
  public static gwq[] b()
  {
    if (d == null) {}
    synchronized (hlr.c)
    {
      if (d == null) {
        d = new gwq[0];
      }
      return d;
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
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gwq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */