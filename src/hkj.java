public final class hkj
  extends hln<hkj>
{
  public int a = 0;
  public int b = 0;
  public int c = 0;
  public String d = "";
  public long e = 0L;
  
  public hkj()
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
      j = i + hll.c(2, c);
    }
    i = j;
    if ((a & 0x4) != 0) {
      i = j + hll.b(3, d);
    }
    j = i;
    if ((a & 0x8) != 0) {
      j = i + (hll.b(4) + 8);
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
      paramhll.b(4, e);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hkj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */