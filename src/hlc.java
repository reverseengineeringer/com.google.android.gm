public final class hlc
  extends hlt
{
  public int a = 0;
  public long b = 0L;
  public String c = "";
  public String d = "";
  public int e = 1;
  private int f = 0;
  
  public hlc()
  {
    E = -1;
  }
  
  protected final int a()
  {
    int j = super.a() + hll.c(1, a);
    int i = j;
    if ((f & 0x1) != 0) {
      i = j + hll.c(2, b);
    }
    j = i;
    if ((f & 0x2) != 0) {
      j = i + hll.b(3, c);
    }
    i = j;
    if ((f & 0x4) != 0) {
      i = j + hll.b(4, d);
    }
    j = i;
    if ((f & 0x8) != 0) {
      j = i + hll.c(5, e);
    }
    return j;
  }
  
  public final void a(hll paramhll)
  {
    paramhll.a(1, a);
    if ((f & 0x1) != 0) {
      paramhll.a(2, b);
    }
    if ((f & 0x2) != 0) {
      paramhll.a(3, c);
    }
    if ((f & 0x4) != 0) {
      paramhll.a(4, d);
    }
    if ((f & 0x8) != 0) {
      paramhll.a(5, e);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hlc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */