public final class hqv
  extends hln<hqv>
{
  public Integer a = null;
  public Integer b = null;
  public Integer c = null;
  public Integer d = null;
  
  public hqv()
  {
    E = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if (a != null) {
      i = j + hll.c(1, a.intValue());
    }
    j = i;
    if (b != null) {
      j = i + hll.c(2, b.intValue());
    }
    i = j;
    if (c != null) {
      i = j + hll.c(3, c.intValue());
    }
    j = i;
    if (d != null) {
      j = i + hll.c(4, d.intValue());
    }
    return j;
  }
  
  public final void a(hll paramhll)
  {
    if (a != null) {
      paramhll.a(1, a.intValue());
    }
    if (b != null) {
      paramhll.a(2, b.intValue());
    }
    if (c != null) {
      paramhll.a(3, c.intValue());
    }
    if (d != null) {
      paramhll.a(4, d.intValue());
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hqv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */