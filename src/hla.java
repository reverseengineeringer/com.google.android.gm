public final class hla
  extends hlt
{
  public int a = 0;
  public String b = "";
  public String c = "";
  public String d = "";
  public long e = 0L;
  
  public hla()
  {
    E = -1;
  }
  
  protected final int a()
  {
    int j = super.a() + hll.b(1, b) + hll.b(2, c);
    int i = j;
    if ((a & 0x1) != 0) {
      i = j + hll.b(3, d);
    }
    j = i;
    if ((a & 0x2) != 0) {
      j = i + hll.c(4, e);
    }
    return j;
  }
  
  public final void a(hll paramhll)
  {
    paramhll.a(1, b);
    paramhll.a(2, c);
    if ((a & 0x1) != 0) {
      paramhll.a(3, d);
    }
    if ((a & 0x2) != 0) {
      paramhll.a(4, e);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hla
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */