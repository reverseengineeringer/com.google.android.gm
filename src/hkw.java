public final class hkw
  extends hlt
{
  public int a = 0;
  public String b = "";
  public int c = 0;
  private String d = "";
  
  public hkw()
  {
    E = -1;
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
 * Qualified Name:     hkw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */