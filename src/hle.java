public final class hle
  extends hlt
{
  public int a = 0;
  public int b = 1;
  public String c = "";
  public long d = 0L;
  public String e = "";
  public String f = "";
  public boolean g = false;
  private int h = 0;
  
  public hle()
  {
    E = -1;
  }
  
  protected final int a()
  {
    int j = super.a() + hll.c(1, a);
    int i = j;
    if ((h & 0x1) != 0) {
      i = j + hll.c(2, b);
    }
    j = i;
    if ((h & 0x2) != 0) {
      j = i + hll.b(3, c);
    }
    i = j;
    if ((h & 0x8) != 0) {
      i = j + hll.b(4, e);
    }
    j = i;
    if ((h & 0x4) != 0) {
      j = i + hll.c(5, d);
    }
    i = j;
    if ((h & 0x20) != 0) {
      i = j + (hll.b(6) + 1);
    }
    j = i;
    if ((h & 0x10) != 0) {
      j = i + hll.b(7, f);
    }
    return j;
  }
  
  public final void a(hll paramhll)
  {
    paramhll.a(1, a);
    if ((h & 0x1) != 0) {
      paramhll.a(2, b);
    }
    if ((h & 0x2) != 0) {
      paramhll.a(3, c);
    }
    if ((h & 0x8) != 0) {
      paramhll.a(4, e);
    }
    if ((h & 0x4) != 0) {
      paramhll.a(5, d);
    }
    if ((h & 0x20) != 0) {
      paramhll.a(6, g);
    }
    if ((h & 0x10) != 0) {
      paramhll.a(7, f);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */