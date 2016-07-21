public final class hre
  extends hln<hre>
{
  public int a = Integer.MIN_VALUE;
  public Integer b = null;
  
  public hre()
  {
    E = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if (a != Integer.MIN_VALUE) {
      i = j + hll.c(1, a);
    }
    j = i;
    if (b != null) {
      j = i + hll.c(2, b.intValue());
    }
    return j;
  }
  
  public final void a(hll paramhll)
  {
    if (a != Integer.MIN_VALUE) {
      paramhll.a(1, a);
    }
    if (b != null) {
      paramhll.a(2, b.intValue());
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hre
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */