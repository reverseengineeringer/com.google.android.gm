public final class hqz
  extends hln<hqz>
{
  public int a = Integer.MIN_VALUE;
  
  public hqz()
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
    return i;
  }
  
  public final void a(hll paramhll)
  {
    if (a != Integer.MIN_VALUE) {
      paramhll.a(1, a);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hqz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */