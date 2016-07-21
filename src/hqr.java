public final class hqr
  extends hln<hqr>
{
  public Float a = null;
  public Integer b = null;
  public Integer c = null;
  
  public hqr()
  {
    E = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if (a != null)
    {
      a.floatValue();
      i = j + (hll.b(1) + 4);
    }
    j = i;
    if (b != null) {
      j = i + hll.c(2, b.intValue());
    }
    i = j;
    if (c != null) {
      i = j + hll.c(3, c.intValue());
    }
    return i;
  }
  
  public final void a(hll paramhll)
  {
    if (a != null) {
      paramhll.a(1, a.floatValue());
    }
    if (b != null) {
      paramhll.a(2, b.intValue());
    }
    if (c != null) {
      paramhll.a(3, c.intValue());
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hqr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */