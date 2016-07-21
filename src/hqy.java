public final class hqy
  extends hln<hqy>
{
  public hqx a;
  public hrf b;
  public int c = Integer.MIN_VALUE;
  public hqq d;
  
  public hqy()
  {
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
    if (b != null) {
      j = i + hll.d(2, b);
    }
    i = j;
    if (c != Integer.MIN_VALUE) {
      i = j + hll.c(3, c);
    }
    j = i;
    if (d != null) {
      j = i + hll.d(4, d);
    }
    return j;
  }
  
  public final void a(hll paramhll)
  {
    if (a != null) {
      paramhll.b(1, a);
    }
    if (b != null) {
      paramhll.b(2, b);
    }
    if (c != Integer.MIN_VALUE) {
      paramhll.a(3, c);
    }
    if (d != null) {
      paramhll.b(4, d);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hqy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */