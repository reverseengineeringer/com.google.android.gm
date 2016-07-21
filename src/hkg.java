public final class hkg
  extends hln<hkg>
{
  public int a = 0;
  public hkh b = null;
  public int c = 0;
  public int d = 0;
  public boolean e = false;
  public int f = 0;
  
  public hkg()
  {
    q = null;
    E = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if (b != null) {
      i = j + hll.d(1, b);
    }
    j = i;
    if ((a & 0x1) != 0) {
      j = i + hll.c(2, c);
    }
    i = j;
    if ((a & 0x2) != 0) {
      i = j + hll.c(3, d);
    }
    j = i;
    if ((a & 0x4) != 0) {
      j = i + (hll.b(4) + 1);
    }
    i = j;
    if ((a & 0x8) != 0) {
      i = j + hll.c(5, f);
    }
    return i;
  }
  
  public final void a(hll paramhll)
  {
    if (b != null) {
      paramhll.b(1, b);
    }
    if ((a & 0x1) != 0) {
      paramhll.a(2, c);
    }
    if ((a & 0x2) != 0) {
      paramhll.a(3, d);
    }
    if ((a & 0x4) != 0) {
      paramhll.a(4, e);
    }
    if ((a & 0x8) != 0) {
      paramhll.a(5, f);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hkg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */