public final class gwn
  extends hlt
{
  public int a = 0;
  public float b = 0.0F;
  public int c = 0;
  public String d = "";
  public boolean e = false;
  public int f = 1;
  public int g = 2;
  public String h = "";
  public String i = "";
  
  public gwn()
  {
    E = -1;
  }
  
  protected final int a()
  {
    int k = super.a();
    int j = k;
    if ((a & 0x1) != 0) {
      j = k + (hll.b(1) + 4);
    }
    k = j;
    if ((a & 0x2) != 0) {
      k = j + hll.c(2, c);
    }
    j = k;
    if ((a & 0x4) != 0) {
      j = k + hll.b(3, d);
    }
    k = j;
    if ((a & 0x8) != 0) {
      k = j + (hll.b(4) + 1);
    }
    j = k;
    if ((a & 0x10) != 0) {
      j = k + hll.c(5, f);
    }
    k = j;
    if ((a & 0x20) != 0) {
      k = j + hll.c(6, g);
    }
    j = k;
    if ((a & 0x40) != 0) {
      j = k + hll.b(7, h);
    }
    k = j;
    if ((a & 0x80) != 0) {
      k = j + hll.b(8, i);
    }
    return k;
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
    if ((a & 0x80) != 0) {
      paramhll.a(8, i);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gwn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */