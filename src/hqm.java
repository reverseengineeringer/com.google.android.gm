public final class hqm
  extends hln<hqm>
{
  public String a = null;
  public String b = null;
  public int c = Integer.MIN_VALUE;
  public Long d = null;
  
  public hqm()
  {
    E = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if (a != null) {
      i = j + hll.b(1, a);
    }
    j = i;
    if (b != null) {
      j = i + hll.b(2, b);
    }
    i = j;
    if (c != Integer.MIN_VALUE) {
      i = j + hll.c(3, c);
    }
    j = i;
    if (d != null) {
      j = i + hll.c(4, d.longValue());
    }
    return j;
  }
  
  public final void a(hll paramhll)
  {
    if (a != null) {
      paramhll.a(1, a);
    }
    if (b != null) {
      paramhll.a(2, b);
    }
    if (c != Integer.MIN_VALUE) {
      paramhll.a(3, c);
    }
    if (d != null) {
      paramhll.a(4, d.longValue());
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hqm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */