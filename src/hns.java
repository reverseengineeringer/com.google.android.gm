public final class hns
  extends hln<hns>
{
  public hoc a = null;
  public hny b = null;
  public hnt c = null;
  public hnv d = null;
  public hoa e = null;
  private int f = 0;
  private int g = 1;
  
  public hns()
  {
    q = null;
    E = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if (a != null) {
      i = j + hll.d(1, a);
    }
    j = i;
    if ((f & 0x1) != 0) {
      j = i + hll.c(2, g);
    }
    i = j;
    if (b != null) {
      i = j + hll.d(3, b);
    }
    j = i;
    if (c != null) {
      j = i + hll.d(4, c);
    }
    i = j;
    if (d != null) {
      i = j + hll.d(5, d);
    }
    j = i;
    if (e != null) {
      j = i + hll.d(6, e);
    }
    return j;
  }
  
  public final void a(hll paramhll)
  {
    if (a != null) {
      paramhll.b(1, a);
    }
    if ((f & 0x1) != 0) {
      paramhll.a(2, g);
    }
    if (b != null) {
      paramhll.b(3, b);
    }
    if (c != null) {
      paramhll.b(4, c);
    }
    if (d != null) {
      paramhll.b(5, d);
    }
    if (e != null) {
      paramhll.b(6, e);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hns
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */