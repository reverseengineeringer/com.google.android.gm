public final class hon
  extends hln<hon>
{
  private int a = 0;
  private int b = 0;
  private double c = 0.0D;
  private double d = 0.0D;
  private long e = 0L;
  private int f = 0;
  private String g = "";
  private String h = "";
  
  public hon()
  {
    q = null;
    E = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((a & 0x1) != 0) {
      i = j + hll.c(1, b);
    }
    j = i;
    if ((a & 0x2) != 0) {
      j = i + (hll.b(2) + 8);
    }
    i = j;
    if ((a & 0x4) != 0) {
      i = j + (hll.b(3) + 8);
    }
    j = i;
    if ((a & 0x8) != 0) {
      j = i + hll.c(4, e);
    }
    i = j;
    if ((a & 0x10) != 0) {
      i = j + hll.c(5, f);
    }
    j = i;
    if ((a & 0x20) != 0) {
      j = i + hll.b(6, g);
    }
    i = j;
    if ((a & 0x40) != 0) {
      i = j + hll.b(7, h);
    }
    return i;
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
    if ((a & 0x10) != 0) {
      paramhll.a(5, f);
    }
    if ((a & 0x20) != 0) {
      paramhll.a(6, g);
    }
    if ((a & 0x40) != 0) {
      paramhll.a(7, h);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hon
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */